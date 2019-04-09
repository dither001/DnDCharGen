package controller;
//import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;

import com.dnd5e.gear.equipment.Armor;
import com.dnd5e.gear.equipment.Tool;
import com.dnd5e.gear.equipment.Weapon;
import com.dnd5e.magic.Sorcery;
import com.dnd5e.monsters.Monster;
import com.miscellaneous.util.FileLoader;

//import java.util.Iterator;
//import java.util.List;
//
//import com.dnd4e.definitions.*;
//import com.dnd5e.character.classes.*;
import com.dnd5e.character.definitions.*;
//import com.dnd5e.definitions.*;
//import com.dnd5e.factions.*;
//import com.dnd5e.gear.equipment.*;
//import com.dnd5e.magic.*;
//import com.dnd5e.monsters.*;
//import com.dnd5e.worlds.*;
//import com.miscellaneous.util.*;

import view.NPCFrame;

public class Main {
	public static final boolean RELEASE;
	public static final boolean TESTING_MESSAGES;
	public static final int NPCS_TO_ROLL;

	private static NPCFrame frame;
	public static List<DnDCharacter> npcList;

	static {
		RELEASE = false;
		TESTING_MESSAGES = false;

		NPCS_TO_ROLL = 25;
		
		Armor.setupArmor(FileLoader.parseArmor("resources/armor.csv"));
		Monster.setupMonsters(FileLoader.parseMonsters("resources/monsters.csv"));
		Sorcery.setupSpells(FileLoader.parseSpells("resources/spells.csv"));
		Tool.setupTools(FileLoader.parseGear("resources/gear.csv"));
		Weapon.setupWeapons(FileLoader.parseWeapons("resources/weapons.csv"));
	}

	/*
	 * MAIN METHOD
	 */
	public static void main(String[] args) {
		// frame.addMouseListener(null);
		loadFiles();
		npcList = rollCharacters(NPCS_TO_ROLL);

		frame = new NPCFrame();
		frame.setVisible(true);
	}

	public static void loadFiles() {
//		Armor.setupArmor(FileLoader.parseArmor("resources/armor.csv"));
//		Monster.setupMonsters(FileLoader.parseMonsters("resources/monsters.csv"));
//		Sorcery.setupSpells(FileLoader.parseSpells("resources/spells.csv"));
//		Tool.setupTools(FileLoader.parseGear("resources/gear.csv"));
//		Weapon.setupWeapons(FileLoader.parseWeapons("resources/weapons.csv"));

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

	public static List<DnDCharacter> rollCharacters(int n) {
		List<DnDCharacter> list = new ArrayList<DnDCharacter>(n);
		for (int i = 0; i < n; ++i)
			list.add(DnDCharacter.random());

		return list;
	}
}
