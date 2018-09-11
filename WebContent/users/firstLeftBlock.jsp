<%@page import="java.util.ArrayList"%>
<%@page import="com.pghomes.openuser.PGDAO"%>
<form id="formCity">
<%
ArrayList<String> cityList =  PGDAO.getCityList();
%>
<table height="146">
<% for(int i=0; i < cityList.size(); i++){ %>
<tr valign="top"><td><input type="checkbox" name="cities" value="<%= cityList.get(i) %>" onclick="getLocalityList();getPGList('1');getPGCountList('1');getSearchParams();"/><%= cityList.get(i) %></td></tr>
<%} %>
</table>
</form>