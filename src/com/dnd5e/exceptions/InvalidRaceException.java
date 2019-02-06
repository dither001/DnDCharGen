package com.dnd5e.exceptions;

@SuppressWarnings("serial")
public class InvalidRaceException extends Exception {

	public InvalidRaceException() {
		super("Invalid Race");
	}
}
