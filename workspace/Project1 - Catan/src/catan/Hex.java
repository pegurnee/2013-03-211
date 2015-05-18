package catan;

import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 * This class holds methods and variables associated with the hexes used to create the board in Catan.
 * Contains a built in GUI, unusable without the user interface.
 * 
 * @author Eddie Gurnee
 * @author Nicole Downer
 * @version 0.0.25 10/26/2013
 * @see CatanFrame
 * @see HexBoard
 * 
 */
public class Hex extends JPanel {
	/**
	 * This thrice-be-damned class holds all of the method and variables needed to cause me to go insane.
	 * 
	 * @author Eddie Gurnee
	 * @version 0.0.18 10/28/2013
	 * @see Road
	 */
	private class Edge extends BoardSpace {
		private final int B_WIDTH = 30;
		private final int B_HEIGHT = 15;

		private final int S_WIDTH = 10;
		private final int S_HEIGHT = 30;

		private int edgeNum;

		private Edge(int edgeNum) {
			super();
			
			this.setAllNotEligible();
			this.edgeNum = edgeNum;

			if (edgeNum == 0) {
				//mid right
				setSize(S_WIDTH, S_HEIGHT);
			} else {
				//bot right and left
				setSize(B_WIDTH, B_HEIGHT);
			}		
		}		
		@Override
		public void actionPerformed(ActionEvent e) {
			int n = JOptionPane.showConfirmDialog
					(null,
							"Would you like to place a road?",
							"Place road",
							JOptionPane.YES_NO_OPTION
							);

			if (n == 0) {
				try {
					if (!BoardGame.getActivePlayer().isRemainingRoads()) {
						throw new NoMorePiecesException("Roads");
					}
					if (!BoardGame.getActivePlayer().isRoadBuilding()) {
						if (!BoardGame.getActivePlayer().isEnoughMoney(new Road(BoardGame.getActivePlayer(), -1).getCost())) {
							throw new NotEnoughResourcesException("Road");
						}
					}
					if (!isEligible()) {
						throw new NoConnectionException("Road");
					}
					this.onLanding();
				} catch (NoMorePiecesException|NoConnectionException|NotEnoughResourcesException ex) {
					ex.displayErrMessage();
				}
			}
		}
		@Override
		public void onLanding() {
			Road theRoad = new Road(BoardGame.getActivePlayer(), this.edgeNum);

			if (BoardGame.start) {
				if (!BoardGame.getActivePlayer().isTheRoadPlaced()) {
					BoardGame.getActivePlayer().setTheRoadPlaced(true);
				} else if (!BoardGame.getActivePlayer().isSecondRoadPlaced()) {
					BoardGame.getActivePlayer().setSecondRoadPlaced(true);
				}
			}
			
			//enable nearby edges
			int r = Hex.this.getRow();
			int c = Hex.this.getCol();

			switch (edgeNum) {
			case 0:
				Hex.this.enableEdge(1);
				Hex.this.enableCorner(0);
				try {
					BoardGame.board.gameBoard[r][c + 1].enableEdge(2);
				} catch (ArrayIndexOutOfBoundsException ex) {
					//Don't you worry child
				}
				try {
					if (r <= 3) {
						BoardGame.board.gameBoard[r - 1][c].enableCorner(1);
						BoardGame.board.gameBoard[r - 1][c].enableEdge(1);
					} else {
						BoardGame.board.gameBoard[r - 1][c + 1].enableCorner(1);
						BoardGame.board.gameBoard[r - 1][c + 1].enableEdge(1);
					}
				} catch (ArrayIndexOutOfBoundsException ex) {
					//Don't you worry child
				}
				try {
					if (r <= 3) {
						BoardGame.board.gameBoard[r - 1][c].enableEdge(2);
					} else {
						BoardGame.board.gameBoard[r - 1][c + 1].enableEdge(2);
					}
				} catch (ArrayIndexOutOfBoundsException ex) {
					//Don't you worry child
				}
				break;
			case 1:
				Hex.this.enableEdge(0);
				Hex.this.enableEdge(2);
				Hex.this.enableCorner(0, 1);
				try {
					BoardGame.board.gameBoard[r][c + 1].enableEdge(2);
				} catch (ArrayIndexOutOfBoundsException ex) {
					//Don't you worry child
				}
				try{
					if (r < 3) {
						BoardGame.board.gameBoard[r + 1][c].enableEdge(0);
					} else {
						BoardGame.board.gameBoard[r + 1][c - 1].enableEdge(0);
					}
				} catch (ArrayIndexOutOfBoundsException ex) {
					//Don't you worry child
				}
				break;
			case 2:
				Hex.this.enableEdge(1);
				Hex.this.enableCorner(1);
				try {
					BoardGame.board.gameBoard[r][c - 1].enableCorner(1);
					BoardGame.board.gameBoard[r][c - 1].enableEdge(0, 1);
				} catch (ArrayIndexOutOfBoundsException ex) {
					//Don't you worry child
				}
				try {
					if (r < 3) {
						BoardGame.board.gameBoard[r + 1][c].enableEdge(0);
					} else {
						BoardGame.board.gameBoard[r + 1][c - 1].enableEdge(0);
					}
				} catch (ArrayIndexOutOfBoundsException ex) {
					//Don't you worry child
				}
				break;
			}
			
			Hex.this.add(theRoad);
			theRoad.setBounds(this.getBounds());

			if (BoardGame.getActivePlayer().isRoadBuilding()) {
				BoardGame.getActivePlayer().builtFreeRoad();
				BoardGame.getActivePlayer().placedRoad();
			} else {
				BoardGame.getActivePlayer().buyPiece(theRoad);
			}
			
			Hex.this.remove(this);
		}
	}
	/**
	 * This class holds the methods and variable associated with the corners of each hex.
	 * Cities and Settlements go here.
	 * 
	 * @author Eddie Gurnee
	 * @version 0.0.41 10/27/2013
	 * @see Properties
	 *
	 */
	private class Corner extends BoardSpace {
		private final int WIDTH = 20;
		private final int HEIGHT = 20;		
		private int corNum;

		private Corner() {
			this(-1);
		}
		private Corner(int corNum) {
			super();
			setSize(WIDTH, HEIGHT);

			this.corNum = corNum;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			int n = JOptionPane.showConfirmDialog
					(null,
							"Would you like to place a settlement?",
							"Place Settlement",
							JOptionPane.YES_NO_OPTION
							);
			if (n == 0) {
				try {
					if (!BoardGame.getActivePlayer().isEnoughMoney(new Properties(BoardGame.getActivePlayer()).getCost())) {
						throw new NotEnoughResourcesException("Settlement");
					}
					if (!this.isEligible()) {
						throw new NoConnectionException("Settlement");
					}
					if (!BoardGame.getActivePlayer().isRemainingSettlements()) {
						throw new NoMorePiecesException("Settlements");
					}
					this.onLanding();
				} catch (NoMorePiecesException|NoConnectionException|NotEnoughResourcesException ex) {
					ex.displayErrMessage();
				}
			}			
		}
		@Override
		public void onLanding() {
//			System.out.println("Hex : " + Hex.this.getRow() + " " + Hex.this.getCol() 
//					+ "\nCorner Num: " + corNum + " CLICKED!");

			Properties theSettlement = new Properties(BoardGame.getActivePlayer());

			Hex.this.addProperty(theSettlement);

			int r = Hex.this.getRow();
			int c = Hex.this.getCol();

			if (corNum == 0) {
				//remove adjacent corners
				Hex.this.removeCorner(1);				
				try {
					BoardGame.board.gameBoard[r][c + 1].removeCorner(1);
				} catch (ArrayIndexOutOfBoundsException ex) {
					//Don't you worry child
				}				
				try {
					if (r > 3) {
						BoardGame.board.gameBoard[r - 1][c + 1].removeCorner(1);
					} else {
						BoardGame.board.gameBoard[r - 1][c].removeCorner(1);
					}
				} catch (ArrayIndexOutOfBoundsException ex) {
					//Don't you worry child
				}

				//enable nearby edges
				Hex.this.enableEdge(0);
				Hex.this.enableEdge(1);
				BoardGame.board.gameBoard[r][c + 1].enableEdge(2);

				//add properties to the adjacent Hexes
				BoardGame.board.gameBoard[r][c + 1].addProperty(theSettlement);
				if (r < 3) {
					BoardGame.board.gameBoard[r + 1][c + 1].addProperty(theSettlement);					
				} else {
					BoardGame.board.gameBoard[r + 1][c].addProperty(theSettlement);
				}				
			} else {
				//remove adjacent corners
				Hex.this.removeCorner(0);
				try {
					BoardGame.board.gameBoard[r][c - 1].removeCorner(0);
				} catch (ArrayIndexOutOfBoundsException ex) {
					//Don't you worry child
				}
				try {
					if (r >= 3) {
						BoardGame.board.gameBoard[r + 1][c - 1].removeCorner(0);
					} else {
						BoardGame.board.gameBoard[r + 1][c].removeCorner(0);
					}
				} catch (ArrayIndexOutOfBoundsException ex) {
					//Don't you worry child
				}

				//enable nearby edges
				Hex.this.enableEdge(1);
				Hex.this.enableEdge(2);				
				try {
					if (r >= 3) {
						BoardGame.board.gameBoard[r + 1][c - 1].enableEdge(0);
					} else {
						BoardGame.board.gameBoard[r + 1][c].enableEdge(0);
					}
				} catch (ArrayIndexOutOfBoundsException ex) {
					//Don't you worry child
				}

				//add properties to nearby hexes
				if (r < 3) {
					BoardGame.board.gameBoard[r + 1][c].addProperty(theSettlement);
					BoardGame.board.gameBoard[r + 1][c + 1].addProperty(theSettlement);
				} else {
					BoardGame.board.gameBoard[r + 1][c].addProperty(theSettlement);
					BoardGame.board.gameBoard[r + 1][c - 1].addProperty(theSettlement);
				}
			}

			Hex.this.add(theSettlement);
			theSettlement.setBounds(this.getBounds());

			BoardGame.getActivePlayer().buyPiece(theSettlement);

			Hex.this.remove(this);
			BoardGame.board.repaint();
		}
	}

	private final int WIDTH = 100, HEIGHT = 100, OFFSET = 10;
	private final int SIDES = 6;

	private final int NUM_EDGES = SIDES / 2;
	private final int NUM_CORNERS = SIDES / 3;

	private final int[] XPOINTS = {
			(WIDTH / 2) + OFFSET,
			(WIDTH) + OFFSET,
			(WIDTH) + OFFSET,
			(WIDTH / 2) + OFFSET,
			(0) + OFFSET,
			(0) + OFFSET,
	};	
	private final int[] YPOINTS = {
			(0) + OFFSET,
			(HEIGHT / 4) + OFFSET,
			((3 * HEIGHT) / 4) + OFFSET,
			(HEIGHT) + OFFSET,
			((3 * HEIGHT) / 4) + OFFSET,
			(HEIGHT / 4) + OFFSET,
	};	
	private final Polygon HEX = new Polygon (XPOINTS, YPOINTS, SIDES);

	private String type;

	private int row;
	private int col;

	private Corner[] corners = new Corner[NUM_CORNERS];
	private Edge[] edges = new Edge[NUM_EDGES];

	private ArrayList<Properties> establishedProperties = new ArrayList<Properties>();

	public Hex(String type) {
		super();
		setSize((WIDTH) + (2 * OFFSET), (HEIGHT) + (2 *OFFSET));
		setOpaque(false);
		setLayout(null);

		this.type = type;

		for (int i = 0; i < NUM_CORNERS; i++) {
			corners[i] = new Corner(i);
			this.add(corners[i]);
		}
		for (int i = 0; i < NUM_EDGES; i++) {
			edges[i] = new Edge(i);
			this.add(edges[i]);
		}

		placeCorners();
		placeEdges();
	}
	private void placeCorners() {
		for (int i = 0; i < NUM_CORNERS; i++) {
			if (i == 0) {
				corners[i].setBounds(
						(this.getWidth() - corners[i].getWidth()),
						((3 * (this.getHeight() - corners[i].getHeight())) / 4), 
						corners[i].getWidth(), 
						corners[i].getHeight());
			} else if (i == 1) {
				corners[i].setBounds(
						((this.getWidth() - corners[i].getWidth()) / 2),
						(this.getHeight() - corners[i].getHeight()),
						corners[i].getWidth(), 
						corners[i].getHeight());
			}
		}
	}
	private void placeEdges() {
		for (int i = 0; i < NUM_EDGES; i++) {
			switch (i) {
			//			default:
			case 0:
				edges[i].setBounds(
						(OFFSET + WIDTH - (edges[i].getWidth() / 2)),
						(OFFSET + (HEIGHT / 4) + (new Corner().HEIGHT / 2)),
						edges[i].getWidth(),
						edges[i].getHeight());
				break;
			case 1:
				edges[i].setBounds(
						(OFFSET + (WIDTH / 2) + (new Corner().WIDTH / 2)),
						(OFFSET + (3 * HEIGHT / 4) + (new Corner().HEIGHT / 4)), 
						edges[i].getWidth(), 
						edges[i].getHeight());
				break;
			case 2:
				edges[i].setBounds(
						(OFFSET + (new Corner().WIDTH / 2)),
						(OFFSET + (3 * HEIGHT / 4) + (new Corner().HEIGHT / 4)), 
						edges[i].getWidth(),
						edges[i].getHeight());
				break;
			}
		}
	}
	public void enableEdge(int... edgeNum) {
		for (int edge : edgeNum) {
			this.edges[edge].setEligible(true);
		}
	}
	public void removeEdge(int... edgeNum) {
		for (int edge : edgeNum) {
			this.remove(edges[edge]);
		}
	}
	public void removeCorner(int... cornerNum) {
		for (int corner : cornerNum) {
			this.remove(corners[corner]);
		}
	}
	public void enableCorner(int... cornerNum) {
		for (int corner : cornerNum) {
			this.corners[corner].setEligible(true);
		}
	}
	public void enableCorners() {
		for (int c = 0; c < corners.length; c++) {
			corners[c].setAllEligible();
		}
	}
	public void disableCorners() {
		for (Corner c: corners) {
			c.setAllNotEligible();
		}
	}
	public String getType() {
		return type;
	}
	public Polygon getHex() {
		return HEX;
	}
	protected void setType(String type) {
		this.type = type;
	}
	protected ArrayList<Properties> getProperties() {
		return establishedProperties;
	}
	public void addProperty(Properties newProperty) {
		establishedProperties.add(newProperty);
	}
	public void setRowAndCol(int row, int col) {
		this.row = row;
		this.col = col;
	}
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
	public String toString() {
		return "Type: " + this.type + "\nRow: " + this.row + "\nCol: " + this.col;
	}
}