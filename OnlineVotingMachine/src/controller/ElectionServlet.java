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
 * Servlet implementation class ElectionServlet
 */
@WebServlet("/ElectionServlet")
public class ElectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ElectionServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside ElectionServlet");
		
		CandidateDAO dao = new CandidateDAO();
		
		String actionToPerform = request.getParameter("doThisToItem");
		System.out.println("Launch us to voting screen");
		if (actionToPerform.equals("Nominate Candidates")) {
			String tempElectionNumber = request.getParameter("eName");
			int electionID = Integer.parseInt(tempElectionNumber);

			ArrayList<String> allElections = dao.getAllElections();

			String electionName = allElections.get(electionID);
			System.out.println("------" + electionName);

			String candidate1 = request.getParameter("candidate1");
			String candidate2 = request.getParameter("candidate2");
			String candidate3 = request.getParameter("candidate3");

			// System.out.println(candidate1);
			// System.out.println(candidate2);
			// System.out.println(candidate3);

			Election c = new Election(electionName, candidate1, candidate2, candidate3);

			dao.insertCandidates(c);

			request.setAttribute("electionToVoteIn", c);
			getServletContext().getRequestDispatcher("/vote.jsp").forward(request, response);

		} else if (actionToPerform.equals("Start Existing Election")) {
			System.out.println("Launch us to voting screen for existing election");
			String tempElectionNumber = request.getParameter("eName");
			int electionID = Integer.parseInt(tempElectionNumber);
			ArrayList<String> allElections = dao.getAllElections();
			String electionName = allElections.get(electionID);
			System.out.println("------" + electionName);
			Election existingCandidates = dao.getCandidatesByLatestElectionName(electionName);
			request.setAttribute("electionToVoteIn", existingCandidates);
			getServletContext().getRequestDispatcher("/vote.jsp").forward(request, response);
		}

	}

}
