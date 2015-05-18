package lab05;
// ************************************************************** 
// ComparePlayers
//
// Reads in two Player objects and tells whether they represent 
// the same player.
// ************************************************************** 
import java.util.Scanner;
/**
 * This class is used for testing the eqaulity of different players according to the equals() method defined in the player class.
 * Used in lab5.
 * 
 * @author Eddie Gurnee
 * @version 10/21/2013
 * @see Player
 *
 */
public class ComparePlayers
{
	public static void main(String[] args)
	{
		Player player1 = new Player();
		Player player2 = new Player();
		
		Scanner scan = new Scanner(System.in);

		//Prompt for and read in information for player 1
		System.out.println("Enter data for Player 1:");
		player1.readPlayer();
		
		//Prompt for and read in information for player 2
		System.out.println("Enter data for Player 2:");
		player2.readPlayer();

		//Compare player1 to player 2 and print a message saying
		//whether they are equal
		if (player1.equals(player2)) {
			System.out.println("Player 1 and Player 2 are the same.");
		} else {
			System.out.println("Player 1 and Player 2 are not the same.");
		}

		Player player3 = (Player)player2.clone();

		if (player2.equals(player3)) {
			System.out.println("Player 2 and Player 3 are the same.");
		} else {
			System.out.println("Player 2 and Player 3 are not the same.");
		}

		scan.close();
	} 
}