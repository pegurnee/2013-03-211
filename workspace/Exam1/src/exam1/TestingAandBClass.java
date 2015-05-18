package exam1;
/**
 * 
 * @author Eddie Gurnee
 * @version 10/07/13
 * @see AClass
 * @see BClass
 *
 */
import java.util.Scanner;

public class TestingAandBClass {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Please Enter x value for object A: ");
		int xA = kb.nextInt();
		System.out.print("Please Enter y value for object A: ");
		int yA = kb.nextInt();

		System.out.print("Please Enter x value for object B: ");
		int xB = kb.nextInt();
		System.out.print("Please Enter y value for object B: ");
		int yB = kb.nextInt();
		System.out.print("Please Enter z value for object B: ");
		int zB = kb.nextInt();

		AClass aObj = new AClass(xA, yA);
		BClass bObj = new BClass(xB, yB, zB);

		aObj.changeEm();
		System.out.println(aObj.toString());

		System.out.println(bObj.addEm());
		System.out.println(bObj.toString());
		
		kb.close();
	}
}
