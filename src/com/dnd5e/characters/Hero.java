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

	public Hero() {
		super();
		this.level = 1;
		this.experience = 0;

		this.job = DnDClass.ROGUE;
		this.subclass = Subclass.THIEF;
		this.race = Race.HUMAN;
		this.background = Background.CRIMINAL;
	}

	/*
	 * OVERRIDE METHODS
	 */
	@Override
	public int getProficiencyBonus() {
		int bonus = 2;

		if (level > 16)
			bonus = 6;
		else if (level > 12)
			bonus = 5;
		else if (level > 8)
			bonus = 4;
		else if (level > 4)
			bonus = 3;

		return bonus;
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

}
