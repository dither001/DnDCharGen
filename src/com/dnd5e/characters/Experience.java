package com.dnd5e.characters;

public abstract class Experience {

	private static final int MAX_LEVEL;
	private static final int[] XP_FOR_NEXT_LEVEL;

	static {
		//
		MAX_LEVEL = 20;

		//
		XP_FOR_NEXT_LEVEL = new int[] { 300, 900, 2700, 6500, 14000, 23000, 34000, 48000, 64000, 85000, 100000, 120000,
				140000, 165000, 195000, 225000, 265000, 305000, 355000 };

	}

	/*
	 * Gets the total experience required to advance to the passed level.
	 * 
	 * @param currentLevel: current character level
	 * 
	 * @return experience required for next level
	 * 
	 * @throws IllegalArgumentException if level is invalid
	 */
	public static int getEXPForNextLevel(int currentLevel) {
		if (currentLevel < 1 || currentLevel >= MAX_LEVEL)
			throw new IllegalArgumentException(currentLevel + " not a valid level");

		// XP_FOR_LEVEL[0] is for 1st level
		return XP_FOR_NEXT_LEVEL[currentLevel - 1];
	}

	public static int getLevelForEXP(int experience) {
		if (experience < 0)
			throw new IllegalArgumentException("EXP " + experience + " must not be negative");

		int level = 1;
		for (int el : XP_FOR_NEXT_LEVEL) {
			if (experience < el)
				break;
			else
				++level;
		}

		return level;
	}

}
