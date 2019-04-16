package com.dnd5e.dungeons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import com.dnd5e.definitions.dungeons.*;
import com.miscellaneous.util.*;

@SuppressWarnings("serial")
public class Chamber extends Segment {

	// SQUARES
	public static final Dimension TWO_BY_TWO;
	public static final Dimension THREE_BY_THREE;
	public static final Dimension FOUR_BY_FOUR;
	public static final Dimension FIVE_BY_FIVE;
	public static final Dimension SIX_BY_SIX;
	// RECTANGLES
	public static final Dimension TWO_BY_THREE;
	public static final Dimension THREE_BY_FOUR;
	public static final Dimension FOUR_BY_FIVE;
	public static final Dimension FIVE_BY_EIGHT;

	static {
		TWO_BY_TWO = new Dimension(2 * Default.WALL_LENGTH, 2 * Default.WALL_LENGTH);
		THREE_BY_THREE = new Dimension(3 * Default.WALL_LENGTH, 3 * Default.WALL_LENGTH);
		FOUR_BY_FOUR = new Dimension(4 * Default.WALL_LENGTH, 4 * Default.WALL_LENGTH);
		FIVE_BY_FIVE = new Dimension(5 * Default.WALL_LENGTH, 5 * Default.WALL_LENGTH);
		SIX_BY_SIX = new Dimension(6 * Default.WALL_LENGTH, 6 * Default.WALL_LENGTH);
		//
		TWO_BY_THREE = new Dimension(2 * Default.WALL_LENGTH, 3 * Default.WALL_LENGTH);
		THREE_BY_FOUR = new Dimension(3 * Default.WALL_LENGTH, 4 * Default.WALL_LENGTH);
		FOUR_BY_FIVE = new Dimension(4 * Default.WALL_LENGTH, 5 * Default.WALL_LENGTH);
		FIVE_BY_EIGHT = new Dimension(5 * Default.WALL_LENGTH, 8 * Default.WALL_LENGTH);

	}

	/*
	 * INSTANCE FIELDS
	 */
	private boolean isRoomCircular;

	/*
	 * CONSTRUCTORS
	 */
	private Chamber() {
		super();
		this.setLocation(Default.MIDPOINT);
		this.setRoomCircular(false);
	}

	/*
	 * INSTANCE METHODS
	 */
	private boolean isLargeRoom;

	/*
	 * INSTANCE METHODS
	 */
	public boolean isLargeRoom() {
		return isLargeRoom;
	}

	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);

		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);

		if (isRoomCircular)
			g.drawOval(x, y, width, height);

	}

	/*
	 * STATIC METHODS
	 */
	public static Chamber build(Cardinal cardinal, Point location) {
		Chamber chamber = new Chamber();

		Dimension size = randomDimension();

		chamber.setCardinal(cardinal);
		chamber.setLocation(new Point(location));
		chamber.setSize(size);

		if (Dice.roll(3) == 3 && (size.equals(THREE_BY_THREE) || size.equals(FOUR_BY_FOUR)))
			chamber.setRoomCircular(true);

		if (size.equals(FIVE_BY_FIVE) || size.equals(SIX_BY_SIX))
			chamber.setRoomCircular(true);

		return chamber;
	}

	public static Chamber get(Dimension dimension) {
		Chamber chamber = new Chamber();

		chamber.setCardinal(Cardinal.NORTH);
		chamber.setSize(dimension);

		return chamber;
	}

	public static Dimension randomDimension() {
		Dimension d = null;

		switch (Dice.roll(20)) {
		case 1:
		case 2:
			d = TWO_BY_TWO;
			break;
		case 3:
		case 4:
			d = THREE_BY_THREE;
			break;
		case 5:
		case 6:
			d = FOUR_BY_FOUR;
			break;
		case 7:
		case 8:
		case 9:
			d = TWO_BY_THREE;
			break;
		case 10:
		case 11:
		case 12:
			d = THREE_BY_FOUR;
			break;
		case 13:
		case 14:
			d = FOUR_BY_FIVE;
			break;
		case 15:
			d = FIVE_BY_EIGHT;
			break;
		case 16:
			// 30-ft. circle
			d = THREE_BY_THREE;
			break;
		case 17:
			// 50-ft. circle
			d = FIVE_BY_FIVE;
			break;
		case 18:
			// 40-ft. octagon
			d = FOUR_BY_FOUR;
			break;
		case 19:
			// 60-ft. octagon
			d = SIX_BY_SIX;
			break;
		case 20:
			// 40x60-ft. trapezoid
		default:
			d = TWO_BY_TWO;
			break;
		}

		return d;
	}

	public boolean isRoomCircular() {
		return isRoomCircular;
	}

	public void setRoomCircular(boolean isRoomCircular) {
		this.isRoomCircular = isRoomCircular;
	}

}
