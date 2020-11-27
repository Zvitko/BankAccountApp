package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) {
		List<Account> accounts = new LinkedList<Account>();
		
		
		// Read the CSV file then create new accounts based on that data
		String file = "/Users/vitko/eclipse-workspace/Java Projects/src/bankaccountapp/NewBankAccounts.csv";
		List<String[]> newAccountHolders = utilities.CSV.read(file);

		for (String[] accountHolder : newAccountHolders) {
			String name = accountHolder[0];
			String ssn = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);
			if (accountType.equals("Savings")) {
				accounts.add(new Savings(name, ssn, initDeposit));
			}
			else if (accountType.equals("Checking")) {
				accounts.add(new Checking(name, ssn, initDeposit));
			}
			else {
				System.out.println("Error Reading Account Type");
			}
		}
		
		for (Account acc : accounts) {
			System.out.println("\n**********************");
			acc.showInfo();
		}
	}

}
