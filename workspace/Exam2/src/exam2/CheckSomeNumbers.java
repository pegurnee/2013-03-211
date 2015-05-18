package exam2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @author Eddie Gurnee
 * @version 11/11/13
 *
 */
public class CheckSomeNumbers {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		try {
			System.out.print("Please enter a non-negative integer number: ");
			int theFirstOne = kb.nextInt();
			if (theFirstOne < 0) {
				throw new NegativeNumberException(theFirstOne + " is not a non-negative number.");
			}
			System.out.print("Please enter another non-negative integer number: ");
			int theSecondOne = kb.nextInt();
			if (theSecondOne < 0) {
				throw new NegativeNumberException(theSecondOne + " is not a non-negative number.");
			}
			System.out.println("You've entered " + theFirstOne + " and " + theSecondOne + ".");		
		} catch (InputMismatchException|NegativeNumberException ex) {
			ex.printStackTrace();
			System.exit(0);
		} finally {
			kb.close();
		}			
	}
}