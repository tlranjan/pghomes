<% if(request.getParameter("id").equals("addguest")){ %><% if(session.getAttribute("ownerId") != null){ %><%@include file="ownermenu/addguest.jsp" %><% } else { %><%@include file="login.jsp" %><% } %><% } %> 
<% if(request.getParameter("id").equals("addpg")){ %><% if(session.getAttribute("ownerId") != null){ %><%@include file="ownermenu/addpg.jsp" %><% } else { %><%@include file="login.jsp" %><% } %><% } %> 
<% if(request.getParameter("id").equals("addroom")){ %><% if(session.getAttribute("ownerId") != null){ %><%@include file="ownermenu/addroom.jsp" %><% } else { %><%@include file="login.jsp" %><% } %><% } %> 
<% if(request.getParameter("id").equals("deleteguest")){ %><% if(session.getAttribute("ownerId") != null){ %><%@include file="ownermenu/deleteguest.jsp" %><% } else { %><%@include file="login.jsp" %><% } %><% } %> 
<% if(request.getParameter("id").equals("deletepg")){ %><% if(session.getAttribute("ownerId") != null){ %><%@include file="ownermenu/deletepg.jsp" %><% } else { %><%@include file="login.jsp" %><% } %><% } %> 
<% if(request.getParameter("id").equals("deleteroom")){ %><% if(session.getAttribute("ownerId") != null){ %><%@include file="ownermenu/deleteroom.jsp" %><% } else { %><%@include file="login.jsp" %><% } %><% } %> 
<% if(request.getParameter("id").equals("editguest")){ %><% if(session.getAttribute("ownerId") != null){ %><%@include file="ownermenu/editguest.jsp" %><% } else { %><%@include file="login.jsp" %><% } %><% } %> 
<% if(request.getParameter("id").equals("editpg")){ %><% if(session.getAttribute("ownerId") != null){ %><%@include file="ownermenu/editpg.jsp" %><% } else { %><%@include file="login.jsp" %><% } %><% } %> 
<% if(request.getParameter("id").equals("editroom")){ %><% if(session.getAttribute("ownerId") != null){ %><%@include file="ownermenu/editroom.jsp" %><% } else { %><%@include file="login.jsp" %><% } %><% } %> 
<% if(request.getParameter("id").equals("editroomrent")){ %><% if(session.getAttribute("ownerId") != null){ %><%@include file="ownermenu/editroomrent.jsp" %><% } else { %><%@include file="login.jsp" %><% } %><% } %> 
<% if(request.getParameter("id").equals("guestdue")){ %><% if(session.getAttribute("ownerId") != null){ %><%@include file="ownermenu/guestdue.jsp" %><% } else { %><%@include file="login.jsp" %><% } %><% } %> 
<% if(request.getParameter("id").equals("guestpaid")){ %><% if(session.getAttribute("ownerId") != null){ %><%@include file="ownermenu/guestpaid.jsp" %><% } else { %><%@include file="login.jsp" %><% } %><% } %> 
<% if(request.getParameter("id").equals("pggoodsmgmnt")){ %><% if(session.getAttribute("ownerId") != null){ %><%@include file="ownermenu/pggoodsmgmnt.jsp" %><% } else { %><%@include file="login.jsp" %><% } %><% } %> 
<% if(request.getParameter("id").equals("viewallguest")){ %><% if(session.getAttribute("ownerId") != null){ %><%@include file="ownermenu/viewallguest.jsp" %><% } else { %><%@include file="login.jsp" %><% } %><% } %> 
<% if(request.getParameter("id").equals("viewbed")){ %><% if(session.getAttribute("ownerId") != null){ %><%@include file="ownermenu/viewbed.jsp" %><% } else { %><%@include file="login.jsp" %><% } %><% } %> 
<% if(request.getParameter("id").equals("pgprof")){ %><% if(session.getAttribute("ownerId") != null){ %><%@include file="ownermenu/pgprof.jsp" %><% } else { %><%@include file="login.jsp" %><% } %><% } %> 
<% if(request.getParameter("id").equals("viewemptybed")){ %><% if(session.getAttribute("ownerId") != null){ %><%@include file="ownermenu/viewemptybed.jsp" %><% } else { %><%@include file="login.jsp" %><% } %><% } %> 
<% if(request.getParameter("id").equals("viewpg")){ %><% if(session.getAttribute("ownerId") != null){ %><%@include file="ownermenu/viewpg.jsp" %><% } else { %><%@include file="login.jsp" %><% } %><% } %> 
<% if(request.getParameter("id").equals("viewroom")){ %><% if(session.getAttribute("ownerId") != null){ %><%@include file="ownermenu/viewroom.jsp" %><% } else { %><%@include file="login.jsp" %><% } %><% } %> 
<% if(request.getParameter("id").equals("successMessage")){ %><%@include file="ownermenu/successMessage.jsp" %><% } %>
<% if(request.getParameter("id").equals("home")){ %><%@include file="homeMainBody.jsp" %><% } %>
<% if(request.getParameter("id").equals("faqs")){ %><%@include file="faqs.jsp" %><% } %>
<% if(request.getParameter("id").equals("contactUs")){ %><%@include file="contacts.jsp" %><% } %>
<% if(request.getParameter("id").equals("ownerreg")){ %><%@include file="ownerReg.jsp" %><% } %> 
<% if(request.getParameter("id").equals("loginLink")){ %><%@include file="login.jsp" %><% } %> 
<% if(request.getParameter("id").equals("pgadvt")){ %><%@include file="pgadvt.jsp" %><% } %> 