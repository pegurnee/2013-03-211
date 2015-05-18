package lab10b;

// ***********************************************************
// LinkedQueue.java
// A linked-list implementation of the classic FIFO queue interface.
// ***********************************************************
/**
 * Expanded the LinkedQueue class for lab10, also to fiddle with LinkedLists.
 * 
 * @author Eddie Gurnee
 * @version 12/09/2013
 * 
 */
public class LinkedQueue implements QueueADT {
    private Node front, back;
    private int numElements;

    // ---------------------------------------------
    // Constructor; initializes the front and back pointers
    // and the number of elements.
    // ---------------------------------------------
    public LinkedQueue() {
        this.front = null;
        this.back = null;
        this.numElements = 0;
    }

    // ---------------------------------------------
    // Puts item on end of queue.
    // ---------------------------------------------
    public void enqueue(Object item) {
        Node temp = new Node(item);
        if (this.front != null) {
            this.back.setNext(temp);
        } else {
            this.front = temp;
        }
        this.back = temp;
        this.numElements++;
    }

    // ---------------------------------------------
    // Removes and returns object from front of queue.
    // ---------------------------------------------
    public Object dequeue() {
        Object item = null;
        item = this.front.getElement();
        this.front = this.front.getNext();
        this.numElements--;
        return item;
    }

    // ---------------------------------------------
    // Returns true if queue is empty.
    // ---------------------------------------------
    public boolean isEmpty() {
        return (this.front == null);
    }

    // ---------------------------------------------
    // Returns true if queue is full, but it never is.
    // ---------------------------------------------
    public boolean isFull() {
        return false;
    }

    // ---------------------------------------------
    // Returns the number of elements in the queue.
    // ---------------------------------------------
    public int size() {
        return this.numElements;
    }

    // ---------------------------------------------
    // Returns a string containing the elements of the queue
    // from first to last
    // ---------------------------------------------
    public String toString() {
        String result = "\n";
        Node temp = front;
        while (temp != null) {
            result += temp.getElement() + "\n";
            temp = temp.getNext();
        }
        return result;
    }
}