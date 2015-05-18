package catan;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

/**
 * 
 * @author Eddie Gurnee
 * @author Nicole Downer
 * @version 0.0.23 10/26/2013
 * @see CatanFrame
 * @see Hex
 * @see LandHex
 * @see SeaHex
 * @see Robber
 * 
 */
public class HexBoard extends JPanel {

	private final int HEIGHT = 625;
	private final int WIDTH = 750;
	private final String[] LANDS = {"Wood", "Sheep", "Wheat", "Ore", "Brick", "Desert"};
	private final String[] PORTS = {"Wood", "Sheep", "Wheat", "Ore", "Brick", "3to1"};	
	public Hex[][] gameBoard;
	public Robber theRobber;

	public HexBoard() {
		super();
		setLayout(null);
		setBackground(new Color(30, 50, 80));
		setOpaque(true);

		int[] numberOrder = {5, 2, 6, 3, 8, 10, 9, 12, 11, 4, 8, 10, 9, 4, 5, 6, 3, 11};

		//creates the robber piece
		theRobber = new Robber();
		add(theRobber);
		theRobber.setVisible(true);

		//this is used to randomize the number placement
		ArrayList<Integer> allNumbers = new ArrayList<Integer>();		
		for (int i = 0; i < numberOrder.length; i++) {
			allNumbers.add(numberOrder[i]);
		}
		Collections.shuffle(allNumbers);

		//array list of lands using array of types
		ArrayList<LandHex> allLands = new ArrayList<LandHex>();
		for (int i = 0; i < 6; i++) {
			if (i < 3) {
				for (int j = 0; j < 4; j++) {
					allLands.add(new LandHex(LANDS[i], (int)allNumbers.get(0)));
					allNumbers.remove(0);
				}
			} else if (i < 5) {
				for (int j = 0; j < 3; j++) {
					allLands.add(new LandHex(LANDS[i], (int)allNumbers.get(0)));
					allNumbers.remove(0);
				}
			} else {
				allLands.add(new LandHex(LANDS[i], 0));
			}
		}

		//array list of ports using array of types
		ArrayList<String> allPorts = new ArrayList<String>();
		for (int i = 0; i < 6; i++) {
			if (i < 5) {
				allPorts.add(PORTS[i]);
			} else {
				for (int j = 0; j < 4; j++) {
					allPorts.add(PORTS[i]);
				}
			}
		}

		Collections.shuffle(allLands);
		Collections.shuffle(allPorts);

		//generate two dimensional array of hexes for the gameboard
		gameBoard = new Hex[7][];
		for (int r = 0; r < 7; r++) {
			if (r == 0 || r == 6) {
				gameBoard[r] = new Hex[4];
			} else if (r == 1 || r == 5) {
				gameBoard[r] = new Hex[5];
			} else if (r == 2 || r == 4) {
				gameBoard[r] = new Hex[6];
			} else {
				gameBoard[r] = new Hex[7];
			}
		}		

		//placing land and sea objects into gameBoard array
		for (int r = 0; r < gameBoard.length; r++) {
			if (r == 0 || r == 6) {
				for (int c = 0; c < gameBoard[r].length; c++) {
					if (c == 0 || c == 2) {
						gameBoard[r][c] = new SeaHex(allPorts.get(0));
						allPorts.remove(0);
					} else {
						gameBoard[r][c] = new SeaHex();
					}
				}
			} else if (r == 1 || r == 5) {
				for (int c = 0; c < gameBoard[r].length; c++) {
					if (c == 4) {
						gameBoard[r][c] = new SeaHex(allPorts.get(0));
						allPorts.remove(0);
					} else if (c == 0) {
						gameBoard[r][c] = new SeaHex();
					} else {
						gameBoard[r][c] = allLands.get(0);
						allLands.remove(0);
					}

				}
			} else if (r == 2 || r == 4){
				for (int c = 0; c < gameBoard[r].length; c++) {
					if (c == 0) {
						gameBoard[r][c] = new SeaHex(allPorts.get(0));
						allPorts.remove(0);
					} else if (c == 5) {
						gameBoard[r][c] = new SeaHex();
					} else {
						gameBoard[r][c] = allLands.get(0);
						allLands.remove(0);
					}
				}
			} else {
				for (int c = 0; c < gameBoard[r].length; c++) {
					if (c == 6) {
						gameBoard[r][c] = new SeaHex(allPorts.get(0));
						allPorts.remove(0);
					} else if (c == 0) {
						gameBoard[r][c] = new SeaHex();
					} else {
						gameBoard[r][c] = allLands.get(0);
						allLands.remove(0);
					}
				}
			}			
		}

		//remove unused edges and corners
		for (int r = 0; r < gameBoard.length; r++) {
			switch (r) {
			case 0:
				for (int c = 0; c < gameBoard[r].length; c++) {					
					gameBoard[r][c].removeEdge(0);
				}
			case 1:
			case 2:
				gameBoard[r][0].removeEdge(2);	
				gameBoard[r][gameBoard[r].length - 1].removeEdge(0, 1);
				gameBoard[r][gameBoard[r].length - 1].removeCorner(0);
				break;
			case 3:
			case 4:
			case 5:
				gameBoard[r][0].removeEdge(1, 2);
				gameBoard[r][0].removeCorner(1);	
				gameBoard[r][gameBoard[r].length - 1].removeEdge(0, 1, 2);
				gameBoard[r][gameBoard[r].length - 1].removeCorner(0, 1);	
				break;
			case 6:
				for (int c = 0; c < gameBoard[r].length; c++) {					
					gameBoard[r][c].removeEdge(0, 1, 2);
					gameBoard[r][c].removeCorner(0, 1);					
				}
				break;				
			}
		}

		//creates the locations that will be used to absolutely position the hexes
		setBounds(0, 0, WIDTH, HEIGHT);

		int locX = 175;
		int locY = 50;		

		for (int r = 0; r < gameBoard.length; r++) {
			for (int c = 0; c < gameBoard[r].length; c++) {
				add(gameBoard[r][c]);
				gameBoard[r][c].setBounds(locX, locY, gameBoard[r][c].getWidth(), gameBoard[r][c].getHeight());
				gameBoard[r][c].setRowAndCol(r, c);
				locX += 100;
			}
			locX -= (100 * (gameBoard[r].length));
			if (r < (gameBoard.length / 2)) {				
				locX -= 50;
			} else {
				locX += 50;
			}
			locY += 75;
		}
	}
	public void startRobber() {
		//starts the robber at the desert
		outerloop:
			for (int r = 0; r < gameBoard.length; r++) {
				for (int c = 0; c < gameBoard[r].length; c++) {
					if (gameBoard[r][c].getType().equals("Desert")) {
						theRobber.place((LandHex)gameBoard[r][c]);
						break outerloop;
					}
				}
			}
	}
	public LandHex getRobberLocation() {
		return (LandHex)gameBoard[theRobber.getRowPlaced()][theRobber.getColPlaced()];
	}	
	public void disableAllCorners() {
		for (int r = 0; r < gameBoard.length; r++) {
			for (int c = 0; c < gameBoard[r].length; c++) {
				gameBoard[r][c].disableCorners();
			}
		}
	}
	public void enableAllCorners() {
		for (int r = 0; r < gameBoard.length; r++) {
			for (int c = 0; c < gameBoard[r].length; c++) {
				gameBoard[r][c].enableCorners();
			}
		}
	}
}