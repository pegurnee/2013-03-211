
public class ImplementB implements Weeks{
	
	public String firstDayOfWeekStr() {
		return MONDAY;
	}
	
	public int dayOfWeek(String day) {
	if (day.equals(MONDAY))
		return 1;
	else if (day.equals(TUESDAY))
		return 2;
	else 
		return -1;
	}
}
