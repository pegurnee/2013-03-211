package lab05;
// **********************************************************
// Player.java
//
// Defines a Player class that holds information about an athlete. 
// **********************************************************
import java.util.Scanner;
/**
 * This class hold methods and variables available to players for lab5.
 * 
 * @author Eddie Gurnee
 * @version 10/21/2013
 *
 */
public class Player
{
	private String name;
	private String team;
	private int jerseyNumber;

	public Player() {
		this("no name", "no team", -1);
	}

	public Player(String name, String team, int jerseyNumber) {
		this.name = name;
		this.team = team;
		this.jerseyNumber = jerseyNumber;
	}

	public Player(Player origPlayer) {
		this(origPlayer.name, origPlayer.team, origPlayer.jerseyNumber);    	
	}
	//----------------------------------------------------------- 
	// Prompts for and reads in the player's name, team, and
	// jersey number.
	//-----------------------------------------------------------
	public void readPlayer()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Name: ");
		name = scan.nextLine();
		System.out.print("Team: ");
		team = scan.nextLine();
		System.out.print("Jersey number: ");
		jerseyNumber = scan.nextInt();
	}
	@Override
	public Object clone() {
		return new Player(this);
	}
	@Override
	public boolean equals(Object otherObject) {
		if (otherObject == null) {
			return false;
		} else if (this.getClass() != otherObject.getClass()) {
			return false;
		} else {
			Player otherPlayer = (Player)otherObject;
			return (this.team.equals(otherPlayer.team) 
					&& this.jerseyNumber == otherPlayer.jerseyNumber);
		}
	}
}