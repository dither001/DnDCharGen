package com.dnd5e.characters;

import com.dnd5e.definitions.*;
import com.dnd5e.exceptions.*;
import com.dnd5e.util.*;

public enum DnDClass {
	BARBARIAN, BARD, CLERIC, DRUID, FIGHTER, MONK, PALADIN, RANGER, ROGUE, SORCERER, WARLOCK, WIZARD;

	/*
	 * STATIC FIELDS
	 */
	private static final DnDClass[] CLASSES = { BARBARIAN, BARD, CLERIC, DRUID, FIGHTER, MONK, PALADIN, RANGER, ROGUE,
			SORCERER, WARLOCK, WIZARD };

	/*
	 * INSTANCE METHODS
	 */
	public int indexOf() {
		return Misc.indexOfEnum(this.toString(), CLASSES);
	}

	/*
	 * STATIC METHODS
	 */
	public DnDClass get(int index) {
		return CLASSES[index];
	}

	public static int getHitDie(DnDClass job) {
		int hitDie = 8;

		switch (job) {
		case BARBARIAN:
			hitDie = 12;
			break;
		case BARD:
		case CLERIC:
		case DRUID:
		case MONK:
		case ROGUE:
		case WARLOCK:
			hitDie = 8;
			break;
		case FIGHTER:
		case PALADIN:
		case RANGER:
			hitDie = 10;
			break;
		case SORCERER:
		case WIZARD:
			hitDie = 6;
			break;
		}

		return hitDie;
	}

	public static int getNumberOfSkills(DnDClass job) {
		int jobSkills = 2;

		switch (job) {
		case BARBARIAN:
		case CLERIC:
		case DRUID:
		case FIGHTER:
		case MONK:
		case PALADIN:
		case SORCERER:
		case WARLOCK:
		case WIZARD:
			jobSkills = 2;
			break;
		case BARD:
		case RANGER:
			jobSkills = 3;
			break;
		case ROGUE:
			jobSkills = 4;
			break;
		}

		return jobSkills;
	}

	public static DnDClass parse(String s) throws InvalidDnDClassException {
		for (DnDClass el : CLASSES) {
			if (el.toString().compareToIgnoreCase(s) == 0)
				return el;
		}

		throw new InvalidDnDClassException();
	}

	public static DnDClass random() {
		return Misc.randomFromArray(CLASSES);
	}

	public static DnDClass selectClass(DnDCharacter actor) {
		DnDClass job = null;
		Alignment ali = actor.getAlignment();

		int dexterity, intelligence, wisdom, charisma;
		dexterity = actor.getDexterity();
		intelligence = actor.getIntelligence();
		wisdom = actor.getWisdom();
		charisma = actor.getCharisma();

		int dice = Dice.roll(4);
		if (charisma > 11 && dice == 1)
			job = BARD;
		else if (charisma > 11 && dice == 2)
			job = SORCERER;
		else if (charisma > 11 && dice == 3)
			job = WARLOCK;
		else if (wisdom > 11 && dice == 1)
			job = CLERIC;
		else if (wisdom > 11 && dice == 2)
			job = DRUID;
		else if (wisdom > 11 && dice == 3)
			job = MONK;
		else if (intelligence > 11 && dice < 3)
			job = WIZARD;
		else if (dexterity > 11 && dice < 3)
			job = RANGER;
		else if (ali.isGood())
			job = PALADIN;
		else if (ali.isChaotic())
			job = BARBARIAN;
		else if (ali.isLawful() || dice < 4)
			job = FIGHTER;
		else
			job = ROGUE;

		return job;
	}
}
