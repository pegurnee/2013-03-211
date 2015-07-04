package data_struct.proj.p1;

public class ChuteOrLadder extends NormalSpace {
	private boolean chute;
	private int distance;
	
	public ChuteOrLadder(boolean chute, int distance) {
		this.chute = chute;
		this.distance = distance;
	}

	@Override
	public void onLanding(Player currentPlayer) {
		if (chute) {
			currentPlayer.chute(distance);
			System.out.println("Oh no! It's a chute! You fell down " + distance + " spots!");
		}
		else {
			currentPlayer.ladder(distance);
			System.out.println("Yay! It's a ladder! You climbed up " + distance + " spots!");
		}
		System.out.println("You're now on space " + currentPlayer.getLocation());
		currentPlayer.endTurn();
	}

}
