package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;

public class CandidateDAO {
	Connection con = null;
	
	public CandidateDAO(){
		makeConnection();
	}
	
	public void makeConnection(){
		String url = "jdbc:mysql://localhost:3306/Elections";
		String user = "root";
		String password = "DIAD2016";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection made");
			
			
		}catch (Exception ex){
			System.out.println("SQL Exception");
		}
		
	}
	
	public Election getAllCandidates(String electionName){
		makeConnection();
		String q = "SELECT Candidate1Name, Candidate2Name, Candidate3Name from CurrentElections WHERE ElectionName = '" + electionName + "'";
		Election allCandidates = null;
		
		try {
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(q);

			while (rs.next()) {
				String candidate1Name = rs.getString(1);
				String candidate2Name = rs.getString(2);
				String candidate3Name = rs.getString(3);
				allCandidates = new Election(candidate1Name, candidate2Name, candidate3Name);
			}
			//System.out.println("Query results for all candidates: " + allCandidates.getCandidate1() + " " + allCandidates.getCandidate2() + " " + allCandidates.getCandidate3());
			
		} catch (SQLException ex) {
			System.out.println("SQL error in getAllCandidates() method");
		}
		
		return allCandidates;
	}
	
	public Election getVotingResults(String electionName){
		makeConnection();
		String q = "SELECT Candidate1Name, Candidate2Name, Candidate3Name, Candidate1Vote, Candidate2Vote, Candidate3Vote from CurrentElections WHERE ElectionName = '" + electionName + "'";
		Election allVotes = null;
		
		try {
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(q);

			while (rs.next()) {
				String candidate1Name = rs.getString(1);
				String candidate2Name = rs.getString(2);
				String candidate3Name = rs.getString(3);
				int candidate1Vote = rs.getInt(4);
				int candidate2Vote = rs.getInt(5);
				int candidate3Vote = rs.getInt(6);
				
				allVotes = new Election(candidate1Name, candidate2Name, candidate3Name, candidate1Vote, candidate2Vote, candidate3Vote);
			}
			System.out.println("Query results for all candidates: " + allVotes.getCandidate1() + " " + allVotes.getCandidate2() + " " + allVotes.getCandidate3());
			
		} catch (SQLException ex) {
			System.out.println("SQL error in getVotingResults() method");
		}
		
		return allVotes;
	}
	
	public void insertCandidates(Election c){
		makeConnection();
		
		String tempElectionName = c.getElectionName();
		String tempCandidate1 = c.getCandidate1();
		String tempCandidate2 = c.getCandidate2();
		String tempCandidate3 = c.getCandidate3();
		
		String query = "insert into CurrentElections (ElectionName, Candidate1Name, Candidate2Name, Candidate3Name) values ('" + tempElectionName +
				"', '" + tempCandidate1 + "', '" + tempCandidate2 + "', '" + tempCandidate3 + "')";
		System.out.println(query);
		
		try {
			Statement st = (Statement) con.createStatement();
			st.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertCandidateVotes(Election v){
		makeConnection();
		
		String tempElectionName = v.getElectionName();
		int tempCandidate1Vote = v.getCandidate1Vote();
		int tempCandidate2Vote = v.getCandidate2Vote();
		int tempCandidate3Vote = v.getCandidate3Vote();
		
		String query = "update CurrentElections set Candidate1Vote = " + tempCandidate1Vote + ", Candidate2Vote = " + tempCandidate2Vote + 
				", Candidate3Vote = " + tempCandidate3Vote + " WHERE ElectionName = '" + tempElectionName + "'";
		System.out.println(query);
		
		try {
			Statement st = (Statement) con.createStatement();
			st.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteCandidates(Election d){
		makeConnection();

		String query = "delete from currentelections";
		System.out.println(query);
		try {
			Statement st = (Statement) con.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
