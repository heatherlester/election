package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CandidateDAO;
import model.Election;

/**
 * Servlet implementation class VotingServlet
 */
@WebServlet("/VotingServlet")
public class VotingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VotingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Inside VotingServlet");
		
		String actionToPerform = request.getParameter("doThisToItem");
		if (actionToPerform.equals("Submit Vote")) {
			System.out.println("Submits vote to election database");

			String voteFor = request.getParameter("voteFor");
			System.out.println("To Vote For: " + voteFor);
			String eName = request.getParameter("eName");
			String c1 = request.getParameter("c1");
			String c2 = request.getParameter("c2");
			String c3 = request.getParameter("c3");

			CandidateDAO dao = new CandidateDAO();
			int electionID = dao.getSpecificElectionID(eName, c1, c2, c3);
			Election elect = dao.getVotingResultsByElectionID(electionID);

			System.out.println("Candidate 1: " + elect.getCandidate1());

			if (elect.getCandidate1().equals(voteFor)) {
				elect.voteForCandidate1();
			} else if (elect.getCandidate2().equals(voteFor)) {
				elect.voteForCandidate2();
			} else if (elect.getCandidate3().equals(voteFor)) {
				elect.voteForCandidate3();
			}

			dao.insertCandidateVotes(elect);

			request.setAttribute("electionToVoteIn", elect);

			getServletContext().getRequestDispatcher("/vote.jsp").forward(request, response);
		} else if (actionToPerform.equals("Voting Results")) {
			System.out.println("Launch us to voting results screen");
			CandidateDAO dao = new CandidateDAO();
			String eName = request.getParameter("eName");
			Election allVotes = dao.getVotingResults(eName);
			
			int totalVotes = allVotes.getCandidate1Vote() + allVotes.getCandidate2Vote() + allVotes.getCandidate3Vote();
			allVotes.setVoteTotal(totalVotes);
			
			request.setAttribute("votingResults", allVotes);
			getServletContext().getRequestDispatcher("/votingResults.jsp").forward(request, response);
		}
	}

}
