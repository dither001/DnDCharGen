package testing;

import org.junit.Test;

import com.dnd5e.character.classes.*;
import com.dnd5e.character.definitions.*;
import com.dnd5e.definitions.*;

public class CharacterTest {
	//
	private static final int NUMBER_TO_GENERATE = 10;
	//
	private static final Alignment ALIGNMENT = Alignment.CHAOTIC_EVIL;
	private static final DnDClass CHARACTER_CLASS = DnDClass.BARBARIAN;

	/*
	 * ALIGNMENT TESTING
	 */
	@Test
	public void testSkewEvil() {
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

	/*
	 * CLASS TESTING
	 */
	@Test
	public void testRandomCharacters() {
		randomCharacter(NUMBER_TO_GENERATE);
	}

	private void characterOfAlignment(int n, Alignment ali) {
		DnDCharacter toon = null;
		for (int i = 0; i < n; ++i) {
			do {
				toon = DnDCharacter.random();
			} while (toon.getAlignment().equals(ali) != true);
			System.out.println(toon.toStringVerbose());
			System.out.println();
		}
	}

	private void characterOfClass(int n, DnDClass job) {
		DnDCharacter toon = null;
		for (int i = 0; i < n; ++i) {
			do {
				toon = DnDCharacter.random();
			} while (toon.getJob().equals(job) != true);
			System.out.println(toon.toStringVerbose());
			System.out.println();
		}
	}

	private void randomCharacter(int n) {
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
}
