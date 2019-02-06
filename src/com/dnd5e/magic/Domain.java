package com.dnd5e.magic;

import com.dnd5e.characters.*;
import com.dnd5e.exceptions.*;

public enum Domain {
	DEATH, KNOWLEDGE, LIFE, LIGHT, NATURE, TEMPEST, TRICKERY, WAR;

	/*
	 * STATIC METHODS
	 */
	public static Domain parseClericSubclass(Subclass subclass) throws InvalidDomainException {
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

		throw new InvalidDomainException();
	}
}