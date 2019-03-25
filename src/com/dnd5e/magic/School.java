package com.dnd5e.magic;

import com.miscellaneous.util.*;

public enum School {
	ABJURATION, CONJURATION, DIVINATION, ENCHANTMENT, EVOCATION, ILLUSION, NECROMANCY, TRANSMUTATION;

	/*
	 * STATIC FIELDS
	 */
	private static final School[] SCHOOLS = { ABJURATION, CONJURATION, DIVINATION, ENCHANTMENT, EVOCATION, ILLUSION,
			NECROMANCY, TRANSMUTATION };

	/*
	 * INSTANCE METHODS
	 */
	public int indexOf() {
		return Misc.indexOfEnum(this.toString(), SCHOOLS);
	}

	/*
	 * STATIC METHODS
	 */
	public static School get(int index) {
		return SCHOOLS[index];
	}

	public static School parse(String s) throws ParserException {
		for (School el : SCHOOLS) {
			if (el.toString().compareToIgnoreCase(s) == 0)
				return el;
		}

		throw new ParserException(s);
	}

}
