package chutesLadders;

public class Player {
	private int location;
	private String name;
	
	public Player() {
		this("no name");
	}
	public Player(String name) {
		this.name = name;
		this.location = 0;
	}
	public void startTurn() {
		System.out.println(name + ", it is now your turn!");
	}
	public void advance(int distance) {
		this.location += distance;
		if (location > 99) {
			location = 99;
		}
	}
	public void endTurn() {
		System.out.println(name + ", your turn is now over.");
	}
	
	public int getLocation() {
		return (location + 1);
	}
	public String getName() {
		return name;
	}
	
	public void chute(int distance) {
		this.location -= distance;
	}
	public void ladder(int distance) {
		this.location += distance;
	}
}
