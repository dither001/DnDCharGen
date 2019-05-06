package com.dnd5e.definitions.dungeons;

public enum DoorType {
	DEAD, FALSE_DOOR, PASSAGEWAY, PORTCULLIS, SECRET_DOOR, STANDARD, TEST;

	public static boolean passageOrPortcullis(DoorType type) {
		return type.equals(PASSAGEWAY) || type.equals(PORTCULLIS);
	}

}
