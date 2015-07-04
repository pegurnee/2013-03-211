package data_struct.labs.l08;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Demonstrates binary file I/O of serializable class objects.
 */
public class CreateHourly {

    public static void main(String[] args) {

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(
                    new FileOutputStream("hourly.dat"));

            HourlyEmployee emp1 = new HourlyEmployee("George", 10.50, 25);
            HourlyEmployee emp2 = new HourlyEmployee("Marvin", 15.50, 50);
            HourlyEmployee emp3 = new HourlyEmployee("Harold", 12.25, 37);

            outputStream.writeObject(emp1);
            outputStream.writeObject(emp2);
            outputStream.writeObject(emp3);

            outputStream.close();

            System.out.println("Data sent to file.");
        } catch (IOException e) {
            System.out.println("Problem with file output.");
        }

        System.out.println("Now let's reopen the file and display the data.");

        try {
            ObjectInputStream inputStream = new ObjectInputStream(
                    new FileInputStream("hourly.dat"));

            HourlyEmployee readOne = (HourlyEmployee)inputStream.readObject();
            HourlyEmployee readTwo = (HourlyEmployee)inputStream.readObject();
            HourlyEmployee readThree = (HourlyEmployee)inputStream.readObject();

            System.out.println("The following were read from the file:");
            System.out.println(readOne);
            System.out.println(readTwo);
            System.out.println(readThree);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find datafile.");
        } catch (ClassNotFoundException e) {

            System.out.println("Problems with file input.");
        } catch (IOException e) {
            System.out.println("Problems with file input.");
        }

        System.out.println("End of program.");
    }
}
