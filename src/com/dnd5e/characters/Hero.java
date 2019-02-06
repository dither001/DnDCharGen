package com.dnd5e.characters;

public abstract class Hero extends Actor implements Adventurer {

	/*
	 * ADVENTURER FIELDS
	 */
	protected int level;
	protected int experience;

	protected DnDClass job;
	protected Subclass subclass;
	protected Race race;
	protected Background background;


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

}
