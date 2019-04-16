package com.dnd5e.definitions.dungeons;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

public class Default {
	public static boolean SHOW_BOUNDARY;
	public static boolean SHOW_GRID;

	public static final double AREA_TO_MAP;
	public static final Rectangle BOUNDARY;
	public static final int BOUNDARY_AREA;
	public static final Dimension DIMENSIONS;
	public static final int INSET;
	public static final int WALL_LENGTH;

	//
	public static final Dimension DOOR_SIZE;
	public static final Point MIDPOINT;

	static {
		// OPTIONS
		SHOW_BOUNDARY = true;
		SHOW_GRID = true;

		//
		AREA_TO_MAP = 66.67;
		DIMENSIONS = new Dimension(440, 340);
		INSET = 20;
		WALL_LENGTH = 10;

		// DERIVED FIELDS
		Point bTopLeft = new Point(Default.INSET, Default.INSET + 10);
		int bWidth = Default.DIMENSIONS.width - 2 * Default.INSET;
		int bHeight = Default.DIMENSIONS.height - 2 * Default.INSET;
		Dimension bDimensions = new Dimension(bWidth, bHeight);
		BOUNDARY = new Rectangle(bTopLeft, bDimensions);
		BOUNDARY_AREA = bWidth * bHeight;

		MIDPOINT = new Point(DIMENSIONS.width / 2, DIMENSIONS.height / 2);

		int width = (int) (Default.WALL_LENGTH * 0.6);
		int height = (int) (Default.WALL_LENGTH * 0.3);
		DOOR_SIZE = new Dimension(width, height);

	}

}
