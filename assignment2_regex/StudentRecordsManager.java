package assignment2_regex;

import java.util.*;
import java.util.regex.*;

/*
 *  Design a Java program to manage Student Records using different ArrayList, Vector, List
	collections. The program should Add student records, Display all students, Remove a student
	by roll number, Search a student by roll number. The program should handle exceptions, use
	interface and REGEX as required.
 * 
 */
class Student{
	 	private int rollNo;
	    private String name;
	    private String email;

	    public Student(int rollNo, String name, String email) {
	        this.rollNo = rollNo;
	        this.name = name;
	        this.email = email;
	    }
	    
	    public int getRollNo() {
	        return rollNo;
	    }

	    public String toString() {
	        return "Roll No: " + rollNo + ", Name: " + name + ", Email: " + email;
	    }
	    
	 // Email validation using REGEX
	    public static boolean isValidEmail(String email) {
	       String regex = "[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+";
	       return Pattern.matches(regex, email);
	    }
	    
}



interface StudentOperations{
	void addStudent(Student student);
    void displayStudents();
    void removeStudent(int rollNo);
    void searchStudent(int rollNo);
	
}


class StudentManager implements StudentOperations{
	private List<Student> students;
	
	public StudentManager(List<Student>students) {
		this.students = students;
	}
	
	@Override
	public void addStudent(Student student) {
		students.add(student);
		System.out.println("Student Added Successfully! ");
	}
	
	@Override
	public void displayStudents(){
		if(students.isEmpty()) {
			System.out.println("List is Empty! No records ");
			return;
		}
		for (Student s : students) {
			System.out.println(s);
		}
	}
	
	@Override
	public void removeStudent(int rollNo) {
		boolean found  =  false;
		 Iterator<Student> it = students.iterator();
		 while(it.hasNext()) {
			 if(it.next().getRollNo() == rollNo) {
				 it.remove();
				 found = true;
				 System.out.print("Remove successfully : ");
				 break;
			 }
			 
			 if(!found) {
				 System.out.println("Student not fpound");
			 }
		 }
	}
	
	@Override
	public void searchStudent(int rollNo) {
		if(students.isEmpty()) {
			System.out.println("Empty Records !");
		}
		
		for(Student s : students) {
			if(s.getRollNo()==rollNo) {
				System.out.println(s);
				return;
			}
		}
		System.out.println("Record Not Found !");
		
	}
	
}
public class StudentRecordsManager {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		List<Student> collection = null;

		System.out.println("************************************************WELCOME TO STUDENT RECORDS************************************************ ");
		System.out.println("Press key for Operation : ");
		System.out.println("ArrayList   :  Press 1 ");
		System.out.println("Vector      :  Press 2 ");
		System.out.println("List        :  Press 3 ");
		System.out.println("3. List (LinkedList)");
		int type = sc.nextInt();
		
		switch(type) {
		case 1: collection = new ArrayList<>();
		break;
		
		case 2: collection = new Vector<>();
		break;
		
		case 3: collection = new LinkedList<>();
	    break;
	    
	    default:
	    	System.out.println("Invalid Output");
	    	//System.exit(0);
	    	return;
		}
		
		StudentManager manager = new StudentManager(collection);
		
		int choice ;
		do {
			 System.out.println("\n 1. Add Student");
	            System.out.println("2. Display Students");
	            System.out.println("3. Remove Student");
	            System.out.println("4. Search Student");
	            System.out.println("0. Exit");
	            System.out.print("Enter choice: ");

	            choice = sc.nextInt();
	            
	            try {
	            	
	            	switch(choice) {
	            	case 1:
	            		 System.out.print("Enter Roll No: ");
	                        int roll = sc.nextInt();
	                        sc.nextLine();

	                        System.out.print("Enter Name: ");
	                        String name = sc.nextLine();

	                        System.out.print("Enter Email: ");
	                        String email = sc.nextLine();
	                        
	                        if(!Student.isValidEmail(email)) throw new IllegalArgumentException("Invalid Email formate");
	                        
	                        manager.addStudent(new Student(roll,name,email));
	                        break;
	                        
	            	case 2:
	            		manager.displayStudents();
	            		break;
	            		
	            	case 3:
	            		System.out.println("Enter roll no to remove records : ");
	            		manager.removeStudent(sc.nextInt());
	            		break;
	            		
	            	case 4:
	            		System.out.println("Enter roll to Search ");
	            		manager.searchStudent(sc.nextInt());
	            		break;
	            		
	            	default:
                        System.out.println("Invalid Option");
	            		
	            	}
	            }
	            catch (Exception e) {
	                System.out.println(" Error: " + e.getMessage());
	            }
	            

		}while(choice !=0);
		
		sc.close();

	}

}