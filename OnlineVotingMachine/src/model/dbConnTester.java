package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class dbConnTester {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/Elections";
		String user = "root";
		String password = "DIAD2016";
		
		try {
			
			//Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection made");
			
			String q = "SELECT * from currentelections";
			
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(q);
			
			while(rs.next()){
				String candidate1 = rs.getString(1);
				String candidate2 = rs.getString(2);
				String candidate3 = rs.getString(3);
				System.out.println(candidate1 + " -- " + candidate2 + " -- " + candidate3);
			}
		}catch (Exception ex){
			System.out.println("SQL Exception");
		}

	}

}
