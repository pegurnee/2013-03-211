package data_struct.in_class.d10_02;
/**
 * A class to test basic 'Object' methods
 * 
 * @author Eddie Gurnee
 * @version 10/02/13
 * @see TestingSam
 * 
 */
public class Sam {
	public int mikesplan = 8;
	/**
	 * No argument constructor for the Sam class
	 * 
	 */
	public Sam() {
		
	}
	/**
	 * Indicates if some other "Sam" object is equal to this one.
	 * 
	 */
	
	public boolean equals(Sam otherObject) {
		if (otherObject == null) {
			System.out.println("check1");
			return false;
		}
		else if (this.getClass() != otherObject.getClass()) {
			System.out.println("check2");
			return false;
		}
		else {
			System.out.println("if this shows then fuck the police");
			Sam otherSam = (Sam)otherObject;
			return this.mikesplan == otherSam.mikesplan;
		}
	}
	public int getMikesPlan() {
		return mikesplan;
	}
}