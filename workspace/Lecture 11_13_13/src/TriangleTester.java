import java.util.Scanner;
public class TriangleTester {

	public static void main(String[] args) {
		int area;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter triangle width: ");
		int width = scan.nextInt();
		Triangle t = new Triangle(width);

		area = t.getAreaIter();
		System.out.println("area (Iteration): " + area);
//		area = t.getAreaRec();
//		System.out.println("Area (Recursion): " + area);		
	}

}
