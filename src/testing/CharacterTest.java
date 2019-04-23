package testing;

import java.util.Iterator;

import org.junit.Test;

import com.dnd1e.encounters.*;
import com.dnd5e.characters.*;
import com.dnd5e.definitions.rules.*;
import com.dnd5e.equipment.*;
import com.dnd5e.magic.*;
import com.dnd5e.monsters.*;
import com.dnd5e.worlds.*;
import com.miscellaneous.util.*;

public class CharacterTest {
	//
	private static final int NUMBER_TO_GENERATE = 10000;

	//
	private static final Alignment ALIGNMENT = Alignment.CHAOTIC_EVIL;

	private static final Background BACKGROUND = Background.URCHIN;
	private static final DnDClass CLAZZ = DnDClass.WIZARD;
	private static final Subclass SUBCLASS = Subclass.ARCANE_TRICKSTER;
	private static final God GOD = God.ASMODEUS;
	private static final Race RACE = Race.HALF_ORC;

	private static final Cornerstone CORNERSTONE = Cornerstone.DEMON;

	//
	private static final School[] SCHOOLS = { School.ABJURATION, School.EVOCATION };

	private static void loadFiles() {
		Armor.setupArmor(FileLoader.parseArmor("resources/armor.csv"));
		Monster.setupMonsters(FileLoader.parseMonsters("resources/monsters.csv"));
		Sorcery.setupSpells(FileLoader.parseSpells("resources/spells.csv"));
		Tool.setupTools(FileLoader.parseGear("resources/gear.csv"));
		Weapon.setupWeapons(FileLoader.parseWeapons("resources/weapons.csv"));
	}

	/*
	 * ALIGNMENT TESTING
	 */
	@Test
	public void skewEvil() {
		int[] array = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

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
		printAlignmentGrid(NUMBER_TO_GENERATE, array);
		System.out.printf("\n");
		printAlignmentArray(NUMBER_TO_GENERATE, array);
	}

	private void printAlignmentArray(int num, int[] array) {
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

	private void printAlignmentGrid(int num, int[] array) {
		int n = 0;
		String[] s = new String[9];

		n = array[4]; // LG
		s[0] = String.format("%6d (%4.1f %%)", n, 1.0 * n / num * 100);
		n = array[5]; // LN
		s[1] = String.format("%6d (%4.1f %%)", n, 1.0 * n / num * 100);
		n = array[3]; // LE
		s[2] = String.format("%6d (%4.1f %%)", n, 1.0 * n / num * 100);
		n = array[7]; // NG
		s[3] = String.format("%6d (%4.1f %%)", n, 1.0 * n / num * 100);
		n = array[8]; // TN
		s[4] = String.format("%6d (%4.1f %%)", n, 1.0 * n / num * 100);
		n = array[6]; // NE
		s[5] = String.format("%6d (%4.1f %%)", n, 1.0 * n / num * 100);
		n = array[1]; // CG
		s[6] = String.format("%6d (%4.1f %%)", n, 1.0 * n / num * 100);
		n = array[2]; // CN
		s[7] = String.format("%6d (%4.1f %%)", n, 1.0 * n / num * 100);
		n = array[0]; // CE
		s[8] = String.format("%6d (%4.1f %%)", n, 1.0 * n / num * 100);

		System.out.printf("%s | %s | %s%n", s[0], s[1], s[2]);
		System.out.printf("%s | %s | %s%n", s[3], s[4], s[5]);
		System.out.printf("%s | %s | %s%n", s[6], s[7], s[8]);
		n = array[9]; // LG
		System.out.println(String.format("            Unaligned: %6d (%4.1f %%)", n, 1.0 * n / num * 100));

	}

	/*
	 * CLASS TESTING
	 */
	@Test
	public void oneMillionCharacters() {
		loadFiles();

		DnDCharacter toon = null;
		for (int i = 1; i <= 1000000; ++i) {
			toon = DnDCharacter.random();

			if (i % 100000 == 0) {
				System.out.println(i);
				toon.getName();
			}
		}
	}

	@Test
	public void testRandomCharacters() {
		randomCharacter(NUMBER_TO_GENERATE);
	}

	@Test
	public void testCharacterAlignment() {
		characterOfAlignment(NUMBER_TO_GENERATE, ALIGNMENT);
	}

	@Test
	public void testCharacterBackground() {
		characterOfBackground(NUMBER_TO_GENERATE, BACKGROUND);
	}

	@Test
	public void testCharacterClass() {
		characterOfClass(NUMBER_TO_GENERATE, CLAZZ);
	}

	@Test
	public void testCharacterSubclass() {
		characterOfSubclass(NUMBER_TO_GENERATE, SUBCLASS);
	}

	@Test
	public void testCharacterGod() {
		characterOfGod(NUMBER_TO_GENERATE, GOD);
	}

	@Test
	public void testCharacterRace() {
		characterOfRace(NUMBER_TO_GENERATE, RACE);
	}

	@Test
	public void testClassAdvancement() {
		DnDCharacter toon = null;
		do {
			toon = DnDCharacter.random();
		} while (toon.getJob().equals(CLAZZ) != true);

		System.out.println(toon.toStringVerbose());
		System.out.println();

		for (int i = 1; i < 20; ++i) {
			toon.advance();
			System.out.println(toon.toStringVerbose());
			System.out.println();
		}

	}

	@Test
	public void testSubclassAdvancement() {
		DnDCharacter toon = null;
		do {
			toon = DnDCharacter.random();
		} while (toon.getSubclass().equals(SUBCLASS) != true);

		System.out.println(toon.toStringVerbose());
		System.out.println();

		for (int i = 1; i < 20; ++i) {
			toon.advance();
			System.out.println(toon.toStringVerbose());
			System.out.println();
		}

	}

	@Test
	public void testSkewClass() {
		loadFiles();

		int[] array = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		for (int i = 0; i < NUMBER_TO_GENERATE; ++i) {
			++array[DnDCharacter.random().getJob().indexOf()];
		}

		int n = 0;
		String s = null;
		for (int i = 0; i < array.length; ++i) {
			n = array[i];
			s = String.format("(%4.1f %%)", 1.0 * n / NUMBER_TO_GENERATE * 100);
			System.out.printf("%6d %-8s %-16s\n", n, s, DnDClass.get(i));
		}

		System.out.printf("\n");
		printClassArray(NUMBER_TO_GENERATE, array);
	}

	/*
	 * 
	 */
	private void characterOfAlignment(int n, Alignment ali) {
		loadFiles();

		DnDCharacter toon = null;
		for (int i = 0; i < n; ++i) {
			do {
				toon = DnDCharacter.random();
			} while (toon.getAlignment().equals(ali) != true);
			System.out.println(toon.toStringVerbose());
			System.out.println();
		}
	}

	private void characterOfBackground(int n, Background job) {
		loadFiles();

		DnDCharacter toon = null;
		for (int i = 0; i < n; ++i) {
			do {
				toon = DnDCharacter.random();
			} while (toon.getBackground().equals(job) != true);
			System.out.println(toon.toStringVerbose());
			System.out.println();
		}
	}

	private void characterOfClass(int n, DnDClass job) {
		loadFiles();

		DnDCharacter toon = null;
		for (int i = 0; i < n; ++i) {
			do {
				toon = DnDCharacter.random();
			} while (toon.getJob().equals(job) != true);
			System.out.println(toon.toStringVerbose());
			System.out.println();
		}
	}

	private void characterOfSubclass(int n, Subclass job) {
		loadFiles();

		DnDCharacter toon = null;
		for (int i = 0; i < n; ++i) {
			do {
				toon = DnDCharacter.random();
			} while (toon.getSubclass().equals(job) != true);
			System.out.println(toon.toStringVerbose());
			System.out.println();
		}
	}

	private void characterOfGod(int n, God god) {
		loadFiles();

		DnDCharacter toon = null;
		for (int i = 0; i < n; ++i) {
			do {
				toon = DnDCharacter.random();
			} while (toon.getGod().equals(god) != true);
			System.out.println(toon.toStringVerbose());
			System.out.println();
		}
	}

	private void characterOfRace(int n, Race race) {
		loadFiles();

		DnDCharacter toon = null;
		for (int i = 0; i < n; ++i) {
			do {
				toon = DnDCharacter.random();
			} while (toon.getRace().equals(race) != true);
			System.out.println(toon.toStringVerbose());
			System.out.println();
		}
	}

	private void randomCharacter(int n) {
		loadFiles();

		for (int i = 0; i < n; ++i) {
			System.out.println(DnDCharacter.random().toStringVerbose());
			System.out.println();
		}
	}

	private void printClassArray(int num, int[] array) {
		int n = 0;
		String s = null;

		// BARBARIAN, BARD, CLERIC
		// DRUID, FIGHTER, MONK
		// PALADIN, RANGER, ROGUE
		// SORCERER, WARLOCK, WIZARD

		n = array[1] + array[9] + array[10];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-16s %s\n", "% Charisma", s);

		n = array[2] + array[3] + array[5];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-16s %s\n", "% Wisdom", s);

		// n = array[11];
		// s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		// System.out.printf("%-16s %s\n", "% Intelligence", s);

		n = array[7];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-16s %s\n", "% Dexterity", s);

		n = array[0] + array[4] + array[6];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-16s %s\n", "% Strength", s);

		System.out.printf("\n");

		n = array[8];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-16s %s\n", "% Rogues", s);

		n = array[4];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-16s %s\n", "% Fighters", s);

		n = array[3] + array[11];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-16s %s\n", "% Druid+Wizard", s);

		n = array[2];
		s = String.format("(%4.1f %%)", 1.0 * n / num * 100);
		System.out.printf("%-16s %s\n", "% Clerics", s);
	}

	/*
	 * MAGIC TESTING
	 */
	@Test
	public void testSchoolFilter() {
		loadFiles();

		for (Iterator<Spell> it = Sorcery.getSpellsOfSchool(SCHOOLS).iterator(); it.hasNext();)
			System.out.println(it.next().toString());
	}

	/*
	 * MONSTER TESTING
	 */
	@Test
	public void getCornerstone() {
		loadFiles();

		for (Monster el : Monster.getCornerstone(CORNERSTONE))
			System.out.println(el.toStringVerbose());

	}

	/*
	 * RACE TESTING
	 */
	@Test
	public void testSkewHuman() {
		int[] array = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

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

	private void printRaceArray(int num, int[] array) {
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
	 * DUNGEON TESTING
	 */
	@Test
	public void monsterLevel() {
		int numberToRoll = 10000;

		int floor = 1;
		for (int j = 0; j < 17; ++j) {
			int[] monsterLevels = Misc.initializeArray(10, 0);
			for (int i = 1; i < numberToRoll; ++i) {
				++monsterLevels[EncounterMatrix.monsterLevel(floor) - 1];
			}

			System.out.println("Floor number: " + floor);
			for (int i = 0; i < monsterLevels.length; ++i) {
				double percent = 100.0 * monsterLevels[i] / numberToRoll;
				System.out.printf("%2d: %6d (%6.2f)%n", 1 + i, monsterLevels[i], +percent);
			}

			System.out.println();
			++floor;
		}
	}
}
