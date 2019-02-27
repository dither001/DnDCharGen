package com.miscellaneous.util;

@SuppressWarnings("serial")
public class ParserException extends Exception {

	public ParserException() {
		super("Parser failed to read");
	}

	public ParserException(String s) {
		super("Failed to parse " + " " + s);

	}

	public ParserException(String clazz, String s) {
		super("Failed to parse " + clazz + " " + s);

	}
}
