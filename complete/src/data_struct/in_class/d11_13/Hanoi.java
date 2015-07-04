package data_struct.in_class.d11_13;
/**
 * Tower of Hanoi
 * 
 * @author Elsa Poh
 * @version 11/13/2013
 */
public class Hanoi {
    private int numDiscs;
    private static int count = 1;

    public Hanoi(int n) {
        numDiscs = n;
        moveDiscs(numDiscs, 1, 3, 2);
    }

    private void moveDiscs(int num, int fromPeg, int toPeg, int tempPeg) {

        if (num > 0) {
            moveDiscs(num - 1, fromPeg, tempPeg, toPeg);
            System.out.println("Step " + (count++) + ": Move a disc from peg "
                    + fromPeg + " to peg " + toPeg);
            moveDiscs(num - 1, tempPeg, toPeg, fromPeg);
        }

    }
}
