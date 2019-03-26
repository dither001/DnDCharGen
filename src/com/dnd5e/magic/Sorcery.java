package com.dnd5e.magic;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.miscellaneous.util.*;

public class Sorcery {
	private static HashMap<Spell, Sorcery> spellMap;

	private static EnumSet<Spell> ABJURATIONS;
	private static EnumSet<Spell> CONJURATIONS;
	private static EnumSet<Spell> DIVINATIONS;
	private static EnumSet<Spell> ENCHANTMENTS;
	private static EnumSet<Spell> EVOCATIONS;
	private static EnumSet<Spell> ILLUSIONS;
	private static EnumSet<Spell> NECROMANCIES;
	private static EnumSet<Spell> TRANSMUTATIONS;

	static {
		spellMap = FileLoader.parseSpells("spells.csv");

		ABJURATIONS = EnumSet.noneOf(Spell.class);
		CONJURATIONS = EnumSet.noneOf(Spell.class);
		DIVINATIONS = EnumSet.noneOf(Spell.class);
		ENCHANTMENTS = EnumSet.noneOf(Spell.class);
		EVOCATIONS = EnumSet.noneOf(Spell.class);
		ILLUSIONS = EnumSet.noneOf(Spell.class);
		NECROMANCIES = EnumSet.noneOf(Spell.class);
		TRANSMUTATIONS = EnumSet.noneOf(Spell.class);

		for (Iterator<Sorcery> it = spellMap.values().iterator(); it.hasNext();) {
			Sorcery s = it.next();

			if (s.school.equals(School.ABJURATION))
				ABJURATIONS.add(s.spellName);
			else if (s.school.equals(School.CONJURATION))
				CONJURATIONS.add(s.spellName);
			else if (s.school.equals(School.DIVINATION))
				DIVINATIONS.add(s.spellName);
			else if (s.school.equals(School.ENCHANTMENT))
				ENCHANTMENTS.add(s.spellName);
			else if (s.school.equals(School.EVOCATION))
				EVOCATIONS.add(s.spellName);
			else if (s.school.equals(School.ILLUSION))
				ILLUSIONS.add(s.spellName);
			else if (s.school.equals(School.NECROMANCY))
				NECROMANCIES.add(s.spellName);
			else if (s.school.equals(School.TRANSMUTATION))
				TRANSMUTATIONS.add(s.spellName);

		}
	}

	/*
	 * INSTANCE VARIABLES
	 */
	protected String name;
	protected Spell spellName;
	protected School school;
	protected int level;

	/*
	 * CONSTRUCTORS
	 */
	public Sorcery() {
		this.school = School.ABJURATION;
		this.level = 1;
	}

	/*
	 * INSTANCE METHODS
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Spell getSpellName() {
		return spellName;
	}

	public void setSpellName(Spell spellName) {
		this.spellName = spellName;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	/*
	 * STATIC METHODS
	 */
	public static List<Sorcery> getSorceriesOfSchool(School school) {
		List<Sorcery> list = new ArrayList<Sorcery>();

		Sorcery s = null;
		for (Iterator<Sorcery> it = spellMap.values().iterator(); it.hasNext();) {
			s = it.next();

			if (s.school.equals(school))
				list.add(s);
		}

		return list;
	}

	public static List<Sorcery> getSorceriesOfSchool(int level, School school) {
		List<Sorcery> list = new ArrayList<Sorcery>();

		Sorcery s = null;
		for (Iterator<Sorcery> it = spellMap.values().iterator(); it.hasNext();) {
			s = it.next();

			if (s.level == level && s.school.equals(school))
				list.add(s);
		}

		return list;
	}

	public static List<Sorcery> getSorceriesOfSchool(School[] array) {
		List<Sorcery> list = new ArrayList<Sorcery>();

		Sorcery s = null;
		for (Iterator<Sorcery> it = spellMap.values().iterator(); it.hasNext();) {
			s = it.next();

			for (School el : array) {
				if (s.school.equals(el))
					list.add(s);
			}
		}

		return list;
	}

	public static List<Sorcery> getSorceriesOfSchool(int level, School[] array) {
		List<Sorcery> list = new ArrayList<Sorcery>();

		Sorcery s = null;
		for (Iterator<Sorcery> it = spellMap.values().iterator(); it.hasNext();) {
			s = it.next();

			if (s.level == level) {
				for (School el : array) {
					if (s.school.equals(el))
						list.add(s);
				}
			}
		}

		return list;
	}

	/*
	 * 
	 */
	public static List<Spell> getSpellsOfSchool(School school) {
		List<Spell> list = new ArrayList<Spell>();

		Sorcery s = null;
		for (Iterator<Sorcery> it = spellMap.values().iterator(); it.hasNext();) {
			s = it.next();

			if (s.school.equals(school))
				list.add(s.spellName);
		}

		return list;
	}

	public static List<Spell> getSpellsOfSchool(int level, School school) {
		List<Spell> list = new ArrayList<Spell>();

		Sorcery s = null;
		for (Iterator<Sorcery> it = spellMap.values().iterator(); it.hasNext();) {
			s = it.next();

			if (s.level == level && s.school.equals(school))
				list.add(s.spellName);
		}

		return list;
	}

	public static List<Spell> getSpellsOfSchool(School[] array) {
		List<Spell> list = new ArrayList<Spell>();

		Sorcery s = null;
		for (Iterator<Sorcery> it = spellMap.values().iterator(); it.hasNext();) {
			s = it.next();

			for (School el : array) {
				if (s.school.equals(el))
					list.add(s.spellName);
			}
		}

		return list;
	}

	public static List<Spell> getSpellsOfSchool(int level, School[] array) {
		List<Spell> list = new ArrayList<Spell>();

		Sorcery s = null;
		for (Iterator<Sorcery> it = spellMap.values().iterator(); it.hasNext();) {
			s = it.next();

			if (s.level == level) {
				for (School el : array) {
					if (s.school.equals(el))
						list.add(s.spellName);
				}
			}
		}

		return list;
	}
}
