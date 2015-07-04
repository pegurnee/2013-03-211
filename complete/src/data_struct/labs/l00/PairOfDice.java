package data_struct.labs.l00;
public class PairOfDice {
	 private int face1;
	 private int face2;
	 
	PairOfDice() {
		face1 = -1;
		face2 = -1;
	}	
	public void rollDice() {
		face1 = (int) ((Math.random() * 6) + 1);
		face2 = (int) ((Math.random() * 6) + 1);			
	}
	public boolean isSnakeEyes() {
		if (face1 == face2 && face1 == 1) {
			return true;
		}
		return false;
	}
	public String toString() {
		String str = "You rolled: %n     " + face1 + "%n     " + face2 + "%n";
		if (isSnakeEyes()) {
			str = str + "***SNAKE EYES***%n";
		}
		return str;
	}	
}
	
