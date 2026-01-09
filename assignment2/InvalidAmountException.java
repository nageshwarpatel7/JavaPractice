package assignment2;

public class InvalidAmountException extends Exception {
   
	private static final long serialVersionUID = 5921054116834693713L;

	   public InvalidAmountException(String message) {
 	   super(message);
    }
}