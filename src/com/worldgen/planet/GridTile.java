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

		this.tiles = new GridTile[edgeCount];
		this.corners = new GridCorner[edgeCount];
		this.edges = new GridEdge[edgeCount];
	}

}
