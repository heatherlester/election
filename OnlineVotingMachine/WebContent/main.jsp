<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/template.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1UTF-8">
<title>Welcome</title>
</head>
<body>
	<form method="post" action="MasterElectionServlet">
		<table>
			<tr>
				<h1 class="header">WELCOME TO THE ELECTION!</h1>
			</tr>
			<tr>
				<h3>Thank you for choosing to participate in the election.<br>
				Every vote counts!</h3>
			</tr>

		</table>
		<center>
			<div>
				<input type="submit" name="doThisToItem" value="Let's Begin!" class="button1">
			</div>
		</center>
</body>
</html>