package com.dnd5e.character.classes;

import java.util.EnumSet;

import com.dnd5e.definitions.*;

public abstract class Cleric extends JobClass {
	/*
	 * 
	 */
	@SuppressWarnings("incomplete-switch")
	public static void apply(int level, Hero actor) {
		EnumSet<RacialFeature> racialFeatures = actor.getFeatures();
		EnumSet<ClassFeature> classFeatures = actor.getClassFeatures();

		Subclass subclass = actor.getSubclass();
		switch (level) {
		case 1:
			racialFeatures.add(RacialFeature.WISDOM_SAVE);
			racialFeatures.add(RacialFeature.CHARISMA_SAVE);
			//

			/*
			 * DIVINE DOMAIN
			 */
			switch (subclass) {
			case DEATH:
				classFeatures.add(ClassFeature.DIVINE_DOMAIN_DEATH);
				classFeatures.add(ClassFeature.REAPER);
				//
				EnumSet<Skill> skills = actor.getSkills();
				skills.addAll(Skill.militaryWeaponList());
				actor.setSkills(skills);
				break;
			case KNOWLEDGE:
				classFeatures.add(ClassFeature.DIVINE_DOMAIN_KNOWLEDGE);
				//
				break;
			case LIFE:
				classFeatures.add(ClassFeature.DIVINE_DOMAIN_LIFE);
				//
				break;
			case LIGHT:
				classFeatures.add(ClassFeature.DIVINE_DOMAIN_LIGHT);
				//
				break;
			case NATURE:
				classFeatures.add(ClassFeature.DIVINE_DOMAIN_NATURE);
				//
				break;
			case TEMPEST:
				classFeatures.add(ClassFeature.DIVINE_DOMAIN_TEMPEST);
				//
				break;
			case TRICKERY:
				classFeatures.add(ClassFeature.DIVINE_DOMAIN_TRICKERY);
				//
				break;
			case WAR:
				classFeatures.add(ClassFeature.DIVINE_DOMAIN_WAR);
				//
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
				break;
			case KNOWLEDGE:
				break;
			case LIFE:
				break;
			case LIGHT:
				break;
			case NATURE:
				break;
			case TEMPEST:
				break;
			case TRICKERY:
				break;
			case WAR:
				break;
			}

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
			/*
			 * DIVINE DOMAIN
			 */
			switch (subclass) {
			case DEATH:
				break;
			case KNOWLEDGE:
				break;
			case LIFE:
				break;
			case LIGHT:
				break;
			case NATURE:
				break;
			case TEMPEST:
				break;
			case TRICKERY:
				break;
			case WAR:
				break;
			}

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
			/*
			 * DIVINE DOMAIN
			 */
			switch (subclass) {
			case DEATH:
				break;
			case KNOWLEDGE:
				break;
			case LIFE:
				break;
			case LIGHT:
				break;
			case NATURE:
				break;
			case TEMPEST:
				break;
			case TRICKERY:
				break;
			case WAR:
				break;
			}

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

}
