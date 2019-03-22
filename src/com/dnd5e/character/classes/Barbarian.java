package com.dnd5e.character.classes;

import java.util.EnumSet;

import com.dnd5e.definitions.*;
import com.miscellaneous.util.*;

public abstract class Barbarian extends JobClass {
	private static final DnDClass CLAZZ = DnDClass.BARBARIAN;

	//
	private static final RacialFeature[] SAVING_THROWS = DnDClass.getSavingThrows(CLAZZ);
	private static final Skill[] CLASS_SKILLS = Skill.getClassSkills(CLAZZ);
	private static int NUMBER_OF_SKILLS = DnDClass.getNumberOfSkills(CLAZZ);

	/*
	 * STATIC METHODS
	 */
	public static void setup(Hero actor) {
		// CLASS FEATURES
		apply(1, actor);

		// SAVING THROWS
		actor.getFeatures().addAll(Misc.arrayToList(SAVING_THROWS));

		// SKILLS & WEAPON/ARMOR PROFICIENCY
		Misc.tryToAdd(NUMBER_OF_SKILLS, CLASS_SKILLS, actor.getCommonSkills());
		actor.getArmorSkills().addAll(Skill.lightAndMediumArmorList());
		actor.getArmorSkills().add(Skill.SHIELD);
		actor.getWeaponSkills().addAll(Skill.allWeaponList());

	}

	public static void apply(int level, Hero actor) {
		EnumSet<RacialFeature> racialFeatures = actor.getFeatures();
		EnumSet<ClassFeature> classFeatures = actor.getClassFeatures();

		Subclass subclass = actor.getSubclass();
		switch (level) {
		case 1:
			//
			classFeatures.add(ClassFeature.RAGE);
			classFeatures.add(ClassFeature.RAGE_PER_DAY_2);
			classFeatures.add(ClassFeature.RAGE_BONUS_2);
			classFeatures.add(ClassFeature.UNARMORED_BARBARIAN);

			break;
		case 2:
			classFeatures.add(ClassFeature.RECKLESS_ATTACK);
			classFeatures.add(ClassFeature.DANGER_SENSE);

			break;
		case 3:
			classFeatures.add(ClassFeature.RAGE_PER_DAY_3);

			/*
			 * PRIMAL PATH
			 */
			if (subclass.equals(Subclass.BERSERKER)) {
				classFeatures.add(ClassFeature.FRENZY);

			} else if (subclass.equals(Subclass.BEAR_TOTEM)) {
				classFeatures.add(ClassFeature.SPIRIT_SEEKER);
				classFeatures.add(ClassFeature.BEAR_SPIRIT_3);

			} else if (subclass.equals(Subclass.EAGLE_TOTEM)) {
				classFeatures.add(ClassFeature.SPIRIT_SEEKER);
				classFeatures.add(ClassFeature.EAGLE_SPIRIT_3);

			} else if (subclass.equals(Subclass.WOLF_TOTEM)) {
				classFeatures.add(ClassFeature.SPIRIT_SEEKER);
				classFeatures.add(ClassFeature.WOLF_SPIRIT_3);

			}

			break;
		case 4:
			// ABILTIY SCORE IMPROVEMENT
			classFeatures.add(ClassFeature.ABILITY_BONUS_4);
			improveAbility(actor);

			break;
		case 5:
			classFeatures.add(ClassFeature.RAGE_PER_DAY_4);
			//
			classFeatures.add(ClassFeature.EXTRA_ATTACK_1);
			classFeatures.add(ClassFeature.FAST_MOVEMENT);

			break;
		case 6:
			/*
			 * PRIMAL PATH
			 */
			if (subclass.equals(Subclass.BERSERKER)) {
				classFeatures.add(ClassFeature.MINDLESS_RAGE);

			} else if (subclass.equals(Subclass.BEAR_TOTEM)) {
				classFeatures.add(ClassFeature.BEAR_ASPECT_6);

			} else if (subclass.equals(Subclass.EAGLE_TOTEM)) {
				classFeatures.add(ClassFeature.EAGLE_ASPECT_6);

			} else if (subclass.equals(Subclass.WOLF_TOTEM)) {
				classFeatures.add(ClassFeature.WOLF_ASPECT_6);

			}

			break;
		case 7:
			classFeatures.add(ClassFeature.FERAL_INSTINCT);

			break;
		case 8:
			// ABILTIY SCORE IMPROVEMENT
			classFeatures.add(ClassFeature.ABILITY_BONUS_8);
			improveAbility(actor);

			break;
		case 9:
			classFeatures.add(ClassFeature.RAGE_BONUS_3);
			//
			classFeatures.add(ClassFeature.BRUTAL_CRITICAL_1);

			break;
		case 10:
			/*
			 * PRIMAL PATH
			 */
			if (subclass.equals(Subclass.BERSERKER)) {
				classFeatures.add(ClassFeature.INTIMIDATING_PRESENCE);

			} else if (subclass.equals(Subclass.BEAR_TOTEM)) {
				classFeatures.add(ClassFeature.SPIRIT_WALKER);

			} else if (subclass.equals(Subclass.EAGLE_TOTEM)) {
				classFeatures.add(ClassFeature.SPIRIT_WALKER);

			} else if (subclass.equals(Subclass.WOLF_TOTEM)) {
				classFeatures.add(ClassFeature.SPIRIT_WALKER);

			}

			break;
		case 11:
			classFeatures.add(ClassFeature.RELENTLESS_RAGE);

			break;
		case 12:
			classFeatures.add(ClassFeature.RAGE_PER_DAY_5);
			// ABILTIY SCORE IMPROVEMENT
			classFeatures.add(ClassFeature.ABILITY_BONUS_12);
			improveAbility(actor);

			break;
		case 13:
			classFeatures.add(ClassFeature.BRUTAL_CRITICAL_2);

			break;
		case 14:
			/*
			 * PRIMAL PATH
			 */
			if (subclass.equals(Subclass.BERSERKER)) {
				classFeatures.add(ClassFeature.RETALIATION);

			} else if (subclass.equals(Subclass.BEAR_TOTEM)) {
				classFeatures.add(ClassFeature.BEAR_ATTUNEMENT_14);

			} else if (subclass.equals(Subclass.EAGLE_TOTEM)) {
				classFeatures.add(ClassFeature.EAGLE_ATTUNEMENT_14);

			} else if (subclass.equals(Subclass.WOLF_TOTEM)) {
				classFeatures.add(ClassFeature.WOLF_ATTUNEMENT_14);

			}

			break;
		case 15:
			classFeatures.add(ClassFeature.PERSISTENT_RAGE);

			break;
		case 16:
			classFeatures.add(ClassFeature.RAGE_BONUS_4);
			// ABILTIY SCORE IMPROVEMENT
			classFeatures.add(ClassFeature.ABILITY_BONUS_16);
			improveAbility(actor);

			break;
		case 17:
			classFeatures.add(ClassFeature.BRUTAL_CRITICAL_3);
			classFeatures.add(ClassFeature.RAGE_PER_DAY_6);

			break;
		case 18:
			classFeatures.add(ClassFeature.INDOMITABLE_MIGHT);

			break;
		case 19:
			// ABILTIY SCORE IMPROVEMENT
			classFeatures.add(ClassFeature.ABILITY_BONUS_19);
			improveAbility(actor);

			break;
		case 20:
			classFeatures.add(ClassFeature.RAGE_PER_DAY_99);
			//
			classFeatures.add(ClassFeature.PRIMAL_CHAMPION);

			break;
		}

		actor.setFeatures(racialFeatures);
		actor.setClassFeatures(classFeatures);
	}

}
