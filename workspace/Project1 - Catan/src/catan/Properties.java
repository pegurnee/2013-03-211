package catan;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
/**
 * 
 * @author Eddie Gurnee
 * @author Nicole Downer
 * @version 0.0.10 10/22/2013
 * @see Piece
 * @see Player
 *
 */
public class Properties extends Piece implements ActionListener {
	private boolean city;	
	private int victoryPoints;
	private int value;
	private String type;
	
	private final int WIDTH = 20;
	private final int HEIGHT = 20;
	
	public Properties(Player owner) {
		super(owner);
		setSize(WIDTH, HEIGHT);
		
		this.city = false;
		this.setType("Settlement");
		this.setCost(1, 1, 1, 0, 1);
		this.setVictoryPoints(1);
		this.value = 1;
		
		addActionListener(this);
	}
	private void setVictoryPoints(int victoryPoints) {
		this.victoryPoints = victoryPoints;		
	}
	public void actionPerformed(ActionEvent e) {
		try {
			if (!(this.getOwner().equals(BoardGame.getActivePlayer()))) {
				throw new NotYourPieceException(BoardGame.getActivePlayer(), this);
			}
			
			if (!city) {
				int n = JOptionPane.showConfirmDialog
						(null,
								"Would you like to place a City?",
								"Place City",
								JOptionPane.YES_NO_OPTION
								);
				if (n == 0) {
					try {
						if (!BoardGame.getActivePlayer().isRemainingCities()) {
							throw new NoMorePiecesException("Cities");
						}
						if (BoardGame.getActivePlayer().isEnoughMoney(this.cost)) {
							throw new NotEnoughResourcesException("City");
						}
						
						this.city = true;
						this.value = 2;
						this.setVictoryPoints(2);
						this.setType("City");
						this.setCost(0, 2, 0, 3, 0);
						this.setFocusPainted(false);
						
						BoardGame.getActivePlayer().buyPiece(this);
					} catch (NoMorePiecesException|NotEnoughResourcesException ex) {
						ex.displayErrMessage();
					}					
				}
			}
		} catch (NotYourPieceException ex) {
			ex.displayErrMessage();
		}
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(this.getOwner().getColor());
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		if (this.getOwner().getColor() == Color.WHITE || this.getOwner().getColor() == Color.YELLOW) {
			g.setColor(Color.BLACK);
		} else {
			g.setColor(Color.WHITE);
		}
		String letter;
		if (!city) {
			letter = "S";
		} else {
			letter = "C";
		}
		g.drawString(letter, 6, 15);
	}
	public int getVictoryPoints() {
		return victoryPoints;
	}
	public int getValue() {
		return value;
	}
	public String getType() {
		return type;
	}
	private void setType(String type) {
		this.type = type;
	}
	public boolean getCity() {
		return city;
	}
}