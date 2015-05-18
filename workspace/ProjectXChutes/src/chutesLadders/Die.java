package chutesLadders;

public class Die {
	private int sides;
	
	public Die() {
		this(6);
	}
	public Die(int sides) {
		this.sides = sides;
	}
	public int roll() {
		return (int)((Math.random() * sides) + 1);
	}
}
