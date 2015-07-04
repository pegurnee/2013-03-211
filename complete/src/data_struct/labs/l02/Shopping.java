package data_struct.labs.l02;
import java.util.Scanner;
import java.text.NumberFormat;

public class Shopping {

	/**
	 * @author Eddie Gurnee
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);		
		ShoppingCart cart = new ShoppingCart();
		NumberFormat fmt = NumberFormat.getCurrencyInstance();

		System.out.print("Would you like to begin shopping? [y/n] ");
		char confirm = kb.next().trim().toLowerCase().charAt(0);
		if (confirm == 'n') {
			System.out.println("Have a great day!");
		}
		else {
			boolean finished = false;
			while (!finished) {
				System.out.print("Enter Name of Item: ");
				String name = kb.next();
				System.out.print("Enter Price of Item: ");
				double price = kb.nextDouble();
				System.out.print("Enter Quantity of Item: ");
				int quantity = kb.nextInt();

				cart.addToCart(name, price, quantity);

				System.out.println(cart);
				
				boolean realChar = false;
				while (!realChar) {
					System.out.print("Would you like to continue shopping? [y/n] ");
					confirm = kb.next().trim().toLowerCase().charAt(0);
					if (confirm == 'n' || confirm == 'y') {
						realChar = true;
						if (confirm == 'n') {
							finished = true;
						}					
					}
					else {
						System.out.println("\nInvalid Response.\n");
					}
				}
			}
			System.out.println("Your total today is " + fmt.format(cart.getTotalPrice()) + ".");
		}
		kb.close();
	}
}
