package com.dnd5e.definitions.gear;

import com.dnd5e.characters.*;
import com.dnd5e.definitions.skills.Skill;

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
