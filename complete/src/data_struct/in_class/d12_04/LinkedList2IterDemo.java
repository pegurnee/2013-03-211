package data_struct.in_class.d12_04;
public class LinkedList2IterDemo {
    public static void main(String[] args) {
        LinkedList2Iter list = new LinkedList2Iter();
        LinkedList2Iter list2 = new LinkedList2Iter();
        LinkedList2Iter.List2Iterator i = list.iterator();
        // LinkedList2Iter.List2Iterator i = list.new List2Iterator();
        LinkedList2Iter.List2Iterator k = list2.iterator();

        list.addToStart("shoes");
        list.addToStart("orange juice");
        list.addToStart("coat");

        System.out.println("List contains");
        i.restart();
        while (i.hasNext())
            System.out.println(i.next());
        System.out.println();

        i.restart();
        i.next();
        i.delete();

        System.out.println("List now contains");
        i.restart();
        while (i.hasNext())
            System.out.println(i.next());
        System.out.println();

        i.restart();
        i.next();
        i.addHere("socks");

        i.restart();
        while (i.hasNext())
            System.out.println(i.next());
        System.out.println();
    }

}
