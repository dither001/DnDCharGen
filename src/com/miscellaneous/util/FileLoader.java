package com.miscellaneous.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import com.dnd5e.definitions.*;
import com.dnd5e.exceptions.*;
import com.dnd5e.gear.definitions.*;
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
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static HashMap<Skill, Armor> parseArmor(String filename) {
		HashMap<Skill, Armor> map = new HashMap<Skill, Armor>();
		BufferedReader input = null;

		String line = "";
		String comma = ",";

		try {
			input = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));
			// skips first character if '?'
			input.mark(1);
			if (input.read() != 0xFEFF)
				input.reset();

			Armor armor = null;
			Skill skill = null;
			int counter = 0;
			while ((line = input.readLine()) != null) {
				counter = 0;
				String[] values = line.split(comma);

				armor = new Armor();
				armor.setName(values[counter++]);
				armor.setMaterial(Material.parse(values[counter++]));
				armor.setCostCP(Integer.valueOf(values[counter++]));
				armor.setWeightOz(Integer.valueOf(values[counter++]));

				armor.setIsStackable(false);
				armor.setQuantity(Integer.valueOf(values[counter++]));
				armor.setSizeOfStack(Integer.valueOf(values[counter++]));

				armor.setHanded(Handed.parse(values[counter++]));

				// skill parser
				skill = Skill.parseArmorType(values[counter++]);
				armor.setSkills(new Skill[] { skill });

				armor.setArmorClass(Integer.valueOf(values[counter++]));
				armor.setDexterityBonus(Integer.valueOf(values[counter++]));

				map.put(skill, armor);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserException e) {
			e.printStackTrace();
		}

		return map;
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

			WeaponTrait[] traits = null;
			Weapon weapon = null;
			Skill skill = null;
			int counter = 0;
			int[] dice = new int[] { 1, 1 };
			while ((line = input.readLine()) != null) {
				counter = 0;
				String[] values = line.split(comma), damageDice, weaponTraits;

				weapon = new Weapon();
				weapon.setName(values[counter++]);
				weapon.setMaterial(Material.parse(values[counter++]));
				weapon.setCostCP(Integer.valueOf(values[counter++]));
				weapon.setWeightOz(Integer.valueOf(values[counter++]));

				weapon.setQuantity(Integer.valueOf(values[counter++]));
				weapon.setSizeOfStack(Integer.valueOf(values[counter++]));

				if (weapon.getQuantity() > 1)
					weapon.setIsStackable(true);
				else
					weapon.setIsStackable(false);

				weapon.setHanded(Handed.parse(values[counter++]));

				// skill parser
				skill = Skill.parseWeapon(values[counter++]);
				weapon.setSkills(new Skill[] { skill });

				// DAMAGE DICE ASSIGNMENT
				damageDice = values[counter++].split("d");
				dice[0] = Integer.valueOf(damageDice[0]);
				dice[1] = Integer.valueOf(damageDice[1]);
				weapon.setDamageDice(dice);
				weapon.setDamageType(Energy.parse(values[counter++]));

				// WEAPON TRAITS
				if (values.length > 10) {
					weaponTraits = values[counter++].split(".");
					traits = new WeaponTrait[weaponTraits.length];
					for (int i = 0; i < traits.length; ++i)
						traits[i] = WeaponTrait.parse(weaponTraits[i]);

					weapon.setTraits(traits);
				}

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
