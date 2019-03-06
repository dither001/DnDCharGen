package controller;

import java.util.ArrayList;

import com.dnd4e.definitions.PowerSource;
import com.dnd5e.characters.*;
import com.dnd5e.definitions.*;
import com.dnd5e.factions.*;
import com.dnd5e.gear.equipment.Armor;
import com.dnd5e.gear.equipment.Weapon;
import com.dnd5e.worlds.*;
import com.miscellaneous.util.FileLoader;
import com.miscellaneous.util.ParserException;
import com.worldgen.planet.Grid;

public class Main {

	/*
	 * MAIN METHOD
	 */
	public static void main(String[] args) {
		/*
		 * WORLD GEN TESTING
		 */
		testWorldGen(0);

		// testSkewEvil();
		// testSkewHuman();
		// testRandomRogues();
		// testRandomCharacters(50);

		// testRandomChaoticCharacters(10);
		// testRandomCharactersOfAlignment(10, Alignment.CHAOTIC_EVIL);
		// testRandomCharactersOfClass(10, DnDClass.BARBARIAN);

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
		try {
			grid = Grid.build(size);

			for (int i = 0; i < grid.tiles.length; ++i)
				System.out.println(grid.tiles[i].toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	/*
	 * CHARACTER TESTING
	 */
	public static void testRandomCharactersOfAlignment(int n, Alignment ali) {
		DnDCharacter toon = null;
		for (int i = 0; i < n; ++i) {
			do {
				toon = DnDCharacter.random();
			} while (toon.getAlignment().equals(ali) != true);
			System.out.println(toon.toStringVerbose());
			System.out.println();
		}
	}

	public static void testRandomChaoticCharacters(int n) {
		DnDCharacter toon = null;
		for (int i = 0; i < n; ++i) {
			do {
				toon = DnDCharacter.random();
			} while (toon.getAlignment().nonChaotic());
			System.out.println(toon.toStringVerbose());
			System.out.println();
		}
	}

	public static void testRandomCharactersOfClass(int n, DnDClass job) {
		DnDCharacter toon = null;
		for (int i = 0; i < n; ++i) {
			do {
				toon = DnDCharacter.random();
			} while (toon.getJob().equals(job) != true);
			System.out.println(toon.toStringVerbose());
			System.out.println();
		}
	}

	public static void testRandomCharacters(int n) {
		for (int i = 0; i < n; ++i) {
			System.out.println(DnDCharacter.random().toStringVerbose());
			System.out.println();
		}
	}

	public static void testRandomRogues() {
		int[] array = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int NUMBER_TO_GENERATE = 10000;

		int[] ali = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int num_ali = 0;
		int male = 0;
		int female = 0;

		for (int i = 0; i < NUMBER_TO_GENERATE; ++i) {
			DnDCharacter c = DnDCharacter.random();
			++array[c.getJob().indexOf()];

			if (c.isFemale())
				++female;
			else
				++male;

			if (c.getJob().equals(DnDClass.ROGUE)) {
				++num_ali;
				++ali[c.getAlignment().indexOf()];
			}
		}

		int n = 0;
		String s = null;
		for (int i = 0; i < array.length; ++i) {
			n = array[i];
			s = String.format("(%4.1f %%)", 1.0 * n / NUMBER_TO_GENERATE * 100);
			System.out.printf("%6d %-8s %-16s\n", n, s, DnDClass.get(i));
		}

		System.out.printf("\nFemale: %d", female);
		System.out.printf("\nMale: %d", male);
		System.out.printf("\n\n");
		printClassArray(NUMBER_TO_GENERATE, array);

		// rogue alignments
		System.out.printf("\n");
		for (int i = 0; i < ali.length; ++i) {
			n = ali[i];
			s = String.format("(%4.1f %%)", 1.0 * n / num_ali * 100);
			System.out.printf("%6d %-8s %-16s\n", n, s, Alignment.get(i));
		}

		System.out.printf("\n");
		printAlignmentArray(num_ali, ali);
	}

	public static void printClassArray(int num, int[] array) {
		int n = 0;
		String s = null;

		// BARBARIAN, BARD, CLERIC
		// DRUID, FIGHTER, MONK
		// PALADIN, RANGER, ROGUE
		// SORCERER, WARLOCK, WIZARD

		n = array[1] + array[9] + array[10];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-10s %s\n", "% Charisma", s);

		n = array[2] + array[3] + array[5];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-10s %s\n", "% Wisdom", s);

		// n = array[11];
		// s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		// System.out.printf("%-10s %s\n", "% Intelligence", s);

		n = array[7];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-10s %s\n", "% Dexterity", s);

		n = array[0] + array[4] + array[6];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-10s %s\n", "% Strength", s);

		System.out.printf("\n");

		n = array[8];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-10s %s\n", "% Rogues", s);

		n = array[4];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-10s %s\n", "% Fighters", s);

		n = array[3] + array[11];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-10s %s\n", "% Druid+Wizard", s);

		n = array[2];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-10s %s\n", "% Clerics", s);
	}

	/*
	 * RACE TESTING
	 */
	public static void testSkewHuman() {
		int[] array = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int NUMBER_TO_GENERATE = 10000;

		for (int i = 0; i < NUMBER_TO_GENERATE; ++i) {
			++array[Race.randomSkewHuman().indexOf()];
		}

		int n = 0;
		String s = null;
		for (int i = 0; i < array.length; ++i) {
			n = array[i];
			s = String.format("(%4.1f %%)", 1.0 * n / NUMBER_TO_GENERATE * 100);
			System.out.printf("%6d %-8s %-16s\n", n, s, Race.get(i));
		}

		System.out.printf("\n");
		printRaceArray(NUMBER_TO_GENERATE, array);
	}

	public static void printRaceArray(int num, int[] array) {
		int n = 0;
		String s = null;

		n = array[4] + array[5] + array[6] + array[7] + array[8];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-10s %s\n", "% Chromatic", s);

		n = array[9] + array[10] + array[11] + array[12] + array[13];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-10s %s\n", "% Metallic", s);

		n = array[14] + array[15];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-10s %s\n", "% Dwarf", s);

		n = array[16] + array[17] + array[18];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-10s %s\n", "% Elf", s);

		n = array[19] + array[20];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-10s %s\n", "% Gnome", s);

		n = array[0];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-10s %s\n", "% Half-elf", s);

		n = array[1];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-10s %s\n", "% Half-orc", s);

		n = array[21] + array[22];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-10s %s\n", "% Halfling", s);

		n = array[2];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-10s %s\n", "% Human", s);

		n = array[3];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-10s %s\n", "% Tiefling", s);
	}

	/*
	 * ALIGNMENT TESTING
	 */
	public static void testSkewEvil() {
		int[] array = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int NUMBER_TO_GENERATE = 10000;

		for (int i = 0; i < NUMBER_TO_GENERATE; ++i) {
			++array[Alignment.randomSkewEvil().indexOf()];
		}

		int n = 0;
		String s = null;
		for (int i = 0; i < array.length; ++i) {
			n = array[i];
			s = String.format("(%4.1f %%)", 1.0 * n / NUMBER_TO_GENERATE * 100);
			System.out.printf("%6d %-8s %-16s\n", n, s, Alignment.get(i));
		}

		System.out.printf("\n");
		printAlignmentArray(NUMBER_TO_GENERATE, array);
	}

	public static void printAlignmentArray(int num, int[] array) {
		int n = 0;
		String s = null;

		n = array[0] + array[1] + array[2];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-10s %s\n", "% Chaotic", s);

		n = array[0] + array[3] + array[6];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-10s %s\n", "% Evil", s);

		n = array[1] + array[4] + array[7];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-10s %s\n", "% Good", s);

		n = array[3] + array[4] + array[5];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-10s %s\n", "% Lawful", s);

		n = array[2] + array[5] + array[6] + array[7] + array[8];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-10s %s\n", "% Neutral", s);

	}
}
