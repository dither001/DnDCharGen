package com.dnd5e.character.classes;

import java.util.EnumSet;

import com.dnd5e.definitions.*;

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

	protected static final ClassFeature[] EXPERTISE = { ClassFeature.EXPERTISE_ATHLETICS,
			ClassFeature.EXPERTISE_ACROBATICS, ClassFeature.EXPERTISE_SLEIGHT_OF_HAND, ClassFeature.EXPERTISE_STEALTH,
			ClassFeature.EXPERTISE_ARCANA, ClassFeature.EXPERTISE_HISTORY, ClassFeature.EXPERTISE_INVESTIGATION,
			ClassFeature.EXPERTISE_NATURE, ClassFeature.EXPERTISE_RELIGION, ClassFeature.EXPERTISE_ANIMAL_HANDLING,
			ClassFeature.EXPERTISE_INSIGHT, ClassFeature.EXPERTISE_MEDICINE, ClassFeature.EXPERTISE_PERCEPTION,
			ClassFeature.EXPERTISE_SURVIVAL, ClassFeature.EXPERTISE_DECEPTION, ClassFeature.EXPERTISE_INTIMIDATION,
			ClassFeature.EXPERTISE_PERFORMANCE, ClassFeature.EXPERTISE_PERSUASION,
			ClassFeature.EXPERTISE_THIEVES_TOOLS };

	/*
	 * STATIC METHODS
	 */
	public static void apply(int level, Hero actor) {
		System.out.println("Not implemented.");

		EnumSet<RacialFeature> racialFeatures = actor.getFeatures();
		EnumSet<ClassFeature> classFeatures = actor.getClassFeatures();

		Subclass subclass = actor.getSubclass();
		switch (level) {
		case 1:
			racialFeatures.add(RacialFeature.STRENGTH_SAVE);
			racialFeatures.add(RacialFeature.CONSTITUTION_SAVE);
			//

			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			//
			classFeatures.add(ClassFeature.ABILITY_BONUS_4);
			enhanceAbility(actor);

			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			//
			classFeatures.add(ClassFeature.ABILITY_BONUS_8);
			enhanceAbility(actor);

			break;
		case 9:
			break;
		case 10:
			break;
		case 11:
			break;
		case 12:
			//
			classFeatures.add(ClassFeature.ABILITY_BONUS_12);
			enhanceAbility(actor);

			break;
		case 13:
			break;
		case 14:
			break;
		case 15:
			break;
		case 16:
			//
			classFeatures.add(ClassFeature.ABILITY_BONUS_16);
			enhanceAbility(actor);

			break;
		case 17:
			break;
		case 18:
			break;
		case 19:
			//
			classFeatures.add(ClassFeature.ABILITY_BONUS_19);
			enhanceAbility(actor);

			break;
		case 20:
			break;
		}

		actor.setFeatures(racialFeatures);
		actor.setClassFeatures(classFeatures);
	}

	public static void enhanceAbility(Adventurer actor) {
		// TODO

	}


}
