<%@page import="java.util.ArrayList"%>
<%@page import="com.pghomes.pgowner.ManageRoom"%>
<%
Integer ownerId = Integer.parseInt((String)session.getAttribute("ownerId"));
ArrayList<ArrayList<String>> pgList = ManageRoom.getPGList(ownerId);
%>
<table height="600">
<tr valign="top" height="100"><td><h3>Please select a Room under a PG to Delete</h3><b>Note:&nbsp;</b>If you delete any Room, Information under this Room will be deleted forever.<br/></td></tr>
<tr valign="top" height="100"><td><form action="DeleteRoom" method="post">
<b>Please select a PG</b>&nbsp;<select name="pgid_to_delete" onchange="getRoomNames(this.value);">
<option value="0">--select--</option>
<%
for(int i = 0; i < pgList.size(); i++) {
	%><option value="<%=pgList.get(i).get(0) %>"><%=pgList.get(i).get(1) %></option><%
}
%></select><br/>
<div id="roomNames"><b>Please a select Room to Delete</b>&nbsp;<select><option>--select--</option></select><input type="submit" value="Delete" onclick="return confirm('Are you sure you want to delete this Room?');" /></div>
</form>
</td></tr><tr><td></td></tr>
</table>