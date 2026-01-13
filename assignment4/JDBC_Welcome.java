package assignment4;

import java.sql.*;


/*
 * Established the connection with mySql.
 * First Step 
 */


public class JDBC_Welcome {

	public static void main(String[] args){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","1234");
			System.out.println("Connection Created Successfully !");
			con.close();
		}
		catch(ClassNotFoundException e) {
			System.out.println("Class Not Found Error !");
		}
		catch(SQLException e) {
			System.out.println("Connection not created !");
		}
		

	}

}