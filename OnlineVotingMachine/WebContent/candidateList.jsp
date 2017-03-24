<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="model.CandidateDAO, model.Election, java.util.ArrayList"%>
<link href="css/template.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nomination of Candidates</title>
</head>
<body>
	<%
		CandidateDAO dao = new CandidateDAO();
		ArrayList<String> elections = (ArrayList<String>)request.getAttribute("listOfAllElections");
	%>

	<form method="post" action="ElectionServlet">
		<table>
			<h2 class="header" align="center">ELECTION DETAILS</h2>
			<tr>
				<td class="font">Please select the type of election:</td>
				<td><select id="eName" name = "eName">
					<%for(int i = 0; i < elections.size(); i++){ %>
						<option value="<%=i%>"><%=elections.get(i) %></option>

					<%} %>
					</select>
				</td>
			</tr>
		</table>
		<table>
			<tr>
				<td><input type = "submit" name = "doThisToItem" value = "Start Existing Election" class="button2"></td>
			</tr>
		</table>
		<table>
			<tr>
				<td>OR</td>
			</tr>
		</table>
		<table>
			<tr>
				<td class="font">If you would like to nominate your own candidates, enter names below:</td>
			</tr>
		</table>
		<table>
			<tr>
				<td class="font">Candidate 1 Name:</td>
				<td><input type = "text" name = "candidate1"></td>
			</tr>
			<tr>
				<td class="font">Candidate 2 Name:</td>
				<td><input type = "text" name = "candidate2"></td>
			</tr>
			<tr>
				<td class="font">Candidate 3 Name:</td>
				<td><input type = "text" name = "candidate3"></td>
			</tr>
		</table>
		
		<center>
			<div>
				<input type = "submit" name = "doThisToItem" value = "Nominate Candidates" class="button2">				
			</div>
		</center>
</form>
</body>
</html>