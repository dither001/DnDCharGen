package com.dnd5e.definitions;

import com.miscellaneous.util.*;

public enum EnergyType {
	BLUDGEONING, PIERCING, SLASHING, FORCE, FIRE, COLD, LIGHTNING, ACID, RADIANT, THUNDER, NECROTIC, PSYCHIC, POISON;

	private static final EnergyType[] ENERGIES = { ACID, BLUDGEONING, COLD, FIRE, FORCE, LIGHTNING, NECROTIC, PIERCING,
			POISON, PSYCHIC, RADIANT, SLASHING, THUNDER };

	private static final EnergyType[] TIER_ZERO = { FORCE };
	private static final EnergyType[] TIER_ONE = { COLD, FIRE };
	private static final EnergyType[] TIER_TWO = { ACID, LIGHTNING, RADIANT, THUNDER };
	private static final EnergyType[] TIER_THREE = { NECROTIC, POISON, PSYCHIC };

	private static final EnergyType[][] TIERS = { TIER_ZERO, TIER_ONE, TIER_TWO, TIER_THREE };

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

		throw new ParserException(s);
	}

	public static int[] randomVulnerabilities() {
		int[] array = new int[] { 0, 0, 0 };

		int a = Dice.roll(3) - 1;
		array[a] = Dice.roll(21) - 11;
		array[(a + 1) % 3] = Dice.roll(Math.abs(array[a])) - 1;
		array[(a + 2) % 3] = Math.abs(array[a]) - array[(a + 1) % 3];
		
		if (array[a] > 0) {
			array[(a + 1) % 3] *= -1;
			array[(a + 2) % 3] *= -1;
		}

		return new int[] { array[0] * 10, array[1] * 10, array[2] * 10 };
	}
}
