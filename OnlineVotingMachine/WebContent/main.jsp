<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<form method="post" action="MasterControllerServlet">
		<table>
			<tr>
				<th>Welcome to the election!</th>
			</tr>
			<tr>
				<th>Let's get started by selecting the election</th>
			</tr>

		</table>

		<div style="text-align: center">
			<input type="submit" name="doThisToItem" value="Let's Vote!">
		</div>
</body>
</html>