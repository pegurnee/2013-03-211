package data_struct.in_class.d11_13;

public class Triangle {
	private int width;
	
	public Triangle (int awidth)
	{
		width = awidth;
	}
	
	public int getAreaIter()
	{
		int area = 0;
	
		if (width <= 0)
			return 0;
		for (int i=1; i<=width; i++)
			area += i;
		return area;
	}

	
	/**
	 * Extra Credit +3 points
	 * Write a recursive method to calculate the area of the triangle 
	 */
	//	public int getAreaRec()
	{
		//Base cases: width <= 0 or width = 1
		//width > 1: area of smaller triangle + width
	}
}
