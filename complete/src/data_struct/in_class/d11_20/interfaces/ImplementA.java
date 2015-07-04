package data_struct.in_class.d11_20.interfaces;

public class ImplementA implements Weeks {
    public String firstDayOfWeekStr() {
        return SUNDAY;
    }

    /**
     * Extra Credit, create a method to return the proper day of the week
     * 
     * @author Eddie Gurnee
     * @version 11/20/2013
     */
    public int dayOfWeek(String day) {
        // +2 EC pts
        // Write the body for this method
        // "Sunday" = 1, ..., "Saturday" = 7, Invalid string = -1

        int theDay = 0;
        switch (day) {
        case "Sunday":
            theDay = 1;
            break;
        case "Monday":
            theDay = 2;
            break;
        case "Tuesday":
            theDay = 3;
            break;
        case "Wednesday":
            theDay = 4;
            break;
        case "Thursday":
            theDay = 5;
            break;
        case "Friday":
            theDay = 6;
            break;
        case "Saturday":
            theDay = 7;
            break;
        default:
            theDay = -1;
            break;
        }
        return theDay;
    }

}
