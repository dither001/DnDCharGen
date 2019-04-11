package com.dnd5e.worlds;

import com.dnd5e.characters.*;
import com.dnd5e.definitions.rules.*;
import com.dnd5e.magic.*;
import com.miscellaneous.util.*;

public enum God implements Opposite, Similar {
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
	 * INSTANCE METHODS
	 */
	public String holySymbol() {
		return holySymbol(this);
	}

	private boolean deathGod() {
		return this.equals(RAVEN_QUEEN) || this.equals(TOROG) || this.equals(VECNA) || this.equals(ZEHIR);
	}

	private boolean knowledgeGod() {
		return this.equals(ERATHIS) || this.equals(IOUN) || this.equals(MORADIN) || this.equals(VECNA);
	}

	private boolean lifeGod() {
		return this.equals(BAHAMUT) || this.equals(PELOR) || this.equals(RAVEN_QUEEN);
	}

	private boolean lightGod() {
		return this.equals(CORELLON) || this.equals(PELOR);
	}

	private boolean natureGod() {
		return this.equals(MELORA);
	}

	private boolean tempestGod() {
		return this.equals(GRUUMSH) || this.equals(KORD) || this.equals(MELORA);
	}

	private boolean tricksterGod() {
		return this.equals(ASMODEUS) || this.equals(AVANDRA) || this.equals(LOLTH) || this.equals(SEHANINE)
				|| this.equals(THARIZDUN) || this.equals(ZEHIR);
	}

	private boolean warGod() {
		return this.equals(BAHAMUT) || this.equals(BANE) || this.equals(GRUUMSH) || this.equals(MORADIN)
				|| this.equals(TIAMAT);
	}

	@Override
	public int similarTo(Object o) {
		int similar = -1;

		if (o.getClass().equals(God.class)) {
			God g = (God) o;

			if (g.deathGod() && this.deathGod())
				similar = 1;
			else if (g.knowledgeGod() && this.knowledgeGod())
				similar = 1;
			else if (g.lifeGod() && this.lifeGod())
				similar = 1;
			else if (g.lightGod() && this.lightGod())
				similar = 1;
			else if (g.natureGod() && this.natureGod())
				similar = 1;
			else if (g.tempestGod() && this.tempestGod())
				similar = 1;
			else if (g.tricksterGod() && this.tricksterGod())
				similar = 1;
			else if (g.warGod() && this.warGod())
				similar = 1;

			if (g.equals(this))
				similar = 0;
		}

		return similar;
	}

	@Override
	public boolean opposedTo(Object o) {
		boolean opposed = false;

		if (o.getClass().equals(God.class)) {
			God g = (God) o;

			if (g.deathGod() && this.lifeGod())
				opposed = true;
			else if (g.knowledgeGod() && this.tricksterGod())
				opposed = true;
			else if (g.lightGod() && this.tempestGod())
				opposed = true;
			else if (g.natureGod() && this.warGod())
				opposed = true;
			else if (g.lifeGod() && this.deathGod())
				opposed = true;
			else if (g.tricksterGod() && this.knowledgeGod())
				opposed = true;
			else if (g.tempestGod() && this.lightGod())
				opposed = true;
			else if (g.warGod() && this.natureGod())
				opposed = true;

			if (g.equals(this))
				opposed = false;
		}

		return opposed;
	}

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
			} catch (ParserException e) {
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

	public static String holySymbol(God god) {
		String s = null;

		switch (god) {
		case ASMODEUS:
			s = "three triangles in tight formation";
			break;
		case AVANDRA:
			s = "three stacked wavy lines";
			break;
		case BAHAMUT:
			s = "dragon's head, in profile, facing left";
			break;
		case BANE:
			s = "claw with three talons pointing down";
			break;
		case CORELLON:
			s = "eight-pointed star";
			break;
		case ERATHIS:
			s = "upper half of a clockwork gear";
			break;
		case GRUUMSH:
			s = "triangular eye with bony protrusions";
			break;
		case IOUN:
			s = "crook shaped like a stylized";
			break;
		case KORD:
			s = "sword with a lightning bolt cross guard";
			break;
		case LOLTH:
			s = "eight-pointed star with web motif";
			break;
		case MELORA:
			s = "wavelike swirl";
			break;
		case MORADIN:
			s = "flaming anvil";
			break;
		case PELOR:
			s = "circle with six outwardly radiating points";
			break;
		case RAVEN_QUEEN:
			s = "raven's head, in profile, facing left";
			break;
		case SEHANINE:
			s = "crescent moon";
			break;
		case THARIZDUN:
			s = "jagged counter-clockwise spiral";
			break;
		case TIAMAT:
			s = "five-pointed star with curved points";
			break;
		case TOROG:
			s = "letter 'T' attached to circular shackle";
			break;
		case VECNA:
			s = "partially shattered one-eyed skull";
			break;
		case ZEHIR:
			s = "snake in the shape of a dagger";
			break;
		}

		return s;
	}

}
