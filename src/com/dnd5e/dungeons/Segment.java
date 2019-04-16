package com.dnd5e.dungeons;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import com.dnd5e.definitions.dungeons.Cardinal;
import com.dnd5e.definitions.dungeons.Default;

@SuppressWarnings("serial")
public abstract class Segment extends Rectangle {

	public Cardinal cardinal;
	public boolean explored;

	/*
	 * CONSTRUCTORS
	 */
	public Segment() {
		this.explored = false;
	}

	/*
	 * INSTANCE METHODS
	 */
	public Cardinal getCardinal() {
		return cardinal;
	}

	public void setCardinal(Cardinal cardinal) {
		this.cardinal = cardinal;
	}

	public boolean getExplored() {
		return explored;
	}

	public void setExplored(boolean explored) {
		this.explored = explored;
	}

	public int area() {
		return height * width;
	}

	public Point nearestLocation() {
		return new Point(getLocation());
	}

	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);

		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);
	}

	public int numberOfSegments() {
		return (perimeter() / Default.WALL_LENGTH);
	}

	public int perimeter() {
		return (2 * height + 2 * width);
	}

	public void shift(Point point) {
		// Location remains the same if "south" or "east" of point
		if (cardinal.isNorth()) {
			this.translate(0, -height);

		} else if (cardinal.isWest()) {
			this.translate(-width, 0);

		}
	}

	public String toString() {
		return getClass().getSimpleName();
	}

}
