package org.citibank.client;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import org.citibank.customer.Customer;
import org.citibank.models.CustomerDao;
import org.citibank.models.CustomerDbUtil;
import com.citibank.admin.Main;

public class Client {
	
	static {
		System.out.println("Welcome to Citi Bank...");
	}
	
	public void readInput() {
		
		Scanner sn = new Scanner(System.in);
		
		System.out.println("Enter your option.....");
		System.out.println("1. For Customer Mode");
		System.out.println("2. For Admin Mode");
		
		int choice = sn.nextInt();
		
		switch(choice) {
		
		case 1:
			showCustomerOption();
			break;
			
		case 2:
			Main main = new Main();
			break;
		
		}
	}
	
	public void showCustomerOption() {
		
		System.out.println("Please Select your option");
		System.out.println("1. Create a new Customer");
		System.out.println("2. Show all customers");
		System.out.println("3. Find a customer");
		
		Scanner sn = new Scanner(System.in);
		int choice = sn.nextInt();

		CustomerDao dao = new CustomerDbUtil();
		
		switch(choice) {
		
		case 1: 

			Customer customer = new Customer();
			System.out.println("Enter your name");
			customer.setName(sn.next());
			
			System.out.println("Enter your email");
			customer.setEmail(sn.next());
			
			System.out.println("Enter your DOB");
			customer.setDateOfBirth(LocalDate.of(sn.nextInt(), sn.nextInt(), sn.nextInt()));
			
			System.out.println("Enter your password");
			customer.setPassword(sn.next());
			
			System.out.println("Enter your salary");
			customer.setSalary(sn.nextDouble());
			
			System.out.println("Enter your nationality");
			customer.setNationality(sn.next());
			dao.saveCustomer(customer);
			break;
			
		case 2: 
			
			System.out.println("Enter id to be searched");
			Customer c = dao.findCustomer(sn.nextInt());
			System.out.println(c);
			break;
		}
	}
	
	public static void main(String ...args) {
	
		Customer customer = new Customer();
		customer.setName("Tushar");
		customer.setEmail("tkp.tushar@gmail.com");
		customer.setDateOfBirth(customer.parse(new Date()));
		customer.setPassword("123");
		customer.setSalary(1234.);
		customer.setNationality("nri");
		
		CustomerDao customerDao = new CustomerDbUtil();
		
//		customerDao.saveCustomer(customer);
		customerDao.deleteAll();
	}
}


