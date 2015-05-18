package catan.SYS;
/**
 * This class holds the methods and variables available to Land Hexes for the Catan board.
 * 
 * @author Eddie Gurnee
 * @version 0.0.02 10/15/2013
 *
 */
public class LandHex extends Hex {
	private int producesOn;	
	
	public LandHex() {
		this("no type", -1);		
	}
	public LandHex(String type, int producesOn) {
		super(type);
		this.producesOn = producesOn;
	}
	public int getProducesOn() {
		return producesOn;
	}
}