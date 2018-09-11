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

import com.pghomes.dbconnection.DBConnection;

/**
 * Servlet implementation class RegisterOwner
 */
public class RegisterOwner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterOwner() {
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
		String owner_name = request.getParameter("owner_name");
		String owner_gender = request.getParameter("owner_gender");
		String perma_add = request.getParameter("perma_add");
		String present_add = request.getParameter("present_add");
		String phone = request.getParameter("phone");
		String other_contact = request.getParameter("other_contact");
		String mail_id = request.getParameter("mail_id");
		String password_owner = request.getParameter("password_owner");
		Connection con = null;
		Statement stmt = null;
		try{
			con = DBConnection.getDBConnection();
			stmt = con.createStatement();
			String allUser = "SELECT OWNERMAILID FROM owner";
			ResultSet rs = stmt.executeQuery(allUser);
			while(rs.next()) {
				String userMail = rs.getString("OWNERMAILID");
				if(userMail.equalsIgnoreCase(mail_id)) {
					DBConnection.closeConnection(con, stmt);
					request.setAttribute("successMessage", "The Mail Id you are using is all ready in use, Please use another one!");
					request.getRequestDispatcher("customers.jsp?id=successMessage").forward(request, response);
					return;
				}
			}
			String sql = "INSERT INTO owner (OWNERNAME, OWNERGENDER, OWNERPAIDMEMBER, OWNERPARAMADDRESS, OWNERCROSSADDRESS, OWNERPHONENUMBER, OWNEROTHERCONTACTS, OWNERMAILID, PASSWORD) VALUES ('"+owner_name+"','"+owner_gender+"','No','"+perma_add+"','"+present_add+"','"+phone+"','"+other_contact+"','"+mail_id+"','"+password_owner+"')";
			stmt.executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.closeConnection(con, stmt);
		}
		RequestDispatcher rdOwnerReg = request.getRequestDispatcher("customers.jsp?id=successMessage");
		request.setAttribute("successMessage", "Your registration got successful. Please contact us to activate your account.");
		rdOwnerReg.forward(request, response);
	}
}
