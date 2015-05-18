
public class Circle extends Shape{
	private double radius;
	
	public Circle (String name, double r)
	{
		super(name);
		radius = r;
	}
	
	public double area()
	{
		return Math.PI * radius * radius;
	}
	
	public String toString()
	{
		return super.toString() + "Radius = " + radius;
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
			Circle otherCirc = (Circle) otherObj;
			if (otherCirc.getName().equals(this.getName()) && Math.abs(otherCirc.radius - this.radius) < 0.0001 )
				return true;
			else return false;
		}
		
	}
}
