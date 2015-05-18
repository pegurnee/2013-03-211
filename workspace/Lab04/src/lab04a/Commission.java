package lab04a;
/**
 * This is the Commission class for lab4
 * 
 * @author Eddie Gurnee
 * @version 10/14/2013
 */
public class Commission extends Hourly {
	protected double totalSales;
	protected double commissionRate;
	
	public Commission(String eName, String eAddress, String ePhone,
			String socSecNumber, double rate, double commissionRate) {
		super(eName, eAddress, ePhone, socSecNumber, rate);
		this.commissionRate = commissionRate;
	}
	public void addSales (double totalSales) {
		this.totalSales += totalSales;
	}
	
	@Override
	public double pay() {
		double thePay = super.pay() + commissionRate * totalSales;
		totalSales = 0;
		return thePay;
	}
	
	public String toString() {
		return super.toString() + "\nTotal Sales: " + totalSales;
	}
}
