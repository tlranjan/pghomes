<%@page import="com.pghomes.openuser.PGDAO"%>
<%@page import="java.util.ArrayList"%>
<form id="formRents">
<%
ArrayList<String> rentList =  PGDAO.getRentRangeList();
%>
<table height="146">
<% for(int i=0; i < rentList.size(); i++){ %>
<tr valign="top"><td><input type="checkbox" name="rentranges" value="<%= rentList.get(i) %>" onclick="getPGList('1');getSearchParams();getPGCountList('1');"/><%= rentList.get(i) %></td></tr>
<%} %>
</table>
</form>