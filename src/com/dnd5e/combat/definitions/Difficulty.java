package com.dnd5e.combat.definitions;

import com.dnd5e.character.definitions.*;

public enum Difficulty {
	EASY, MEDIUM, HARD, DEADLY;

	private static int[] DAILY_THRESHOLD = { 300, 600, 1200, 1700, 3500, 4000, 5000, 6000, 7500, 9000, 10500, 11500,
			13500, 15000, 18000, 20000, 25000, 27000, 30000, 40000 };

	private static int[][] ENCOUNTER_THRESHOLD = {
			{ 25, 50, 75, 125, 250, 300, 350, 450, 550, 600, 800, 1000, 1100, 1250, 1400, 1600, 2000, 2100, 2400,
					2800 },
			{ 50, 100, 150, 250, 500, 600, 750, 900, 1100, 1200, 1600, 2000, 2200, 2500, 2800, 3200, 3900, 4200, 4900,
					5700 },
			{ 75, 150, 225, 375, 750, 900, 1100, 1400, 1600, 1900, 2400, 3000, 3400, 3800, 4300, 4800, 5900, 6300, 7300,
					8500 },
			{ 100, 200, 400, 500, 1100, 1400, 1700, 2100, 2400, 2800, 3600, 4500, 5100, 5700, 6400, 7200, 8800, 9500,
					10900, 12700 } };

	/*
	 * 
	 */
	public static int getEncounterThreshold(Adventurer[] array, Difficulty d) {
		int threshold = 0;

		for (int i = 0; i < array.length; ++i)
			threshold += getEncounterThreshold(array[i].getLevel(), d);

		return threshold;
	}

	public static int getEncounterThreshold(int level, Difficulty d) {
		int threshold = 0;

		switch (d) {
		case DEADLY:
			threshold = ENCOUNTER_THRESHOLD[3][level];
		case EASY:
			threshold = ENCOUNTER_THRESHOLD[0][level];
		case HARD:
			threshold = ENCOUNTER_THRESHOLD[2][level];
		case MEDIUM:
			threshold = ENCOUNTER_THRESHOLD[1][level];
		}

		return threshold;
	}

}
