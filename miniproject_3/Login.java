package miniproject_3;

import java.sql.*;
import java.util.Scanner;

public class Login {
    public static boolean authenticate() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Username: ");
            String u = sc.nextLine();
            System.out.print("Password: ");
            String p = sc.next();

            Connection con = DBconnection.getConnection();
            PreparedStatement ps =
                con.prepareStatement("SELECT * FROM student WHERE name=? AND roll_no=?");

            ps.setString(1, u);
            ps.setString(2, p);

            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (Exception e) {
            System.out.println("Login Error: " + e.getMessage());
            return false;
        }
    }
}