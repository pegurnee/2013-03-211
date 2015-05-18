import java.io.*;
import java.util.Scanner;
/**
 * 
 * @author Elsa Poh
 * @version 10/30/2013
 *
 */
public class IntegerText {

	public static void main (String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter filename: ");
		String fname = scan.next();
		int num = 0;
		Scanner intfile = null;
		PrintWriter oddfile = null, evenfile = null;
		
		try {
			intfile = new Scanner (new FileInputStream (fname));   // may also use File()
			evenfile = new PrintWriter("even.txt");
			oddfile = new PrintWriter (new FileOutputStream("odd.txt"));
			
			while (intfile.hasNextInt()){
				num = intfile.nextInt();
				if (num % 2 == 0)
					evenfile.println(num);
				else
					oddfile.println(num);
			}
			
		}
		catch (FileNotFoundException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		finally {
			intfile.close();
			evenfile.close();
			oddfile.close();
			scan.close();
		}
	}
	
}







