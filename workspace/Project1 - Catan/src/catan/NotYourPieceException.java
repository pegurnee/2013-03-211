package catan;
/**
 * This exception is for players attempting to use other players pieces.
 * 
 * @author Eddie Gurnee
 * @version 0.0.01 10/23/2013
 *
 */
public class NotYourPieceException extends CatanException {

	public NotYourPieceException() {
		this("That's not your piece.");
	}

	public NotYourPieceException(String message) {
		super(message, "Not Your Piece Exception");
	}
	
	public NotYourPieceException(Player activePlayer, Properties theProperty) {
		super(
				(activePlayer.getName() 
					+ " that " + theProperty.getType() 
					+ " does not belong to you.\nIt belongs to " 
					+ theProperty.getOwner().getName() + "."),
				"Not Your Piece Exception");
	}	
}