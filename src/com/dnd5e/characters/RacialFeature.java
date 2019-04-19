package com.dnd5e.characters;

import java.util.EnumSet;

import com.dnd5e.definitions.rules.*;
import com.dnd5e.magic.*;
import com.miscellaneous.util.*;

public enum RacialFeature {
	/*
	 * RACIAL FEATURES
	 */
	DARKVISION_60, DARKVISION_120, SUNLIGHT_SENSITIVITY,
	// dwarf features
	DWARVEN_ENCUMBRANCE, STOUT_RESILIENCE, DWARF_WEAPON_TRAINING, STONECUNNING, DWARVEN_TOUGHNESS, DWARF_ARMOR_TRAINING,
	// elf features
	FEY_ANCESTRY, ELF_TRANCE, ELF_WEAPON_TRAINING, FLEET_OF_FOOT, MASK_OF_THE_WILD, DROW_WEAPON_TRAINING,
	// halfling features
	HALFLING_LUCK, HALFLING_BRAVERY, HALFLING_NIMBLENESS, NATURALLY_STEALTHY,
	// dragonborn features
	FIRE_BREATH_LINE, LIGHTNING_BREATH_LINE, ACID_BREATH_LINE, FIRE_BREATH_CONE, COLD_BREATH_CONE, ACID_BREATH_CONE, POISON_BREATH_CONE,
	// gnome features
	GNOME_CUNNING, NATURAL_ILLUSIONIST, SPEAK_WITH_SMALL_BEASTS, ARTIFICERS_LORE, GNOME_TINKER,
	// half-orc features
	HALF_ORC_MENACE, RELENTLESS_ENDURANCE, SAVAGE_ATTACKS,
	// tiefling features
	HELLISH_RESISTANCE, INFERNAL_LEGACY,

	/*
	 * GENERIC & SHARED FEATURES
	 */
	STRENGTH_SAVE, DEXTERITY_SAVE, CONSTITUTION_SAVE, INTELLIGENCE_SAVE, WISDOM_SAVE, CHARISMA_SAVE

	/*
	 * END OF FEATURES
	 */
	;

	/*
	 * STATIC FIELDS
	 */
	private static final Skill[] ELF_WEAPONS = { Skill.LONGBOW, Skill.LONGSWORD, Skill.SHORTBOW, Skill.SHORTSWORD };
	private static final Skill[] DROW_WEAPONS = { Skill.HAND_CROSSBOW, Skill.RAPIER, Skill.SHORTSWORD };
	private static final Skill[] DWARF_WEAPONS = { Skill.BATTLEAXE, Skill.HANDAXE, Skill.LIGHT_HAMMER,
			Skill.WARHAMMER };

	/*
	 * STATIC METHODS
	 */
	public static void setup(Creature creature) {
		DnDCharacter actor = null;
		if (creature.getClass().equals(DnDCharacter.class))
			actor = (DnDCharacter) creature;
		else
			return;

		EnumSet<Language> languages = actor.getLanguages();
		EnumSet<RacialFeature> features = actor.getFeatures();

		languages.add(Language.COMMON);

		Race race = actor.getRace();
		switch (race) {
		case BLACKSCALE:
		case BLUESCALE:
		case BRASSLEAF:
		case BRONZELEAF:
		case COPPERLEAF:
		case GOLDLEAF:
		case GREENSCALE:
		case REDSCALE:
		case SILVERLEAF:
		case WHITESCALE:
			/*
			 * DRAGONBORN FEATURES
			 */
			actor.setStrength(actor.getStrength() + 2);
			actor.setCharisma(actor.getCharisma() + 1);
			//
			languages.add(Language.DRACONIC);
			// TODO - draconic ancestry

			break;
		case DARK_ELF:
		case HIGH_ELF:
		case WOOD_ELF:
			/*
			 * ELF FEATURES
			 */
			actor.setDexterity(actor.getDexterity() + 2);
			actor.getCommonSkills().add(Skill.PERCEPTION);
			features.add(FEY_ANCESTRY);
			features.add(ELF_TRANCE);
			//
			languages.add(Language.ELVISH);

			if (race.equals(Race.HIGH_ELF)) {
				actor.setIntelligence(actor.getIntelligence() + 1);
				features.add(DARKVISION_60);
				Misc.tryToAddOne(Language.COMMON_LANGUAGES, actor.getLanguages());
				//
				features.add(ELF_WEAPON_TRAINING);
				actor.getWeaponSkills().addAll(Misc.arrayToList(ELF_WEAPONS));
				//
				Misc.tryToAddOne(Spell.CANTRIPS, actor.getCantripsKnown());

			} else if (race.equals(Race.WOOD_ELF)) {
				actor.setWisdom(actor.getWisdom() + 1);
				features.add(DARKVISION_60);
				//
				features.add(FLEET_OF_FOOT);
				// TODO - increase base movement
				features.add(MASK_OF_THE_WILD);
				//
				features.add(ELF_WEAPON_TRAINING);
				actor.getWeaponSkills().addAll(Misc.arrayToList(ELF_WEAPONS));

			} else if (race.equals(Race.DARK_ELF)) {
				actor.setCharisma(actor.getCharisma() + 1);
				features.add(DARKVISION_120);
				features.add(SUNLIGHT_SENSITIVITY);
				//
				features.add(DROW_WEAPON_TRAINING);
				actor.getWeaponSkills().addAll(Misc.arrayToList(DROW_WEAPONS));
				//
				Misc.tryToAdd(Spell.DANCING_LIGHTS, actor.getCantripsKnown());

			}

			break;
		case FOREST_GNOME:
		case ROCK_GNOME:
			/*
			 * GNOME FEATURES
			 */
			actor.setIntelligence(actor.getIntelligence() + 2);
			features.add(DARKVISION_60);
			features.add(GNOME_CUNNING);
			//
			languages.add(Language.GNOMISH);
			//

			if (race.equals(Race.FOREST_GNOME)) {
				actor.setDexterity(actor.getDexterity() + 1);
				//
				features.add(NATURAL_ILLUSIONIST);
				features.add(SPEAK_WITH_SMALL_BEASTS);
				Misc.tryToAdd(Spell.MINOR_ILLUSION, actor.getCantripsKnown());

			} else if (race.equals(Race.ROCK_GNOME)) {
				actor.setConstitution(actor.getConstitution() + 1);
				//
				features.add(ARTIFICERS_LORE);
				features.add(GNOME_TINKER);

			}

			break;
		case HALF_ELF:
			/*
			 * HALF-ELF FEATURES
			 */
			actor.setCharisma(actor.getCharisma() + 2);
			actor.setDexterity(actor.getDexterity() + 1);
			actor.setConstitution(actor.getConstitution() + 1);
			//
			features.add(DARKVISION_60);
			features.add(FEY_ANCESTRY);
			languages.add(Language.ELVISH);
			Misc.tryToAddOne(Language.COMMON_LANGUAGES, actor.getLanguages());
			//
			Misc.tryToAddN(2, Skill.getCommonSkills(), actor.getCommonSkills());

			break;
		case HALF_ORC:
			/*
			 * HALF-ORC FEATURES
			 */
			actor.setStrength(actor.getStrength() + 2);
			actor.setConstitution(actor.getConstitution() + 1);
			//
			features.add(DARKVISION_60);
			languages.add(Language.ORCISH);
			//
			features.add(HALF_ORC_MENACE);
			features.add(RELENTLESS_ENDURANCE);
			features.add(SAVAGE_ATTACKS);
			//
			actor.getCommonSkills().add(Skill.INTIMIDATION);

			break;
		case HILL_DWARF:
		case MOUNTAIN_DWARF:
			/*
			 * DWARF FEATURES
			 */
			actor.setConstitution(actor.getConstitution() + 2);
			features.add(DWARVEN_ENCUMBRANCE);
			features.add(DARKVISION_60);
			//
			features.add(DWARF_WEAPON_TRAINING);
			actor.getWeaponSkills().addAll(Misc.arrayToList(DWARF_WEAPONS));
			//
			actor.getSpecialSkills().add(Misc.randomFromArray(Skill.DWARF_TOOLS));
			features.add(RacialFeature.STONECUNNING);
			//
			languages.add(Language.DWARVISH);

			if (race.equals(Race.HILL_DWARF)) {
				actor.setWisdom(actor.getWisdom() + 1);
				//
				features.add(DWARVEN_TOUGHNESS);

			} else if (race.equals(Race.MOUNTAIN_DWARF)) {
				actor.setStrength(actor.getStrength() + 2);
				//
				features.add(DWARF_ARMOR_TRAINING);
				actor.getArmorSkills().addAll(Skill.lightAndMediumArmorList());

			}

			break;
		case HUMAN:
			/*
			 * HUMAN FEATURES
			 */
			actor.setStrength(actor.getStrength() + 1);
			actor.setDexterity(actor.getDexterity() + 1);
			actor.setConstitution(actor.getConstitution() + 1);
			actor.setIntelligence(actor.getIntelligence() + 1);
			actor.setWisdom(actor.getWisdom() + 1);
			actor.setCharisma(actor.getCharisma() + 1);
			Misc.tryToAddOne(Language.COMMON_LANGUAGES, actor.getLanguages());

			break;
		case LIGHTFOOT_HALFLING:
		case STRONGHEART_HALFLING:
			/*
			 * HALFLING FEaTURES
			 */
			actor.setDexterity(actor.getDexterity() + 2);
			features.add(HALFLING_LUCK);
			features.add(HALFLING_BRAVERY);
			features.add(HALFLING_NIMBLENESS);
			//
			languages.add(Language.HALFLING);

			if (race.equals(Race.LIGHTFOOT_HALFLING)) {
				actor.setCharisma(actor.getCharisma() + 1);
				//
				features.add(NATURALLY_STEALTHY);

			} else if (race.equals(Race.STRONGHEART_HALFLING)) {
				actor.setConstitution(actor.getConstitution() + 1);
				//
				features.add(RacialFeature.STOUT_RESILIENCE);

			}

			break;
		case TIEFLING:
			/*
			 * TIEFLING FEATURES
			 */
			actor.setCharisma(actor.getCharisma() + 2);
			actor.setIntelligence(actor.getIntelligence() + 1);
			languages.add(Language.INFERNAL);
			//
			features.add(DARKVISION_60);
			features.add(HELLISH_RESISTANCE);
			features.add(INFERNAL_LEGACY);
			// TODO - add innate spell casting
			actor.getInnateSpells().add(1, Spell.HELLISH_REBUKE);

			break;
		}

		actor.setLanguages(languages);
		actor.setFeatures(features);
	}

	public static void removeRacialAbilityBonuses(Hero actor) {
		Race race = actor.getRace();

		switch (race) {
		case BLACKSCALE:
		case BLUESCALE:
		case BRASSLEAF:
		case BRONZELEAF:
		case COPPERLEAF:
		case GOLDLEAF:
		case GREENSCALE:
		case REDSCALE:
		case SILVERLEAF:
		case WHITESCALE:
			actor.setStrength(actor.getStrength() - 2);
			actor.setCharisma(actor.getCharisma() - 1);
			break;
		case DARK_ELF:
		case HIGH_ELF:
		case WOOD_ELF:
			actor.setDexterity(actor.getDexterity() - 2);

			if (race.equals(Race.HIGH_ELF)) {
				actor.setIntelligence(actor.getIntelligence() - 1);

			} else if (race.equals(Race.WOOD_ELF)) {
				actor.setWisdom(actor.getWisdom() - 1);

			} else if (race.equals(Race.DARK_ELF)) {
				actor.setCharisma(actor.getCharisma() - 1);

			}

			break;
		case FOREST_GNOME:
		case ROCK_GNOME:
			actor.setIntelligence(actor.getIntelligence() - 2);

			if (race.equals(Race.FOREST_GNOME)) {
				actor.setDexterity(actor.getDexterity() - 1);

			} else if (race.equals(Race.ROCK_GNOME)) {
				actor.setConstitution(actor.getConstitution() - 1);

			}

			break;
		case HALF_ELF:
			actor.setCharisma(actor.getCharisma() - 2);
			actor.setDexterity(actor.getDexterity() - 1);
			actor.setConstitution(actor.getConstitution() - 1);

			break;
		case HALF_ORC:
			actor.setStrength(actor.getStrength() - 2);
			actor.setConstitution(actor.getConstitution() - 1);

			break;
		case HILL_DWARF:
		case MOUNTAIN_DWARF:
			actor.setConstitution(actor.getConstitution() - 2);

			if (race.equals(Race.HILL_DWARF)) {
				actor.setWisdom(actor.getWisdom() - 1);

			} else if (race.equals(Race.MOUNTAIN_DWARF)) {
				actor.setStrength(actor.getStrength() - 2);

			}

			break;
		case HUMAN:
			actor.setStrength(actor.getStrength() - 1);
			actor.setDexterity(actor.getDexterity() - 1);
			actor.setConstitution(actor.getConstitution() - 1);
			actor.setIntelligence(actor.getIntelligence() - 1);
			actor.setWisdom(actor.getWisdom() - 1);
			actor.setCharisma(actor.getCharisma() - 1);

			break;
		case LIGHTFOOT_HALFLING:
		case STRONGHEART_HALFLING:
			actor.setDexterity(actor.getDexterity() - 2);

			if (race.equals(Race.LIGHTFOOT_HALFLING)) {
				actor.setCharisma(actor.getCharisma() - 1);

			} else if (race.equals(Race.STRONGHEART_HALFLING)) {
				actor.setConstitution(actor.getConstitution() - 1);

			}

			break;
		case TIEFLING:
			actor.setCharisma(actor.getCharisma() - 2);
			actor.setIntelligence(actor.getIntelligence() - 1);

			break;
		}

	}

}
