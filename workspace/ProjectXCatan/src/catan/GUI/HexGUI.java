package catan.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import catan.SYS.Hex;
import catan.SYS.LandHex;
import catan.SYS.Player;
import catan.SYS.SeaHex;
/**
 * The GUI for an individual hexagonal space
 * 
 * @author Eddie Gurnee
 * @version 00.00.15 10/15/2013
 * @see CatanFrame
 * @see HexBoard
 * 
 */

public class HexGUI extends JPanel implements MouseListener {
	
	private final int WIDTH = 100;
	private final int HEIGHT = 100;

	private final int[] XPOINTS = {
			WIDTH / 2,
			WIDTH,
			WIDTH,
			WIDTH / 2,
			0,
			0,
	};
	private final int[] YPOINTS = {
			0,
			HEIGHT / 4,
			(3 * HEIGHT) / 4,
			HEIGHT,
			(3 * HEIGHT) / 4,
			HEIGHT / 4,
	};
	private final Polygon HEX = new Polygon (XPOINTS, YPOINTS, 6);
	
	private String produceNum;
	private String type;
	private Class<? extends Hex> theClass;	
	
	public HexGUI(Hex theHex) {
		super();
		setSize(WIDTH, HEIGHT);
		
		//if it is a button, need these three methods:
//		setContentAreaFilled(false);
//		setFocusPainted(false);
//		setBorderPainted(true);
		
		//if it is a panel, need this method:
		setOpaque(false);
		setLayout(null);
		
		//discovers what class (either sea or land) the hex is
		this.theClass = theHex.getClass();
		//discovers what type the resource or port is
		this.type = theHex.getType();
		
		if (theClass == LandHex.class) {
			produceNum = "" + ((LandHex)theHex).getProducesOn();
		}
		
		addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (!(HEX.contains(e.getX(), e.getY()))) {
			((JLayeredPane)getParent()).moveToBack(this);
		} else {
			System.out.println("What a twist! " + type + "\nLayer: " + JLayeredPane.getLayer(this));
		}
	}
	
	//methods needed to implement the mouse listener class
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (theClass == SeaHex.class) {
			g.setColor(new Color(28, 107, 160));
		} else if (theClass == LandHex.class) {
			if (type.equals("Sheep")) {
				g.setColor(new Color(102, 166, 102));
			} else if (type.equals("Wood")) {
				g.setColor(new Color(150, 111, 51));
			} else if (type.equals("Wheat")) {
				g.setColor(new Color(245, 222, 179));
			} else if (type.equals("Brick")) {
				g.setColor(new Color(142, 35, 35));
			} else if (type.equals("Ore")) {
				g.setColor(new Color(212, 215, 217));
			} else if (type.equals("Desert")) {
				g.setColor(new Color(254, 232, 214));
			}
		} else {
			System.out.println("Don't do this please i'm so sorry");
		}
		
		g.fillPolygon(HEX);
		
		if (theClass == LandHex.class) {
			g.setColor(new Color(255, 255, 255));
			g.fillOval(35, 35, 30, 30);
			
			g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
			g.setColor(new Color(0, 0, 0));
			g.drawString(produceNum, 45, 53);
		}
	}
}
