<%@page import="java.util.ArrayList"%>
<%@page import="com.pghomes.openuser.PGDAO"%>
<% ArrayList<String> cityList =  PGDAO.getCityList(); %>
<table height="600"><tr height="300"><td>
<form action="AddPG" method="post" name="addPG">
<h3>Add your PG</h3>
<table>
<tr><td align="right">PG Name</td><td>:</td><td><input type="text" name="pg_name"/>&nbsp;If you have more than one PG, give unique name</td></tr>
<tr><td align="right">PG City</td><td>:</td><td><select name="pg_city" onchange="getLocalityList(this.value)"><option>--select--</option><% for(int i=0; i < cityList.size(); i++){ %><option><%= cityList.get(i) %></option><%} %></select></td></tr>
<tr><td align="right">PG Location</td><td>:</td><td><div id="localityList"><select name="pg_location"><option>--select--</option></select></div></td></tr>
<tr><td align="right"></td><td></td><td>Other Location:&nbsp;<input type="text" name="other_location"/></td></tr>
<tr><td align="right">PG Type</td><td>:</td><td><select name="pg_type"><option>Male</option><option>Female</option></select></td></tr>
<tr><td align="right">PG Phone</td><td>:</td><td><input type="text" name="pg_phone"/></td></tr>
<tr><td align="right">Other Contacts</td><td>:</td><td><input type="text" name="other_contacts"/></td></tr>
<tr><td align="right">PG Address</td><td>:</td><td><input type="text" name="pg_address"/></td></tr>
<tr><td align="right">PG Details</td><td>:</td><td><input type="text" name="pg_details"/></td></tr>
<tr><td></td><td></td><td><input type="submit" value="Submit" onclick="return validatePG();"/></td></tr>
</table>
</form>
</td></tr>
<tr><td></td></tr>
</table>