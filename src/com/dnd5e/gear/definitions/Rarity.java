package com.dnd5e.gear.definitions;

public enum Rarity {
	MUNDANE, COMMON, UNCOMMON, RARE, VERY_RARE, LEGENDARY;
	
	public static int getBaseValue(Rarity rarity) {
		// base value in copper pieces
		int baseValue = 1;

		if (rarity.equals(COMMON))
			baseValue = 50;
		else if (rarity.equals(UNCOMMON))
			baseValue = 101;
		else if (rarity.equals(RARE))
			baseValue = 501;
		else if (rarity.equals(VERY_RARE))
			baseValue = 5001;
		else if (rarity.equals(LEGENDARY))
			baseValue = 50001;

		// convert from gold to copper value
		return baseValue * 100;
	}

	public static Rarity getRarity(int value) {
		Rarity rarity = MUNDANE;

		// convert from copper to gold value
		value /= (value > 1000) ? 100 : 1;
		if (value > 50000) {
			rarity = LEGENDARY;
		} else if (value > 5000) {
			rarity = VERY_RARE;
		} else if (value > 500) {
			rarity = RARE;
		} else if (value > 100) {
			rarity = UNCOMMON;
		} else if (value > 50) {
			rarity = COMMON;
		}

		return rarity;
	}

}
