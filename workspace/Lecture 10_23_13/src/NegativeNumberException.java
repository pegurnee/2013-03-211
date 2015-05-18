/**
 * This exception is to be used if a number is negative.
 * 
 * @author Eddie Gurnee
 * @version 10/23/2013
 * @see ExtraCredit
 * 
 */
public class NegativeNumberException extends Exception {
	public NegativeNumberException() {
		this("Number is not positive.");
	}

	public NegativeNumberException(String message) {
		super(message);
	}
}