package com.dnd5e.character.classes;

import java.util.EnumSet;

import com.dnd5e.character.definitions.*;

import controller.*;

public abstract class JobClass {
	/*
	 * STATIC FIELDS
	 */
	protected static final ClassFeature[] STR_BONUSES = { ClassFeature.STR_BONUS_4, ClassFeature.STR_BONUS_6,
			ClassFeature.STR_BONUS_8, ClassFeature.STR_BONUS_10, ClassFeature.STR_BONUS_12, ClassFeature.STR_BONUS_14,
			ClassFeature.STR_BONUS_16, ClassFeature.STR_BONUS_19 };
	protected static final ClassFeature[] DEX_BONUSES = { ClassFeature.DEX_BONUS_4, ClassFeature.DEX_BONUS_6,
			ClassFeature.DEX_BONUS_8, ClassFeature.DEX_BONUS_10, ClassFeature.DEX_BONUS_12, ClassFeature.DEX_BONUS_14,
			ClassFeature.DEX_BONUS_16, ClassFeature.DEX_BONUS_19 };
	protected static final ClassFeature[] CON_BONUSES = { ClassFeature.CON_BONUS_4, ClassFeature.CON_BONUS_6,
			ClassFeature.CON_BONUS_8, ClassFeature.CON_BONUS_10, ClassFeature.CON_BONUS_12, ClassFeature.CON_BONUS_14,
			ClassFeature.CON_BONUS_16, ClassFeature.CON_BONUS_19 };
	protected static final ClassFeature[] INT_BONUSES = { ClassFeature.INT_BONUS_4, ClassFeature.INT_BONUS_6,
			ClassFeature.INT_BONUS_8, ClassFeature.INT_BONUS_10, ClassFeature.INT_BONUS_12, ClassFeature.INT_BONUS_14,
			ClassFeature.INT_BONUS_16, ClassFeature.INT_BONUS_19 };
	protected static final ClassFeature[] WIS_BONUSES = { ClassFeature.WIS_BONUS_4, ClassFeature.WIS_BONUS_6,
			ClassFeature.WIS_BONUS_8, ClassFeature.WIS_BONUS_10, ClassFeature.WIS_BONUS_12, ClassFeature.WIS_BONUS_14,
			ClassFeature.WIS_BONUS_16, ClassFeature.WIS_BONUS_19 };
	protected static final ClassFeature[] CHA_BONUSES = { ClassFeature.CHA_BONUS_4, ClassFeature.CHA_BONUS_6,
			ClassFeature.CHA_BONUS_8, ClassFeature.CHA_BONUS_10, ClassFeature.CHA_BONUS_12, ClassFeature.CHA_BONUS_14,
			ClassFeature.CHA_BONUS_16, ClassFeature.CHA_BONUS_19 };

	/*
	 * STATIC METHODS
	 */
	public static void setup(Hero actor) {

		if (Main.TESTING_MESSAGES)
			System.out.println("Not implemented.");
	}

	public static void setupStartingGear(Hero actor) {
		DnDClass job = actor.getJob();
		switch (job) {
		case BARBARIAN:
			Barbarian.setupStartingGear(actor);
			break;
		case BARD:
			Bard.setupStartingGear(actor);
			break;
		case CLERIC:
			Cleric.setupStartingGear(actor);
			break;
		case DRUID:
			Druid.setupStartingGear(actor);
			break;
		case FIGHTER:
			Fighter.setupStartingGear(actor);
			break;
		case MONK:
			Monk.setupStartingGear(actor);
			break;
		case PALADIN:
			Paladin.setupStartingGear(actor);
			break;
		case RANGER:
			Ranger.setupStartingGear(actor);
			break;
		case ROGUE:
			Rogue.setupStartingGear(actor);
			break;
		case SORCERER:
			Sorcerer.setupStartingGear(actor);
			break;
		case WARLOCK:
			Warlock.setupStartingGear(actor);
			break;
		case WIZARD:
			Wizard.setupStartingGear(actor);
			break;
		default:
			break;
		}
	}

	@SuppressWarnings("unused")
	public static void apply(int level, Hero actor) {
		EnumSet<ClassFeature> features = actor.getClassFeatures();

		Subclass subclass = actor.getSubclass();
		switch (level) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_4);
			improveAbility(actor);

			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_8);
			improveAbility(actor);

			break;
		case 9:
			break;
		case 10:
			break;
		case 11:
			break;
		case 12:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_12);
			improveAbility(actor);

			break;
		case 13:
			break;
		case 14:
			break;
		case 15:
			break;
		case 16:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_16);
			improveAbility(actor);

			break;
		case 17:
			break;
		case 18:
			break;
		case 19:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_19);
			improveAbility(actor);

			break;
		case 20:
			break;
		}

		actor.setClassFeatures(features);
	}

	public static void improveAbility(Hero actor) {
		ClassFeature improvement = null;

		// determines index of improvement to return
		int level = actor.getLevel(), index = 0;
		if (level == 4)
			index = 0;
		else if (level == 6)
			index = 1;
		else if (level == 8)
			index = 2;
		else if (level == 10)
			index = 3;
		else if (level == 12)
			index = 4;
		else if (level == 14)
			index = 5;
		else if (level == 16)
			index = 6;
		else if (level == 19)
			index = 7;

		if (actor.improveConstitution(2))
			improvement = CON_BONUSES[index];
		else if (actor.improveCharisma(2))
			improvement = CHA_BONUSES[index];
		else if (actor.improveStrength(2))
			improvement = STR_BONUSES[index];
		else if (actor.improveIntelligence(2))
			improvement = INT_BONUSES[index];
		else if (actor.improveDexterity(2))
			improvement = DEX_BONUSES[index];
		else if (actor.improveWisdom(2))
			improvement = WIS_BONUSES[index];

		actor.getClassFeatures().add(improvement);
	}

}
