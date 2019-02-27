package com.dnd5e.gear.definitions;

import com.dnd5e.definitions.*;

public interface Usable extends Portable {
	public Handed getHanded();

	public void setHanded(Handed handed);

	public Skill[] getSkills();

	public void setSkills(Skill[] skills);

	/*
	 * 
	 */
	public default boolean uses(Skill skill) {
		for (Skill el : getSkills()) {
			if (el.equals(skill))
				return true;
		}

		return false;
	}

}
