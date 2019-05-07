package com.dnd5e.backgrounds;

import com.dnd5e.characters.*;
import com.dnd5e.definitions.skills.Skill;
import com.dnd5e.equipment.*;
import com.miscellaneous.util.*;

public abstract class Urchin {
	private static final Background BACKGROUND;
	private static final Skill[] SKILLS;

	/*
	 * INITIALIZATION
	 */
	static {
		BACKGROUND = Background.URCHIN;
		SKILLS = new Skill[] { Skill.SLEIGHT_OF_HAND, Skill.STEALTH };
	}

	/*
	 * STATIC METHODS
	 */
	public static void setup(Hero actor) {
		// SKILLS
		int r = Misc.tryToAddAll(SKILLS, actor.getCommonSkills());

		// GAMING SET + LAND VEHICLES
		r += Misc.tryToAdd(Skill.DISGUISE_KIT, actor.getSpecialSkills());
		r += Misc.tryToAdd(Skill.THIEVES_TOOLS, actor.getSpecialSkills());
		if (r > 0) {
			// ensure the N/PC gets the requisite number of skills
			Misc.tryToAddN(r, Skill.getCommonSkills(), actor.getCommonSkills());
		}

		/*
		 * INVENTORY
		 */
		Inventory inv = actor.getInventory();

		// x1 "small knife"
		inv.addWeaponHelper(Skill.DAGGER);

		// TODO - map of the city you grew up in
		// TODO - pet mouse
		// TODO - token to remember your parents

		// x1 common clothes
		inv.addGearHelper(1, "common clothes");

		// TODO - belt pouch
		// TODO - 10 gp

		// FINAL STEP
		actor.setInventory(inv);
	}

	public static Background getEnumeratedType() {
		return BACKGROUND;
	}
}
