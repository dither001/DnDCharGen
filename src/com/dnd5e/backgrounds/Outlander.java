package com.dnd5e.backgrounds;

import com.dnd5e.characters.*;
import com.dnd5e.definitions.rules.*;
import com.dnd5e.definitions.skills.Skill;
import com.dnd5e.equipment.*;
import com.miscellaneous.util.*;

public abstract class Outlander {
	private static final Background BACKGROUND;
	private static final Skill[] SKILLS;

	private static final String[] ORIGIN;
	/*
	 * INITIALIZATION
	 */
	static {
		BACKGROUND = Background.OUTLANDER;
		SKILLS = new Skill[] { Skill.ATHLETICS, Skill.SURVIVAL };
		//
		ORIGIN = new String[] { "forester", "trapper", "homesteader", "guide", "exile or outcast", "bounty hunter",
				"pilgrim", "tribal nomad", "hunter-gatherer", "tribal marauder" };
	}

	/*
	 * STATIC METHODS
	 */
	public static void setup(Hero actor) {
		// SKILLS
		int r = Misc.tryToAddAll(SKILLS, actor.getCommonSkills());

		// MUSICAL INSTRUMENT
		r += Misc.tryToAddOne(Skill.getInstrumentSkillsList(), actor.getSpecialSkills());
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

		// x1 staff - vague in the PHB, so chose simple weapon version
		inv.addWeaponHelper(Skill.QUARTERSTAFF);
		// x1 traveler clothes
		inv.addGearHelper(1, "traveler clothes");

		// TODO - trophy from animal you killed
		// TODO - belt pouch
		// TODO - 10 gp

		// FINAL STEP
		actor.setInventory(inv);
	}

	public static Background getEnumeratedType() {
		return BACKGROUND;
	}
}
