<%@page import="com.pghomes.openuser.PGDAO"%>
<%@page import="java.util.ArrayList"%>
<form id="formShare">
<% 
ArrayList<String> shareList =  PGDAO.getAllSharingList();
%>
<table height="146">
<% for(int i=0; i < shareList.size(); i++){ %>
<tr valign="top"><td><input type="checkbox" name="shareTypes" value="<%= shareList.get(i) %>" onclick="getPGList('1');getSearchParams();getPGCountList('1');"/><%= shareList.get(i) %></td></tr>
<%} %>
</table>
</form>