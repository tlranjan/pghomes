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
 * Servlet implementation class DeleteRoom
 */
public class DeleteRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRoom() {
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
		String pgid_to_delete = request.getParameter("pgid_to_delete");
		String roomid_to_delete = request.getParameter("roomid_to_delete");
		Connection con = null;
		Statement stmt = null;
		try {
			con = DBConnection.getDBConnection();
			stmt = con.createStatement();
			String roomSql = "DELETE FROM room WHERE ROOMID="+roomid_to_delete+" AND ROOMPGID="+pgid_to_delete;
			stmt.executeUpdate(roomSql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con, stmt);
		}
		request.setAttribute("successMessage", "Selected Room Deleted from the PG!!");
		request.getRequestDispatcher("customers.jsp?id=successMessage").forward(request, response);
	}

}
