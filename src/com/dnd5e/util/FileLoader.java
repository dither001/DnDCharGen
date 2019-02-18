package com.dnd5e.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.dnd5e.definitions.*;
import com.dnd5e.exceptions.*;
import com.dnd5e.gear.definitions.Handed;
import com.dnd5e.gear.definitions.Material;
import com.dnd5e.gear.equipment.*;
import com.dnd5e.monsters.*;

public class FileLoader {
	private static final String[] SYSTEM_FILES = { "monsters.csv", "weapons.csv" };

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

			/*
			 * FIXME - TESTING
			 */
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

	public static HashMap<Skill, Weapon> parseWeapons(String filename) {
		HashMap<Skill, Weapon> map = new HashMap<Skill, Weapon>();
		BufferedReader input = null;

		String line = "";
		String comma = ",";

		try {
			input = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));
			// skips first character if '?'
			input.mark(1);
			if (input.read() != 0xFEFF)
				input.reset();

			Weapon weapon = null;
			Skill skill = null;
			int counter = 0;
			int[] dice = new int[] { 1, 1 };
			while ((line = input.readLine()) != null) {
				counter = 0;
				String[] values = line.split(comma), damageDice;

				weapon = new Weapon();
				weapon.setName(values[counter++]);
				weapon.setMaterial(Material.parse(values[counter++]));
				weapon.setCostCP(Integer.valueOf(values[counter++]));
				weapon.setWeightOzs(Integer.valueOf(values[counter++]));

				weapon.setIsStackable(false);
				weapon.setQuantity(Integer.valueOf(values[counter++]));
				weapon.setSizeOfStack(Integer.valueOf(values[counter++]));

				weapon.setHanded(Handed.parse(values[counter++]));

				skill = Skill.parseSimpleWeapon(values[counter++]);
				weapon.setSkills(new Skill[] { skill });

				// DAMAGE DICE ASSIGNMENT
				damageDice = values[counter++].split("d");
				dice[0] = Integer.valueOf(damageDice[0]);
				dice[1] = Integer.valueOf(damageDice[1]);
				weapon.setDamageDice(dice);
				weapon.setDamageType(Energy.parse(values[counter++]));
				// TODO - weapon.setTraits(traits);

				map.put(skill, weapon);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserException e) {
			e.printStackTrace();
		}

		return map;
	}
}
