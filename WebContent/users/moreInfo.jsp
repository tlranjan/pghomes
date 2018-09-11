<%@page import="java.util.List"%>
<%@page import="com.pghomes.openuser.PGDAO"%>
<%@page import="java.util.Iterator"%>
<%
String infoPGId = request.getParameter("infoPGId");
Integer infoPGIdInt = Integer.parseInt(infoPGId);
List<String> imageList = PGDAO.getPGImageId(infoPGIdInt);
Iterator<String> it = imageList.iterator();
List<String> discList = PGDAO.getPGDiscriptionAd(infoPGIdInt);
Iterator<String> discIt = discList.iterator();
%>
<%
	if(imageList.isEmpty()){
		%><table height="600"><tr><td><b>No extra information is available for the selected PG</b></td></tr></table><%
	} else {
		%>
<table height="600">
<tr>
<td width="400">
<table>
<tr><td valign="top" height="250"><div id="map-canvas"></div></td></tr>
<tr><td height="350" valign="top">
<ul class="bxslider"><%
while(it.hasNext()) {
	%><li><img src="http://drive.google.com/uc?export=view&id=<%=it.next() %>" /></li><%
}
%>
</ul>
</td></tr>
</table>
</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td valign="top"><table>
<%
while(discIt.hasNext()){
	%><tr><td valign="top"><b>-&nbsp;</b></td><td><b><%=discIt.next() %></b></td><td>&nbsp;&nbsp;</td></tr><%
}
%>
</table></td>
</tr>
</table>
<%
	}
%>
