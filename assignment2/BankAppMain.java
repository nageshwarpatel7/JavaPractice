package assignment2;

import java.util.*;

public class BankAppMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter account holder name: ");
		String accountHolderName = sc.nextLine();
		
		System.out.print("Enter account number: ");
		String accountNumber = sc.nextLine();
		
		System.out.println("Enter intial deposite amount (minimum 2500): ");
		double balance = sc.nextDouble();

		BankAccount account = new BankAccount(accountHolderName,accountNumber,balance);
		try {
            account.displayCustomerDetails();
            System.out.println();

            account.deposite(2000);
            System.out.println("Current Balance: ₹" + account.balanceEnquiry());

            account.withdraw(3000);
            System.out.println("Remaining Balance: ₹" + account.balanceEnquiry());

        } catch (InvalidAmountException | InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nThank you for banking with us!");
		

	}

}