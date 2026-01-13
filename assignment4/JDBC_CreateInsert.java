package assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_CreateInsert {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","1234");
			
			String insertData = "insert into student(roll_no, name , branch , yop ,sem , percentage) values (98 ,'Lucky Palr' , 'DS', 2026, '8' ,74),"
					+ "(83,'Himesh Kurmi','DS', 2026 , '8' , 79) , (111,'Nageshwar', 'DS', 2026 , '8' , 75), (86,'Jay Harinkhede','DS',2026,'8',71),"
					+ "(141,'Rajeev Kurmi', 'DS', 2026,'8',74)";
			
			Statement st = con.createStatement();
			st.execute(insertData);
			
			System.out.println("Data is Updated Successfully !");
			
		}
		catch(ClassNotFoundException e) {
			System.out.println("Warning "+e);
		}
		catch(SQLException e) {
			System.out.println("Connection : "+e);
		}

	}

}