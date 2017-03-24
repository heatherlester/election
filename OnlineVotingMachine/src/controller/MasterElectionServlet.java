package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CandidateDAO;

/**
 * Servlet implementation class MasterElectionServlet
 */
@WebServlet("/MasterElectionServlet")
public class MasterElectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MasterElectionServlet() {
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
		// TODO Auto-generated method stub
		System.out.println("Inside MasterElectionServlet");
		
		CandidateDAO dao = new CandidateDAO();

		String actionToPerform = request.getParameter("doThisToItem");
		if(actionToPerform.equals("Let's Begin!")){
			System.out.println("Launch us to candidate screen");
			ArrayList<String> allElections = dao.getAllElections();
			request.setAttribute("listOfAllElections", allElections);
			getServletContext().getRequestDispatcher("/candidateList.jsp").forward(request, response);
		} 
	}

}
