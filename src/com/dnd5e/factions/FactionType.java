package com.dnd5e.factions;

import com.dnd5e.characters.*;
import com.miscellaneous.util.Misc;

public enum FactionType {
	BAND, // bravos (mercenaries)
	CULT, //
	GANG, // assassins, shadows (spies/thieves)
	RING; // smugglers, hawkers (dealers/slavers/traffickers)

	private static FactionType[] TYPES;

	static {

		TYPES = new FactionType[] { BAND, CULT, GANG, RING };
	}

	/*
	 * STATIC METHODS
	 */
	public static FactionType getType(Background bg) {
		FactionType type = null;

		switch (bg) {
		case ACOLYTE:
		case NOBLE:
		case SAGE:
			type = CULT;
			break;
		case CHARLATAN:
		case CRIMINAL:
		case ENTERTAINER:
		case GUILD_ARTISAN:
			type = RING;
			break;
		case SAILOR:
		case SOLDIER:
			type = BAND;
			break;
		case FOLK_HERO:
		case HERMIT:
		case OUTLANDER:
		case URCHIN:
		default:
			type = GANG;
			break;
		}

		return type;
	}

	public static FactionType random() {
		return Misc.randomFromArray(TYPES);
	}
}
