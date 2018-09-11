<%@page import="java.util.ArrayList"%>
<%@page import="com.pghomes.pgowner.ManageRoom"%>
<%
Integer ownerId = Integer.parseInt((String)session.getAttribute("ownerId"));
ArrayList<ArrayList<String>> pgList = ManageRoom.getPGList(ownerId);
%>
<table height="600">
<tr valign="top" height="50"><td><b>Please select a PG</b>&nbsp;
<select onchange="getRoomDetails(this.value,<%=ownerId %>);">
<option value="0">--select--</option>
<%
for(int i = 0; i < pgList.size(); i++) {
	%><option value="<%=pgList.get(i).get(0) %>"><%=pgList.get(i).get(1) %></option><%
}
%>
</select>
</td></tr>
<tr height="50"><td><h3>Rooms Details Under Selected PG:</h3></td></tr>
<tr valign="top"><td><div id="getRoomDetails"></div></td></tr>
</table>