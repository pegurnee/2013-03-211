// File: TemperatureConversion.java
// A Java application to print a temperature conversion table.
// Additional javadoc documentation is available at:
//   http://www.cs.colorado.edu/~main/docs/TemperatureConversion.html

import java.text.NumberFormat; // Used in the printNumber method.

/******************************************************************************
* The TemperatureConversion Java application prints a table 
* converting Celsius to Fahrenheit degrees.
*
* @see <A HREF="TemperatureConversion.java">
*      Java Source Code
*      (www.cs.colorado.edu/~main/applications/TemperatureConversion.java)
*      </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version
*   Feb 22, 1999
******************************************************************************/
public class TemperatureConversion 
{

   /**
   * The main method prints a Celsius to Fahrenheit conversion
   * table.
   * The bounds of the table range from -50C to +50C in 10 degree increments.
   * The String argumments (args) are not used
   * in this implementation.
   **/
   public static void main(String[ ] args) 
   {
      final double TABLE_BEGIN = -50.0; // The table's first Celsius temperature
      final double TABLE_END   =  50.0; // The table's final Celsius temperature
      final double TABLE_STEP  =  10.0; // Increment between temperatures in table
      final int    WIDTH       =     6; // Number of characters in output numbers
      final int    ACCURACY    =     2; // Number of digits to right of decimal pt
             
      double celsius;                   // A Celsius temperature
      double fahrenheit;                // The equivalent Fahrenheit temperature

      System.out.println("TEMPERATURE CONVERSION");
      System.out.println("----------------------"); 
      System.out.println("Celsius     Fahrenheit");
       
      for (celsius = TABLE_BEGIN; celsius <= TABLE_END; celsius += TABLE_STEP) 
      {  // Each iteration prints one line of the conversion table.
         fahrenheit = celsiusToFahrenheit(celsius);
         printNumber(celsius, WIDTH, ACCURACY);                               
         System.out.print("C        ");
         printNumber(fahrenheit, WIDTH, ACCURACY);
         System.out.println("F");
      }
      System.out.println("----------------------");
   }
 
        
   /**
   * Convert a temperature from Celsius degrees to Fahrenheit degrees.
   * 
   * @param c 
   *   a temperature in Celsius degrees
   * @precondition
   *   c >= -273.16.
   * @return 
   *   the temperature c converted to Fahrenheit
   * @throws java.lang.IllegalArgumentException
   *   Indicates that c is less than the smallest Celsius 
   *   temperature (-273.16).
   **/
   public static double celsiusToFahrenheit(double c)
   {
      final double MINIMUM_CELCIUS = -273.16;

      if (c < MINIMUM_CELCIUS)
         throw new IllegalArgumentException("Argument " + c + " is too small.");
      return (9.0/5.0)*c + 32;
   }

      
   /**
   * Print a number to System.out, using a specified format.
   * @param d
   *   the number to be printed
   * @param minimumWidth
   *   the minimum number of characters in the entire output
   * @param fractionDigits
   *   the number of digits to print on the right side of the decimal point
   * @precondition
   *   fractionDigits is not negative.
   * @postcondition
   *   The number d has been printed to System.out.
   *   This printed number is rounded to the specified number of digits on the
   *   right of the decimal. If fractionDigits is 0,
   *   then only the integer part of d is printed.
   *   If necessary, spaces appear at the front of the number to raise
   *   the total number of printed characters to the minimum. Additional
   *   formatting details are obtained from the current locale. For example,
   *   in the United States, a period is used for the decimal and commas are
   *   used to separate groups of integer digits.
   * @throws java.lang.IllegalArgumentException
   *   Indicates that fractionDigits is negative.
   * @example
   *   printNumber(12345.27, 8, 1); // Prints 12,345.3 in the U.S. 
   **/  
   public static void printNumber(double d, int minimumWidth, int fractionDigits)
   {
      // Note: getNumberInstance( ) creates a NumberFormat object using
      // local information about the characters for a decimal point and
      // separators.
      NumberFormat form = NumberFormat.getNumberInstance( );
      String output;
      int i;

      // Set the number of digits to appear on the right of the decimal.
      if (fractionDigits < 0)
         throw new IllegalArgumentException("fractionDigits < 0:" + fractionDigits);
      form.setMinimumFractionDigits(fractionDigits);
      form.setMaximumFractionDigits(fractionDigits);
        
      // Round and format the number.
      output = form.format(d);
      
      for (i = minimumWidth-output.length( ); i > 0; i--)
	   System.out.print(' ');
      System.out.print(output);
   }
         
}
