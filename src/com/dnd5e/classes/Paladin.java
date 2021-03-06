package com.dnd5e.classes;

import java.util.EnumSet;

import com.dnd5e.characters.*;
import com.dnd5e.definitions.skills.Skill;
import com.dnd5e.equipment.*;
import com.miscellaneous.util.*;

public abstract class Paladin extends JobClass {
	private static final DnDClass CLAZZ;
	private static final RacialFeature[] SAVING_THROWS;
	private static final Skill[] CLASS_SKILLS;
	private static final int NUMBER_OF_SKILLS;

	//
	private static final ClassFeature[] FIGHTING_STYLE = new ClassFeature[] { ClassFeature.STYLE_DEFENSE,
			ClassFeature.STYLE_DUELING, ClassFeature.STYLE_GREAT_WEAPON, ClassFeature.STYLE_PROTECTION };

	static {
		CLAZZ = DnDClass.PALADIN;
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

		actor.getArmorSkills().addAll(Skill.allArmorList());
		actor.getArmorSkills().add(Skill.SHIELD);
		actor.getWeaponSkills().addAll(Skill.allWeaponList());

		actor.getSpecialSkills().add(Skill.HOLY_SYMBOL);
	}

	public static void setupStartingGear(Hero actor) {
		/*
		* INVENTORY
		*/
		Inventory inv = actor.getInventory();

		// FIRST CHOICE
		int dice = Dice.roll(2);
		if (dice == 1) {
			inv.randomMilitaryWeapon();
			inv.addShieldHelper();

		} else {
			inv.randomMilitaryWeapon();
			inv.randomMilitaryWeapon();

		}

		// SECOND CHOICE
		dice = Dice.roll(2);
		if (dice == 1) {
			inv.addWeaponHelper(5, Skill.JAVELIN);

		} else {
			inv.randomSimpleWeapon();

		}

		// TODO - add priest's or explorer's pack
		// TODO - receive holy symbol
		inv.addArmorHelper(Skill.CHAIN_MAIL);

		// FINAL STEP
		actor.setInventory(inv);
		}
	
	public static void apply(int level, Hero actor) {
		EnumSet<ClassFeature> features = actor.getClassFeatures();

		Subclass subclass = actor.getSubclass();
		switch (level) {
		case 1:
			features.add(ClassFeature.DIVINE_SENSE);
			features.add(ClassFeature.LAY_ON_HANDS);

			break;
		case 2:
			features.add(ClassFeature.DIVINE_SMITE);
			Misc.tryToAddOne(FIGHTING_STYLE, features);

			break;
		case 3:
			features.add(ClassFeature.DIVINE_HEALTH);
			features.add(ClassFeature.CHANNEL_DIVINITY_1);

			/*
			 * SACRED OATH
			 */
			if (subclass.equals(Subclass.DEVOTION_OATH)) {
				features.add(ClassFeature.SACRED_WEAPON);
				features.add(ClassFeature.TURN_THE_UNHOLY);

			} else if (subclass.equals(Subclass.ANCIENTS_OATH)) {
				features.add(ClassFeature.NATURES_WRATH);
				features.add(ClassFeature.TURN_THE_FAITHLESS);

			} else if (subclass.equals(Subclass.VENGEANCE_OATH)) {
				features.add(ClassFeature.ABJURE_ENEMY);
				features.add(ClassFeature.VOW_OF_ENMITY);

			} else if (subclass.equals(Subclass.OATHBREAKER)) {
				features.add(ClassFeature.CONTROL_UNDEAD);
				features.add(ClassFeature.DREADFUL_ASPECT);

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
			features.add(ClassFeature.AURA_OF_PROTECTION);

			break;
		case 7:
			/*
			 * SACRED OATH
			 */
			if (subclass.equals(Subclass.DEVOTION_OATH)) {
				features.add(ClassFeature.AURA_OF_DEVOTION);

			} else if (subclass.equals(Subclass.ANCIENTS_OATH)) {
				features.add(ClassFeature.AURA_OF_WARDING);

			} else if (subclass.equals(Subclass.VENGEANCE_OATH)) {
				features.add(ClassFeature.RELENTLESS_AVENGER);

			} else if (subclass.equals(Subclass.OATHBREAKER)) {
				features.add(ClassFeature.AURA_OF_HATE);

			}

			break;
		case 8:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_8);
			improveAbility(actor);

			break;
		case 9:
			break;
		case 10:
			features.add(ClassFeature.AURA_OF_COURAGE);

			break;
		case 11:
			features.add(ClassFeature.IMPROVED_SMITE);

			break;
		case 12:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_12);
			improveAbility(actor);

			break;
		case 13:
			break;
		case 14:
			features.add(ClassFeature.CLEANSING_TOUCH);

			break;
		case 15:
			/*
			 * SACRED OATH
			 */
			if (subclass.equals(Subclass.DEVOTION_OATH)) {
				features.add(ClassFeature.PURITY_OF_SPIRIT);

			} else if (subclass.equals(Subclass.ANCIENTS_OATH)) {
				features.add(ClassFeature.UNDYING_SENTINEL);

			} else if (subclass.equals(Subclass.VENGEANCE_OATH)) {
				features.add(ClassFeature.SOUL_OF_VENGEANCE);

			} else if (subclass.equals(Subclass.OATHBREAKER)) {
				features.add(ClassFeature.SUPERNATURAL_RESISTANCE);

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
			features.add(ClassFeature.IMPROVED_AURA_18);

			break;
		case 19:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_19);
			improveAbility(actor);

			break;
		case 20:
			/*
			 * SACRED OATH
			 */
			if (subclass.equals(Subclass.DEVOTION_OATH)) {
				features.add(ClassFeature.HOLY_NIMBUS);

			} else if (subclass.equals(Subclass.ANCIENTS_OATH)) {
				features.add(ClassFeature.ELDER_CHAMPION);

			} else if (subclass.equals(Subclass.VENGEANCE_OATH)) {
				features.add(ClassFeature.AVENGING_ANGEL);

			} else if (subclass.equals(Subclass.OATHBREAKER)) {
				features.add(ClassFeature.DREAD_LORD);

			}

			break;
		}

		actor.setClassFeatures(features);
	}
}
