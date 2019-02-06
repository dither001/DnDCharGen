package com.dnd5e.characters;

import com.dnd5e.definitions.*;
import com.dnd5e.util.*;

public class DnDCharacter extends Actor implements Adventurer {

	/*
	 * ADVENTURER FIELDS
	 */
	private int level;
	private int experience;

	private DnDClass job;
	private Subclass subclass;
	private Race race;
	private Background background;

	/*
	 * INSTANCE METHODS
	 */
	public String toStringVerbose() {
		String s = "";

		s += name + " " + alignment.toString() + " " + race.toString() + " " + job.toString() + " "
				+ subclass.toString() + " " + background.toString();
		s += String.format("%n[%2d,%2d,%2d,%2d,%2d,%2d]", abilityScores[0], abilityScores[1], abilityScores[2],
				abilityScores[3], abilityScores[4], abilityScores[5]);

		return s;
	}
	
	/*
	 * ADVENTURER METHODS
	 */
	@Override
	public int getLevel() {
		return level;
	}

	@Override
	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public int getExperience() {
		return experience;
	}

	@Override
	public void setExperience(int experience) {
		this.experience = experience;
	}

	@Override
	public DnDClass getJob() {
		return job;
	}

	@Override
	public void setJob(DnDClass job) {
		this.job = job;
	}

	@Override
	public Subclass getSubclass() {
		return subclass;
	}

	@Override
	public void setSubclass(Subclass subclass) {
		this.subclass = subclass;
	}

	@Override
	public Race getRace() {
		return race;
	}

	@Override
	public void setRace(Race race) {
		this.race = race;
	}

	@Override
	public Background getBackground() {
		return background;
	}

	@Override
	public void setBackground(Background background) {
		this.background = background;
	}

	/*
	 * STATIC METHODS
	 */
	public static DnDCharacter random() {
		DnDCharacter toon = new DnDCharacter();

		toon.makePersistent(false);
		toon.markChanged(true);
		// toon.setID(id);

		toon.setAbilityScores(Dice.roll3d6InOrder());
		toon.setAbilityCeiling(new int[] { 20, 20, 20, 20, 20, 20 });
		toon.setFemale(toon.getStrength() > toon.getConstitution());

		toon.setAlignment(Alignment.randomSkewEvil());
		toon.setJob(DnDClass.selectClass(toon));
		toon.setSubclass(Subclass.selectSubclass(toon));
		toon.setRace(Race.randomSkewHuman());
		toon.setBackground(Background.random());

		toon.setLevel(1);
		toon.setExperience(0);

		return toon;
	}

}
