package com.dnd4e.definitions;

import com.dnd5e.exceptions.*;
import com.miscellaneous.util.*;

public enum PowerSource implements Opposite, Similar {
	ARCANE, DIVINE, ELEMENTAL, MARTIAL, PRIMAL, PSIONIC, SHADOW;

	/*
	 * STATIC FIELDS
	 */
	private static final PowerSource[] POWER_SOURCES = { ARCANE, DIVINE, ELEMENTAL, MARTIAL, PRIMAL, PSIONIC, SHADOW };

	/*
	 * INSTANCE METHODS
	 */
	public int indexOf() {
		return Misc.indexOfEnum(this.toString(), POWER_SOURCES);
	}

	@Override
	public int similarTo(Object o) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public boolean opposedTo(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * STATIC METHODS
	 */
	public static PowerSource get(int index) {
		return POWER_SOURCES[index];
	}

	public static PowerSource parse(String s) throws ParserException {
		for (PowerSource el : POWER_SOURCES) {
			if (el.toString().compareToIgnoreCase(s) == 0)
				return el;
		}

		throw new ParserException(PowerSource.class.getName(), s);
	}

	public static PowerSource random() {
		return Misc.randomFromArray(POWER_SOURCES);
	}
}
