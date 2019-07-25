package com.citibank.loan.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.citibank.models.RetrieveConnection;

import com.citibank.loan.Loan;

public class LoanOperationUtil implements LoanDao {

	private Connection connection = RetrieveConnection.getConenction();

	@Override
	public boolean saveLoan(Loan loan) {

		boolean flag = false;
		try {

			PreparedStatement statement = connection.prepareStatement("INSERT INTO Loan VALUES (null, ?, ?, ?, ?)");
			flag = statement.execute();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public Loan viewLoan(int id) {

		Loan loan = new Loan();
		
		try {

			PreparedStatement statement = connection.prepareStatement("INSERT INTO Loan VALUES (null, ?, ?, ?, ?)");
			ResultSet rs = statement.executeQuery();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return loan;
	}
}
