/**
 * The first demo of recursion.
 * 
 * @author Elsa Poh
 * @version 11/13/2013
 */
public class RecursionDemo1 {
    public static void main(String[] args) {
        System.out.println("writeVertical(3):");
        writeVertical(3);

        System.out.println("writeVertical(12):");
        writeVertical(12);

        System.out.println("writeVertical(123):");
        writeVertical(123);

        System.out.println("Magnitude of 55555= " + magnitude(55555));
    }

    public static void writeVertical(int n) {
        if (n < 10) {
            System.out.println(n);
        } else // n is two or more digits long:
        {
            writeVertical(n / 10);
            System.out.println(n % 10);
        }
    }

    public static int magnitude(int x) {
        if (x < 1)
            return 0;
        else
            return magnitude(x / 10) + 1;
    }
}
