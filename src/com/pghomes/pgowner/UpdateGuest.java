package com.pghomes.pgowner;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pghomes.dbconnection.DBConnection;

/**
 * Servlet implementation class UpdateGuest
 */
public class UpdateGuest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateGuest() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ownerId = request.getParameter("ownerId");
		String pgId = request.getParameter("pgId");
		String editInputGuestId = request.getParameter("editInputGuestId");
		String onlyDueGuest = request.getParameter("onlyDueGuest");
		System.out.println("ownerId="+ownerId+" pgId="+pgId+" guestId="+editInputGuestId+" onlyDueGuest="+onlyDueGuest);
		
		String paid_upto = request.getParameter("paid_upto");
		String prev_prev_month = request.getParameter("prev_prev_month");
		String prev_month = request.getParameter("prev_month");
		String curr_month = request.getParameter("curr_month");
		String due_date = request.getParameter("due_date");
		
		Connection con = null;
		Statement stmt = null;
		try {
			con = DBConnection.getDBConnection();
			stmt = con.createStatement();
			String sql = "UPDATE guest SET PAID_UPTO='"+paid_upto+"', PREVPREVMONTH="+prev_prev_month+", PREVIOUSMONTH="+prev_month+", CURRENTMONTH="+curr_month+", DUE_DATE='"+due_date+"' WHERE GUESTID='"+editInputGuestId+"'";
			stmt.executeUpdate(sql);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con, stmt);
		}
		RequestDispatcher rd = request.getRequestDispatcher("customers.jsp?id=successMessage");
		request.setAttribute("successMessage", "Guest updated successfully!");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
