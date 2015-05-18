package catan;

import java.awt.event.ActionListener;

import javax.swing.JButton;
/**
 * This abstract class holds the methods and variables needed for each BoardSpace in Catan.
 * 
 * @author Eddie Gurnee
 * @author Nicole Downer
 * @version 0.0.08 10/29/2013 
 *
 */
public abstract class BoardSpace extends JButton implements ActionListener {
	private final int MAX_PLAYERS = 4;
	
	private boolean[] eligible = new boolean[MAX_PLAYERS];
	
	public BoardSpace() {
		super();
		setContentAreaFilled(false);
		setFocusPainted(true);
		setBorderPainted(false);  //turn this off to get rid of duh borders

		this.setAllEligible();		
		this.addActionListener(this);
	}	
	public abstract void onLanding();
	
	public boolean isEligible() {
		return eligible[BoardGame.activePlayer];
	}
	public void setEligible(boolean eligible) {
		this.eligible[BoardGame.activePlayer] = eligible;
	}
	public void setAllEligible() {
		for (int e = 0; e < eligible.length; e++) {
			eligible[e] = true;
		}
	}
	public void setAllNotEligible() {
		for (int e = 0; e < eligible.length; e++) {
			eligible[e] = false;
		}
	}
}