package com.dnd5e.dungeons;

public class Dungeon {

	/*
	 * INSTANCE FIELDS
	 */
	private Floor[] floors;

	/*
	 * CONSTRUCTORS
	 */
	private Dungeon() {
		setFloors(new Floor[0]);
	}

	/*
	 * INSTANCE METHODS
	 */
	public Floor getFloor(int index) {
		return floors[index];
	}

	public Floor[] getFloors() {
		return floors;
	}

	public void setFloors(Floor[] floors) {
		this.floors = floors;
	}

	public void explore() {
		floors[0].explore();
	}

	public boolean stairHandler(Stair stair) {
		/*
		 * TODO - STAIR HANDLING
		 */
		return false;
	}

	/*
	 * STATIC METHODS
	 */
	public static Dungeon build(int totalFloors) {
		Dungeon dungeon = new Dungeon();

		Floor[] floors = new Floor[totalFloors];
		for (int i = 0; i < totalFloors; ++i)
			floors[i] = Floor.build(dungeon);

		dungeon.setFloors(floors);

		return dungeon;
	}

}
