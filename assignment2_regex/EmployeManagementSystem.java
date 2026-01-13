package assignment2_regex;

import java.util.regex.*;
import java.util.*;

// Interface  : Operation to be performed
interface EmployeeOperations {
    void addEmployee(Integer id, Employee emp);
    void displayEmployees();
    void searchEmployee(Integer id);
    void removeEmployee(Integer id);
}


// Employee Class blueprint
class Employee{
	private int id;
	private String name;
	private String email;
	private String department;
	
	
	Employee(int id, String name,String email,String department){
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
	}
	
	public int getEmpId(){
		return id;
	}
	
	 public static boolean isValidEmail(String email) {
	        String regex = "[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+";
	        return Pattern.matches(regex, email);
	    }
	 
	 @Override
	    public String toString() {
	        return "Employee ID: " + id +
	               ", Name: " + name +
	               ", Email: " + email+
	               ", Department: "+department;
	    }
}

class ManageOperation implements EmployeeOperations{
	
	// Create Collection 
	private Map<Integer,Employee>map;
	
	// Constructor
	public ManageOperation(Map<Integer,Employee> map) {
		this.map = map;
	}
	
	// Override all interface method
	
	@Override
	public void addEmployee(Integer id, Employee emp) {
		map.put(id, emp);
		System.out.println("Employee added");
	}
	
	
	@Override
	public void displayEmployees() {
		if(map.isEmpty()) {
			System.out.println("Record book is Empty!");
			return;
		}
		
		map.forEach((k,V) ->  System.out.println(k + " => " + V));
	}
	
	@Override
	public void searchEmployee(Integer id) {
		
		if(map.containsKey(id)){
			System.out.println(" Employee Found: "+map.get(id));
		}
		else if(map.isEmpty()) {
			System.out.println("Record book is Emppty !");
			return;
		}
		else {
			System.out.println("Record Not Found! ");
		}
	}
	
	@Override
	public void removeEmployee(Integer id) {
		if(map.remove(id)!=null) {
			System.out.println("Employee Removed");
		}
		else {
			System.out.println("Employee Not Found !~ ");
		}
	}
	
}

public class EmployeManagementSystem {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        Map<Integer, Employee> map = null;
	        
	        System.out.println("===== EMPLOYEE RECORD SYSTEM =====");
	        System.out.println("1. HashMap");
	        System.out.println("2. Hashtable");
	        System.out.println("3. TreeMap");
	        System.out.print("Choose Map Type: ");

	        int type = sc.nextInt();
	        
	        switch (type) {
            case 1:
                map = new HashMap<>();
                System.out.println(" HashMap Selected");
                System.out.println("Supports ONE null key & MULTIPLE null values");
                break;

            case 2:
                map = new Hashtable<>();
                System.out.println(" Hashtable Selected");
                System.out.println("Does NOT support null key or null value");
                break;

            case 3:
                map = new TreeMap<>();
                System.out.println(" TreeMap Selected");
                System.out.println("Does NOT support null key");
                break;

            default:
                System.out.println("Invalid Choice");
                System.exit(0);
        }
	        
	        ManageOperation manager = new ManageOperation(map);
	        
	        int choice;
	        do {
	            System.out.println("\n1. Add Employee");
	            System.out.println("2. Display Employees");
	            System.out.println("3. Search Employee");
	            System.out.println("4. Remove Employee");
	            System.out.println("5. Demonstrate Null Support");
	            System.out.println("0. Exit");
	            System.out.print("Enter choice: ");

	            choice = sc.nextInt();
	            
	            try {
	            	switch(choice) {
	            	
	            	case 1:
	            			System.out.println("Enter Employee Id : ");
	            		    int id = sc.nextInt();
	            		    sc.nextLine();
	            		    
	            		    System.out.print("Enter Name: ");
	                        String name = sc.nextLine();

	                        System.out.print("Enter Email: ");
	                        String email = sc.nextLine();
	                        if(!Employee.isValidEmail(email)) {
	                        	throw new IllegalArgumentException("Invalid Email ");
	                        }
	                        System.out.println("Enter Department: ");
	                        String department = sc.nextLine();
	                        
	                        manager.addEmployee(id,new Employee(id,name,email,department));
	                        break;
	            	case 2:
	            		manager.displayEmployees();
	            		break;
	            	
	            	case 3:
	            		System.out.println("Enter the id to search Employee :  ");
	            		int sId = sc.nextInt();
	            		manager.searchEmployee(sId);
	            		break;
	            		
	            	case 4:
	            		System.out.println("Enter Employee Id to Remove: ");
	            		int rId = sc.nextInt();
	            		manager.removeEmployee(rId);
	                    break;
	                  
	            	case 5:
	            		 System.out.println("---- Null Support Demo ----");
	            		 try {
	                            map.put(null, null);
	                            System.out.println("Null key/value inserted successfully");
	                        } catch (Exception e) {
	                            System.out.println("❌ Null not supported: " + e);
	                        }
	                        break;
	                        
	            	case 0:
	            		 System.out.println("Program Terminated");
	                        break;

	            	default:
	                        System.out.println("Invalid Option");
	            	}
	            }	
	            	catch (Exception e) {
	                    System.out.println(" Error: " + e.getMessage());
	                }
	            } while (choice != 0);

	        sc.close();
	     
	        
	}

}