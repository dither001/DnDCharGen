package com.norvendae.definitions.towns;

/*
 * Settlement sizes and descriptions adapted from Dungeon Master's Guide (Third Edition).
 */

public enum SettlementType {
	THORP, HAMLET, VILLAGE, TOWN, CITY, METROPOLIS;

	private static final SettlementType[] TYPES;

	//
	private static final int[] COMMUNITY_MODIFIER;
	private static final int[] CURRENCY_LIMIT;
	private static final int[] POPULATION_THRESHOLD;

	static {
		TYPES = new SettlementType[] { THORP, HAMLET, VILLAGE, TOWN, CITY, METROPOLIS };
		//
		COMMUNITY_MODIFIER = new int[] { -1, 0, 3, 6, 9, 12 };
		CURRENCY_LIMIT = new int[] { 100, 200, 800, 3000, 15000, 40000 };
		POPULATION_THRESHOLD = new int[] { 400, 900, 2000, 5000, 12000, 25000 };
	}

	/*
	 * INSTANCE METHODS
	 */
	public int indexOf() {
		return indexOf(this);
	}

	/*
	 * STATIC METHODS
	 */
	public static SettlementType get(int index) {
		return TYPES[index];
	}

	public static int indexOf(SettlementType type) {
		switch (type) {
		case THORP:
			return 0;
		case HAMLET:
			return 1;
		case CITY:
			return 2;
		case VILLAGE:
			return 3;
		case TOWN:
			return 4;
		case METROPOLIS:
			return 5;
		default:
			return -1;
		}
	}

	public static int communityModifier(SettlementType type) {
		return COMMUNITY_MODIFIER[indexOf(type)];
	}

	public static int currencyLimit(SettlementType type) {
		return CURRENCY_LIMIT[indexOf(type)];
	}

	public static int populationCapacity(SettlementType type) {
		return POPULATION_THRESHOLD[indexOf(type)];
	}
}
