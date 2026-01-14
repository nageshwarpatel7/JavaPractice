package miniproject_1;

public interface BankOperation {
	void deposit(double amount);
    void withdraw(double amount) throws Exception;
    double getBalance();
    void displayAccountDetails();
}