package com.dnd5e.classes;

import java.util.EnumSet;

import com.dnd5e.characters.*;
import com.dnd5e.definitions.rules.*;
import com.dnd5e.equipment.*;
import com.dnd5e.magic.Spell;
import com.miscellaneous.util.*;

public abstract class Monk extends JobClass {
	private static final DnDClass CLAZZ;
	private static final RacialFeature[] SAVING_THROWS;
	private static final Skill[] CLASS_SKILLS;
	private static final int NUMBER_OF_SKILLS;

	//
	private static final ClassFeature[][] ELEMENTAL_DISCIPLINE = {
			{ ClassFeature.FANGS_OF_FIRE_SNAKE, ClassFeature.FIST_OF_FOUR_THUNDERS, ClassFeature.FIST_OF_UNBROKEN_AIR,
					ClassFeature.RUSH_OF_GALE_SPIRITS, ClassFeature.SHAPE_OF_FLOWING_RIVER,
					ClassFeature.SWEEPING_CINDER_STRIKE, ClassFeature.WATER_WHIP },
			{ ClassFeature.CLENCH_OF_NORTH_WIND_6, ClassFeature.GONG_OF_THE_SUMMIT_6 },
			{ ClassFeature.ETERNAL_MOUNTAIN_11, ClassFeature.FLAMES_OF_PHOENIX_11, ClassFeature.MIST_STANCE_11,
					ClassFeature.RIDE_THE_WIND_11 },
			{ ClassFeature.BREATH_OF_WINTER_17, ClassFeature.RIVER_OF_HUNGRY_FLAME_17,
					ClassFeature.WAVE_OF_ROLLING_EARTH_17 } };

	static {
		CLAZZ = DnDClass.MONK;
		SAVING_THROWS = DnDClass.getSavingThrows(CLAZZ);
		CLASS_SKILLS = Skill.getClassSkills(CLAZZ);
		NUMBER_OF_SKILLS = DnDClass.getNumberOfSkills(CLAZZ);
	}

	public static void setup(Hero actor) {
		// CLASS FEATURES
		apply(1, actor);

		// SAVING THROWS
		actor.getFeatures().addAll(Misc.arrayToList(SAVING_THROWS));

		// SKILLS & WEAPON/ARMOR PROFICIENCY
		Misc.tryToAddN(NUMBER_OF_SKILLS, CLASS_SKILLS, actor.getCommonSkills());
		Misc.tryToAddOne(Skill.getInstrumentsAndProfessions(), actor.getSpecialSkills());

		actor.getWeaponSkills().addAll(Skill.simpleWeaponList());
		actor.getWeaponSkills().add(Skill.SHORTSWORD);
	}

	public static void setupStartingGear(Hero actor) {
		/*
		 * INVENTORY
		 */
		Inventory inv = actor.getInventory();

		// FIRST CHOICE
		int dice = Dice.roll(2);
		if (dice == 1) {
			inv.addWeapon(Skill.SHORTSWORD);

		} else {
			inv.randomSimpleWeapon();

		}

		// TODO - add dungeoneer's or explorer's pack
		// TODO - receive 10 darts
		inv.addWeapon(10, Skill.DART);

		// FINAL STEP
		actor.setInventory(inv);
	}

	public static void apply(int level, Hero actor) {
		EnumSet<ClassFeature> features = actor.getClassFeatures();

		Subclass subclass = actor.getSubclass();
		switch (level) {
		case 1:
			features.add(ClassFeature.UNARMORED_MONK);
			features.add(ClassFeature.MARTIAL_ARTS_D4);

			break;
		case 2:
			features.add(ClassFeature.MONK_MOVE_2);
			features.add(ClassFeature.KI_POWERS);
			features.add(ClassFeature.FLURRY_OF_BLOWS);
			features.add(ClassFeature.PATIENT_DEFENSE);
			features.add(ClassFeature.STEP_OF_THE_WIND);

			break;
		case 3:
			features.add(ClassFeature.DEFLECT_MISSILES);

			/*
			 * MONASTIC TRADITION
			 */
			if (subclass.equals(Subclass.OPEN_HAND)) {
				features.add(ClassFeature.OPEN_HAND_TECHNIQUE);

			} else if (subclass.equals(Subclass.SHADOW_WAY)) {
				features.add(ClassFeature.SHADOW_ARTS);
				Misc.tryToAdd(Spell.MINOR_ILLUSION, actor.getCantripsKnown());

			} else if (subclass.equals(Subclass.FOUR_ELEMENTS)) {
				features.add(ClassFeature.ELEMENTAL_ATTUNEMENT);
				Misc.tryToAddOne(ELEMENTAL_DISCIPLINE[0], features);

			}

			break;
		case 4:
			features.add(ClassFeature.SLOW_FALL);

			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_4);
			improveAbility(actor);

			break;
		case 5:
			features.add(ClassFeature.MARTIAL_ARTS_D6);
			features.add(ClassFeature.EXTRA_ATTACK_1);
			features.add(ClassFeature.STUNNING_STRIKE);

			break;
		case 6:
			features.add(ClassFeature.MONK_MOVE_6);
			features.add(ClassFeature.KI_STRIKE);

			/*
			 * MONASTIC TRADITION
			 */
			if (subclass.equals(Subclass.OPEN_HAND)) {
				features.add(ClassFeature.WHOLENESS_OF_BODY);

			} else if (subclass.equals(Subclass.SHADOW_WAY)) {
				features.add(ClassFeature.SHADOW_STEP);

			} else if (subclass.equals(Subclass.FOUR_ELEMENTS)) {
				Misc.tryToAddOne(ELEMENTAL_DISCIPLINE[1], features);

			}

			break;
		case 7:
			features.add(ClassFeature.EVASION);
			features.add(ClassFeature.STILLNESS_OF_MIND);

			break;
		case 8:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_8);
			improveAbility(actor);

			break;
		case 9:
			features.add(ClassFeature.WALL_RUNNING);

			break;
		case 10:
			features.add(ClassFeature.MONK_MOVE_10);
			features.add(ClassFeature.PURITY_OF_BODY);

			break;
		case 11:
			features.add(ClassFeature.MARTIAL_ARTS_D8);

			/*
			 * MONASTIC TRADITION
			 */
			if (subclass.equals(Subclass.OPEN_HAND)) {
				features.add(ClassFeature.TRANQUILITY);

			} else if (subclass.equals(Subclass.SHADOW_WAY)) {
				features.add(ClassFeature.SHADOW_CLOAK);

			} else if (subclass.equals(Subclass.FOUR_ELEMENTS)) {
				Misc.tryToAddOne(ELEMENTAL_DISCIPLINE[2], features);

			}

			break;
		case 12:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_12);
			improveAbility(actor);

			break;
		case 13:
			features.add(ClassFeature.TONGUE_OF_SUN_MOON);

			break;
		case 14:
			features.add(ClassFeature.MONK_MOVE_14);
			features.add(ClassFeature.DIAMOND_SOUL);

			break;
		case 15:
			features.add(ClassFeature.TIMELESS_BODY);

			break;
		case 16:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_16);
			improveAbility(actor);

			break;
		case 17:
			features.add(ClassFeature.MARTIAL_ARTS_D10);

			/*
			 * MONASTIC TRADITION
			 */
			if (subclass.equals(Subclass.OPEN_HAND)) {
				features.add(ClassFeature.QUIVERING_PALM);

			} else if (subclass.equals(Subclass.SHADOW_WAY)) {
				features.add(ClassFeature.OPPORTUNIST);

			} else if (subclass.equals(Subclass.FOUR_ELEMENTS)) {
				Misc.tryToAddOne(ELEMENTAL_DISCIPLINE[3], features);

			}
			break;
		case 18:
			features.add(ClassFeature.MONK_MOVE_18);
			features.add(ClassFeature.EMPTY_BODY);

			break;
		case 19:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_19);
			improveAbility(actor);

			break;
		case 20:
			features.add(ClassFeature.PERFECT_SELF);

			break;
		}

		actor.setClassFeatures(features);
	}
}
