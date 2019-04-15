package com.dnd5e.definitions.dungeons;

import java.awt.Dimension;
import java.awt.Point;

import com.miscellaneous.util.Dice;

@SuppressWarnings("serial")
public class Chamber extends Segment {
	private static final Dimension TWO_BY_TWO;
	private static final Dimension THREE_BY_THREE;
	private static final Dimension FOUR_BY_FOUR;
	//
	private static final Dimension TWO_BY_THREE;
	private static final Dimension THREE_BY_FOUR;
	private static final Dimension FOUR_BY_FIVE;
	private static final Dimension FIVE_BY_EIGHT;

	static {
		TWO_BY_TWO = new Dimension(2 * Default.WALL_LENGTH, 2 * Default.WALL_LENGTH);
		THREE_BY_THREE = new Dimension(3 * Default.WALL_LENGTH, 3 * Default.WALL_LENGTH);
		FOUR_BY_FOUR = new Dimension(4 * Default.WALL_LENGTH, 4 * Default.WALL_LENGTH);
		TWO_BY_THREE = new Dimension(2 * Default.WALL_LENGTH, 3 * Default.WALL_LENGTH);
		THREE_BY_FOUR = new Dimension(3 * Default.WALL_LENGTH, 4 * Default.WALL_LENGTH);
		FOUR_BY_FIVE = new Dimension(4 * Default.WALL_LENGTH, 5 * Default.WALL_LENGTH);
		FIVE_BY_EIGHT = new Dimension(5 * Default.WALL_LENGTH, 8 * Default.WALL_LENGTH);

	}

	/*
	 * INSTANCE METHODS
	 */
	private boolean isLargeRoom;

	/*
	 * INSTANCE METHODS
	 */
	public int area() {
		return height * width;
	}

	public int perimeter() {
		return (2 * height + 2 * width);
	}

	public boolean isLargeRoom() {
		return isLargeRoom;
	}

	public int numberOfSegments() {
		return (perimeter() / Default.WALL_LENGTH);
	}

	/*
	 * STATIC METHODS
	 */
	public static Chamber build(Point location) {
		Chamber chamber = new Chamber();

		chamber.setLocation(new Point(location));
		chamber.setSize(randomDimension());

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
		case 17:
			// 50-ft. circle
		case 18:
			// 40-ft. octagon
		case 19:
			// 60-ft. octagon
		case 20:
			// 40x60-ft. trapezoid
		default:
			d = TWO_BY_TWO;
			break;
		}

		return d;
	}
}
