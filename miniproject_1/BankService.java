package miniproject_1;
import java.io.*;
import java.util.*;

public class BankService {
	 private static final String FILE_NAME = "accounts.dat";
	 
	// LOAD DATA FROM FILE
	 public static List<BankAccount> loadAccounts(){
		 try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))){
				 return (List<BankAccount>)ois.readObject();
		 }
		 catch (Exception e) {
			 return new ArrayList<>();
		 }
	 }
	 
	 // SAVE DATA TO FILE
	 public static void saveAccounts(List<BankAccount> accounts ) {
		 try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
			 oos.writeObject(accounts);
		 }
		 catch(Exception e) {
			 System.out.println("File Write Error");
		 }
	 }
	 
	 // FIND ACCOUNT
	 public static BankAccount findAccount(List<BankAccount> list, int accNo) {
	        for (BankAccount b : list) {
	            if (b.getAccountNumber() == accNo)
	                return b;
	        }
	        return null;
	    }
}