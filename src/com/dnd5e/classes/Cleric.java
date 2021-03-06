package com.dnd5e.classes;

import java.util.EnumSet;

import com.dnd5e.characters.*;
import com.dnd5e.definitions.magic.Spell;
import com.dnd5e.definitions.rules.*;
import com.dnd5e.definitions.skills.Skill;
import com.dnd5e.equipment.*;
import com.dnd5e.magic.*;
import com.miscellaneous.util.*;

public abstract class Cleric extends JobClass {
	private static final DnDClass CLAZZ;
	private static final RacialFeature[] SAVING_THROWS;
	private static final Skill[] CLASS_SKILLS;
	private static final int NUMBER_OF_SKILLS;

	// SPECIAL USE
	private static final Skill[] KNOWLEDGE_DOMAIN;

	static {
		CLAZZ = DnDClass.CLERIC;
		SAVING_THROWS = DnDClass.getSavingThrows(CLAZZ);
		CLASS_SKILLS = Skill.getClassSkills(CLAZZ);
		NUMBER_OF_SKILLS = DnDClass.getNumberOfSkills(CLAZZ);

		//
		KNOWLEDGE_DOMAIN = new Skill[] { Skill.ARCANA, Skill.HISTORY, Skill.NATURE, Skill.RELIGION };
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
		actor.getWeaponSkills().addAll(Skill.simpleWeaponList());

		// MAGIC SETUP
		Spell.addCantrip(3, CLAZZ, actor.getCantripsKnown());
		actor.getClassFeatures().add(ClassFeature.RITUAL_CASTING_CLERIC);
		actor.getSpecialSkills().add(Skill.HOLY_SYMBOL);

	}

	public static void setupStartingGear(Hero actor) {
		/*
		 * INVENTORY
		 */
		Inventory inv = actor.getInventory();
		int strength = actor.getStrength();
		int dexterity = actor.getDexterity();

		// FIRST CHOICE
		if (actor.getWeaponSkills().contains(Skill.WARHAMMER)) {
			inv.addWeaponHelper(Skill.WARHAMMER);

		} else {
			inv.addWeaponHelper(Skill.MACE);

		}

		// SECOND CHOICE
		if (dexterity > 15) {
			inv.addArmorHelper(Skill.LEATHER_ARMOR);

		} else if (actor.getArmorSkills().contains(Skill.CHAIN_MAIL) && strength > 12) {
			inv.addArmorHelper(Skill.CHAIN_MAIL);

		} else {
			inv.addArmorHelper(Skill.SCALE_MAIL);

		}

		// THIRD CHOICE
		int dice = Dice.roll(2);
		if (dice == 1) {
			inv.addWeaponHelper(Skill.LIGHT_CROSSBOW);
			inv.addAmmunition(Skill.LIGHT_CROSSBOW);
		} else {
			inv.randomSimpleWeapon();
		}

		// TODO - add priest's or explorer's pack
		// TODO - receive shield + holy symbol
		inv.addShieldHelper();

		// FINAL STEP
		actor.setInventory(inv);
	}

	public static void apply(int level, Hero actor) {
		EnumSet<ClassFeature> features = actor.getClassFeatures();

		Subclass subclass = actor.getSubclass();
		switch (level) {
		case 1:
			/*
			 * DIVINE DOMAIN
			 */
			switch (subclass) {
			case DEATH:
				features.add(ClassFeature.DIVINE_DOMAIN_DEATH);
				features.add(ClassFeature.REAPER);

				Misc.tryToAdd(Spell.CHILL_TOUCH, actor.getCantripsKnown());
				//
				actor.getCommonSkills().addAll(Skill.militaryWeaponList());
				break;
			case KNOWLEDGE:
				features.add(ClassFeature.DIVINE_DOMAIN_KNOWLEDGE);
				features.add(ClassFeature.BLESSINGS_OF_KNOWLEDGE);
				//
				Misc.tryToAddN(2, Language.NONSECRET_LANGUAGES, actor.getLanguages());
				Misc.tryToAddN(2, KNOWLEDGE_DOMAIN, actor.getCommonSkills());

				break;
			case LIFE:
				features.add(ClassFeature.DIVINE_DOMAIN_LIFE);
				features.add(ClassFeature.DISCIPLE_OF_LIFE);
				//
				actor.getCommonSkills().addAll(Skill.heavyArmorList());
				break;
			case LIGHT:
				features.add(ClassFeature.DIVINE_DOMAIN_LIGHT);
				features.add(ClassFeature.WARDING_FLARE);

				Misc.tryToAdd(Spell.LIGHT, actor.getCantripsKnown());
				//
				break;
			case NATURE:
				features.add(ClassFeature.DIVINE_DOMAIN_NATURE);
				Spell.addCantrip(DnDClass.DRUID, actor.getCantripsKnown());
				//
				actor.getCommonSkills().addAll(Skill.heavyArmorList());
				break;
			case TEMPEST:
				features.add(ClassFeature.DIVINE_DOMAIN_TEMPEST);
				features.add(ClassFeature.WRATH_OF_THE_STORM);
				//
				actor.getCommonSkills().addAll(Skill.heavyArmorList());
				actor.getCommonSkills().addAll(Skill.militaryWeaponList());
				break;
			case TRICKERY:
				features.add(ClassFeature.DIVINE_DOMAIN_TRICKERY);
				features.add(ClassFeature.BLESSING_OF_THE_TRICKSTER);
				//
				break;
			case WAR:
				features.add(ClassFeature.DIVINE_DOMAIN_WAR);
				features.add(ClassFeature.WAR_PRIEST);
				//
				actor.getCommonSkills().addAll(Skill.heavyArmorList());
				actor.getCommonSkills().addAll(Skill.militaryWeaponList());
				break;
			default:
				break;
			}

			break;
		case 2:
			features.add(ClassFeature.CHANNEL_DIVINITY_1);

			/*
			 * DIVINE DOMAIN
			 */
			switch (subclass) {
			case DEATH:
				features.add(ClassFeature.TOUCH_OF_DEATH);
				break;
			case KNOWLEDGE:
				features.add(ClassFeature.KNOWLEDGE_OF_THE_AGES);
				break;
			case LIFE:
				features.add(ClassFeature.PRESERVE_LIFE);
				break;
			case LIGHT:
				features.add(ClassFeature.RADIANCE_OF_THE_DAWN);
				break;
			case NATURE:
				features.add(ClassFeature.CHARM_ANIMALS_AND_PLANTS);
				break;
			case TEMPEST:
				features.add(ClassFeature.DESTRUCTIVE_WRATH);
				break;
			case TRICKERY:
				features.add(ClassFeature.INVOKE_DUPLICITY);
				break;
			case WAR:
				features.add(ClassFeature.GUIDED_STRIKE);
				break;
			default:
				break;
			}

			break;
		case 3:
			/*
			 * NO NEW FEATURE
			 */

			break;
		case 4:
			// NEW CANTRIP
			Spell.addCantrip(CLAZZ, actor.getCantripsKnown());

			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_4);
			improveAbility(actor);

			break;
		case 5:
			features.add(ClassFeature.DESTROY_UNDEAD_5);

			break;
		case 6:
			features.add(ClassFeature.CHANNEL_DIVINITY_2);

			/*
			 * DIVINE DOMAIN
			 */
			switch (subclass) {
			case DEATH:
				features.add(ClassFeature.INESCAPABLE_DESTRUCTION);
				break;
			case KNOWLEDGE:
				features.add(ClassFeature.READ_THOUGHTS);
				break;
			case LIFE:
				features.add(ClassFeature.BLESSED_HEALER);
				break;
			case LIGHT:
				features.add(ClassFeature.IMPROVED_FLARE);
				break;
			case NATURE:
				features.add(ClassFeature.DAMPEN_ELEMENTS);
				break;
			case TEMPEST:
				features.add(ClassFeature.THUNDERBOLT_STRIKE);
				break;
			case TRICKERY:
				features.add(ClassFeature.TRICKERY_CLOAK);
				break;
			case WAR:
				features.add(ClassFeature.WAR_GODS_BLESSING);
				break;
			default:
				break;
			}

			break;
		case 7:
			/*
			 * NO NEW FEATURE
			 */

			break;
		case 8:
			features.add(ClassFeature.DESTROY_UNDEAD_8);

			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_8);
			improveAbility(actor);

			/*
			 * DIVINE DOMAIN
			 */
			switch (subclass) {
			case DEATH:
				features.add(ClassFeature.DIVINE_STRIKE_DEATH);
				break;
			case KNOWLEDGE:
				features.add(ClassFeature.POTENT_SPELLCASTING_CLERIC);
				break;
			case LIFE:
				features.add(ClassFeature.DIVINE_STRIKE_LIFE);
				break;
			case LIGHT:
				features.add(ClassFeature.POTENT_SPELLCASTING_CLERIC);
				break;
			case NATURE:
				features.add(ClassFeature.DIVINE_STRIKE_NATURE);
				break;
			case TEMPEST:
				features.add(ClassFeature.DIVINE_STRIKE_TEMPEST);
				break;
			case TRICKERY:
				features.add(ClassFeature.DIVINE_STRIKE_TRICKERY);
				break;
			case WAR:
				features.add(ClassFeature.DIVINE_STRIKE_WAR);
				break;
			default:
				break;
			}

			break;
		case 9:
			/*
			 * NO NEW FEATURE
			 */

			break;
		case 10:
			// NEW CANTRIP
			Misc.tryToAddOne(Spell.CLERIC_SPELLS[0], actor.getCantripsKnown());
			//
			features.add(ClassFeature.DIVINE_INTERVENTION_10);

			break;
		case 11:
			features.add(ClassFeature.DESTROY_UNDEAD_11);
			//

			break;
		case 12:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_12);
			improveAbility(actor);

			break;
		case 13:
			/*
			 * NO NEW FEATURE
			 */
			break;
		case 14:
			features.add(ClassFeature.DESTROY_UNDEAD_14);
			//

			break;
		case 15:
			/*
			 * NO NEW FEATURE
			 */

			break;
		case 16:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_16);
			improveAbility(actor);

			break;
		case 17:
			features.add(ClassFeature.DESTROY_UNDEAD_17);
			//

			/*
			 * DIVINE DOMAIN
			 */
			switch (subclass) {
			case DEATH:
				features.add(ClassFeature.IMPROVED_REAPER);
				break;
			case KNOWLEDGE:
				features.add(ClassFeature.VISIONS_OF_THE_PAST);
				break;
			case LIFE:
				features.add(ClassFeature.SUPREME_HEALING);
				break;
			case LIGHT:
				features.add(ClassFeature.POTENT_SPELLCASTING_CLERIC);
				break;
			case NATURE:
				features.add(ClassFeature.MASTER_OF_NATURE);
				break;
			case TEMPEST:
				features.add(ClassFeature.STORMBORN);
				break;
			case TRICKERY:
				features.add(ClassFeature.IMPROVED_DUPLICITY);
				break;
			case WAR:
				features.add(ClassFeature.AVATAR_OF_BATTLE);
				break;
			default:
				break;
			}

			break;
		case 18:
			features.add(ClassFeature.CHANNEL_DIVINITY_3);

			break;
		case 19:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_19);
			improveAbility(actor);

			break;
		case 20:
			features.add(ClassFeature.DIVINE_INTERVENTION_20);

			break;
		}

		actor.setClassFeatures(features);
	}

}
