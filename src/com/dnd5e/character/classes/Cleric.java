package com.dnd5e.character.classes;

import java.util.EnumSet;

import com.dnd5e.definitions.*;
import com.dnd5e.magic.*;
import com.miscellaneous.util.*;

public abstract class Cleric extends JobClass {

	private static final Skill[] KNOWLEDGE_SKILLS = { Skill.ARCANA, Skill.HISTORY, Skill.NATURE, Skill.RELIGION };

	/*
	 * 
	 */

	public static void apply(int level, Hero actor) {
		EnumSet<RacialFeature> racialFeatures = actor.getFeatures();
		EnumSet<ClassFeature> classFeatures = actor.getClassFeatures();

		Subclass subclass = actor.getSubclass();
		switch (level) {
		case 1:
			racialFeatures.add(RacialFeature.WISDOM_SAVE);
			racialFeatures.add(RacialFeature.CHARISMA_SAVE);

			/*
			 * DIVINE DOMAIN
			 */
			switch (subclass) {
			case DEATH:
				classFeatures.add(ClassFeature.DIVINE_DOMAIN_DEATH);
				classFeatures.add(ClassFeature.REAPER);

				Misc.tryToAdd(Spell.CHILL_TOUCH, actor.getCantripsKnown());
				//
				actor.getSkills().addAll(Skill.militaryWeaponList());
				break;
			case KNOWLEDGE:
				classFeatures.add(ClassFeature.DIVINE_DOMAIN_KNOWLEDGE);
				classFeatures.add(ClassFeature.BLESSINGS_OF_KNOWLEDGE);
				//
				Misc.tryToAdd(2, Language.NONSECRET_LANGUAGES, actor.getLanguages());
				Misc.tryToAdd(2, KNOWLEDGE_SKILLS, actor.getSkills());

				break;
			case LIFE:
				classFeatures.add(ClassFeature.DIVINE_DOMAIN_LIFE);
				classFeatures.add(ClassFeature.DISCIPLE_OF_LIFE);
				//
				actor.getSkills().addAll(Skill.heavyArmorList());
				break;
			case LIGHT:
				classFeatures.add(ClassFeature.DIVINE_DOMAIN_LIGHT);
				classFeatures.add(ClassFeature.WARDING_FLARE);

				Misc.tryToAdd(Spell.LIGHT, actor.getCantripsKnown());
				//
				break;
			case NATURE:
				classFeatures.add(ClassFeature.DIVINE_DOMAIN_NATURE);
				Misc.tryToAdd(Spell.DRUID_SPELLS[0], actor.getCantripsKnown());
				//
				actor.getSkills().addAll(Skill.heavyArmorList());
				break;
			case TEMPEST:
				classFeatures.add(ClassFeature.DIVINE_DOMAIN_TEMPEST);
				classFeatures.add(ClassFeature.WRATH_OF_THE_STORM);
				//
				actor.getSkills().addAll(Skill.heavyArmorList());
				actor.getSkills().addAll(Skill.militaryWeaponList());
				break;
			case TRICKERY:
				classFeatures.add(ClassFeature.DIVINE_DOMAIN_TRICKERY);
				classFeatures.add(ClassFeature.BLESSING_OF_THE_TRICKSTER);
				//
				break;
			case WAR:
				classFeatures.add(ClassFeature.DIVINE_DOMAIN_WAR);
				classFeatures.add(ClassFeature.WAR_PRIEST);
				//
				actor.getSkills().addAll(Skill.heavyArmorList());
				actor.getSkills().addAll(Skill.militaryWeaponList());
				break;
			default:
				break;
			}

			break;
		case 2:
			classFeatures.add(ClassFeature.CHANNEL_DIVINITY_1);

			/*
			 * DIVINE DOMAIN
			 */
			switch (subclass) {
			case DEATH:
				classFeatures.add(ClassFeature.TOUCH_OF_DEATH);
				break;
			case KNOWLEDGE:
				classFeatures.add(ClassFeature.KNOWLEDGE_OF_THE_AGES);
				break;
			case LIFE:
				classFeatures.add(ClassFeature.PRESERVE_LIFE);
				break;
			case LIGHT:
				classFeatures.add(ClassFeature.RADIANCE_OF_THE_DAWN);
				break;
			case NATURE:
				classFeatures.add(ClassFeature.CHARM_ANIMALS_AND_PLANTS);
				break;
			case TEMPEST:
				classFeatures.add(ClassFeature.DESTRUCTIVE_WRATH);
				break;
			case TRICKERY:
				classFeatures.add(ClassFeature.INVOKE_DUPLICITY);
				break;
			case WAR:
				classFeatures.add(ClassFeature.GUIDED_STRIKE);
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
			Misc.tryToAdd(Spell.CLERIC_SPELLS[0], actor.getCantripsKnown());
			// ABILTIY SCORE IMPROVEMENT
			classFeatures.add(ClassFeature.ABILITY_BONUS_4);
			improveAbility(actor);

			break;
		case 5:
			classFeatures.add(ClassFeature.DESTROY_UNDEAD_5);

			break;
		case 6:
			classFeatures.add(ClassFeature.CHANNEL_DIVINITY_2);

			/*
			 * DIVINE DOMAIN
			 */
			switch (subclass) {
			case DEATH:
				classFeatures.add(ClassFeature.INESCAPABLE_DESTRUCTION);
				break;
			case KNOWLEDGE:
				classFeatures.add(ClassFeature.READ_THOUGHTS);
				break;
			case LIFE:
				classFeatures.add(ClassFeature.BLESSED_HEALER);
				break;
			case LIGHT:
				classFeatures.add(ClassFeature.IMPROVED_FLARE);
				break;
			case NATURE:
				classFeatures.add(ClassFeature.DAMPEN_ELEMENTS);
				break;
			case TEMPEST:
				classFeatures.add(ClassFeature.THUNDERBOLT_STRIKE);
				break;
			case TRICKERY:
				classFeatures.add(ClassFeature.TRICKERY_CLOAK);
				break;
			case WAR:
				classFeatures.add(ClassFeature.WAR_GODS_BLESSING);
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
			classFeatures.add(ClassFeature.DESTROY_UNDEAD_8);
			// ABILTIY SCORE IMPROVEMENT
			classFeatures.add(ClassFeature.ABILITY_BONUS_8);
			improveAbility(actor);

			/*
			 * DIVINE DOMAIN
			 */
			switch (subclass) {
			case DEATH:
				classFeatures.add(ClassFeature.DIVINE_STRIKE_DEATH);
				break;
			case KNOWLEDGE:
				classFeatures.add(ClassFeature.POTENT_SPELLCASTING_CLERIC);
				break;
			case LIFE:
				classFeatures.add(ClassFeature.DIVINE_STRIKE_LIFE);
				break;
			case LIGHT:
				classFeatures.add(ClassFeature.POTENT_SPELLCASTING_CLERIC);
				break;
			case NATURE:
				classFeatures.add(ClassFeature.DIVINE_STRIKE_NATURE);
				break;
			case TEMPEST:
				classFeatures.add(ClassFeature.DIVINE_STRIKE_TEMPEST);
				break;
			case TRICKERY:
				classFeatures.add(ClassFeature.DIVINE_STRIKE_TRICKERY);
				break;
			case WAR:
				classFeatures.add(ClassFeature.DIVINE_STRIKE_WAR);
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
			Misc.tryToAdd(Spell.CLERIC_SPELLS[0], actor.getCantripsKnown());
			//
			classFeatures.add(ClassFeature.DIVINE_INTERVENTION_10);

			break;
		case 11:
			classFeatures.add(ClassFeature.DESTROY_UNDEAD_11);
			//

			break;
		case 12:
			// ABILTIY SCORE IMPROVEMENT
			classFeatures.add(ClassFeature.ABILITY_BONUS_12);
			improveAbility(actor);

			break;
		case 13:
			/*
			 * NO NEW FEATURE
			 */
			break;
		case 14:
			classFeatures.add(ClassFeature.DESTROY_UNDEAD_14);
			//

			break;
		case 15:
			/*
			 * NO NEW FEATURE
			 */
			break;
		case 16:
			// ABILTIY SCORE IMPROVEMENT
			classFeatures.add(ClassFeature.ABILITY_BONUS_16);
			improveAbility(actor);

			break;
		case 17:
			classFeatures.add(ClassFeature.DESTROY_UNDEAD_17);
			//

			/*
			 * DIVINE DOMAIN
			 */
			switch (subclass) {
			case DEATH:
				classFeatures.add(ClassFeature.IMPROVED_REAPER);
				break;
			case KNOWLEDGE:
				classFeatures.add(ClassFeature.VISIONS_OF_THE_PAST);
				break;
			case LIFE:
				classFeatures.add(ClassFeature.SUPREME_HEALING);
				break;
			case LIGHT:
				classFeatures.add(ClassFeature.POTENT_SPELLCASTING_CLERIC);
				break;
			case NATURE:
				classFeatures.add(ClassFeature.MASTER_OF_NATURE);
				break;
			case TEMPEST:
				classFeatures.add(ClassFeature.STORMBORN);
				break;
			case TRICKERY:
				classFeatures.add(ClassFeature.IMPROVED_DUPLICITY);
				break;
			case WAR:
				classFeatures.add(ClassFeature.AVATAR_OF_BATTLE);
				break;
			default:
				break;
			}

			break;
		case 18:
			classFeatures.add(ClassFeature.CHANNEL_DIVINITY_3);
			
			break;
		case 19:
			// ABILTIY SCORE IMPROVEMENT
			classFeatures.add(ClassFeature.ABILITY_BONUS_19);
			improveAbility(actor);

			break;
		case 20:
			classFeatures.add(ClassFeature.DIVINE_INTERVENTION_20);
			
			break;
		}

		actor.setFeatures(racialFeatures);
		actor.setClassFeatures(classFeatures);
	}

}
