package com.dnd5e.dungeons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import com.dnd5e.definitions.dungeons.*;
import com.miscellaneous.util.Misc;

@SuppressWarnings("serial")
public class Door extends Segment {

	private DoorType doorType;

	/*
	 * CONSTRUCTORS
	 */
	private Door() {
		super();
		this.doorType = DoorType.PASSAGEWAY;
	}

	/*
	 * INSTANCE METHODS
	 */
	public DoorType getDoorType() {
		return doorType;
	}

	public void setDoorType(DoorType doorType) {
		this.doorType = doorType;
	}

	public Point nearestLocation() {
		int xOffset = x, yOffset = y;
		if (Cardinal.isNorthOrSouth(cardinal)) {
			xOffset = x - (x % Default.WALL_LENGTH);
			yOffset = y - (y % Default.WALL_LENGTH) + Default.WALL_LENGTH;

		} else {
			xOffset = x - (x % Default.WALL_LENGTH) + Default.WALL_LENGTH;
			yOffset = y - (y % Default.WALL_LENGTH);

		}

		// System.out.println(cardinal + " (" + x + ", " + y + ")" + " (" + xOffset + ",
		// " + yOffset + ")");

		return new Point(xOffset, yOffset);
	}

	public void paint(Graphics g) {

		if (doorType.equals(DoorType.PASSAGEWAY)) {
			g.setColor(Color.WHITE);
			g.fillRect(x, y, width, height);
			return;

		} else if (doorType.equals(DoorType.FALSE_DOOR)) {
			g.setColor(Color.BLUE);

		} else {
			g.setColor(Color.GREEN);

		}

		g.fillRect(x, y, width, height);
		// g.setColor(Color.BLACK);
		// g.drawRect(x, y, width, height);
	}

	/*
	 * STATIC METHODS
	 */
	public static Door build(Cardinal cardinal, Point p) {
		Door door = new Door();

		Dimension size = null;
		Point location = null;

		switch (cardinal) {
		case NORTH:
			size = Default.DOOR_SIZE;
			location = new Point(p.x + 2, p.y - 1);
			break;
		case EAST:
			size = Misc.transpose(Default.DOOR_SIZE);
			location = new Point(p.x - 1, p.y + 2);
			break;
		case SOUTH:
			size = Default.DOOR_SIZE;
			location = new Point(p.x + 2, p.y - 1);
			break;
		case WEST:
			size = Misc.transpose(Default.DOOR_SIZE);
			location = new Point(p.x - 1, p.y + 2);
			break;
		}

		door.setCardinal(cardinal);
		door.setLocation(location);
		door.setSize(size);

		return door;
	}

}
