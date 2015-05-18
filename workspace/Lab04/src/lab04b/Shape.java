package lab04b;
/**
 * The abstract class from which all these other shapes are derived
 * 
 * @author Eddie Gurnee
 * @version 10/14/2013
 *
 */
public abstract class Shape {
	protected String shapeName;
	
	/**
	 * No args constructor for shape, defaults named as "no shape"
	 */
	public Shape() {
		this("no shape");
	}
	/**
	 * The constructor for the shape class
	 * 
	 * @param shapeName is the name of the shape
	 */
	public Shape(String shapeName) {
		this.shapeName = shapeName;
	}
	
	public abstract double area();
	
	public String toString() {
		return shapeName;
	}
}
