package catan;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 * This class holds methods and variables available to robbers.
 * 
 * @author Eddie Gurnee
 * @version 0.0.02 10/28/2013
 *
 */

public class Robber extends JPanel {
	private boolean placed;
	private final int WIDTH = 50;
	private final int HEIGHT = 50;	

	private int rowPlaced;
	private int colPlaced;

	private LandHex theCurrentLocation;

	public Robber() {
		super();
		setSize(WIDTH, HEIGHT);
		setOpaque(false);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.BLACK);		
		g.fillOval(0, 0, WIDTH, HEIGHT);
	}
	public boolean isPlaced() {
		return placed;
	}
	public void setPlaced(boolean placed) {
		this.placed = placed;
	}
	public int getColPlaced() {
		return colPlaced;
	}
	public int getRowPlaced() {
		return rowPlaced;
	}
	public void setRowAndColPlaced(int rowPlaced, int colPlaced) {
		this.rowPlaced = rowPlaced;
		this.colPlaced = colPlaced;
	}
	public void unPlace() {
		this.placed = false;
		theCurrentLocation.remove(this);
		theCurrentLocation.setProduces(true);
		BoardGame.board.repaint();
	}
	public void place(LandHex location) {
		this.placed = true;
		this.theCurrentLocation = location;
		location.setProduces(false);
		this.setRowAndColPlaced(location.getRow(), location.getCol());
		location.add(this);
		this.setBounds(
				((location.getWidth() - this.getWidth()) / 2),
				((location.getHeight() - this.getHeight()) / 2),
				this.getWidth(),
				this.getHeight());
		this.setVisible(true);
		BoardGame.board.repaint();

		//stealing on robber placement, will add later
//		if (location.getProperties().size() != 0) {
//			Player[] effectedPlayers = new Player[location.getProperties().size()];
//
//			for (int i = 0; i < effectedPlayers.length; i++) {
//				effectedPlayers[i] = location.getProperties().get(i).getOwner();
//			}
//
//			int i = (int)JOptionPane.showOptionDialog
//					(null,
//							"Which Player would you like to steal from?",
//							"Steal from Player",
//							JOptionPane.YES_NO_OPTION,
//							JOptionPane.PLAIN_MESSAGE,
//							null,
//							effectedPlayers,
//							effectedPlayers[0]);
//			
//		}
	}
}