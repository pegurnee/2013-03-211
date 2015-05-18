package lab09a;

// ******************************************************************
// BaseConversion.java
//
// Recursively converts an integer from base 10 to another base
// ******************************************************************

import java.util.Scanner;

/**
 * This is for the first part of Lab 9, all about converting base 10 numbers to
 * other bases.
 * 
 * @author Eddie Gurnee
 * @version 11/19/2013
 */
public class BaseConversion {

    public static final String[] EXTRA_DIGITS = {
            "A", "B", "C", "D", "E", "F"
    };

    public static void main(String[] args) {
        int base10Num;
        int base;

        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.println("Base Conversion Program");
        System.out.print("Enter an integer: ");
        base10Num = scan.nextInt();
        System.out.print("Enter the base: ");
        base = scan.nextInt();

        // Call convert and print the answer
        System.out.println(base10Num + " in base " + base + " is "
                + convert(base10Num, base));

        scan.close();
    }

    // --------------------------------------------------
    // Converts a base 10 number to another base.
    // --------------------------------------------------
    public static String convert(int num, int b) {
        int quotient; // the quotient when num is divided by base b
        int remainder; // the remainder when num is divided by base b

        quotient = num / b;
        remainder = num % b;

        String remain;
        if (remainder > 9) {
            remain = EXTRA_DIGITS[remainder - 10];
        } else {
            remain = "" + remainder;
        }

        if (quotient == 0) {
            return remain;
        } else {
            return convert(quotient, b) + remain;
        }

    }

}
