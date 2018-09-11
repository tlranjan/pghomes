package com.pghomes.pgowner;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PopulateGuest
 */
public class PopulateGuest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopulateGuest() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ownerId = Integer.parseInt(request.getParameter("ownerId"));
		int pgId = Integer.parseInt(request.getParameter("pgId"));
		Boolean onlyDueGuest = Boolean.parseBoolean(request.getParameter("onlyDueGuest"));
		String editInputGuestId = request.getParameter("editInputGuestId");
		ArrayList<ArrayList<String>> guestInfos = ManageGuest.getGuestInfo(ownerId, pgId, onlyDueGuest);
		PrintWriter out = response.getWriter();
		out.print("<table height=\"530\" border=\"1\">");
		out.print("<tr height=\"5\"><th>Name/Room</th><th>Rent</th><th>Paid Upto</th><th>2nd Prev Month</th><th>Previous Month</th><th>Current Month</th><th>Total Due</th><th>Due Date</th><th></th></tr>");
		for(int i=0; i < guestInfos.size(); i++) {
			String guestId = guestInfos.get(i).get(0);
			String guestName = guestInfos.get(i).get(1);
			String paid_upto = guestInfos.get(i).get(5);
			String due_date = guestInfos.get(i).get(6);
			int rent = Integer.parseInt(guestInfos.get(i).get(17));
			int prev_prev_month = Integer.parseInt(guestInfos.get(i).get(18));
			int prev_month = Integer.parseInt(guestInfos.get(i).get(19));
			int curr_month = Integer.parseInt(guestInfos.get(i).get(20));
			int total_due = (rent*3) - (prev_prev_month + prev_month + curr_month);
			String tr_colour = "#FFFFFF";
			if(total_due > 0) {
				tr_colour = "red";
			}
			if(!editInputGuestId.equals("0") && editInputGuestId.equals(guestId)) {
				out.print("<form action=\"UpdateGuest\"><tr height=\"5\" bgcolor=\""+tr_colour+"\"><td>"+guestName+"</td><td>"+rent+"</td><td><input type=\"text\" name=\"paid_upto\" value=\""+paid_upto+"\" style=\"width:50px;\" id=\"datepicker\" /></td><td><input type=\"text\" name=\"prev_prev_month\" value=\""+prev_prev_month+"\" style=\"width:50px;\" /></td><td><input type=\"text\" name=\"prev_month\" value=\""+prev_month+"\" style=\"width:50px;\" /></td><td><input type=\"text\" name=\"curr_month\" value=\""+curr_month+"\" style=\"width:50px;\" /></td><td>"+total_due+"</td><td><input type=\"text\" name=\"due_date\" value=\""+due_date+"\" style=\"width:50px;\" id=\"datepicker\" /></td><td><input type=\"hidden\" name=\"ownerId\" value=\""+ownerId+"\" /><input type=\"hidden\" name=\"pgId\" value=\""+pgId+"\" /><input type=\"hidden\" name=\"editInputGuestId\" value=\""+editInputGuestId+"\" /><input type=\"hidden\" name=\"onlyDueGuest\" value=\"true\" /><input type=\"submit\" value=\"Update\" /></td></tr></form>");
			} else {
				out.print("<tr height=\"5\" bgcolor=\""+tr_colour+"\"><td>"+guestName+"</td><td>"+rent+"</td><td>"+paid_upto+"</td><td>"+prev_prev_month+"</td><td>"+prev_month+"</td><td>"+curr_month+"</td><td>"+total_due+"</td><td>"+due_date+"</td><td><input type=\"button\" value=\"Edit\" onclick=\"getGuestDetails("+ownerId+", "+pgId+", "+guestId+", "+onlyDueGuest+");\"/></td></tr>");
				
			}
		}
		out.print("<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
		out.print("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
