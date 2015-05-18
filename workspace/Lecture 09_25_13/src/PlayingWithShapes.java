import java.util.Scanner;

public class PlayingWithShapes {

	/**
	 * @author Eddie Gurnee
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		Shape otherShape = new Shape(5, "blue", true);
		
		System.out.print("Enter number of sides: ");
		int sides = kb.nextInt();
		System.out.print("Enter color of shape: ");
		String color = kb.next();
		System.out.print("Enter if filled with color [y/n]: ");
		String filled = kb.next();
		
		Shape myShape = new Shape(sides, color, filled.equalsIgnoreCase("y"));
		
		System.out.println("\n" + myShape.toString());
		System.out.println(myShape.equals(otherShape));
		
		Rectangle myRectangle = new Rectangle(4, "blue", true, 5.0, 3.5);		
		System.out.println("\n" + myRectangle);
		
		kb.close();
	}
}