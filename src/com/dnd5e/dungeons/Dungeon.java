package com.dnd5e.dungeons;

public class Dungeon {

	/*
	 * INSTANCE FIELDS
	 */
	private Floor[] floors;
	private int currentFloor;

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

	private boolean floorsUnderMapped() {
		for (Floor el : floors) {
			if (el.isUnderMapped())
				return true;
		}

		return false;
	}

	public void explore() {
		floors[0].initialize();
		currentFloor = 0;

		int counter = 0;
		while (floorsUnderMapped()) {
			// if (floors[currentFloor].isUnderMapped())
			floors[currentFloor].explore();

			if (currentFloor < floors.length)
				++currentFloor;

			if (currentFloor == floors.length)
				currentFloor = 0;

			++counter;
			if (counter > 999)
				break;
		}
	}

	public boolean stairHandler(Stair stair) {
		boolean added = true;
		/*
		 * TODO - STAIR HANDLING
		 */
		int landings = stair.getFloors();
		for (int i = 1; i <= landings; ++i) {
			if (stair.isGoingUp() && i >= 0) {
				Stair s = Stair.build(stair.cardinal, stair.getLocation());
				// if (i < landings)
				// s.setExplored(true);

				if (floors[currentFloor - i].addStair(s) != true) {
					added = false;
					break;
				}

			} else if (stair.isGoingDown() && currentFloor + i < floors.length) {
				Stair s = Stair.build(stair.cardinal, stair.getLocation());
				if (floors[currentFloor + i].addStair(s) != true) {
					added = false;
					break;
				}
			}
		}

		return added;
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
