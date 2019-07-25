package com.citibank.loan;

public class NoLoanTypeFoundException extends Exception{

	public NoLoanTypeFoundException(String message) {
		
		super(message);
	}
}
