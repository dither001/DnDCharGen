package com.dnd5e.backgrounds;

import com.dnd5e.characters.*;
import com.dnd5e.definitions.skills.Skill;
import com.dnd5e.equipment.*;
import com.miscellaneous.util.*;

public abstract class FolkHero {
	private static final Background BACKGROUND;
	private static final Skill[] SKILLS;

	private static final String[] DEFINING_EVENT;
	/*
	 * INITIALIZATION
	 */
	static {
		BACKGROUND = Background.FOLK_HERO;
		SKILLS = new Skill[] { Skill.ANIMAL_HANDLING, Skill.SURVIVAL };
		//
		DEFINING_EVENT = new String[] { "I stood up to a tyrant's agents.", "I saved people during a natural disaster.",
				"I stood alone against a terrible monster.", "I stole from a corrupt merchant to help the poor.",
				"I led a militia to fight off an invading army.",
				"I broke into a tyrant's castle and stole weapons to arm the people.",
				"I trained the peasantry to use farm implements as weapons against a tyrant's soldiers.",
				"My symbolic act of protest convinced a lord to rescind an unpopular decree.",
				"A celestial, fey, or other supernatural creature gave me a blessing or revealed my secret origin.",
				"I rose to leadership in a lord's army and was commended for my heroism." };
	}

	/*
	 * STATIC METHODS
	 */
	public static void setup(Hero actor) {
		// SKILLS
		int r = Misc.tryToAddAll(SKILLS, actor.getCommonSkills());

		// PROFESSIONAL SKILL + LAND VEHICLE
		r += Misc.tryToAddOne(Skill.getProfessionalSkillsList(), actor.getSpecialSkills());
		r += Misc.tryToAddOne(Skill.getLandVehicles(), actor.getSpecialSkills());
		if (r > 0) {
			// ensure the N/PC gets the requisite number of skills
			Misc.tryToAddN(r, Skill.getCommonSkills(), actor.getCommonSkills());			
		}

		/*
		 * INVENTORY
		 */
		Inventory inv = actor.getInventory();

		// TODO - need method like "random instrument" to filter & select artisan tools
		// based on skills
		inv.randomArtisanTool();
		// x1 shovel
		inv.addGearHelper(1, "shovel");

		// TODO - x1 iron pot
		// inv.addGear(1, "iron pot");

		// x1 common clothes
		inv.addGearHelper(1, "common clothes");

		// TODO - "belt pouch"
		// TODO - 10 gp

		// FINAL STEP
		actor.setInventory(inv);
	}
	
	public static Background getEnumeratedType() {
		return BACKGROUND;
	}
}
