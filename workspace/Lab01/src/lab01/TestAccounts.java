package lab01;
//***********************************************************
// TestAccounts.java
// A simple program to test the getNumAccts() method of the 
// Account class.  
//***********************************************************
import java.util.Scanner;

public class TestAccounts
{
	public static void main(String[] args)
	{
		Account testAcct;

		Scanner scan = new Scanner(System.in);

		System.out.println("How many accounts would you like to create?");
		int num = scan.nextInt();

		for (int i=1; i<=num; i++)
		{
			testAcct = new Account(100, "Name"+i , i);
			System.out.println("\nCreated account " + testAcct);
			System.out.println("Now there are " + Account.getNumAccounts() + 
					" accounts");
		}
		
		scan.close();
	}
}