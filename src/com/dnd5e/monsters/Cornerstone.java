package com.dnd5e.monsters;

import com.dnd5e.exceptions.*;
import com.miscellaneous.util.*;

public enum Cornerstone {
	ANGEL, DEMON, DRAGON, FAERIE, GIANT, GOD, OLD_ONE, SPIRIT, UNDEAD;
	
	private static final Cornerstone[] CORNERSTONES = { ANGEL, DEMON, DRAGON, FAERIE, GIANT, GOD, OLD_ONE, SPIRIT, UNDEAD };
	
	/*
	 * INSTANCE METHODS
	 */
	public int indexOf() {
		return Misc.indexOfEnum(this.toString(), CORNERSTONES);
	}

	/*
	 * STATIC METHODS
	 */
	public static Cornerstone get(int index) {
		return CORNERSTONES[index];
	}

	public static Cornerstone parse(String s) throws ParserException {
		for (Cornerstone el : CORNERSTONES) {
			if (el.toString().compareToIgnoreCase(s) == 0)
				return el;
		}
		
		throw new ParserException(s);
	}

}
