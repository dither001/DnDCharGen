package com.miscellaneous.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import com.dnd5e.definitions.*;
import com.dnd5e.gear.definitions.*;
import com.dnd5e.gear.equipment.*;
import com.dnd5e.magic.*;
import com.dnd5e.monsters.*;

public class FileLoader {

	/*
	 * STATIC METHODS
	 */
	public static HashMap<String, Monster> parseMonsters(String filename) {
		HashMap<String, Monster> map = new HashMap<String, Monster>();
		BufferedReader input = null;

		String line = "";
		String comma = ",";

		try {
			input = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));

			// skips first character if '?'
			input.mark(1);
			if (input.read() != 0xFEFF)
				input.reset();

			while ((line = input.readLine()) != null) {
				String[] values = line.split(comma);

				Monster monster = new Monster();
				int counter = 0, dexMod = 0, conMod = 0, hitDice = 0, hdSize = 0;

				monster.setName(values[counter++]);
				// monster.setFemale(false);
				// monster.setAlignment(Alignment.UNALIGNED);
				// monster.setGod(God.ASMODEUS);

				++counter; // my creature type system
				monster.setStrength(Integer.valueOf(values[counter++]));
				monster.setDexterity(Integer.valueOf(values[counter++]));
				dexMod = monster.getDexterityModifier(); // DEX
				monster.setConstitution(Integer.valueOf(values[counter++]));
				conMod = monster.getConstitutionModifier(); // CON
				monster.setIntelligence(Integer.valueOf(values[counter++]));
				monster.setWisdom(Integer.valueOf(values[counter++]));
				monster.setCharisma(Integer.valueOf(values[counter++]));

				monster.setCreatureSize(Size.parse(values[counter++]));
				monster.setCreatureType(CreatureType.parse(values[counter++]));

				++counter; // Armor Class
				hitDice = Integer.valueOf(values[counter++]);
				hdSize = monster.getCreatureSize().hitDieSize();
				monster.setHitDice(Misc.setupHitDice(hitDice, hdSize));

				if (values.length > 12) {
					++counter; // attack
					++counter; // damage
					++counter; // type
				}

				map.put(monster.getName(), monster);
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

		return map;
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
				weapon.setDamageType(EnergyType.parse(values[counter++]));

				// WEAPON TRAITS
				if (values.length > 10) {
					weaponTraits = values[counter++].split(":");

					traits = new WeaponTrait[weaponTraits.length];
					for (int i = 0; i < weaponTraits.length; ++i) {
						traits[i] = WeaponTrait.parse(weaponTraits[i]);
					}

					weapon.setTraits(traits);
				} else {
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

	public static HashMap<Spell, Sorcery> parseSpells(String filename) {
		HashMap<Spell, Sorcery> map = new HashMap<Spell, Sorcery>();
		BufferedReader input = null;

		String line = "";
		String comma = ",";

		try {
			input = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));

			// skips first character if '?'
			input.mark(1);
			if (input.read() != 0xFEFF)
				input.reset();

			while ((line = input.readLine()) != null) {
				String[] values = line.split(comma);

				Sorcery sorcery = new Sorcery();
				sorcery.setName(values[0]);
				sorcery.setLevel(Integer.valueOf(values[1]));
				sorcery.setSchool(School.parse(values[2]));

				map.put(Spell.parse(values[0]), sorcery);
			}
		} catch (IOException | ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return map;
	}

}
