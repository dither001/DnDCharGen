package com.dnd5e.gear.definitions;

import com.dnd5e.exceptions.*;
import com.dnd5e.util.*;

public enum WeaponTrait {
	FINESSE, REACH, THROWN, AMMUNITION, LOADING, IMPROVISED;

	private static final WeaponTrait[] TRAITS = { AMMUNITION, FINESSE, IMPROVISED, LOADING, REACH, THROWN };

	/*
	 * INSTANCE METHODS
	 */
	public int indexOf() {
		return Misc.indexOfEnum(this.toString(), TRAITS);
	}

	/*
	 * STATIC METHODS
	 */
	public static WeaponTrait get(int index) {
		return TRAITS[index];
	}

	public static WeaponTrait parse(String s) throws ParserException {
		for (WeaponTrait el : TRAITS) {
			if (el.toString().compareToIgnoreCase(s) == 0)
				return el;
		}

		throw new ParserException();
	}

}
