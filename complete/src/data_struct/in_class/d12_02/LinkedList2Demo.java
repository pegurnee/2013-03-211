package data_struct.in_class.d12_02;

public class LinkedList2Demo
{
    public static void main(String[] args)
    {
        LinkedList2 list = new LinkedList2( );
        list.addToEnd("Apples");
        list.addToEnd("Bananas");
        list.addToStart("Cantaloupe");
        System.out.println("List has " + list.size( ) 
                            + " nodes.");
        list.outputList( );

        if (list.contains("Cantaloupe"))
            System.out.println("Cantaloupe is on list.");
        else
            System.out.println("Cantaloupe is NOT on list.");

        list.deleteHeadNode( );
        list.deleteEndNode( );

        if (list.contains("Cantaloupe"))
            System.out.println("Cantaloupe is on list.");
        else
            System.out.println("Cantaloupe is NOT on list.");

        while (list.deleteHeadNode( ))
            ; //Empty loop body

        System.out.println("Start of list:");
        list.outputList( );
        System.out.println("End of list.");
    }
}
