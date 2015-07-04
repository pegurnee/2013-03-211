package data_struct.in_class.d09_18;
// ****************************************************************
// Sales.java
// Reads in and stores sales for each of 5 salespeople. Displays
// sales entered by salesperson id and total sales for all salespeople.
// ****************************************************************
import java.util.Scanner;
import java.text.NumberFormat;

public class Sales {
	public static void main(String[] args) {
		NumberFormat usMoney = NumberFormat.getCurrencyInstance();
		Scanner scan = new Scanner(System.in);		
		
		//final int SALESPEOPLE = scan;
		System.out.print("Enter number of salespeople: ");
		int salespeople = scan.nextInt();
		
		
		int[] sales = new int[salespeople];
		int sum = 0;

		for (int i=0; i < sales.length; i++) {
			System.out.print("Enter sales for salesperson " + i + ": $");
			sales[i] = scan.nextInt();
		}
		System.out.println("\nSalesperson Sales");
		System.out.println("--------------------");
		
		int max = Integer.MIN_VALUE;
		int maxID = -1;
		int min = Integer.MAX_VALUE;
		int minID = -1;		
		
		for (int i = 0; i < sales.length; i++)
		{
			System.out.println("Salesperson " + i + ": " + usMoney.format(sales[i]));
			sum += sales[i];
			if (sales[i] > max) {
				max = sales[i];
				maxID = i;
			}
			if (sales[i] < min) {
				min = sales[i];
				minID = i;
			}
		}
		System.out.println("--------------------");
		
		System.out.println("\nTotal sales: " + usMoney.format(sum));
		System.out.println("Average sales: " + usMoney.format(sum / (double)sales.length));
		
		System.out.println("\nSalesperson " + maxID + " had the highest sale with " + usMoney.format(max) + ".");
		System.out.println("Salesperson " + minID + " had the lowest sale with " + usMoney.format(min) + ".");
		
		System.out.print("\nPlease enter minimum amount to check against: $");
		int compareValue = scan.nextInt();
		
		System.out.println("\nSalespeople that exceeded " + usMoney.format(compareValue));
		System.out.println("---------------------------------------");
		int numExceeded = 0;
		for (int i = 0; i < sales.length; i++) {
			if (sales[i] > compareValue) {
				System.out.println("Salesperson " + i + ": " + usMoney.format(sales[i]));
				System.out.println("\t-exceeded by " + usMoney.format(sales[i] - compareValue)+ ".");
				numExceeded++;
			}
		}
		System.out.println("---------------------------------------");
		
		System.out.println("\n" + numExceeded + " salespeople exceeded " + usMoney.format(compareValue) + ".");
		
		scan.close();
		
		System.out.println();
		
		//using for-each
		for (int salesAmount : sales) {
			System.out.println("Sales amount: " + usMoney.format(salesAmount));
		}
	}
}