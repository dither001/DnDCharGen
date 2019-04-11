package com.dnd5e.definitions.gear;

import com.miscellaneous.util.*;

public enum Material {
	CLOTH, PAPER, ROPE, CRYSTAL, GLASS, ICE, WOOD, BONE, STONE, IRON, STEEL, MITHRAL, ADAMANTINE,
	// SUPPLEMENTAL
	CHALK, CERAMIC, COPPER, FEATHER, FOOD, GOLD, LEAD, PLATINUM, SILVER, SOAP, TIN, WAX;

	private static final Material[] MATERIALS = {
			// DUNGEON MASTER'S GUIDE
			CLOTH, PAPER, ROPE, CRYSTAL, GLASS, ICE, WOOD, BONE, STONE, IRON, STEEL, MITHRAL, ADAMANTINE,
			// SUPPLEMENTAL
			CHALK, CERAMIC, COPPER, FEATHER, FOOD, GOLD, LEAD, PLATINUM, SILVER, SOAP, TIN, WAX };

	/*
	 * INSTANCE METHODS
	 */
	public int indexOf() {
		return Misc.indexOfEnum(this.toString(), MATERIALS);
	}

	public int getArmorClass() {
		int armorClass = 11;

		switch (this) {
		case ADAMANTINE:
			armorClass = 23;
			break;
		case BONE:
		case CERAMIC:
		case WOOD:
			armorClass = 15;
			break;
		case CRYSTAL:
		case GLASS:
		case ICE:
			armorClass = 13;
			break;
		case IRON:
		case STEEL:
			armorClass = 19;
			break;
		case MITHRAL:
			armorClass = 21;
			break;
		case STONE:
			armorClass = 17;
			break;
		default:
			break;
		}

		return armorClass;
	}

	/*
	 * STATIC METHODS
	 */
	public static Material get(int index) {
		return MATERIALS[index];
	}

	public static Material parse(String s) throws ParserException {
		for (Material el : MATERIALS) {
			if (el.toString().compareToIgnoreCase(s) == 0)
				return el;
		}

		throw new ParserException(s);
	}
}
