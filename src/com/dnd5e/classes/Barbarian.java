package com.dnd5e.classes;

import java.util.EnumSet;

import com.dnd5e.characters.*;
import com.dnd5e.definitions.skills.Skill;
import com.dnd5e.equipment.*;
import com.miscellaneous.util.*;

public abstract class Barbarian extends JobClass {
	private static final DnDClass CLAZZ;
	private static final RacialFeature[] SAVING_THROWS;
	private static final Skill[] CLASS_SKILLS;
	private static final int NUMBER_OF_SKILLS;

	static {
		CLAZZ = DnDClass.BARBARIAN;
		SAVING_THROWS = DnDClass.getSavingThrows(CLAZZ);
		CLASS_SKILLS = Skill.getClassSkills(CLAZZ);
		NUMBER_OF_SKILLS = DnDClass.getNumberOfSkills(CLAZZ);
	}

	/*
	 * STATIC METHODS
	 */
	public static void setup(Hero actor) {
		// CLASS FEATURES
		apply(1, actor);

		// SAVING THROWS
		actor.getFeatures().addAll(Misc.arrayToList(SAVING_THROWS));

		// SKILLS & WEAPON/ARMOR PROFICIENCY
		Misc.tryToAddN(NUMBER_OF_SKILLS, CLASS_SKILLS, actor.getCommonSkills());

		actor.getArmorSkills().addAll(Skill.lightAndMediumArmorList());
		actor.getArmorSkills().add(Skill.SHIELD);
		actor.getWeaponSkills().addAll(Skill.allWeaponList());

	}

	public static void setupStartingGear(Hero actor) {
		/*
		 * INVENTORY
		 */
		Inventory inv = actor.getInventory();

		// FIRST CHOICE
		int dice = Dice.roll(2);
		if (actor.isMedium() && dice == 1) {
			inv.addWeaponHelper(Skill.GREATAXE);

		} else {
			inv.addWeaponHelper(Skill.randomMilitaryMelee());

		}

		// SECOND CHOICE
		dice = Dice.roll(2);
		if (dice == 1) {
			inv.addWeaponHelper(Skill.HANDAXE);
			inv.addWeaponHelper(Skill.HANDAXE);

		} else {
			inv.addWeaponHelper(Skill.randomSimpleWeapon());

		}

		// TODO - add explorer's pack

		// 4 javelins
		inv.addWeaponHelper(4, Skill.JAVELIN);

		// FINAL STEP
		actor.setInventory(inv);
	}

	public static void apply(int level, Hero actor) {
		EnumSet<ClassFeature> features = actor.getClassFeatures();

		Subclass subclass = actor.getSubclass();
		switch (level) {
		case 1:
			//
			features.add(ClassFeature.RAGE);
			features.add(ClassFeature.RAGE_PER_DAY_2);
			features.add(ClassFeature.RAGE_BONUS_2);
			features.add(ClassFeature.UNARMORED_BARBARIAN);

			break;
		case 2:
			features.add(ClassFeature.RECKLESS_ATTACK);
			features.add(ClassFeature.DANGER_SENSE);

			break;
		case 3:
			features.add(ClassFeature.RAGE_PER_DAY_3);

			/*
			 * PRIMAL PATH
			 */
			if (subclass.equals(Subclass.BERSERKER)) {
				features.add(ClassFeature.FRENZY);

			} else if (subclass.equals(Subclass.BEAR_TOTEM)) {
				features.add(ClassFeature.SPIRIT_SEEKER);
				features.add(ClassFeature.BEAR_SPIRIT_3);

			} else if (subclass.equals(Subclass.EAGLE_TOTEM)) {
				features.add(ClassFeature.SPIRIT_SEEKER);
				features.add(ClassFeature.EAGLE_SPIRIT_3);

			} else if (subclass.equals(Subclass.WOLF_TOTEM)) {
				features.add(ClassFeature.SPIRIT_SEEKER);
				features.add(ClassFeature.WOLF_SPIRIT_3);

			}

			break;
		case 4:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_4);
			improveAbility(actor);

			break;
		case 5:
			features.add(ClassFeature.EXTRA_ATTACK_1);
			features.add(ClassFeature.FAST_MOVEMENT);

			break;
		case 6:
			features.add(ClassFeature.RAGE_PER_DAY_4);

			/*
			 * PRIMAL PATH
			 */
			if (subclass.equals(Subclass.BERSERKER)) {
				features.add(ClassFeature.MINDLESS_RAGE);

			} else if (subclass.equals(Subclass.BEAR_TOTEM)) {
				features.add(ClassFeature.BEAR_ASPECT_6);

			} else if (subclass.equals(Subclass.EAGLE_TOTEM)) {
				features.add(ClassFeature.EAGLE_ASPECT_6);

			} else if (subclass.equals(Subclass.WOLF_TOTEM)) {
				features.add(ClassFeature.WOLF_ASPECT_6);

			}

			break;
		case 7:
			features.add(ClassFeature.FERAL_INSTINCT);

			break;
		case 8:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_8);
			improveAbility(actor);

			break;
		case 9:
			features.add(ClassFeature.RAGE_BONUS_3);
			//
			features.add(ClassFeature.BRUTAL_CRITICAL_1);

			break;
		case 10:
			/*
			 * PRIMAL PATH
			 */
			if (subclass.equals(Subclass.BERSERKER)) {
				features.add(ClassFeature.INTIMIDATING_PRESENCE);

			} else if (subclass.equals(Subclass.BEAR_TOTEM)) {
				features.add(ClassFeature.SPIRIT_WALKER);

			} else if (subclass.equals(Subclass.EAGLE_TOTEM)) {
				features.add(ClassFeature.SPIRIT_WALKER);

			} else if (subclass.equals(Subclass.WOLF_TOTEM)) {
				features.add(ClassFeature.SPIRIT_WALKER);

			}

			break;
		case 11:
			features.add(ClassFeature.RELENTLESS_RAGE);

			break;
		case 12:
			features.add(ClassFeature.RAGE_PER_DAY_5);

			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_12);
			improveAbility(actor);

			break;
		case 13:
			features.add(ClassFeature.BRUTAL_CRITICAL_2);

			break;
		case 14:
			/*
			 * PRIMAL PATH
			 */
			if (subclass.equals(Subclass.BERSERKER)) {
				features.add(ClassFeature.RETALIATION);

			} else if (subclass.equals(Subclass.BEAR_TOTEM)) {
				features.add(ClassFeature.BEAR_ATTUNEMENT_14);

			} else if (subclass.equals(Subclass.EAGLE_TOTEM)) {
				features.add(ClassFeature.EAGLE_ATTUNEMENT_14);

			} else if (subclass.equals(Subclass.WOLF_TOTEM)) {
				features.add(ClassFeature.WOLF_ATTUNEMENT_14);

			}

			break;
		case 15:
			features.add(ClassFeature.PERSISTENT_RAGE);

			break;
		case 16:
			features.add(ClassFeature.RAGE_BONUS_4);

			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_16);
			improveAbility(actor);

			break;
		case 17:
			features.add(ClassFeature.BRUTAL_CRITICAL_3);
			features.add(ClassFeature.RAGE_PER_DAY_6);

			break;
		case 18:
			features.add(ClassFeature.INDOMITABLE_MIGHT);

			break;
		case 19:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_19);
			improveAbility(actor);

			break;
		case 20:
			features.add(ClassFeature.RAGE_PER_DAY_99);
			//
			features.add(ClassFeature.PRIMAL_CHAMPION);

			break;
		}

		actor.setClassFeatures(features);
	}

}
