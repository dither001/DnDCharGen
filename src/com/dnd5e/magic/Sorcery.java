package com.dnd5e.magic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.dnd5e.definitions.magic.*;

public class Sorcery {
	private static HashMap<Spell, Sorcery> spellMap;
	
	static {
		spellMap = new HashMap<Spell, Sorcery>();
	}

	/*
	 * INSTANCE VARIABLES
	 */
	protected String name;
	protected Spell spell;
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
		return spell;
	}

	public void setSpellName(Spell spellName) {
		this.spell = spellName;
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
				list.add(s.spell);
		}

		return list;
	}

	public static List<Spell> getSpellsOfSchool(int level, School school) {
		List<Spell> list = new ArrayList<Spell>();

		Sorcery s = null;
		for (Iterator<Sorcery> it = spellMap.values().iterator(); it.hasNext();) {
			s = it.next();

			if (s.level == level && s.school.equals(school))
				list.add(s.spell);
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
					list.add(s.spell);
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
						list.add(s.spell);
				}
			}
		}

		return list;
	}
	
	public static void setupSpells(HashMap<Spell, Sorcery> spellMap) {
		Sorcery.spellMap = spellMap;
	}
}
