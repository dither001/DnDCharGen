package com.dnd5e.backgrounds;

import com.dnd5e.characters.*;
import com.dnd5e.definitions.rules.*;
import com.dnd5e.definitions.skills.Skill;
import com.dnd5e.equipment.*;
import com.miscellaneous.util.*;

public abstract class GuildArtisan {
	private static final Background BACKGROUND;
	private static final Skill[] SKILLS;

	private static final String[] GUILD_BUSINESS;
	/*
	 * INITIALIZATION
	 */
	static {
		BACKGROUND = Background.GUILD_ARTISAN;
		SKILLS = new Skill[] { Skill.INSIGHT, Skill.PERSUASION };
		//
		GUILD_BUSINESS = new String[] { "I stood up to a tyrant's agents.", "I saved people during a natural disaster.",
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

		// ARTISAN TOOL
		Skill guildSkill = Misc.randomFromList(Skill.getProfessionalSkillsList());

		r += Misc.tryToAdd(guildSkill, actor.getSpecialSkills());
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

		// x1 artisan tool
		inv.addGearHelper(1, guildSkill.toString().replace("_", " ").toLowerCase());

		// TODO - letter of introduction from guild

		// x1 traveler clothes
		inv.addGearHelper(1, "traveler clothes");

		// TODO - "belt pouch"
		// TODO - 15 gp

		// FINAL STEP
		actor.setInventory(inv);
	}

	private void guilds() {
		Skill skill = Misc.randomFromList(Skill.getProfessionalSkillsList());

		switch (skill) {
		case ALCHEMY_TOOLS:
			break;
		case BREWING_TOOLS:
			break;
		case CALLIGRAPHY_TOOLS:
			break;
		case CARPENTER_TOOLS:
			break;
		case CARTOGRAPHY_TOOLS:
			break;
		case COBBLER_TOOLS:
			break;
		case MESS_KIT:
			break;
		case GLASSBLOWER_TOOLS:
			break;
		case JEWELER_TOOLS:
			break;
		case LEATHERWORKING_TOOLS:
			break;
		case MASONRY_TOOLS:
			break;
		case NAVIGATOR_TOOLS:
			break;
		case PAINTING_TOOLS:
			break;
		case POTTING_TOOLS:
			break;
		case SMITHING_TOOLS:
			// includes: armorer, locksmiths, & finesmiths
			// includes: smiths and metal-forgers
			break;
		case TINKERS_TOOLS:
			break;
		case WEAVING_TOOLS:
			break;
		case WOODCARVING_TOOLS:
			break;
		default:
			// missing: shipwrights & sail-makers
			// missing: wagon-makers & wheelwrights
			break;

		}

	}
	
	public static Background getEnumeratedType() {
		return BACKGROUND;
	}
}
