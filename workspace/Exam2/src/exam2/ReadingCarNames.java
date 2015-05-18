package exam2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * @author Eddie Gurnee
 * @version 11/11/13
 *
 */
public class ReadingCarNames {
	public static void main(String[] args) {
		File carf = new File("car_names.txt");

		Scanner carsIn = null;
		PrintWriter vowelsOut = null;
		
		try {
			carsIn = new Scanner(new FileInputStream(carf));
			vowelsOut = new PrintWriter(new File("vowel_names.txt"));

			while (carsIn.hasNextLine()) {
				String oneCar = carsIn.nextLine();

				try {
					switch (oneCar.charAt(0)) {
					case 'A': case 'a':
					case 'E': case 'e':
					case 'I': case 'i':
					case 'O': case 'o':
					case 'U': case 'u':
					case 'Y': case 'y':
						vowelsOut.println(oneCar);
						break;
					default:
						//do nothing
						break;
					}
				} catch (StringIndexOutOfBoundsException ex) {
					//For blank lines; 0 length strings
				}
			}

			carf.renameTo(new File("all_car_names.txt"));
			
			System.out.println("Tranfer was a great success!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			vowelsOut.close();
		}
	}
}