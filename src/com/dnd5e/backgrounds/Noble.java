package com.dnd5e.backgrounds;

import com.dnd5e.characters.*;
import com.dnd5e.definitions.rules.*;
import com.dnd5e.equipment.*;
import com.miscellaneous.util.*;

public abstract class Noble {
	private static final Background BACKGROUND;
	private static final Skill[] SKILLS;

	/*
	 * INITIALIZATION
	 */
	static {
		BACKGROUND = Background.NOBLE;
		SKILLS = new Skill[] { Skill.HISTORY, Skill.PERSUASION };
	}

	/*
	 * STATIC METHODS
	 */
	public static void setup(Hero actor) {
		// SKILLS
		int r = Misc.tryToAddAll(SKILLS, actor.getCommonSkills());

		// GAMING SKILL
		r += Misc.tryToAddOne(Skill.getGamingSkills(), actor.getSpecialSkills());
		if (r > 0) {
			// ensure the N/PC gets the requisite number of skills
			Misc.tryToAddN(r, Skill.getCommonSkills(), actor.getCommonSkills());
		}

		// LANGUAGES
		Misc.tryToAddOne(Language.COMMON_LANGUAGES, actor.getLanguages());

		/*
		 * INVENTORY
		 */
		Inventory inv = actor.getInventory();

		// x1 fine clothes
		inv.addGear(1, "fine clothes");
		// x1 signet ring
		inv.addGear(1, "signet ring");

		// TODO - scroll of pedigree
		// TODO - purse
		// TODO - 25 gp

		// FINAL STEP
		actor.setInventory(inv);
	}

}
