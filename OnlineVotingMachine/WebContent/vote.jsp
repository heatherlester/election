<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="model.CandidateDAO, model.Election, java.util.ArrayList"%>
<link href="css/template.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vote Now</title>
</head>
<body>
	<%
		CandidateDAO dao = new CandidateDAO();
		Election currentElection = (Election) request.getAttribute("electionToVoteIn");
		request.setAttribute("toVoteIn", currentElection);
	%>

	<form method="post" action="VotingServlet">
		<table>
			<h2 class="header" align="center">CANDIDATES</h2>
			<tr>
				<h3>Select the candidate you would like to vote for:</h3>
			</tr>
			<tr>
				<td><input type="hidden" name="eName" value="<%=currentElection.getElectionName()%>"></td>
			</tr>

			<tr>
				<td class="font"><input type="radio" name="voteFor" value="<%=currentElection.getCandidate1()%>"><%=currentElection.getCandidate1()%></td>
			</tr>
			<tr>
				<td class="font"><input type="radio" name="voteFor" value="<%=currentElection.getCandidate2()%>"><%=currentElection.getCandidate2()%></td>
			</tr>
			<tr>
				<td class="font"><input type="radio" name="voteFor" value="<%=currentElection.getCandidate3()%>"><%=currentElection.getCandidate3()%></td>

			</tr>

		</table>
		<center>
			<div>
				<input type="hidden" name="c1" value="<%=currentElection.getCandidate1()%>">
				<input type="hidden" name="c2" value="<%=currentElection.getCandidate2()%>">
				<input type="hidden" name="c3" value="<%=currentElection.getCandidate3()%>">
				<input type="submit" name="doThisToItem" value="Submit Vote" class="button2">
				<input type=button value="Back" onCLick="history.back()" class="button2">
				<input type="submit" name="doThisToItem" value="Voting Results" class="button2">
			</div>
		</center>
	</form>
</body>
</html>