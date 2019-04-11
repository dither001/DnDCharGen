package com.dnd5e.backgrounds;

import com.dnd5e.character.definitions.Background;
import com.dnd5e.character.definitions.Hero;
import com.dnd5e.definitions.Skill;
import com.dnd5e.gear.equipment.Inventory;
import com.miscellaneous.util.Misc;

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
		inv.addWeapon(Skill.DAGGER);

		// TODO - map of the city you grew up in
		// TODO - pet mouse
		// TODO - token to remember your parents

		// x1 common clothes
		inv.addGear(1, "common clothes");

		// TODO - belt pouch
		// TODO - 10 gp

		// FINAL STEP
		actor.setInventory(inv);
	}

}