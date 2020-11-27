package bankaccountapp;

public abstract class Account implements IBaseRate{
	// Common properties for checking and savings account
	private String name;
	private String ssn;
	private double balance;
	
	private static int index = 10000;
	protected String accountNumber;
	protected double rate;
	
	
	// Constructor to set base properties and initialize the account
	public Account(String name, String ssn, double initDeposit) {
		this.name = name;
		this.ssn = ssn;
		this.balance = initDeposit;
		this.accountNumber = setAccountNumber();
		setRate();
	}
	
	public abstract void setRate();
	
	private String setAccountNumber() {
		String lastTwoOfSSN = ssn.substring(ssn.length()-2, ssn.length());
		int uniqueID = index;
		int randomNumber = (int) (Math.random() * Math.pow(10, 3));
		return lastTwoOfSSN + uniqueID + randomNumber;
	}
	
	public void compound() {
		double accruedInterest = balance * (rate/100);
		balance = balance + accruedInterest;
		System.out.println("Accrued Interest $" + accruedInterest);
		printBalance();
	}
	
	// Methods - Transactions
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("Depositing $" + amount);
		printBalance();
	}
	
	public void withdraw(double amount) {
		balance = balance - amount;
		System.out.println("Withdrawling $" + amount);
		printBalance();
	}
	
	public void transfer(String toWhere, double amount) {
		balance = balance - amount;
		System.out.println("Transfering $" + amount + " to " + toWhere);
		printBalance();
	}
	
	public void printBalance() {
		System.out.println("Your balance is now $" + balance);
	}
	
	public void showInfo() {
		System.out.println("Name: " + name +
				"\n Account Number: " + accountNumber +
				"\n Balance: " + balance + 
				"\n Rate: " + rate + "%"
				);
	}
}
