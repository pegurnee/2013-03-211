package lab06b;
/**
 * This class is the MathUtils class, made awesome by Eddie Gurnee
 * 
 * @author Eddie Gurnee
 * @version 10/28/2013
 *
 */
// ****************************************************************
// MathUtils.java
//
// Provides static mathematical utility functions.
//
// ****************************************************************
public class MathUtils
{
//-------------------------------------------------------------
// Returns the factorial of the argument given
//-------------------------------------------------------------
	public static int factorial(int n) throws IllegalArgumentException
	{
		//Awesome additions by eddie
		if (n < 0) {
			throw new IllegalArgumentException(n + " is a negative number, you silly goose.");
		} else if (n > 16) {
			throw new IllegalArgumentException(n + " is far too large, you silly goose.");
		}
		
		int fac = 1;
		for (int i=n; i>0; i--)
			fac *= i;
		return fac;
	}
}