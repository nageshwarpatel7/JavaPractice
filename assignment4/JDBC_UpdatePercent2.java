package assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_UpdatePercent2 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","1234");
			
			String updatePercent = "update students set percentage = percentage+5  where branch = 'CSE' ";
			
			Statement st = con.createStatement();
			st.execute(updatePercent);
			
			System.out.println("Percentage is Updated Successfully !");
			
		}
		catch(ClassNotFoundException e) {
			System.out.println("Warning "+e);
		}
		catch(SQLException e) {
			System.out.println("Connection : "+e);
		}


	}

}