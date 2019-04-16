package com.dnd5e.dungeons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

@SuppressWarnings("serial")
public class Bend extends Passage {

	private boolean isLeftTurn;

	/*
	 * CONSTRUCTORS
	 */
	private Bend() {
		super();

	}

	/*
	 * INSTANCE METHODS
	 */
	public Point nearestLocation() {
		Point point = null;

		switch (cardinal) {
		case NORTH:
			point = isLeftTurn ? new Point(x, y) : new Point(x + width, y);
			break;
		case EAST:
			point = isLeftTurn ? new Point(x, y) : new Point(x, y + height);
			break;
		case SOUTH:
			point = isLeftTurn ? new Point(x + width, y) : new Point(x, y);
			break;
		case WEST:
			point = isLeftTurn ? new Point(x, y + height) : new Point(x, y);
			break;
		}

		return point;
	}

	public boolean isLeftTurn() {
		return isLeftTurn;
	}

	public void setLeftTurn(boolean isLeftTurn) {
		this.isLeftTurn = isLeftTurn;
	}

	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);

		g.setColor(Color.BLACK);
		if (isDeadEnd) {
			switch (cardinal) {
			case NORTH:
				g.drawLine(x, y, x, y + height);
				g.drawLine(x + width, y, x + width, y + height);
				g.drawLine(x, y, x + width, y);
				break;
			case EAST:
				g.drawLine(x, y, x + width, y);
				g.drawLine(x, y + height, x + width, y + height);
				g.drawLine(x + width, y, x + width, y + height);
				break;
			case SOUTH:
				g.drawLine(x, y, x, y + height);
				g.drawLine(x + width, y, x + width, y + height);
				g.drawLine(x, y + height, x + width, y + height);
				break;
			case WEST:
				g.drawLine(x, y, x + width, y);
				g.drawLine(x, y + height, x + width, y + height);
				g.drawLine(x, y, x, y + height);
				break;
			}
		} else {
			// standard bend
			switch (cardinal) {
			case NORTH:
				g.drawLine(x, y, x + width, y);

				if (isLeftTurn)
					g.drawLine(x + width, y, x + width, y + height);
				else
					g.drawLine(x, y, x, y + height);

				break;
			case EAST:
				g.drawLine(x + width, y, x + width, y + height);

				if (isLeftTurn)
					g.drawLine(x, y + height, x + width, y + height);
				else
					g.drawLine(x, y, x + width, y);

				break;
			case SOUTH:
				g.drawLine(x, y + height, x + width, y + height);

				if (isLeftTurn)
					g.drawLine(x, y, x, y + height);
				else
					g.drawLine(x + width, y, x + width, y + height);

				break;
			case WEST:
				g.drawLine(x, y, x, y + height);

				if (isLeftTurn)
					g.drawLine(x, y, x + width, y);
				else
					g.drawLine(x, y + height, x + width, y + height);

				break;
			}

		}
	}

	/*
	 * STATIC METHODS
	 */
	public static Bend build(boolean isLeftTurn, Passage passage) {
		Bend bend = new Bend();

		bend.setLeftTurn(isLeftTurn);
		bend.setCardinal(passage.cardinal);
		bend.setLocation(passage.nearestLocation());

		Dimension d = null;
		switch (passage.getCardinal()) {
		case EAST:
		case WEST:
			d = new Dimension(passage.height, passage.height);
			break;
		case NORTH:
		case SOUTH:
			d = new Dimension(passage.width, passage.width);
			break;
		}

		bend.setSize(d);

		return bend;
	}
}
