package com.pghomes.pgowner;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pghomes.openuser.PGDAO;

/**
 * Servlet implementation class GetLocalityList
 */
public class GetLocalityList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetLocalityList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> cityNames = new ArrayList<String>();
		if(request.getParameter("cityName") != "--select--"){
			cityNames.add(request.getParameter("cityName"));
		}
		ArrayList<String> locList = PGDAO.getLocalityList(cityNames);
		PrintWriter out = response.getWriter();
		out.print("<select name='pg_location'>");
		out.print("<option>--select--</option>");
		for(int i =0; i < locList.size(); i++){
			out.print("<option>"+locList.get(i)+"</option>");
		}
		out.print("</select>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
