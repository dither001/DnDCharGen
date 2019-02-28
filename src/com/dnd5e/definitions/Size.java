package com.dnd5e.definitions;

import com.miscellaneous.util.*;

public enum Size {
	TINY, SMALL, MEDIUM, LARGE, HUGE, GARGANTUAN;

	private static final Size[] SIZES = { TINY, SMALL, MEDIUM, LARGE, HUGE, GARGANTUAN };

	/*
	 * 
	 */
	public int hitDieSize() {
		return hitDieSize(this);
	}

	public int indexOf() {
		for (int i = 0; i < SIZES.length; ++i) {
			if (SIZES[i].equals(this))
				return i;
		}

		return -1;
	}

	/*
	 * STATIC METHODS
	 */
	public static Size get(int index) {
		return SIZES[index];
	}

	public static int hitDieSize(Size size) {
		switch (size) {
		case GARGANTUAN:
			return 12;
		case HUGE:
			return 10;
		case LARGE:
			return 8;
		case MEDIUM:
			return 6;
		case SMALL:
		case TINY:
			return 4;
		default:
			return 8;
		}
	}

	public static Size parse(String s) throws ParserException {
		for (Size el : SIZES) {
			if (el.toString().compareToIgnoreCase(s) == 0)
				return el;
		}

		throw new ParserException(Size.class.getSimpleName(), s);
	}
}
