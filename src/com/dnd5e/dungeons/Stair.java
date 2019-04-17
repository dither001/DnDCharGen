package com.dnd5e.dungeons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import com.dnd5e.definitions.dungeons.*;

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

}
