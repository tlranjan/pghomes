<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="datefield/jquery-ui.css" />
  <script src="datefield/jquery-1.9.1.js"></script>
  <script src="datefield/jquery-ui.js"></script>
  <script>
	$(function() {
    $( "#datepicker" ).datepicker({ dateFormat: 'yy/mm/dd' });
	});
   </script>
</head>
<body>
Date: <input type="text" id="datepicker" />
<table>
<form action="test2.jsp"><tr><td><input type="text" name="abc" value="sdfsdf" /></td><td><input type="submit" value="Update" /></td></tr></form>
<tr><td>sdsa</td><td>sfdsss</td></tr>
</table>
</body>
</html>