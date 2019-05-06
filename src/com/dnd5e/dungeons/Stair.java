package com.dnd5e.dungeons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import com.dnd5e.definitions.dungeons.*;
import com.miscellaneous.util.Default;
import com.miscellaneous.util.Dice;

@SuppressWarnings("serial")
public class Stair extends Passage {

	private boolean goingUp;
	private int floors;

	/*
	 * CONSTRUCTORS
	 */
	private Stair() {
		super();
		this.setGoingUp(false);
		this.setFloors(1);
	}

	/*
	 * INSTANCE METHODS
	 */
	public int getFloors() {
		return floors;
	}

	public void setFloors(int floors) {
		this.floors = floors;
	}

	public boolean isGoingDown() {
		return goingUp != true;
	}

	public boolean isGoingUp() {
		return goingUp;
	}

	public void setGoingUp(boolean goingUp) {
		this.goingUp = goingUp;
	}

	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);

		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);

		int[] xpts = new int[] { x, (2 * x + width) / 2, x + width }, ypts;
		if (goingUp)
			ypts = new int[] { y + height, y, y + height };
		else
			ypts = new int[] { y, y + height, y };

		g.fillPolygon(xpts, ypts, 3);
	}

	/*
	 * STATIC METHODS
	 */
	public static Stair build(Cardinal cardinal, Point location) {
		Stair stair = new Stair();

		stair.setSize(new Dimension(Default.WALL_LENGTH, Default.WALL_LENGTH));
		stair.setCardinal(cardinal);
		stair.setLocation(location);

		return stair;
	}

	public static Stair random(Cardinal c, Point p) {
		Stair s = build(c, p);

		int dice = Dice.roll(10);
		if (dice > 7) {
			// GOING UP
			s.setGoingUp(true);

		} else {
			// GOING DOWN
			dice = Dice.roll(10);
			s.floors = (dice == 10) ? 3 : (dice == 9) ? 2 : 1;

		}

		return s;
	}

}
