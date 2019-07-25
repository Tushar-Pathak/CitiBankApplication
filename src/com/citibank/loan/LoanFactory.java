package com.citibank.loan;

public class LoanFactory {

	private LoanFactory() {
	}

	public static AbstractLoan getLoan(String loanType) throws NoLoanTypeFoundException {

		if (loanType.equals("HOME LOAN")) {
			
			new HomeLoan();
		} else if (loanType.equals("HOUSE LOAN")) {
			
			new HouseLoan();
		} else if (loanType.equals("CAR LOAN")) {
			
			new CarLoan();
		} 
			
		throw new NoLoanTypeFoundException("No Loan Type matched...");
	}
}
