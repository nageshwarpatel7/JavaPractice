package assignment4;

import java.sql.*;


public class JDBC_CreateTable {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","1234");
			
			String createTable = "create table Student(roll_no INT  primary key , name varchar(20), branch varchar(20), yop INT  ,sem varchar(10), ) ";
			Statement st = con.createStatement();
			st.execute(createTable);
			
			System.out.println("Table is Created Successfully !");
			
		}
		catch(ClassNotFoundException e) {
			System.out.println("Warning "+e);
		}
		catch(SQLException e) {
			System.out.println("Connection : "+e);
		}

	}

}