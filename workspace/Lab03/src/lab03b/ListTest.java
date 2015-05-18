package lab03b;
// ****************************************************************
// ListTest.java
//
// A simple test program that creates an IntList, puts some
// ints in it, and prints the list.
//
// ****************************************************************
/**
 * @author Eddie Gurnee
 * lab#3.2
 * 9/30/13
 *
 */
public class ListTest
{
	public static void main(String[] args)
	{
		IntList myList = new IntList(10);
		myList.add(100);
		myList.add(50);
		myList.add(200);
		myList.add(25);		
		System.out.println(myList);
		
		SortedIntList myBetterList = new SortedIntList(10);
		myBetterList.add(100);
		myBetterList.add(50);
		myBetterList.add(27);
		myBetterList.add(-22);
		myBetterList.add(200);
		myBetterList.add(500);
		myBetterList.add(25);
		myBetterList.add(-20);
		System.out.println(myBetterList);
	}
}