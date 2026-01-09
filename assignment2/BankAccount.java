package assignment2;

public class BankAccount implements BankServices , CustomerServices {
    
    private String accountHolderName;
    private String accountNumber;
    private double balance;
    
    
    public BankAccount(String accountHolderName, String accountNumber, double balance) {
    	this.accountHolderName=accountHolderName;
    	this.accountNumber=accountNumber;
    	this.balance=balance;
    }
    
    @Override
    public void deposite(int amount) throws InvalidAmountException{
    	if(amount<0) {
    		throw new InvalidAmountException("Deposite Amount Should be greator than 0. ");
    	}
    	balance=balance+amount;
    	System.out.println("₹" + amount + " deposited successfully.");
    }
    
    @Override
    public void withdraw(int amount) throws InvalidAmountException , InsufficientBalanceException{
    	if(amount<0) {
    		throw new InvalidAmountException("Withdrawl Amount Should be greator than 0. ");
    	}
    	else if(balance<=0) {
    		throw new InsufficientBalanceException("Insufficient Balance !");
    	}
    	balance-=amount;
    	 System.out.println("₹" + amount + " withdrawn successfully.");
    }
    
    @Override
    public double balanceEnquiry(){
    	return balance;
    }
    @Override
    public void displayCustomerDetails() {
    	 System.out.println("Account Holder : " + accountHolderName);
         System.out.println("Account Number : " + accountNumber);
         System.out.println("Current Balance: ₹" + balance);
    }
}