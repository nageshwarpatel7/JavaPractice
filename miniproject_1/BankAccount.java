package miniproject_1;
import java.io.Serializable;


public abstract class BankAccount implements BankOperation, Serializable  {
		private long accountNo;
		private String customerName;
		protected  double balance;
		
		// Create Constructor
		public BankAccount(long accountNo, String customerName, double balance) {
			this.accountNo = accountNo;
			this.customerName = customerName;
			this.balance = balance;
		}
		
		// getter method
		public long getAccountNumber(){
			return accountNo;
		}
	
		public String getholderName() {
			return customerName;
		}
		
		// method overriden 
		
		 @Override
		    public double getBalance() {
		        return balance;
		    }
		 
		 @Override
		 public void deposit(double amount) {
			 balance+=amount;
			 System.out.println("Dear User "+customerName+" deposited amount  "+amount+ "in your account "+customerName);
		 }
		 
		 // Override + OverLoading
		 public void deposit(double amount , String  mode) {
			 balance+=amount;
			 System.out.println("Mode : "+mode);
		 }
		 
		 
		 @Override
		 public void withdraw(double amount) throws Exception {
			 if(amount>balance) {
				 throw new Exception("Insufficient Balance");
			 }
			 balance-=amount;
		 }
		 
		 @Override
		    public void displayAccountDetails() {
		        System.out.println(this);
		    }


		    // Abstract method
		    public abstract void calculateInterest();
		    
		  @Override
		    public String toString() {
		        return "Account No: " + accountNo +
		               ", Name: " + customerName +
		               ", Balance: ₹" + balance;
		    }
		    
	    
}