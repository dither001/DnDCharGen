package com.dnd5e.gear.definitions;

import com.dnd5e.exceptions.*;
import com.miscellaneous.util.*;

public enum Handed {
	NONE, LIGHT, ONE, VERSATILE, TWO, HEAVY;

	private static final Handed[] HANDED = { HEAVY, LIGHT, NONE, ONE, TWO, VERSATILE };

	/*
	 * INSTANCE METHODS
	 */
	public int indexOf() {
		return Misc.indexOfEnum(this.toString(), HANDED);
	}

	/*
	 * STATIC METHODS
	 */
	public static Handed get(int index) {
		return HANDED[index];
	}

	public static Handed parse(String s) throws ParserException {
		for (Handed el : HANDED) {
			if (el.toString().compareToIgnoreCase(s) == 0)
				return el;
		}

		throw new ParserException();
	}
}
