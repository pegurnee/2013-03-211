package catan;
/**
 * This exception is used when the bank is out of Dev Cards.
 * 
 * @author Eddie Gurnee
 * @version 0.0.01 10/28/2013
 * @see CatanException
 * 
 */
public class NotEnoughCardsException extends CatanException {
	public NotEnoughCardsException() {
		super("There are no more cards available.");
	}
	public NotEnoughCardsException(String cardType) {
		this("There are no more " + cardType + " cards available", "Not Enough Cards Exception");
	}
	public NotEnoughCardsException(String message, String title) {
		super(message, title);
	}
}