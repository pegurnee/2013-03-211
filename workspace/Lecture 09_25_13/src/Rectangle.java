
public class Rectangle  extends Shape {
	private double length;
	private double width;
	
	public Rectangle() {
		this(4, "red", true, 0, 0);
		
//		super();
//		
//		this.length = 0;
//		this.width = 0;
	}
	
	public Rectangle(int sides, String color, boolean filled, double length, double width) {
		super(sides, color, filled);
		
		this.length = length;
		this.width = width;
	}
	
	public double getLength() {
		return this.length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	public double getWidth() {
		return this.width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	
	public String toString() {
		String str = "Not filled";
		if (getFilled()) {
			str = "Filled with color";
		}
		return "Sides: " + getSides() + "\nColor: " + getColor() + "\n" + str + "\nLength: " + this.length + "\nWidth: " + this.width;
	}
	
	public boolean equals(Rectangle otherRectangle) {
		return (this.getSides() == otherRectangle.getSides()) 
				&& (this.getColor().equals(otherRectangle.getColor())) 
				&& (this.getFilled() == otherRectangle.getFilled());
	}
}