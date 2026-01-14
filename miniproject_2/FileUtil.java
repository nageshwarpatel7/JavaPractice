package miniproject_2;

import java.io.*;
import java.util.*;

// fil;e  handling code


public class FileUtil {

    private static final String FILE_NAME = "employees.txt";

    public static ArrayList<Employee> loadEmployees() {
        ArrayList<Employee> list = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(Employee.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("File Read Error!");
        }

        return list;
    }

    public static void saveEmployees(List<Employee> list) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Employee e : list) {
                pw.println(e);
            }
        } catch (IOException e) {
            System.out.println("File Write Error!");
        }
    }
}