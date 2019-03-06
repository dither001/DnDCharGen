package com.worldgen.planet;

public class GridTile {
	int id;
	int edgeCount;

	GridTile[] tiles;
	GridCorner[] corners;
	GridEdge[] edges;

	float[] v;

	/*
	 * CONSTRUCTORS
	 */
	public GridTile(int id, int edgeCount) {
		this.id = id;
		this.edgeCount = edgeCount;

		v = new float[] { 0, 0, 0 };
		tiles = new GridTile[edgeCount];
		corners = new GridCorner[edgeCount];
		edges = new GridEdge[edgeCount];
	}

	/*
	 * 
	 */
	private String vToString() {
		String s = "(";

		s += v[0] + ", ";
		s += v[1] + ", ";
		s += v[2] + ")";

		return s;
	}

	public String toString() {
		String s = "";

		// for (GridTile el : tiles)
		// s += el.id + ", ";

		// for (GridCorner el : corners)
		// s += el.id + ", ";

		// for (GridEdge el : edges)
		// s += el.toString() + ", ";

		return "" + id;
	}
}
