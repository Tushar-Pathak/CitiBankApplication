package org.citibank.models;

import java.util.List;
import org.citibank.customer.Customer;

public interface CustomerDao {
	
	boolean saveCustomer(Customer customer);
	Customer findCustomer(int id);
	List<Customer> findAll();
	boolean updateCustomer(int id);
	boolean deleteCustomer(int id);
	void deleteAll();
}
