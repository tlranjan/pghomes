package com.pghomes.pgowner;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PopulateRooms
 */
public class PopulateRooms extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopulateRooms() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Integer ownerId = Integer.parseInt(request.getParameter("ownerId"));
		Integer pgId = Integer.parseInt(request.getParameter("pgId"));
		List<ArrayList<String>> roomList = ManageRoom.getRoomList(ownerId, pgId);
		Iterator<ArrayList<String>> itList = roomList.iterator();
		out.print("<table>");
		int count = 0;
		while(itList.hasNext()){
			count++;
			ArrayList<String> allRooms = itList.next();
			out.print("<tr valign='top' height='100'><td><b>"+count+".</b></td><td>");
			out.print("<b>Room Number</b>:&nbsp;"+allRooms.get(1)+"<br/>");
			out.print("<b>Floor No.</b>:&nbsp;"+allRooms.get(2)+"<br/>");
			out.print("<b>Sharing Type</b>:&nbsp;"+allRooms.get(3)+"<br/>");
			out.print("<b>No. of Empty Beds</b>:&nbsp;"+allRooms.get(4)+"<br/>");
			out.print("</td></tr>");
		}
		out.print("<tr><td></td><td></td></tr></table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
