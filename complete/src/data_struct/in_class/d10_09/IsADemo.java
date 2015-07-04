package data_struct.in_class.d10_09;


public class IsADemo
{
    public static void main(String[] args)
    {
//    	Employee joseph = new Employee("Josephine", new Date("January", 1, 2004));
        SalariedEmployee joe = new SalariedEmployee("Josephine", 
                                   new Date("January", 1, 2004), 100000);
        HourlyEmployee sam = new HourlyEmployee("Sam", 
                                   new Date("February", 1, 2003), 50.50, 40);

        System.out.println("joe's longer name is " + joe.getName( ));

        System.out.println("\nshowEmployee(joe) invoked:");
        showEmployee(joe);

        System.out.println("\nshowEmployee(sam) invoked:");
        showEmployee(sam);
        
//        System.out.println("Comparing Joseph with Joe");
//        if (joseph.equals(joe)) 
//        	System.out.println("Joseph is the same a Joe");
//        else
//        	System.out.println("Joseph is not Joe");
//
//        System.out.println("Comparing Joe with Joseph");
//        if (joe.equals(joseph)) 
//        	System.out.println("Joe is the same a Joseph");
//        else
//        	System.out.println("Joe is not Joseph");
    	
//    	SalariedEmployee sam = new SalariedEmployee("Sam", new Date(), 10.00);
//    	Employee joe = new SalariedEmployee("Sam", new Date(), 10.00);
//        
//        System.out.println("Comparing these other guys...");
//        System.out.println(sam.equals(joe));
//        System.out.println(joe.equals(sam));
//        System.out.println(sam.getClass());
        
    }

    public static void showEmployee(Employee employeeObject)
    {
           System.out.println(employeeObject.getName( ));
           System.out.println(employeeObject.getHireDate( ));
           System.out.println(employeeObject);
    }
}
