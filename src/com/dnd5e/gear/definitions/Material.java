package com.dnd5e.gear.definitions;

import com.miscellaneous.util.*;

public enum Material {
	CLOTH, PAPER, ROPE, CRYSTAL, GLASS, ICE, WOOD, BONE, STONE, IRON, STEEL, MITHRAL, ADAMANTINE;

	private static final Material[] MATERIALS = { ADAMANTINE, BONE, CLOTH, CRYSTAL, GLASS, ICE, IRON, MITHRAL, PAPER,
			ROPE, STEEL, STONE, WOOD };

	/*
	 * INSTANCE METHODS
	 */
	public int indexOf() {
		return Misc.indexOfEnum(this.toString(), MATERIALS);
	}

	public int getArmorClass() {
		int armorClass = 10;

		switch (this) {
		case ADAMANTINE:
			armorClass = 23;
			break;
		case BONE:
		case WOOD:
			armorClass = 15;
			break;
		case CLOTH:
		case PAPER:
		case ROPE:
			armorClass = 11;
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

		throw new ParserException();
	}
}
