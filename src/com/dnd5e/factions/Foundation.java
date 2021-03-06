package com.dnd5e.factions;

public enum Foundation {
	ALIGNMENT, GOD, RACE, BACKGROUND, JOB, NONE;

	/*
	 * 
	 */
	public boolean higherIdeal() {
		return this.equals(NONE) != true;
	}

	public Foundation next() {
		Foundation next = ALIGNMENT;

		switch (this) {
		case ALIGNMENT:
			next = GOD;
			break;
		case GOD:
			next = RACE;
			break;
		case RACE:
			next = BACKGROUND;
			break;
		case BACKGROUND:
			next = JOB;
			break;
		case JOB:
			next = NONE;
			break;
		case NONE:
			break;
		}

		return next;
	}
}
