/**
 * A class to test basic 'Object' methods, derived from Sam
 * 
 * @author Eddie Gurnee
 * @version 10/02/13
 * @see TestingSam
 * @see Sam
 * 
 */
public class George extends Sam {
	public int eddiesplan;
	protected int x = 1;
	/**
	 * No argument constructor for the George class
	 * 
	 */
	public George() {
		super();
		eddiesplan = 2;
	}
	public George(int plan) {
		super();
		eddiesplan = plan;
	}
	/**
	 * Indicates if some other "George" object is equal to this one.
	 * 
	 */
	public boolean equals(Object otherObject) {
		if (otherObject == null) {
			System.out.println("check1");
			return false;
		}
		else if (this.getClass() != otherObject.getClass()) {
			System.out.println("check2");
			return false;
		}
		else {
			George otherGeorge = (George)otherObject;
			return this.eddiesplan == otherGeorge.eddiesplan;
		}
	}
	public int getMikesPlan () {
		return 99;
	}
	public int getMikesPlan (int a) {
		return super.getMikesPlan() + 2;
	}
}