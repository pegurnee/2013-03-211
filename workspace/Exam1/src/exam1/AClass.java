package exam1;
/**
 * 
 * @author Elsa Poh
 * @version 10/07/13
 * @see BClass
 *
 */
public class AClass {

	private int x;
	private int y;

	public AClass(int a, int b) {
		x = a;
		y = b;
	}

	public int addEm() {
		return x + y;
	}

	public void changeEm() {
		x++;
		y--;
	}

	public String toString() {
		return "" + x + "   " + y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}