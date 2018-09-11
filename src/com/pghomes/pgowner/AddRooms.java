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
 * Servlet implementation class AddRooms
 */
public class AddRooms extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRooms() {
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
		String room_name = request.getParameter("room_name");
		String room_which_floor = request.getParameter("room_which_floor");
		String sharing_type = request.getParameter("sharing_type");
		String room_rent = request.getParameter("room_rent");
		int empty_beds = 0;
		if(sharing_type.equalsIgnoreCase("SingleBedroom")) {
			empty_beds = 1;
		}
		if(sharing_type.equalsIgnoreCase("TwoSharing")) {
			empty_beds = 2;
		}
		if(sharing_type.equalsIgnoreCase("ThreeSharing")) {
			empty_beds = 3;
		}
		if(sharing_type.equalsIgnoreCase("FourSharing")) {
			empty_beds = 4;
		}
		if(sharing_type.equalsIgnoreCase("DoubleDecker")) {
			empty_beds = 6;
		}
		if(sharing_type.equalsIgnoreCase("Doormetory")) {
			empty_beds = 8;
		}
		int pg_id = 0;
		Connection con = null;
		Statement stmt = null;
		try{
			con = DBConnection.getDBConnection();
			stmt = con.createStatement();
			String pgNameSql = "SELECT PGID FROM pg WHERE PGOWNERID="+ownerId+" AND PGNAME='"+pg_name+"'";
			ResultSet rs = stmt.executeQuery(pgNameSql);
			while(rs.next()) {
				pg_id = rs.getInt("PGID");
			}
			if(pg_id != 0){
				String sql = "INSERT INTO room (ROOMNAME, ROOMWHICHFLOOR, ROOMSHARINGTYPE, EMPTYBEDS, ROOMPGID, RENTPERBED) VALUES ('"+room_name+"','"+room_which_floor+"','"+sharing_type+"',"+empty_beds+","+pg_id+","+room_rent+")";
				stmt.executeUpdate(sql);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.closeConnection(con, stmt);
		}
		if(pg_id == 0) {
			request.setAttribute("successMessage", "Room was not added to the PG for some error, Please try again.");
			request.getRequestDispatcher("customers.jsp?id=successMessage").forward(request, response);
			return;
		}
		request.setAttribute("successMessage", "Room successfuly added to PG "+pg_name);
		request.getRequestDispatcher("customers.jsp?id=successMessage").forward(request, response);
	}

}
