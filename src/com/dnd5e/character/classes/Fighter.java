package com.dnd5e.character.classes;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import com.dnd5e.definitions.*;
import com.dnd5e.magic.*;
import com.miscellaneous.util.*;

public abstract class Fighter extends JobClass {
	private static final DnDClass CLAZZ;
	private static final RacialFeature[] SAVING_THROWS;
	private static final Skill[] CLASS_SKILLS;
	private static final int NUMBER_OF_SKILLS;

	//
	private static final DnDClass CASTING_CLASS;
	private static final School[] ELDRITCH_KNIGHT_SCHOOLS;

	//
	private static final ClassFeature[] FIGHTING_STYLE;
	private static final ClassFeature[] MANEUVERS;

	static {
		CLAZZ = DnDClass.FIGHTER;
		SAVING_THROWS = DnDClass.getSavingThrows(CLAZZ);
		CLASS_SKILLS = Skill.getClassSkills(CLAZZ);
		NUMBER_OF_SKILLS = DnDClass.getNumberOfSkills(CLAZZ);

		//
		CASTING_CLASS = DnDClass.WIZARD;
		ELDRITCH_KNIGHT_SCHOOLS = new School[] { School.ABJURATION, School.EVOCATION };

		//
		FIGHTING_STYLE = new ClassFeature[] { ClassFeature.STYLE_ARCHERY, ClassFeature.STYLE_DEFENSE,
				ClassFeature.STYLE_DUELING, ClassFeature.STYLE_GREAT_WEAPON, ClassFeature.STYLE_PROTECTION,
				ClassFeature.STYLE_TWO_WEAPON };
		MANEUVERS = new ClassFeature[] { ClassFeature.COMMANDERS_STRIKE, ClassFeature.DISARMING_ATTACK,
				ClassFeature.DISTRACTING_STRIKE, ClassFeature.EVASIVE_FOOTWORK, ClassFeature.FEINTING_ATTACK,
				ClassFeature.GOADING_ATTACK, ClassFeature.LUNGING_ATTACK, ClassFeature.MANEUVERING_ATTACK,
				ClassFeature.MENACING_ATTACK, ClassFeature.PARRY, ClassFeature.PRECISION_ATTACK,
				ClassFeature.PUSHING_ATTACK, ClassFeature.RALLY, ClassFeature.RIPOSTE, ClassFeature.SWEEPING_ATTACK,
				ClassFeature.TRIP_ATTACK };
	}

	public static void setup(Hero actor) {
		// CLASS FEATURES
		apply(1, actor);

		// SAVING THROWS
		actor.getFeatures().addAll(Misc.arrayToList(SAVING_THROWS));

		// SKILLS & WEAPON/ARMOR PROFICIENCY
		Misc.tryToAdd(NUMBER_OF_SKILLS, CLASS_SKILLS, actor.getCommonSkills());

		actor.getArmorSkills().addAll(Skill.allArmorList());
		actor.getArmorSkills().add(Skill.SHIELD);
		actor.getWeaponSkills().addAll(Skill.allWeaponList());
	}

	public static void apply(int level, Hero actor) {
		EnumSet<ClassFeature> features = actor.getClassFeatures();

		Subclass subclass = actor.getSubclass();
		switch (level) {
		case 1:
			features.add(ClassFeature.FIGHTING_STYLE);
			features.add(Misc.randomFromArray(FIGHTING_STYLE));
			features.add(ClassFeature.SECOND_WIND);

			break;
		case 2:
			features.add(ClassFeature.ACTION_SURGE_2);

			break;
		case 3:

			/*
			 * MARTIAL ARCHETYPE
			 */
			if (subclass.equals(Subclass.CHAMPION)) {
				features.add(ClassFeature.IMPROVED_CRITICAL);

			} else if (subclass.equals(Subclass.BATTLE_MASTER)) {
				Misc.tryToAdd(3, MANEUVERS, actor.getClassFeatures());
				features.add(ClassFeature.COMBAT_SUPERIORITY);
				features.add(ClassFeature.SUPERIORITY_D8);
				features.add(ClassFeature.SUPERIORITY_DICE_4);
				features.add(ClassFeature.STUDENT_OF_WAR);

			} else if (subclass.equals(Subclass.ELDRITCH_KNIGHT)) {
				features.add(ClassFeature.WEAPON_BOND);
				addEldritchKnightSpell(3, 1, actor.getSpellsKnown());

			}

			break;
		case 4:
			// ELDRITCH KNIGHT SPELL
			if (subclass.equals(Subclass.ELDRITCH_KNIGHT))
				addEldritchKnightSpell(1, 1, actor.getSpellsKnown());

			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_4);
			improveAbility(actor);

			break;
		case 5:
			break;
		case 6:
			break;
		case 7:

			/*
			 * MARTIAL ARCHETYPE
			 */
			if (subclass.equals(Subclass.CHAMPION)) {
				features.add(ClassFeature.REMARKABLE_ATHLETE);

			} else if (subclass.equals(Subclass.BATTLE_MASTER)) {
				features.add(ClassFeature.SUPERIORITY_DICE_5);
				// TODO - fighter maneuver
				features.add(ClassFeature.KNOW_YOUR_ENEMY);

			} else if (subclass.equals(Subclass.ELDRITCH_KNIGHT)) {
				features.add(ClassFeature.WAR_MAGIC);
				addEldritchKnightSpell(1, 2, actor.getSpellsKnown());

			}

			break;
		case 8:
			// ELDRITCH KNIGHT FREEBIE
			if (subclass.equals(Subclass.ELDRITCH_KNIGHT))
				Spell.addSpell(2, CASTING_CLASS, actor.getSpellsKnown());

			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_8);
			improveAbility(actor);

			break;
		case 9:
			features.add(ClassFeature.INDOMITABLE_1);

			break;
		case 10:

			/*
			 * MARTIAL ARCHETYPE
			 */
			if (subclass.equals(Subclass.CHAMPION)) {
				features.add(ClassFeature.ADDITIONAL_FIGHTING_STYLE);
				// TODO - extra fighting style

			} else if (subclass.equals(Subclass.BATTLE_MASTER)) {
				features.add(ClassFeature.SUPERIORITY_D10);
				// TODO - 2 fighter maneuvers

			} else if (subclass.equals(Subclass.ELDRITCH_KNIGHT)) {
				features.add(ClassFeature.ELDRITCH_STRIKE);
				// TODO - cantrip
				// TODO - new spell

			}

			break;
		case 11:
			features.add(ClassFeature.EXTRA_ATTACK_2);

			// TODO -eldritch knight spell

			break;
		case 12:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_12);
			improveAbility(actor);

			break;
		case 13:
			features.add(ClassFeature.INDOMITABLE_2);

			// TODO - eldritch knight spell

			break;
		case 14:
			// TODO - eldritch knight spell

			// ELDRITCH KNIGHT FREEBIE
			if (subclass.equals(Subclass.ELDRITCH_KNIGHT))
				Spell.addSpell(3, CASTING_CLASS, actor.getSpellsKnown());

			break;
		case 15:

			/*
			 * MARTIAL ARCHETYPE
			 */
			if (subclass.equals(Subclass.CHAMPION)) {
				features.add(ClassFeature.SUPERIOR_CRITICAL);

			} else if (subclass.equals(Subclass.BATTLE_MASTER)) {
				features.add(ClassFeature.SUPERIORITY_DICE_6);
				// TODO - 2 maneuvers
				features.add(ClassFeature.RELENTLESS_FIGHTER);

			} else if (subclass.equals(Subclass.ELDRITCH_KNIGHT)) {
				features.add(ClassFeature.ARCANE_CHARGE);

			}

			break;
		case 16:
			// TODO - eldritch knight spell

			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_16);
			improveAbility(actor);

			break;
		case 17:
			features.add(ClassFeature.ACTION_SURGE_17);
			features.add(ClassFeature.INDOMITABLE_3);

			break;
		case 18:

			/*
			 * MARTIAL ARCHETYPE
			 */
			if (subclass.equals(Subclass.CHAMPION)) {
				features.add(ClassFeature.SURVIVOR);

			} else if (subclass.equals(Subclass.BATTLE_MASTER)) {
				features.add(ClassFeature.SUPERIORITY_D12);

			} else if (subclass.equals(Subclass.ELDRITCH_KNIGHT)) {
				features.add(ClassFeature.IMPROVED_WAR_MAGIC);

			}

			break;
		case 19:
			// TODO - eldritch knight spell

			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_19);
			improveAbility(actor);

			break;
		case 20:
			features.add(ClassFeature.EXTRA_ATTACK_3);

			// ELDRITCH KNIGHT FREEBIE
			if (subclass.equals(Subclass.ELDRITCH_KNIGHT))
				Spell.addSpell(4, CASTING_CLASS, actor.getSpellsKnown());

			break;
		}

		actor.setClassFeatures(features);
	}

	/*
	 * PRIVATE METHODS
	 */
	public static void addEldritchKnightSpell(int n, int level, Set<Spell> spellsKnown) {
		// get initial list
		List<Spell> list = Spell.spellsList(DnDClass.WIZARD);
		// remove duplicates
		list.removeAll(spellsKnown);
		// keep
		list.retainAll(Sorcery.getSpellsOfSchool(level, ELDRITCH_KNIGHT_SCHOOLS));

		Collections.shuffle(list);
		for (int i = 0; i < n; ++i)
			spellsKnown.add(list.get(0));
	}
}
