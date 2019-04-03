package com.dnd5e.gear.equipment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.dnd5e.character.classes.*;
import com.dnd5e.character.definitions.DnDClass;
import com.dnd5e.gear.definitions.*;
import com.dnd5e.magic.*;
import com.miscellaneous.util.*;

public class Spellbook extends Tool {

	/*
	 * INSTANCE FIELDS
	 */
	protected HashMap<Spell, Integer> spellbook;

	/*
	 * CONSTRUCTORS
	 */
	private Spellbook() {
		super();

		this.spellbook = new HashMap<Spell, Integer>();
		this.handed = Handed.ONE;
	}

	/*
	 * INSTANCE METHODS
	 */
	public void add(int level, Spell spell) {
		spellbook.put(spell, new Integer(level));
	}

	public void addAll(int[] levels, Spell[] spells) {
		for (int i = 0; i < spells.length; ++i)
			spellbook.put(spells[i], levels[i]);
	}

	public List<Spell> getSpellsList() {
		return new ArrayList<Spell>(spellbook.keySet());
	}

	public List<Spell> getSpellsOfLevel(int level) {
		List<Spell> list = new ArrayList<Spell>();

		for (Iterator<Spell> it = spellbook.keySet().iterator(); it.hasNext();) {
			Spell spell = it.next();
			if (spellbook.get(spell).equals(level))
				list.add(spell);
		}

		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Spell>[] getSpellsByLevel() {
		List<Spell>[] array = (ArrayList<Spell>[]) new ArrayList[10];

		for (int i = 0; i < array.length; ++i)
			array[i] = new ArrayList<Spell>();

		for (Iterator<Spell> it = spellbook.keySet().iterator(); it.hasNext();) {
			Spell spell = it.next();
			array[(int) spellbook.get(spell)].add(spell);
		}

		return array;
	}

	public int size() {
		return spellbook.size();
	}

	/*
	 * STATIC METHODS
	 */
	public static Spellbook build() {
		int numberOfSpells = 6;
		int spellsLevel = 1;

		Spellbook spellbook = new Spellbook();
		int[] levels = Misc.initializeArray(numberOfSpells, spellsLevel);
		Spell[] spells = new Spell[numberOfSpells];

		List<Spell> list = Spell.spellsList(spellsLevel, DnDClass.WIZARD);
		Collections.shuffle(list);

		for (int i = 0; i < numberOfSpells; ++i)
			spells[i] = list.get(i);

		// add spells from spells/levels arrays
		spellbook.addAll(levels, spells);
		return spellbook;
	}
}
