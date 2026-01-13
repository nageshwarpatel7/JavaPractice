package assignment1;
import java.util.*;


/* A class sixth student required to solve basic mathematics problems. For this he
 *  she needs to
perform operations such as addition, subtraction, multiplication, division, remainder,
square,
cube, and absolute. Write a program using methods to perform these basic operations. */
public class MathOperations {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Which operation do you wants to perform: ");
			System.out.println("1. Addition, 2.Subtraction, 3.multiplication, 4.division, 5.remainder, 6.square, 7.cube, 8.absolute, 0.Exit");
			System.out.print("Enter your choice (1,2,3,4,5,6,7,8,0): ");
			int choice = sc.nextInt();
			if(choice==0) {
				System.out.println("Exited sucessfully!");
				break;
				}
			System.out.print("Enter operand 1: ");
			int  a = sc.nextInt();
			int b=0;
			if(choice!=6 || choice!=7) {
				System.out.println("Enter operand 2: ");
				b= sc.nextInt();
			}
			
			
			if(choice==1)
				System.out.println(add(a,b));
			else if(choice==2)
				System.out.println(subtract(a,b));
			else if(choice==3)
				System.out.println(mul(a,b));
			else if(choice==4)
				division(a,b);
			else if(choice==5)
				rem(a,b);
			else if(choice==6)
				System.out.println(square(a));
			else if(choice==7)
				System.out.println(cube(a));
			else if(choice==8)
				System.out.println(absolute(a,b));
			else
				System.out.println("Invalid choice!");
			
		}
	}
	public static int add(int a,int b ) {
		return a+b;
	}
	public static int subtract(int a,int b ) {
		return a-b;
	}
	public static int mul(int a,int b ) {
		return a*b;
	}
	public static void division(int a,int b ) {
		try {
			System.out.println(a/b);
		}
		catch(Exception e) {
			System.out.println("Cannot divide by zero "+e);
			
		}
	}
	public static void rem(int a,int b ) {
		try {
		 System.out.println(a%b);}
		catch(Exception e) {
			System.out.println("Exception occured "+e);
		}
	}
	public static int square(int a) {
		return a*a;
	}
	public static int cube(int a) {
		return a*a*a;
	}
	public static int absolute(int a,int b ) {
		return ((a-b)>=0)?(a-b):(b-a);
	}
}

