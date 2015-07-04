package data_struct.labs.l10.a;

public class TestHugeNumber {
    /**
     * Main method with some test code
     */
    public static void main(String[] args) {
        // Create a HugeNumber that is 123456789
        HugeNumber h1 = new HugeNumber();
        for (int i = 9; i >= 1; i--) {
            h1.addDigit(i);
        }
        System.out.println(h1);

        // Create a HugeNumber that is 55555555558888888888
        HugeNumber h2 = new HugeNumber();
        for (int i = 0; i < 10; i++) {
            h2.addDigit(8);
        }
        for (int i = 0; i < 10; i++) {
            h2.addDigit(5);
        }
        System.out.println("h2 is: " + h2);

        // Make a copy of h1
        HugeNumber h3 = new HugeNumber(h1);
        System.out.println("h3 is " + h3);

        // Reset h1
        h1.resetValue();
        // Change original source for h3
        System.out.println("h1 after reset:" + h1);
        // Should remain unchanged
        System.out.println("h3 after h1 reset:" + h3);

        // Add h3 to 987654321
        HugeNumber h4 = new HugeNumber();
        for (int i = 1; i <= 9; i++) {
            h4.addDigit(i);
        }

        HugeNumber h5 = h3.add(h4);
        System.out.println(h5);

    }
} // HugeHumber

