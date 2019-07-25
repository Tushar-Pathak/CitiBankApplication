package com.citibank.loan.models;

import com.citibank.loan.Loan;

public interface LoanDao {

	boolean saveLoan(Loan loan);
	Loan viewLoan(int id);
	
}
