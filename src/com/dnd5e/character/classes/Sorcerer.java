package com.dnd5e.character.classes;

import java.util.EnumSet;

import com.dnd5e.definitions.*;
import com.dnd5e.magic.*;
import com.miscellaneous.util.*;

public abstract class Sorcerer extends JobClass {
	private static final DnDClass CLAZZ;
	private static final RacialFeature[] SAVING_THROWS;
	private static final Skill[] CLASS_SKILLS;
	private static final int NUMBER_OF_SKILLS;

	//
	private static final ClassFeature[] ANCESTRY;
	private static final ClassFeature[] METAMAGIC;

	static {
		CLAZZ = DnDClass.SORCERER;
		SAVING_THROWS = DnDClass.getSavingThrows(CLAZZ);
		CLASS_SKILLS = Skill.getClassSkills(CLAZZ);
		NUMBER_OF_SKILLS = DnDClass.getNumberOfSkills(CLAZZ);

		//
		ANCESTRY = new ClassFeature[] { ClassFeature.ANCESTRY_RED, ClassFeature.ANCESTRY_BLACK,
				ClassFeature.ANCESTRY_BLUE, ClassFeature.ANCESTRY_GREEN, ClassFeature.ANCESTRY_WHITE,
				ClassFeature.ANCESTRY_GOLD, ClassFeature.ANCESTRY_SILVER, ClassFeature.ANCESTRY_BRONZE,
				ClassFeature.ANCESTRY_COPPER, ClassFeature.ANCESTRY_BRASS };
		METAMAGIC = new ClassFeature[] { ClassFeature.CAREFUL_SPELL, ClassFeature.DISTANCE_SPELL,
				ClassFeature.EMPOWERED_SPELL, ClassFeature.EXTENDED_SPELL, ClassFeature.HEIGHTENED_SPELL,
				ClassFeature.QUICKENED_SPELL, ClassFeature.SUBTLE_SPELL, ClassFeature.TWINNED_SPELL };
	}

	public static void setup(Hero actor) {
		// CLASS FEATURES
		apply(1, actor);

		// SAVING THROWS
		actor.getFeatures().addAll(Misc.arrayToList(SAVING_THROWS));

		// SKILLS & WEAPON/ARMOR PROFICIENCY
		Misc.tryToAdd(NUMBER_OF_SKILLS, CLASS_SKILLS, actor.getCommonSkills());

		actor.getWeaponSkills().addAll(Skill.wizardWeapons());

		Spell.addCantrip(4, CLAZZ, actor.getCantripsKnown());
		Spell.addSpell(2, 1, CLAZZ, actor.getSpellsKnown());
		actor.getSpecialSkills().add(Skill.ARCANE_FOCUS);
	}

	public static void apply(int level, Hero actor) {
		EnumSet<ClassFeature> features = actor.getClassFeatures();

		Subclass subclass = actor.getSubclass();
		switch (level) {
		case 1:

			/*
			 * SORCEROUS ORIGIN
			 */
			if (subclass.equals(Subclass.DRAGON_ORIGIN)) {
				actor.getLanguages().add(Language.DRACONIC);
				features.add(ClassFeature.DRACONIC_RESILIENCE);

				// CHOOSE ANCESTRY
				ClassFeature ancestry = Misc.randomFromArray(ANCESTRY);
				features.add(ancestry);
				addAncestry(ancestry, actor);

			} else if (subclass.equals(Subclass.CHAOS_ORIGIN)) {
				features.add(ClassFeature.WILD_MAGIC_SURGE);
				features.add(ClassFeature.TIDES_OF_CHAOS);

			}

			break;
		case 2:
			// SPELLS KNOWN
			Spell.addSpell(1, CLAZZ, actor.getSpellsKnown());

			features.add(ClassFeature.FONT_OF_MAGIC);
			features.add(ClassFeature.FLEXIBLE_CASTING);

			break;
		case 3:
			// SPELLS KNOWN
			Spell.addSpell(2, CLAZZ, actor.getSpellsKnown());

			// METAMAGIC
			Misc.tryToAdd(2, METAMAGIC, features);

			break;
		case 4:
			// SPELLS KNOWN
			Spell.addSpell(2, CLAZZ, actor.getSpellsKnown());

			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_4);
			improveAbility(actor);

			break;
		case 5:
			// SPELLS KNOWN
			Spell.addSpell(3, CLAZZ, actor.getSpellsKnown());

			break;
		case 6:
			// SPELLS KNOWN
			Spell.addSpell(3, CLAZZ, actor.getSpellsKnown());

			/*
			 * SORCEROUS ORIGIN
			 */
			if (subclass.equals(Subclass.DRAGON_ORIGIN)) {
				features.add(ClassFeature.ELEMENTAL_AFFINITY);

			} else if (subclass.equals(Subclass.CHAOS_ORIGIN)) {
				features.add(ClassFeature.BEND_LUCK);

			}

			break;
		case 7:
			// SPELLS KNOWN
			Spell.addSpell(4, CLAZZ, actor.getSpellsKnown());

			break;
		case 8:
			// SPELLS KNOWN
			Spell.addSpell(4, CLAZZ, actor.getSpellsKnown());

			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_8);
			improveAbility(actor);

			break;
		case 9:
			// SPELLS KNOWN
			Spell.addSpell(5, CLAZZ, actor.getSpellsKnown());

			break;
		case 10:
			// SPELLS KNOWN
			Spell.addSpell(5, CLAZZ, actor.getSpellsKnown());

			// METAMAGIC
			Misc.tryToAdd(METAMAGIC, features);

			break;
		case 11:
			// SPELLS KNOWN
			Spell.addSpell(6, CLAZZ, actor.getSpellsKnown());

			break;
		case 12:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_12);
			improveAbility(actor);

			break;
		case 13:
			// SPELLS KNOWN
			Spell.addSpell(7, CLAZZ, actor.getSpellsKnown());

			break;
		case 14:
			/*
			 * SORCEROUS ORIGIN
			 */
			if (subclass.equals(Subclass.DRAGON_ORIGIN)) {
				features.add(ClassFeature.DRAGON_WINGS);

			} else if (subclass.equals(Subclass.CHAOS_ORIGIN)) {
				features.add(ClassFeature.CONTROLLED_CHAOS);

			}

			break;
		case 15:
			// SPELLS KNOWN
			Spell.addSpell(8, CLAZZ, actor.getSpellsKnown());

			break;
		case 16:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_16);
			improveAbility(actor);

			break;
		case 17:
			// SPELLS KNOWN
			Spell.addSpell(9, CLAZZ, actor.getSpellsKnown());

			// METAMAGIC
			Misc.tryToAdd(METAMAGIC, features);

			break;
		case 18:
			/*
			 * SORCEROUS ORIGIN
			 */
			if (subclass.equals(Subclass.DRAGON_ORIGIN)) {
				features.add(ClassFeature.DRACONIC_PRESENCE);

			} else if (subclass.equals(Subclass.CHAOS_ORIGIN)) {
				features.add(ClassFeature.SPELL_BOMBARDMENT);

			}

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

	@SuppressWarnings("incomplete-switch")
	private static void addAncestry(ClassFeature ancestry, Hero actor) {
		EnumSet<ClassFeature> classFeatures = actor.getClassFeatures();

		switch (ancestry) {
		case ANCESTRY_BLACK:
		case ANCESTRY_COPPER:
			classFeatures.add(ClassFeature.ANCESTRY_ACID);
			break;
		case ANCESTRY_BLUE:
		case ANCESTRY_BRONZE:
			classFeatures.add(ClassFeature.ANCESTRY_LIGHTNING);
			break;
		case ANCESTRY_BRASS:
		case ANCESTRY_GOLD:
		case ANCESTRY_RED:
			classFeatures.add(ClassFeature.ANCESTRY_FIRE);
			break;
		case ANCESTRY_GREEN:
			classFeatures.add(ClassFeature.ANCESTRY_POISON);
			break;
		case ANCESTRY_SILVER:
		case ANCESTRY_WHITE:
			classFeatures.add(ClassFeature.ANCESTRY_COLD);
			break;
		}

		actor.setClassFeatures(classFeatures);
	}
}
