package com.pghomes.pgowner;

import java.io.IOException;
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
 * Servlet implementation class AddPG
 */
public class AddPG extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPG() {
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
		int ownerId = Integer.parseInt((String) request.getSession().getAttribute("ownerId"));
		String pg_name = request.getParameter("pg_name");
		String pg_city = request.getParameter("pg_city");
		String pg_location = request.getParameter("pg_location");
		String pg_type = request.getParameter("pg_type");
		String pg_phone = request.getParameter("pg_phone");
		String other_contacts = request.getParameter("other_contacts");
		String pg_address = request.getParameter("pg_address");
		String pg_details = request.getParameter("pg_details");
		String other_location = request.getParameter("other_location");
		String pgName = null;
		Connection con = null;
		Statement stmt = null;
		try{
			con = DBConnection.getDBConnection();
			stmt = con.createStatement();
			String pgSql = "SELECT PGNAME FROM pg where PGOWNERID="+ownerId;
			ResultSet rs = stmt.executeQuery(pgSql);
			while(rs.next()){
				pgName = rs.getString("PGNAME").trim();
			}
			if(pg_location.equalsIgnoreCase("--select--") && other_location.equals("")) {
				DBConnection.closeConnection(con, stmt);
				request.setAttribute("successMessage", "Please select a location or add other location while adding PG.");
				request.getRequestDispatcher("customers.jsp?id=successMessage").forward(request, response);
				return;
			}
			if(!pg_location.equalsIgnoreCase("--select--") && !other_location.equals("")) {
				DBConnection.closeConnection(con, stmt);
				request.setAttribute("successMessage", "Please select either a location or add other location while adding PG.");
				request.getRequestDispatcher("customers.jsp?id=successMessage").forward(request, response);
				return;
			}
			if(pg_location.equalsIgnoreCase("--select--") && !other_location.equals("")) {
				pg_location = other_location;
			}
			if(!pg_name.equalsIgnoreCase(pgName)){
				String sql = "INSERT INTO pg (PGNAME, PGCITYNAME, PGLOCATION, PGTYPE, PGPHONE, PGOTHERCONTACTS, PGADDRESS, PGDETAILS, PGOWNERID) VALUES ('"+pg_name+"','"+pg_city+"','"+pg_location+"','"+pg_type+"','"+pg_phone+"','"+other_contacts+"','"+pg_address+"','"+pg_details+"',"+ownerId+")";
				stmt.executeUpdate(sql);
			}
			if(!other_location.equals("")){
				String locSql = "INSERT INTO localitylist (LOCALITYNAME, CITYNAME) VALUES ('"+other_location+"', '"+pg_city+"')";
				stmt.executeUpdate(locSql);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.closeConnection(con, stmt);
		}
		if(pg_name.equalsIgnoreCase(pgName)){
			request.setAttribute("successMessage", "The PG Name you entered is allready exist in your acount.");
			request.getRequestDispatcher("customers.jsp?id=successMessage").forward(request, response);
			return;
		}
		request.setAttribute("successMessage", "You have successfuly added PG in your acount!");
		request.getRequestDispatcher("customers.jsp?id=successMessage").forward(request, response);
	}

}
