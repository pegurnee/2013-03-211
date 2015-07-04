package data_struct.in_class.d11_13;
import java.util.Scanner;

/**
 * @author Elsa Poh
 * @version 11/13/2013
 */
public class F_test {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scan.nextInt();

        System.out.println("Sum = " + sum(num));
        System.out.println("Factorial = " + factorial(num));

        // checking extra credit
        // ec(2);

    }

    public static int sum(int n) {
        if (n <= 0)
            return 0;
        else
            return (n + sum(n - 1));
    }

    public static int factorial(int n) {
        if (n <= 1)
            return 1;
        else
            return (n * factorial(n - 1));
    }

    /**
     * Write a recursive method with a parameter that is a non-negative integer.
     * The method write that number of asterisks to the screen followed by that
     * number of exclamation points. Use no loops or local variables.
     **/
    public static void ec(int n) {
        // Recursive
        System.out.print("*");
        if (n > 1)
            ec(n - 1);
        System.out.print("!");

        // Iterative
        // for (int i = 0; i < n; i++) {
        // System.out.print("*");
        // }
        // for (int i = 0; i < n; i++) {
        // System.out.print("!");
        // }
    }

}
