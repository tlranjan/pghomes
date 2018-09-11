<%@page import="java.util.ArrayList"%>
<%@page import="com.pghomes.openuser.PGDAO"%>
<%@page import="java.util.List"%>
<%
String[] cities = request.getParameterValues("cities");
String[] localities = request.getParameterValues("localities");
String[] rentranges = request.getParameterValues("rentranges");
String[] shareTypes = request.getParameterValues("shareTypes");
String pgListPageNo = request.getParameter("searchPageNo");
String[] gender = request.getParameterValues("gender");
ArrayList<String> genders = new ArrayList<String>();
if(gender != null){
	for(String s : gender){
		genders.add(s.toString());
	}
}
if(pgListPageNo == null){
	pgListPageNo = "1";
}
int pgaeDisplayed = Integer.parseInt(pgListPageNo);
ArrayList<String> cityNames = new ArrayList<String>();
if(cities != null){
	for(String s : cities){
		cityNames.add(s.toString());
	}
}
ArrayList<String> locations = new ArrayList<String>();
if(localities != null){
	for(String s : localities){
		locations.add(s.toString());
	}	
}
ArrayList<String> rents = new ArrayList<String>();
if(rentranges != null){
	for(String s : rentranges){
		rents.add(s.toString());
	}	
}
ArrayList<String> sharingTypes = new ArrayList<String>();
if(shareTypes != null){
	for(String s : shareTypes){
		sharingTypes.add(s.toString());
	}	
}
List<ArrayList<String>> allPGList = PGDAO.getPGList(cityNames, locations, sharingTypes, rents, genders, Integer.parseInt(pgListPageNo));
int allPGCount = PGDAO.getPGListCount(cityNames, locations, sharingTypes, rents, genders);
int pageTotal = allPGCount/9;
int startCounter = ((pgaeDisplayed-1) * 9)+1;
int endCounter = startCounter + 8;
if(allPGCount <= endCounter){
	endCounter = allPGCount;
}
%>
<table height="640" width="650">
<tr><td width="25"></td><td width="550" colspan="2"><div id="searchFor"><b>Showing All Results</b></div></td></tr>
<tr><td width="25"></td><td><form id="formGender"><input type="checkbox" name="gender" value="Male" onclick="getPGList('1');getSearchParams();getPGCountList('1');"/>Male<input type="checkbox" name="gender" value="Female" onclick="getPGList('1');getSearchParams();getPGCountList('1');"/>Female</form></td><td align="right"><div id="pgResultCountUpper">
<b>Showing results&nbsp;</b><%= startCounter %>-<%= endCounter %>&nbsp;of&nbsp;<%= allPGCount %>
<%
for(int i = 0; i <= pageTotal; i++){
	%>&nbsp;<a href="#" onclick="getPGList(<%=i+1 %>);getPGCountList(<%=i+1 %>);"><%=i+1 %></a><%
}
%>
</div></td></tr>
<tr>
<td width="25"></td><td colspan="2">
<div style="width:100%; max-height:610px; overflow:auto"><div id="loadSearchedContent">
<table height="610">
<% for(int i=0; i < allPGList.size(); i++){ %>
<tr height="30"><td>
<table>
<tr><td style="text-align: justify">
<b><a href="home.jsp?id=moreinfo&infoPGId=<%= allPGList.get(i).get(7) %>" target="_blank"><%= allPGList.get(i).get(0) %></a></b>&nbsp;<%= allPGList.get(i).get(1) %>,&nbsp;<%= allPGList.get(i).get(6) %><br/>
<b>Description:</b>&nbsp;<%= allPGList.get(i).get(5) %>,&nbsp;<%= allPGList.get(i).get(4) %>,&nbsp;<%= allPGList.get(i).get(6) %><br/>
<b>Contacts:</b>&nbsp;<%= allPGList.get(i).get(2) %>,&nbsp;<%= allPGList.get(i).get(3) %><br/>
<a href="home.jsp?id=moreinfo&infoPGId=<%= allPGList.get(i).get(7) %>" target="_blank">More Info</a>&nbsp;&nbsp;<a href="home.jsp?id=pgbooking">Booking</a>
</td></tr>
</table>
</td></tr>
<%} %><tr></tr>
</table>
</div></div>
</td>
</tr>
<tr><td align="right" colspan="3">
<div id="pgResultCountLower">
<b>Showing results&nbsp;</b><%= startCounter %>-<%= endCounter %>&nbsp;of&nbsp;<%= allPGCount %>
<%
for(int i = 0; i <= pageTotal; i++){
	%>&nbsp;<a href="#" onclick="getPGList(<%=i+1 %>);getPGCountList(<%=i+1 %>);"><%=i+1 %></a><%
}
%>
</div>
</td></tr>
</table>