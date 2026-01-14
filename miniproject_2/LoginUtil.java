package miniproject_2;

import java.util.Scanner;

public class LoginUtil {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "1234";

    public static boolean login() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Username: ");
        String user = sc.next();

        System.out.print("Password: ");
        String pass = sc.next();

        return user.equals(USERNAME) && pass.equals(PASSWORD);
       
    }
}