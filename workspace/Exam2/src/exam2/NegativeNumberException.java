package exam2;
/**
 * 
 * @author Eddie Gurnee
 * @version 11/11/13
 *
 */
public class NegativeNumberException extends Exception {
	
	public NegativeNumberException() {
		this("Negative Number Not Allowed!");
	}
	public NegativeNumberException(String message) {
		super(message);
	}
}