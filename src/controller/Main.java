package controller;
//import java.util.ArrayList;

import java.util.List;

import com.dnd5e.magic.*;
import com.dnd5e.monsters.*;
import com.miscellaneous.util.*;
import com.dnd5e.characters.*;
import com.dnd5e.dungeons.*;
import com.dnd5e.equipment.*;
import com.dnd5e.factions.*;

import view.*;

public class Main {
	private static NPCFrame frame;
	public static List<DnDCharacter> npcList;

	private static DungeonFrame dungeonFrame;
	public static Dungeon dungeon;

	//
	private static Circles circles;

	static {

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
//		npcList = DnDCharacter.rollCharacters(Default.CHARACTERS_TO_ROLL);
//		circles = Circles.build(npcList);
//		frame = new NPCFrame();
//		frame.setVisible(true);
//
//		System.out.println(circles.toString());

		dungeon = Dungeon.build(Dice.roll(2, 4) + 1);
		dungeon.explore();

		dungeonFrame = DungeonFrame.build(dungeon);
		dungeonFrame.setVisible(true);

		dungeonFrame.revalidate();
	}
}
