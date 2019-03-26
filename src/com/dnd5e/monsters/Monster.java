package com.dnd5e.monsters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.dnd5e.character.definitions.*;
import com.dnd5e.definitions.*;
import com.miscellaneous.util.*;

public class Monster extends Actor {
	public static HashMap<String, Monster> monsterMap;

	static {
		monsterMap = FileLoader.parseMonsters("monsters.csv");

	}

	/*
	 * CONSTRUCTORS
	 */
	public Monster() {
		super();
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

}
