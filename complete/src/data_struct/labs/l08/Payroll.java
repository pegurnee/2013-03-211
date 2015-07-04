package data_struct.labs.l08;

// ****************************************************************************
// Warning.java
//
// Reads student data from a text file and writes data to another text file.
// ****************************************************************************

import java.util.*;
import java.io.*;

/**
 * This is the in class Lab 8. Using doing input and output with binary files.
 * 
 * @author Eddie Gurnee
 * @version 11/18/2013
 */
public class Payroll {
    // --------------------------------------------------------------------
    // Reads student data (name, semester hours, quality points) from a
    // text file, computes the GPA, then writes data to another file
    // if the student is placed on academic warning.
    // --------------------------------------------------------------------
    public static void main(String[] args) {

        HourlyEmployee emp;
        double weeklyPay;

        String inputName = "hourly.dat";
        String outputName = "payroll.txt";

        try {
            // Set up ObjectInputStream to input file
            ObjectInputStream inputStream = new ObjectInputStream(
                    new FileInputStream(inputName));

            // Set up the output file stream
            PrintWriter outFile = new PrintWriter(new FileWriter(new File(
                    outputName)));

            // Print a header to the output file
            outFile.println();
            outFile.println("Weekly Payroll");
            outFile.println();

            // Process the input file, one token at a time
            try {
                while (true) {
                    // Read each HourlyEmployee object from the file
                    emp = (HourlyEmployee)inputStream.readObject();
                    // Calculate the weekly pay
                    weeklyPay = emp.getPay() / 4;
                    // Write the employee's name and weekly pay to the output
                    // file
                    outFile.println(emp.toString() + ": $" + weeklyPay
                            + " a week");
                }
                // Add a catch for EOFException
            } catch (EOFException e) {
                inputStream.close();
            } finally {
                outFile.close();
            }

            System.out.println("Payroll saved successfully to " + outputName);

            // Add a catch for each of the specified exceptions, and in each
            // case
            // give as specific a message as you can

            // Close the output file in a finally block
        } catch (FileNotFoundException e) {
            System.out.println("The load file " + inputName
                    + " cannot be found.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("The binary file " + inputName
                    + " does not contain data for HourlyEmployee objects.");
            e.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Something else that is bad just happened.");
            ex.printStackTrace();
        }
    }
}
