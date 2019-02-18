package com.dnd5e.gear.definitions;

public enum Material {
	CLOTH, PAPER, ROPE, CRYSTAL, GLASS, ICE, WOOD, BONE, STONE, IRON, STEEL, MITHRAL, ADAMANTINE;

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

}
