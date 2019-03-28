package com.dnd5e.monsters;

public abstract class Encounter {

	public static Monster[] redistribute(Monster[] array) {
		int dice = 2;

		// initialize table
		Monster[] table = new Monster[array.length];
		for (int i = 0; i < array.length; ++i)
			table[i] = null;

		int die = (array.length % dice == 1) ? array.length / 2 + 1 : array.length / 2;

		table[++die] = array[0];
		for (int i = 1; i + 1 < die; ++i) {
			table[die + i - 2] = array[i];
			table[die - i - 2] = array[i + 1];
		}

		return table;
	}

}
