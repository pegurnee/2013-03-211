package data_struct.labs.l07;
/**
 * This in the in class lab 7
 * Reading in shapes from a text file, then organizing them into separate text files.
 * 
 * @author Eddie Gurnee
 * @version 11/04/2013
 * 
 */
// ****************************************************************************
//   Areas.java
// 
//   Reads shape data from a text file and writes data to corresponding text files.
// ****************************************************************************

import java.text.DecimalFormat;
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
		double area;			// area of the shape
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

		Scanner scan = null;
		PrintWriter circles = null;
		PrintWriter squares = null;
		PrintWriter rectangles = null;
		PrintWriter triangles = null;
		
		DecimalFormat pretty = new DecimalFormat(".00");
		Scanner kb = new Scanner(System.in);
		
		System.out.println("What shapes file are you reading from?");
		inputName = kb.next();
		
		try 
		{
			// Set up Scanner to input file
			scan = new Scanner(new File(inputName));

			// Set up the output file streams
			circles = new PrintWriter(new FileOutputStream(circleName));
			squares = new PrintWriter(new FileOutputStream(squareName));
			rectangles = new PrintWriter(new FileOutputStream(rectangleName));
			triangles = new PrintWriter(new FileOutputStream(triangleName));

			// Print a header to each of the output files
			circles.println ();
			circles.println ("Circles");
			circles.println ();

			squares.println ();
			squares.println ("Squares");
			squares.println ();			

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
				shapeType = scan.next();
				
				// Instantiate the correct object for shapeObj
				switch (shapeType) {
				case "Circle":
					name = "Circle";
					radius = scan.nextDouble();
					shapeObj = new Circle(name, radius);
					area = ((Circle)shapeObj).area();
					circles.println("Radius: " + pretty.format(radius) + 
							" Area: " + pretty.format(area));
					break;
				case "Square":
					name = "Square";
					side = scan.nextDouble();
					shapeObj = new Square(name, side);
					area = ((Square)shapeObj).area();
					squares.println("Side: " + pretty.format(side) + 
							" Area: " + pretty.format(area));
					break;
				case "Rectangle":
					name = "Rectangle";
					length = scan.nextDouble();
					width = scan.nextDouble();
					shapeObj = new Rectangle(name, width, length);
					area = ((Rectangle)shapeObj).area();
					rectangles.println("Length: " + pretty.format(length) + 
							" Width: " + pretty.format(width) + 
							" Area: " + pretty.format(area));
					break;
				case "Triangle":
					name = "Triangle";
					base = scan.nextDouble();
					height = scan.nextDouble();
					shapeObj = new Triangle(name, base, height);
					area = ((Triangle)shapeObj).area();
					triangles.println("Base: " + pretty.format(base) + 
							" Height: " + pretty.format(height) + 
							" Area: " + pretty.format(area));					
					break;
				}

				// Calculate the corresponding area using the correct area() method

				// Write the shape dimension(s) and area in the correct file				
			}
			System.out.println("Conversion Complete");
		}
		//Add a catch for each of the specified exceptions, and in each case 
		//give as specific a message as you can
		catch (FileNotFoundException ex) {
			System.err.println(ex);
		} catch (InputMismatchException ex) {
			System.err.println(ex);
		}

		//Close all files in a finally block
		finally {
			scan.close();

			circles.close();
			squares.close();
			rectangles.close();
			triangles.close();
		}
	}
}