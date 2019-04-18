package com.dnd5e.dungeons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.dnd5e.definitions.dungeons.*;
import com.miscellaneous.util.*;

public class Floor {
	private Dungeon dungeon;
	//
	private List<Chamber> chambers;
	private List<Passage> passages;
	private List<Door> doors;
	private List<Stair> stairs;

	private List<Point> points;

	// CONVENIENVE
	private int totalMappedArea;

	/*
	 * CONSTRUCTORS
	 */
	private Floor() {
		setDungeon(null);
		//
		chambers = new ArrayList<Chamber>();
		passages = new ArrayList<Passage>();
		doors = new ArrayList<Door>();
		stairs = new ArrayList<Stair>();
		//
		points = new ArrayList<Point>();
		//
		totalMappedArea = 0;
	}

	/*
	 * INSTANCE METHODS
	 */
	public String toString() {
		return getClass().getSimpleName();
	}

	public boolean hasStairs() {
		return stairs.size() > 0;
	}

	public Dungeon getDungeon() {
		return dungeon;
	}

	public void setDungeon(Dungeon dungeon) {
		this.dungeon = dungeon;
	}

	public List<Chamber> getChambers() {
		return chambers;
	}

	public void setChambers(List<Chamber> chambers) {
		this.chambers = chambers;
	}

	public List<Passage> getPassages() {
		return passages;
	}

	public void setPassages(List<Passage> passages) {
		this.passages = passages;
	}

	public int getTotalMappedArea() {
		return totalMappedArea;
	}

	public void paint(Graphics g) {
		int length = Default.WALL_LENGTH;
		int width = Default.DIMENSIONS.width;
		int height = Default.DIMENSIONS.height;

		g.setColor(Color.CYAN);
		if (Default.SHOW_GRID) {
			for (int i = length; i < width; i += length)
				g.drawLine(i, 0, i, height);

			for (int i = length; i < height; i += length)
				g.drawLine(0, i, width, i);
		}

		g.setColor(Color.RED);
		if (Default.SHOW_BOUNDARY) {
			g.drawRect(Default.BOUNDARY.x, Default.BOUNDARY.y, Default.BOUNDARY.width, Default.BOUNDARY.height);
		}

		for (Chamber el : chambers)
			el.paint(g);

		for (Passage el : passages)
			el.paint(g);

		for (Stair el : stairs)
			el.paint(g);

		for (Door el : doors)
			el.paint(g);

		g.setColor(Color.BLACK);
		for (Point el : points)
			g.fillOval(el.x, el.y, 5, 5);
	}

	public boolean addChamber(Chamber chamber) {
		boolean added = false;
		if (isValidLocation(chamber))
			added = chambers.add(chamber);

		return added;
	}

	public boolean addDoor(Door door) {
		if (outOfBounds(door))
			return false;

		for (Door el : doors) {
			if (el.contains(door) || el.intersects(door))
				return false;
		}

		return doors.add(door);
	}

	public boolean addPassage(Passage passage) {
		boolean added = false;

		if (isValidLocation(passage))
			added = passages.add(passage);

		return added;
	}

	public boolean addStair(Stair stair) {
		boolean added = false;

		if (isValidLocation(stair))
			added = stairs.add(stair);

		return added;
	}

	public boolean isUnderMapped() {
		return 1.0 * totalMappedArea / Default.BOUNDARY_AREA < Default.AREA_TO_MAP;
	}

	/*
	 * XXX - This method will randomly select a starting passage.
	 */
	public void initialize() {
		addChamber(room1());
	}

	/*
	 * XXX - This method loops through unexplored passages and unopened doors.
	 */
	public void explore() {
		int doorIndex = 0, roomIndex = 0, passageIndex = 0, stairIndex = 0;
		while (unexplored() && isUnderMapped()) {
			// advance stairs
			for (int i = stairIndex; i < stairs.size(); ++i) {
				checkBeyondPassage(stairs.get(stairIndex));
				stairIndex = i;
			}

			// advance passages
			for (int i = passageIndex; i < passages.size(); ++i) {
				checkBeyondPassage(passages.get(i));
				passageIndex = i;
			}

			// check for doors
			for (int i = roomIndex; i < chambers.size(); ++i) {
				checkRoomForDoors(10, chambers.get(roomIndex));
				roomIndex = i;
			}

			// open doors
			for (int i = doorIndex; i < doors.size(); ++i) {
				checkBeyondDoor(doors.get(i));
				doorIndex = i;
			}

			totalMappedArea = totalMappedArea();
			if (explored())
				break;
		}

		// System.out.println("total chambers: " + chambers.size());
		// System.out.println("total passages: " + passages.size());
		// System.out.println("total doors: " + doors.size());

		// for (Door el : doors)
		// System.out.println(el.toStringDoorState());

		// System.out.println();
		// System.out.println(mappedArea() + " / " + Default.BOUNDARY_AREA);
		// System.out.printf("%.2f%%%n", 100.0 * mappedArea() / Default.BOUNDARY_AREA);

	}

	/*
	 * PRIVATE METHODS
	 */
	@SuppressWarnings("unused")
	private boolean inBounds(Rectangle r) {
		return Default.BOUNDARY.contains(r);
	}

	private boolean outOfBounds(Rectangle r) {
		return Default.BOUNDARY.contains(r) != true;
	}

	private boolean isValidLocation(Rectangle r) {
		if (outOfBounds(r))
			return false;

		for (Chamber el : chambers) {
			if (el.intersects(r) || r.intersects(el))
				return false;

			if (el.contains(r) || r.contains(el))
				return false;
		}

		for (Passage el : passages) {
			if (el.contains(r) || r.contains(el))
				return false;

			if (el.intersects(r) || r.intersects(el))
				return false;
		}

		for (Stair el : stairs) {
			if (el.contains(r) || r.contains(el))
				return false;

			if (el.intersects(r) || r.intersects(el))
				return false;
		}

		return true;
	}

	/*
	 * XXX - Helper methods used to determine when/how to explore.
	 */
	private boolean unexplored() {
		return explored() != true;
	}

	private boolean explored() {
		// XXX - In order of importance: passages, doors, stairs
		boolean allPassagesExplored = allPassagesExplored();
		boolean allDoorsOpened = allDoorsOpened();
		boolean allStairsExplored = allStairsExplored();

		return allPassagesExplored && allDoorsOpened && allStairsExplored;
	}

	private boolean allDoorsOpened() {
		for (Door el : doors) {
			if (el.explored != true)
				return false;
		}

		return true;
	}

	private boolean allPassagesExplored() {
		for (Passage el : passages) {
			if (el.explored != true)
				return false;
		}

		return true;
	}

	private boolean allStairsExplored() {
		for (Stair el : stairs) {
			if (el.explored != true)
				return false;
		}

		return true;
	}

	/*
	 * XXX - This method checks what exists beyond a door.
	 */
	private void checkBeyondDoor(Door door) {
		if (door.explored != true) {
			door.setExplored(true);

			Cardinal cardinal = door.getCardinal();
			List<Point> loc = null;

			switch (Dice.roll(20)) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
				/*
				 * straight, 20-foot passage (3-8)
				 */
				Passage p = Passage.build(cardinal, door.nearestLocation(), 20, 10);
				p.shift(door.nearestLocation());

				if (addPassage(p) != true)
					door.setDoorType(DoorType.FALSE_DOOR);
				break;
			case 9:
			case 10:
			case 11:
			case 12:
			case 13:
			case 14:
			case 15:
			case 16:
			case 17:
			case 18:
				/*
				 * CHAMBERS (9-18)
				 */
				Chamber c = Chamber.build(cardinal, door.nearestLocation());
				c.shift(door.nearestLocation());

				// randomize location
				loc = potentialLocations(c);
				if (loc.size() > 0) {
					Collections.shuffle(loc);
					c.setLocation(loc.get(0));
				}

				// finalize
				if (addChamber(c) != true)
					door.setDoorType(DoorType.FALSE_DOOR);
				break;
			case 19:
				Stair s = Stair.build(cardinal, door.nearestLocation());
				s.shift(door.nearestLocation());
				s.setExplored(true);

				if (addStair(s)) {
					dungeon.stairHandler(s);
				} else {
					door.setDoorType(DoorType.FALSE_DOOR);
				}
				break;
			case 20:
				door.setDoorType(DoorType.FALSE_DOOR);
			default:
				break;
			}
		}
	}

	/*
	 * XXX - This method checks what exists beyond the current passage.
	 */
	private void checkBeyondPassage(Passage passage) {
		if (passage.explored != true) {
			passage.setExplored(true);
			boolean added = false;

			Cardinal cardinal = passage.getCardinal();
			Point point = null;
			List<Point> loc = null;
			Door door = null;
			Passage p1 = null, p2 = null;
			Bend b = null;
			Branch br = null;

			int dice;
			if (passage.getClass().equals(Stair.class)) {
				/*
				 * XXX - Stair extends Passage, therefore it uses this method to determine what
				 * can be found "beyond." Stairs generally lead to either A) a passage, B) a
				 * chamber, or C) a dead end. For this reason, I set the dice roller to "ignore"
				 * the possibility of discovering more stairs beyond a set of stairs.
				 */
				dice = Dice.roll(19);

			} else {
				dice = Dice.roll(20);

			}

			switch (dice) {
			case 1:
			case 2:
				/*
				 * straight, 20-foot passage (1-2)
				 */
				p1 = Passage.build(cardinal, passage.nearestLocation(), 20, 10);
				p1.shift(passage.nearestLocation());

				if (addPassage(p1) != true)
					passage.setDeadEnd(true);
				break;
			case 3:
				/*
				 * 40-foot passage w/door on left (3)
				 */
				p1 = Passage.build(cardinal, passage.nearestLocation(), 40, 10);
				p1.shift(passage.nearestLocation());

				if (addPassage(p1)) {
					point = p1.nearestLocation();

					switch (cardinal) {
					case NORTH:
						point.translate(0, Default.WALL_LENGTH);
						break;
					case EAST:
						point.translate(-2 * Default.WALL_LENGTH, 0);
						break;
					case SOUTH:
						point.translate(Default.WALL_LENGTH, -2 * Default.WALL_LENGTH);
						break;
					case WEST:
						point.translate(Default.WALL_LENGTH, Default.WALL_LENGTH);
						break;
					}

					addDoor(Door.build(cardinal.counterClockwise(), point));
				} else {
					passage.setDeadEnd(true);

				}
				break;
			case 4:
				/*
				 * 40-foot passage w/door on right (4)
				 */
				p1 = Passage.build(cardinal, passage.nearestLocation(), 40, 10);
				p1.shift(passage.nearestLocation());

				if (addPassage(p1)) {
					point = p1.nearestLocation();

					switch (cardinal) {
					case NORTH:
						point.translate(Default.WALL_LENGTH, Default.WALL_LENGTH);
						break;
					case EAST:
						point.translate(-2 * Default.WALL_LENGTH, Default.WALL_LENGTH);
						break;
					case SOUTH:
						point.translate(0, -2 * Default.WALL_LENGTH);
						break;
					case WEST:
						point.translate(Default.WALL_LENGTH, 0);
						break;
					}

					addDoor(Door.build(cardinal.clockwise(), point));
				} else {
					passage.setDeadEnd(true);

				}
				break;
			case 5:
				/*
				 * 20-foot passage ends in door (5)
				 */
				p1 = Passage.build(cardinal, passage.nearestLocation(), 20, 10);
				p1.shift(passage.nearestLocation());
				p1.setExplored(true);
				p1.setDeadEnd(true);

				if (addPassage(p1)) {
					addDoor(Door.build(cardinal, p1.nearestLocation()));

				} else {
					passage.setDeadEnd(true);

				}
				break;
			case 6:
			case 7:
				/*
				 * RIGHT BRANCH (6-7)
				 */
				p1 = Passage.build(cardinal, passage.nearestLocation(), 20, 10);
				p1.shift(passage.nearestLocation());
				p1.setExplored(true);

				if (addPassage(p1)) {
					br = Branch.build(false, p1);
					br.shift(p1.nearestLocation());
					br.setExplored(true);

					if (addPassage(br)) {
						// first follow straight passage
						p2 = Passage.build(cardinal, br.nearestLocation(), 10, 10);
						p2.shift(br.nearestLocation());

						if (addPassage(p2) != true) {
							br.setDeadEnd(true);
						}

						// then follow branch
						cardinal = cardinal.clockwise();
						p2 = Passage.build(cardinal, br.branchTo(), 10, 10);
						p2.shift(br.branchTo());

						if (addPassage(p2) != true) {
							br.setBranchDeadEnds(true);
						}

					} else {
						// passage leading to branch
						p1.setDeadEnd(true);

					}
				} else {
					// original passage before branch
					passage.setDeadEnd(true);

				}
				break;
			case 8:
			case 9:
				/*
				 * LEFT BRANCH (8-9)
				 */
				p1 = Passage.build(cardinal, passage.nearestLocation(), 20, 10);
				p1.shift(passage.nearestLocation());
				p1.setExplored(true);

				if (addPassage(p1)) {
					br = Branch.build(true, p1);
					br.shift(p1.nearestLocation());
					br.setExplored(true);

					if (addPassage(br)) {
						// first follow straight passage
						p2 = Passage.build(cardinal, br.nearestLocation(), 10, 10);
						p2.shift(br.nearestLocation());

						if (addPassage(p2) != true) {
							br.setDeadEnd(true);
						}

						// then follow branch
						cardinal = cardinal.counterClockwise();
						p2 = Passage.build(cardinal, br.branchTo(), 10, 10);
						p2.shift(br.branchTo());

						if (addPassage(p2) != true) {
							br.setBranchDeadEnds(true);
						}

					} else {
						// passage leading to branch
						p1.setDeadEnd(true);

					}
				} else {
					// original passage before branch
					passage.setDeadEnd(true);

				}
				break;
			case 10:
				/*
				 * dead end w/chance of secret door (10)
				 */
				p1 = Passage.build(cardinal, passage.nearestLocation(), 20, 10);
				p1.shift(passage.nearestLocation());
				p1.setExplored(true);
				p1.setDeadEnd(true);

				if (addPassage(p1)) {
					if (Dice.roll(10) == 10) {
						addDoor(Door.build(cardinal, p1.nearestLocation(), DoorType.SECRET_DOOR));

					}

				} else {
					passage.setDeadEnd(true);

				}
				break;
			case 11:
			case 12:
				/*
				 * LEFT TURN (11-12)
				 */
				p1 = Passage.build(cardinal, passage.nearestLocation(), 20, 10);
				p1.shift(passage.nearestLocation());
				p1.setExplored(true);

				if (addPassage(p1)) {
					b = Bend.build(true, p1);
					b.shift(p1.nearestLocation());
					b.setExplored(true);

					if (addPassage(b)) {
						cardinal = cardinal.counterClockwise();
						p1 = Passage.build(cardinal, b);

						p1.shift(b.nearestLocation());
						if (addPassage(p1) != true)
							b.setDeadEnd(true);
					} else {
						p1.setDeadEnd(true);

					}
				} else {
					passage.setDeadEnd(true);

				}
				break;
			case 13:
			case 14:
				/*
				 * RIGHT TURN (13-14)
				 */
				p1 = Passage.build(cardinal, passage.nearestLocation(), 20, 10);
				p1.shift(passage.nearestLocation());
				p1.setExplored(true);

				if (addPassage(p1)) {
					b = Bend.build(false, p1);
					b.shift(p1.nearestLocation());
					b.setExplored(true);

					if (addPassage(b)) {
						cardinal = cardinal.clockwise();
						p1 = Passage.build(cardinal, b);
						p1.shift(b.nearestLocation());

						if (addPassage(p1) != true)
							b.setDeadEnd(true);
					} else {
						p1.setDeadEnd(true);
					}
				} else {
					passage.setDeadEnd(true);

				}
				break;
			case 15:
			case 16:
			case 17:
			case 18:
			case 19:
				/*
				 * CHAMBERS (15-19)
				 */
				Chamber c = Chamber.build(cardinal, passage.nearestLocation());
				c.shift(passage.nearestLocation());

				// randomize location
				loc = potentialLocations(c);
				if (loc.size() > 0) {
					Collections.shuffle(loc);
					c.setLocation(loc.get(0));
				}

				// finalize
				added = addChamber(c);
				if (added) {
					door = Door.build(cardinal, passage.nearestLocation());
					door.setDoorType(DoorType.PASSAGEWAY);
					door.setExplored(true);
					addDoor(door);
				} else {
					passage.setDeadEnd(true);

				}
				break;
			case 20:
				/*
				 * STAIRS (20)
				 */
				Stair s = Stair.build(cardinal, passage.nearestLocation());
				s.shift(passage.nearestLocation());
				s.setExplored(true);

				if (addStair(s)) {
					dungeon.stairHandler(s);
				} else {
					passage.setDeadEnd(true);

				}
				break;
			default:
				break;

			}
		}
	}

	/*
	 * XXX - This method checks a segment for possible doors.
	 * 
	 */
	private void checkRoomForDoors(int probability, Segment s) {
		int length;

		// NORTH WALL
		length = s.width;
		for (int i = 0; i < length; i += Default.WALL_LENGTH) {
			if (Dice.roll(100) <= probability) {
				Point location = new Point(s.x + i, s.y);
				//
				addDoor(Door.random(Cardinal.NORTH, location));
			}
		}

		// EAST WALL
		length = s.height;
		for (int i = 0; i < length; i += Default.WALL_LENGTH) {
			if (Dice.roll(100) <= probability) {
				Point location = new Point(s.x + s.width, s.y + i);
				//
				addDoor(Door.random(Cardinal.EAST, location));
			}
		}

		// SOUTH WALL
		length = s.width;
		for (int i = 0; i < length; i += Default.WALL_LENGTH) {
			if (Dice.roll(100) <= probability) {
				Point location = new Point(s.x + i, s.y + s.height);
				//
				addDoor(Door.random(Cardinal.SOUTH, location));
			}

		}

		// WEST WALL
		length = s.height;
		for (int i = 0; i < length; i += Default.WALL_LENGTH) {
			if (Dice.roll(100) <= probability) {
				Point location = new Point(s.x, s.y + i);
				//
				addDoor(Door.random(Cardinal.WEST, location));
			}
		}
	}

	private List<Point> potentialLocations(Chamber chamber) {
		List<Point> list = new ArrayList<Point>();
		Point startingPoint = chamber.getLocation();
		Dimension size = chamber.getSize();

		int pivots = 0;
		if (Cardinal.isNorthOrSouth(chamber.getCardinal())) {
			// can slide left & right
			pivots = chamber.width / Default.WALL_LENGTH;
			for (int i = 0; i < pivots; ++i) {
				Point current = new Point(startingPoint.x - i * Default.WALL_LENGTH, startingPoint.y);
				Rectangle r = new Rectangle(current, size);

				if (isValidLocation(r))
					list.add(current);
			}

		} else {
			// can slide up & down
			pivots = chamber.height / Default.WALL_LENGTH;
			for (int i = 0; i < pivots; ++i) {
				Point current = new Point(startingPoint.x, startingPoint.y - i * Default.WALL_LENGTH);
				Rectangle r = new Rectangle(current, size);

				if (isValidLocation(r))
					list.add(current);
			}
		}

		return list;
	}

	/*
	 * XXX - This method sets all doors in an array to the specified type.
	 */
	private void setDoorsOfType(int[] doors, Segment s, DoorType doorType) {
		int length;

		// NORTH WALL
		length = s.width;
		for (int i = 0; i < length; i += Default.WALL_LENGTH) {
			if (doors[i / Default.WALL_LENGTH] == 1) {
				Point location = new Point(s.x + i, s.y);
				//
				addDoor(Door.build(Cardinal.NORTH, location, doorType));
			}
		}

		// EAST WALL
		length = s.height;
		for (int i = 0; i < length; i += Default.WALL_LENGTH) {
			int index = (i + s.width) / Default.WALL_LENGTH;
			if (doors[index] == 1) {
				Point location = new Point(s.x + s.width, s.y + i);
				//
				addDoor(Door.build(Cardinal.EAST, location, doorType));
			}
		}

		// SOUTH WALL
		length = s.width;
		for (int i = 0; i < length; i += Default.WALL_LENGTH) {
			int index = (i + s.width + s.height) / Default.WALL_LENGTH;
			if (doors[index] == 1) {
				Point location = new Point(s.x + i, s.y + s.width);
				//
				addDoor(Door.build(Cardinal.SOUTH, location, doorType));
			}

		}

		// WEST WALL
		length = s.height;
		for (int i = 0; i < length; i += Default.WALL_LENGTH) {
			int index = (i + s.width + s.height + s.width) / Default.WALL_LENGTH;
			if (doors[index] == 1) {
				Point location = new Point(s.x, s.y + i);
				//
				addDoor(Door.build(Cardinal.WEST, location, doorType));
			}
		}
	}

	private int totalMappedArea() {
		int area = 0;

		for (Chamber el : chambers)
			area += el.area();

		for (Passage el : passages)
			area += el.area();

		return area;
	}

	/*
	 * STARTING ROOMS
	 */
	private Chamber room1() {
		Chamber chamber = Chamber.get(Chamber.TWO_BY_TWO);

		int[] doorLocations = Misc.initializeArray(chamber.numberOfSegments(), 0);
		for (int i = 0; i < doorLocations.length; i += (chamber.width / Default.WALL_LENGTH))
			doorLocations[Dice.roll(2) - 1 + i] = 1;

		// for (int el : doorLocations)
		// System.out.print(el + ", ");

		setDoorsOfType(doorLocations, chamber, DoorType.PASSAGEWAY);

		return chamber;
	}

	/*
	 * STATIC METHODS
	 */
	public static Floor build(Dungeon dungeon) {
		Floor floor = new Floor();
		floor.setDungeon(dungeon);

		return floor;
	}

}
