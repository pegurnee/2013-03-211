package interfaces;
import java.util.Scanner;
public class TestDayofWeek {
	public static void main (String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ImplementA x = new ImplementA();
		System.out.println("ImplementA: " + x.firstDayOfWeekStr());
		
		ImplementB y = new ImplementB();
		System.out.println("ImplementB: " + y.firstDayOfWeekStr());
	}
}


//EC +1pt write the statement to display the day number given
// day name using dayOfWeek()