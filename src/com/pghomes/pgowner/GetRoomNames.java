package com.pghomes.pgowner;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pghomes.dbconnection.DBConnection;

/**
 * Servlet implementation class GetRoomNames
 */
public class GetRoomNames extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRoomNames() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer pgId = Integer.parseInt(request.getParameter("pgId"));
		PrintWriter out = response.getWriter();
		Connection con = null;
		Statement stmt = null;
		try {
			con = DBConnection.getDBConnection();
			stmt = con.createStatement();
			String sql = "SELECT ROOMID, ROOMNAME FROM room WHERE ROOMPGID="+pgId;
			ResultSet rs = stmt.executeQuery(sql);
			out.print("<b>Please a select Room to Delete</b>&nbsp;");
			out.print("<select name='roomid_to_delete'>");
			out.print("<option value='0'>--select--</option>");
			while(rs.next()) {
				out.print("<option value="+rs.getInt("ROOMID")+">"+rs.getString("ROOMNAME")+"</option>");
			}
			out.print("</select>");
			out.print("<input type='submit' value='Delete' onclick=\"return confirm('Are you sure you want to delete this Room?');\" />");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con, stmt);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
