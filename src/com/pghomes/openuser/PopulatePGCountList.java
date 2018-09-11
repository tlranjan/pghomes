package com.pghomes.openuser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PopulatePGCountList
 */
public class PopulatePGCountList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopulatePGCountList() {
        super();
        // TODO Auto-generated constructor stub
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
		String pageNo = request.getParameter("searchPageNo");
		String[] gender = request.getParameterValues("gender");
		ArrayList<String> genders = new ArrayList<String>();
		if(gender != null){
			for(String s : gender){
				genders.add(s.toString());
			}
		}
		if(pageNo == null){
			pageNo = "1";
		}
		int displayedPgae = Integer.parseInt(pageNo);
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
		int pgCount = PGDAO.getPGListCount(cityNames, locations, sharingTypes, rents, genders);
		int totalPage = pgCount/9;
		int counterStart = ((displayedPgae-1)*9)+1;
		int counterEnd = counterStart + 8;
		if(pgCount <= counterEnd){
			counterEnd = pgCount;
		}
		out.print("<b>Showing results&nbsp;</b>"+counterStart+"-"+counterEnd+"&nbsp;of&nbsp;"+pgCount);
		for(int i = 0; i <= totalPage; i++){
			int x = i+1;
			out.print("&nbsp;<a href='#' onclick='getPGList("+x+");getPGCountList("+x+");'>"+x+"</a>");
		}
		
		out.print("");
		out.print("");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
