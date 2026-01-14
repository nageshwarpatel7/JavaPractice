package miniproject_2;

import java.util.*;

public class EmployeeService {

    private ArrayList<Employee> employees;

    public EmployeeService() {
        employees = FileUtil.loadEmployees();
    }

    public void addEmployee(Employee emp) throws Exception {

        for (Employee e : employees) {
            if (e.getId() == emp.getId()) {
                throw new Exception("Employee ID must be unique!");
            }
        }

        if (emp.getSalary() <= 0) {
            throw new Exception("Salary must be positive!");
        }

        if (emp.getDepartment().isEmpty()) {
            throw new Exception("Department cannot be empty!");
        }

        employees.add(emp);
        FileUtil.saveEmployees(employees);
        System.out.println("Employee Added Successfully!");
    }

    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No Records Found!");
            return;
        }

        for (Employee e : employees) {
            System.out.println(e.getId() + " | " + e.getName()
                    + " | " + e.getSalary()
                    + " | " + e.getDepartment());
        }
    }

    public Employee searchEmployee(int id) {
        for (Employee e : employees) {
            if (e.getId() == id) return e;
        }
        return null;
    }

    public boolean updateSalary(int id, double salary) {

        if (salary <= 0) {
            System.out.println("Salary must be po sitive!");
            return false;
        }

        for (Employee e : employees) {
            if (e.getId() == id) {
                e.setSalary(salary);
                FileUtil.saveEmployees(employees);
                return true;
            }
        }
        return false;
    }

    public boolean deleteEmployee(int id) {

        Iterator<Employee> it = employees.iterator();

        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.remove();
                FileUtil.saveEmployees(employees);
                return true;
            }
        }
        return false;
    }

    public void sortEmployees() {
        employees.sort(Comparator.comparingInt(Employee::getId));
        displayEmployees();
    }

    public void displayDepartments() {
        HashSet<String> depts = new HashSet<>();

        for (Employee e : employees) {
            depts.add(e.getDepartment());
        }

        System.out.println("Departmenits:");
        for (String d : depts) {
            System.out.println("- " + d);
        }
    }
}