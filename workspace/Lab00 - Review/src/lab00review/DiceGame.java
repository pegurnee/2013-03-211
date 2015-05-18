package lab00review;

import java.util.Scanner;

public class DiceGame {

	/**
	 * @author eddie gurnee
	 * @param args
	 */
	public static void main(String[] args) {
		lengthOfString("000000000000000000000000000000000000000");
		
//		double num = -.000000000001;
		
		System.out.println(Integer.toBinaryString(1000));
		
		Scanner kb = new Scanner(System.in);

		System.out.print("Enter user name: ");
		String name = kb.nextLine();
		name = name.trim().toUpperCase();
		System.out.printf("Current User: %s", name);
		System.out.println();

		PairOfDice pod = new PairOfDice();

		System.out.print("How many times would you like to roll the dice? ");
		int numRolls = kb.nextInt();
		kb.nextLine();
		
		kb.close();
		
		
		
		if (numRolls > 0) {
			System.out.printf("You have selected to roll the dice %d times", numRolls);
			System.out.println();

			int numSnakeEyes = 0;

			for (int r = 0; r < numRolls; r++) {
				pod.rollDice();
				System.out.printf(pod.toString());
				if (pod.isSnakeEyes()) {
					numSnakeEyes++;
				}			
			}
			System.out.printf("Out of %d rolls, %s recieved %d snake eyes.", numRolls, name, numSnakeEyes);
		}
		else {
			int count = 0;
			while(!pod.isSnakeEyes()) {
				pod.rollDice();
				System.out.printf(pod.toString());
				count++;				
			}
			System.out.printf("After %d rolls, you recieved a snake eyes.", count);			
		}		
	}
	public static void lengthOfString(String str) {
		System.out.println(str.length());
	}
	
}
