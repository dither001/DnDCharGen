package com.dnd5e.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.dnd5e.exceptions.*;
import com.dnd5e.monsters.Cornerstone;

public class FileLoader {
	private static final String[] SYSTEM_FILES = { "monsters.csv" };

	/*
	 * INITIALIZATION
	 */
	static {
		parseMonsters(SYSTEM_FILES[0]);
	}

	/*
	 * STATIC METHODS
	 */
	public static void parseMonsters(String filename) {
		BufferedReader input = null;

		String line = "";
		String comma = ",";

		int[] types = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		try {
			input = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));

			// skips first character if '?'
			input.mark(1);
			if (input.read() != 0xFEFF)
				input.reset();

			while ((line = input.readLine()) != null) {
				String[] values = line.split(comma);

				++types[Cornerstone.parse(values[1]).indexOf()];
			}

			for (int i = 0; i < types.length; ++i) {
				System.out.printf("%2d (%5.1f%%) %s\n", types[i], 1.0 * types[i] / 167 * 100,
						Cornerstone.get(i).toString());
			}

			input.close();
			// END OF READING AND CLOSE
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidCornerstoneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
