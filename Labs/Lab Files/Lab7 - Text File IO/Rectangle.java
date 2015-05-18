
public class Rectangle extends Shape{
	private double length, width;
	
	public Rectangle (String name, double l, double w)
	{
		super(name);
		length = l;
		width = w;
	}
	
	public double area()
	{
		return length * width;
	}
	
	public String toString()
	{
		return super.toString() + "\nLength = " + length + "\nWidth = " + width;
	}
	
	public boolean equals(Object otherObj)
	{
		if (otherObj == null)
		{
			return false;
		}
		else if (otherObj.getClass() != this.getClass())
			return false;
		else
		{
			Rectangle otherRect = (Rectangle) otherObj;
			if (otherRect.getName().equals(this.getName()) && Math.abs(otherRect.length - this.length) < 0.0001 && Math.abs(otherRect.width - otherRect.width) < 0.0001)
				return true;
			else return false;
		}
		
	}
}
