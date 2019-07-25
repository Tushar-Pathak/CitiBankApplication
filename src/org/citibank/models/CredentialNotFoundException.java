package org.citibank.models;

public class CredentialNotFoundException extends RuntimeException{

	public CredentialNotFoundException(String msg) {
		
		super(msg);
	}
}
