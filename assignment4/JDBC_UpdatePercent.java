package assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_UpdatePercent {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","1234");
			
			String updateStructure = "alter table students Add percentage Decimal(5,2)";
			
			Statement st = con.createStatement();
			st.execute(updateStructure);
			
			System.out.println("Table is Updated Successfully !");
			
		}
		catch(ClassNotFoundException e) {
			System.out.println("Warning "+e);
		}
		catch(SQLException e) {
			System.out.println("Connection : "+e);
		}

	}

}