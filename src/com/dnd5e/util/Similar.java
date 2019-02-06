package com.dnd5e.util;

public interface Similar {
	/*
	 * Similar objects are of the same class, but are not the same object. They must
	 * not be the "opposite" of one another. Returns 1 for "similar," -1 for
	 * "dissimilar," and 0 for "the same as."
	 */
	public int similarTo(Object o);

}
