<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="model.CandidateDAO, model.Election, java.util.ArrayList"%>
<link href="css/template.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Voting Results</title>
</head>
<body>
	<%
		CandidateDAO dao = new CandidateDAO();
		Election votingResults = (Election) request.getAttribute("votingResults");
	%>


	<table class="border">
		<h2 class="header" align="center">ELECTION RESULTS:</h2>
			<tr>
				<td class="heading">Candidate Name:</td>
				<td class="heading">Vote Count:</td>
			</tr>
			<tr>
				<td class="border"><%=votingResults.getCandidate1()%></td>
				<td class="border"><%=votingResults.getCandidate1Vote()%></td>
			</tr>
			<tr>
				<td class="border"><%=votingResults.getCandidate2()%></td>
				<td class="border"><%=votingResults.getCandidate2Vote()%></td>
			</tr>
			<tr>
				<td class="border"><%=votingResults.getCandidate3()%></td>
				<td class="border"><%=votingResults.getCandidate3Vote()%></td>
			</tr>
			
	</table>
	<table class="total">
		<tr>
			<td>Vote Total:</td>
			<td><%=votingResults.getVoteTotal()%></td>
		</tr>
		<tr>
			<td> </td>
		</tr>
	</table>

	<input type="hidden" name="c1" value="<%=votingResults.getCandidate1()%>">
	<input type="hidden" name="c2" value="<%=votingResults.getCandidate2()%>">
	<input type="hidden" name="c3" value="<%=votingResults.getCandidate3()%>">
	<input type="hidden" name="c1V" value="<%=votingResults.getCandidate1Vote()%>">
	<input type="hidden" name="c2V" value="<%=votingResults.getCandidate2Vote()%>">
	<input type="hidden" name="c3V" value="<%=votingResults.getCandidate3Vote()%>">
	<input type="hidden" name="allVotes" value=<%votingResults.getVoteTotal();%>>
	<center>
		<div>
			<input type=button value="Back" onCLick="history.back()" class="button2">
		</div>
</body>
</html>