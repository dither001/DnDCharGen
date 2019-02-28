package com.miscellaneous.util;

public abstract class Misc {

	/*
	 * H - HIT DICE
	 */
	public static int[] setupHitDice(int n, int size) {
		int[] array = new int[n];

		for (int i = 0; i < array.length; ++i)
			array[i] = (int) (0.5 * size);

		return array;
	}

	/*
	 * I - INDEX
	 */
	public static <T> int indexOfEnum(String string, T[] array) {
		int index = -1;
		for (int i = 0; i < array.length; ++i) {
			if (array[i].toString().compareToIgnoreCase(string) == 0) {
				index = i;
				break;
			}
		}

		return index;
	}

	/*
	 * R - RANDOM
	 */
	public static <T> T randomFromArray(T[] array) {
		T choice = array[Dice.roll(array.length) - 1];

		return choice;
	}

}
