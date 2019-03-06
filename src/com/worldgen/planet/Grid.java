package com.worldgen.planet;

import java.util.ArrayList;

public class Grid {
	private static final float x = -0.525731112119133606f;
	private static final float z = -0.850650808352039932f;

	private static final float[][] icos_tiles = { //
			{ -x, 0, z }, { x, 0, z }, { -x, 0, -z }, //
			{ x, 0, -z }, { 0, z, x }, { 0, z, -x }, //
			{ 0, -z, x }, { 0, -z, -x }, { z, x, 0 }, //
			{ -z, x, 0 }, { z, -x, 0 }, { -z, -x, 0 } //
	};

	private static final int[][] icos_tiles_n = { //
			{ 9, 4, 1, 6, 11 }, { 4, 8, 10, 6, 0 }, { 11, 7, 3, 5, 9 }, //
			{ 2, 7, 10, 8, 5 }, { 9, 5, 8, 1, 0 }, { 2, 3, 8, 4, 9 }, //
			{ 0, 1, 10, 7, 11 }, { 11, 6, 10, 3, 2 }, { 5, 3, 10, 1, 4 }, //
			{ 2, 5, 4, 0, 11 }, { 3, 7, 6, 1, 8 }, { 7, 2, 9, 0, 6 } //
	};

	/*
	 * 
	 */
	ArrayList<GridTile> tiles;
	ArrayList<GridCorner> corners;
	ArrayList<GridEdge> edges;

	/*
	 * INSTANCE METHODS
	 */
	public GridTile getTile(int index) {
		return tiles.get(index);
	}

	public GridCorner getCorner(int index) {
		return corners.get(index);
	}

	public GridEdge getEdge(int index) {
		return edges.get(index);
	}

	public int tileSize() {
		return tiles.size();
	}

	public int cornerSize() {
		return corners.size();
	}

	public int edgeSize() {
		return edges.size();
	}

	/*
	 * STATIC METHODS
	 */
	public static Grid build() {
		// TODO
		return new Grid();
	}

	private static Grid sizeZeroGrid() {
		Grid grid = new Grid();

		/*
		 * The following 15 lines were formerly in Grid constructor.
		 */
		int tileSize = tileCount(0);
		int cornerSize = cornerCount(0);
		int edgeSize = edgeCount(0);

		grid.tiles = new ArrayList<GridTile>(tileSize);
		for (int i = 0; i < tileSize; ++i)
			grid.tiles.add(new GridTile(i, i < 12 ? 5 : 6));

		grid.corners = new ArrayList<GridCorner>(cornerSize);
		for (int i = 0; i < cornerSize; ++i)
			grid.corners.add(new GridCorner(i));

		grid.edges = new ArrayList<GridEdge>(edgeSize);
		for (int i = 0; i < edgeSize; ++i)
			grid.edges.add(new GridEdge(i));

		/*
		 * 
		 */
		for (GridTile el : grid.tiles) {
			el.v = icos_tiles[el.id];
		}

		return grid;
	}

	public static int tileCount(int size) {
		// TODO - untested
		return (int) (10 * Math.pow(3, size) + 2);
	}

	public static int cornerCount(int size) {
		// TODO - untested
		return (int) (20 * Math.pow(3, size));
	}

	public static int edgeCount(int size) {
		// TODO - untested
		return (int) (30 * Math.pow(3, size));
	}

}
