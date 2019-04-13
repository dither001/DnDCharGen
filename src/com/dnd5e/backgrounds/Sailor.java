package com.dnd5e.backgrounds;

import com.dnd5e.characters.*;
import com.dnd5e.definitions.rules.*;
import com.dnd5e.equipment.*;
import com.miscellaneous.util.*;

public abstract class Sailor {
	private static final Background BACKGROUND;
	private static final Skill[] SKILLS;

	/*
	 * INITIALIZATION
	 */
	static {
		BACKGROUND = Background.SAILOR;
		SKILLS = new Skill[] { Skill.ATHLETICS, Skill.PERCEPTION };
	}

	/*
	 * STATIC METHODS
	 */
	public static void setup(Hero actor) {
		// SKILLS
		int r = Misc.tryToAddAll(SKILLS, actor.getCommonSkills());

		// NAVIGATOR TOOLS + WATER VEHICLES
		r += Misc.tryToAdd(Skill.NAVIGATOR_TOOLS, actor.getSpecialSkills());
		r += Misc.tryToAddOne(Skill.getWaterVehicles(), actor.getSpecialSkills());
		if (r > 0) {
			// ensure the N/PC gets the requisite number of skills
			Misc.tryToAddN(r, Skill.getCommonSkills(), actor.getCommonSkills());
		}

		/*
		 * INVENTORY
		 */
		Inventory inv = actor.getInventory();

		// x1 "belaying pin"
		inv.addWeaponHelper(Skill.CLUB);
		// x1 silk rope
		inv.addGearHelper(1, "silk rope");

		// TODO - lucky charm or trinket

		// x1 common clothes
		inv.addGearHelper(1, "common clothes");

		// TODO - belt pouch
		// TODO - 10 gp

		// FINAL STEP
		actor.setInventory(inv);
	}

}
