package data_struct.in_class.d10_30;
// ****************************************************************************
//   Warning.java
// 
//   Reads student data from a text file and writes data to another text file.
// ****************************************************************************

import java.util.*;
import java.io.*;

public class Warning
{
    // --------------------------------------------------------------------
    //   Reads student data (name, semester hours, quality points) from a 
    //   text file, computes the GPA, then writes data to another file
    //   if the student is placed on academic warning.
    // -------------------------------------------------------------------- 
    public static void main (String[] args)
    {

	int creditHrs;         // number of semester hours earned
	double qualityPts;     // number of quality points earned
	double gpa;            // grade point (quality point) average

	String name, inputName = "students.txt";
	String outputName = "warning.txt";

	try 
	    {
		// Set up Scanner to input file
		Scanner scan = new Scanner(new File(inputName));

		// Set up the output file stream
		PrintWriter outFile = new PrintWriter(new File(outputName));

		// Print a header to the output file
		outFile.println ();
		outFile.println ("Students on Academic Warning");
		outFile.println ();

		// Process the input file, one token at a time
		while (scan.hasNext())
		    {
			// Get the credit hours and quality points and
			// determine if the student is on warning. If so,
			// write the student data to the output file.
			
			name = scan.next();
			creditHrs = scan.nextInt();
			qualityPts = scan.nextDouble();
			gpa = qualityPts / creditHrs;
			if (creditHrs < 30 && gpa < 1.5  || creditHrs < 60 && gpa < 1.75
			    || creditHrs >= 60 && gpa < 2.0)
			    
			    outFile.println (name + " " + creditHrs + " " + gpa);
		    }
		outFile.close();
	    }
		
	catch (FileNotFoundException e)
	    {
		System.out.println ("The file " + inputName + " was not found.");
	    }
	//Note that the Scanner throws an InputMismatchException, not a
	//NumberFormatException as indicated in the problem statement

	catch (InputMismatchException e)
	    {
		System.out.println("Format error in input file: " + e);
	    }

	}
}
