package catan;

import javax.swing.JOptionPane;

/**
 * The default exception from which all Catan exceptions are derived.
 * 
 * @author Eddie Gurnee
 * @version 0.0.02 10/22/2013
 *
 */
public class CatanException extends Exception {
	private String message;
	private String title;
	
	public CatanException() {
		this("You've done something stupid @Catan!");
	}
	public CatanException(String message) {
		this(message, "Catan Exception");
	}
	public CatanException(String message, String title) {
		super(message);
		this.message = message;
		this.title = title;
	}
	public void displayErrMessage() {
		JOptionPane.showMessageDialog
		(null,
				message,
				title,
				JOptionPane.ERROR_MESSAGE);
	}
}