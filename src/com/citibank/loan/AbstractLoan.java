package com.citibank.loan;

import org.citibank.customer.Customer;

public abstract class AbstractLoan {

	protected double interestRate = 0.05;
	
	abstract void setRate();
	
	public boolean checkEligibility(Customer customer) {
		
		if (customer.getNationality() == "IR") {
			return true;
		}
		
		return false;
	}
	
	public double calculateLoan(double amount) {
		
		return amount * interestRate;
	}
	
	public boolean grantLoan() {
	
		return true;
	}
}
