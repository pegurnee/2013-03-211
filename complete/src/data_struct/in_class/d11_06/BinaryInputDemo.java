package data_struct.in_class.d11_06;

import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
//import java.io.EOFException;
/**
 * Testing input with Binary files.
 * 
 * @author Elsa Poh
 * @author Eddie Gurnee
 * @version 11/06/2013
 *
 */
public class BinaryInputDemo
{
	public static void main(String[] args)
	{
		ObjectInputStream inputStream = null;
		try
		{
			inputStream = 
					new ObjectInputStream(new FileInputStream("numbers.bin"));

			System.out.println("Reading the file numbers.bin.");


			int n1 = inputStream.readInt( );
			int n2 = inputStream.readInt( );
				
			System.out.println("Numbers read from file:");
			
			System.out.println(n1);
			System.out.println(n2);

			inputStream.close( );

		}
		catch(FileNotFoundException e)
		{
			System.out.println("Cannot find file numbers.bin.");
		}
		catch(IOException e)
		{
			System.out.println("Problems with input from numbers.bin.");
		}
		finally
		{
			
		}
	}
}


