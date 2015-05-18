
public class Square extends Shape{
	private double side;
	
	public Square (String name, double s)
	{
		super(name);
		side = s;
	}
	
	public double area()
	{
		return side * side;
	}
	
	public String toString()
	{
		return super.toString() + "Side = " + side;
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
			Square otherSq = (Square) otherObj;
			if (otherSq.getName().equals(this.getName()) && Math.abs(otherSq.side - this.side) < 0.0001 )
				return true;
			else return false;
		}
		
	}
}
