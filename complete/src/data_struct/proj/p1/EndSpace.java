package data_struct.proj.p1;

public class EndSpace extends NormalSpace {

	public EndSpace() {
		
	}

	@Override
	public void onLanding(Player currentPlayer) {
		System.out.println(currentPlayer.getName() + ", you win!");
		System.exit(0);
	}
}