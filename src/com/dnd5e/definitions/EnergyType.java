package com.dnd5e.definitions;

import com.miscellaneous.util.*;

public enum EnergyType {
	BLUDGEONING, PIERCING, SLASHING, FORCE, FIRE, COLD, LIGHTNING, ACID, RADIANT, THUNDER, NECROTIC, PSYCHIC, POISON;

	private static final EnergyType[] ENERGIES = { ACID, BLUDGEONING, COLD, FIRE, FORCE, LIGHTNING, NECROTIC, PIERCING,
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
	public static EnergyType get(int index) {
		return ENERGIES[index];
	}
	
	public static EnergyType parse(String s) throws ParserException {
		for (EnergyType el : ENERGIES) {
			if (el.toString().compareToIgnoreCase(s) == 0)
				return el;
		}
		
		throw new ParserException();
	}
}
