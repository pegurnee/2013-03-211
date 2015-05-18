package exam1;
/**
 * 
 * @author Eddie Gurnee
 * @version 10/07/13
 *
 */
public class Rectangle {	
	private double length;
	private double width;
	
	public Rectangle() {
		this(-1, -1);
	}
	
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	public double findArea() {
		return (this.length * this.width);
	}
	
	public String toString() {
		return "Length: " + this.length + "\nWidth: " + this.width;
	}
}