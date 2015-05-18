// ****************************************************************************
//   Areas.java
// 
//   Reads shape data from a text file and writes data to corresponding text files.
// ****************************************************************************

import java.util.*;
import java.io.*;

public class Areas
{
    // --------------------------------------------------------------------
    //   Reads shape data from a text file, computes the area, 
    //   then writes data to another file based on the shape type
    // -------------------------------------------------------------------- 
    public static void main (String[] args)
    {

	String shapeType;		// type of shape
	double area;         	// area of the shape
	double radius;    		// circle dimension
	double side;            // square dimension
	double length, width;	// rectangle dimensions
	double base, height;	// triangle dimensions

	String name, inputName = "shapes.txt";
	String circleName = "circles.txt";
	String squareName = "squares.txt";
	String rectangleName = "rectangles.txt";
	String triangleName = "triangles.txt";
	Shape shapeObj = null;

	try 
	    {
		// Set up Scanner to input file

		// Set up the output file streams

		// Print a header to each of the output files
		squares.println ();
		squares.println ("Squares");
		squares.println ();

		circles.println ();
		circles.println ("Circles");
		circles.println ();
		
		rectangles.println ();
		rectangles.println ("Rectangles");
		rectangles.println ();
		
		triangles.println ();
		triangles.println ("Triangles");
		triangles.println ();
		
		// Process the input file, one token at a time
		while (scan.hasNext())
		    {
			// Get the shape name and dimension(s)
			
			// Instantiate the correct object for shapeObj
			
			// Calculate the corresponding area using the correct area() method
			
			// Write the shape dimension(s) and area in the correct file
			
		    }
	    }
		
		//Add a catch for each of the specified exceptions, and in each case 
		//give as specific a message as you can
	
	
		//Close all files in a finally block
    }
}
