package com.dnd5e.dungeons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import com.dnd5e.definitions.dungeons.*;
import com.dnd5e.definitions.gear.Material;
import com.miscellaneous.util.Default;
import com.miscellaneous.util.Dice;
import com.miscellaneous.util.Misc;

@SuppressWarnings("serial")
public class Door extends Segment {

	private Material material;
	private DoorState[] doorState;
	private DoorType doorType;

	/*
	 * CONSTRUCTORS
	 */
	private Door() {
		super();
		this.setMaterial(Material.WOOD);
		this.doorState = new DoorState[0];
		this.doorType = DoorType.PASSAGEWAY;
	}

	/*
	 * DOOR STATES
	 */
	protected boolean contains(DoorState state) {
		// OPEN, BROKEN, JAMMED, STUCK, BARRED, LOCKED
		for (DoorState el : doorState) {
			if (el.equals(state))
				return true;
		}

		return false;
	}

	protected String toStringDoorState() {
		String s = "[";
		for (int i = 0; i < doorState.length; ++i) {
			s += doorState[i];

			if (i + 1 < doorState.length)
				s += ", ";
		}
		s += "]";

		return s;
	}

	protected void setDoorState(DoorState[] doorState) {
		this.doorState = doorState;
	}

	public boolean add(DoorState state) {
		boolean add = false;
		if (doorState.length == 0) {
			doorState = new DoorState[] { state };
		} else if (contains(state) != true) {
			add = true;
			DoorState[] array = new DoorState[doorState.length + 1];
			for (int i = 0; i < doorState.length; ++i)
				array[i] = doorState[i];

			array[doorState.length] = state;
			doorState = array;
		}

		return add;
	}

	public boolean isDoorBarred() {
		return contains(DoorState.BARRED);
	}

	public boolean isDoorLocked() {
		return contains(DoorState.LOCKED);
	}

	public boolean isDoorStuck() {
		return contains(DoorState.STUCK);
	}

	/*
	 * INSTANCE METHODS
	 */
	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

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

		} else if (doorType.equals(DoorType.SECRET_DOOR)) {
			g.setColor(Color.WHITE);
			g.fillRect(x, y, width, height);

			// draw 'S'
			g.setColor(Color.BLACK);
			switch (cardinal) {
			case EAST:
			case WEST:
				g.drawString("S", x - 2, y + height + 2);
				break;
			case NORTH:
			case SOUTH:
				g.drawString("S", x - 1, y + height * 2);
				break;
			}
			return;

		} else {
			g.setColor(Color.GREEN);

		}

		g.fillRect(x, y, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);
	}

	/*
	 * STATIC METHODS
	 */
	public static Door build(Cardinal cardinal, Point p) {
		return build(cardinal, p, DoorType.STANDARD);
	}

	public static Door build(Cardinal cardinal, Point p, DoorType doorType) {
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
		door.setDoorType(doorType);
		door.setSize(size);

		return door;
	}

	public static Door random(Cardinal cardinal, Point p) {
		int dice;
		Door door = build(cardinal, p);

		dice = Dice.roll(10);
		DoorType type = DoorType.STANDARD;
		if (dice == 9)
			type = DoorType.PORTCULLIS;
		else if (dice == 10)
			type = DoorType.SECRET_DOOR;

		door.setDoorType(type);

		dice = Dice.roll(10);
		if (dice < 7)
			door.setMaterial(Material.WOOD);
		else if (dice < 9)
			door.setMaterial(Material.STONE);
		else
			door.setMaterial(Material.IRON);

		dice = Dice.roll(10);
		if (dice < 4)
			door.add(DoorState.randomlyBarredOrLocked());

		dice = Dice.roll(6);
		if (dice < 3)
			door.add(DoorState.STUCK);

		return door;
	}

}
