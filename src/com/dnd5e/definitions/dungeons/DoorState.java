package com.dnd5e.definitions.dungeons;

import com.miscellaneous.util.Dice;

public enum DoorState {
	OPEN, BROKEN, JAMMED, STUCK, BARRED, LOCKED;

	/*
	 * STATIC METHODS
	 */
	public static DoorState randomlyBarredOrLocked() {
		return Dice.roll(2) == 1 ? BARRED : LOCKED;
	}
}
