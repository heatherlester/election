package model;

public class Election{	

	private String electionName;
	private String candidate1;
	private String candidate2;
	private String candidate3;
	private int candidate1Vote;
	private int candidate2Vote;
	private int candidate3Vote;
	public int voteTotal;

	public Election(){
		
	}
	
	public Election(String eN, String c1, String c2, String c3){
		this.electionName = eN;
		this.candidate1 = c1;
		this.candidate2 = c2;
		System.out.println("========="+ this.candidate2);
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
	
	public Election(String c1, String c2, String c3, int c1V, int c2V, int c3V, String eName){
		this.candidate1 = c1;
		this.candidate2 = c2;
		this.candidate3 = c3;
		this.candidate1Vote = c1V;
		this.candidate2Vote = c2V;
		this.candidate3Vote = c3V;
		this.electionName = eName;
	}
		
	public void voteForCandidate1() {
		this.candidate1Vote++;
		this.voteTotal++;
	}

	public void voteForCandidate2() {
		this.candidate2Vote++;
		this.voteTotal++;
	}
	
	public void voteForCandidate3() {
		this.candidate3Vote++;
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
	


	public int getVoteTotal() {
		return voteTotal;
	}

	public void setVoteTotal(int voteTotal) {
		this.voteTotal = voteTotal;
	}


}
