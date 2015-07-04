package data_struct.in_class.d10_23;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This class is extra credit for COSC 211.
 * 
 * @author Eddie Gurnee
 * @version 10/23/2013
 * @see NegativeNumberException
 * @see OddNumberException
 */
public class ExtraCredit {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		boolean success = false;		
		
		while (!success) {
			System.out.print("\nPlease enter an integer: ");
			try {
				int num = kb.nextInt();
				
				if (num < 0) {
					throw new NegativeNumberException();
				}
				if (num % 2 != 0) {
					throw new OddNumberException();
				}				
				
				System.out.println("Yay! " + num + " is an even postive integer!");				
				success = true;
				
			} catch (InputMismatchException ex) {
				System.err.println("Number is not an integer.");			
				kb.nextLine();
			} catch (NegativeNumberException|OddNumberException ex) {				
				System.err.println(ex);
				kb.nextLine();
			}
		}
	}
}