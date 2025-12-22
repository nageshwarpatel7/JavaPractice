
import java.util.Scanner;

public class BankManagementSystem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("____________________________WELCOME TO PUNJAB NATIONAL BANK OF INDIA______________________________");
		try {
            // Account Creation
            System.out.print("Enter Account Number: ");
            int accNo = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter Account Holder Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Initial Balance: ");
            double balance = sc.nextDouble();

            BankAccount account = new BankAccount(accNo, name, balance);

            int choice;
            do {
                System.out.println("\n_______________________________________________BANK MENU _______________________________________");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Balance Enquiry");
                System.out.println("4. Display Account Details");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        account.deposit(sc.nextDouble());
                        break;

                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        account.withdraw(sc.nextDouble());
                        break;

                    case 3:
                        System.out.println("Current Balance: ₹" + account.getBalance());
                        break;

                    case 4:
                        account.display();
                        break;

                    case 5:
                        System.out.println("Thank you for using Bank Management System.");
                        break;

                    default:
                        System.out.println("Invalid choice! Please select again.");
                }

            } while (choice != 5);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
	}

}


class BankAccount{
	static String bankName = "Punjab Nationl Bank Of India (PNB)";
	private int accountNumber;
	private String accountHolderName;
	private double balance;
	
	// Constructor    : call at time of objection creation directly.  
    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
    
    // Deposit method 
    public void deposit(double amount) {
    	if(amount <= 0) {
    		System.out.println("Deposit amount must be greator than 0 ! ");
    		}
    	balance+=amount;
    	System.out.println("Amount is added successfully ! ");
    }
    
    
    // Withdrwal method
    public void withdraw(double amount) {
    	if(amount < 0) {
    		System.out.println("Deposit amount must be greator than 0 ! ");
    	}
    	else if(amount > balance ) {
    		System.out.println("Insufficient Balance in Your account !");
    		 
    	}
    	else {
    	balance-=amount;
    	System.out.println(amount+" is debited from your account : "+accountNumber);
    	}
    }
    
 // Balance Enquiry
    public double getBalance() {
        return balance;
    }
    
    
    // Display Account detail
    
    public void display(){
       System.out.println("\n ________________________________ACCOUNT DETAILS_______________________________");    	
       System.out.println("Bank            :  "+bankName);
       System.out.println("Acount Number   :  "+accountNumber);
       System.out.println("Acount Holder   :  "+accountHolderName);
       System.out.println("Current Balance :  "+balance);
       
       System.out.println();
       System.out.println("____________________________________________________________________________________");
       
       System.out.println("Thank you!");
    }
    
}