package com.pghomes.pgowner;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pghomes.dbconnection.DBConnection;

/**
 * Servlet implementation class DeletePG
 */
public class DeletePG extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePG() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer pgid_to_delete = Integer.parseInt(request.getParameter("pgid_to_delete"));
		Connection con = null;
		Statement stmt = null;
		try {
			con = DBConnection.getDBConnection();
			stmt = con.createStatement();
			String roomSql = "DELETE FROM room WHERE ROOMPGID="+pgid_to_delete;
			stmt.executeUpdate(roomSql);
			String pgSql = "DELETE FROM pg WHERE PGID="+pgid_to_delete;
			stmt.executeUpdate(pgSql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con, stmt);
		}
		request.setAttribute("successMessage", "Selected PG Deleted!!");
		request.getRequestDispatcher("customers.jsp?id=successMessage").forward(request, response);
	}

}
