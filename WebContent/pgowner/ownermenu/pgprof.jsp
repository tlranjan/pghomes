<%@page import="java.util.ArrayList"%>
<%@page import="com.pghomes.pgowner.ManagePG"%>
<%@page import="java.util.Iterator"%>
<%
String ownerId = (String)session.getAttribute("ownerId");
ArrayList<ArrayList<String>> pgList = ManagePG.getPGList(Integer.parseInt(ownerId));
Iterator<ArrayList<String>> it = pgList.iterator();
int count = 0;
%><h3>Your PG Details:</h3>
<table height="560">
<% while(it.hasNext()) {
count ++;
%>
<tr height="100"><td valign="top"><b><%=count %>.</b></td><td valign="top">
<% 
ArrayList<String> pgRow = it.next();
%>
<b>PG Name</b>:&nbsp;<%=pgRow.get(1) %><br/>
<b>Location</b>:&nbsp;<%=pgRow.get(2) %><br/>
<b>Phone</b>:&nbsp;<%=pgRow.get(3) %><br/>
<b>Other Contacts</b>:&nbsp;<%=pgRow.get(4) %><br/>
<b>Address</b>:&nbsp;<%=pgRow.get(5) %><br/>
<b>Details</b>:&nbsp;<%=pgRow.get(6) %><br/>
<b>City Name</b>:&nbsp;<%=pgRow.get(7) %><br/><br/>
</td></tr>
<% } %>
<tr><td></td><td></td></tr>
</table>