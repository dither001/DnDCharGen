package com.dnd5e.exceptions;

@SuppressWarnings("serial")
public class InvalidDomainException extends Exception {

	public InvalidDomainException() {
		super("Invalid Domain");
	}
}
