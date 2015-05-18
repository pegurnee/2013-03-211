
public class Triangle extends Shape{
	private double base, height;
	
	public Triangle (String name, double b, double h)
	{
		super(name);
		base = b;
		height = h;
	}
	
	public double area()
	{
		return 0.5 * base * height; 
	}
	
	public String toString()
	{
		return super.toString() + "Base = " + base + "Height = " + height;
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
			Triangle otherTri = (Triangle) otherObj;
			if (otherTri.getName().equals(this.getName()) && Math.abs(otherTri.height - this.height) < 0.0001 && Math.abs(otherTri.base - otherTri.base) < 0.0001)
				return true;
			else return false;
		}
		
	}
}
