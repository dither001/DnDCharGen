package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.dnd4e.definitions.*;
import com.dnd5e.character.classes.*;
import com.dnd5e.character.definitions.*;
import com.dnd5e.definitions.*;
import com.dnd5e.factions.*;
import com.dnd5e.gear.equipment.*;
import com.dnd5e.magic.*;
import com.dnd5e.monsters.*;
import com.dnd5e.worlds.*;
import com.miscellaneous.util.*;

import view.NPCFrame;

public class Main {
	public static final boolean TESTING_MESSAGES_ON = false;

	/*
	 * MAIN METHOD
	 */
	public static void main(String[] args) {
		new NPCFrame().setVisible(true);

	}

	private static void testing() {

		// List<Monster> list = new ArrayList<Monster>();
		// for (Monster el : Monster.monsterMap.values()) {
		// if (el.getNaturalWeapons().length == 0)
		// list.add(el);
		// }
		//
		// for (Monster el : list)
		// System.out.println(el);

		// Encounter.redistribute(new Monster[19]);

		/*
		 * (force these objects to initialize)
		 */
	}

}
