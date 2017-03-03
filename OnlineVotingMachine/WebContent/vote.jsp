<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vote Now</title>
</head>
<body>
<form method="post" action="ElectionServlet">
<table border=0 cellpadding=5>
<tr>Please select a candidate that you would like to vote for:</tr>
<tr>
<td></td>
</tr>
</table>
<input type="submit" name="doThisToItem" value="Submit Vote">
<input type="submit" name="doThisToItem" value="Back">
<input type="submit" name="doThisToItem" value="Voting Results">
</body>
</html>