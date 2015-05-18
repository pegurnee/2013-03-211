
public abstract class Shape {
	private String shapeName;
	
	public Shape(String name)
	{
		shapeName = name;
	}
	
	public abstract double area();
	
	public String getName()
	{
		return shapeName;
	}
	
	public String toString()
	{
		return "Shape: " + shapeName;
	}
}
