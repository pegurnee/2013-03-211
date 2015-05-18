package catan;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This is how you play Catan like a pro.
 * 
 * @author Eddie Gurnee
 * @author Nicole Downer
 * @version 0.0.10 10/29/2013
 * @see CatanFrame
 * @see HexBoard
 * @see Player
 * @see DevCard
 *
 */
public class BoardGame {
	static Player[] thePlayers = new Player[1];
	static int activePlayer = -1;
	static HexBoard board = new HexBoard();
	static boolean start;
	
	private static int forwardCount = 1;
	private static int backwardCount = 1;

	//Wood, Sheep, Wheat, Ore, Brick
	static int[] bank = {19, 19, 19, 19, 19};
	static ArrayList<DevCard> devCardsBank = new ArrayList<>();

	public static void main(String[] args) {
		board.startRobber();
		
		String[] theColors = {"Red", "Blue", "White", "Orange"};
		String[] theNames = {"nicole", "NICOLE", "Mike", "Eddie"}; // default players

		String[] devCards = {"Knight", "Year of Plenty", "Monopoly", "Road Building", "Victory Point"};

		for (int i = 0; i < devCards.length; i++) {
			int numOfCards = 0;
			switch (i) {
			case 0:
				numOfCards += 9;
			case 4:
				numOfCards += 3;
			case 1:
			case 2:
			case 3:
				numOfCards += 2;
				break;
			}
			for (int j = 0; j < numOfCards; j++) {
				devCardsBank.add(new DevCard(devCards[i]));
			}
		}
		
		Collections.shuffle(devCardsBank);
		
		for (int i = 0; i < thePlayers.length; i++) {
			thePlayers[i] = new Player(theNames[i], theColors[i]);
		}

		start = true;

		for (Player a : thePlayers) {
			a.addStartResources();
		}
		
		CatanFrame startingGui = new CatanFrame(true);
		startingGui.setVisible(true);

		//				//roll dice
		//				//get money
		//				//spend money
		//				//end turn

	}
	public static void namesOfPlayers(String[] theNames) {
		String[] theColors = {"Red", "Blue", "White", "Orange"};
		for (int i = 0; i < thePlayers.length; i++) {
			thePlayers[i] = new Player(theNames[i], theColors[i]);
		}
		for (Player a : thePlayers) {
			a.addStartResources();
		}
	}
	public static void establishPlayers(int numPlayers) {
		thePlayers = new Player[numPlayers];
	}
	public static void firstSettlements(boolean backward) {
		if (forwardCount == thePlayers.length) {
			activePlayer++;
			for (Player a : thePlayers) {
				a.addStartResources();
			}
			backward = true;
			forwardCount = -1;
		}
		if (backward) {
			BoardGame.activePlayer--;
			backwardCount++;
			new CatanFrame(thePlayers[activePlayer], board);
		} else {
			BoardGame.activePlayer++;
			forwardCount++;
			new CatanFrame(thePlayers[activePlayer], board);
		}
	}
	public static void startGame() {
		activePlayer--;
		start = false;
		board.disableAllCorners();
		newFrame();
	}
	public static void newFrame() {
		activePlayer++;
		if (activePlayer == thePlayers.length) {
			activePlayer = 0;
		}
		new CatanFrame(thePlayers[activePlayer], board);
	}
	public static Player getActivePlayer() {
		return thePlayers[activePlayer];
	}
}