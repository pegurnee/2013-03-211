package catan;
/**
 * This exception is used when a player attempts to place an connected
 * 
 * @author Eddie Gurnee
 * @version 0.0.01 10/24/2013
 * @see CatanException
 *
 */
public class NoConnectionException extends CatanException {
	
	public NoConnectionException() {
		super("Your piece would not be connected to anything.");
	}
	public NoConnectionException(String unconnectedPiece) {
		this("Your " + unconnectedPiece + " needs to be connected to one of your trade routes.", "No Connected Road Exception");		
	}
	public NoConnectionException(String message, String title) {
		super(message, title);		
	}
}