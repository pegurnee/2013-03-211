package chutesLadders;
import java.util.Scanner;

public class BoardGame {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner kb = new Scanner(System.in);

		System.out.println("How many people are playing? [1-4]");
		int nPlay = kb.nextInt();
		int spaces = 100;
		NormalSpace[] gameBoard = new NormalSpace[spaces];

		int[] theChutes = {16, 47, 49, 56, 62, 64, 87, 93, 95, 98};
		int[] chuteDistance = {10, 21, 38, 3, 43, 4, 63, 20, 20, 20};
		int[] theLadders = {1, 4, 9, 21, 28, 36, 51, 71, 80, 92};
		int[] ladderDistance = {37, 10, 22, 21, 56, 8, 16, 20, 20, 2};

		for (int i = 0; i < spaces; i++) {
			gameBoard[i] = new NormalSpace();
			for (int j = 0; j < theChutes.length; j++) {
				if (i == theChutes[j]) {
					gameBoard[i] = new ChuteOrLadder(true, (chuteDistance[j] - 1));
				}
				else if (j == theLadders[j]) {
					gameBoard[i] = new ChuteOrLadder(false, (ladderDistance[j] - 1));
				}
			}
		}
		
		gameBoard[99] = new EndSpace();

		Player[] players = new Player[nPlay];		

		for (int i = 0; i < nPlay; i++) {			
			System.out.print("Insert player " + i + " name: ");
			String name = kb.next();
			players[i] = new Player(name);
		}

		Die gameDie = new Die();
		
		while (true) {
			for (int i = 0; i < nPlay; i++) {
				players[i].startTurn();

				System.out.println("Enter 'roll' to Roll the die!");
				kb.next();

				int theRoll = gameDie.roll();
				System.out.println("You rolled a " + theRoll + "!");
				players[i].advance(theRoll);

				gameBoard[players[i].getLocation()].onLanding(players[i]);

				System.out.println("Enter 'end turn' to Continue!");
				kb.next();
			}
		}
	}
}