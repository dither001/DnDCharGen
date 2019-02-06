package com.dnd5e.util;

import java.util.Random;

public abstract class Dice {
	/*
	 * STATIC FIELDS
	 */
	private static final Random RAND = new Random();

	/*
	 * STATIC METHODS
	 */
	public static int roll(int faces) {
		return roll(1, faces);
	}

	public static int roll(int dice, int faces) {
		int result = 0;

		dice = (dice < 1) ? 1 : dice;
		faces = (faces < 1) ? 1 : faces;

		for (int i = 0; i < dice; ++i) {
			result += RAND.nextInt(faces) + 1;
		}

		return result;
	}

	public static int[] roll3d6InOrder() {
		int[] array = new int[] { 0, 0, 0, 0, 0, 0 };
		for (int i = 0; i < array.length; ++i) {
			array[i] += roll(3, 6);
		}

		return array;
	}


}
