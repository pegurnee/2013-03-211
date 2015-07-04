package data_struct.in_class.d09_25;

public class Shape {
	private int sides;
	private String color;
	private boolean filled;
	
	public Shape() {
		this(0, "red", true);
		
//		sides = 0;
//		color = "red";
//		filled = true;
	}
	
	public Shape(int sides, String color, boolean filled) {
		this.sides = sides;
		this.color = color;
		this.filled = filled;		
	}
	
	public int getSides() {
		return this.sides;
	}	
	public void setSides(int sides) {
		this.sides = sides;
	}
	
	public String getColor() {
		return this.color;
	}	
	public void setColor(String color) {
		this.color = color;
	}	
	
	public boolean getFilled() {
		return this.filled;
	}	
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public String toString() {
		String str = "Not filled";
		if (filled) {
			str = "Filled with color";
		}
		return "Sides: " + this.sides + "\nColor: " + this.color + "\n" + str;
	}
	
	public boolean equals(Shape otherShape) {
		return (this.sides == otherShape.sides) && (this.color.equals(otherShape.color)) && (this.filled == otherShape.filled);
	}
}