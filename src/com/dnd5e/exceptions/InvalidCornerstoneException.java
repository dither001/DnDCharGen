package com.dnd5e.exceptions;

@SuppressWarnings("serial")
public class InvalidCornerstoneException extends Exception {

	public InvalidCornerstoneException(String s) {
		super(s + "is not a valid Cornerstone");
	}
}
