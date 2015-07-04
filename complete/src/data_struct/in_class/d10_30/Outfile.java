package data_struct.in_class.d10_30;
import java.io.*;
import java.util.*;
/**
 * 
 * @author Elsa Poh
 * @author Eddie Gurnee
 * @version 10/30/2013
 *
 */
public class Outfile {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		boolean done = false;

		while (!done) {
			System.out.print("Enter string: ");
			String phrase = scan.nextLine();

			PrintWriter outf = null;
			try
			{
				//FileOutputStream(file, boolean)
				//true = append
				//false = overwrite
				outf = new PrintWriter(new FileOutputStream("letter.txt", true));
				outf.println(phrase);
				System.out.println("Done? [y/n]: ");
				done = scan.nextLine().trim().equalsIgnoreCase("y");
			}
			catch (FileNotFoundException ex)
			{
				System.out.println(ex.getMessage());
				System.exit(1);
			}
			finally
			{
				outf.close();
			}
		}
		
		scan.close();
	}
}