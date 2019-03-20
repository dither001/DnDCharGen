package com.miscellaneous.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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
	 * I - INDEX METHODS
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
	 * L - LIST METHODS
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> arrayToList(Object[] array) {
		List<T> list = new ArrayList<T>();
		for (int i = 0; i < array.length; ++i)
			list.add((T) array[i]);

		return list;
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> addArrayToList(Object[] array, List<T> list) {
		for (int i = 0; i < array.length; ++i)
			list.add((T) array[i]);

		return list;
	}

	/*
	 * R - RANDOM METHODS
	 */
	public static <T> T randomFromArray(T[] array) {
		T choice = array[Dice.roll(array.length) - 1];

		return choice;
	}

	/*
	 * S - SET METHODS
	 */
	public static <T> boolean tryToAdd(T el, Set<T> set) {
		return set.add(el);
	}

	public static <T> boolean tryToAdd(Object[] array, Set<T> set) {
		return tryToAdd(1, array, set);
	}

	public static <T> boolean tryToAdd(List<Object> array, Set<T> set) {
		return tryToAdd(1, array, set);
	}

	@SuppressWarnings("unchecked")
	public static <T> boolean tryToAdd(int n, Object[] array, Set<T> set) {
		boolean added = false;
		List<T> list = new ArrayList<T>();

		for (Object el : array) {
			if (set.contains(el) != true)
				list.add((T) el);
		}

		if (list.size() > n - 1) {
			Collections.shuffle(list);

			for (int i = 0; i < n; ++i)
				set.add(list.get(i));

			added = true;
		}

		return added;
	}

	@SuppressWarnings("unchecked")
	public static <T> boolean tryToAdd(int n, List<Object> array, Set<T> set) {
		boolean added = false;
		List<T> list = new ArrayList<T>();

		for (Object el : array) {
			if (set.contains(el) != true)
				list.add((T) el);
		}

		if (list.size() > n - 1) {
			Collections.shuffle(list);

			for (int i = 0; i < n; ++i)
				set.add(list.get(i));

			added = true;
		}

		return added;
	}

}
