<%@page import="com.pghomes.openuser.PGDAO"%>
<%@page import="java.util.ArrayList"%>
<%
ArrayList<String> allLocalityList =  PGDAO.getAllLocalityList();
%>
<div id="loadLocalities">
<form id="formLocality">
<table height="146">
<% for(int i=0; i < allLocalityList.size(); i++){ %>
<tr valign="top"><td><input type="checkbox" value="<%= allLocalityList.get(i) %>" name="localities" onclick="getPGList('1');getSearchParams();getPGCountList('1');"/><%= allLocalityList.get(i) %></td></tr>
<%} %>
</table>
</form>
</div>