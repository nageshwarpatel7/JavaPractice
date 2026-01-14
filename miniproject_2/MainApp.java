package miniproject_2;

import java.util.Scanner;
/*
Username: admin
Password: 1234
 */
public class MainApp {

    public static void main(String[] args) {

        if (!LoginUtil.login()) {
            System.out.println("X Access Denied! X");
            return;
        }

        EmployeeService service = new EmployeeService();
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n********************===== Employee Management System =====********************");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Display Sorted Employees");
            System.out.println("7. Display Departments");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            while (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                sc.next();
            }
            choice = sc.nextInt();

            switch (choice) {

                case 1 -> {
                    try {
                        System.out.print("ID: ");
                        int id = sc.nextInt();

                        System.out.print("Name: ");
                        String name = sc.next();

                        System.out.print("Salary: ");
                        double salary = sc.nextDouble();

                        System.out.print("Department: ");
                        String dept = sc.nextLine();

                        service.addEmployee(new Employee(id, name, salary, dept));

                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                case 2 -> service.displayEmployees();

                case 3 -> {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    Employee e = service.searchEmployee(id);
                    if (e != null)
                        System.out.println("Found: " + e.getName());
                    else
                        System.out.println("Employee Not Found!");
                }

                case 4 -> {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    System.out.print("New Salary: ");
                    double sal = sc.nextDouble();

                    if (service.updateSalary(id, sal))
                        System.out.println("Salary Updated!");
                    else
                        System.out.println("Update Failed!");
                }

                case 5 -> {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    if (service.deleteEmployee(id))
                        System.out.println("Employee Deleted!");
                    else
                        System.out.println("Employee Not Found!");
                }

                case 6 -> service.sortEmployees();

                case 7 -> service.displayDepartments();

                case 8 -> System.out.println("System Exited.");

                default -> System.out.println("Invalid Choice!");
            }

        } while (choice != 8);
    }
}