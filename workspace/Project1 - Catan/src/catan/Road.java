package catan;

import java.awt.Graphics;
import java.awt.Polygon;

/**
 * This class contains the methods and variable associated with the road pieces that each player has in Catan.
 * 
 * @author Eddie Gurnee
 * @version 0.0.02 10/23/2013
 *
 */
public class Road extends Piece {
	//Wood, Sheep, Wheat, Ore, Brick

	private int edgeNum;

	private final int B_WIDTH = 30;
	private final int B_HEIGHT = 15;

	private final int S_WIDTH = 10;
	private final int S_HEIGHT = 50;

	private final int SIDES = 4;
	private final int[][] XPOINTS =
		{
			{0, S_WIDTH, S_WIDTH, 0},
			{0, B_WIDTH, B_WIDTH, 0},
			{0, B_WIDTH, B_WIDTH, 0},
		};
	private final int[][] YPOINTS =
		{
			{0, 0, S_HEIGHT, S_HEIGHT},
			{B_HEIGHT / 3, 0, B_HEIGHT - (B_HEIGHT / 3), B_HEIGHT},
			{0, B_HEIGHT / 3, B_HEIGHT, B_HEIGHT - (B_HEIGHT / 3)},
		};
	private final Polygon[] polyRoad = 
		{
			new Polygon(XPOINTS[0], YPOINTS[0], SIDES),
			new Polygon(XPOINTS[1], YPOINTS[1], SIDES), 
			new Polygon(XPOINTS[2], YPOINTS[2], SIDES)
		};
	
	public Road(Player owner, int edgeNum) {
		super(owner);
		this.edgeNum = edgeNum;
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);

		if (edgeNum == 1) {
			setSize(S_WIDTH, S_HEIGHT);
		} else {
			setSize(B_WIDTH, S_HEIGHT);
		}
		this.setCost(1, 0, 0, 0, 1);
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(this.getOwner().getColor());
		g.fillPolygon(polyRoad[edgeNum]);
	}
}