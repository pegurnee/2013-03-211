package data_struct.in_class.d11_06;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * Testing output with Binary files
 * 
 * @author Elsa Poh
 * @author Eddie Gurnee
 * @version 11/06/2013
 *
 */
public class BinaryOutputDemo
{
	public static void main(String[] args)
	{
		try
		{
			ObjectOutputStream outputStream =
					new ObjectOutputStream(new FileOutputStream("numbers.bin"));

			int i;
			for (i = 0; i < 5; i++)
				outputStream.writeInt(i);

			System.out.println("Numbers written to the file numbers.bin.");
			outputStream.close( );
		}
		catch(IOException e)
		{
			System.out.println("Problem with file output.");
		}
	}
}
