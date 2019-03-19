package com.dnd5e.character.classes;

import java.util.EnumSet;

import com.dnd5e.character.definitions.*;

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
	
	// class features
	public EnumSet<ClassFeature> getClassFeatures();
	
	public void setClassFeatures(EnumSet<ClassFeature> classFeatures);

	// race
	public Race getRace();

	public void setRace(Race race);

	// background
	public Background getBackground();

	public void setBackground(Background background);
}
