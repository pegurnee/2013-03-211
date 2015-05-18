package lab09b;

// ******************************************************************
// Backwards.java
//
// Uses a recursive method to print a string backwards.
// ******************************************************************
import java.util.Scanner;

/**
 * This class is for lab9b, used to print out a string backwards.
 * 
 * @author Eddie Gurnee
 * @version 11/19/2013
 */
public class Backwards {

    // --------------------------------------------------------------
    // Reads a string from the user and prints it backwards.
    // --------------------------------------------------------------
    public static void main(String[] args) {
        String msg;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a string: ");
        msg = scan.nextLine();

        System.out.print("\nThe string backwards: ");
        printBackwards(msg);
        System.out.println();

        scan.close();
    }

    // --------------------------------------------------------------
    // Takes a string and recursively prints it backwards.
    // --------------------------------------------------------------
    public static void printBackwards(String s) {
        // Fill in code
        if (s.length() != 0) {
            printBackwards(s.substring(1));
            System.out.print(s.substring(0, 1));
        }

    }
}
