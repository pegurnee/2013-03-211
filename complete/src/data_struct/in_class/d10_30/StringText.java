package data_struct.in_class.d10_30;

import java.io.*;
import java.util.Scanner;
/**
 * 
 * @author Elsa Poh
 * @author Eddie Gurnee
 * @version 10/30/2013
 *
 */
public class StringText {

	public static void main (String[] args) {
		Scanner txtfile = null;
		Scanner kb = new Scanner(System.in);
		File afile = null;
		File copyFile = null;
		PrintWriter outf = null;
		
		try {
			afile = new File ("data.txt");
			txtfile = new Scanner (afile);
			
			System.out.print("Enter output filename: ");
			String outfilename = kb.nextLine().trim();
			
			copyFile = new File(outfilename);
			outf = new PrintWriter(copyFile);

			System.out.println("Length of file: " + afile.length());
			System.out.println("Actual name of file: " + afile.getName());
			
			while (txtfile.hasNext()) {
				String temp = txtfile.nextLine();
				System.out.println(temp);
				outf.println(temp);
			}
			
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}		
		finally {
			txtfile.close();
			outf.close();
			kb.close();
		}
	}	
}