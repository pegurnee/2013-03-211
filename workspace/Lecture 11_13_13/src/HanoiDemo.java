import java.util.Scanner;

/**
 * Tester for the tower of Hanoi.
 * 
 * @author Elsa Poh
 * @version 11/13/2013
 */
public class HanoiDemo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of discs: ");
        int numDiscs = scan.nextInt();
        Hanoi towersOfHanoi = new Hanoi(numDiscs);
    }

}
