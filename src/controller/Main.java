package controller;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import com.dnd5e.magic.*;
import com.dnd5e.monsters.*;
import com.miscellaneous.util.*;
import com.dnd5e.characters.*;
import com.dnd5e.dungeons.*;
import com.dnd5e.equipment.*;
import com.dnd5e.factions.*;

import view.*;

public class Main {
	private static List<DnDCharacter> npcList;
	private static Dungeon dungeon;

	//
	private static Circles circles;

	static {

		Armor.setupArmor(FileLoader.parseArmor("resources/armor.csv"));
		Monster.setupMonsters(FileLoader.parseMonsters("resources/monsters.csv"));
		Sorcery.setupSpells(FileLoader.parseSpells("resources/spells.csv"));
		Tool.setupTools(FileLoader.parseGear("resources/gear.csv"));
		Weapon.setupWeapons(FileLoader.parseWeapons("resources/weapons.csv"));

		//
		npcList = DnDCharacter.rollCharacters(Default.CHARACTERS_TO_ROLL);
		circles = Circles.build(npcList);
		dungeon = Dungeon.build(Dice.roll(2, 4) + 1);
	}

	/*
	 * MAIN METHOD
	 */
	public static void main(String[] args) {
		buildTabbedPane();
	}

	private static void buildTabbedPane() {
		JTabbedPane tabbedPane = new JTabbedPane();

		// add tabs
		tabbedPane.addTab("Characters", NPCTablePane.build(npcList));
		tabbedPane.addTab("Dungeons", DungeonPane.build(dungeon));

		//
		JFrame frame = new JFrame("World Serpent");
		frame.add(tabbedPane);

		//
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
