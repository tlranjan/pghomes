<b>Search Result For:</b>&nbsp;
<%
String[] cities = request.getParameterValues("cities");
String[] localities = request.getParameterValues("localities");
String[] rentranges = request.getParameterValues("rentranges");
String[] shareTypes = request.getParameterValues("shareTypes");
String[] gender = request.getParameterValues("gender");
if(gender != null){
	for(String s : gender){
		%><%=s.toString() %>,&nbsp;<%
	}
}
if(cities != null){
	for(String s : cities){
		%><%=s.toString() %>,&nbsp;<%
	}
}
if(localities != null){
	for(String s : localities){
		%><%=s.toString() %>,&nbsp;<%
	}	
}
if(rentranges != null){
	for(String s : rentranges){
		%><%=s.toString() %>,&nbsp;<%
	}	
}
if(shareTypes != null){
	for(String s : shareTypes){
		%><%=s.toString() %>,&nbsp;<%
	}	
}
%>