package com.citibank.loan;

public class CarLoan extends AbstractLoan {

	@Override
	void setRate() {
		interestRate = 0.5;
	}
}
