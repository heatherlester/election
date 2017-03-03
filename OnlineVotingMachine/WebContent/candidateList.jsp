<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="java.util.ArrayList, model.Election"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Candidates</title>
</head>
<body>
	<%
		Election allCandidates = (Election) request.getAttribute("AllCandidates");
	%>
	<form method="post" action="ElectionServlet">
		<table border=0 cellpadding=5>
			<tr>
				<td>Please select the type of election:</td>
				<td><select id="elections">
						<option value="1">Presidential</option>
						<option value="2">Homecoming Queen</option>
						<option value="3">Sheriff</option>
				</select></td>
			</tr>
			<tr>
				<td>Enter candidate names to nominate:
				<br>
				<input type="text" name="candidate1">
				<br>
				<input type="text" name="candidate2">
				<br>
				<input type="text" name="candidate3"></td>
			</tr>

			<tr>
				<td><input type="submit" name="doThisToItem"
					value="Nominate Candidates"></td>
				<td>OR</td>
				<td><input type="submit" name="doThisToItem"
					value="Start Existing Election"></td>
			</tr>
		</table>
	</form>
</body>
</html>