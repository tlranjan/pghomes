<%@page import="com.pghomes.pgowner.ManagePG"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<ArrayList<String>> pgDetails = ManagePG.getPGDetails(Integer.parseInt((String)session.getAttribute("ownerId"))); %>
<table height="600">
<tr><td valign="top"><h3>Your PG Details:</h3><table>
<% for(int i=0; i < pgDetails.size(); i++) { %>
<tr height="50"><td valign="top"><%=i+1 %>.</td><td><b>PG Name:&nbsp;</b><%=pgDetails.get(i).get(0) %><br/><b>Total Rooms:&nbsp;</b><%=pgDetails.get(i).get(1) %><br/><b>Total Beds:&nbsp;</b><%=pgDetails.get(i).get(2) %><br/><b>Total Empty Beds:&nbsp;</b><%=pgDetails.get(i).get(3) %><br/><b>Total Guests:&nbsp;</b><%=pgDetails.get(i).get(4) %><br/><br/></td></tr>
<% } %><tr><td></td></tr></table>
</td></tr>
</table>