package miniproject_1;

import java.util.*;

public class BankApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<BankAccount> accounts = BankService.loadAccounts();

        int choice;
        do {
            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Enquiry");
            System.out.println("5. Display Account Details");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Account No: ");
                        int accNo = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Initial Balance: ");
                        double bal = sc.nextDouble();

                        System.out.print("1. Savings  2. Current: ");
                        int type = sc.nextInt();

                        BankAccount acc;
                        if (type == 1)
                            acc = new SavingsAccount(accNo, name, bal);
                        else
                            acc = new CurrentAccount(accNo, name, bal);

                        accounts.add(acc);
                        BankService.saveAccounts(accounts);
                        System.out.println("Account Created Successfully");
                        break;

                    case 2:
                        System.out.print("Account No: ");
                        acc = BankService.findAccount(accounts, sc.nextInt());
                        if (acc != null) {
                            System.out.print("Amount: ");
                            acc.deposit(sc.nextDouble(), "Cash");
                            BankService.saveAccounts(accounts);
                        }
                        break;

                    case 3:
                        System.out.print("Account No: ");
                        acc = BankService.findAccount(accounts, sc.nextInt());
                        if (acc != null) {
                            System.out.print("Amount: ");
                            acc.withdraw(sc.nextDouble());
                            BankService.saveAccounts(accounts);
                        }
                        break;

                    case 4:
                        System.out.print("Account No: ");
                        acc = BankService.findAccount(accounts, sc.nextInt());
                        if (acc != null)
                            System.out.println("Balance: ₹" + acc.getBalance());
                        break;

                    case 5:
                        accounts.forEach(System.out::println);
                        break;

                    case 0:
                        System.out.println("Thank You");
                        break;

                    default:
                        System.out.println("Invalid Choice");
                }
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage());
            }

        } while (choice != 0);

        sc.close();
    }
}