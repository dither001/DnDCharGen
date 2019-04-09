package com.dnd5e.backgrounds;

import com.dnd5e.character.definitions.*;
import com.dnd5e.definitions.*;
import com.dnd5e.gear.equipment.*;
import com.miscellaneous.util.*;

public class Acolyte {
	private static final Background BACKGROUND;
	private static final Skill[] SKILLS;

	/*
	 * INITIALIZATION
	 */
	static {
		BACKGROUND = Background.ACOLYTE;
		SKILLS = new Skill[] { Skill.INSIGHT, Skill.RELIGION };
	}

	/*
	 * STATIC METHODS
	 */
	public static void setup(Hero actor) {
		// LANGUAGES
		Misc.tryToAddN(2, Language.COMMON_LANGUAGES, actor.getLanguages());

		// SKILLS
		int r = Misc.tryToAddAll(SKILLS, actor.getCommonSkills());
		if (r > 0)
			Misc.tryToAddN(r, Skill.getCommonSkills(), actor.getCommonSkills());

		/*
		 * INVENTORY
		 */
		Inventory inv = actor.getInventory();

		// TODO - need "holy symbol builder"
		inv.addGear(1, "holy symbol");
		// TODO - need "book builder"
		inv.addGear(1, "book");
		// TODO - need x5 "incense"
		// TODO - need "cleric vestments"
		// x1 common clothes
		inv.addGear(1, "common clothes");
		// TODO - "belt pouch"
		// TODO - 15 gp

		// FINAL STEP
		actor.setInventory(inv);
	}
}
