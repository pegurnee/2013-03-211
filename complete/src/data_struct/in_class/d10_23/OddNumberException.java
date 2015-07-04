package data_struct.in_class.d10_23;
/**
 * This exception is to be used if a number is odd.
 * 
 * @author Eddie Gurnee
 * @version 10/23/2013
 * @see ExtraCredit
 * 
 */
public class OddNumberException extends Exception {
	public OddNumberException() {
		this("Number is not even.");
	}

	public OddNumberException(String message) {
		super(message);
	}
}