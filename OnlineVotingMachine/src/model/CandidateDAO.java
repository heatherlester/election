package model;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


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
	
	public ArrayList<String> getAllElections(){
		makeConnection();
		String q = "SELECT DISTINCT ElectionName from CurrentElections";
		Election allElections = null;
		ArrayList<String> elections = new ArrayList<String>();
		
		try {
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(q);
			while(rs.next()){
			String temp = rs.getString(1);
			System.out.println(temp);
			  elections.add(rs.getString(1));			
			} 
			
		} catch (SQLException ex) {
			System.out.println("SQL error in getAllElections() method");
		}
		
		return elections;
	}
	
	public Election getCandidatesByLatestElectionName(String electionName){
		makeConnection();
		String q = "SELECT Candidate1Name, Candidate2Name, Candidate3Name, ElectionName from CurrentElections WHERE ElectionName = '" + electionName + "' ORDER BY ElectionID DESC LIMIT 0,1";
		Election existingCandidates = null;
		
		try {
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(q);

			while (rs.next()) {
				String candidate1Name = rs.getString(1);
				String candidate2Name = rs.getString(2);
				String candidate3Name = rs.getString(3);
				String eName = rs.getString(4);
				
				existingCandidates = new Election(eName, candidate1Name, candidate2Name, candidate3Name);
			}
			
		} catch (SQLException ex) {
			System.out.println("SQL error in getCandidatesByLatestElectionName() method");
		}
		
		return existingCandidates;
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
		System.out.println(tempElectionName + " <<<<<<<<<<<<<<< TEMP E NAME");
		int tempCandidate1Vote = v.getCandidate1Vote();
		System.out.println(v.getCandidate1Vote()+ "<<<<  Votes for c1");
		int tempCandidate2Vote = v.getCandidate2Vote();
		int tempCandidate3Vote = v.getCandidate3Vote();
		
		String query = "update CurrentElections set Candidate1Vote = " + tempCandidate1Vote + ", Candidate2Vote = " + tempCandidate2Vote + 
				", Candidate3Vote = " + tempCandidate3Vote + " WHERE ElectionName = '" + tempElectionName + "' AND Candidate1Name = '" + v.getCandidate1()+"'";
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
	
	public int getSpecificElectionID(String electionName, String c1Name, String c2Name, String c3Name){
		makeConnection();
		String q = "SELECT ELECTIONID from CurrentElections WHERE ElectionName = '" + electionName + "' AND Candidate1Name = '" + c1Name + "' AND Candidate2Name = '" + c2Name + "' AND Candidate3Name = '" + c3Name + "'";
		int electionID = 0;
		
		try {
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(q);

			while (rs.next()) {
				String tempelectionID = rs.getString(1);
				
				electionID = Integer.parseInt(tempelectionID);
			}
			
		} catch (SQLException ex) {
			System.out.println("SQL error in getSpecificElectionID() method");
		}
		
		return electionID;
	}

	public Election getVotingResultsByElectionID(int electionID){
		makeConnection();
		String q = "SELECT Candidate1Name, Candidate2Name, Candidate3Name, Candidate1Vote, Candidate2Vote, Candidate3Vote, ElectionName from CurrentElections WHERE ElectionID = '" + electionID + "'";
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
				String eName = rs.getString(7);
				
				allVotes = new Election(candidate1Name, candidate2Name, candidate3Name, candidate1Vote, candidate2Vote, candidate3Vote, eName);
			}
			System.out.println("Query results for all candidates: " + allVotes.getCandidate1() + " " + allVotes.getCandidate2() + " " + allVotes.getCandidate3() +" "+ allVotes.getCandidate1Vote());
			
		} catch (SQLException ex) {
			System.out.println("SQL error in getVotingResultsByElectionID() method");
		}
		
		return allVotes;
	}
}
