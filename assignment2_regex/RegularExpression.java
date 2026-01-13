package assignment2_regex;

import java.util.regex.*;
import java.util.Scanner;
/*
 * The program should have following menu
1. Validate Mobile Number
2. Validate Email ID
3. Validate Username
4. Validate Password
5. Exit.
After validation a simple welcome message displayed and if validation failed then invalid
input message should displayed. The program should handle exceptions as required.
 */
class ValidateFunction{
	
	// 1. Check for valid mobile number
	void validMobileNumber(String num) {
		Pattern p = Pattern.compile("^(0|91)?[6-9][0-9]{9}");
		Matcher m = p.matcher(num);
		if(m.find() && m.group().equals(num)) {
			System.out.println("Valid Number");
		}
		else {
			System.out.println("Not a valid Number");
		}
	}
	
   // 2. Validate Email ID
	void vaildEmail(String gmail) {
		Pattern p = Pattern.compile("[a-zA-Z][a-zA-Z0-9._]*@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+");
		Matcher m = p.matcher(gmail);
		if(m.matches()) {
			System.out.println("Valid Email ");
		}
		else {
			System.out.println("Not a valid Email!");
		}
	}
	
   // 3. Validate Username
	void vaildUserName(String name){
		Pattern p = Pattern.compile("[a-zA-Z][a-zA-Z0-9_]{4,14}");
		Matcher m = p.matcher(name);
		if(m.matches()){
			System.out.println("Valid username ");
		}
		else {
			System.out.println("Not a valid username ");
		}
	}
	
	// 4. validate password
	/*
     Minimum 8 characters
	 At least 1 uppercase letter
	 At least 1 lowercase letter
	 At least 1 digit
	 At least 1 special character (@#$%!^&*)
	 No spaces
	 */
	void vaildPassword(String password){
		Pattern p = Pattern.compile("^(?=.*[A-za-z])(?=.*\\d)[A-Za-z\\d@#$%*^]{8,36}$");
		Matcher m = p.matcher(password);
		if(m.matches()) {
			System.out.println("Password is Strong ");
		}
		else {
			System.out.println("password is week");
		}
	}
	
}



public class RegularExpression {
	static Scanner sc = new Scanner(System.in);
    static int input;
	public static void main(String[] args) throws Exception{
		ValidateFunction v = new ValidateFunction();
        		
		do {
		System.out.println("                                                   WELCOME TO CHECKING PLATEFORM                                                       ");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Please select option for cheacking  ");

		System.out.println("1. Check valid Mobile Number   :   press 1   ");
		System.out.println("2. Check valid E-mial Id       :   press 2   ");
		System.out.println("3. Check valid Username        :   press 3   ");
		System.out.println("4. Check valid password        :   press 4   ");
		System.out.println("5. Exit                        :   press 5   ");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.print("Please press the option :  ");
		 input = Integer.parseInt(sc.nextLine());
		
		 
		 
		 switch(input){
	        case 1:
	            System.out.print("\nEnter the Mobile Number: ");
	            String number = sc.nextLine();
	            v.validMobileNumber(number);
	            break;

	        case 2:
	            System.out.print("\nEnter the Email ID: ");
	            String email = sc.nextLine();
	            v.vaildEmail(email);
	            break;

	        case 3:
	            System.out.print("\nEnter the Username: ");
	            String name = sc.nextLine();
	            v.vaildUserName(name);
	            break;

	        case 4:
	            System.out.print("\nEnter the Password: ");
	            String password = sc.nextLine();
	            v.vaildPassword(password);
	            break;

	        case 5:
	            System.out.println("Exiting program...");
	            break;

	        default:
	            System.out.println("Invalid input!");
	        }
		}while(input!=5);
        
        
       
	}
	

}