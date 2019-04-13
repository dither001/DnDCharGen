package com.dnd5e.backgrounds;

import com.dnd5e.characters.*;
import com.dnd5e.definitions.rules.*;
import com.dnd5e.equipment.*;
import com.miscellaneous.util.*;

public abstract class Soldier {
	private static final Background BACKGROUND;
	private static final Skill[] SKILLS;

	private static final String[] SPECIALTY;
	/*
	 * INITIALIZATION
	 */
	static {
		BACKGROUND = Background.SOLDIER;
		SKILLS = new Skill[] { Skill.ATHLETICS, Skill.INTIMIDATION };
		//
		SPECIALTY = new String[] { "officer", "scout", "infantry", "cavalry", "medic", "quartermaster",
				"standard bearer", "support staff" };
	}

	/*
	 * STATIC METHODS
	 */
	public static void setup(Hero actor) {
		// SKILLS
		int r = Misc.tryToAddAll(SKILLS, actor.getCommonSkills());

		// GAMING SET + LAND VEHICLES
		r += Misc.tryToAddOne(Skill.getGamingSkills(), actor.getSpecialSkills());
		r += Misc.tryToAddOne(Skill.getLandVehicles(), actor.getSpecialSkills());
		if (r > 0) {
			// ensure the N/PC gets the requisite number of skills
			Misc.tryToAddN(r, Skill.getCommonSkills(), actor.getCommonSkills());
		}

		/*
		 * INVENTORY
		 */
		Inventory inv = actor.getInventory();

		// TODO - insignia of rank
		// TODO - trophy from fallen enemy

		// TODO - x1 gaming set

		// x1 common clothes
		inv.addGearHelper(1, "common clothes");

		// TODO - belt pouch
		// TODO - 10 gp

		// FINAL STEP
		actor.setInventory(inv);
	}

}
