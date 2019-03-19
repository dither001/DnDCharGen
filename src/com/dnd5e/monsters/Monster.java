package com.dnd5e.monsters;

import java.util.HashMap;

import com.dnd5e.character.definitions.*;
import com.dnd5e.definitions.Actor;
import com.miscellaneous.util.*;

public class Monster extends Actor {
	private static HashMap<String, Monster> monsterMap;

	static {
		monsterMap = FileLoader.parseMonsters("monsters.csv");
		
		for (Monster el : monsterMap.values()) {
			System.out.println(el.toStringVerbose());
		}
	}

	/*
	 * CONSTRUCTORS
	 */
	public Monster() {
		super();
	}
	
}
