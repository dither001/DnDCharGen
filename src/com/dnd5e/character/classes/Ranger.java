package com.dnd5e.character.classes;

import java.util.EnumSet;

import com.dnd5e.character.definitions.*;
import com.dnd5e.definitions.*;
import com.dnd5e.gear.equipment.*;
import com.miscellaneous.util.*;

public abstract class Ranger extends JobClass {
	private static final DnDClass CLAZZ;
	private static final RacialFeature[] SAVING_THROWS;
	private static final Skill[] CLASS_SKILLS;
	private static final int NUMBER_OF_SKILLS;

	//
	private static final ClassFeature[] FIGHTING_STYLE;
	private static final ClassFeature[] RANGER_ENEMY;
	private static final ClassFeature[] RANGER_TERRAIN;

	private static final ClassFeature[][] HUNTER_TECHNIQUES;

	static {
		CLAZZ = DnDClass.RANGER;
		SAVING_THROWS = DnDClass.getSavingThrows(CLAZZ);
		CLASS_SKILLS = Skill.getClassSkills(CLAZZ);
		NUMBER_OF_SKILLS = DnDClass.getNumberOfSkills(CLAZZ);

		//
		FIGHTING_STYLE = new ClassFeature[] { ClassFeature.STYLE_ARCHERY, ClassFeature.STYLE_DEFENSE,
				ClassFeature.STYLE_DUELING, ClassFeature.STYLE_TWO_WEAPON };
		RANGER_ENEMY = new ClassFeature[] { ClassFeature.ENEMY_ABERRATIONS, ClassFeature.ENEMY_BEASTS,
				ClassFeature.ENEMY_CELESTIALS, ClassFeature.ENEMY_CONSTRUCTS, ClassFeature.ENEMY_DRAGONS,
				ClassFeature.ENEMY_ELEMENTALS, ClassFeature.ENEMY_FEY, ClassFeature.ENEMY_FIENDS,
				ClassFeature.ENEMY_GIANTS, ClassFeature.ENEMY_MONSTROSITIES, ClassFeature.ENEMY_OOZES,
				ClassFeature.ENEMY_PLANTS, ClassFeature.ENEMY_UNDEAD };
		RANGER_TERRAIN = new ClassFeature[] { ClassFeature.EXPLORER_ARCTIC, ClassFeature.EXPLORER_COAST,
				ClassFeature.EXPLORER_DESERT, ClassFeature.EXPLORER_FOREST, ClassFeature.EXPLORER_GRASSLAND,
				ClassFeature.EXPLORER_MOUNTAIN, ClassFeature.EXPLORER_SWAMP, ClassFeature.EXPLORER_UNDERDARK };
		HUNTER_TECHNIQUES = new ClassFeature[][] {
				{ ClassFeature.COLOSSUS_SLAYER, ClassFeature.GIANT_KILLER, ClassFeature.HORDE_BREAKER },
				{ ClassFeature.ESCAPE_THE_HORDE, ClassFeature.MULTIATTACK_DEFENSE, ClassFeature.STEEL_WILL },
				{ ClassFeature.VOLLEY, ClassFeature.WHIRLWIND_ATTACK },
				{ ClassFeature.EVASION, ClassFeature.STAND_AGAINST_THE_TIDE, ClassFeature.UNCANNY_DODGE } };
	}

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

		int strength = actor.getDexterity();
		int dexterity = actor.getDexterity();

		// FIRST CHOICE
		if (dexterity > 15 || strength < 10) {
			inv.addArmor(Skill.LEATHER_ARMOR);

		} else {
			inv.addArmor(Skill.SCALE_MAIL);

		}

		int dice = Dice.roll(2);
		if (dice == 1) {
			inv.addWeapon(Skill.SHORTSWORD);
			inv.addWeapon(Skill.SHORTSWORD);

		} else {
			inv.randomSimpleWeapon();
			inv.randomSimpleWeapon();

		}

		// THIRD CHOICE
		// TODO - add dungeoneer's or explorer's pack

		// TODO - receive longbow + 20 arrows
		inv.addWeapon(Skill.LONGBOW);
		inv.addAmmunition(Skill.LONGBOW);

		// FINAL STEP
		actor.setInventory(inv);
	}

	public static void apply(int level, Hero actor) {
		EnumSet<ClassFeature> features = actor.getClassFeatures();

		Subclass subclass = actor.getSubclass();
		switch (level) {
		case 1:
			// FAVORED ENEMY & TERRAIN
			Misc.tryToAddOne(RANGER_ENEMY, features);
			Misc.tryToAddOne(RANGER_TERRAIN, features);

			break;
		case 2:
			Misc.tryToAddOne(FIGHTING_STYLE, features);

			break;
		case 3:
			features.add(ClassFeature.PRIMEVAL_AWARENESS);

			/*
			 * RANGER ARCHETYPE
			 */
			if (subclass.equals(Subclass.HUNTER)) {
				Misc.tryToAddOne(HUNTER_TECHNIQUES[0], features);

			} else if (subclass.equals(Subclass.BEAST_MASTER)) {
				features.add(ClassFeature.RANGERS_COMPANION);

			}

			break;
		case 4:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_4);
			improveAbility(actor);

			break;
		case 5:
			features.add(ClassFeature.EXTRA_ATTACK_1);

			break;
		case 6:
			// FAVORED ENEMY & TERRAIN
			Misc.tryToAddOne(RANGER_ENEMY, features);
			Misc.tryToAddOne(RANGER_TERRAIN, features);

			break;
		case 7:

			/*
			 * RANGER ARCHETYPE
			 */
			if (subclass.equals(Subclass.HUNTER)) {
				Misc.tryToAddOne(HUNTER_TECHNIQUES[1], features);

			} else if (subclass.equals(Subclass.BEAST_MASTER)) {
				features.add(ClassFeature.BEAST_TRAINING);

			}

			break;
		case 8:
			features.add(ClassFeature.LANDS_STRIDE);

			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_8);
			improveAbility(actor);

			break;
		case 9:
			break;
		case 10:
			// FAVORED TERRAIN
			Misc.tryToAddOne(RANGER_TERRAIN, features);

			break;
		case 11:

			/*
			 * RANGER ARCHETYPE
			 */
			if (subclass.equals(Subclass.HUNTER)) {
				Misc.tryToAddOne(HUNTER_TECHNIQUES[2], features);

			} else if (subclass.equals(Subclass.BEAST_MASTER)) {
				features.add(ClassFeature.BESTIAL_FURY);

			}

			break;
		case 12:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_12);
			improveAbility(actor);

			break;
		case 13:
			break;
		case 14:
			// FAVORED ENEMY
			Misc.tryToAddOne(RANGER_ENEMY, features);

			features.add(ClassFeature.VANISH);

			break;
		case 15:

			/*
			 * RANGER ARCHETYPE
			 */
			if (subclass.equals(Subclass.HUNTER)) {
				Misc.tryToAddOne(HUNTER_TECHNIQUES[3], features);

			} else if (subclass.equals(Subclass.BEAST_MASTER)) {
				features.add(ClassFeature.SHARE_SPELLS);

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
			features.add(ClassFeature.FERAL_SENSES);

			break;
		case 19:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_19);
			improveAbility(actor);

			break;
		case 20:
			features.add(ClassFeature.FOE_SLAYER);

			break;
		}

		actor.setClassFeatures(features);
	}
}
