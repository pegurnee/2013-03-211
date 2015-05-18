package catan;

import java.awt.Color;
import java.awt.Graphics;
/**
 * This class holds the methods and variables available to Sea Hexes for the Catan board.
 * Contains a built in GUI, unusable without the user interface.
 * 
 * @author Eddie Gurnee
 * @version 0.0.03 10/16/2013
 *
 */
public class SeaHex extends Hex {

	private boolean port;
//	private boolean port3to1;
	
	public SeaHex() {
		this("no type");
	}
	public SeaHex(String type) {
		super(type);
		
		if (getType().equals("no type")) {
			port = false;
		} else {
			port = true;
//			port3to1 = false;
		}
	}
	
	public boolean isPort() {
		return port;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(new Color(28, 107, 160));
		g.fillPolygon(this.getHex());
		
		if (port) {
			
		}
	}
}