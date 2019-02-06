package com.dnd5e.util;

public interface Opposite {
	/*
	 * Opposites are more strict than similar: they are the same class and are not
	 * the same object. However they return true for "opposite," and false for
	 * anything else.
	 */
	public boolean opposedTo(Object o);

}
