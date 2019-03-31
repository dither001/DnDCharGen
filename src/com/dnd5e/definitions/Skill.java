package com.dnd5e.definitions;

import java.util.List;
import java.util.Set;

import com.dnd5e.character.classes.*;
import com.miscellaneous.util.*;

public enum Skill {
	UNSKILLED,

	// SIMPLE MELEE WEAPONS
	UNARMED, CLUB, DAGGER, GREATCLUB, HANDAXE, JAVELIN, LIGHT_HAMMER, MACE, QUARTERSTAFF, SICKLE, SPEAR,

	// SIMPLE RANGED WEAPONS
	LIGHT_CROSSBOW, DART, SHORTBOW, SLING,

	// MILITARY MELEE WEAPONS
	BATTLEAXE, FLAIL, GLAIVE, GREATAXE, GREATSWORD, HALBERD, LANCE, LONGSWORD, MAUL, MORNINGSTAR, PIKE, RAPIER, SCIMITAR, SHORTSWORD, TRIDENT, WAR_PICK, WARHAMMER, WHIP,

	// MILITARY RANGED WEAPONS
	BLOWGUN, HAND_CROSSBOW, HEAVY_CROSSBOW, LONGBOW, NET,

	// NATURAL
	NATURAL,

	// SHIELD
	SHIELD,

	// AMMUNITION
	ARROW, BOLT, BULLET, NEEDLE,

	// ARCANE FOCUS
	CRYSTAL, ORB, ROD, ARCANE_STAFF, WAND,

	// DRUID FOCUS
	MISTLETOE, TOTEM, WOODEN_STAFF, YEW_WAND,

	// HOLY SYMBOL
	AMULET, EMBLEM, RELIQUARY,

	// ARMOR
	PADDED_ARMOR, LEATHER_ARMOR, STUDDED_LEATHER, HIDE_ARMOR, CHAIN_SHIRT, SCALE_MAIL, BREASTPLATE, HALF_PLATE, RING_MAIL, CHAIN_MAIL, SPLINT_MAIL, PLATE_MAIL,

	// COMMON SKILLS
	ACROBATICS, ANIMAL_HANDLING, ARCANA, ATHLETICS, DECEPTION, HISTORY, INSIGHT, INTIMIDATION, INVESTIGATION, MEDICINE, NATURE, PERCEPTION, PERFORMANCE, PERSUASION, RELIGION, SLEIGHT_OF_HAND, STEALTH, SURVIVAL,

	// PROFESSIONAL TOOLS
	ALCHEMY_TOOLS, BREWING_TOOLS, CALLIGRAPHY_TOOLS, CARPENTER_TOOLS, CARTOGRAPHY_TOOLS, COBBLER_TOOLS, MESS_KIT, GLASSBLOWER_TOOLS, JEWELER_TOOLS, LEATHERWORKING_TOOLS, MASONRY_TOOLS, NAVIGATOR_TOOLS, PAINTING_TOOLS, POTTING_TOOLS, SMITHING_TOOLS, TINKERS_TOOLS, WEAVING_TOOLS, WOODCARVING_TOOLS,

	// MISCELLANEOUS KITS
	DISGUISE_KIT, FORGERY_KIT, CHESS_SET, GAMING_DICE, PLAYING_CARDS, HERBALISM_KIT, POISONER_KIT, THIEVES_TOOLS,

	// MUSICAL INSTRUMENTS
	BAGPIPES, DRUM, DULCIMER, FLUTE, LUTE, LYRE, HORN, PAN_FLUTE, SHAWM, VIOL,

	// VEHICLES
	CARRIAGE, CART, CHARIOT, SLED, WAGON, GALLEY, KEELBOAT, LONGSHIP, ROWBOAT, SAILING_SHIP, WARSHIP;

	/*
	 * STATIC FIELDS
	 */
	private static final Skill[] ALL_WEAPONS = { UNARMED, CLUB, DAGGER, GREATCLUB, HANDAXE, JAVELIN, LIGHT_HAMMER, MACE,
			QUARTERSTAFF, SICKLE, SPEAR, LIGHT_CROSSBOW, DART, SHORTBOW, SLING, BATTLEAXE, FLAIL, GLAIVE, GREATAXE,
			GREATSWORD, HALBERD, LANCE, LONGSWORD, MAUL, MORNINGSTAR, PIKE, RAPIER, SCIMITAR, SHORTSWORD, TRIDENT,
			WAR_PICK, WARHAMMER, WHIP, BLOWGUN, HAND_CROSSBOW, HEAVY_CROSSBOW, LONGBOW, NET, SHIELD, ARROW, BOLT,
			BULLET, NEEDLE, NATURAL };

	private static final Skill[] SIMPLE_WEAPONS = { CLUB, DAGGER, GREATCLUB, HANDAXE, JAVELIN, LIGHT_HAMMER, MACE,
			QUARTERSTAFF, SICKLE, SPEAR, LIGHT_CROSSBOW, DART, SHORTBOW, SLING };

	private static final Skill[] SIMPLE_MELEE = { CLUB, DAGGER, GREATCLUB, HANDAXE, JAVELIN, LIGHT_HAMMER, MACE,
			QUARTERSTAFF, SICKLE, SPEAR };

	private static final Skill[] SIMPLE_RANGED = { LIGHT_CROSSBOW, DART, SHORTBOW, SLING };

	private static final Skill[] MILITARY_WEAPONS = { BATTLEAXE, FLAIL, GLAIVE, GREATAXE, GREATSWORD, HALBERD, LANCE,
			LONGSWORD, MAUL, MORNINGSTAR, PIKE, RAPIER, SCIMITAR, SHORTSWORD, TRIDENT, WAR_PICK, WARHAMMER, WHIP,
			BLOWGUN, HAND_CROSSBOW, HEAVY_CROSSBOW, LONGBOW, NET };

	private static final Skill[] MILITARY_MELEE = { BATTLEAXE, FLAIL, GLAIVE, GREATAXE, GREATSWORD, HALBERD, LANCE,
			LONGSWORD, MAUL, MORNINGSTAR, PIKE, RAPIER, SCIMITAR, SHORTSWORD, TRIDENT, WAR_PICK, WARHAMMER, WHIP };

	private static final Skill[] MILITARY_RANGED = { BLOWGUN, HAND_CROSSBOW, HEAVY_CROSSBOW, LONGBOW, NET };

	private static final Skill[] RANGED_WEAPONS = { LIGHT_CROSSBOW, DART, SHORTBOW, SLING, BLOWGUN, HAND_CROSSBOW,
			HEAVY_CROSSBOW, LONGBOW, NET };

	private static final Skill[] ARMOR_TYPES = { PADDED_ARMOR, LEATHER_ARMOR, STUDDED_LEATHER, HIDE_ARMOR, CHAIN_SHIRT,
			SCALE_MAIL, BREASTPLATE, HALF_PLATE, RING_MAIL, CHAIN_MAIL, SPLINT_MAIL, PLATE_MAIL };
	private static final Skill[] LIGHT_ARMOR = { PADDED_ARMOR, LEATHER_ARMOR, STUDDED_LEATHER };
	private static final Skill[] MEDIUM_ARMOR = { HIDE_ARMOR, CHAIN_SHIRT, SCALE_MAIL, BREASTPLATE, HALF_PLATE };
	private static final Skill[] HEAVY_ARMOR = { RING_MAIL, CHAIN_MAIL, SPLINT_MAIL, PLATE_MAIL };

	private static final Skill[] COMMON_SKILLS = { ACROBATICS, ANIMAL_HANDLING, ARCANA, ATHLETICS, DECEPTION, HISTORY,
			INSIGHT, INTIMIDATION, INVESTIGATION, MEDICINE, NATURE, PERCEPTION, PERFORMANCE, PERSUASION, RELIGION,
			SLEIGHT_OF_HAND, STEALTH, SURVIVAL };

	/*
	 * CLASS SKILLS
	 */
	private static final Skill[] BARBARIAN_SKILLS = { ANIMAL_HANDLING, ATHLETICS, INTIMIDATION, NATURE, PERCEPTION,
			SURVIVAL };
	private static final Skill[] CLERIC_SKILLS = { HISTORY, INSIGHT, MEDICINE, PERSUASION, RELIGION };
	private static final Skill[] DRUID_SKILLS = { ARCANA, ANIMAL_HANDLING, INSIGHT, MEDICINE, NATURE, PERCEPTION,
			RELIGION, SURVIVAL };
	private static final Skill[] FIGHTER_SKILLS = { ACROBATICS, ANIMAL_HANDLING, ATHLETICS, HISTORY, INSIGHT,
			INTIMIDATION, PERCEPTION, SURVIVAL };
	private static final Skill[] MONK_SKILLS = { ACROBATICS, ATHLETICS, HISTORY, INSIGHT, RELIGION, STEALTH };
	private static final Skill[] PALADIN_SKILLS = { ATHLETICS, INSIGHT, INTIMIDATION, MEDICINE, PERSUASION, RELIGION };
	private static final Skill[] RANGER_SKILLS = { ANIMAL_HANDLING, ATHLETICS, INSIGHT, INVESTIGATION, NATURE,
			PERCEPTION, STEALTH, SURVIVAL };
	private static final Skill[] ROGUE_SKILLS = { ACROBATICS, ATHLETICS, DECEPTION, INSIGHT, INTIMIDATION,
			INVESTIGATION, PERCEPTION, PERFORMANCE, PERSUASION, SLEIGHT_OF_HAND, STEALTH };
	private static final Skill[] SORCERER_SKILLS = { ARCANA, DECEPTION, INSIGHT, INTIMIDATION, PERSUASION, RELIGION };
	private static final Skill[] WARLOCK_SKILLS = { ARCANA, DECEPTION, HISTORY, INTIMIDATION, INVESTIGATION, NATURE,
			RELIGION };
	private static final Skill[] WIZARD_SKILLS = { ARCANA, HISTORY, INSIGHT, INVESTIGATION, MEDICINE, RELIGION };

	/*
	 * UNCOMMON SKILLS
	 */
	private static final Skill[] PROFESSION_SKILLS = { ALCHEMY_TOOLS, BREWING_TOOLS, CALLIGRAPHY_TOOLS, CARPENTER_TOOLS,
			CARTOGRAPHY_TOOLS, COBBLER_TOOLS, MESS_KIT, GLASSBLOWER_TOOLS, JEWELER_TOOLS, LEATHERWORKING_TOOLS,
			MASONRY_TOOLS, NAVIGATOR_TOOLS, PAINTING_TOOLS, POTTING_TOOLS, SMITHING_TOOLS, TINKERS_TOOLS, WEAVING_TOOLS,
			WOODCARVING_TOOLS };
	private static final Skill[] TOOL_SKILLS = { DISGUISE_KIT, FORGERY_KIT, CHESS_SET, GAMING_DICE, PLAYING_CARDS,
			HERBALISM_KIT, POISONER_KIT, THIEVES_TOOLS };
	private static final Skill[] GAMING_SKILLS = { CHESS_SET, GAMING_DICE, PLAYING_CARDS };
	private static final Skill[] INSTRUMENT_SKILLS = { BAGPIPES, DRUM, DULCIMER, FLUTE, LUTE, LYRE, HORN, PAN_FLUTE,
			SHAWM, VIOL };
	private static final Skill[] VEHICLE_SKILLS = { CARRIAGE, CART, CHARIOT, SLED, WAGON, GALLEY, KEELBOAT, LONGSHIP,
			ROWBOAT, SAILING_SHIP, WARSHIP };

	/*
	 * VEHICLE SKILLS
	 */
	private static final Skill[] LAND_VEHICLES = { CARRIAGE, CART, CHARIOT, SLED, WAGON };
	private static final Skill[] WATER_VEHICLES = { GALLEY, KEELBOAT, LONGSHIP, ROWBOAT, SAILING_SHIP, WARSHIP };

	/*
	 * MISCELLANEOUS
	 */
	protected static final Skill[] DWARF_TOOLS = { BREWING_TOOLS, MASONRY_TOOLS, SMITHING_TOOLS };

	/*
	 * INSTANCE METHODS
	 */
	public int indexOf() {
		if (isArmor())
			return Misc.indexOfEnum(this.toString(), ARMOR_TYPES);
		else if (isSimpleWeapon())
			return Misc.indexOfEnum(this.toString(), SIMPLE_WEAPONS);
		else
			return -1;
	}

	private boolean isArmor() {
		boolean armor = false;

		switch (this) {
		case PADDED_ARMOR:
		case LEATHER_ARMOR:
		case STUDDED_LEATHER:
		case HIDE_ARMOR:
		case CHAIN_SHIRT:
		case SCALE_MAIL:
		case BREASTPLATE:
		case HALF_PLATE:
		case RING_MAIL:
		case CHAIN_MAIL:
		case SPLINT_MAIL:
		case PLATE_MAIL:
			armor = true;
		default:
			break;
		}

		return armor;
	}

	private boolean isSimpleWeapon() {
		boolean weapon = false;

		switch (this) {
		case UNARMED:
		case CLUB:
		case DAGGER:
		case GREATCLUB:
		case HANDAXE:
		case JAVELIN:
		case LIGHT_HAMMER:
		case MACE:
		case QUARTERSTAFF:
		case SICKLE:
		case SPEAR:
		case LIGHT_CROSSBOW:
		case DART:
		case SHORTBOW:
		case SLING:
			weapon = true;
		default:
			break;
		}

		return weapon;
	}

	private boolean isMilitaryWeapon() {
		boolean weapon = false;

		switch (this) {
		case BATTLEAXE:
		case FLAIL:
		case GLAIVE:
		case GREATAXE:
		case GREATSWORD:
		case HALBERD:
		case LANCE:
		case LONGSWORD:
		case MAUL:
		case MORNINGSTAR:
		case PIKE:
		case RAPIER:
		case SCIMITAR:
		case SHORTSWORD:
		case TRIDENT:
		case WAR_PICK:
		case WARHAMMER:
		case WHIP:
		case BLOWGUN:
		case HAND_CROSSBOW:
		case HEAVY_CROSSBOW:
		case LONGBOW:
		case NET:
			weapon = true;
		default:
			break;
		}

		return weapon;
	}

	public boolean usesAmmunition() {
		boolean weapon = false;

		switch (this) {
		case BLOWGUN:
		case DART:
		case HAND_CROSSBOW:
		case HEAVY_CROSSBOW:
		case LIGHT_CROSSBOW:
		case LONGBOW:
		case SHORTBOW:
		case SLING:
			weapon = true;
		default:
			break;
		}

		return weapon;
	}

	/*
	 * STATIC METHODS
	 */
	public static List<Skill> getCommonSkills() {
		return Misc.arrayToList(COMMON_SKILLS);
	}

	public static Skill[] getClassSkills(DnDClass job) {
		Skill[] array = null;
		switch (job) {
		case BARBARIAN:
			array = BARBARIAN_SKILLS;
			break;
		case BARD:
			array = COMMON_SKILLS;
			break;
		case CLERIC:
			array = CLERIC_SKILLS;
			break;
		case DRUID:
			array = DRUID_SKILLS;
			break;
		case FIGHTER:
			array = FIGHTER_SKILLS;
			break;
		case MONK:
			array = MONK_SKILLS;
			break;
		case PALADIN:
			array = PALADIN_SKILLS;
			break;
		case RANGER:
			array = RANGER_SKILLS;
			break;
		case ROGUE:
			array = ROGUE_SKILLS;
			break;
		case SORCERER:
			array = SORCERER_SKILLS;
			break;
		case WARLOCK:
			array = WARLOCK_SKILLS;
			break;
		case WIZARD:
			array = WIZARD_SKILLS;
			break;
		default:
			break;
		}

		return array;
	}

	public static Skill getArmorType(int index) {
		return ARMOR_TYPES[index];
	}

	public static Skill getSimpleWeapon(int index) {
		return SIMPLE_WEAPONS[index];
	}

	public static Skill parseArmorType(String s) throws ParserException {
		for (Skill el : ARMOR_TYPES) {
			if (el.toString().compareToIgnoreCase(s) == 0)
				return el;
		}

		throw new ParserException(s);
	}

	public static Skill parseWeapon(String s) throws ParserException {
		for (Skill el : ALL_WEAPONS) {
			if (el.toString().compareToIgnoreCase(s) == 0)
				return el;
		}

		throw new ParserException(s);
	}

	/*
	 * COMMON & SPECIAL SKILLS
	 */
	public static List<Skill> getInstruments() {
		return Misc.arrayToList(INSTRUMENT_SKILLS);
	}

	public static List<Skill> getProfessionalSkills() {
		return Misc.arrayToList(PROFESSION_SKILLS);
	}

	public static List<Skill> getInstrumentsAndProfessions() {
		int length = INSTRUMENT_SKILLS.length + PROFESSION_SKILLS.length;
		Skill[] array = new Skill[length];

		for (int i = 0; i < length; ++i) {
			if (i < INSTRUMENT_SKILLS.length)
				array[i] = INSTRUMENT_SKILLS[i];
			else
				array[i] = PROFESSION_SKILLS[i - INSTRUMENT_SKILLS.length];

		}

		return Misc.arrayToList(array);
	}

	/*
	 * ARMOR & WEAPONS
	 */
	public static List<Skill> lightArmorList() {
		return Misc.arrayToList(LIGHT_ARMOR);
	}

	public static List<Skill> mediumArmorList() {
		return Misc.arrayToList(MEDIUM_ARMOR);
	}

	public static List<Skill> heavyArmorList() {
		return Misc.arrayToList(HEAVY_ARMOR);
	}

	public static List<Skill> lightAndMediumArmorList() {
		return Misc.addArrayToList(MEDIUM_ARMOR, Misc.arrayToList(LIGHT_ARMOR));
	}

	public static List<Skill> allArmorList() {
		return Misc.addArrayToList(HEAVY_ARMOR, lightAndMediumArmorList());
	}

	// SIMPLE WEAPONS
	public static List<Skill> simpleMeleeList() {
		return Misc.arrayToList(SIMPLE_MELEE);
	}

	public static List<Skill> simpleRangedList() {
		return Misc.arrayToList(SIMPLE_RANGED);
	}

	public static List<Skill> simpleWeaponList() {
		return Misc.addArrayToList(SIMPLE_RANGED, simpleMeleeList());
	}

	// MILITARY WEAPONS
	public static List<Skill> militaryMeleeList() {
		return Misc.arrayToList(MILITARY_MELEE);
	}

	public static List<Skill> militaryRangedList() {
		return Misc.arrayToList(MILITARY_RANGED);
	}

	public static List<Skill> militaryWeaponList() {
		return Misc.addArrayToList(MILITARY_RANGED, militaryMeleeList());
	}

	// COMBINED LISTS
	public static List<Skill> meleeWeaponList() {
		return Misc.addArrayToList(MILITARY_MELEE, simpleMeleeList());
	}

	public static List<Skill> druidWeapons() {
		Skill[] array = new Skill[] { Skill.CLUB, Skill.DAGGER, Skill.DART, Skill.JAVELIN, Skill.MACE,
				Skill.QUARTERSTAFF, Skill.SCIMITAR, Skill.SICKLE, Skill.SLING, Skill.SPEAR };
		return Misc.arrayToList(array);
	}

	public static List<Skill> rogueWeapons() {
		Skill[] array = new Skill[] { Skill.HAND_CROSSBOW, Skill.LONGSWORD, Skill.RAPIER, Skill.SHORTSWORD };
		return Misc.arrayToList(array);
	}

	public static List<Skill> allWeaponList() {
		return Misc.arrayToList(ALL_WEAPONS);
	}

	/*
	 * RANDOM SKILLS
	 */
	public static Skill randomMilitaryMelee() {
		return Misc.randomFromArray(MILITARY_MELEE);
	}

	public static Skill randomMilitaryWeapon() {
		return Misc.randomFromArray(MILITARY_WEAPONS);
	}

	public static Skill randomSimpleMelee() {
		return Misc.randomFromArray(SIMPLE_MELEE);
	}

	public static Skill randomSimpleWeapon() {
		return Misc.randomFromArray(SIMPLE_WEAPONS);
	}

}
