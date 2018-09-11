<%
String ownerName = (String)session.getAttribute("ownerName");
String logout = "";
String login = "";
if(ownerName == null){
	ownerName = "Guest";
	logout = "";
	login = "Login";
} else {
	logout = "Logout";
	login = "";
}
%>
<table width="1058" height="100" border="0" align="center">
<tr><td align="right">Welcome&nbsp;<b><%=ownerName %></b>&nbsp;<a href="LogoutOwner"><%=logout %></a><a href="customers.jsp?id=loginLink"><%=login %></a></td></tr>
<tr><td valign="top" align="left"><h1><a href="http://pghomesindia.com/" target="_blank">PG Homes</a></h1></td></tr>
  <tr bgcolor="gray">
    <td width="1058" valign="top" align="center">
		<ul class="menu" id="menu">
		<li><a href="#" class="menulink">Manage PG</a>
			<ul><li><a href="customers.jsp?id=viewpg">View PG Details</a></li><li><a href="customers.jsp?id=addpg">Add PG</a></li><li><a href="customers.jsp?id=deletepg">Delete PG</a></li><li><a href="customers.jsp?id=pgprof">View PG Profile</a></li><li><a href="customers.jsp?id=editpg">Edit PG Profile</a></li></ul>
		</li>
		<li><a href="#" class="menulink">Manage Room</a>
			<ul><li><a href="customers.jsp?id=viewroom">View Room Details</a></li><li><a href="customers.jsp?id=addroom">Add Room</a></li><li><a href="customers.jsp?id=deleteroom">Delete Room</a></li><li><a href="customers.jsp?id=editroom">Edit Room</a></li></ul>
		</li>
		<li><a href="#" class="menulink">Manage Beds</a>
			<ul><li><a href="customers.jsp?id=viewbed">View All Beds</a></li><li><a href="customers.jsp?id=viewemptybed">View Empty Bed</a></li></ul>
		</li>
		<li><a href="#" class="menulink">Manage Guest</a>
			<ul><li><a href="customers.jsp?id=viewallguest">View Guests</a></li><li><a href="customers.jsp?id=addguest">Add Guest</a></li><li><a href="customers.jsp?id=deleteguest">Delete Guest</a></li><li><a href="customers.jsp?id=editguest">Edit Guest Details</a></li></ul>
		</li>
		<li><a href="#" class="menulink">Bill Management</a>
			<ul><li><a href="customers.jsp?id=guestdue">Guest Due</a></li><li><a href="customers.jsp?id=guestpaid">Guest Paid</a></li><li><a href="customers.jsp?id=editroomrent">Edit Room Rent</a></li></ul>
		</li>
		<li><a href="#" class="menulink">PG Solutions</a>
			<ul><li><a href="customers.jsp?id=pggoodsmgmnt">PG Goods Mgmt</a></li><li><a href="customers.jsp?id=pgadvt">PG Advertising</a></li></ul>
		</li>
		<li><a href="#" class="menulink">Home</a>
			<ul><li><a href="customers.jsp?id=home">About Us</a></li><li><a href="customers.jsp?id=faqs">FAQs</a></li><li><a href="customers.jsp?id=contactUs">Contact Us</a></li></ul>
		</li>
		</ul>
		<script type="text/javascript">
			var menu=new menu.dd("menu");
			menu.init("menu","menuhover");
		</script>
  </td></tr>
  </table>