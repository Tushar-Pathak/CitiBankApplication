package com.citibank.loan;

import java.time.LocalDate;

import org.citibank.customer.Customer;

public class Loan {

	private Customer customer;
	private double amount;
	private double interestRate;
	private LocalDate dateOfIssue = LocalDate.now();

	public Loan() {}
	
	public Loan(Customer customer, double amount, double interestRate) {
		
		this.customer = customer;
		this.amount = amount;
		this.interestRate = interestRate;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
}
