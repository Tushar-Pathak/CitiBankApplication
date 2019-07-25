package com.citibank.loan;

public class HomeLoan extends AbstractLoan {

	@Override
	void setRate() {
		
		interestRate = 0.09;
	}
}
