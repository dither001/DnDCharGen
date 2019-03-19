package com.dnd5e.definitions;

import java.util.EnumSet;

import com.dnd5e.characters.*;
import com.miscellaneous.util.*;

public enum Feature {
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
	 * CLASS FEATURES
	 */
	ABILITY_BONUS_4, ABILITY_BONUS_6, ABILITY_BONUS_8, ABILITY_BONUS_10, ABILITY_BONUS_12, ABILITY_BONUS_14, ABILITY_BONUS_16, ABILITY_BONUS_19,
	// strength bonus
	STR_BONUS_4, STR_BONUS_6, STR_BONUS_8, STR_BONUS_10, STR_BONUS_12, STR_BONUS_14, STR_BONUS_16, STR_BONUS_19,
	// dexterity bonus
	DEX_BONUS_4, DEX_BONUS_6, DEX_BONUS_8, DEX_BONUS_10, DEX_BONUS_12, DEX_BONUS_14, DEX_BONUS_16, DEX_BONUS_19,
	// constitution bonus
	CON_BONUS_4, CON_BONUS_6, CON_BONUS_8, CON_BONUS_10, CON_BONUS_12, CON_BONUS_14, CON_BONUS_16, CON_BONUS_19,
	// intelligence bonus
	INT_BONUS_4, INT_BONUS_6, INT_BONUS_8, INT_BONUS_10, INT_BONUS_12, INT_BONUS_14, INT_BONUS_16, INT_BONUS_19,
	// wisdom bonus
	WIS_BONUS_4, WIS_BONUS_6, WIS_BONUS_8, WIS_BONUS_10, WIS_BONUS_12, WIS_BONUS_14, WIS_BONUS_16, WIS_BONUS_19,
	// charisma bonus
	CHA_BONUS_4, CHA_BONUS_6, CHA_BONUS_8, CHA_BONUS_10, CHA_BONUS_12, CHA_BONUS_14, CHA_BONUS_16, CHA_BONUS_19,
	// adventuring skills expertise
	EXPERTISE_ATHLETICS, EXPERTISE_ACROBATICS, EXPERTISE_SLEIGHT_OF_HAND, EXPERTISE_STEALTH, EXPERTISE_ARCANA, EXPERTISE_HISTORY, EXPERTISE_INVESTIGATION, EXPERTISE_NATURE, EXPERTISE_RELIGION, EXPERTISE_ANIMAL_HANDLING, EXPERTISE_INSIGHT, EXPERTISE_MEDICINE, EXPERTISE_PERCEPTION, EXPERTISE_SURVIVAL, EXPERTISE_DECEPTION, EXPERTISE_INTIMIDATION, EXPERTISE_PERFORMANCE, EXPERTISE_PERSUASION,
	//
	EXPERTISE_THIEVES_TOOLS,
	/*
	 * GENERIC & SHARED FEATURES
	 */
	STRENGTH_SAVE, DEXTERITY_SAVE, CONSTITUTION_SAVE, INTELLIGENCE_SAVE, WISDOM_SAVE, CHARISMA_SAVE, FIGHTING_STYLE, EXTRA_ATTACK_1, LANDS_STRIDE, TIMELESS_BODY, EVASION, UNCANNY_DODGE,
	/*
	 * BARBARIAN
	 */
	RAGE, RAGE_PER_DAY_2, RAGE_PER_DAY_3, RAGE_PER_DAY_4, RAGE_PER_DAY_5, RAGE_PER_DAY_6, RAGE_PER_DAY_99, RAGE_BONUS_2, RAGE_BONUS_3, RAGE_BONUS_4, UNARMORED_BARBARIAN, RECKLESS_ATTACK, DANGER_SENSE, FAST_MOVEMENT, FERAL_INSTINCT, BRUTAL_CRITICAL_1, RELENTLESS_RAGE, BRUTAL_CRITICAL_2, PERSISTENT_RAGE, BRUTAL_CRITICAL_3, INDOMITABLE_MIGHT, PRIMAL_CHAMPION,
	// berserker
	FRENZY, MINDLESS_RAGE, INTIMIDATING_PRESENCE, RETALIATION,
	// totem warrior
	SPIRIT_SEEKER, BEAR_SPIRIT_3, EAGLE_SPIRIT_3, WOLF_SPIRIT_3, BEAR_ASPECT_6, EAGLE_ASPECT_6, WOLF_ASPECT_6, SPIRIT_WALKER, BEAR_ATTUNEMENT_14, EAGLE_ATTUNEMENT_14, WOLF_ATTUNEMENT_14,
	/*
	 * BARD
	 */
	// FIXME - unused - BARD_CANTRIPS_2, BARD_CANTRIPS_3, BARD_CANTRIPS_4,
	RITUAL_CASTING_BARD, INSPIRATION_D6, JACK_OF_ALL_TRADES, SONG_OF_REST_D6, INSPIRATION_D8, FONT_OF_INSPIRATION, COUNTERCHARM, SONG_OF_REST_D8, INSPIRATION_D10, MAGICAL_SECRETS_10, SONG_OF_REST_D10, MAGICAL_SECRETS_14, INSPIRATION_D12, SONG_OF_REST_D12, MAGICAL_SECRETS_18, SUPERIOR_INSPIRATION,
	// lore college
	CUTTING_WORDS, MAGICAL_SECRETS_6, PEERLESS_SKILL,
	// valor college
	COMBAT_INSPIRATION, BATTLE_MAGIC,
	/*
	 * CLERIC
	 */
	RITUAL_CASTING_CLERIC, CHANNEL_DIVINITY_1, CHANNEL_DIVINITY_2, CHANNEL_DIVINITY_3, POTENT_SPELLCASTING_CLERIC, TURN_UNDEAD, DIVINE_INTERVENTION_10, DIVINE_INTERVENTION_20, DESTROY_UNDEAD_5, DESTROY_UNDEAD_8, DESTROY_UNDEAD_11, DESTROY_UNDEAD_14, DESTROY_UNDEAD_17,
	// domains
	DIVINE_DOMAIN_DEATH, DIVINE_DOMAIN_KNOWLEDGE, DIVINE_DOMAIN_LIFE, DIVINE_DOMAIN_LIGHT, DIVINE_DOMAIN_NATURE, DIVINE_DOMAIN_TEMPEST, DIVINE_DOMAIN_TRICKERY, DIVINE_DOMAIN_WAR,
	// death
	REAPER, TOUCH_OF_DEATH, INESCAPABLE_DESTRUCTION, DIVINE_STRIKE_DEATH, IMPROVED_REAPER,
	// knowledge
	BLESSINGS_OF_KNOWLEDGE, VISIONS_OF_THE_PAST, KNOWLEDGE_OF_THE_AGES, READ_THOUGHTS,
	// life
	DISCIPLE_OF_LIFE, PRESERVE_LIFE, BLESSED_HEALER, DIVINE_STRIKE_LIFE, SUPREME_HEALING,
	// light
	WARDING_FLARE, RADIANCE_OF_THE_DAWN, IMPROVED_FLARE, CORONA_OF_LIGHT,
	// nature
	CHARM_ANIMALS_AND_PLANTS, DAMPEN_ELEMENTS, DIVINE_STRIKE_NATURE, MASTER_OF_NATURE,
	// tempest
	WRATH_OF_THE_STORM, DESTRUCTIVE_WRATH, THUNDERBOLT_STRIKE, DIVINE_STRIKE_TEMPEST, STORMBORN,
	// trickery
	BLESSING_OF_THE_TRICKSTER, INVOKE_DUPLICITY, TRICKERY_CLOAK, DIVINE_STRIKE_TRICKERY, IMPROVED_DUPLICITY,
	// war
	WAR_PRIEST, GUIDED_STRIKE, WAR_GODS_BLESSING, DIVINE_STRIKE_WAR, AVATAR_OF_BATTLE,
	/*
	 * DRUID
	 */
	RITUAL_CASTING_DRUID, WILD_SHAPE_2, WILD_SHAPE_4, WILD_SHAPE_8, BEAST_SPELLS, ARCHDRUID,
	// land circle
	NATURAL_RECOVERY, CIRCLE_SPELLS_ARCTIC, CIRCLE_SPELLS_COAST, CIRCLE_SPELLS_DESERT, CIRCLE_SPELLS_, CIRCLE_SPELLS_FOREST, CIRCLE_SPELLS_GRASSLAND, CIRCLE_SPELLS_MOUNTAIN, CIRCLE_SPELLS_SWAMP, CIRCLE_SPELLS_UNDERDARK, NATURES_WARD, NATURES_SANCTUARY,
	// moon circle
	COMBAT_WILD_SHAPE, MOON_SHAPE_2, MOON_SHAPE_6, MOON_SHAPE_9, MOON_SHAPE_12, MOON_SHAPE_15, MOON_SHAPE_18, PRIMAL_STRIKE, ELEMENTAL_SHAPE, THOUSAND_FORMS,
	/*
	 * FIGHTER
	 */
	SECOND_WIND, ACTION_SURGE_2, ACTION_SURGE_17, EXTRA_ATTACK_2, EXTRA_ATTACK_3, INDOMITABLE_1, INDOMITABLE_2, INDOMITABLE_3,
	// fighting style
	STYLE_ARCHERY, STYLE_DEFENSE, STYLE_DUELING, STYLE_GREAT_WEAPON, STYLE_PROTECTION, STYLE_TWO_WEAPON,
	// champion
	IMPROVED_CRITICAL, REMARKABLE_ATHLETE, ADDITIONAL_FIGHTING_STYLE, SUPERIOR_CRITICAL, SURVIVOR,
	// battle master
	COMBAT_SUPERIORITY, STUDENT_OF_WAR, KNOW_YOUR_ENEMY, RELENTLESS_FIGHTER, SUPERIORITY_DICE_4, SUPERIORITY_DICE_5, SUPERIORITY_DICE_6, SUPERIORITY_D8, SUPERIORITY_D10, SUPERIORITY_D12,
	// maneuvers
	COMMANDERS_STRIKE, DISARMING_ATTACK, DISTRACTING_STRIKE, EVASIVE_FOOTWORK, FEINTING_ATTACK, GOADING_ATTACK, LUNGING_ATTACK, MANEUVERING_ATTACK, MENACING_ATTACK, PARRY, PRECISION_ATTACK, PUSHING_ATTACK, RALLY, RIPOSTE, SWEEPING_ATTACK, TRIP_ATTACK,
	// eldritch knight
	WEAPON_BOND, WAR_MAGIC, ELDRITCH_STRIKE, ARCANE_CHARGE, IMPROVED_WAR_MAGIC,
	/*
	 * MONK
	 */
	UNARMORED_MONK, MARTIAL_ARTS_D4, MARTIAL_ARTS_D6, MARTIAL_ARTS_D8, MARTIAL_ARTS_D10, MONK_MOVE_2, MONK_MOVE_6, MONK_MOVE_10, MONK_MOVE_14, MONK_MOVE_18, WALL_RUNNING, DEFLECT_MISSILES, SLOW_FALL, KI_STRIKE, STILLNESS_OF_MIND, PURITY_OF_BODY, TONGUE_OF_SUN_MOON, PERFECT_SELF,
	// ki powers
	KI_POWERS, FLURRY_OF_BLOWS, PATIENT_DEFENSE, STEP_OF_THE_WIND, STUNNING_STRIKE, DIAMOND_SOUL, EMPTY_BODY,
	// open hand
	OPEN_HAND_TECHNIQUE, WHOLENESS_OF_BODY, TRANQUILITY, QUIVERING_PALM,
	// shadow
	SHADOW_ARTS, SHADOW_STEP, SHADOW_CLOAK, OPPORTUNIST,
	// four elements
	ELEMENTAL_ATTUNEMENT, FANGS_OF_FIRE_SNAKE, FIST_OF_FOUR_THUNDERS, FIST_OF_UNBROKEN_AIR, RUSH_OF_GALE_SPIRITS, SHAPE_OF_FLOWING_RIVER, SWEEPING_CINDER_STRIKE, WATER_WHIP, CLENCH_OF_NORTH_WIND_6, GONG_OF_THE_SUMMIT_6, ETERNAL_MOUNTAIN_11, FLAMES_OF_PHOENIX_11, MIST_STANCE_11, RIDE_THE_WIND_11, BREATH_OF_WINTER_17, RIVER_OF_HUNGRY_FLAME_17, WAVE_OF_ROLLING_EARTH_17,
	/*
	 * PALADIN
	 */
	DIVINE_SENSE, LAY_ON_HANDS, DIVINE_SMITE, DIVINE_HEALTH, AURA_OF_PROTECTION, AURA_OF_COURAGE, IMPROVED_SMITE, CLEANSING_TOUCH, IMPROVED_AURA_18,
	// devotion
	SACRED_WEAPON, TURN_THE_UNHOLY, AURA_OF_DEVOTION, PURITY_OF_SPIRIT, HOLY_NIMBUS,
	// ancients
	NATURES_WRATH, TURN_THE_FAITHLESS, AURA_OF_WARDING, UNDYING_SENTINEL, ELDER_CHAMPION,
	// vengeance
	ABJURE_ENEMY, VOW_OF_ENMITY, RELENTLESS_AVENGER, SOUL_OF_VENGEANCE, AVENGING_ANGEL,
	// oathbreaker
	CONTROL_UNDEAD, DREADFUL_ASPECT, AURA_OF_HATE, SUPERNATURAL_RESISTANCE, DREAD_LORD,
	/*
	 * RANGER
	 */
	FAVORED_ENEMY, NATURAL_EXPLORER, PRIMEVAL_AWARENESS, HIDE_IN_PLAIN_SIGHT, VANISH, FERAL_SENSES, FOE_SLAYER,
	// enemies
	ENEMY_ABERRATIONS, ENEMY_BEASTS, ENEMY_CELESTIALS, ENEMY_CONSTRUCTS, ENEMY_DRAGONS, ENEMY_ELEMENTALS, ENEMY_FEY, ENEMY_FIENDS, ENEMY_GIANTS, ENEMY_MONSTROSITIES, ENEMY_OOZES, ENEMY_PLANTS, ENEMY_UNDEAD,
	// terrain
	EXPLORER_ARCTIC, EXPLORER_COAST, EXPLORER_DESERT, EXPLORER_FOREST, EXPLORER_GRASSLAND, EXPLORER_MOUNTAIN, EXPLORER_SWAMP, EXPLORER_UNDERDARK,
	// hunter
	COLOSSUS_SLAYER, GIANT_KILLER, HORDE_BREAKER, ESCAPE_THE_HORDE, MULTIATTACK_DEFENSE, STEEL_WILL, VOLLEY, WHIRLWIND_ATTACK, STAND_AGAINST_THE_TIDE,
	// beast master
	RANGERS_COMPANION, BEAST_TRAINING, BESTIAL_FURY, SHARE_SPELLS,
	/*
	 * ROGUE
	 */
	SNEAK_ATTACK_1, SNEAK_ATTACK_2, SNEAK_ATTACK_3, SNEAK_ATTACK_4, SNEAK_ATTACK_5, SNEAK_ATTACK_6, SNEAK_ATTACK_7, SNEAK_ATTACK_8, SNEAK_ATTACK_9, SNEAK_ATTACK_10, CUNNING_ACTION, RELIABLE_TALENT, BLINDSENSE, SLIPPERY_MIND, ELUSIVE, STROKE_OF_LUCK,
	// thief
	FAST_HANDS, SECOND_STORY_WORK, SUPREME_SNEAK, USE_MAGIC_DEVICE, THIEFS_REFLEXES,
	// assassin
	ASSASSINATE, INFILTRATION_EXPERTISE, IMPOSTOR, DEATH_STRIKE,
	// arcane trickster
	MAGE_HAND_LEGERDEMAIN, MAGICAL_AMBUSH, VERSATILE_TRICKSTER, SPELL_THIEF,
	/*
	 * SORCERER
	 */
	FONT_OF_MAGIC, FLEXIBLE_CASTING, SORCEROUS_RESTORATION,
	// metamagic
	CAREFUL_SPELL, DISTANCE_SPELL, EMPOWERED_SPELL, EXTENDED_SPELL, HEIGHTENED_SPELL, QUICKENED_SPELL, SUBTLE_SPELL, TWINNED_SPELL,
	// draconic
	ANCESTRY_FIRE, ANCESTRY_COLD, ANCESTRY_LIGHTNING, ANCESTRY_ACID, ANCESTRY_POISON, DRACONIC_RESILIENCE, ELEMENTAL_AFFINITY, DRAGON_WINGS, DRACONIC_PRESENCE,
	// wild magic
	WILD_MAGIC_SURGE, TIDES_OF_CHAOS, BEND_LUCK, CONTROLLED_CHAOS, SPELL_BOMBARDMENT,
	/*
	 * WARLOCK
	 */
	PACT_OF_THE_CHAIN, PACT_OF_THE_BLADE, PACT_OF_THE_TOME, WARLOCK_SLOT_1, WARLOCK_SLOT_2, WARLOCK_SLOT_3, WARLOCK_SLOT_4, MYSTIC_ARCANUM_11, MYSTIC_ARCANUM_13, MYSTIC_ARCANUM_15, MYSTIC_ARCANUM_17, ELDRITCH_MASTER,
	// invocations
	ARMOR_OF_SHADOWS, BEAST_SPEECH, BEGUILING_INFLUENCE, DEVILS_SIGHT, ELDRITCH_SIGHT, EYES_OF_THE_KEEPER, FIENDISH_VIGOR, GAZE_OF_TWO_MINDS, MASK_OF_MANY_FACES, MISTY_VISIONS, THIEF_OF_FIVE_FATES, MIRE_OF_THE_MIND_5, ONE_WITH_SHADOWS_5, SIGN_OF_ILL_OMEN_5, BEWITCHING_WHISPERS_7, DREADFUL_WORD_7, SCULPTOR_OF_FLESH_7, ASCENDANT_STEP_9, MINIONS_OF_CHAOS_9, OTHERWORLDLY_LEAP_9, WHISPERS_OF_THE_GRAVE_9, MASTER_OF_MYRIAD_FORMS_15, VISIONS_OF_DISTANT_REALMS_15, WITCH_SIGHT_15,
	// prereqs
	AGONIZING_BLAST, BOOK_OF_ANCIENT_SECRETS, ELDRITCH_SPEAR, REPELLING_BLAST, VOICE_OF_THE_CHAIN_MASTER, THIRSTING_BLADE_5, LIFEDRINKER_12, CHAINS_OF_CARCERI_15,
	// fey pact
	FEY_PRESENCE, MISTY_ESCAPE, BEGUILING_DEFENSES, DARK_DELIRIUM,
	// fiend pact
	DARK_ONES_BLESSING, DARK_ONES_OWN_LUCK, FIENDISH_RESILIENCE, HURL_THROUGH_HELL,
	// eldritch pact
	AWAKENED_MIND, ENTROPIC_WARD, THOUGHT_SHIELD, CREATE_THRALL,
	/*
	 * WIZARD
	 */
	RITUAL_CASTING_WIZARD, ARCANE_RECOVERY, SPELL_MASTERY, SIGNATURE_SPELL,
	// abjuration
	ABJURATION_SAVANT, ARCANE_WARD, PROJECTED_WARD, IMPROVED_ABJURATION, ABJURER_RESISTANCE,
	// conjuration
	CONJURATION_SAVANT, MINOR_CONJURATION, BENIGN_TRANSPOSITION, FOCUSED_CONJURATION, DURABLE_SUMMONS,
	// divination
	DIVINATION_SAVANT, PORTENT, EXPERT_DIVINATION, THE_THIRD_EYE, GREATER_PORTENT,
	// enchantment
	ENCHANTMENT_SAVANT, HYPNOTIC_GAZE, INSTINCTIVE_CHARM, SPLIT_ENCHANTMENT, ALTER_MEMORIES,
	// evocation
	EVOCATION_SAVANT, SCULPT_SPELLS, POTENT_CANTRIP, EMPOWERED_EVOCATION, OVERCHANNEL,
	// illusion
	ILLUSION_SAVANT, IMPROVED_MINOR_ILLUSION, MALLEABLE_ILLUSIONS, ILLUSORY_SELF, ILLUSORY_REALITY,
	// necromancy
	NECROMANCY_SAVANT, GRIM_HARVEST, UNDEAD_THRALLS, INURED_TO_DEATH, COMMAND_UNDEAD,
	// transmutation
	TRANSMUTATION_SAVANT, MINOR_ALCHEMY, TRANSMUTERS_STONE, SHAPECHANGER, MASTER_TRANSMUTER,

	/*
	 * END OF FEATURES
	 */
	;

	/*
	 * STATIC METHODS
	 */
	public static void applyRacialFeatures(Hero actor) {
		EnumSet<Language> languages = actor.getLanguages();
		EnumSet<Feature> features = actor.getFeatures();
		EnumSet<Skill> skills = actor.getSkills();

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
			skills.add(Skill.PERCEPTION);
			features.add(FEY_ANCESTRY);
			features.add(ELF_TRANCE);
			//
			languages.add(Language.ELVISH);

			if (race.equals(Race.HIGH_ELF)) {
				actor.setIntelligence(actor.getIntelligence() + 1);
				features.add(DARKVISION_60);
				//
				features.add(ELF_WEAPON_TRAINING);
				skills.add(Skill.LONGBOW);
				skills.add(Skill.LONGSWORD);
				skills.add(Skill.SHORTBOW);
				skills.add(Skill.SHORTSWORD);
				// TODO - random cantrip
				// TODO - random common language

			} else if (race.equals(Race.WOOD_ELF)) {
				actor.setWisdom(actor.getWisdom() + 1);
				features.add(DARKVISION_60);
				//
				features.add(FLEET_OF_FOOT);
				// TODO - increase base movement
				features.add(MASK_OF_THE_WILD);
				//
				features.add(ELF_WEAPON_TRAINING);
				skills.add(Skill.LONGBOW);
				skills.add(Skill.LONGSWORD);
				skills.add(Skill.SHORTBOW);
				skills.add(Skill.SHORTSWORD);

			} else if (race.equals(Race.DARK_ELF)) {
				actor.setCharisma(actor.getCharisma() + 1);
				features.add(DARKVISION_120);
				features.add(SUNLIGHT_SENSITIVITY);
				//
				features.add(DROW_WEAPON_TRAINING);
				skills.add(Skill.HAND_CROSSBOW);
				skills.add(Skill.RAPIER);
				skills.add(Skill.SHORTSWORD);
				// TODO - dancing lights cantrip

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
				// TODO - add cantrip

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
			// TODO - add another language
			// TODO - add 2 skills

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
			skills.add(Skill.INTIMIDATION);

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
			skills.add(Skill.BATTLEAXE);
			skills.add(Skill.HANDAXE);
			skills.add(Skill.LIGHT_HAMMER);
			skills.add(Skill.WARHAMMER);
			//
			skills.add(Misc.randomFromArray(Skill.DWARF_TOOLS));
			features.add(Feature.STONECUNNING);
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
				skills.addAll(Skill.lightAndMediumArmorList());

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
			// TODO - add language

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
				features.add(Feature.STOUT_RESILIENCE);

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
			// TODO - add spell-like ability
			
			break;
		}

		actor.setLanguages(languages);
		actor.setFeatures(features);
		actor.setSkills(skills);
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
