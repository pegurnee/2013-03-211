package data_struct.in_class.d10_30;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JOptionPane;
/**
 * Due to epoh@emich.edu by end of day Friday, Nov 1st.
 * 
 * Extra Credit +10 points
 * Write a Java application to read from a text file
 * (name input by the user) that contains a list of
 * names. Copy the names from the file and write the
 * all UPPERCASE version of the names into another file
 * (name input by user).
 * 
 * Write an exception handler for catching FileNotFoundException.
 * 
 * +5 points.
 * Write another text file containing only the initials
 * of the names read from the input file.
 * 
 * @author Eddie Gurnee
 * @version 0.0.01 10/30/2013
 */
public class ExtraCredit {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("MAKE SURE TO INCLUDE THE \".txt\" AT THE END OF EACH FILE NAME");
		System.out.println("What file are you reading from?");
		Scanner infile = null;
		PrintWriter outCAPS = null;
		PrintWriter outInitials = null;
		
		String str = "Name transfer complete";
		try {
			infile = new Scanner(new File(kb.nextLine().trim()));
			
			System.out.println("What would you like to name " +
					"the file where the ALL CAPS versions " +
					"of the names are to be saved?");
			String theOutFile = kb.nextLine().trim();
			boolean append = false;
			if (new File(theOutFile).exists()) {
				String checkAppend = null;
				System.out.print("I see that that file already exists," +
						"\nwould you like me to simply append the new data? [y/n] ");
				checkAppend = kb.nextLine().trim();
				if (checkAppend.equalsIgnoreCase("y")) {
					append = true;
				}
			}
			outCAPS = new PrintWriter(new FileOutputStream(theOutFile, append));
			
			System.out.println("What would you like to name " +
					"the file where only the initials are to be saved?");
			theOutFile = kb.nextLine().trim();
			append = false;
			if (new File(theOutFile).exists()) {
				String checkAppend = null;
				System.out.print("I see that that file already exists," +
						"\nwould you like me to simply append the new data? [y/n] ");
				checkAppend = kb.nextLine().trim();
				if (checkAppend.equalsIgnoreCase("y")) {
					append = true;
				}
			}
			outInitials = new PrintWriter(new FileOutputStream(theOutFile, append));

			do {
				String fname = infile.next();
				String lname = infile.next();
				infile.nextLine();

				outCAPS.print(fname.toUpperCase() + " ");
				outCAPS.print(lname.toUpperCase() + "\n");
				outCAPS.flush();
				
				outInitials.print(fname.charAt(0) + ".");
				outInitials.print(lname.charAt(0) + ".\n");
				outInitials.flush();
				
			} while (infile.hasNext());
		} catch (FileNotFoundException ex) {
			System.err.println("FILE NOT FOUND!");
			System.exit(0);
		} catch (NoSuchElementException ex) {
			JOptionPane.showMessageDialog
			(null, 
					"You should have a blank line at the end of your text file.");
			str += ", with errors";
		} finally {		
			outCAPS.close();
			outInitials.close();
			infile.close();
		}
		System.out.println(str + ".");
		
		kb.close();
	}
}