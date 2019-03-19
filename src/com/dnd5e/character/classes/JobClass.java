package com.dnd5e.character.classes;

import java.util.EnumSet;

import com.dnd5e.definitions.RacialFeature;

public abstract class JobClass {

	/*
	 * 
	 */
	public static void apply(int level, Hero actor) {
		System.out.println("Not implemented.");

		EnumSet<RacialFeature> racialFeatures = actor.getFeatures();
		EnumSet<ClassFeature> classFeatures = actor.getClassFeatures();

		Subclass subclass = actor.getSubclass();
		switch (level) {
		case 1:
			racialFeatures.add(RacialFeature.STRENGTH_SAVE);
			racialFeatures.add(RacialFeature.CONSTITUTION_SAVE);
			//
			
			break;
		case 2:
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

	public static void enhanceAbility(Adventurer actor) {
		// TODO

	}

}
