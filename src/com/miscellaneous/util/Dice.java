package com.miscellaneous.util;

import java.util.ArrayList;
import java.util.List;
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

	/*
	 * 
	 */
	public static List<float[][]> rollVector3(int n) {
		List<float[][]> list = new ArrayList<float[][]>(n);

		for (int i = 0; i < n; ++i) {
			list.add(new float[][] { //
					pointUniform(RAND.nextInt(), RAND.nextInt()), //
					pointUniform(RAND.nextInt(), RAND.nextInt()), //
					pointUniform(RAND.nextInt(), RAND.nextInt()) //
			});
		}

		return list;
	}

	/*
	 * returns point on sphere of uniform distribution, given two random integers
	 */
	public static float[] pointUniform(int a, int b) {
		double x = 2 * Math.PI * (a / Double.MAX_VALUE);
		double y = Math.acos(2 * (b / Double.MAX_VALUE) - 1) - (0.5 * Math.PI);

		return new float[] { (float) (Math.sin(x) * Math.cos(y)), (float) Math.sin(y),
				(float) (Math.cos(x) * Math.cos(y)) };
	}

	public static String printVector3(float[] array) {
		return String.format("[%s, %s, %s]", array[0], array[1], array[2]);
	}

}
