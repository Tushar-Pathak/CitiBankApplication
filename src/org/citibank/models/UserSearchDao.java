package org.citibank.models;

import java.util.ArrayList;
import org.citibank.customer.Customer;

public interface UserSearchDao extends CustomerDao {

	ArrayList<Customer> findByName(String name);
	Customer findByEmail(String email);
}
