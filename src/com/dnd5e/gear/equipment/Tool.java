package com.dnd5e.gear.equipment;

import com.dnd5e.definitions.Skill;
import com.dnd5e.gear.definitions.*;

public class Tool extends Item implements Usable {
	/*
	 * INSTANCE FIELDS
	 */
	protected Handed handed;
	protected Skill[] skills;

	public Tool() {
		super();
		this.handed = Handed.HEAVY;
		this.skills = new Skill[] { Skill.UNSKILLED };
	}

	/*
	 * INSTANCE METHODS
	 */
	@Override
	public Handed getHanded() {
		return handed;
	}

	@Override
	public void setHanded(Handed handed) {
		this.handed = handed;
	}

	@Override
	public Skill[] getSkills() {
		return skills;
	}

	@Override
	public void setSkills(Skill[] skills) {
		this.skills = skills;
	}

}
