package miniproject_3;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        if (!Login.authenticate()) {
            System.out.println("Invalid Login!");
            return;
        }

        StudentServiceInterface service = new StudentServiceImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("""
            -----------------------------
            STUDENT MANAGEMENT SYSTEM
            -----------------------------
            1. Add Student
            2. Display All Students
            3. Search Student by Eno
            4. Update Student Branch
            5. Delete Student by Eno
            6. Display Sorted Students
            7. Exit
            -----------------------------
            """);

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            try {
                switch (ch) {
                    case 1 -> service.addStudent();
                    case 2 -> service.displayAll();
                    case 3 -> service.searchByEno();
                    case 4 -> service.updateBranch();
                    case 5 -> service.deleteByEno();
                    case 6 -> service.displaySorted();
                    case 7 -> {
                        System.out.println("Thank you!");
                        System.exit(0);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}