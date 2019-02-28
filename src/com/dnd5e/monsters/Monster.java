package com.dnd5e.monsters;

import java.util.HashMap;

import com.dnd5e.characters.*;
import com.miscellaneous.util.FileLoader;

public class Monster extends Actor {
	private static HashMap<String, Monster> monsterMap;

	static {
		monsterMap = FileLoader.parseMonsters("monsters.csv");
		
		for (Monster el : monsterMap.values()) {
			System.out.println(el.toString());
		}
	}

	public Monster() {
		super();
	}
	
	public String toStringVerbose() {
		String s = "";

		s += String.format("%20s %s\n", name);
		s += abilityArrayToString() + "\n";

		return s;
	}

	public String toString() {
		return String.format("%20s %s", name, abilityArrayToString());
	}
}
