package catan;

import javax.swing.JButton;
/**
 * 
 * @author Eddie Gurnee
 * @version 0.0.06 10/28/2013
 *
 */
public abstract class Piece extends JButton {
	private Player owner;
	//Wood, Sheep, Wheat, Ore, Brick
	protected int[] cost = new int[5];
	
	public Piece(Player owner) {
		super();
		setContentAreaFilled(false);
		setFocusPainted(true);
		setBorderPainted(false);
		
		this.owner = owner;
	}
	
	public Player getOwner() {
		return owner;
	}

	public int[] getCost() {
		return cost;
	}

	public void setCost(int[] cost) {
		this.cost = cost;
	}
	public void setCost(int wood, int sheep, int wheat, int ore, int brick) {
		cost[0] = wood;
		cost[1] = sheep;
		cost[2] = wheat;
		cost[3] = ore;
		cost[4] = brick;
	}
}
