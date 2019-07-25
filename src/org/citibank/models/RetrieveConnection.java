package org.citibank.models;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class RetrieveConnection {
	
	private static Connection connection;
	
	static {

		Map<String, String> properties = readProperties();
		try {
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost/citi", properties.get("user"),
					properties.get("password"));

		} catch (SQLException e) {

			System.out.println("User or Password may be incorrect " + e);

		}
	}

	private static Map<String, String> readProperties() {

		Map<String, String> result = new HashMap<String, String>();

		try {

			FileReader fr = new FileReader("db.properties");
			Properties properties = new Properties();
			properties.load(fr);
			
			result.put("user", properties.getProperty("user"));
			result.put("password", properties.getProperty("password"));
			
		} catch (IOException e) {

			CredentialNotFoundException credentialError = new CredentialNotFoundException("No properties file found");
			credentialError.initCause(e);
			throw credentialError;
		}

		return result;
	}
	
	public static Connection getConenction() {
		
		return connection;
	}
}
