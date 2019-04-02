package com.miscellaneous.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class Misc {

	/*
	 * A - ARRAY METHODS
	 */
	public static int[] initializeArray(int size, int value) {
		int[] array = new int[size];
		for (int i = 0; i < size; ++i)
			array[i] = value;

		return array;
	}

	public static int[] initializeArray(int size, int[] values) {
		int[] array = new int[size];
		for (int i = 0; i < size; ++i)
			array[i] = values[i];

		return array;
	}

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
	public static <T> List<T> arrayToList(T[] array) {
		List<T> list = new ArrayList<T>();
		for (int i = 0; i < array.length; ++i)
			list.add((T) array[i]);

		return list;
	}

	public static <T> List<T> addArrayToList(T[] array, List<T> list) {
		for (int i = 0; i < array.length; ++i)
			list.add((T) array[i]);

		return list;
	}

	public static <T> List<T> filterSetFor(T[] array, Set<T> set) {
		List<T> list = new ArrayList<T>();

		for (Iterator<T> it = set.iterator(); it.hasNext();) {
			T current = it.next();

			for (T el : array) {
				if (el.equals(current)) {
					list.add(current);
					break;
				}
			}
		}

		return list;
	}

	/*
	 * R - RANDOM METHODS
	 */
	public static <T> T randomFromArray(T[] array) {
		T choice = array[Dice.roll(array.length) - 1];

		return choice;
	}

	public static <T> T randomFromList(List<T> list) {
		Collections.shuffle(list);

		return list.get(0);
	}

	public static <T> T randomFromSet(Set<T> set) {
		return randomFromList(new ArrayList<T>(set));
	}

	/*
	 * S - SET METHODS
	 */
	public static <T> boolean tryToAdd(T el, Set<T> set) {
		return set.add(el);
	}

	public static <T> boolean tryToAdd(T[] array, Set<T> set) {
		return tryToAdd(1, array, set);
	}

	public static <T> boolean tryToAdd(List<T> array, Set<T> set) {
		return tryToAdd(1, array, set);
	}

	public static <T> boolean tryToAdd(int n, T[] array, Set<T> set) {
		boolean added = false;
		List<T> list = new ArrayList<T>();

		for (T el : array) {
			if (set.contains(el) != true)
				list.add(el);
		}

		if (list.size() > n - 1) {
			Collections.shuffle(list);

			for (int i = 0; i < n; ++i)
				set.add(list.get(i));

			added = true;
		}

		return added;
	}

	public static <T> boolean tryToAdd(int n, List<T> array, Set<T> set) {
		boolean added = false;
		List<T> list = new ArrayList<T>();

		for (T el : array) {
			if (set.contains(el) != true)
				list.add(el);
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
