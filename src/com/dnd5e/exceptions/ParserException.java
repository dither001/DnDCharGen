package com.dnd5e.exceptions;

@SuppressWarnings("serial")
public class ParserException extends Exception {
	
	public ParserException() {
		super("Parser failed to read");
	}
	
	public ParserException(String s) {
		super("Failed to parse" + " " + s);
	}
}
