package data_struct.in_class.d12_04.extra_credit;

/**
 * EC +5 points each 1. public boolean deleteHere(String target) Finds and
 * deletes the first node containing the target item and returns true if item
 * deleted or false if item is not in the list. 2. public void outputListRec()
 * -prints the list from first to last using recursion. Hint: The basic idea is
 * that you print the first item in the list then do a recursive call to print
 * the rest of the list. This means you need to keep track of what hasn't been
 * printed yet (the "rest" of the list). In particular, your recursive method
 * needs to know where the first item is. Note that printRec() has no parameter
 * so you need to use a helper method that does most of the work. It should have
 * a parameter that lets it know where the part of the list to be printed
 * starts. 3. public void outputListRecBackwards() -prints the list from last to
 * first using recursion. Hint: Printing backward recursively is just like
 * printing forward recursively except you print the rest of the list before
 * printing this element.
 */
/**
 * 
 * @author Eddie Gurnee
 * @version 12/02/2013
 * @see Student
 * @param <T>
 *            what the list is to be composed of, needs a valid equals and
 *            toString method
 */
public class LinkedListEC<T> {

    @SuppressWarnings("hiding")
    private class NodeEC<T> {
        private NodeEC<T> link;
        private T data;

        private NodeEC() {
            this(null, null);
        }

        private NodeEC(NodeEC<T> link, T data) {
            this.link = link;
            this.data = data;
        }

        private T getItem() {
            return this.data;
        }

        private NodeEC<T> getLink() {
            return this.link;
        }

        private void setLink(NodeEC<T> newLink) {
            this.link = newLink;

        }
    }

    private NodeEC<T> head;

    /**
     * Known in the computer science field as a push, but what do i know
     * 
     * @param newData
     *            the data to be added to the front of the list
     */
    public void addToFront(T newData) {
        this.head = new NodeEC<T>(head, newData);
    }

    /**
     * Recursively prints out the list from first to last
     */
    public void outputListRec() {
        outputRec(this.head, true);
    }

    /**
     * Recursively prints out the list from last to first
     */
    public void outputListRecBackwards() {
        outputRec(this.head, false);
    }

    /**
     * @param position
     *            The current position along the LinkedList
     * @param forward
     *            Whether the list should be displayed forwards or backwards
     */
    private void outputRec(NodeEC<T> position, boolean forward) {
        if (position != null) {
            if (forward) {
                outputRec(position.getLink(), forward);
                System.out.println(position.getItem());
            } else {
                System.out.println(position.getItem());
                outputRec(position.getLink(), forward);
            }
        }
    }

    /**
     * Iteratively prints out the list
     */
    public void outputList() {
        NodeEC<T> position = head;
        while (position != null) {
            System.out.println(position.getItem());
            position = position.getLink();
        }
    }

    public boolean search(T target) {
        NodeEC<T> position = head;
        boolean found = false;
        while (position != null) {
            if (position.getItem().equals(target)) {
                found = true;
                break;
            } else {
                position = position.getLink();
            }
        }
        return found;
    }

    public boolean deleteHere(T target) {
        NodeEC<T> position = head;
        NodeEC<T> lastposition = position;
        if (head != null) {
            while (!position.getItem().equals(target)) {
                lastposition = position;
                position = position.getLink();
            }
            lastposition.setLink(position.getLink());
            return true;
        } else {
            return false;
        }
    }

    public boolean display(T target) {
        NodeEC<T> position = head;
        if (head != null) {
            while (!position.getItem().equals(target)) {
                position = position.getLink();
            }
            System.out.println(position.getItem());
            return true;
        } else {
            return false;
        }
    }

}
