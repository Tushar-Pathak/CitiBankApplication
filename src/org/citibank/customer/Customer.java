package org.citibank.customer;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Customer {

	private String name;
	private String email;
	private LocalDate dateOfBirth;
	private String password;
	private String nationality;
	private double salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getAge() {
		
		Period period = Period.between(dateOfBirth, LocalDate.now());
		return period.getYears();
	}
	
	public LocalDate parse(int year, int month, int dayOfMonth) {
		
		return LocalDate.of(year, month, dayOfMonth);
	}
	
	public LocalDate parse(Date date) {
		
		Instant instant = Instant.ofEpochMilli(date.getTime());
		LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
	
		return dateTime.toLocalDate();
	}
}
