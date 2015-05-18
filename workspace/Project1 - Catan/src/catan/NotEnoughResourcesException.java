package catan;
/**
 * This exception is used when a player cannot afford to purchase a new piece.
 * 
 * @author Eddie Gurnee
 * @version 0.0.01 10/27/2013
 * @see CatanException
 * 
 */
public class NotEnoughResourcesException extends CatanException {
	public NotEnoughResourcesException() {
		super("You don't have enough money to afford that.");
	}
	public NotEnoughResourcesException(String pieceCannotAfford) {
		this("You cannot afford to buy a new " + pieceCannotAfford + ", sorry.", "Not Enough Resources Exception");
	}
	public NotEnoughResourcesException(String message, String title) {
		super(message, title);
	}
}