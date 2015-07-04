package data_struct.in_class.d12_02;

public class LinkedList1Demo
{
    public static void main(String[] args)
    {
        LinkedList1 list = new LinkedList1( );
        list.addToEnd("Apples", 1);
        list.addToEnd("Bananas", 2);
        list.addToEnd("Cantaloupe", 3);
        System.out.println("List has " + list.size( ) 
                            + " nodes.");
        list.outputList( );

        if (list.contains("Cantaloupe"))
            System.out.println("Cantaloupe is on list.");
        else
            System.out.println("Cantaloupe is NOT on list.");

        list.deleteEndNode( );

        if (list.contains("Cantaloupe"))
            System.out.println("Cantaloupe is on list.");
        else
            System.out.println("Cantaloupe is NOT on list.");

        //while (list.deleteHeadNode( ))
            ; //Empty loop body
        
        list.clear();
        
        System.out.println("Start of list:");
        list.outputList( );
        System.out.println("End of list.");
    }
}
