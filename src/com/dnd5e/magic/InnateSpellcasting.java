package com.dnd5e.magic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.dnd5e.definitions.magic.*;

public class InnateSpellcasting implements Cloneable {
	private HashMap<Spell, Integer> spellMap;

	/*
	 * CONSTRUCTORS
	 */
	public InnateSpellcasting() {
		spellMap = new HashMap<Spell, Integer>();
	}

	/*
	 * INSTANCE METHODS
	 */
	public void add(int usage, Spell spell) {
		spellMap.put(spell, new Integer(usage));
	}

	public void clear() {
		spellMap.clear();
	}

	public InnateSpellcasting clone() {
		InnateSpellcasting clone = new InnateSpellcasting();

		for (Iterator<Spell> it = spellMap.keySet().iterator(); it.hasNext();) {
			Spell spell = it.next();
			clone.add(spellMap.get(spell), spell);
		}

		return clone;
	}

	public Set<Spell> getSpellsList() {
		return spellMap.keySet();
	}

	public int size() {
		return spellMap.size();
	}

	public String toString() {
		return spellMap.keySet().toString();
	}
}
