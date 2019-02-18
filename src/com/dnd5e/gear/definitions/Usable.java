package com.dnd5e.gear.definitions;

import com.dnd5e.definitions.*;

public interface Usable extends Portable {
	public Handed getHanded();
	
	public void setHanded(Handed handed);
	
	public Skill[] getSkills();
	
	public void setSkills(Skill[] skills);
}
