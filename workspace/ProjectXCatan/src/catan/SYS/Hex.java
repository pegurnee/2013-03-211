package catan.SYS;
/**
 * This class holds methods and variables associated with the hexes used to create the board in Catan.
 * 
 * @author Eddie Gurnee
 * @version 0.0.02 10/15/2013
 *
 */
public class Hex {
	private Player[] owners = new Player[3];
	private String type;
	
	public Hex() {
		this("no type");
	}
	public Hex(String type) {
		this.type = type;
	}	
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public boolean equals(Object otherObject) {
		
		return true;
	}
}