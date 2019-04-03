package com.dnd5e.character.definitions;

import com.miscellaneous.util.Dice;
import com.miscellaneous.util.Misc;

public enum Subclass {
	BERSERKER, BEAR_TOTEM, EAGLE_TOTEM, WOLF_TOTEM, // barbarians
	LORE_COLLEGE, VALOR_COLLEGE, // bards
	DEATH, KNOWLEDGE, LIFE, LIGHT, NATURE, TEMPEST, TRICKERY, WAR, // clerics
	LAND_CIRCLE, MOON_CIRCLE, // druids
	CHAMPION, BATTLE_MASTER, ELDRITCH_KNIGHT, // fighters
	OPEN_HAND, SHADOW_WAY, FOUR_ELEMENTS, // monks
	DEVOTION_OATH, ANCIENTS_OATH, VENGEANCE_OATH, OATHBREAKER, // paladins
	HUNTER, BEAST_MASTER, // rangers
	THIEF, ASSASSIN, ARCANE_TRICKSTER, // rogues
	DRAGON_ORIGIN, CHAOS_ORIGIN, // sorcerers
	FEY_PACT, FIEND_PACT, STAR_PACT, // warlocks
	ABJURER, CONJUROR, DIVINER, ENCHANTER, EVOKER, ILLUSIONIST, NECROMANCER, TRANSMUTER; // wizards

	/*
	 * STATIC FIELDS
	 */
	private static final Subclass[] BARBARIANS = { BERSERKER, BEAR_TOTEM, EAGLE_TOTEM, WOLF_TOTEM };
	private static final Subclass[] BARDS = { LORE_COLLEGE, VALOR_COLLEGE };
	private static final Subclass[] CLERICS = { DEATH, KNOWLEDGE, LIFE, LIGHT, NATURE, TEMPEST, TRICKERY, WAR };
	private static final Subclass[] DRUIDS = { LAND_CIRCLE, MOON_CIRCLE };
	private static final Subclass[] FIGHTERS = { CHAMPION, BATTLE_MASTER, ELDRITCH_KNIGHT };
	private static final Subclass[] MONKS = { OPEN_HAND, SHADOW_WAY, FOUR_ELEMENTS };
	private static final Subclass[] PALADINS = { DEVOTION_OATH, ANCIENTS_OATH, VENGEANCE_OATH, OATHBREAKER };
	private static final Subclass[] RANGERS = { HUNTER, BEAST_MASTER };
	private static final Subclass[] ROGUES = { THIEF, ASSASSIN, ARCANE_TRICKSTER };
	private static final Subclass[] SORCERERS = { DRAGON_ORIGIN, CHAOS_ORIGIN };
	private static final Subclass[] WARLOCKS = { FEY_PACT, FIEND_PACT, STAR_PACT };
	private static final Subclass[] WIZARDS = { ABJURER, CONJUROR, DIVINER, ENCHANTER, EVOKER, ILLUSIONIST, NECROMANCER,
			TRANSMUTER };

	/*
	 * STATIC METHODS
	 */
	public static Subclass selectSubclass(DnDCharacter actor) {
		DnDClass job = actor.getJob();
		Subclass subclass = null;

		int dice = 0;
		switch (job) {
		case BARBARIAN:
			subclass = Misc.randomFromArray(BARBARIANS);
			break;
		case BARD:
			subclass = Misc.randomFromArray(BARDS);
			break;
		case CLERIC:
			subclass = Misc.randomFromArray(CLERICS);
			break;
		case DRUID:
			subclass = Misc.randomFromArray(DRUIDS);
			break;
		case FIGHTER:
			dice = Dice.roll(100);

			if (dice < 21 && actor.getIntelligence() > 9)
				subclass = FIGHTERS[2]; // 20% arcane trickster
			else if (dice < 51)
				subclass = FIGHTERS[1]; // 30% assassins
			else
				subclass = FIGHTERS[0]; // 50% thieves
			break;
		case MONK:
			subclass = Misc.randomFromArray(MONKS);
			break;
		case PALADIN:
			subclass = Misc.randomFromArray(PALADINS);
			break;
		case RANGER:
			subclass = Misc.randomFromArray(RANGERS);
			break;
		case ROGUE:
			dice = Dice.roll(100);

			if (dice < 21 && actor.getIntelligence() > 9)
				subclass = ROGUES[2]; // 20% arcane trickster
			else if (dice < 51)
				subclass = ROGUES[1]; // 30% assassins
			else
				subclass = ROGUES[0]; // 50% thieves
			break;
		case SORCERER:
			subclass = Misc.randomFromArray(SORCERERS);
			break;
		case WARLOCK:
			dice = Dice.roll(100);

			if (dice < 41)
				subclass = WARLOCKS[1]; // 40% fiend pact
			else if (dice < 71)
				subclass = WARLOCKS[0]; // 30% fey pact
			else
				subclass = WARLOCKS[2]; // 30% star pact
			break;
		case WIZARD:
			dice = Dice.roll(100);

			if (dice < 41)
				subclass = WIZARDS[2]; // 40% diviner
			else if (dice < 56)
				subclass = WIZARDS[4]; // 15% evoker
			else if (dice < 71)
				subclass = WIZARDS[5]; // 15% illusionist
			else if (dice < 81)
				subclass = WIZARDS[1]; // 10% conjuror
			else if (dice < 86)
				subclass = WIZARDS[0]; // 5% anjurer
			else if (dice < 91)
				subclass = WIZARDS[3]; // 5% enchanter
			else if (dice < 96)
				subclass = WIZARDS[6]; // 5% necromancer
			else
				subclass = WIZARDS[7]; // 5% transmuter
			break;
		}

		return subclass;
	}
}
