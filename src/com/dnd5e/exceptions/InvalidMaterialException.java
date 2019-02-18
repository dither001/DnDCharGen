package com.dnd5e.exceptions;

@SuppressWarnings("serial")
public class InvalidMaterialException extends Exception {

	public InvalidMaterialException() {
		super("Invalid material");
	}
}
