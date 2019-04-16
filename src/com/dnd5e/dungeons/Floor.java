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
	private List<Chamber> chambers;
	private List<Passage> passages;
	private List<Door> doors;

	private List<Point> points;

	/*
	 * CONSTRUCTORS
	 */
	private Floor() {
		chambers = new ArrayList<Chamber>();
		passages = new ArrayList<Passage>();
		doors = new ArrayList<Door>();
		//
		points = new ArrayList<Point>();
	}

	/*
	 * INSTANCE METHODS
	 */
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

		for (Door el : doors)
			el.paint(g);

		g.setColor(Color.ORANGE);
		for (Point el : points)
			g.fillOval(el.x, el.y, 5, 5);
	}

	public boolean inBounds(Rectangle r) {
		return Default.BOUNDARY.contains(r);
	}

	public boolean outOfBounds(Rectangle r) {
		return Default.BOUNDARY.contains(r) != true;
	}

	public boolean addChamber(Chamber chamber) {
		boolean added = false;
		if (isValidLocation(chamber))
			added = chambers.add(chamber);

		return added;
	}

	private boolean isValidLocation(Rectangle r) {
		if (outOfBounds(r))
			return false;

		for (Chamber el : chambers) {
			if (el.contains(r) || r.contains(el))
				return false;

			if (el.intersects(r) || r.intersects(el))
				return false;
		}

		for (Passage el : passages) {
			if (el.contains(r) || r.contains(el))
				return false;

			if (el.intersects(r) || r.intersects(el))
				return false;
		}

		return true;
	}

	public boolean addPassage(Passage passage) {
		boolean added = false;

		if (isValidLocation(passage))
			added = passages.add(passage);

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

	/*
	 * PRIVATE METHODS
	 */
	private void checkBeyondDoor(Door door) {
		if (door.explored != true) {
			door.setExplored(true);
			boolean added = false;

			Cardinal cardinal = door.getCardinal();
			Point point = door.nearestLocation();
			List<Point> loc = null;
			Chamber c = null;

			// TODO - set dice roll to 20
			switch (8) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
				/*
				 * straight, 20-foot passage
				 */
				Passage p = Passage.build(cardinal, point, 20, 10);
				p.shift(point);

				added = addPassage(p);
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
				 * CHAMBERS: determine size, location, & orientation
				 */
				c = Chamber.build(cardinal, point);
				c.shift(point);

				// randomize location
				loc = potentialLocations(c);
				if (loc.size() > 0) {
					Collections.shuffle(loc);
					c.setLocation(loc.get(0));
				}

				// finalize
				added = addChamber(c);
			case 19:
			case 20:
			default:
				break;
			}

			if (added != true)
				door.setDoorType(DoorType.FALSE_DOOR);
		}
	}

	private void checkBeyondPassage(Passage passage) {
		if (passage.explored != true) {
			passage.setExplored(true);
			boolean added = false;

			Cardinal cardinal = passage.getCardinal();
			List<Point> loc = null;
			Door door = null;
			Passage p = null;
			Bend b = null;

			switch (Dice.roll(19)) {
			case 1:
			case 2:
				/*
				 * straight, 20-foot passage
				 */
				p = Passage.build(cardinal, passage.nearestLocation(), 20, 10);
				p.shift(passage.nearestLocation());

				added = addPassage(p);
				break;
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
			case 11:
			case 12:
				/*
				 * LEFT TURN (11-12)
				 */
				p = Passage.build(cardinal, passage.nearestLocation(), 20, 10);
				p.shift(passage.nearestLocation());
				p.setExplored(true);

				if (addPassage(p)) {
					b = Bend.build(true, p);
					b.shift(p.nearestLocation());
					b.setExplored(true);

					if (addPassage(b)) {
						cardinal = cardinal.counterClockwise();
						p = Passage.build(cardinal, b);

						p.shift(b.nearestLocation());
						if (addPassage(p) != true)
							b.setDeadEnd(true);
					} else {
						p.setDeadEnd(true);

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
				p = Passage.build(cardinal, passage.nearestLocation(), 20, 10);
				p.shift(passage.nearestLocation());
				p.setExplored(true);

				if (addPassage(p)) {
					b = Bend.build(false, p);
					b.shift(p.nearestLocation());
					b.setExplored(true);

					if (addPassage(b)) {
						cardinal = cardinal.clockwise();
						p = Passage.build(cardinal, b);
						p.shift(b.nearestLocation());

						if (addPassage(p) != true)
							b.setDeadEnd(true);
					} else {
						p.setDeadEnd(true);
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
			case 20:
				// stairs
			default:
				break;

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

	private void setDoors(int[] doors, Segment s) {
		int length;

		// NORTH WALL
		length = s.width;
		for (int i = 0; i < length; i += Default.WALL_LENGTH) {
			if (doors[i / Default.WALL_LENGTH] == 1) {
				Point location = new Point(s.x + i, s.y);
				//
				addDoor(Door.build(Cardinal.NORTH, location));
			}
		}

		// EAST WALL
		length = s.height;
		for (int i = 0; i < length; i += Default.WALL_LENGTH) {
			int index = (i + s.width) / Default.WALL_LENGTH;
			if (doors[index] == 1) {
				Point location = new Point(s.x + s.width, s.y + i);
				//
				addDoor(Door.build(Cardinal.EAST, location));
			}
		}

		// SOUTH WALL
		length = s.width;
		for (int i = 0; i < length; i += Default.WALL_LENGTH) {
			int index = (i + s.width + s.height) / Default.WALL_LENGTH;
			if (doors[index] == 1) {
				Point location = new Point(s.x + i, s.y + s.width);
				//
				addDoor(Door.build(Cardinal.SOUTH, location));
			}

		}

		// WEST WALL
		length = s.height;
		for (int i = 0; i < length; i += Default.WALL_LENGTH) {
			int index = (i + s.width + s.height + s.width) / Default.WALL_LENGTH;
			if (doors[index] == 1) {
				Point location = new Point(s.x, s.y + i);
				//
				addDoor(Door.build(Cardinal.WEST, location));
			}
		}
	}

	private void checkForDoors(int probability, Segment s) {
		int length;

		// NORTH WALL
		length = s.width;
		for (int i = 0; i < length; i += Default.WALL_LENGTH) {
			if (Dice.roll(100) <= probability) {
				Point location = new Point(s.x + i + 2, s.y - 1);
				//
				addDoor(Door.build(Cardinal.NORTH, location));
			}
		}

		// EAST WALL
		length = s.height;
		for (int i = 0; i < length; i += Default.WALL_LENGTH) {
			if (Dice.roll(100) <= probability) {
				Point location = new Point(s.x + s.width - 1, s.y + i + 2);
				//
				addDoor(Door.build(Cardinal.EAST, location));
			}
		}

		// SOUTH /WALL
		length = s.width;
		for (int i = 0; i < length; i += Default.WALL_LENGTH) {
			if (Dice.roll(100) <= probability) {
				Point location = new Point(s.x + i + 2, s.y + s.width - 1);
				//
				addDoor(Door.build(Cardinal.SOUTH, location));
			}

		}

		// WEST WALL
		length = s.height;
		for (int i = 0; i < length; i += Default.WALL_LENGTH) {
			if (Dice.roll(100) <= probability) {
				Point location = new Point(s.x - 1, s.y + i + 2);
				//
				addDoor(Door.build(Cardinal.WEST, location));
			}
		}
	}

	private void explore() {
		int lastDoorOpened = 0, lastPassageExplored = 0;

		while (mappedArea() / Default.BOUNDARY_AREA < Default.AREA_TO_MAP) {
			// System.out.println(mappedArea() / Default.BOUNDARY_AREA);

			// advance passages
			for (int i = lastPassageExplored; i < passages.size(); ++i) {
				checkBeyondPassage(passages.get(i));
				lastPassageExplored = i;
			}

			// open doors
			for (int i = lastDoorOpened; i < doors.size(); ++i) {
				checkBeyondDoor(doors.get(i));
				lastDoorOpened = i;
			}

			if (allDoorsOpened() && allPassagesExplored())
				break;
		}

		System.out.println("total chambers: " + chambers.size());
		System.out.println("total passages: " + passages.size());
		System.out.println("total doors: " + doors.size());
		System.out.println(mappedArea() + " / " + Default.BOUNDARY_AREA);
		System.out.printf("%.2f%%%n", 100.0 * mappedArea() / Default.BOUNDARY_AREA);

	}

	private int mappedArea() {
		int area = 0;

		for (Chamber el : chambers)
			area += el.area();

		for (Passage el : passages)
			area += el.area();

		return area;
	}

	private boolean allPassagesExplored() {
		for (Passage el : passages) {
			if (el.explored != true)
				return false;
		}

		return true;
	}

	private boolean allDoorsOpened() {
		for (Door el : doors) {
			if (el.explored != true)
				return false;
		}

		return true;
	}

	/*
	 * STARTING ROOMS
	 */
	private Chamber room1() {
		Chamber chamber = Chamber.get(Chamber.TWO_BY_TWO);

		int[] doorLocations = Misc.initializeArray(chamber.numberOfSegments(), 0);
		for (int i = 0; i < doorLocations.length; i += (chamber.width / Default.WALL_LENGTH))
			doorLocations[Dice.roll(2) - 1 + i] = 1;

		for (int el : doorLocations)
			System.out.print(el + ", ");

		setDoors(doorLocations, chamber);

		return chamber;
	}

	/*
	 * STATIC METHODS
	 */
	public static Floor build() {
		Floor f = new Floor();

		System.out.println(f.addChamber(f.room1()));

		// f.checkForDoors(100, f.chambers.get(0));

		f.explore();

		return f;
	}

}
