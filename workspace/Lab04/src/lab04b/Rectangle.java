package lab04b;
/**
 * This is a rectangle for lab4
 * 
 * @author Eddie Gurnee
 * @version 10/14/2013
 */
public class Rectangle extends Shape {
	protected double width;
	protected double height;

	public Rectangle() {
		this("no rectangle", -1, -1);
	}

	public Rectangle(String shapeName, double width, double height) {
		super(shapeName);
		this.width = width;
		this.height = height;
	}

	@Override
	public double area() {
		return width * height;
	}

	public String toString() 
	{ 
		return super.toString() + " with width " + width + " and height " + height + "."; 
	}
}
