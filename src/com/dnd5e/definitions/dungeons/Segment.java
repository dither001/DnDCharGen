package com.dnd5e.definitions.dungeons;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class Segment extends Rectangle {

	/*
	 * INSTANCE METHODS
	 */
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, height, width);

		g.setColor(Color.BLACK);
		g.drawRect(x, y, height, width);
	}
	
	public String toString() {
		return getClass().getSimpleName();
	}
}
