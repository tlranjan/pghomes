package com.pghomes.openuser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PopulateLocality
 */
public class PopulateLocality extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopulateLocality() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String[] cities = request.getParameterValues("cities");
		ArrayList<String> cityList = new ArrayList<String>();
		if(cities != null){
			for(String s : cities){
				cityList.add(s.toString());
			}
		}
		ArrayList<String> localityList =  PGDAO.getLocalityList(cityList);
		out.print("<form id='formLocality'>");
		out.print("<table height='146'>");
		for(int i=0; i < localityList.size(); i++){
			out.print("<tr valign='top'><td><input type='checkbox' value="+localityList.get(i)+" name='localities' onclick='getPGList(1);getSearchParams();getPGCountList(1);'/>"+localityList.get(i)+"</td></tr>");
		}
		out.print("</table>");
		out.print("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
