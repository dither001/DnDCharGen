package com.dnd5e.characters;

public interface Adventurer {

	// level
	public int getLevel();

	public void setLevel(int level);

	// experience
	public int getExperience();

	public void setExperience(int experience);

	// class
	public DnDClass getJob();

	public void setJob(DnDClass job);

	// subclass
	public Subclass getSubclass();

	public void setSubclass(Subclass subclass);

	// race
	public Race getRace();

	public void setRace(Race race);

	// background
	public Background getBackground();

	public void setBackground(Background background);
}
