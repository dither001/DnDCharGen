package com.dnd5e.backgrounds;

import com.dnd5e.characters.*;
import com.dnd5e.definitions.rules.*;
import com.dnd5e.definitions.skills.Skill;
import com.dnd5e.equipment.*;
import com.miscellaneous.util.*;

public abstract class Hermit {
	private static final Background BACKGROUND;
	private static final Skill[] SKILLS;

	private static final String[] SECLUSION;
	/*
	 * INITIALIZATION
	 */
	static {
		BACKGROUND = Background.HERMIT;
		SKILLS = new Skill[] { Skill.MEDICINE, Skill.RELIGION };
		//
		SECLUSION = new String[] { "I was searching for spiritual enlightenment.",
				"I was partaking of communal living in accordance with the dictates of a religious order.",
				"I was exiled for a crime I didn't commit.", "I retreated from society after a life-altering event.",
				"I needed a quiet place to work on my art, literature, music, or manifesto.",
				"I needed to commune with nature, far from civilization.",
				"I was the caretaker of an ancient ruin or relic.",
				"I was a pilgrim in search of a person, place, or relic of spiritual importance." };
	}

	/*
	 * STATIC METHODS
	 */
	public static void setup(Hero actor) {
		// SKILLS
		int r = Misc.tryToAddAll(SKILLS, actor.getCommonSkills());

		// ARTISAN TOOL
		r += Misc.tryToAdd(Skill.HERBALISM_KIT, actor.getSpecialSkills());
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

		// TODO - scroll case of notes from studies/prayers

		// x1 "winter" blanket
		inv.addGearHelper(1, "blanket");
		// x1 traveler clothes
		inv.addGearHelper(1, "common clothes");
		// x1 traveler clothes
		inv.addGearHelper(1, "herbalism kit");

		// TODO - 5 gp

		// FINAL STEP
		actor.setInventory(inv);
	}

	public static Background getEnumeratedType() {
		return BACKGROUND;
	}
}
