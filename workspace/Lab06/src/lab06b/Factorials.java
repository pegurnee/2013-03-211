package lab06b;
/**
 * This is the Factorials class made awesome by Eddie Gurnee,
 * used to test the MathUtils class,
 * the function of n!
 * 
 * @author Eddie Gurnee
 * @version 10/28/2013
 * 
 */
// ****************************************************************
// Factorials.java
//
// Reads integers from the user and prints the factorial of each.
//
// ****************************************************************
import java.util.Scanner;

public class Factorials
{
	public static void main(String[] args)
	{
		String keepGoing = "y";
		Scanner scan = new Scanner(System.in);
		while (keepGoing.equalsIgnoreCase("Y"))
		{
			System.out.print("Enter an integer: ");
			int val = scan.nextInt();
			//awesome additions by eddie
			try {
				System.out.println("Factorial(" + val + ") = "
						+ MathUtils.factorial(val));
				
			//more awesome additions by eddie
			} catch (IllegalArgumentException ex) {
				System.err.println(ex + "\n");
			}
			System.out.println("Another factorial? (y/n) ");
			keepGoing = scan.next();
		}
	}
}