package miniproject_1;

public class CurrentAccount extends BankAccount{
	 public CurrentAccount(int accNo, String name, double balance) {
	        super(accNo, name, balance);
	    }
	 
	 @Override
	 public void calculateInterest() {
		 System.out.println("No interst for current Account ");
	 }
}