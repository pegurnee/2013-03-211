package data_struct.labs.l04.b;
/**
 * This is a cylinder for lab4
 * 
 * @author Eddie Gurnee
 * @version 10/14/2013
 */
public class Cylinder extends Shape {
	protected double height;
	protected double radius;
	
	public Cylinder() {
		this("no cylinder", -1, -1);
	}

	public Cylinder(String shapeName, double height, double radius) {
		super(shapeName);
		this.height = height;
		this.radius = radius;
	}

	@Override
	public double area() {
		return Math.PI * radius * radius * height;
	}

	public String toString() 
	{ 
		return super.toString() + " with radius of " + radius + " and height " + height + "."; 
	}
}
