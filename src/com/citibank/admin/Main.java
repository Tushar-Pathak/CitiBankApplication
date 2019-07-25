package com.citibank.admin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.citibank.client.UserInputException;
import org.citibank.customer.Customer;
import org.citibank.models.CustomerDao;
import org.citibank.models.CustomerDbUtil;

public class Main {
	
	private List<Customer> customers = new ArrayList<>();
	
	public void getCustomersList() {
		
		CustomerDao dao = new CustomerDbUtil();	
		customers = dao.findAll();
	}
	
	public void process() throws UserInputException {
		
		System.out.println("Please Enter your choice.....");
		Scanner sn = new Scanner(System.in);
	
		System.out.println("Press 1 For Viewing All Customers in Ascending Order of Their Names..");
		System.out.println("Press 2 For Viewing All Customers in Ascending Order of Their Salary..");
		
		int choice = sn.nextInt();
		
		switch(choice) {
		
		case 1:
			Collections.sort(customers, SortCriteria.sortByName);
			customers.stream().forEach(System.out::print);
			break;
		
		case 2:
			Collections.sort(customers, SortCriteria.sortBySalary);
			customers.stream().forEach(System.out::print);
			break;
			
		default: 
			throw new UserInputException("No correct option identified");
		}
	}
}
