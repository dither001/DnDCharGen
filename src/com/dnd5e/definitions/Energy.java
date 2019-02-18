package com.dnd5e.definitions;

import com.dnd5e.exceptions.*;
import com.dnd5e.util.*;

public enum Energy {
	BLUDGEONING, PIERCING, SLASHING, FORCE, FIRE, COLD, LIGHTNING, ACID, RADIANT, THUNDER, NECROTIC, PSYCHIC, POISON;

	private static final Energy[] ENERGIES = { ACID, BLUDGEONING, COLD, FIRE, FORCE, LIGHTNING, NECROTIC, PIERCING,
			POISON, PSYCHIC, RADIANT, SLASHING, THUNDER };

	/*
	 * INSTANCE METHODS
	 */
	public int indexOf() {
		return Misc.indexOfEnum(this.toString(), ENERGIES);
	}
	
	/*
	 * STATIC METHODS
	 */
	public static Energy get(int index) {
		return ENERGIES[index];
	}
	
	public static Energy parse(String s) throws ParserException {
		for (Energy el : ENERGIES) {
			if (el.toString().compareToIgnoreCase(s) == 0)
				return el;
		}
		
		throw new ParserException();
	}
}
