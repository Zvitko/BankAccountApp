package bankaccountapp;

public class Checking extends Account{
	// Properties specific to a Checking account
	private int debitCardNumber;
	private int debitCardPin;
	
	// Constructor to initialize saving account properties
	public Checking(String name, String ssn, double initDeposit) {
		super(name, ssn, initDeposit);
		accountNumber = "2" + accountNumber;
		setDebitCard();
	}
	
	@Override
	public void setRate() {
		rate = getBaseRate() * .15;
	}
	
	// Methods specific to the saving account
	private void setDebitCard() {
		debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
		debitCardPin = (int) (Math.random() * Math.pow(10, 4));
	}
	
	public void showInfo() {
		super.showInfo();
		System.out.println("Your Checking Account Features" +
						"\n Debit Card Number: " + debitCardNumber +
						"\n Debit Card Pin: " + debitCardPin
				);
	}
}
