/**
 * Simple program to play with the 'Sam' class
 * 
 * @author Eddie Gurnee
 * @version 10/02/13
 * @see Sam
 * @see George
 * 
 */
public class TestingSam {

	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		Sam iam = new Sam();
		George weare = new George();
		George g2 = new George(3);
//		Object theObject = new Object();
//		theObject.e
//
//		System.out.println(iam);
//		System.out.println(weare);
//
//		System.out.println(iam.equals(theObject));
//		
//		System.out.println(iam.getMikesPlan());
//		
		System.out.println(iam.equals(weare));
		System.out.println();
		System.out.println(weare.equals(iam));
		System.out.println();
		
		System.out.println(g2.equals(weare));
		System.out.println();
		System.out.println(weare.equals(g2));
		System.out.println();
		
		System.out.println(iam.getMikesPlan()); //8
		System.out.println(weare.getMikesPlan()); //99
		System.out.println(weare.getMikesPlan(2)); //10
	}
}
