package com.dnd5e.monsters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.dnd4e.definitions.*;
import com.dnd5e.characters.Actor;
import com.dnd5e.definitions.combat.*;
import com.dnd5e.definitions.rules.*;
import com.dnd5e.equipment.*;

public class Monster extends Actor {
	private static HashMap<String, Monster> monsterMap;
	
	static {
		monsterMap = new HashMap<String, Monster>(); 
	}

	protected Weapon[] naturalWeapons;

	/*
	 * CONSTRUCTORS
	 */
	public Monster() {
		super();

		this.naturalWeapons = new Weapon[0];
	}

	/*
	 * INSTANCE METHODS
	 */
	public String toStringVerbose() {
		String s = "";

		s += String.format("%s %s %s\n", name, size.toString(), creatureType.toString());
		s += abilityArrayToString() + "\n";

		for (Attack el : getNaturalWeaponAttackList())
			s += el + "\n";

		return s;
	}

	public Weapon[] getNaturalWeapons() {
		return naturalWeapons;
	}

	public void setNaturalWeapons(Weapon[] naturalWeapons) {
		this.naturalWeapons = naturalWeapons;
	}

	public List<Attack> getNaturalWeaponAttackList() {
		List<Attack> list = new ArrayList<Attack>();

		for (Weapon el : naturalWeapons)
			list.add(BasicAttack.build(el, this));

		return list;
	}

	/*
	 * STATIC METHODS
	 */
	public static List<Monster> getCornerstone(Cornerstone c) {
		List<Monster> list = new ArrayList<Monster>();

		for (Iterator<Monster> it = monsterMap.values().iterator(); it.hasNext();) {
			Monster m = it.next();

			if (m.getCornerstone().equals(c))
				list.add(m);
		}

		return list;
	}

	public static void setupMonsters(HashMap<String, Monster> monsterMap) {
		Monster.monsterMap = monsterMap;
	}
}
