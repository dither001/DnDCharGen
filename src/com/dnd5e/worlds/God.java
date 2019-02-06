package com.dnd5e.worlds;

import com.dnd5e.characters.*;
import com.dnd5e.definitions.*;
import com.dnd5e.exceptions.InvalidDomainException;
import com.dnd5e.magic.*;
import com.dnd5e.util.*;

public enum God {
	ASMODEUS, AVANDRA, BAHAMUT, BANE, CORELLON, ERATHIS, GRUUMSH, IOUN, KORD, LOLTH, MELORA, MORADIN, PELOR, RAVEN_QUEEN, SEHANINE, THARIZDUN, TIAMAT, TOROG, VECNA, ZEHIR;

	//
	private static final God[] GODS = { ASMODEUS, AVANDRA, BAHAMUT, BANE, CORELLON, ERATHIS, GRUUMSH, IOUN, KORD, LOLTH,
			MELORA, MORADIN, PELOR, RAVEN_QUEEN, SEHANINE, THARIZDUN, TIAMAT, TOROG, VECNA, ZEHIR };

	//
	private static final God[] LAWFUL_GODS = { ASMODEUS, BAHAMUT, BANE, ERATHIS, MORADIN, RAVEN_QUEEN, TIAMAT };
	private static final God[] GOOD_GODS = { AVANDRA, BAHAMUT, CORELLON, MORADIN, PELOR, SEHANINE };
	private static final God[] NEUTRAL_GODS = { ERATHIS, IOUN, KORD, MELORA, PELOR, RAVEN_QUEEN, TOROG, VECNA };
	private static final God[] EVIL_GODS = { ASMODEUS, BANE, GRUUMSH, LOLTH, THARIZDUN, TIAMAT, TOROG, VECNA, ZEHIR };
	private static final God[] CHAOTIC_GODS = { AVANDRA, CORELLON, GRUUMSH, KORD, LOLTH, SEHANINE, THARIZDUN, ZEHIR };

	//
	private static final God[] DEATH_GODS = { RAVEN_QUEEN, TOROG, VECNA, ZEHIR };
	private static final God[] KNOWLEDGE_GODS = { ERATHIS, IOUN, MORADIN, VECNA };
	private static final God[] LIFE_GODS = { BAHAMUT, PELOR, RAVEN_QUEEN };
	private static final God[] LIGHT_GODS = { CORELLON, PELOR };
	private static final God[] NATURE_GODS = { MELORA };
	private static final God[] TEMPEST_GODS = { GRUUMSH, KORD, MELORA };
	private static final God[] TRICKERY_GODS = { ASMODEUS, AVANDRA, LOLTH, SEHANINE, THARIZDUN, TIAMAT, ZEHIR };
	private static final God[] WAR_GODS = { BAHAMUT, BANE, GRUUMSH, MORADIN, TIAMAT };

	/*
	 * STATIC METHODS
	 */
	public static God deusExAlignment(Alignment ali) {
		God[] array = null;

		switch (ali) {
		case CHAOTIC_EVIL:
			array = new God[] { God.GRUUMSH, God.LOLTH, God.THARIZDUN, God.ZEHIR };
			break;
		case CHAOTIC_GOOD:
			array = new God[] { God.AVANDRA, God.CORELLON, God.SEHANINE };
			break;
		case CHAOTIC_NEUTRAL:
			array = Dice.roll(2) == 1 ? CHAOTIC_GODS : NEUTRAL_GODS;
			break;
		case LAWFUL_EVIL:
			array = new God[] { God.ASMODEUS, God.BANE, God.TIAMAT };
			break;
		case LAWFUL_GOOD:
			array = new God[] { God.BAHAMUT, God.MORADIN };
			break;
		case LAWFUL_NEUTRAL:
			array = Dice.roll(2) == 1 ? LAWFUL_GODS : NEUTRAL_GODS;
			break;
		case NEUTRAL_EVIL:
			array = Dice.roll(2) == 1 ? EVIL_GODS : NEUTRAL_GODS;
			break;
		case NEUTRAL_GOOD:
			array = Dice.roll(2) == 1 ? GOOD_GODS : NEUTRAL_GODS;
			break;
		case TRUE_NEUTRAL:
			array = NEUTRAL_GODS;
			break;
		case UNALIGNED:
			array = GODS;
			break;
		}

		return Misc.randomFromArray(array);
	}

	public static God deusExClass(DnDClass job) {
		God god = God.AVANDRA;

		switch (job) {
		case BARBARIAN:
			god = Dice.roll(2) == 1 ? God.GRUUMSH : God.KORD;
			break;
		case BARD:
			god = Misc.randomFromArray(new God[] { God.AVANDRA, God.CORELLON, God.SEHANINE });
			break;
		case CLERIC:
			// TODO - should never reach this code
			god = God.ERATHIS;
			break;
		case DRUID:
			god = Dice.roll(2) == 1 ? God.KORD : God.MELORA;
			break;
		case FIGHTER:
			god = God.BANE;
			break;
		case MONK:
			god = Dice.roll(2) == 1 ? God.ERATHIS : God.IOUN;
			break;
		case PALADIN:
			god = Dice.roll(2) == 1 ? God.BAHAMUT : God.MORADIN;
			break;
		case RANGER:
			god = Dice.roll(2) == 1 ? God.AVANDRA : God.MELORA;
			break;
		case ROGUE:
			god = Dice.roll(2) == 1 ? God.AVANDRA : God.ZEHIR;
			break;
		case SORCERER:
			god = God.CORELLON;
			break;
		case WARLOCK:
			god = God.ASMODEUS;
			break;
		case WIZARD:
			god = Misc.randomFromArray(new God[] { God.CORELLON, God.IOUN, God.VECNA });
			break;
		}

		return god;
	}

	public static God deusExDomain(Domain domain) {
		God[] array = null;

		switch (domain) {
		case DEATH:
			array = DEATH_GODS;
			break;
		case KNOWLEDGE:
			array = KNOWLEDGE_GODS;
			break;
		case LIFE:
			array = LIFE_GODS;
			break;
		case LIGHT:
			array = LIGHT_GODS;
			break;
		case NATURE:
			array = NATURE_GODS;
			break;
		case TEMPEST:
			array = TEMPEST_GODS;
			break;
		case TRICKERY:
			array = TRICKERY_GODS;
			break;
		case WAR:
			array = WAR_GODS;
			break;
		}

		return Misc.randomFromArray(array);
	}

	public static God deusExRace(Race race) {
		God god = God.AVANDRA;

		switch (race) {
		case BLACKSCALE:
		case BLUESCALE:
		case GREENSCALE:
		case REDSCALE:
		case WHITESCALE:
			god = God.TIAMAT;
			break;
		case BRASSLEAF:
		case BRONZELEAF:
		case COPPERLEAF:
		case GOLDLEAF:
		case SILVERLEAF:
			god = God.BAHAMUT;
			break;
		case DARK_ELF:
			god = God.LOLTH;
			break;
		case HALF_ELF:
		case HUMAN:
			god = Dice.roll(2) == 1 ? God.ERATHIS : God.PELOR;
			break;
		case HALF_ORC:
			god = Dice.roll(2) == 1 ? God.GRUUMSH : God.KORD;
			break;
		case HIGH_ELF:
			god = God.CORELLON;
			break;
		case HILL_DWARF:
		case MOUNTAIN_DWARF:
			god = God.MORADIN;
			break;
		case FOREST_GNOME:
		case ROCK_GNOME:
			god = God.MELORA;
			break;
		case LIGHTFOOT_HALFLING:
		case STRONGHEART_HALFLING:
			god = God.AVANDRA;
			break;
		case TIEFLING:
			god = God.ASMODEUS;
			break;
		case WOOD_ELF:
			god = God.SEHANINE;
			break;
		}

		return god;
	}

	public static God random() {
		return Misc.randomFromArray(GODS);
	}

	public static God selectGod(DnDCharacter actor) {
		Alignment ali = actor.getAlignment();
		DnDClass job = actor.getJob();
		Race race = actor.getRace();

		int dice = Dice.roll(10);
		God god = null;
		if (job.equals(DnDClass.CLERIC)) {

			try {
				god = deusExDomain(Domain.parseClericSubclass(actor.getSubclass()));
			} catch (InvalidDomainException e) {
				god = God.ERATHIS;
			}
		} else if (dice < 5) {
			god = deusExAlignment(ali);
		} else if (dice < 8) {
			god = deusExRace(race);
		} else if (dice < 10) {
			god = deusExClass(job);
		} else {
			god = random();
		}

		return god;
	}
}
