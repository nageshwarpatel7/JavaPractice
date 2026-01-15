package miniproject_3;
import java.util.*;
import java.sql.*;

public class StudentServiceImpl implements StudentServiceInterface {
		
	 Scanner sc = new Scanner(System.in);
	 
	@Override
	public void addStudent() throws Exception {
		System.out.println("Enter Enrollment Number :");
		int eno = Integer.parseInt(sc.nextLine());
		
		Connection con = DBconnection.getConnection();
		PreparedStatement  check = con.prepareStatement("select eno from student where eno=?");
		check.setInt(1,eno);
		
		  if (check.executeQuery().next())
	            throw new DuplicateEnoException("Eno already exists!");

		  System.out.print("Name: ");
	        String name = sc.nextLine();

	        System.out.print("Percentage: ");
	        double per = Double.parseDouble(sc.nextLine());

	        if (per <= 0)
	            throw new InvalidPercentageException("Percentage must be positive!");

	        System.out.print("Semester: ");
	        String sem = sc.nextLine();

	        System.out.print("Branch: ");
	        String branch = sc.nextLine();

	        if (sem.isEmpty() || branch.isEmpty())
	            throw new EmptyFieldException("Sem/Branch cannot be empty!");

	        PreparedStatement ps =
	            con.prepareStatement("INSERT INTO student VALUES(?,?,?,?,?)");

	        ps.setInt(1, eno);
	        ps.setString(2, name);
	        ps.setDouble(3, per);
	        ps.setString(4, sem);
	        ps.setString(5, branch);

	        ps.executeUpdate();
	        System.out.println("Student Added Successfully!");
	          
	}

	@Override
	public void displayAll() throws Exception {
		Connection con = DBconnection.getConnection();
        ResultSet rs = con.createStatement()
                .executeQuery("SELECT * FROM student");

        System.out.println("\n--- Student List ---");
        while (rs.next()) {
            System.out.println(
                rs.getInt(1) + " | " +
                rs.getString(2) + " | " +
                rs.getDouble(3) + " | " +
                rs.getString(4) + " | " +
                rs.getString(5)
            );
        }
		
	}

	@Override
	public void searchByEno() throws Exception {
		 System.out.print("Enter Eno: ");
	        int eno = sc.nextInt();

	        Connection con = DBconnection.getConnection();
	        PreparedStatement ps =
	            con.prepareStatement("SELECT * FROM student WHERE eno=?");

	        ps.setInt(1, eno);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next())
	            System.out.println("Found: " + rs.getString("name"));
	        else
	            System.out.println("Student not found!");
		
	}

	@Override
	public void updateBranch() throws Exception {
		 System.out.print("Enter Eno: ");
	        int eno = sc.nextInt();

	        System.out.print("New Branch: ");
	        String branch = sc.next();

	        Connection con = DBconnection.getConnection();
	        PreparedStatement ps =
	            con.prepareStatement("UPDATE student SET branch=? WHERE eno=?");

	        ps.setString(1, branch);
	        ps.setInt(2, eno);

	        if (ps.executeUpdate() > 0)
	            System.out.println("Branch Updated!");
	        else
	            System.out.println("Student not found!");
		
	}

	@Override
	public void deleteByEno() throws Exception {
		System.out.print("Enter Eno: ");
        int eno = sc.nextInt();

        Connection con = DBconnection.getConnection();
        PreparedStatement ps =
            con.prepareStatement("DELETE FROM student WHERE eno=?");

        ps.setInt(1, eno);

        if (ps.executeUpdate() > 0)
            System.out.println("Student Deleted!");
        else
            System.out.println("Student not found!");
		
	}

	@Override
	public void displaySorted() throws Exception {

		Connection con = DBconnection.getConnection();
        ResultSet rs = con.createStatement()
                .executeQuery("SELECT * FROM student ORDER BY percentage DESC");

        System.out.println("\n--- Sorted by Percentage ---");
        while (rs.next()) {
            System.out.println(
                rs.getInt("eno") + " | " +
                rs.getString("name") + " | " +
                rs.getDouble("percentage")
            );
		
	}
}}