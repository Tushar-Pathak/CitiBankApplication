package com.citibank.admin;

import java.util.Comparator;

import org.citibank.customer.Customer;

public class SortCriteria {

	private SortCriteria() {}
	
	public final static Comparator<Customer> sortByName = new Comparator<Customer>() {

		@Override
		public int compare(Customer firstCustomer, Customer secondCustomer) {

			return firstCustomer.getName().compareTo(secondCustomer.getName());
		}
	};

	public final static Comparator<Customer> sortBySalary = new Comparator<Customer>() {

		@Override
		public int compare(Customer firstCustomer, Customer secondCustomer) {
			
			return Double.compare(firstCustomer.getSalary(), secondCustomer.getSalary());
		}
	};
}
