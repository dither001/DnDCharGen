package com.dnd5e.magic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.dnd5e.character.classes.*;
import com.miscellaneous.util.Misc;

public enum Spell {
	// SYSTEM REFERENCE DOCUMENT
	ACID_ARROW, ACID_SPLASH, AID, ALARM, ALTER_SELF, ANIMAL_FRIENDSHIP, ANIMAL_MESSENGER, ANIMAL_SHAPES, ANIMATE_DEAD, ANIMATE_OBJECTS, ANTILIFE_SHELL, ANTIMAGIC_FIELD, ANTIPATHY_SYMPATHY, ARCANE_EYE, ARCANE_HAND, ARCANE_LOCK, ARCANE_SWORD, MAGIC_AURA, ASTRAL_PROJECTION, AUGURY, AWAKEN, BANE, BANISHMENT, BARKSKIN, BEACON_OF_HOPE, BESTOW_CURSE, BLACK_TENTACLES, BLADE_BARRIER, BLESS, BLIGHT, BLINDNESS_DEAFNESS, BLINK, BLUR, BRANDING_SMITE, BURNING_HANDS, CALL_LIGHTNING, CALM_EMOTIONS, CHAIN_LIGHTNING, CHARM_PERSON, CHILL_TOUCH, CIRCLE_OF_DEATH, CLAIRVOYANCE, CLONE, CLOUDKILL, COLOR_SPRAY, COMMAND, COMMUNE, COMMUNE_WITH_NATURE, COMPREHEND_LANGUAGES, COMPULSION, CONE_OF_COLD, CONFUSION, CONJURE_ANIMALS, CONJURE_CELESTIAL, CONJURE_ELEMENTAL, CONJURE_FEY, CONJURE_MINOR_ELEMENTALS, CONJURE_WOODLAND_BEINGS, CONTACT_OTHER_PLANE, CONTAGION, CONTINGENCY, CONTINUAL_FLAME, CONTROL_WATER, CONTROL_WEATHER, COUNTERSPELL, CREATE_FOOD_AND_WATER, CREATE_OR_DESTROY_WATER, CREATE_UNDEAD, CREATION, CURE_WOUNDS, DANCING_LIGHTS, DARKNESS, DARKVISION, DAYLIGHT, DEATH_WARD, DELAYED_BLAST_FIREBALL, DEMIPLANE, DETECT_EVIL_AND_GOOD, DETECT_MAGIC, DETECT_POISON_AND_DISEASE, DETECT_THOUGHTS, DIMENSION_DOOR, DISGUISE_SELF, DISINTEGRATE, DISPEL_EVIL_AND_GOOD, DISPEL_MAGIC, DIVINATION, DIVINE_FAVOR, DIVINE_WORD, DOMINATE_BEAST, DOMINATE_MONSTER, DOMINATE_PERSON, DREAM, DRUIDCRAFT, EARTHQUAKE, ELDRITCH_BLAST, ENHANCE_ABILITY, ENLARGE_REDUCE, ENTANGLE, ENTHRALL, ETHEREALNESS, EXPEDITIOUS_RETREAT, EYEBITE, FABRICATE, FAERIE_FIRE, FAITHFUL_HOUND, FALSE_LIFE, FEAR, FEATHER_FALL, FEEBLEMIND, FIND_FAMILIAR, FIND_STEED, FIND_THE_PATH, FIND_TRAPS, FINGER_OF_DEATH, FIREBALL, FIRE_BOLT, FIRE_SHIELD, FIRE_STORM, FLAME_BLADE, FLAME_STRIKE, FLAMING_SPHERE, FLESH_TO_STONE, FLOATING_DISK, FLY, FOG_CLOUD, FORBIDDANCE, FORCECAGE, FORESIGHT, FREEDOM_OF_MOVEMENT, FREEZING_SPHERE, GASEOUS_FORM, GATE, GEAS, GENTLE_REPOSE, GIANT_INSECT, GLIBNESS, GLOBE_OF_INVULNERABILITY, GLYPH_OF_WARDING, GOODBERRY, GREASE, GREATER_INVISIBILITY, GREATER_RESTORATION, GUARDIAN_OF_FAITH, GUARDS_AND_WARDS, GUIDANCE, GUIDING_BOLT, GUST_OF_WIND, HALLOW, HALLUCINATORY_TERRAIN, HARM, HASTE, HEAL, HEALING_WORD, HEAT_METAL, HELLISH_REBUKE, HEROES_FEAST, HEROISM, HIDEOUS_LAUGHTER, HOLD_MONSTER, HOLD_PERSON, HOLY_AURA, HUNTERS_MARK, HYPNOTIC_PATTERN, ICE_STORM, IDENTIFY, ILLUSORY_SCRIPT, IMPRISONMENT, INCENDIARY_CLOUD, INFLICT_WOUNDS, INSECT_PLAGUE, INSTANT_SUMMONS, INVISIBILITY, IRRESISTIBLE_DANCE, JUMP, KNOCK, LEGEND_LORE, LESSER_RESTORATION, LEVITATE, LIGHT, LIGHTNING_BOLT, LOCATE_ANIMALS_OR_PLANTS, LOCATE_CREATURE, LOCATE_OBJECT, LONGSTRIDER, MAGE_ARMOR, MAGE_HAND, MAGIC_CIRCLE, MAGIC_JAR, MAGIC_MISSILE, MAGIC_MOUTH, MAGIC_WEAPON, MAGNIFICENT_MANSION, MAJOR_IMAGE, MASS_CURE_WOUNDS, MASS_HEAL, MASS_HEALING_WORD, MASS_SUGGESTION, MAZE, MELD_INTO_STONE, MENDING, MESSAGE, METEOR_SWARM, MIND_BLANK, MINOR_ILLUSION, MIRAGE_ARCANE, MIRROR_IMAGE, MISLEAD, MISTY_STEP, MODIFY_MEMORY, MOONBEAM, MOVE_EARTH, NONDETECTION, PASS_WITHOUT_TRACE, PASSWALL, PHANTASMAL_KILLER, PHANTOM_STEED, PLANAR_ALLY, PLANAR_BINDING, PLANE_SHIFT, PLANT_GROWTH, POISON_SPRAY, POLYMORPH, POWER_WORD_KILL, POWER_WORD_STUN, PRAYER_OF_HEALING, PRESTIDIGITATION, PRISMATIC_SPRAY, PRISMATIC_WALL, PRIVATE_SANCTUM, PRODUCE_FLAME, PROGRAMMED_ILLUSION, PROJECT_IMAGE, PROTECTION_FROM_ENERGY, PROTECTION_FROM_EVIL, PROTECTION_FROM_POISON, PURIFY_FOOD_AND_DRINK, RAISE_DEAD, RAY_OF_ENFEEBLEMENT, RAY_OF_FROST, REGENERATE, REINCARNATE, REMOVE_CURSE, RESILIENT_SPHERE, RESISTANCE, RESURRECTION, REVERSE_GRAVITY, REVIVIFY, ROPE_TRICK, SACRED_FLAME, SANCTUARY, SCORCHING_RAY, SCRYING, SECRET_CHEST, SEE_INVISIBILITY, SEEMING, SENDING, SEQUESTER, SHAPECHANGE, SHATTER, SHIELD, SHIELD_OF_FAITH, SHILLELAGH, SHOCKING_GRASP, SILENCE, SILENT_IMAGE, SIMULACRUM, SLEEP, SLEET_STORM, SLOW, SPARE_THE_DYING, SPEAK_WITH_ANIMALS, SPEAK_WITH_DEAD, SPEAK_WITH_PLANTS, SPIDER_CLIMB, SPIKE_GROWTH, SPIRIT_GUARDIANS, SPIRITUAL_WEAPON, STINKING_CLOUD, STONE_SHAPE, STONESKIN, STORM_OF_VENGEANCE, SUGGESTION, SUNBEAM, SUNBURST, SYMBOL, TELEKINESIS, TELEPATHIC_BOND, TELEPORT, TELEPORTATION_CIRCLE, THAUMATURGY, THUNDERWAVE, TIME_STOP, TINY_HUT, TONGUES, TRANSPORT_VIA_PLANTS, TREE_STRIDE, TRUE_POLYMORPH, TRUE_RESURRECTION, TRUE_SEEING, TRUE_STRIKE, UNSEEN_SERVANT, VAMPIRIC_TOUCH, VICIOUS_MOCKERY, WALL_OF_FIRE, WALL_OF_FORCE, WALL_OF_ICE, WALL_OF_STONE, WALL_OF_THORNS, WARDING_BOND, WATER_BREATHING, WATER_WALK, WEB, WEIRD, WIND_WALK, WIND_WALL, WISH, WORD_OF_RECALL, ZONE_OF_TRUTH,

	// PLAYER'S HANDBOOK
	BLADE_WARD, FRIENDS, DISSONANT_WHISPERS, CLOUD_OF_DAGGERS, CROWN_OF_MADNESS, PHANTASMAL_FORCE, FEIGN_DEATH, MIRAGE_ARCANA, POWER_WORD_HEAL, THORN_WHIP, BEAST_SENSE, TSUNAMI, COMPELLED_DUEL, SEARING_SMITE, THUNDEROUS_SMITE, WRATHFUL_SMITE, AURA_OF_VITALITY, BLINDING_SMITE, ELEMENTAL_WEAPON, AURA_OF_LIFE, AURA_OF_PURITY, STAGGERING_SMITE, BANISHING_SMITE, CIRCLE_OF_POWER, DESTRUCTIVE_WAVE, ENSNARING_STRIKE, HAIL_OF_THORNS, CORDON_OF_ARROWS, CONJURE_BARRAGE, LIGHTNING_ARROW, CONJURE_VOLLEY, SWIFT_QUIVER, FIREBOLT, CHROMATIC_ORB, RAY_OF_SICKNESS, WITCH_BOLT, GRASPING_VINE, CRUSADERS_MANTLE, ARCANE_GATE, ARMOR_OF_AGATHYS, ARMS_OF_HADAR, HEX, HUNGER_OF_HADAR, TELEPATHY

	// END OF SPELLS
	;

	/*
	 * SPELLS KNOWN (NUMBER OF)
	 */

	//
	private static final int[] BARD_KNOWN = { 4, 5, 6, 7, 8, 9, 10, 11, 12, 12, 13, 13, 14, 14, 15, 15, 16, 16, 16,
			16 };

	// used by ELDRITCH_KNIGHT fighter and ARCANE_TRICKSTER rogue
	private static final int[] FIGHTER_KNOWN = { 0, 0, 3, 4, 4, 4, 5, 6, 6, 7, 8, 8, 9, 10, 10, 11, 11, 11, 12, 13 };
	private static final int[] RANGER_KNOWN = { 0, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11 };
	private static final int[] SORCERER_KNOWN = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 12, 13, 13, 14, 14, 15, 15, 15,
			15 };
	private static final int[] WARLOCK_KNOWN = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 11, 11, 12, 12, 13, 13, 14, 14, 15,
			15 };

	/*
	 * SPELL SLOTS
	 */

	// used by ELDRITCH_KNIGHT fighter and ARCANE_TRICKSTER rogue
	private static final int[][] FIGHTER_SLOTS = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 2, 0, 0, 0 }, { 3, 0, 0, 0 },
			{ 3, 0, 0, 0 }, { 3, 0, 0, 0 }, { 4, 2, 0, 0 }, { 4, 2, 0, 0 }, { 4, 2, 0, 0 }, { 4, 3, 0, 0 },
			{ 4, 3, 0, 0 }, { 4, 3, 0, 0 }, { 4, 3, 2, 0 }, { 4, 3, 2, 0 }, { 4, 3, 2, 0 }, { 4, 3, 3, 0 },
			{ 4, 3, 3, 0 }, { 4, 3, 3, 0 }, { 4, 3, 3, 1 }, { 4, 3, 3, 1 } };
	private static final int[][] ROGUE_SLOTS = FIGHTER_SLOTS;

	// used by paladin and ranger
	private static final int[][] PALADIN_SLOTS = { { 0, 0, 0, 0, 0 }, { 2, 0, 0, 0, 0 }, { 3, 0, 0, 0, 0 },
			{ 3, 0, 0, 0, 0 }, { 4, 2, 0, 0, 0 }, { 4, 2, 0, 0, 0 }, { 4, 3, 0, 0, 0 }, { 4, 3, 0, 0, 0 },
			{ 4, 3, 2, 0, 0 }, { 4, 3, 2, 0, 0 }, { 4, 3, 3, 0, 0 }, { 4, 3, 3, 0, 0 }, { 4, 3, 3, 1, 0 },
			{ 4, 3, 3, 1, 0 }, { 4, 3, 3, 2, 0 }, { 4, 3, 3, 2, 0 }, { 4, 3, 3, 3, 1 }, { 4, 3, 3, 3, 1 },
			{ 4, 3, 3, 3, 2 }, { 4, 3, 3, 3, 2 } };
	private static final int[][] RANGER_SLOTS = PALADIN_SLOTS;

	// used exclusively by warlock
	private static final int[][] WARLOCK_SLOTS = { { 1, 0, 0, 0, 0 }, { 2, 0, 0, 0, 0 }, { 0, 2, 0, 0, 0 },
			{ 0, 2, 0, 0, 0 }, { 0, 0, 2, 0, 0 }, { 0, 0, 2, 0, 0 }, { 0, 0, 0, 2, 0 }, { 0, 0, 0, 2, 0 },
			{ 0, 0, 0, 0, 2 }, { 0, 0, 0, 0, 2 }, { 0, 0, 0, 0, 3 }, { 0, 0, 0, 0, 3 }, { 0, 0, 0, 0, 3 },
			{ 0, 0, 0, 0, 3 }, { 0, 0, 0, 0, 3 }, { 0, 0, 0, 0, 3 }, { 0, 0, 0, 0, 4 }, { 0, 0, 0, 0, 4 },
			{ 0, 0, 0, 0, 4 }, { 0, 0, 0, 0, 4 } };

	// used by bard, cleric, druid, sorcerer, and wizard
	private static int[][] WIZARD_SLOTS = { { 2, 0, 0, 0, 0, 0, 0, 0, 0 }, { 3, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 4, 2, 0, 0, 0, 0, 0, 0, 0 }, { 4, 3, 0, 0, 0, 0, 0, 0, 0 }, { 4, 3, 2, 0, 0, 0, 0, 0, 0 },
			{ 4, 3, 3, 0, 0, 0, 0, 0, 0 }, { 4, 3, 3, 1, 0, 0, 0, 0, 0 }, { 4, 3, 3, 2, 0, 0, 0, 0, 0 },
			{ 4, 3, 3, 3, 1, 0, 0, 0, 0 }, { 4, 3, 3, 3, 2, 0, 0, 0, 0 }, { 4, 3, 3, 3, 2, 1, 0, 0, 0 },
			{ 4, 3, 3, 3, 2, 1, 0, 0, 0 }, { 4, 3, 3, 3, 2, 1, 1, 0, 0 }, { 4, 3, 3, 3, 2, 1, 1, 0, 0 },
			{ 4, 3, 3, 3, 2, 1, 1, 1, 0 }, { 4, 3, 3, 3, 2, 1, 1, 1, 0 }, { 4, 3, 3, 3, 2, 1, 1, 1, 1 },
			{ 4, 3, 3, 3, 3, 1, 1, 1, 1 }, { 4, 3, 3, 3, 3, 2, 1, 1, 1 }, { 4, 3, 3, 3, 3, 2, 2, 1, 1 } };
	private static int[][] BARD_SLOTS = WIZARD_SLOTS;
	private static int[][] CLERIC_SLOTS = WIZARD_SLOTS;
	private static int[][] DRUID_SLOTS = WIZARD_SLOTS;
	private static int[][] SORCERER_SLOTS = WIZARD_SLOTS;

	/*
	 * SPELL LISTS
	 */
	public static final Spell[] CANTRIPS = { ACID_SPLASH, CHILL_TOUCH, DANCING_LIGHTS, DRUIDCRAFT, ELDRITCH_BLAST,
			FIRE_BOLT, GUIDANCE, LIGHT, MAGE_HAND, MENDING, MESSAGE, MINOR_ILLUSION, POISON_SPRAY, PRESTIDIGITATION,
			PRODUCE_FLAME, RAY_OF_FROST, RESISTANCE, SACRED_FLAME, SHILLELAGH, SHOCKING_GRASP, SPARE_THE_DYING,
			THAUMATURGY, TRUE_STRIKE, VICIOUS_MOCKERY };

	public static final Spell[][] SPELLS_BY_LEVEL = { CANTRIPS,
			{ ALARM, ANIMAL_FRIENDSHIP, BANE, BLESS, BURNING_HANDS, CHARM_PERSON, COLOR_SPRAY, COMMAND,
					COMPREHEND_LANGUAGES, CREATE_OR_DESTROY_WATER, CURE_WOUNDS, DETECT_EVIL_AND_GOOD, DETECT_MAGIC,
					DETECT_POISON_AND_DISEASE, DISGUISE_SELF, DIVINE_FAVOR, ENTANGLE, EXPEDITIOUS_RETREAT, FAERIE_FIRE,
					FALSE_LIFE, FEATHER_FALL, FIND_FAMILIAR, FLOATING_DISK, FOG_CLOUD, GOODBERRY, GREASE, GUIDING_BOLT,
					HEALING_WORD, HELLISH_REBUKE, HEROISM, HIDEOUS_LAUGHTER, HUNTERS_MARK, IDENTIFY, ILLUSORY_SCRIPT,
					INFLICT_WOUNDS, JUMP, LONGSTRIDER, MAGE_ARMOR, MAGIC_MISSILE, PROTECTION_FROM_EVIL,
					PURIFY_FOOD_AND_DRINK, SANCTUARY, SHIELD, SHIELD_OF_FAITH, SILENT_IMAGE, SLEEP, SPEAK_WITH_ANIMALS,
					THUNDERWAVE, UNSEEN_SERVANT },
			{ ACID_ARROW, AID, ALTER_SELF, ANIMAL_MESSENGER, ARCANE_LOCK, MAGIC_AURA, AUGURY, BARKSKIN,
					BLINDNESS_DEAFNESS, BLUR, BRANDING_SMITE, CALM_EMOTIONS, CONTINUAL_FLAME, DARKNESS, DARKVISION,
					DETECT_THOUGHTS, ENHANCE_ABILITY, ENLARGE_REDUCE, ENTHRALL, FIND_STEED, FIND_TRAPS, FLAME_BLADE,
					FLAMING_SPHERE, GENTLE_REPOSE, GUST_OF_WIND, HEAT_METAL, HOLD_PERSON, INVISIBILITY, KNOCK,
					LESSER_RESTORATION, LEVITATE, LOCATE_ANIMALS_OR_PLANTS, LOCATE_OBJECT, MAGIC_MOUTH, MAGIC_WEAPON,
					MIRROR_IMAGE, MISTY_STEP, MOONBEAM, PASS_WITHOUT_TRACE, PRAYER_OF_HEALING, PROTECTION_FROM_POISON,
					RAY_OF_ENFEEBLEMENT, ROPE_TRICK, SCORCHING_RAY, SEE_INVISIBILITY, SHATTER, SILENCE, SPIDER_CLIMB,
					SPIKE_GROWTH, SPIRITUAL_WEAPON, SUGGESTION, WARDING_BOND, WEB, ZONE_OF_TRUTH },
			{ ANIMATE_DEAD, BEACON_OF_HOPE, BESTOW_CURSE, BLINK, CALL_LIGHTNING, CLAIRVOYANCE, CONJURE_ANIMALS,
					COUNTERSPELL, CREATE_FOOD_AND_WATER, DAYLIGHT, DISPEL_MAGIC, FEAR, FIREBALL, FLY, GASEOUS_FORM,
					GLYPH_OF_WARDING, HASTE, HYPNOTIC_PATTERN, LIGHTNING_BOLT, MAGIC_CIRCLE, MAJOR_IMAGE,
					MASS_HEALING_WORD, MELD_INTO_STONE, NONDETECTION, PHANTOM_STEED, PLANT_GROWTH,
					PROTECTION_FROM_ENERGY, REMOVE_CURSE, REVIVIFY, SENDING, SLEET_STORM, SLOW, SPEAK_WITH_DEAD,
					SPEAK_WITH_PLANTS, SPIRIT_GUARDIANS, STINKING_CLOUD, TINY_HUT, TONGUES, VAMPIRIC_TOUCH,
					WATER_BREATHING, WATER_WALK, WIND_WALL },
			{ ARCANE_EYE, BANISHMENT, BLACK_TENTACLES, BLIGHT, COMPULSION, CONFUSION, CONJURE_MINOR_ELEMENTALS,
					CONJURE_WOODLAND_BEINGS, CONTROL_WATER, DEATH_WARD, DIMENSION_DOOR, DIVINATION, DOMINATE_BEAST,
					FABRICATE, FAITHFUL_HOUND, FIRE_SHIELD, FREEDOM_OF_MOVEMENT, GIANT_INSECT, GREATER_INVISIBILITY,
					GUARDIAN_OF_FAITH, HALLUCINATORY_TERRAIN, ICE_STORM, LOCATE_CREATURE, PHANTASMAL_KILLER, POLYMORPH,
					PRIVATE_SANCTUM, RESILIENT_SPHERE, SECRET_CHEST, STONE_SHAPE, STONESKIN, WALL_OF_FIRE },
			{ ANIMATE_OBJECTS, ANTILIFE_SHELL, ARCANE_HAND, AWAKEN, CLOUDKILL, COMMUNE, COMMUNE_WITH_NATURE,
					CONE_OF_COLD, CONJURE_ELEMENTAL, CONTACT_OTHER_PLANE, CONTAGION, CREATION, DISPEL_EVIL_AND_GOOD,
					DOMINATE_PERSON, DREAM, FLAME_STRIKE, GEAS, GREATER_RESTORATION, HALLOW, HOLD_MONSTER,
					INSECT_PLAGUE, LEGEND_LORE, MASS_CURE_WOUNDS, MISLEAD, MODIFY_MEMORY, PASSWALL, PLANAR_BINDING,
					RAISE_DEAD, REINCARNATE, SCRYING, SEEMING, TELEKINESIS, TELEPATHIC_BOND, TELEPORTATION_CIRCLE,
					TREE_STRIDE, WALL_OF_FORCE, WALL_OF_STONE },
			{ BLADE_BARRIER, CHAIN_LIGHTNING, CIRCLE_OF_DEATH, CONJURE_FEY, CONTINGENCY, CREATE_UNDEAD, DISINTEGRATE,
					EYEBITE, FIND_THE_PATH, FLESH_TO_STONE, FORBIDDANCE, FREEZING_SPHERE, GLOBE_OF_INVULNERABILITY,
					GUARDS_AND_WARDS, HARM, HEAL, HEROES_FEAST, INSTANT_SUMMONS, IRRESISTIBLE_DANCE, MAGIC_JAR,
					MASS_SUGGESTION, MOVE_EARTH, PLANAR_ALLY, PROGRAMMED_ILLUSION, SUNBEAM, TRANSPORT_VIA_PLANTS,
					TRUE_SEEING, WALL_OF_ICE, WALL_OF_THORNS, WIND_WALK, WORD_OF_RECALL },
			{ ARCANE_SWORD, CONJURE_CELESTIAL, DELAYED_BLAST_FIREBALL, DIVINE_WORD, ETHEREALNESS, FINGER_OF_DEATH,
					FIRE_STORM, FORCECAGE, MAGNIFICENT_MANSION, MIRAGE_ARCANE, PLANE_SHIFT, PRISMATIC_SPRAY,
					PROJECT_IMAGE, REGENERATE, RESURRECTION, REVERSE_GRAVITY, SEQUESTER, SIMULACRUM, SYMBOL, TELEPORT },
			{ ANIMAL_SHAPES, ANTIMAGIC_FIELD, ANTIPATHY_SYMPATHY, CLONE, CONTROL_WEATHER, DEMIPLANE, DOMINATE_MONSTER,
					EARTHQUAKE, FEEBLEMIND, GLIBNESS, HOLY_AURA, INCENDIARY_CLOUD, MAZE, MIND_BLANK, POWER_WORD_STUN,
					SUNBURST },
			{ ASTRAL_PROJECTION, FORESIGHT, GATE, IMPRISONMENT, MASS_HEAL, METEOR_SWARM, POWER_WORD_KILL,
					PRISMATIC_WALL, SHAPECHANGE, STORM_OF_VENGEANCE, TIME_STOP, TRUE_POLYMORPH, TRUE_RESURRECTION,
					WEIRD, WISH }
			//
	};

	/*
	 * SPELL LISTS (PLAYER'S HANDBOOK)
	 */
	public static final Spell[][] BARD_SPELLS = {
			{ BLADE_WARD, DANCING_LIGHTS, FRIENDS, LIGHT, MAGE_HAND, MENDING, MESSAGE, MINOR_ILLUSION, PRESTIDIGITATION,
					TRUE_STRIKE, VICIOUS_MOCKERY },
			{ ANIMAL_FRIENDSHIP, BANE, CHARM_PERSON, COMPREHEND_LANGUAGES, CURE_WOUNDS, DETECT_MAGIC, DISGUISE_SELF,
					DISSONANT_WHISPERS, FAERIE_FIRE, FEATHER_FALL, HEALING_WORD, HEROISM, IDENTIFY, ILLUSORY_SCRIPT,
					LONGSTRIDER, SILENT_IMAGE, SLEEP, SPEAK_WITH_ANIMALS, HIDEOUS_LAUGHTER, THUNDERWAVE,
					UNSEEN_SERVANT },
			{ ANIMAL_MESSENGER, BLINDNESS_DEAFNESS, CALM_EMOTIONS, CLOUD_OF_DAGGERS, CROWN_OF_MADNESS, DETECT_THOUGHTS,
					ENHANCE_ABILITY, ENTHRALL, HEAT_METAL, HOLD_PERSON, INVISIBILITY, KNOCK, LESSER_RESTORATION,
					LOCATE_ANIMALS_OR_PLANTS, LOCATE_OBJECT, MAGIC_MOUTH, PHANTASMAL_FORCE, SEE_INVISIBILITY, SHATTER,
					SILENCE, SUGGESTION, ZONE_OF_TRUTH },
			{ BESTOW_CURSE, CLAIRVOYANCE, DISPEL_MAGIC, FEAR, FEIGN_DEATH, GLYPH_OF_WARDING, HYPNOTIC_PATTERN, TINY_HUT,
					MAJOR_IMAGE, NONDETECTION, PLANT_GROWTH, SENDING, SPEAK_WITH_DEAD, SPEAK_WITH_PLANTS,
					STINKING_CLOUD, TONGUES },
			{ COMPULSION, CONFUSION, DIMENSION_DOOR, FREEDOM_OF_MOVEMENT, GREATER_INVISIBILITY, HALLUCINATORY_TERRAIN,
					LOCATE_CREATURE, POLYMORPH },
			{ ANIMATE_OBJECTS, AWAKEN, DOMINATE_PERSON, DREAM, GEAS, GREATER_RESTORATION, HOLD_MONSTER, LEGEND_LORE,
					MASS_CURE_WOUNDS, MISLEAD, MODIFY_MEMORY, PLANAR_BINDING, RAISE_DEAD, SCRYING, SEEMING,
					TELEPORTATION_CIRCLE },
			{ EYEBITE, FIND_THE_PATH, GUARDS_AND_WARDS, MASS_SUGGESTION, IRRESISTIBLE_DANCE, PROGRAMMED_ILLUSION,
					TRUE_SEEING },
			{ ETHEREALNESS, FORCECAGE, MIRAGE_ARCANA, MAGNIFICENT_MANSION, ARCANE_SWORD, PROJECT_IMAGE, REGENERATE,
					RESURRECTION, SYMBOL, TELEPORT },
			{ DOMINATE_MONSTER, FEEBLEMIND, GLIBNESS, MIND_BLANK, POWER_WORD_STUN },
			{ FORESIGHT, POWER_WORD_HEAL, POWER_WORD_KILL, TRUE_POLYMORPH } };

	public static final Spell[][] CLERIC_SPELLS = {
			{ GUIDANCE, LIGHT, MENDING, RESISTANCE, SACRED_FLAME, SPARE_THE_DYING, THAUMATURGY },
			{ BANE, BLESS, COMMAND, CREATE_OR_DESTROY_WATER, CURE_WOUNDS, DETECT_EVIL_AND_GOOD, DETECT_MAGIC,
					DETECT_POISON_AND_DISEASE, GUIDING_BOLT, HEALING_WORD, INFLICT_WOUNDS, PROTECTION_FROM_EVIL,
					PURIFY_FOOD_AND_DRINK, SANCTUARY, SHIELD_OF_FAITH },
			{ AUGURY, BLINDNESS_DEAFNESS, CALM_EMOTIONS, CONTINUAL_FLAME, ENHANCE_ABILITY, HOLD_PERSON,
					LESSER_RESTORATION, LOCATE_OBJECT, PRAYER_OF_HEALING, PROTECTION_FROM_POISON, SILENCE,
					SPIRITUAL_WEAPON, WARDING_BOND, ZONE_OF_TRUTH },
			{ ANIMATE_DEAD, BEACON_OF_HOPE, BESTOW_CURSE, CLAIRVOYANCE, CREATE_FOOD_AND_WATER, DAYLIGHT, DISPEL_MAGIC,
					FEIGN_DEATH, GLYPH_OF_WARDING, MAGIC_CIRCLE, MASS_HEALING_WORD, MELD_INTO_STONE,
					PROTECTION_FROM_ENERGY, REMOVE_CURSE, REVIVIFY, SENDING, SPEAK_WITH_DEAD, SPIRIT_GUARDIANS, TONGUES,
					WATER_WALK },
			{ BANISHMENT, CONTROL_WATER, DEATH_WARD, DIVINATION, FREEDOM_OF_MOVEMENT, GUARDIAN_OF_FAITH,
					LOCATE_CREATURE, STONE_SHAPE },
			{ COMMUNE, CONTAGION, DISPEL_EVIL_AND_GOOD, FLAME_STRIKE, GEAS, GREATER_RESTORATION, HALLOW, INSECT_PLAGUE,
					LEGEND_LORE, MASS_CURE_WOUNDS, PLANAR_BINDING, RAISE_DEAD, SCRYING },
			{ BLADE_BARRIER, CREATE_UNDEAD, FIND_THE_PATH, FORBIDDANCE, HARM, HEAL, HEROES_FEAST, PLANAR_ALLY,
					TRUE_SEEING, WORD_OF_RECALL },
			{ CONJURE_CELESTIAL, DIVINE_WORD, ETHEREALNESS, FIRE_STORM, PLANE_SHIFT, REGENERATE, RESURRECTION, SYMBOL },
			{ ANTIMAGIC_FIELD, CONTROL_WEATHER, EARTHQUAKE, HOLY_AURA },
			{ ASTRAL_PROJECTION, GATE, MASS_HEAL, TRUE_RESURRECTION } };

	public static final Spell[][] DRUID_SPELLS = {
			{ DRUIDCRAFT, GUIDANCE, MENDING, POISON_SPRAY, PRODUCE_FLAME, RESISTANCE, SHILLELAGH, THORN_WHIP },
			{ ANIMAL_FRIENDSHIP, CHARM_PERSON, CREATE_OR_DESTROY_WATER, CURE_WOUNDS, DETECT_MAGIC,
					DETECT_POISON_AND_DISEASE, ENTANGLE, FAERIE_FIRE, FOG_CLOUD, GOODBERRY, HEALING_WORD, JUMP,
					LONGSTRIDER, PURIFY_FOOD_AND_DRINK, SPEAK_WITH_ANIMALS, THUNDERWAVE },
			{ ANIMAL_MESSENGER, BARKSKIN, BEAST_SENSE, DARKVISION, ENHANCE_ABILITY, FIND_TRAPS, FLAME_BLADE,
					FLAMING_SPHERE, GUST_OF_WIND, HEAT_METAL, HOLD_PERSON, LESSER_RESTORATION, LOCATE_ANIMALS_OR_PLANTS,
					LOCATE_OBJECT, MOONBEAM, PASS_WITHOUT_TRACE, PROTECTION_FROM_POISON, SPIKE_GROWTH },
			{ CALL_LIGHTNING, CONJURE_ANIMALS, DAYLIGHT, DISPEL_MAGIC, FEIGN_DEATH, MELD_INTO_STONE, PLANT_GROWTH,
					PROTECTION_FROM_ENERGY, SLEET_STORM, SPEAK_WITH_PLANTS, WATER_BREATHING, WATER_WALK, WIND_WALL },
			{ BLIGHT, CONFUSION, CONJURE_MINOR_ELEMENTALS, CONJURE_WOODLAND_BEINGS, CONTROL_WATER, DOMINATE_BEAST,
					FREEDOM_OF_MOVEMENT, GIANT_INSECT, GRASPING_VINE, HALLUCINATORY_TERRAIN, ICE_STORM, LOCATE_CREATURE,
					POLYMORPH, STONE_SHAPE, STONESKIN, WALL_OF_FIRE },
			{ ANTILIFE_SHELL, AWAKEN, COMMUNE_WITH_NATURE, CONJURE_ELEMENTAL, CONTAGION, GEAS, GREATER_RESTORATION,
					INSECT_PLAGUE, MASS_CURE_WOUNDS, PLANAR_BINDING, REINCARNATE, SCRYING, TREE_STRIDE, WALL_OF_STONE },
			{ CONJURE_FEY, FIND_THE_PATH, HEAL, HEROES_FEAST, MOVE_EARTH, SUNBEAM, TRANSPORT_VIA_PLANTS, WALL_OF_THORNS,
					WIND_WALK },
			{ FIRE_STORM, MIRAGE_ARCANA, PLANE_SHIFT, REGENERATE, REVERSE_GRAVITY },
			{ ANIMAL_SHAPES, ANTIPATHY_SYMPATHY, CONTROL_WEATHER, EARTHQUAKE, FEEBLEMIND, SUNBURST, TSUNAMI },
			{ FORESIGHT, SHAPECHANGE, STORM_OF_VENGEANCE, TRUE_RESURRECTION } };

	public static Spell[][] PALADIN_SPELLS = { {},
			{ BLESS, COMMAND, COMPELLED_DUEL, CURE_WOUNDS, DETECT_EVIL_AND_GOOD, DETECT_MAGIC,
					DETECT_POISON_AND_DISEASE, DIVINE_FAVOR, HEROISM, PROTECTION_FROM_EVIL, PURIFY_FOOD_AND_DRINK,
					SEARING_SMITE, SHIELD_OF_FAITH, THUNDEROUS_SMITE, WRATHFUL_SMITE },
			{ AID, BRANDING_SMITE, FIND_STEED, LESSER_RESTORATION, LOCATE_OBJECT, MAGIC_WEAPON, PROTECTION_FROM_POISON,
					ZONE_OF_TRUTH },
			{ AURA_OF_VITALITY, BLINDING_SMITE, CREATE_FOOD_AND_WATER, CRUSADERS_MANTLE, DAYLIGHT, DISPEL_MAGIC,
					ELEMENTAL_WEAPON, MAGIC_CIRCLE, REMOVE_CURSE, REVIVIFY },
			{ AURA_OF_LIFE, AURA_OF_PURITY, BANISHMENT, DEATH_WARD, LOCATE_CREATURE, STAGGERING_SMITE },
			{ BANISHING_SMITE, CIRCLE_OF_POWER, DESTRUCTIVE_WAVE, DISPEL_EVIL_AND_GOOD, GEAS, RAISE_DEAD } };

	public static Spell[][] RANGER_SPELLS = { {},
			{ ALARM, ANIMAL_FRIENDSHIP, CURE_WOUNDS, DETECT_MAGIC, DETECT_POISON_AND_DISEASE, ENSNARING_STRIKE,
					FOG_CLOUD, GOODBERRY, HAIL_OF_THORNS, HUNTERS_MARK, JUMP, LONGSTRIDER, SPEAK_WITH_ANIMALS },
			{ ANIMAL_MESSENGER, BARKSKIN, BEAST_SENSE, CORDON_OF_ARROWS, DARKVISION, FIND_TRAPS, LESSER_RESTORATION,
					LOCATE_ANIMALS_OR_PLANTS, LOCATE_OBJECT, PASS_WITHOUT_TRACE, PROTECTION_FROM_POISON, SILENCE,
					SPIKE_GROWTH },
			{ CONJURE_ANIMALS, CONJURE_BARRAGE, DAYLIGHT, LIGHTNING_ARROW, NONDETECTION, PLANT_GROWTH,
					PROTECTION_FROM_ENERGY, SPEAK_WITH_PLANTS, WATER_BREATHING, WATER_WALK, WIND_WALL },
			{ CONJURE_WOODLAND_BEINGS, FREEDOM_OF_MOVEMENT, GRASPING_VINE, LOCATE_CREATURE, STONESKIN },
			{ COMMUNE_WITH_NATURE, CONJURE_VOLLEY, SWIFT_QUIVER, TREE_STRIDE } };

	public static Spell[][] SORCERER_SPELLS = {
			{ ACID_SPLASH, BLADE_WARD, CHILL_TOUCH, DANCING_LIGHTS, FIREBOLT, FRIENDS, LIGHT, MAGE_HAND, MENDING,
					MESSAGE, MINOR_ILLUSION, POISON_SPRAY, PRESTIDIGITATION, RAY_OF_FROST, SHOCKING_GRASP,
					TRUE_STRIKE },
			{ BURNING_HANDS, CHARM_PERSON, CHROMATIC_ORB, COLOR_SPRAY, COMPREHEND_LANGUAGES, DETECT_MAGIC,
					DISGUISE_SELF, EXPEDITIOUS_RETREAT, FALSE_LIFE, FEATHER_FALL, FOG_CLOUD, JUMP, MAGE_ARMOR,
					MAGIC_MISSILE, RAY_OF_SICKNESS, SHIELD, SILENT_IMAGE, SLEEP, THUNDERWAVE, WITCH_BOLT },
			{ ALTER_SELF, BLINDNESS_DEAFNESS, BLUR, CLOUD_OF_DAGGERS, CROWN_OF_MADNESS, DARKNESS, DARKVISION,
					DETECT_THOUGHTS, ENHANCE_ABILITY, ENLARGE_REDUCE, GUST_OF_WIND, HOLD_PERSON, INVISIBILITY, KNOCK,
					LEVITATE, MIRROR_IMAGE, MISTY_STEP, PHANTASMAL_FORCE, SCORCHING_RAY, SEE_INVISIBILITY, SHATTER,
					SPIDER_CLIMB, SUGGESTION, WEB },
			{ BLINK, CLAIRVOYANCE, COUNTERSPELL, DAYLIGHT, DISPEL_MAGIC, FEAR, FIREBALL, FLY, GASEOUS_FORM, HASTE,
					HYPNOTIC_PATTERN, LIGHTNING_BOLT, MAJOR_IMAGE, PROTECTION_FROM_ENERGY, SLEET_STORM, SLOW,
					STINKING_CLOUD, TONGUES, WATER_BREATHING, WATER_WALK },
			{ BANISHMENT, BLIGHT, CONFUSION, DIMENSION_DOOR, DOMINATE_BEAST, GREATER_INVISIBILITY, ICE_STORM, POLYMORPH,
					STONESKIN, WALL_OF_FIRE },
			{ ANIMATE_OBJECTS, CLOUDKILL, CONE_OF_COLD, CREATION, DOMINATE_PERSON, HOLD_MONSTER, INSECT_PLAGUE, SEEMING,
					TELEKINESIS, TELEPORTATION_CIRCLE, WALL_OF_STONE },
			{ ARCANE_GATE, CHAIN_LIGHTNING, CIRCLE_OF_DEATH, DISINTEGRATE, EYEBITE, GLOBE_OF_INVULNERABILITY,
					MASS_SUGGESTION, MOVE_EARTH, SUNBEAM, TRUE_SEEING },
			{ DELAYED_BLAST_FIREBALL, ETHEREALNESS, FINGER_OF_DEATH, FIRE_STORM, PLANE_SHIFT, PRISMATIC_SPRAY,
					REVERSE_GRAVITY, TELEPORT },
			{ DOMINATE_MONSTER, EARTHQUAKE, INCENDIARY_CLOUD, POWER_WORD_STUN, SUNBURST },
			{ GATE, METEOR_SWARM, POWER_WORD_KILL, TIME_STOP, WISH } };

	public static Spell[][] WARLOCK_SPELLS = {
			{ BLADE_WARD, CHILL_TOUCH, ELDRITCH_BLAST, FRIENDS, MAGE_HAND, MINOR_ILLUSION, POISON_SPRAY,
					PRESTIDIGITATION, TRUE_STRIKE },
			{ ARMOR_OF_AGATHYS, ARMS_OF_HADAR, CHARM_PERSON, COMPREHEND_LANGUAGES, EXPEDITIOUS_RETREAT, HELLISH_REBUKE,
					HEX, ILLUSORY_SCRIPT, PROTECTION_FROM_EVIL, UNSEEN_SERVANT, WITCH_BOLT },
			{ CLOUD_OF_DAGGERS, CROWN_OF_MADNESS, DARKNESS, ENTHRALL, HOLD_PERSON, INVISIBILITY, MIRROR_IMAGE,
					MISTY_STEP, RAY_OF_ENFEEBLEMENT, SHATTER, SPIDER_CLIMB, SUGGESTION },
			{ COUNTERSPELL, DISPEL_MAGIC, FEAR, FLY, GASEOUS_FORM, HUNGER_OF_HADAR, HYPNOTIC_PATTERN, MAGIC_CIRCLE,
					MAJOR_IMAGE, REMOVE_CURSE, TONGUES, VAMPIRIC_TOUCH },
			{ BANISHMENT, BLIGHT, DIMENSION_DOOR, HALLUCINATORY_TERRAIN },
			{ CONTACT_OTHER_PLANE, DREAM, HOLD_MONSTER, SCRYING },
			{ ARCANE_GATE, CIRCLE_OF_DEATH, CONJURE_FEY, CREATE_UNDEAD, EYEBITE, FLESH_TO_STONE, MASS_SUGGESTION,
					TRUE_SEEING },
			{ ETHEREALNESS, FINGER_OF_DEATH, FORCECAGE, PLANE_SHIFT },
			{ DEMIPLANE, DOMINATE_MONSTER, FEEBLEMIND, GLIBNESS, POWER_WORD_STUN },
			{ ASTRAL_PROJECTION, FORESIGHT, IMPRISONMENT, POWER_WORD_KILL, TRUE_POLYMORPH } };

	public static Spell[][] WIZARD_SPELLS = {
			{ ACID_SPLASH, BLADE_WARD, CHILL_TOUCH, DANCING_LIGHTS, FIREBOLT, FRIENDS, LIGHT, MAGE_HAND, MENDING,
					MESSAGE, MINOR_ILLUSION, POISON_SPRAY, PRESTIDIGITATION, RAY_OF_FROST, SHOCKING_GRASP,
					TRUE_STRIKE },
			{ ALARM, BURNING_HANDS, CHARM_PERSON, CHROMATIC_ORB, COLOR_SPRAY, COMPREHEND_LANGUAGES, DETECT_MAGIC,
					DISGUISE_SELF, EXPEDITIOUS_RETREAT, FALSE_LIFE, FEATHER_FALL, FIND_FAMILIAR, FOG_CLOUD, GREASE,
					IDENTIFY, ILLUSORY_SCRIPT, JUMP, LONGSTRIDER, MAGE_ARMOR, MAGIC_MISSILE, PROTECTION_FROM_EVIL,
					RAY_OF_SICKNESS, SHIELD, SILENT_IMAGE, SLEEP, HIDEOUS_LAUGHTER, FLOATING_DISK, THUNDERWAVE,
					UNSEEN_SERVANT, WITCH_BOLT },
			{ ALTER_SELF, ARCANE_LOCK, BLINDNESS_DEAFNESS, BLUR, CLOUD_OF_DAGGERS, CONTINUAL_FLAME, CROWN_OF_MADNESS,
					DARKVISION, DETECT_THOUGHTS, ENLARGE_REDUCE, FLAMING_SPHERE, GENTLE_REPOSE, GUST_OF_WIND,
					HOLD_PERSON, INVISIBILITY, KNOCK, LEVITATE, LOCATE_OBJECT, MAGIC_MOUTH, MAGIC_WEAPON, ACID_ARROW,
					MIRROR_IMAGE, MISTY_STEP, MAGIC_AURA, PHANTASMAL_FORCE, RAY_OF_ENFEEBLEMENT, ROPE_TRICK,
					SCORCHING_RAY, SEE_INVISIBILITY, SHATTER, SPIDER_CLIMB, SUGGESTION, WEB },
			{ ANIMATE_DEAD, BESTOW_CURSE, BLINK, CLAIRVOYANCE, COUNTERSPELL, DISPEL_MAGIC, FEAR, FEIGN_DEATH, FIREBALL,
					FLY, GASEOUS_FORM, GLYPH_OF_WARDING, HASTE, HYPNOTIC_PATTERN, TINY_HUT, LIGHTNING_BOLT,
					MAGIC_CIRCLE, MAJOR_IMAGE, NONDETECTION, PHANTOM_STEED, PROTECTION_FROM_ENERGY, REMOVE_CURSE,
					SENDING, SLEET_STORM, SLOW, STINKING_CLOUD, TONGUES, VAMPIRIC_TOUCH, WATER_BREATHING },
			{ ARCANE_EYE, BANISHMENT, BLIGHT, CONFUSION, CONJURE_MINOR_ELEMENTALS, CONTROL_WATER, DIMENSION_DOOR,
					BLACK_TENTACLES, FABRICATE, FIRE_SHIELD, GREATER_INVISIBILITY, HALLUCINATORY_TERRAIN, ICE_STORM,
					SECRET_CHEST, LOCATE_CREATURE, FAITHFUL_HOUND, PRIVATE_SANCTUM, RESILIENT_SPHERE, PHANTASMAL_KILLER,
					POLYMORPH, STONE_SHAPE, STONESKIN, WALL_OF_FIRE },
			{ ANIMATE_OBJECTS, ARCANE_HAND, CLOUDKILL, CONE_OF_COLD, CONJURE_ELEMENTAL, CONTACT_OTHER_PLANE, CREATION,
					DOMINATE_PERSON, DREAM, GEAS, HOLD_MONSTER, LEGEND_LORE, MISLEAD, MODIFY_MEMORY, PASSWALL,
					PLANAR_BINDING, TELEPATHIC_BOND, SCRYING, TELEKINESIS, TELEPORTATION_CIRCLE, WALL_OF_FORCE,
					WALL_OF_STONE },
			{ ARCANE_GATE, CHAIN_LIGHTNING, CIRCLE_OF_DEATH, CONTINGENCY, CREATE_UNDEAD, DISINTEGRATE, INSTANT_SUMMONS,
					EYEBITE, FLESH_TO_STONE, GLOBE_OF_INVULNERABILITY, GUARDS_AND_WARDS, MAGIC_JAR, MASS_SUGGESTION,
					MOVE_EARTH, FREEZING_SPHERE, IRRESISTIBLE_DANCE, PROGRAMMED_ILLUSION, SUNBEAM, TRUE_SEEING,
					WALL_OF_ICE },
			{ DELAYED_BLAST_FIREBALL, ETHEREALNESS, FINGER_OF_DEATH, FORCECAGE, MIRAGE_ARCANA, MAGNIFICENT_MANSION,
					ARCANE_SWORD, PLANE_SHIFT, PRISMATIC_SPRAY, PROJECT_IMAGE, REVERSE_GRAVITY, SEQUESTER, SIMULACRUM,
					SYMBOL, TELEPORT },
			{ ANTIMAGIC_FIELD, ANTIPATHY_SYMPATHY, CLONE, CONTROL_WEATHER, DEMIPLANE, DOMINATE_MONSTER, FEEBLEMIND,
					INCENDIARY_CLOUD, MAZE, MIND_BLANK, POWER_WORD_STUN, SUNBURST, TELEPATHY },
			{ ASTRAL_PROJECTION, FORESIGHT, GATE, IMPRISONMENT, METEOR_SWARM, POWER_WORD_KILL, PRISMATIC_WALL,
					SHAPECHANGE, TIME_STOP, TRUE_POLYMORPH, WEIRD, WISH } };

	/*
	 * CLERIC DOMAINS
	 */
	private static Spell[][] KNOWLEDGE_DOMAIN = { {}, { COMMAND, IDENTIFY }, { AUGURY, SUGGESTION },
			{ NONDETECTION, SPEAK_WITH_DEAD }, { ARCANE_EYE, CONFUSION }, { LEGEND_LORE, SCRYING } };
	private static Spell[][] LIFE_DOMAIN = { {}, { BLESS, CURE_WOUNDS }, { LESSER_RESTORATION, SPIRITUAL_WEAPON },
			{ BEACON_OF_HOPE, REVIVIFY }, { DEATH_WARD, GUARDIAN_OF_FAITH }, { MASS_CURE_WOUNDS, RAISE_DEAD } };
	private static Spell[][] LIGHT_DOMAIN = { {}, { BURNING_HANDS, FAERIE_FIRE }, { FLAMING_SPHERE, SCORCHING_RAY },
			{ DAYLIGHT, FIREBALL }, { GUARDIAN_OF_FAITH, WALL_OF_FIRE }, { FLAME_STRIKE, SCRYING } };
	private static Spell[][] NATURE_DOMAIN = { {}, { ANIMAL_FRIENDSHIP, SPEAK_WITH_ANIMALS },
			{ BARKSKIN, SPIKE_GROWTH }, { PLANT_GROWTH, WIND_WALL }, { DOMINATE_BEAST, GRASPING_VINE },
			{ INSECT_PLAGUE, TREE_STRIDE } };
	private static Spell[][] TEMPEST_DOMAIN = { {}, { FOG_CLOUD, THUNDERWAVE }, { GUST_OF_WIND, SHATTER },
			{ CALL_LIGHTNING, SLEET_STORM }, { CONTROL_WATER, ICE_STORM }, { DESTRUCTIVE_WAVE, INSECT_PLAGUE } };
	private static Spell[][] TRICKERY_DOMAIN = { {}, { CHARM_PERSON, DISGUISE_SELF },
			{ MIRROR_IMAGE, PASS_WITHOUT_TRACE }, { BLINK, DISPEL_MAGIC }, { DIMENSION_DOOR, POLYMORPH },
			{ DOMINATE_PERSON, MODIFY_MEMORY } };
	private static Spell[][] WAR_DOMAIN = { {}, { DIVINE_FAVOR, SHIELD_OF_FAITH }, { MAGIC_WEAPON, SPIRITUAL_WEAPON },
			{ CRUSADERS_MANTLE, SPIRIT_GUARDIANS }, { FREEDOM_OF_MOVEMENT, STONESKIN },
			{ FLAME_STRIKE, HOLD_MONSTER } };

	/*
	 * DRUID CIRCLES
	 */
	private static Spell[][] ARCTIC_CIRCLE = { {}, { HOLD_PERSON, SPIKE_GROWTH }, { SLEET_STORM, SLOW },
			{ FREEDOM_OF_MOVEMENT, ICE_STORM }, { COMMUNE_WITH_NATURE, CONE_OF_COLD } };
	private static Spell[][] COAST_CIRCLE = { {}, { MIRROR_IMAGE, MISTY_STEP }, { WATER_BREATHING, WATER_WALK },
			{ CONTROL_WATER, FREEDOM_OF_MOVEMENT }, { CONJURE_ELEMENTAL, SCRYING } };
	private static Spell[][] DESERT_CIRCLE = { {}, { BLUR, SILENCE }, { CREATE_FOOD_AND_WATER, PROTECTION_FROM_ENERGY },
			{ BLIGHT, HALLUCINATORY_TERRAIN }, { INSECT_PLAGUE, WALL_OF_STONE } };
	private static Spell[][] FOREST_CIRCLE = { {}, { BARKSKIN, SPIDER_CLIMB }, { CALL_LIGHTNING, PLANT_GROWTH },
			{ DIVINATION, FREEDOM_OF_MOVEMENT }, { COMMUNE_WITH_NATURE, TREE_STRIDE } };
	private static Spell[][] GRASSLAND_CIRCLE = { {}, { INVISIBILITY, PASS_WITHOUT_TRACE }, { DAYLIGHT, HASTE },
			{ DIVINATION, FREEDOM_OF_MOVEMENT }, { DREAM, INSECT_PLAGUE } };
	private static Spell[][] MOUNTAIN_CIRCLE = { {}, { SPIDER_CLIMB, SPIKE_GROWTH },
			{ LIGHTNING_BOLT, MELD_INTO_STONE }, { STONE_SHAPE, STONESKIN }, { PASSWALL, WALL_OF_STONE } };
	private static Spell[][] SWAMP_CIRCLE = { {}, { DARKNESS, ACID_ARROW }, { WATER_WALK, STINKING_CLOUD },
			{ FREEDOM_OF_MOVEMENT, LOCATE_CREATURE }, { INSECT_PLAGUE, SCRYING } };
	private static Spell[][] UNDERDARK_CIRCLE = { {}, { SPIDER_CLIMB, WEB }, { GASEOUS_FORM, STINKING_CLOUD },
			{ GREATER_INVISIBILITY, STONE_SHAPE }, { CLOUDKILL, INSECT_PLAGUE } };

	/*
	 * STATIC METHODS
	 */
	public static List<Spell> spellsList(DnDClass job) {
		List<Spell> list = new ArrayList<Spell>();
		int n = 0;

		switch (job) {
		case BARBARIAN:
		case MONK:
			break;
		case BARD:
			n = BARD_SPELLS.length;
			break;
		case CLERIC:
			n = CLERIC_SPELLS.length;
			break;
		case DRUID:
			n = DRUID_SPELLS.length;
			break;
		case PALADIN:
			n = PALADIN_SPELLS.length;
			break;
		case RANGER:
			n = RANGER_SPELLS.length;
			break;
		case FIGHTER:
		case ROGUE:
		case WIZARD:
			n = WIZARD_SPELLS.length;
			break;
		case SORCERER:
			n = SORCERER_SPELLS.length;
			break;
		case WARLOCK:
			n = WARLOCK_SPELLS.length;
			break;
		}

		for (int i = 0; i < n; ++i)
			list.addAll(spellsList(i, job));

		return list;
	}

	public static List<Spell> spellsList(int level, DnDClass job) {
		Spell[] array = null;

		switch (job) {
		case BARBARIAN:
		case MONK:
			break;
		case BARD:
			array = BARD_SPELLS[level];
			break;
		case CLERIC:
			array = CLERIC_SPELLS[level];
			break;
		case DRUID:
			array = DRUID_SPELLS[level];
			break;
		case PALADIN:
			array = PALADIN_SPELLS[level];
			break;
		case RANGER:
			array = RANGER_SPELLS[level];
			break;
		case FIGHTER:
		case ROGUE:
		case WIZARD:
			array = WIZARD_SPELLS[level];
			break;
		case SORCERER:
			array = SORCERER_SPELLS[level];
			break;
		case WARLOCK:
			array = WARLOCK_SPELLS[level];
			break;
		}

		return Misc.arrayToList(array);
	}

	public static boolean addCantrip(DnDClass job, Set<Spell> set) {
		return addCantrip(1, job, set);
	}

	public static boolean addCantrip(int n, DnDClass job, Set<Spell> set) {
		return Misc.tryToAdd(n, spellsList(0, job), set);
	}

	public static boolean addSpell(int level, DnDClass job, Set<Spell> set) {
		return addSpell(1, level, job, set);
	}

	public static boolean addSpell(int n, int level, DnDClass job, Set<Spell> set) {
		return Misc.tryToAdd(n, spellsList(level, job), set);
	}

	public static void addMagicalSecret(int n, int level, Set<Spell> spellsKnown) {
		List<Spell> list = Misc.arrayToList(SPELLS_BY_LEVEL[level]);
		list.removeAll(spellsKnown);
		
		Collections.shuffle(list);
		 for (int i = 0; i < n; ++i)
			 spellsKnown.add(list.get(0));
	}
}
