<%@page import="java.util.ArrayList"%>
<%@page import="com.pghomes.pgowner.ManageRoom"%>
<%@page import="com.pghomes.openuser.PGDAO"%>
<%
Integer ownerId = Integer.parseInt((String)session.getAttribute("ownerId"));
ArrayList<ArrayList<String>> pgList = ManageRoom.getPGList(ownerId);
ArrayList<String> shareList =  PGDAO.getAllSharingList();
%>
<table height="600"><tr height="300"><td>
<form action="AddRooms" method="post" name="addRooms">
<h3>Add Rooms to your PG</h3>
<table>
<tr><td align="right">Select a PG</td><td>:</td><td><select name="pg_name"><option value="0">--select--</option><% for(int i = 0; i < pgList.size(); i++) {	%><option><%=pgList.get(i).get(1) %></option><% } %></select></td></tr>
<tr><td align="right">Room Name/No.</td><td>:</td><td><input type="text" name="room_name"/></td></tr>
<tr><td align="right">Room Floor No.</td><td>:</td><td><input type="text" name="room_which_floor"/></td></tr>
<tr><td align="right">Room Sharing</td><td>:</td><td><select name="sharing_type"><% for(int i=0; i < shareList.size(); i++){ %><option><%= shareList.get(i) %></option><%} %></select></td></tr>
<tr><td align="right">Rent Per Bed</td><td>:</td><td><input type="text" name="room_rent"/></td></tr>
<tr><td></td><td></td><td><input type="submit" value="Submit" onclick="return validateRooms();"/></td></tr>
</table>
</form>
</td></tr>
<tr><td></td></tr>
</table>