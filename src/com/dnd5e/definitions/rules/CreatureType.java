package com.dnd5e.definitions.rules;

import com.miscellaneous.util.*;

public enum CreatureType {
	ABERRATION, BEAST, CELESTIAL, CONSTRUCT, DRAGON, ELEMENTAL, FEY, FIEND, GIANT, HUMANOID, MONSTROSITY, OOZE, PLANT, UNDEAD;

	private static final CreatureType[] CREATURE_TYPES = { ABERRATION, BEAST, CELESTIAL, CONSTRUCT, DRAGON, ELEMENTAL,
			FEY, FIEND, GIANT, HUMANOID, MONSTROSITY, OOZE, PLANT, UNDEAD };

	/*
	 * 
	 */
	public int indexOf() {
		// TODO
		for (int i = 0; i < CREATURE_TYPES.length; ++i) {
			if (CREATURE_TYPES[i].equals(this))
				return i;
		}

		return -1;
	}
	
	/*
	 * 
	 */
	public static CreatureType get(int index) {
		return CREATURE_TYPES[index];
	}
	
	public static CreatureType parse(String s) throws ParserException {
		for (CreatureType el : CREATURE_TYPES) {
			if (el.toString().compareToIgnoreCase(s) == 0)
				return el;
		}
		
		throw new ParserException(CreatureType.class.getSimpleName(), s);
	}
}
