package bankaccountapp;

public interface IBaseRate {
	// Method that returns the base rate
	default double getBaseRate() {
		return 2.5;
	}
}
