package com.dnd5e.backgrounds;

import com.dnd5e.characters.*;
import com.dnd5e.definitions.skills.Skill;
import com.dnd5e.equipment.*;
import com.miscellaneous.util.*;

public abstract class Criminal {
	private static final Background BACKGROUND;
	private static final Skill[] SKILLS;

	private static final String[] CRIMINAL_SPECIALTY;
	/*
	 * INITIALIZATION
	 */
	static {
		BACKGROUND = Background.CHARLATAN;
		SKILLS = new Skill[] { Skill.DECEPTION, Skill.STEALTH };
		//
		CRIMINAL_SPECIALTY = new String[] { "blackmailer", "burglar", "enforcer", "fence", "highway robber",
				"hired killer", "pickpocket", "smuggler" };
	}

	/*
	 * STATIC METHODS
	 */
	public static void setup(Hero actor) {
		// SKILLS
		int r = Misc.tryToAddAll(SKILLS, actor.getCommonSkills());

		// GAMING + THIEVES TOOLS
		r += Misc.tryToAddOne(Skill.getGamingSkills(), actor.getSpecialSkills());
		r += Misc.tryToAdd(Skill.THIEVES_TOOLS, actor.getSpecialSkills());
		if (r > 0) {
			// ensure the N/PC gets the requisite number of skills
			Misc.tryToAddN(r, Skill.getCommonSkills(), actor.getCommonSkills());			
		}

		/*
		 * INVENTORY
		 */
		Inventory inv = actor.getInventory();

		// x1 crowbar
		inv.addGearHelper(1, "crowbar");
		// x1 common clothes "dark, with a hood"
		inv.addGearHelper(1, "common clothes");

		// TODO - "belt pouch"
		// TODO - 15 gp

		// FINAL STEP
		actor.setInventory(inv);
	}

	public static Background getEnumeratedType() {
		return BACKGROUND;
	}
}
