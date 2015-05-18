package interfaces;

public class Square implements Shape{
	private double sides;
	
	public Square(double sides) {
		this.sides = sides;
	}
	public double area () {
		return sides*sides;
	}
	public double perimeter(){ 
		return 4 * sides;
	}
	
}
