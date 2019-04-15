package com.dnd5e.definitions.dungeons;

import com.miscellaneous.util.*;

public enum Cardinal {
	NORTH, SOUTH, EAST, WEST;

	public Cardinal clockwise() {
		Cardinal direction = null;

		switch (this) {
		case EAST:
			direction = SOUTH;
			break;
		case NORTH:
			direction = EAST;
			break;
		case SOUTH:
			direction = WEST;
			break;
		case WEST:
			direction = NORTH;
			break;
		default:
			break;
		}

		return direction;
	}

	public Cardinal counterClockwise() {
		Cardinal direction = null;

		switch (this) {
		case EAST:
			direction = NORTH;
			break;
		case NORTH:
			direction = WEST;
			break;
		case SOUTH:
			direction = EAST;
			break;
		case WEST:
			direction = SOUTH;
			break;
		default:
			break;
		}

		return direction;
	}

	public boolean isNorth() {
		return this.equals(NORTH);
	}

	public boolean isSouth() {
		return this.equals(SOUTH);
	}

	public boolean isEast() {
		return this.equals(EAST);
	}

	public boolean isWest() {
		return this.equals(WEST);
	}

	/*
	 * STATIC METHODS
	 */
	public static Cardinal random() {
		Cardinal[] array = new Cardinal[] { NORTH, SOUTH, EAST, WEST };

		return Misc.randomFromArray(array);
	}

	public static boolean isNorthOrSouth(Cardinal o) {
		boolean northSouth = false;

		if (o.equals(Cardinal.NORTH) || o.equals(Cardinal.SOUTH))
			northSouth = true;

		return northSouth;
	}
}
