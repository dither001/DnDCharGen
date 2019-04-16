package com.dnd5e.definitions.dungeons;

public enum DoorType {
	FALSE_DOOR, PASSAGEWAY, PORTCULLIS, SECRET_DOOR, STANDARD;

	public static boolean passageOrPortcullis(DoorType type) {
		return type.equals(PASSAGEWAY) || type.equals(PORTCULLIS);
	}

}
