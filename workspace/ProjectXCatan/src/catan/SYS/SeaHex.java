package catan.SYS;
/**
 * This class holds the methods and variables available to Sea Hexes for the Catan board.
 * 
 * @author Eddie Gurnee
 * @version 0.0.02 10/15/2013
 *
 */
public class SeaHex extends Hex {
	private boolean port;
	private boolean port3to1;
	
	public SeaHex() {
		this("no type", false, false);
	}
	public SeaHex(String type, boolean port, boolean port3to1) {
		super(type);
		if (!port) {
			this.setType("no type");
			port3to1 = false;
		} else if (port3to1) {
			this.setType("3to1");
		}
	}
	public boolean getPort() {
		return port;
	}
}