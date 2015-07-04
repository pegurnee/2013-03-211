package data_struct.labs.l03.a;
// **************************************************************** 
// DogTest.java 
// 
// A simple test class that creates a Dog and makes it speak. 
//           
// **************************************************************** 
/**
 * @author Eddie Gurnee
 * lab#3.1
 * 9/30/13
 *
 */
public class DogTest 
{ 
	public static void main(String[] args) 
	{ 
		Dog dog = new Dog("Spike"); 
		System.out.println(dog.getName() + " says " + dog.speak()); 

		//Create and print a Yorkshire and a Labrador 
		Yorkshire yorksure = new Yorkshire("Reginald"); 
		System.out.println(yorksure.getName() + " says " + yorksure.speak()); 

		Labrador labbynormal = new Labrador("Marley", "black"); 
		System.out.println(labbynormal.getName() + " says " + labbynormal.speak()); 


	} 
}