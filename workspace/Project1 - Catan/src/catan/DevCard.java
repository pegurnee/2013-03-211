package catan;

import javax.swing.JOptionPane;

/**
 * 
 * @author Eddie Gurnee
 * @version 0.0.03 10/29/2013
 *
 */
public class DevCard {
	private String type;

	private static final int[] COST = {0, 1, 1, 1, 0};
	private int victoryPoint;
	private String name;	

	private String[] vpCards = {"Chapel", "Market", "University", "Town Center", "Library"};
	static int theVPcard;

	public DevCard(String type) {
		this.type = type;
		this.victoryPoint = 0;

		if (type.equals("Victory Point")) {
			this.name = vpCards[theVPcard++];
			this.victoryPoint = 1;
		} else {
			this.name = type;
		}
	}
	public static int[] getCost() {
		return COST;
	}
	public int getVictoryPoints() {
		return victoryPoint;
	}
	public String toString() {
		return this.name;
	}
	public void play() {
		String[] theResources = {"Wood", "Sheep", "Wheat", "Ore", "Brick"};
		switch (type) {
		case "Knight":
			BoardGame.getActivePlayer().addArmy();
			JOptionPane.showMessageDialog
			(null,  
					"Move the robber!\nYou now have " + BoardGame.getActivePlayer().getArmy() + " played soldiers!",
					"Soldier Results",
					JOptionPane.PLAIN_MESSAGE);
			boolean largest = true;
			if (BoardGame.getActivePlayer().getArmy() < 3) {
				largest = false;
			} else {
				for (Player a : BoardGame.thePlayers) {
					if (!a.equals(BoardGame.getActivePlayer())) {
						if (BoardGame.getActivePlayer().getArmy() <= a.getArmy()) {
							largest = false;
						}
					}
				}
			}
			if (largest) {
				JOptionPane.showMessageDialog
				(null,
						"You now have the largest army!",
						"Largest Army",
						JOptionPane.PLAIN_MESSAGE);
				BoardGame.getActivePlayer().setLargestArmy(true);
				for (Player a : BoardGame.thePlayers) {
					if (!a.equals(BoardGame.getActivePlayer())) {
						a.setLargestArmy(false);
					}
				}
			}
			BoardGame.board.theRobber.unPlace();			
			break;
		case "Year of Plenty":
			int r1 = JOptionPane.showOptionDialog
			(null,
					"Which resource would you like for free?",
					"Year of Plenty:",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE,
					null,
					theResources,
					theResources[0]
					);
			int r2 = JOptionPane.showOptionDialog
					(null,
							"Which other resource would you like for free?",
							"Year of Plenty:",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.PLAIN_MESSAGE,
							null,
							theResources,
							theResources[0]
							);

			String str = "You gained ";
			if (r1 != r2) {
				BoardGame.getActivePlayer().stealResource(r1, 1);
				BoardGame.getActivePlayer().stealResource(r2, 1);
				str += "one " + theResources[r1] + " and one " + theResources[r2];
			} else {
				BoardGame.getActivePlayer().stealResource(r1, 2);
				str += "two " + theResources[r1] + "s";
			}
			str += ".";
			JOptionPane.showMessageDialog
			(null,  
					str,
					"Year of Plenty Results",
					JOptionPane.PLAIN_MESSAGE);
			break;
		case "Road Building":
			BoardGame.getActivePlayer().setRoadBuilding();
			JOptionPane.showMessageDialog
			(null,  
					"You my now place two free roads!",
					"Road Building Results",
					JOptionPane.PLAIN_MESSAGE);
			break;
		case "Monopoly":
			int n = JOptionPane.showOptionDialog
			(null,
					"Which resource would you like to take all of?",
					"Monopoly:",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE,
					null,
					theResources,
					theResources[0]
					);
			int totalGained = 0;
			for (int i = 0; i < BoardGame.thePlayers.length; i++) {
				if (!BoardGame.getActivePlayer().equals(BoardGame.thePlayers[i])) {
					totalGained += BoardGame.thePlayers[i].monopoly(n);
				}
			}

			BoardGame.getActivePlayer().stealResource(n, totalGained);

			JOptionPane.showMessageDialog
			(null,  
					"You stole " + totalGained + " " + theResources[n] + " total from the other players.",
					"Monopoly Results",
					JOptionPane.PLAIN_MESSAGE);
			break;
		case "Victory Point":
			JOptionPane.showMessageDialog
			(null,  
					"You can't play victory point cards.",
					"",
					JOptionPane.WARNING_MESSAGE);
			break;
		}
	}
}
