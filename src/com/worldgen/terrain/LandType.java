package com.worldgen.terrain;

public enum LandType {
	LAND, WATER, COAST;

	public static LandType get(int i) {
		if (i == 1)
			return LAND;
		else if (i == 2)
			return WATER;
		else if (i == 4)
			return COAST;

		return null;
	}
}
