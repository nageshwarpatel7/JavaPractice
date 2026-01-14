package miniproject_2;

import java.io.Serializable;

public class Employee implements Serializable {

    private int id;
    private String name;
    private double salary;
    private String department;

    public Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + salary + "," + department;
    }

    public static Employee fromString(String line) {
        String[] parts = line.split(",");
        return new Employee(
                Integer.parseInt(parts[0]),
                parts[1],
                Double.parseDouble(parts[2]),
                parts[3]
        );
    }
}