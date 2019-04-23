package com.dnd1e.encounters;

/*
 * Based on "Dungeon Random Monster Level Determination Matrix" found on page 174 of
 *  the Dungeon Masters Guide (1977).
 */

import com.miscellaneous.util.Dice;

public class EncounterMatrix {
	/*
	 * The Numbers column assumes that the encounter will take place on the level
	 * which is equivalent to the level assigned to the particular monster.
	 * 
	 * In order to adjust for the more difficult conditions on lower levels of the
	 * dungeon, and the relatively easier ones above, use the following rules:
	 * 
	 * 1.) Lesser monsters on lower levels have their numbers augmented by a like
	 * number of the same sort of creatures for each level of the dungeon beneath
	 * that of the assigned level of the monster type encountered. There are two
	 * exceptions to this rule:
	 * 
	 * a. Characters are increased by level of experience rather than by numbers
	 * encountered, as indicated in the DUNGEON RANDOM MONSTER TABLE Notes.
	 * 
	 * b. Ninth and tenth level monsters are typically given attendant monsters,
	 * rather than greater numbers, in lower dungeon levels, i.e., a demon prince
	 * encountered on the 11th dungeon level might have a single type I demon
	 * attendant, while on the 15th level of the dungeon the same demon prince might
	 * have 5 such lesser demons or a pair of type III escorts.
	 * 
	 * 2.) Greater monsters on higher levels will have their numbers reduced by 1
	 * for each level of the dungeon above their assigned level, subject to a
	 * minimum number of 1.
	 * 
	 * Dungeon Masters Guide (1977), page 174
	 */

	private static int[][] MONSTER_TABLES;

	static {
		MONSTER_TABLES = new int[][] { //
				new int[] { 0, 16, 19, 20 }, // 1st
				new int[] { 0, 12, 16, 18, 19, 20 }, // 2nd-3rd
				new int[] { 0, 5, 10, 16, 18, 19, 20 }, // 4th
				new int[] { 0, 3, 6, 12, 16, 18, 19, 20 }, // 5th
				new int[] { 0, 2, 4, 6, 12, 16, 18, 19, 20 }, // 6th
				new int[] { 0, 1, 3, 5, 10, 14, 16, 18, 19, 20 }, // 7th
				new int[] { 0, 1, 2, 4, 7, 10, 14, 16, 18, 19, 20 }, // 8th
				new int[] { 0, 1, 2, 3, 5, 8, 12, 15, 17, 19, 20 }, // 9th
				new int[] { 0, 1, 2, 3, 4, 6, 9, 12, 16, 19, 20 }, // 10th-11th
				new int[] { 0, 1, 2, 3, 4, 5, 7, 9, 12, 18, 20 }, // 12th-13th
				new int[] { 0, 1, 2, 3, 4, 5, 6, 8, 11, 17, 20 }, // 14th-15th
				new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 10, 16, 20 }, // 16-plus
		};
	}

	/*
	 * STATIC METHODS
	 */
	public static int monsterLevel(int floor) {

		int[] array = null;
		int dice = Dice.roll(20);

		if (floor == 1)
			array = MONSTER_TABLES[0];
		else if (floor == 2 || floor == 3)
			array = MONSTER_TABLES[1];
		else if (floor == 4)
			array = MONSTER_TABLES[2];
		else if (floor == 5)
			array = MONSTER_TABLES[3];
		else if (floor == 6)
			array = MONSTER_TABLES[4];
		else if (floor == 7)
			array = MONSTER_TABLES[5];
		else if (floor == 8)
			array = MONSTER_TABLES[6];
		else if (floor == 9)
			array = MONSTER_TABLES[7];
		else if (floor == 10 || floor == 11)
			array = MONSTER_TABLES[8];
		else if (floor == 12 || floor == 13)
			array = MONSTER_TABLES[9];
		else if (floor == 14 || floor == 15)
			array = MONSTER_TABLES[10];
		else if (floor >= 16)
			array = MONSTER_TABLES[11];

		int monsterLevel = 1;
		while (dice > array[monsterLevel])
			++monsterLevel;

		return monsterLevel;
	}

}
