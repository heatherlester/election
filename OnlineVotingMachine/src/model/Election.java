package model;

public class Election{	

	private String electionName;
	private String candidate1;
	private String candidate2;
	private String candidate3;
	private int candidate1Vote;
	private int candidate2Vote;
	private int candidate3Vote;
	public int candidate1Votes;
	public int candidate2Votes;
	public int candidate3Votes;
	public int voteTotal;

	public Election(){
		
	}
	
	public Election(String eN, String c1, String c2, String c3){
		this.electionName = eN;
		this.candidate1 = c1;
		this.candidate2 = c2;
		this.candidate3 = c3;
	}
	
	public Election(String c1, String c2, String c3){
		this.candidate1 = c1;
		this.candidate2 = c2;
		this.candidate3 = c3;
	}
	
	public Election(String eN, int c1V, int c2V, int c3V){
		this.electionName = eN;
		this.candidate1Vote = c1V;
		this.candidate2Vote = c2V;
		this.candidate3Vote = c3V;
	}
	
	public Election(String c1, String c2, String c3, int c1V, int c2V, int c3V){
		this.candidate1 = c1;
		this.candidate2 = c2;
		this.candidate3 = c3;
		this.candidate1Vote = c1V;
		this.candidate2Vote = c2V;
		this.candidate3Vote = c3V;
	}
		
	public void voteForCandidate1() {
		this.candidate1Votes++;
		this.voteTotal++;
	}

	public void voteForCandidate2() {
		this.candidate2Votes++;
		this.voteTotal++;
	}
	
	public void voteForCandidate3() {
		this.candidate3Votes++;
		this.voteTotal++;
	}

	public String getElectionName() {
		return electionName;
	}

	public void setElectionName(String electionName) {
		this.electionName = electionName;
	}

	public String getCandidate1() {
		return candidate1;
	}

	public void setCandidate1(String candidate1) {
		this.candidate1 = candidate1;
	}

	public String getCandidate2() {
		return candidate2;
	}

	public void setCandidate2(String candidate2) {
		this.candidate2 = candidate2;
	}

	public String getCandidate3() {
		return candidate3;
	}

	public void setCandidate3(String candidate3) {
		this.candidate3 = candidate3;
	}

	public int getCandidate1Vote() {
		return candidate1Vote;
	}

	public void setCandidate1Vote(int candidate1Vote) {
		this.candidate1Vote = candidate1Vote;
	}

	public int getCandidate2Vote() {
		return candidate2Vote;
	}

	public void setCandidate2Vote(int candidate2Vote) {
		this.candidate2Vote = candidate2Vote;
	}

	public int getCandidate3Vote() {
		return candidate3Vote;
	}

	public void setCandidate3Vote(int candidate3Vote) {
		this.candidate3Vote = candidate3Vote;
	}
	
	public int getCandidate1Votes() {
		return candidate1Votes;
	}

	public void setCandidate1Votes(int candidate1Votes) {
		this.candidate1Votes = candidate1Votes;
	}

	public int getCandidate2Votes() {
		return candidate2Votes;
	}

	public void setCandidate2Votes(int candidate2Votes) {
		this.candidate2Votes = candidate2Votes;
	}

	public int getCandidate3Votes() {
		return candidate3Votes;
	}

	public void setCandidate3Votes(int candidate3Votes) {
		this.candidate3Votes = candidate3Votes;
	}

	public int getVoteTotal() {
		return voteTotal;
	}

	public void setVoteTotal(int voteTotal) {
		this.voteTotal = voteTotal;
	}


}
