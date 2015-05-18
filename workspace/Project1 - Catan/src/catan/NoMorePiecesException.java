package catan;
/**
 * This exception is used when a player is out of a specific piece.
 * 
 * @author Eddie Gurnee
 * @version 0.0.01 10/23/2013
 * @see CatanException
 * 
 */
public class NoMorePiecesException extends CatanException {	
	public NoMorePiecesException() {
		super("You've got no more of that piece");
	}
	public NoMorePiecesException(String pieceOutOf) {
		this("You are all out of " + pieceOutOf + ".", "No More Pieces Exception");
	}
	public NoMorePiecesException(String message, String title) {
		super(message, title);
	}
}