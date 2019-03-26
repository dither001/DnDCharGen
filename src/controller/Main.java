package controller;

import java.util.ArrayList;
import java.util.Iterator;

import com.dnd4e.definitions.*;
import com.dnd5e.character.classes.*;
import com.dnd5e.character.definitions.*;
import com.dnd5e.definitions.*;
import com.dnd5e.factions.*;
import com.dnd5e.gear.equipment.*;
import com.dnd5e.magic.*;
import com.dnd5e.worlds.*;
import com.miscellaneous.util.*;
import com.worldgen.planet.Grid;
import com.worldgen.terrain.Terrain;

public class Main {
	public static final boolean TESTING_MESSAGES_ON = false;

	/*
	 * MAIN METHOD
	 */
	public static void main(String[] args) {
		
		// FileLoader.parseSpells("spells.csv");

		// testSkewEvil();
		// testSkewHuman();
		// testRandomRogues();
		// testRandomCharacters(50);

		// testRandomCharacters(50);
		// testRandomChaoticCharacters(10);
		// testRandomCharactersOfAlignment(10, Alignment.CHAOTIC_EVIL);
		// testRandomCharactersOfClass(10, DnDClass.CLERIC);

		// testFactionOfAlignment(5, Alignment.CHAOTIC_EVIL);
		// testFactionOfGod(5, God.ASMODEUS);
		// testFactionOfRace(5, Race.TIEFLING);
		// testFactionOfBackground(5, Background.ACOLYTE);
		// testFactionOfJob(5, DnDClass.FIGHTER);
		// testFaction(5);

		// Armor.getArmorClone(Skill.PADDED_ARMOR);
		// Weapon.get(Skill.SLING);

		/*
		 * (force these objects to initialize)
		 */
		// FileLoader.parseMonsters("monsters.csv");

	}

	/*
	 * PLANET GENERATION
	 */
	public static void testWorldGen(int size) {
		// "maximum" normal size is probably about 8
		Grid grid;

		/*
		 * FIXME - numerous problems, untested nonsense
		 */
		try {
			grid = Grid.build(size);

			for (int i = 0; i < grid.tiles.length; ++i)
				System.out.println(grid.tiles[i].toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Terrain.build(size);
	}

	/*
	 * FACTION TESTING
	 */
	public static void testAddAll() {
		ArrayList<Creature> list = new ArrayList<Creature>();
		for (int i = 0; i < 5; ++i)
			list.add(DnDCharacter.random());

		Warband band = new Warband();
		band.addAll(list);

		System.out.println("Begin");
		for (Creature el : band.getMembers())
			System.out.println(el.toString());
	}

	public static void testFactionOfJob(int n, DnDClass job) {
		Warband band = new Warband();
		System.out.println("Before");
		for (int i = 0; i < n; ++i) {
			DnDCharacter toon = randomCharacterOfJob(job);
			// System.out.println("wants to join: " + toon.toString());

			band.add(toon);

			for (Creature el : band.getMembers())
				System.out.println(el.toString());

			System.out.println();
		}

		System.out.println("Finished");
	}

	public static void testFactionOfBackground(int n, Background bg) {
		Warband band = new Warband();
		System.out.println("Before");
		for (int i = 0; i < n; ++i) {
			DnDCharacter toon = randomCharacterOfBackground(bg);
			// System.out.println("wants to join: " + toon.toString());

			band.add(toon);

			for (Creature el : band.getMembers())
				System.out.println(el.toString());

			System.out.println();
		}

		System.out.println("Finished");
	}

	public static void testFactionOfRace(int n, Race race) {
		Warband band = new Warband();
		System.out.println("Before");
		for (int i = 0; i < n; ++i) {
			DnDCharacter toon = randomCharacterOfRace(race);
			// System.out.println("wants to join: " + toon.toString());

			band.add(toon);

			for (Creature el : band.getMembers())
				System.out.println(el.toString());

			System.out.println();
		}

		System.out.println("Finished");
	}

	public static void testFactionOfGod(int n, God god) {
		Warband band = new Warband();
		System.out.println("Before");
		for (int i = 0; i < n; ++i) {
			DnDCharacter toon = randomCharacterOfGod(god);
			// System.out.println("wants to join: " + toon.toString());

			band.add(toon);

			for (Creature el : band.getMembers())
				System.out.println(el.toString());

			System.out.println();
		}

		System.out.println("Finished");
	}

	public static void testFactionOfAlignment(int n, Alignment ali) {
		Warband band = new Warband();
		System.out.println("Before");
		for (int i = 0; i < n; ++i) {
			DnDCharacter toon = randomCharacterOfAlignment(ali);
			// System.out.println("wants to join: " + toon.toString());

			band.add(toon);

			for (Creature el : band.getMembers())
				System.out.println(el.toString());

			System.out.println();
		}

		System.out.println("Finished");
	}

	public static void testFaction(int n) {
		Warband band = new Warband();
		for (int i = 0; i < n; ++i)
			band.add(DnDCharacter.random());

		for (Creature el : band.getMembers())
			System.out.println(el.toString());

		System.out.println(band.foundationToString());
	}

	public static DnDCharacter randomCharacterOfJob(DnDClass job) {
		DnDCharacter toon = null;
		do {
			toon = DnDCharacter.random();
		} while (toon.getJob().equals(job) != true);

		return toon;
	}

	public static DnDCharacter randomCharacterOfBackground(Background bg) {
		DnDCharacter toon = null;
		do {
			toon = DnDCharacter.random();
		} while (toon.getBackground().equals(bg) != true);

		return toon;
	}

	public static DnDCharacter randomCharacterOfRace(Race race) {
		DnDCharacter toon = null;
		do {
			toon = DnDCharacter.random();
		} while (toon.getRace().equals(race) != true);

		return toon;
	}

	public static DnDCharacter randomCharacterOfGod(God god) {
		DnDCharacter toon = null;
		do {
			toon = DnDCharacter.random();
		} while (toon.getGod().equals(god) != true);

		return toon;
	}

	public static DnDCharacter randomCharacterOfAlignment(Alignment ali) {
		DnDCharacter toon = null;
		do {
			toon = DnDCharacter.random();
		} while (toon.getAlignment().equals(ali) != true);

		return toon;
	}

}
