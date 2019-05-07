package com.dnd5e.backgrounds;

import com.dnd5e.characters.*;
import com.dnd5e.definitions.rules.*;
import com.dnd5e.definitions.skills.Skill;
import com.dnd5e.equipment.*;
import com.miscellaneous.util.*;

public abstract class Sage {
	private static final Background BACKGROUND;
	private static final Skill[] SKILLS;

	private static final String[] SPECIALTY;
	/*
	 * INITIALIZATION
	 */
	static {
		BACKGROUND = Background.SAGE;
		SKILLS = new Skill[] { Skill.ARCANA, Skill.HISTORY };
		//
		SPECIALTY = new String[] { "alchemist", "astronomer", "discredited academic", "librarian", "professor",
				"researcher", "wizard apprentice", "scribe" };
	}

	/*
	 * STATIC METHODS
	 */
	public static void setup(Hero actor) {
		// SKILLS
		int r = Misc.tryToAddAll(SKILLS, actor.getCommonSkills());
		if (r > 0) {
			// ensure the N/PC gets the requisite number of skills
			Misc.tryToAddN(r, Skill.getCommonSkills(), actor.getCommonSkills());
		}

		// LANGUAGES
		Misc.tryToAddN(2, Language.COMMON_LANGUAGES, actor.getLanguages());

		/*
		 * INVENTORY
		 */
		Inventory inv = actor.getInventory();

		// TODO - bottle of ink

		// x1 "small knife"
		inv.addWeaponHelper(Skill.DAGGER);

		// TODO - letter from dead colleague posing unanswered question

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
