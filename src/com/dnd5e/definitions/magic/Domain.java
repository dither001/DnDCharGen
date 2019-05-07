package com.dnd5e.definitions.magic;

import com.dnd5e.characters.*;
import com.miscellaneous.util.*;

public enum Domain {
	DEATH, KNOWLEDGE, LIFE, LIGHT, NATURE, TEMPEST, TRICKERY, WAR;

	/*
	 * STATIC METHODS
	 */
	@SuppressWarnings("incomplete-switch")
	public static Domain parseClericSubclass(Subclass subclass) throws ParserException {
		switch (subclass) {
		case DEATH:
			return Domain.DEATH;
		case KNOWLEDGE:
			return Domain.KNOWLEDGE;
		case LIFE:
			return Domain.LIFE;
		case LIGHT:
			return Domain.LIGHT;
		case NATURE:
			return Domain.NATURE;
		case TEMPEST:
			return Domain.TEMPEST;
		case TRICKERY:
			return Domain.TRICKERY;
		case WAR:
			return Domain.WAR;
		}

		throw new ParserException();
	}
}