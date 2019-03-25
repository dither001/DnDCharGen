package com.dnd5e.character.classes;

import java.util.EnumSet;

import com.dnd5e.definitions.*;
import com.dnd5e.magic.*;
import com.miscellaneous.util.*;

public class Druid extends JobClass {
	private static final DnDClass CLAZZ;
	private static final RacialFeature[] SAVING_THROWS;
	private static final Skill[] CLASS_SKILLS;
	private static final int NUMBER_OF_SKILLS;

	static {
		CLAZZ = DnDClass.DRUID;
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
		Misc.tryToAdd(NUMBER_OF_SKILLS, CLASS_SKILLS, actor.getCommonSkills());
		Misc.tryToAdd(Skill.HERBALISM_KIT, actor.getSpecialSkills());

		actor.getArmorSkills().addAll(Skill.lightAndMediumArmorList());
		actor.getArmorSkills().add(Skill.SHIELD);
		actor.getWeaponSkills().addAll(Skill.druidWeapons());

		// MAGIC SETUP
		Spell.addCantrip(2, CLAZZ, actor.getCantripsKnown());
		actor.getClassFeatures().add(ClassFeature.RITUAL_CASTING_DRUID);
	}

	public static void apply(int level, Hero actor) {
		EnumSet<ClassFeature> features = actor.getClassFeatures();

		Subclass subclass = actor.getSubclass();
		switch (level) {
		case 1:
			Misc.tryToAdd(Language.DRUIDIC, actor.getLanguages());
			break;
		case 2:
			if (subclass.equals(Subclass.LAND_CIRCLE)) {
				Spell.addCantrip(CLAZZ, actor.getCantripsKnown());
				features.add(ClassFeature.WILD_SHAPE_2);
				features.add(ClassFeature.NATURAL_RECOVERY);

			} else if (subclass.equals(Subclass.MOON_CIRCLE)) {
				features.add(ClassFeature.MOON_SHAPE_2);
				features.add(ClassFeature.COMBAT_WILD_SHAPE);

			}

			break;
		case 3:
			break;
		case 4:
			// NEW CANTRIP
			Spell.addCantrip(CLAZZ, actor.getCantripsKnown());

			if (subclass.equals(Subclass.MOON_CIRCLE) != true) {
				features.add(ClassFeature.WILD_SHAPE_4);
			}

			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_4);
			improveAbility(actor);

			break;
		case 5:
			break;
		case 6:
			if (subclass.equals(Subclass.LAND_CIRCLE)) {
				features.add(ClassFeature.LANDS_STRIDE);

			} else if (subclass.equals(Subclass.MOON_CIRCLE)) {
				features.add(ClassFeature.MOON_SHAPE_6);
				features.add(ClassFeature.PRIMAL_STRIKE);

			}

			break;
		case 7:
			break;
		case 8:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_8);
			improveAbility(actor);

			break;
		case 9:
			if (subclass.equals(Subclass.MOON_CIRCLE)) {
				features.add(ClassFeature.MOON_SHAPE_9);
			}

			break;
		case 10:
			// NEW CANTRIP
			Spell.addCantrip(CLAZZ, actor.getCantripsKnown());

			if (subclass.equals(Subclass.LAND_CIRCLE)) {
				features.add(ClassFeature.NATURES_WARD);

			} else if (subclass.equals(Subclass.MOON_CIRCLE)) {
				features.add(ClassFeature.ELEMENTAL_SHAPE);

			}

			break;
		case 11:
			break;
		case 12:
			if (subclass.equals(Subclass.MOON_CIRCLE)) {
				features.add(ClassFeature.MOON_SHAPE_12);
			}

			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_12);
			improveAbility(actor);

			break;
		case 13:
			break;
		case 14:
			if (subclass.equals(Subclass.LAND_CIRCLE)) {
				features.add(ClassFeature.NATURES_SANCTUARY);

			} else if (subclass.equals(Subclass.MOON_CIRCLE)) {
				features.add(ClassFeature.THOUSAND_FORMS);

			}

			break;
		case 15:
			if (subclass.equals(Subclass.MOON_CIRCLE)) {
				features.add(ClassFeature.MOON_SHAPE_15);
			}

			break;
		case 16:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_16);
			improveAbility(actor);

			break;
		case 17:
			break;
		case 18:
			if (subclass.equals(Subclass.MOON_CIRCLE)) {
				features.add(ClassFeature.MOON_SHAPE_18);
			}

			features.add(ClassFeature.TIMELESS_BODY);
			features.add(ClassFeature.BEAST_SPELLS);

			break;
		case 19:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_19);
			improveAbility(actor);

			break;
		case 20:
			features.add(ClassFeature.ARCHDRUID);

			break;
		}

		actor.setClassFeatures(features);
	}

}
