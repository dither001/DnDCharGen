package com.dnd5e.character.classes;

import com.dnd5e.character.definitions.*;
import com.dnd5e.definitions.*;
import com.miscellaneous.util.*;

public enum DnDClass implements Opposite, Similar {
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

	public boolean isController() {
		return this.equals(DRUID) || this.equals(WIZARD);
	}

	public boolean isDefender() {
		return this.equals(BARBARIAN) || this.equals(FIGHTER) || this.equals(PALADIN);
	}

	public boolean isLeader() {
		return this.equals(BARD) || this.equals(CLERIC);
	}

	public boolean isStriker() {
		return this.equals(MONK) || this.equals(RANGER) || this.equals(ROGUE) || this.equals(SORCERER)
				|| this.equals(WARLOCK);
	}

	@Override
	public int similarTo(Object o) {
		int similar = -1;

		if (o.getClass().equals(DnDClass.class)) {
			DnDClass job = (DnDClass) o;

			if (job.isStriker() && this.isStriker())
				similar = 1;
			else if (job.isLeader() && this.isLeader())
				similar = 1;
			else if (job.isController() && this.isController())
				similar = 1;
			else if (job.isDefender() && this.isDefender())
				similar = 1;

			// if (job.isStriker() && (this.isLeader() || this.isDefender()))
			// similar = 1;
			// else if (job.isLeader() && (this.isController() || this.isStriker()))
			// similar = 1;
			// else if (job.isController() && (this.isDefender() || this.isStriker()))
			// similar = 1;
			// else if (job.isDefender() && (this.isStriker() || this.isController()))
			// similar = 1;

			if (job.equals(this))
				similar = 0;
		}

		return similar;
	}

	@Override
	public boolean opposedTo(Object o) {
		boolean opposed = false;

		if (o.getClass().equals(DnDClass.class)) {
			DnDClass job = (DnDClass) o;

			if (job.isStriker() && this.isController())
				opposed = true;
			else if (job.isLeader() && this.isDefender())
				opposed = true;
			else if (job.isController() && this.isStriker())
				opposed = true;
			else if (job.isDefender() && this.isLeader())
				opposed = true;

			if (job.equals(this))
				opposed = false;
		}

		return opposed;
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

	public static DnDClass parse(String s) throws ParserException {
		for (DnDClass el : CLASSES) {
			if (el.toString().compareToIgnoreCase(s) == 0)
				return el;
		}

		throw new ParserException();
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
		else if (strength > 5 && dice < 5 && ali.nonChaotic())
			job = FIGHTER;
		else
			job = ROGUE;

		return job;
	}

}
