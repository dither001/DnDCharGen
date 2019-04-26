package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import com.dnd5e.characters.*;
import com.dnd5e.dungeons.*;
import com.dnd5e.equipment.*;
import com.dnd5e.factions.*;
import com.dnd5e.magic.*;
import com.dnd5e.monsters.*;
import com.dnd5e.worlds.*;
import com.miscellaneous.util.*;

import view.*;

public abstract class Controller {

	/*
	 * STATIC FIELDS
	 */
	private static JTabbedPane tabbedPane;

	// tabs
	private static NPCTablePane npcTab;
	private static CirclesPane circlesTab;

	private static PlayerPane playerTab;
	private static DungeonPane dungeonTab;
	private static FactionPane factionTab;

	//
	private static List<DnDCharacter> players;
	private static List<DnDCharacter> npcList;
	private static Circles circles;

	//
	private static List<Warband> factions;
	private static Dungeon dungeon;

	static {

		Armor.setupArmor(FileLoader.parseArmor("resources/armor.csv"));
		Monster.setupMonsters(FileLoader.parseMonsters("resources/monsters.csv"));
		Sorcery.setupSpells(FileLoader.parseSpells("resources/spells.csv"));
		Tool.setupTools(FileLoader.parseGear("resources/gear.csv"));
		Weapon.setupWeapons(FileLoader.parseWeapons("resources/weapons.csv"));

		//
		players = new ArrayList<DnDCharacter>();
		npcList = Controller.rollCharacters();
		// circles = Circles.build(npcList);
		dungeon = Dungeon.build(Dice.roll(2, 4) + 1);
		factions = new ArrayList<Warband>();
	}

	/*
	 * STATIC METHODS
	 */
	public static void addPlayers(List<DnDCharacter> list) {
		for (DnDCharacter el : list) {
			if (players.contains(el) != true)
				players.add(el);
		}
	}

	public static List<DnDCharacter> getPlayers() {
		return players;
	}

	public static void setPlayers(List<DnDCharacter> players) {
		Controller.players = players;
	}

	public static List<DnDCharacter> getNpcList() {
		return npcList;
	}

	public static void setNpcList(List<DnDCharacter> npcList) {
		Controller.npcList = npcList;
	}

	public static Circles getCircles() {
		return circles;
	}

	public static void setCircles(Circles circles) {
		Controller.circles = circles;
	}

	public static List<Warband> getFactions() {
		return factions;
	}

	public static void setFactions(List<Warband> factions) {
		Controller.factions = factions;
	}

	public static void buildTabbedPane() {
		tabbedPane = new JTabbedPane();

		// add tabs
		playerTab = (PlayerPane) tabbedPane.add("Players", PlayerPane.build(players));
		npcTab = (NPCTablePane) tabbedPane.add("Characters", NPCTablePane.build(npcList));
		// circlesTab = (CirclesPane) tabbedPane.add("Circles",
		// CirclesPane.build(circles));
		factionTab = (FactionPane) tabbedPane.add("Factions", FactionPane.build());
		dungeonTab = (DungeonPane) tabbedPane.add("Dungeons", DungeonPane.build(dungeon));

		//
		JFrame frame = new JFrame("World Serpent");
		frame.add(tabbedPane);

		//
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static List<DnDCharacter> rollCharacters() {
		int n = Default.CHARACTERS_TO_ROLL;
		List<DnDCharacter> list = new ArrayList<DnDCharacter>(n);
		for (int i = 0; i < n; ++i)
			list.add(DnDCharacter.random());

		return list;
	}

	public static void clearCharacters() {
		// TODO

	}

	public static void generateFactions() {
		if (players.size() > 0 && factions.size() < 1) {
			List<DnDCharacter> l1 = new ArrayList<DnDCharacter>(npcList);
			npcList.removeAll(players);
			circles = Circles.build(l1);

			EnumSet<Background> bgs = EnumSet.noneOf(Background.class);
			EnumSet<Subclass> sub = EnumSet.noneOf(Subclass.class);
			EnumSet<Race> race = EnumSet.noneOf(Race.class);
			EnumSet<God> god = EnumSet.noneOf(God.class);

			for (DnDCharacter el : players) {
				bgs.add(el.getBackground());
				sub.add(el.getSubclass());
				race.add(el.getRace());
				god.add(el.getGod());
			}

			int total = bgs.size() + sub.size() + race.size() + god.size();
			factions = new ArrayList<Warband>(total);
			int dice;

			// BACKGROUND
			for (Background el : bgs) {
				List<Actor> list = new ArrayList<Actor>(circles.getBackgroundMap().get(el));
				Collections.shuffle(list);

				dice = Dice.roll(4) + 3;
				if (list.size() < dice)
					dice = list.size();
				list = list.subList(0, dice);

				Warband warband = new Warband();
				warband.addAll(list);
				warband.setPurpose(el.toString());
				warband.setType(FactionType.getType(el));
				warband.setName(warband.getLeaderName() + "'s " + warband.getPurpose() + " " + warband.getType());
				factions.add(warband);
			}

			// SUBCLASS
			for (Subclass el : sub) {
				List<Actor> list = new ArrayList<Actor>(circles.getSubclassMap().get(el));
				Collections.shuffle(list);

				dice = Dice.roll(4) + 3;
				if (list.size() < dice)
					dice = list.size();
				list = list.subList(0, dice);

				Warband warband = new Warband();
				warband.addAll(list);
				warband.setPurpose(el.toString());
				warband.setType(FactionType.random());
				warband.setName(warband.getLeaderName() + "'s " + warband.getPurpose() + " " + warband.getType());
				factions.add(warband);
			}

			// RACE
			for (Race el : race) {
				List<Actor> list = new ArrayList<Actor>(circles.getRaceMap().get(el));
				Collections.shuffle(list);

				dice = Dice.roll(4) + 3;
				if (list.size() < dice)
					dice = list.size();
				list = list.subList(0, dice);

				Warband warband = new Warband();
				warband.addAll(list);
				warband.setPurpose(el.toString());
				warband.setType(FactionType.random());
				warband.setName(warband.getLeaderName() + "'s " + warband.getPurpose() + " " + warband.getType());
				factions.add(warband);
			}

			// GOD
			for (God el : god) {
				List<Actor> list = new ArrayList<Actor>(circles.getGodMap().get(el));
				Collections.shuffle(list);

				dice = Dice.roll(4) + 3;
				if (list.size() < dice)
					dice = list.size();
				list = list.subList(0, dice);

				Warband warband = new Warband();
				warband.addAll(list);
				warband.setPurpose(el.toString());
				warband.setType(FactionType.random());
				warband.setName(warband.getLeaderName() + "'s " + warband.getPurpose() + " " + warband.getType());
				factions.add(warband);
			}

			update();
		}
	}

	public static void update() {
		playerTab.setContents(players);
		playerTab.updateContents();

		factionTab.setContents(factions);
		factionTab.updateContents();

		tabbedPane.revalidate();
		tabbedPane.repaint();
	}

}
