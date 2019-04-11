package com.dnd5e.backgrounds;

import com.dnd5e.character.definitions.*;
import com.dnd5e.definitions.*;
import com.dnd5e.gear.equipment.Inventory;
import com.miscellaneous.util.Misc;

public abstract class Entertainer {
	private static final Background BACKGROUND;
	private static final Skill[] SKILLS;

	private static final String[] ENTERTAINER_ROUTINE;
	/*
	 * INITIALIZATION
	 */
	static {
		BACKGROUND = Background.ENTERTAINER;
		SKILLS = new Skill[] { Skill.ACROBATICS, Skill.PERFORMANCE };
		//
		ENTERTAINER_ROUTINE = new String[] { "actor", "dancer", "fire-eater", "jester", "juggler", "musician", "poet",
				"singer", "storyteller", "tumbler" };
	}

	/*
	 * STATIC METHODS
	 */
	public static void setup(Hero actor) {
		// SKILLS
		int r = Misc.tryToAddAll(SKILLS, actor.getCommonSkills());

		// INSTRUMENT + DISGUISE KIT
		r += Misc.tryToAddOne(Skill.getInstrumentSkillsList(), actor.getSpecialSkills());
		r += Misc.tryToAdd(Skill.DISGUISE_KIT, actor.getSpecialSkills());
		if (r > 0) {
			// ensure the N/PC gets the requisite number of skills
			Misc.tryToAddN(r, Skill.getCommonSkills(), actor.getCommonSkills());
		}

		/*
		 * INVENTORY
		 */
		Inventory inv = actor.getInventory();

		// x1 random musical instrument
		inv.randomInstrument();
		// TODO - random favor from admirer

		// x1 costume
		inv.addGear(1, "costume");

		// TODO - "belt pouch"
		// TODO - 15 gp

		// FINAL STEP
		actor.setInventory(inv);

	}
}
