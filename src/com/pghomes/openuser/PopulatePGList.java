package com.pghomes.openuser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PopulatePGList
 */
public class PopulatePGList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopulatePGList() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String[] cities = request.getParameterValues("cities");
		String[] localities = request.getParameterValues("localities");
		String[] rentranges = request.getParameterValues("rentranges");
		String[] shareTypes = request.getParameterValues("shareTypes");
		String pgListPageNo = request.getParameter("searchPageNo");
		String[] gender = request.getParameterValues("gender");
		ArrayList<String> genders = new ArrayList<String>();
		if(gender != null){
			for(String s : gender){
				genders.add(s.toString());
			}
		}
		ArrayList<String> cityNames = new ArrayList<String>();
		if(cities != null){
			for(String s : cities){
				cityNames.add(s.toString());
			}
		}
		ArrayList<String> locations = new ArrayList<String>();
		if(localities != null){
			for(String s : localities){
				locations.add(s.toString());
			}	
		}
		ArrayList<String> rents = new ArrayList<String>();
		if(rentranges != null){
			for(String s : rentranges){
				rents.add(s.toString());
			}	
		}
		ArrayList<String> sharingTypes = new ArrayList<String>();
		if(shareTypes != null){
			for(String s : shareTypes){
				sharingTypes.add(s.toString());
			}	
		}
		List<ArrayList<String>> searchedPGList = PGDAO.getPGList(cityNames, locations, sharingTypes, rents, genders, Integer.parseInt(pgListPageNo));
		out.print("<table height='610'>");
		for(int i=0; i < searchedPGList.size(); i++){
			out.print("<tr height='30'><td>");
			out.print("<table>");
			out.print("<tr><td style='text-align: justify'>");
			out.print("<b><a href='home.jsp?id=moreinfo&infoPGId="+searchedPGList.get(i).get(7)+"' target='_blank'>"+searchedPGList.get(i).get(0)+"</a></b>&nbsp;"+searchedPGList.get(i).get(1)+",&nbsp;"+searchedPGList.get(i).get(6)+"<br/>");
			out.print("<b>Description:</b>&nbsp;"+searchedPGList.get(i).get(5)+",&nbsp;"+searchedPGList.get(i).get(4)+",&nbsp;"+searchedPGList.get(i).get(6)+"<br/>");
			out.print("<b>Contacts:</b>&nbsp;"+searchedPGList.get(i).get(2)+",&nbsp;"+searchedPGList.get(i).get(3)+"<br/>");
			out.print("<a href='home.jsp?id=moreinfo&infoPGId="+searchedPGList.get(i).get(7)+"' target='_blank'>More Info</a>&nbsp;&nbsp;<a href='home.jsp?id=pgbooking'>Booking</a>");
			out.print("</td></tr>");
			out.print("</table>");
			out.print("</td></tr>");
		}
			out.print("<tr><td></td></tr>");
			out.print("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
