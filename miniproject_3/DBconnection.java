package miniproject_3;

import java.sql.*;

public class DBconnection {
    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/practice",
            "root",
            "1234"
        );
    }
}