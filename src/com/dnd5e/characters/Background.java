package com.dnd5e.characters;

import com.dnd5e.exceptions.*;
import com.dnd5e.util.*;

public enum Background {
	ACOLYTE, CHARLATAN, CRIMINAL, ENTERTAINER, FOLK_HERO, GUILD_ARTISAN, HERMIT, NOBLE, OUTLANDER, SAGE, SAILOR, SOLDIER, URCHIN;

	private static final Background[] BACKGROUNDS = { ACOLYTE, CHARLATAN, CRIMINAL, ENTERTAINER, FOLK_HERO,
			GUILD_ARTISAN, HERMIT, NOBLE, OUTLANDER, SAGE, SAILOR, SOLDIER, URCHIN };

	/*
	 * INSTANCE METHODS
	 */
	public int indexOf() {
		return Misc.indexOfEnum(this.toString(), BACKGROUNDS);
	}

	/*
	 * STATIC METHODS
	 */
	public static Background parse(String s) throws InvalidBackgroundException {
		for (Background el : BACKGROUNDS) {
			if (el.toString().compareToIgnoreCase(s) == 0)
				return el;
		}

		throw new InvalidBackgroundException();
	}

	public static Background random() {
		return Misc.randomFromArray(BACKGROUNDS);
	}
}
