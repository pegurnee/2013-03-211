package chutesLadders;

public class NormalSpace extends BoardSpace {

	public NormalSpace() {
		
	}

	@Override
	public void onLanding(Player currentPlayer) {
		System.out.println("You're now on space " + currentPlayer.getLocation());
		currentPlayer.endTurn();		
	}
}