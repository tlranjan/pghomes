package com.pghomes.pgowner;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pghomes.dbconnection.DBConnection;

/**
 * Servlet implementation class AuthenticateOwner
 */
public class AuthenticateOwner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticateOwner() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("user_owner");
		String password = request.getParameter("password_owner");
		Integer ownerId = null;
		String ownerName = null;
		RequestDispatcher rdHome = request.getRequestDispatcher("customers.jsp?id=viewpg");
		Connection con = null;
		Statement stmt = null;
		String paid_member = null;
		try {
			con = DBConnection.getDBConnection();
			stmt = con.createStatement();
			String sql = "SELECT OWNERMAILID, PASSWORD, OWNERID, OWNERNAME, OWNERPAIDMEMBER FROM owner";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String db_user = rs.getString("OWNERMAILID");
				String db_pass = rs.getString("PASSWORD");
				if(username.equals(db_user) && password.equals(db_pass)){
					paid_member = rs.getString("OWNERPAIDMEMBER");
					if(paid_member.equalsIgnoreCase("Yes")) {
						ownerId = rs.getInt("OWNERID");
						ownerName = rs.getString("OWNERNAME");
						HttpSession session = request.getSession();
						session.setAttribute("ownerId", ownerId.toString());
						session.setAttribute("ownerName", ownerName);
					} else {
						DBConnection.closeConnection(con, stmt);
						request.setAttribute("successMessage", "You are not a paid member please contact our customer care!");
						request.getRequestDispatcher("customers.jsp?id=successMessage").forward(request, response);
						return;
					}
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con, stmt);
		}
		rdHome.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
