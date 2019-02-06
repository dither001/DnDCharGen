package com.dnd5e.exceptions;

@SuppressWarnings("serial")
public class InvalidAlignmentException extends Exception {

	public InvalidAlignmentException() {
		super("Invalid Alignment");
	}
}
