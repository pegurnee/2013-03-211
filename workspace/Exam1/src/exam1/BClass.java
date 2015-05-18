package exam1;
/**
 * 
 * @author Eddie Gurnee
 * @version 10/07/13
 * @see AClass
 * 
 */
public class BClass extends AClass {
	private int z;
	public BClass(int a, int b, int c) {
		super(a, b);
		z = c;
	}
	public int addEm() {
		return super.addEm() + z;
	}
	public String toString() {
		return super.toString() + " " + z;
	}
	public boolean equals(Object otherObject) {
		if (otherObject == null) {
			return false;
		}
		else if (this.getClass() != otherObject.getClass()) {
			return false;
		}
		else {
			BClass otherBClass = (BClass)otherObject;
			return (this.z == otherBClass.z && 
					this.getY() == otherBClass.getY() && 
					this.getX() == otherBClass.getX()
					);
		}
	}
}