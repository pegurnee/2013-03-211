package extracredit;

import java.util.Scanner;

/**
 * The driver used to test the Extra Credit LinkedListEC
 * 
 * @author Eddie Gurnee
 * @version 12/02/2013
 * @see LinkedListEC
 * @see Student
 */
public class LinkedListECDriver {
    private static LinkedListEC<Student> list;
    private static Scanner kb;

    public static void main(String[] args) {
        list = new LinkedListEC<Student>();
        kb = new Scanner(System.in);

        // a few of default students
        list.addToFront(new Student("0024", "Eddie", "Gurnee"));
        list.addToFront(new Student("0021", "Nicole", "Downer"));
        list.addToFront(new Student("0025", "Mike", "Nitchie"));
        list.addToFront(new Student("0026", "Nicole", "Arruda"));
        list.addToFront(new Student("0037", "Carlos", "Mora"));

        int response;

        do {
            System.out.println();
            System.out.println("1: Add a new student");
            System.out.println("2: Delete a student");
            System.out.println("3: Find a student by ID");
            System.out.println("4: List students forward");
            System.out.println("5: List students backward");
            System.out.println();
            System.out.println("0: End\n");
            System.out.print("~" + System.getProperty("user.name") + "$: ");

            response = kb.nextInt();
            kb.nextLine();
            System.out.println();

            switch (response) {
            case 1:
                addIt();
                break;
            case 2:
                deleteIt();
                break;
            case 3:
                findIt();
                break;
            case 4:
                listItForward();
                break;
            case 5:
                listItBackward();
                break;
            default:
            }

        } while (response != 0);

        kb.close();
    }

    public static void addIt() {
        String fName, lName, tempID = "";
        boolean invalid = true;

        while (invalid) {
            System.out.println("Enter a unique ID number to add");
            tempID = kb.nextLine();
            invalid = list.search(new Student(tempID));
            if (invalid) {
                System.out.println("That is not a unique ID."
                        + "\nPlease enter a unique ID number.");
            }
        }

        System.out.println("Enter first name");
        fName = kb.nextLine();
        System.out.println("Enter last name");
        lName = kb.nextLine();

        Student tempStudent = new Student(tempID, fName, lName);
        list.addToFront(tempStudent);

        // kb.close();
    }

    public static void deleteIt() {
        System.out.print("Enter a unique ID number to delete: ");
        String tempID = kb.nextLine();

        if (!list.deleteHere(new Student(tempID))) {
            System.out.println("Student ID not found.");
        }
    }

    public static void findIt() {
        System.out.print("Enter a unique ID number to display: ");
        String tempID = kb.nextLine();

        if (!list.display(new Student(tempID))) {
            System.out.println("Student ID not found.");
        }
    }

    public static void listItForward() {
        list.outputListRec();
    }

    public static void listItBackward() {
        list.outputListRecBackwards();
    }

}
