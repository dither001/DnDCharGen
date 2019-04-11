package com.dnd5e.definitions.gear;

public enum WeaponType {
	UNARMED, CLUB, DAGGER, GREATCLUB, HANDAXE, JAVELIN, LIGHT_HAMMER, MACE, QUARTERSTAFF, SICKLE, SPEAR, LIGHT_CROSSBOW, DART, SHORTBOW, SLING, BATTLEAXE, FLAIL, GLAIVE, GREATAXE, GREATSWORD, HALBERD, LANCE, LONGSWORD, MAUL, MORNINGSTAR, PIKE, RAPIER, SCIMITAR, SHORTSWORD, TRIDENT, WAR_PICK, WARHAMMER, WHIP, BLOWGUN, HAND_CROSSBOW, HEAVY_CROSSBOW, LONGBOW, NET, SHIELD, ARROW, BOLT, BULLET, NEEDLE, CRYSTAL, ORB, ROD, ARCANE_STAFF, WAND, MISTLETOE, TOTEM, WOODEN_STAFF, YEW_WAND, AMULET, EMBLEM, RELIQUARY;

	/*
	 * STATIC FIELDS
	 */
	private static final WeaponType[] SIMPLE_MELEE = { CLUB, DAGGER, GREATCLUB, HANDAXE, JAVELIN, LIGHT_HAMMER, MACE,
			QUARTERSTAFF, SICKLE, SPEAR, UNARMED };

	private static final WeaponType[] SIMPLE_RANGED = { LIGHT_CROSSBOW, DART, SHORTBOW, SLING };

	private static final WeaponType[] MILITARY_MELEE = { BATTLEAXE, FLAIL, GLAIVE, GREATAXE, HALBERD, LANCE, LONGSWORD,
			MAUL, MORNINGSTAR, PIKE, RAPIER, SCIMITAR, SHORTSWORD, TRIDENT, WAR_PICK, WARHAMMER, WHIP };

	private static final WeaponType[] MILITARY_RANGED = { BLOWGUN, HAND_CROSSBOW, HEAVY_CROSSBOW, LONGBOW, NET };

	private static final WeaponType[] AMMUNITION = { ARROW, BOLT, BULLET, NEEDLE };

	private static final WeaponType[] ARCANE_FOCUS = { CRYSTAL, ORB, ROD, ARCANE_STAFF, WAND };

	private static final WeaponType[] DRUID_FOCUS = { MISTLETOE, TOTEM, WOODEN_STAFF, YEW_WAND };

	private static final WeaponType[] HOLY_SYMBOL = { AMULET, EMBLEM, RELIQUARY };

	/*
	 * STATIC METHODS
	 */

	public static WeaponType[] simpleMelee() {
		return SIMPLE_MELEE;
	}

	public static WeaponType[] simpleRanged() {
		return SIMPLE_RANGED;
	}

	public static WeaponType[] militaryMelee() {
		return MILITARY_MELEE;
	}

	public static WeaponType[] militaryRanged() {
		return MILITARY_RANGED;
	}

	public static WeaponType[] ammunition() {
		return AMMUNITION;
	}

	public static WeaponType[] arcaneFocus() {
		return ARCANE_FOCUS;
	}

	public static WeaponType[] druidFocus() {
		return DRUID_FOCUS;
	}

	public static WeaponType[] holySymbol() {
		return HOLY_SYMBOL;
	}

}
