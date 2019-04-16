package com.dnd5e.dungeons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

@SuppressWarnings("serial")
public class Branch extends Passage {

	private boolean isLeftTurn;
	private boolean branchDeadEnds;

	/*
	 * CONSTRUCTORS
	 */
	private Branch() {
		super();

	}

	/*
	 * INSTANCE METHODS
	 */
	public boolean isBranchDeadEnds() {
		return branchDeadEnds;
	}

	public void setBranchDeadEnds(boolean branchDeadEnds) {
		this.branchDeadEnds = branchDeadEnds;
	}

	public boolean isLeftTurn() {
		return isLeftTurn;
	}

	public void setLeftTurn(boolean isLeftTurn) {
		this.isLeftTurn = isLeftTurn;
	}

	public Point branchTo() {
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

	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);

		// switch (cardinal) {
		// case NORTH:
		// g.drawLine(x, y, x, y + height);
		// g.drawLine(x + width, y, x + width, y + height);
		// g.drawLine(x, y, x + width, y);
		// break;
		// case EAST:
		// g.drawLine(x, y, x + width, y);
		// g.drawLine(x, y + height, x + width, y + height);
		// g.drawLine(x + width, y, x + width, y + height);
		// break;
		// case SOUTH:
		// g.drawLine(x, y, x, y + height);
		// g.drawLine(x + width, y, x + width, y + height);
		// g.drawLine(x, y + height, x + width, y + height);
		// break;
		// case WEST:
		// g.drawLine(x, y, x + width, y);
		// g.drawLine(x, y + height, x + width, y + height);
		// g.drawLine(x, y, x, y + height);
		// break;
		// }

		// standard branch
		g.setColor(Color.BLACK);
		switch (cardinal) {
		case NORTH:
			if (isDeadEnd)
				g.drawLine(x, y, x + width, y);

			if (isLeftTurn)
				g.drawLine(x + width, y, x + width, y + height);
			else
				g.drawLine(x, y, x, y + height);

			break;
		case EAST:
			if (isDeadEnd)
				g.drawLine(x + width, y, x + width, y + height);

			if (isLeftTurn)
				g.drawLine(x, y + height, x + width, y + height);
			else
				g.drawLine(x, y, x + width, y);

			break;
		case SOUTH:
			if (isDeadEnd)
				g.drawLine(x, y + height, x + width, y + height);

			if (isLeftTurn)
				g.drawLine(x, y, x, y + height);
			else
				g.drawLine(x + width, y, x + width, y + height);

			break;
		case WEST:
			if (isDeadEnd)
				g.drawLine(x, y, x, y + height);

			if (isLeftTurn)
				g.drawLine(x, y, x + width, y);
			else
				g.drawLine(x, y + height, x + width, y + height);

			break;
		}
	}

	/*
	 * STATIC METHODS
	 */
	public static Branch build(boolean isLeftTurn, Passage passage) {
		Branch branch = new Branch();

		branch.setLeftTurn(isLeftTurn);
		branch.setCardinal(passage.cardinal);
		branch.setLocation(passage.nearestLocation());

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
		branch.setSize(d);

		return branch;
	}
}
