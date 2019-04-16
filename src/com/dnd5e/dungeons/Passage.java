package com.dnd5e.dungeons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import com.dnd5e.definitions.dungeons.Cardinal;
import com.miscellaneous.util.Misc;

@SuppressWarnings("serial")
public class Passage extends Segment {

	protected boolean isDeadEnd;

	/*
	 * CONSTRUCTORS
	 */
	protected Passage() {
		super();
		setDeadEnd(false);
	}

	/*
	 * INSTANCE METHODS
	 */
	public Point nearestLocation() {
		Point point = null;

		if (cardinal.isSouth()) {
			point = new Point(x, y + height);

		} else if (cardinal.isEast()) {
			point = new Point(x + width, y);

		} else {
			point = new Point(getLocation());

		}

		return point;
	}

	public void paint(Graphics g) {
		if (isDeadEnd)
			g.setColor(Color.PINK);
		else
			g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);

		g.setColor(Color.BLACK);
		switch (cardinal) {
		case EAST:
		case WEST:
			g.drawLine(x, y, x + width, y);
			g.drawLine(x, y + height, x + width, y + height);
			break;
		case NORTH:
		case SOUTH:
			g.drawLine(x, y, x, y + height);
			g.drawLine(x + width, y, x + width, y + height);
			break;
		}

		if (isDeadEnd) {
			switch (cardinal) {
			case EAST:
				g.drawLine(x + width, y, x + width, y + height);
				break;
			case NORTH:
				g.drawLine(x, y, x + width, y);
				break;
			case SOUTH:
				g.drawLine(x, y + height, x + width, y + height);
				break;
			case WEST:
				g.drawLine(x, y, x, y + height);
				break;
			}
		}
	}

	/*
	 * STATIC METHODS
	 */
	public static Passage build(Passage passage) {
		return Passage.build(passage.getCardinal(), passage.nearestLocation(), passage.height, passage.width);
	}

	public static Passage build(Cardinal cardinal, Passage passage) {
		return Passage.build(cardinal, passage.nearestLocation(), passage.height, passage.width);
	}

	public static Passage build(Cardinal cardinal, Point location) {
		return build(cardinal, location, 30, 10);
	}

	public static Passage build(Cardinal cardinal, Point location, int length) {
		return build(cardinal, location, length, 10);
	}

	public static Passage build(Cardinal cardinal, Point location, int length, int width) {
		Passage passage = new Passage();
		Dimension dimension = new Dimension(width, length);

		passage.setCardinal(cardinal);
		passage.setLocation(location);

		if (Cardinal.isNorthOrSouth(cardinal)) {
			passage.setSize(dimension);

		} else {
			passage.setSize(Misc.transpose(dimension));

		}

		return passage;
	}

	public boolean isDeadEnd() {
		return isDeadEnd;
	}

	public void setDeadEnd(boolean isDeadEnd) {
		this.isDeadEnd = isDeadEnd;
	}
}
