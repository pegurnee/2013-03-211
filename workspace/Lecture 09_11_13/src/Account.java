//*******************************************************
// Account.java
// A bank account class with methods to deposit to, withdraw from,
// change the name on, charge a fee to, and print a summary of the account.

import java.text.NumberFormat;

public class Account
{
	private double balance;
	private String name;
	private long acctNum;
	
	private static int numAccounts;

	// Constructor -- initializes balance, owner, and account number
	public Account(double balance, String name, long acctNum)
	{
		this.balance = balance;
		this.name = name;
		this.acctNum = acctNum;
		
		numAccounts++;
	}

	// Checks to see if balance is sufficient for withdrawal.
	// If so, decrements balance by amount; if not, prints message.
	public void withdraw(double amount)
	{
		if (balance >= amount)
			balance -= amount;
		else
			System.out.println("Insufficient funds");
	}

	// Adds deposit amount to balance
	public void deposit(double amount)
	{
		balance += amount;
	}
	
	// Returns the account owner
	public String getName()
	{
		return name;
	}

	// Returns balance.
	public double getBalance()
	{
		return balance;
	}

	// Returns the account number
	public long getAcctNumber()
	{
		return acctNum;
	}
	
	// Returns the number of accounts
	public static int getNumAccounts()
	{
		return numAccounts;
	}

	// Returns a string containing the name, account number, and balance.
	public String toString()
	{
		// write your code here

		NumberFormat usMoney = NumberFormat.getCurrencyInstance();

		return "Account Owner: " + name 
				+ "\nAccount Number: " + acctNum 
				+ "\nBalance: " + usMoney.format(balance); 

		/*String str = "Account Owner: %s%nAccount Number: %d%nBalance: $%.2f", name, Long.parsetoInt(acctNum), balance;
	  return str; */
	}

	// Deducts $10 service fee
	public double chargeFee()
	{
		// write your code here
		balance -= 10;

		return balance;
	}

	// Changes the name on the account 
	public void changeName(String newName)
	{
		// Write your code here
		name = newName;
	}
	
	// Closes the account: sets balance to 0 and adds "CLOSED" to account name and decreases number of active accounts
	public void close()
	{
		this.name += " - CLOSED";
		this.balance = 0;
		numAccounts--;
	}
	
	// Creates a new account that is the sum of the balance of two accounts and closes the two original accounts
	public static Account consolidate(Account acct1, Account acct2)
	{
		if (acct1.name.equals(acct2.name) && acct1.acctNum != acct2.acctNum)
		{
			long newAcctNum;
			if (acct1.acctNum > acct2.acctNum)
			{
				newAcctNum = acct1.acctNum + 1;
			}
			else
			{
				newAcctNum = acct2.acctNum + 1;
			}
			
			Account newAcct = new Account(acct1.balance + acct2.balance, acct1.name, newAcctNum);
			acct1.close();
			acct2.close();
						
			return newAcct;
		}
		else
		{
			System.out.println("Accounts cannot be consolidated.");
			return null;
		}		
	}
}


