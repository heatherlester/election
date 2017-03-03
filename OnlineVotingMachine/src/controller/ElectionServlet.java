package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CandidateDAO;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside ElectionServlet");
		
		CandidateDAO dao = new CandidateDAO();

		String actionToPerform = request.getParameter("doThisToItem");
		if(actionToPerform.equals("Nominate Candidates")){
			System.out.println("Launch us to voting screen");
			getServletContext().getRequestDispatcher("/vote.jsp").forward(request, response);
		} else if(actionToPerform.equals("Start Existing Election")){
			System.out.println("Launch us to voting screen");
			getServletContext().getRequestDispatcher("/vote.jsp").forward(request, response);
		} else if(actionToPerform.equals("Submit Vote")){
			System.out.println("Submits vote to election database");
			getServletContext().getRequestDispatcher("/vote.jsp").forward(request, response);
		} else if(actionToPerform.equals("Back")){
			System.out.println("take back to candidate screen");
			getServletContext().getRequestDispatcher("/candidateList.jsp").forward(request, response);
		} else if(actionToPerform.equals("Voting Results")){
			System.out.println("Launch us to voting results screen");
			getServletContext().getRequestDispatcher("/votingResults.jsp").forward(request, response);
		}
	}

}
