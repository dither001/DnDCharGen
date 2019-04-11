package com.dnd5e.character.classes;

import java.util.EnumSet;

import com.dnd5e.character.definitions.*;
import com.dnd5e.definitions.*;
import com.dnd5e.gear.equipment.*;
import com.dnd5e.magic.*;
import com.miscellaneous.util.*;

public abstract class Bard extends JobClass {
	private static final DnDClass CLAZZ;
	private static final RacialFeature[] SAVING_THROWS;
	private static final Skill[] CLASS_SKILLS;
	private static final int NUMBER_OF_SKILLS;

	static {
		CLAZZ = DnDClass.BARD;
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
		Misc.tryToAddN(3, Skill.getInstrumentSkillsList(), actor.getSpecialSkills());

		//
		actor.getArmorSkills().addAll(Skill.lightArmorList());
		actor.getWeaponSkills().addAll(Skill.simpleWeaponList());
		actor.getWeaponSkills().addAll(Skill.rogueWeapons());

		// MAGIC SETUP
		Spell.addCantrip(2, CLAZZ, actor.getCantripsKnown());
		Spell.addSpell(4, 1, CLAZZ, actor.getSpellsKnown());
		actor.getClassFeatures().add(ClassFeature.RITUAL_CASTING_BARD);
		actor.getSpecialSkills().add(Skill.MUSIC_FOCUS);

	}

	public static void setupStartingGear(Hero actor) {
		/*
		 * INVENTORY
		 */
		Inventory inv = actor.getInventory();

		// FIRST CHOICE
		int dice = Dice.roll(3);
		if (dice == 1) {
			inv.addWeapon(Skill.RAPIER);

		} else if (dice == 2) {
			inv.addWeapon(Skill.LONGSWORD);

		} else {
			// random simple weapon
			inv.addWeapon(Skill.randomSimpleWeapon());
		}

		// TODO - add diplomat's or entertainer's pack

		// musical instrument
		inv.randomInstrument();

		// leather armor + dagger
		inv.addArmor(Skill.LEATHER_ARMOR);
		inv.addWeapon(Skill.DAGGER);

		// FINAL STEP
		actor.setInventory(inv);
	}

	public static void apply(int level, Hero actor) {
		EnumSet<ClassFeature> features = actor.getClassFeatures();
		int spellLevel = level < 18 ? (level + 1) / 2 : 9;

		Subclass subclass = actor.getSubclass();
		switch (level) {
		case 1:
			features.add(ClassFeature.INSPIRATION_D6);

			break;
		case 2:
			Spell.addSpell(spellLevel, CLAZZ, actor.getSpellsKnown());
			features.add(ClassFeature.JACK_OF_ALL_TRADES);
			features.add(ClassFeature.SONG_OF_REST_D6);

			break;
		case 3:
			Spell.addSpell(spellLevel, CLAZZ, actor.getSpellsKnown());
			ClassFeature.addRandomExpertise(2, actor);

			/*
			 * BARD COLLEGE
			 */
			if (subclass.equals(Subclass.LORE_COLLEGE)) {
				Misc.tryToAddN(3, Skill.getCommonSkills(), actor.getCommonSkills());
				features.add(ClassFeature.CUTTING_WORDS);

			} else if (subclass.equals(Subclass.VALOR_COLLEGE)) {
				actor.getArmorSkills().addAll(Skill.mediumArmorList());
				actor.getArmorSkills().add(Skill.SHIELD);
				actor.getWeaponSkills().addAll(Skill.militaryWeaponList());
				features.add(ClassFeature.COMBAT_INSPIRATION);

			}

			break;
		case 4:
			// NEW CANTRIP
			Spell.addCantrip(CLAZZ, actor.getCantripsKnown());
			//
			Spell.addSpell(spellLevel, CLAZZ, actor.getSpellsKnown());

			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_4);
			improveAbility(actor);

			break;
		case 5:
			Spell.addSpell(spellLevel, CLAZZ, actor.getSpellsKnown());
			//
			features.add(ClassFeature.INSPIRATION_D8);
			features.add(ClassFeature.FONT_OF_INSPIRATION);

			break;
		case 6:
			Spell.addSpell(spellLevel, CLAZZ, actor.getSpellsKnown());
			//
			features.add(ClassFeature.COUNTERCHARM);

			/*
			 * BARD COLLEGE
			 */
			if (subclass.equals(Subclass.LORE_COLLEGE)) {
				features.add(ClassFeature.MAGICAL_SECRETS_6);
				Spell.addMagicalSecret(2, spellLevel, actor.getSpellsKnown());

			} else if (subclass.equals(Subclass.VALOR_COLLEGE)) {
				features.add(ClassFeature.EXTRA_ATTACK_1);

			}

			break;
		case 7:
			// spells and nothing else
			Spell.addSpell(spellLevel, CLAZZ, actor.getSpellsKnown());

			break;
		case 8:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_8);
			improveAbility(actor);

			break;
		case 9:
			Spell.addSpell(spellLevel, CLAZZ, actor.getSpellsKnown());
			features.add(ClassFeature.SONG_OF_REST_D8);

			break;
		case 10:
			// NEW CANTRIP
			Spell.addCantrip(CLAZZ, actor.getCantripsKnown());
			//
			features.add(ClassFeature.INSPIRATION_D10);
			features.add(ClassFeature.MAGICAL_SECRETS_10);
			Spell.addMagicalSecret(2, spellLevel, actor.getSpellsKnown());
			ClassFeature.addRandomExpertise(2, actor);

			break;
		case 11:
			// spells and nothing else
			Spell.addSpell(spellLevel, CLAZZ, actor.getSpellsKnown());

			break;
		case 12:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_12);
			improveAbility(actor);

			break;
		case 13:
			Spell.addSpell(spellLevel, CLAZZ, actor.getSpellsKnown());
			features.add(ClassFeature.SONG_OF_REST_D10);

			break;
		case 14:
			features.add(ClassFeature.MAGICAL_SECRETS_14);
			Spell.addMagicalSecret(2, spellLevel, actor.getSpellsKnown());

			/*
			 * BARD COLLEGE
			 */
			if (subclass.equals(Subclass.LORE_COLLEGE)) {
				features.add(ClassFeature.PEERLESS_SKILL);

			} else if (subclass.equals(Subclass.VALOR_COLLEGE)) {
				features.add(ClassFeature.BATTLE_MAGIC);

			}

			break;
		case 15:
			Spell.addSpell(spellLevel, CLAZZ, actor.getSpellsKnown());
			features.add(ClassFeature.INSPIRATION_D12);

			break;
		case 16:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_16);
			improveAbility(actor);

			break;
		case 17:
			Spell.addSpell(spellLevel, CLAZZ, actor.getSpellsKnown());
			features.add(ClassFeature.SONG_OF_REST_D12);

			break;
		case 18:
			features.add(ClassFeature.MAGICAL_SECRETS_18);
			Spell.addMagicalSecret(2, spellLevel, actor.getSpellsKnown());

			break;
		case 19:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_19);
			improveAbility(actor);

			break;
		case 20:
			features.add(ClassFeature.SUPERIOR_INSPIRATION);

			break;
		}

		actor.setClassFeatures(features);
	}

}
