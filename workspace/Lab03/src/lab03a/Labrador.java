package lab03a;
// **************************************************************** 
// Labrador.java 
// 
// A class derived from Dog that holds information about 
// a labrador retriever.  Overrides Dog speak method and includes 
// information about avg weight for this breed. 
// **************************************************************** 
/**
 * @author Eddie Gurnee
 *
 */
public class Labrador extends Dog 
{ 
	@SuppressWarnings("unused")
	private String color;              //black, yellow, or chocolate? 
	@SuppressWarnings("unused")
	private int breedWeight = 75; 

	//Initial Labrador constructor did not invoke the super()
	//constructor to access the dog class constructor
	public Labrador(String name,  String color) 
	{ 
		super(name);
		this.color = color;
	} 

	// ------------------------------------------------------------ 
	// Big bark -- overrides speak method in Dog 
	// ------------------------------------------------------------ 
	public String speak() 
	{ 
		return "WOOF"; 
	} 
}