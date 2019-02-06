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
	public static DnDClass get(int index) {
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

		int strength, dexterity, intelligence, wisdom, charisma;
		strength = actor.getStrength();
		dexterity = actor.getDexterity();
		intelligence = actor.getIntelligence();
		wisdom = actor.getWisdom();
		charisma = actor.getCharisma();

		int dice = Dice.roll(6);
		if (charisma > 11 && dice == 1 && ali.nonLawful())
			job = BARD;
		else if (charisma > 13 && (dice == 2 || dice == 3) && ali.nonLawful())
			job = SORCERER;
		else if (charisma > 13 && (dice == 4 || dice == 5) && ali.nonGood())
			job = WARLOCK;
		else if (wisdom > 13 && (dice == 1 || dice == 2))
			job = CLERIC;
		else if (wisdom > 13 && (dice == 3 || dice == 4) && ali.isNeutral())
			job = DRUID;
		else if (dexterity > 11 && wisdom > 11 && dice < 6 && ali.nonChaotic())
			job = MONK;
		else if (intelligence > 13 && dice < 4 && ali.nonLawful())
			job = WIZARD;
		else if (dexterity > 11 && dice < 4 && ali.nonChaotic())
			job = RANGER;
		else if (strength > 11 && ali.isGood())
			job = PALADIN;
		else if (strength > 9 && ali.isChaotic())
			job = BARBARIAN;
		else if (strength > 5 && dice < 5  && ali.nonChaotic())
			job = FIGHTER;
		else
			job = ROGUE;

		return job;
	}
}
