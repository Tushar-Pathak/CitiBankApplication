package com.citibank.loan;

import org.citibank.customer.Customer;

import com.citibank.loan.models.LoanDao;
import com.citibank.loan.models.LoanOperationUtil;

public class DisburseLoan {

	private Customer customer;

	public DisburseLoan(Customer customer) {

		this.customer = customer;
	}

	public void getLoan(double amount) {

		try {
			AbstractLoan loanType = LoanFactory.getLoan("HOME LOAN");

			loanType.setRate();
			loanType.calculateLoan(1000);
			loanType.checkEligibility(customer);
			
			if (loanType.grantLoan() == true) {
				
				LoanDao userLoan = new LoanOperationUtil();
				userLoan.saveLoan(new Loan(customer, loanType.calculateLoan(amount), loanType.interestRate));
			}
			
		} catch (NoLoanTypeFoundException e) {

			System.out.println("Sorry but we don't provide this type of loan.....");
		}

	}

}
