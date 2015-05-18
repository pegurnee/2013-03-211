package catan;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
/**
 * This class holds the methods and variables available to Land Hexes for the Catan board.
 * Contains a built in GUI, unusable without the user interface.
 * 
 * @author Eddie Gurnee
 * @author Nicole Downer
 * @version 0.0.08 10/28/2013
 *
 */
public class LandHex extends Hex {
	/**
	 * This class holds the methods and variables available to the number tokens on Land Hexes for the Catan board.
	 * 
	 * @author Eddie Gurnee
	 * @version 0.0.05 10/22/2013
	 *
	 */
	private class NumberToken extends BoardSpace {
		private String theNum;

		private final int HEIGHT = 30;
		private final int WIDTH = 30;

		private NumberToken (int numProduces) {
			super();			
			setSize(WIDTH, HEIGHT);

			this.theNum = "" + numProduces;
		}
		@Override
		public void onLanding() {
			BoardGame.board.theRobber.place(LandHex.this);			
		}
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(new Color(223, 180, 160));
			g.fillOval(0, 0, WIDTH, HEIGHT);

			g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
			g.setColor(Color.BLACK);
			g.drawString(theNum, 10, 20);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!BoardGame.board.theRobber.isPlaced()) {
				this.onLanding();
			}
		}
	}

	private int produceOn;
	private boolean produces;
	private int resource;
	private Color bgColor;
	private NumberToken numObject;

	public LandHex(String type, int produceOn) {
		super(type);
		this.produceOn = produceOn;
		this.produces = true;

		this.numObject = new NumberToken(produceOn);

		numObject.setBounds(
				((this.getWidth() - numObject.getWidth()) / 2),
				((this.getHeight() - numObject.getHeight()) / 2),
				numObject.getWidth(),
				numObject.getHeight());

		this.add(numObject);

		switch(type) {
		case "Wood":
			bgColor = new Color(150, 111, 51);
			setResource(0);
			break;
		case "Sheep":
			bgColor = new Color(102, 166, 102);
			setResource(1);
			break;
		case "Wheat":
			bgColor = new Color(245, 222, 179);
			setResource(2);
			break;
		case "Ore":
			bgColor = new Color(212, 215, 217);
			setResource(3);
			break;
		case "Brick":
			bgColor = new Color(142, 35, 35);
			setResource(4);
			break;
		case "Desert":
			bgColor = new Color(254, 232, 214);
			this.remove(numObject);			
			break;
		}
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(bgColor);		
		g.fillPolygon(this.getHex());
	}
	public boolean isProduces() {
		return produces;
	}
	public void setProduces(boolean produces) {
		this.produces = produces;
	}
	public void produce() {
		if (produces) {
			for (Properties a : this.getProperties()) {
				a.getOwner().addTempResource(resource, a.getValue());
			}
		}
	}
	public int getProduceOn() {
		return produceOn;
	}
	public int getResource() {
		return resource;
	}
	private void setResource(int resource) {
		this.resource = resource;
	}
}