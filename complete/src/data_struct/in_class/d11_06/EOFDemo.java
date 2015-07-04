package data_struct.in_class.d11_06;

import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.FileNotFoundException;
/**
 * Testing input with Binary files until end of file.
 * 
 * @author Elsa Poh
 * @author Eddie Gurnee
 * @version 11/06/2013
 *
 */
public class EOFDemo
{
	public static void main(String[] args)
	{
		try
		{
			ObjectInputStream inputStream =
					new ObjectInputStream(new FileInputStream("numbers.bin"));
			int number;
			System.out.println("Reading numbers in numbers.bin");
			try
			{
				while (true)
				{
					number = inputStream.readInt( );
					System.out.println(number);
				}
			}
			catch(EOFException e)
			{
				System.out.println("No more numbers in the file.");
			}
			inputStream.close( );
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Cannot find file numbers.bin.");
		}
		catch(IOException e)
		{
			System.out.println("Problem with input from file numbers.dat.");
		}
	}
}
