package com.miscellaneous.util;

@SuppressWarnings("serial")
public class ItemNotPresentException extends Exception {

	public ItemNotPresentException(String s) {
		super(s + " not found");
	}

}
