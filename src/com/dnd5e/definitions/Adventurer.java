package com.dnd5e.definitions;

import com.dnd5e.characters.*;

public interface Adventurer {

	public int getLevel();

	public void setLevel(int level);

	public int getExperience();

	public void setExperience(int experience);

	public DnDClass getJob();

	public void setJob(DnDClass job);

	public Subclass getSubclass();

	public void setSubclass(Subclass subclass);

	public Race getRace();

	public void setRace(Race race);

	public Background getBackground();

	public void setBackground(Background background);

}
