package lab10a;

/**
 * HugeNumber.java
 * 
 * This program implements a class that can store extremely large numbers by
 * storing each digit as a node in a doubly-linked list.
 * 
 * 
 * Created: Sun Apr 3 2005
 * 
 * @author Kenrick Mock
 * @version 1
 */
/**
 * Expanded the HugeNumber class for lab 10, to fiddle with LinkedLists.
 * 
 * @author Eddie Gurnee
 * @version 12/09/2013
 * 
 */
class HugeNumber {

    /**
     * Inner class to store a digit within a node
     */
    private class DigitNode {
        private int digit = 0;			// Value for this digit
        private DigitNode next = null;	// Reference to next digit
        private DigitNode prev = null;	// Reference to previous digit

        /**
         * DigitNode constructor, initializes number
         */
        public DigitNode(int d) {
            this.digit = d;
        }

        /* Accessor and mutator methods */
        public int getDigit() {
            return digit;
        }

        public void setDigit(int d) {
            digit = d;
        }

        public DigitNode getNext() {
            return next;
        }

        public void setNext(DigitNode nextNode) {
            next = nextNode;
        }

        public DigitNode getPrev() {
            return prev;
        }

        public void setPrev(DigitNode prevNode) {
            prev = prevNode;
        }
    }

    // Variable declarations
    private DigitNode head = null;	// Head points to the most significant digit
                                   // in the list
    private DigitNode tail = null;		// Tail points to the least significant digit

    // in the list

    /**
     * Constructor
     */
    public HugeNumber() {
        head = new DigitNode(0);
        tail = null;
    }

    /**
     * Deep copy constructor
     * 
     * @param newVal
     *            Input HugeNumber to copy to this HugeNumber
     */
    public HugeNumber(HugeNumber newVal) {
        // Traverse the input HugeNumber, copying each node to a new list
        DigitNode current = newVal.head;
        DigitNode temp;  // Copy of current node
        DigitNode prev;  // Previous node for the copy so we can set up the
                        // double link

        if (current != null) {
            // Create head
            this.head = new DigitNode(current.getDigit());
            prev = head;

            // Iterate through the rest of the list, making a copy of each node
            // and setting the previous and next references in the copy
            current = current.getNext();
            while (current != null) {
                temp = new DigitNode(current.getDigit());
                prev.setNext(temp);
                temp.setPrev(prev);
                prev = temp;
                current = current.getNext();
            }
            // Set tail to prev, the last thing in the copy
            this.tail = prev;
        }
    }

    /**
     * Adds a input HugeNumber to this HugeNumber. It traverses the linked
     * lists, adding each digit starting from the least significant digit and
     * working up to the most significant digit.
     * 
     * @param otherNum
     *            target HugeNumber to add
     * @return HugeNumber HugeNumber that represents the sum of the two
     *         HugeNumbers
     */
    public HugeNumber add(HugeNumber otherNum) {
        HugeNumber temp = new HugeNumber(this);
        DigitNode position = temp.tail;
        DigitNode otherPosition = otherNum.tail;
        int carry = 0;
        while (position != null && otherPosition != null) {
            int sum = position.getDigit() + otherPosition.getDigit() + carry;
            if (sum >= 10) {
                position.setDigit(sum % 10);
                carry = 1;
            } else {
                position.setDigit(sum);
                carry = 0;
            }
            position = position.getPrev();
            otherPosition = otherPosition.getPrev();
        }
        if (otherPosition != null && position == null) {
            while (otherPosition != null) {
                int sum = otherPosition.getDigit() + carry;
                if (sum >= 10) {
                    sum = sum % 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                temp.addDigit(sum);
                otherPosition = otherPosition.getPrev();
            }
        }
        if (carry > 0) {
            temp.addDigit(carry);
        }
        return temp;
    }

    /**
     * addDigit adds a new digit, d, as a new most significant digit for the
     * list.
     * 
     * @param d
     *            new digit to add as the MSD
     */
    public void addDigit(int d) {
        DigitNode newDigit = new DigitNode(d);
        if (tail == null) {
            head = newDigit;
            tail = newDigit;
        } else {
            // Make the new digit's next point to the previously
            // most significant digit
            newDigit.setNext(head);
            // Make head's previous point to the new digit
            head.setPrev(newDigit);
            // Set the head to the new most significant digit
            head = newDigit;
        }
    }

    /**
     * Resets the HugeNumber to a null, empty value
     */
    public void resetValue() {
        head = null;
        tail = null;
    }

    /**
     * @return String The HugeNumber converted to a string
     */
    public String toString() {
        String temp = "";
        DigitNode position = this.head;
        while (position != null) {
            temp += position.getDigit();
            position = position.getNext();
        }
        return temp;
    }
}
