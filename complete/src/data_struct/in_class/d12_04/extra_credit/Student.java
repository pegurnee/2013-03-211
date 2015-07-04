package data_struct.in_class.d12_04.extra_credit;

/**
 * A basic student class to use for the extra credit linked list
 * 
 * @author Eddie Gurnee
 * @version 12/02/2013
 */
public class Student {
    private String id;
    private String fName;
    private String lName;

    public Student(String id) {
        this(id, "no name", "no name");
    }

    public Student(String id, String fName, String lName) {
        super();
        this.id = id;
        this.fName = fName;
        this.lName = lName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        } else {
            // students are equal only if their IDs are equal, everything else
            // doesn't matter for equality
            Student other = (Student)obj;
            return this.id.equals(other.getID());
        }
    }

    public String getfName() {
        return fName;
    }

    public String getID() {
        return id;
    }

    public String getlName() {
        return lName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( (fName == null) ? 0 : fName.hashCode());
        result = prime * result + ( (id == null) ? 0 : id.hashCode());
        result = prime * result + ( (lName == null) ? 0 : lName.hashCode());
        return result;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setID(String id) {
        this.id = id;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Override
    public String toString() {
        return "Student ID = " + id + ", Name = " + fName + " " + lName;
    }

}
