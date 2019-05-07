package com.dnd5e.backgrounds;

import com.dnd5e.characters.*;
import com.dnd5e.definitions.skills.Skill;
import com.dnd5e.equipment.*;
import com.miscellaneous.util.*;

public abstract class Charlatan {
	private static final Background BACKGROUND;
	private static final Skill[] SKILLS;

	private static final Skill[] UNCOMMON_SKILLS;

	private static final String[] FAVORITE_SCHEMES;
	/*
	 * INITIALIZATION
	 */
	static {
		BACKGROUND = Background.CHARLATAN;
		SKILLS = new Skill[] { Skill.DECEPTION, Skill.SLEIGHT_OF_HAND };
		//
		UNCOMMON_SKILLS = new Skill[] { Skill.DISGUISE_KIT, Skill.FORGERY_KIT };

		FAVORITE_SCHEMES = new String[] { "I cheat at games of chance.", "I shave coins or roge documents.",
				"I insinuate myself into people's lives to prey on their weakness and secure their fortunes.",
				"I put on new identities like clothes.", "I run sleight-of-hand cons on street corners.",
				"I convince people that worthless junk is worth their hard-earned money." };
	}

	/*
	 * STATIC METHODS
	 */
	public static void setup(Hero actor) {
		// SKILLS
		int r = Misc.tryToAddAll(SKILLS, actor.getCommonSkills());

		// UNCOMMON SKILLS
		r += Misc.tryToAddAll(UNCOMMON_SKILLS, actor.getSpecialSkills());
		if (r > 0) {
			// ensure the N/PC gets the requisite number of skills
			Misc.tryToAddN(r, Skill.getCommonSkills(), actor.getCommonSkills());			
		}

		/*
		 * INVENTORY
		 */
		Inventory inv = actor.getInventory();

		// x1 fine clothes
		inv.addGearHelper(1, "fine clothes");
		// TODO - "con tools"
		// e.g. x10 stoppered bottles
		// e.g. weighted dice
		// e.g. marked cards
		// e.g. signet ring of imaginary duke

		// TODO - "belt pouch"
		// TODO - 15 gp

		// FINAL STEP
		actor.setInventory(inv);
	}
	
	public static Background getEnumeratedType() {
		return BACKGROUND;
	}
}
