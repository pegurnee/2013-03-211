// ****************************************************************************
//   Warning.java
// 
//   Reads employee data from a binary file and writes data to a text file.
// ****************************************************************************

import java.util.*;
import java.io.*;

public class Payroll
{
    // --------------------------------------------------------------------
    //   Reads employee data from a binary file of HourlyEmployee data,
    //   computes the weekly pay, then writes data to another file.
    // -------------------------------------------------------------------- 
    public static void main (String[] args)
    {

	HourlyEmployee emp;		
	double weeklyPay;            

	String inputName = "hourly.dat";
	String outputName = "payroll.txt";

	try 
	    {
		// Set up ObjectOutputStream to input file

		// Set up the output file stream

		// Print a header to the output file
		outFile.println ();
		outFile.println ("Weekly Payroll");
		outFile.println ();

		// Process the input file, one token at a time
		try
            {
                while (true)
				{
				// Read each HourlyEmployee object from the file
				// Calculate the weekly pay
				// Write the employee's name and weekly pay to the output file
				}
			    inputStream.close( );
		    }
		//Add a catch for  EOFException

	    }
		
	//Add a catch for each of the specified exceptions, and in each case 
	//give as specific a message as you can
	
	
	//Close the output file in a finally block
    }
}
