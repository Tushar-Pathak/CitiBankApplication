package org.citibank.models;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.sql.Date;

import org.citibank.customer.Customer;

public class CustomerDbUtil implements CustomerDao {

	protected static Connection connection = RetrieveConnection.getConenction();

	@Override
	public boolean saveCustomer(Customer customer) {

		final String query = "Insert into customer VALUES (null, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = null;
		boolean flag = false;

		try {

			statement = connection.prepareStatement(query);
			
			statement.setString(1, customer.getName());
			statement.setDate(2, Date.valueOf(customer.getDateOfBirth()));
			statement.setString(3, customer.getEmail());
			statement.setString(4, customer.getPassword());
			statement.setString(5, customer.getNationality());
			statement.setDouble(6, customer.getSalary());
			
			flag = statement.execute();
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			if (statement != null) {
				try {

					statement.close();
					closeConnection();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}

		return flag;
	}

	@Override
	public Customer findCustomer(int id) {
		final String query = "SELECT * FROM customer WHERE id = ?";
		PreparedStatement statement = null;
		Customer customer = new Customer();
		
		try {

			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				
				customer.setName(rs.getString(2));
				customer.setDateOfBirth(customer.parse(rs.getDate(3)));
				customer.setEmail(rs.getString(4));
				customer.setPassword(rs.getString(5));
				customer.setNationality(rs.getString(6));
				customer.setSalary(rs.getDouble(7));
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			if (statement != null) {
				try {

					statement.close();
					closeConnection();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
		
		return customer;
	}

	@Override
	public List<Customer> findAll() {
		
		final String query = "SELECT * FROM customer";
		PreparedStatement statement = null;
		List<Customer> customers = new ArrayList<>();
		
		try {

			statement = connection.prepareStatement(query);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				
				Customer customer = new Customer();
				customer.setName(rs.getString(2));
				customer.setDateOfBirth(customer.parse(rs.getDate(3)));
				customer.setEmail(rs.getString(4));
				customer.setPassword(rs.getString(5));
				customer.setNationality(rs.getString(6));
				customer.setSalary(rs.getDouble(7));
				
				customers.add(customer);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			if (statement != null) {
				try {

					statement.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
		
		return customers;
	}

	@Override
	public boolean updateCustomer(int id) {
		return false;
	}

	@Override
	public boolean deleteCustomer(int id) {
		
		final String query = "SELECT * FROM customer";
		PreparedStatement statement = null;
		List<Customer> customers = new ArrayList<>();
		boolean flag = false;
		
		try {

			statement = connection.prepareStatement(query);
			flag = statement.execute();
			
			closeConnection();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			if (statement != null) {
				try {

					statement.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
		
		return flag;
	}

	@Override
	public void deleteAll() {

		final String query = "DELETE FROM customer";
		PreparedStatement statement = null;
		List<Customer> customers = new ArrayList<>();
		
		try {

			statement = connection.prepareStatement(query);
			
			statement.execute();
			closeConnection();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			if (statement != null) {
				try {

					statement.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}		
	}

	public void closeConnection() {

		if (connection != null) {
			try {

				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
}
