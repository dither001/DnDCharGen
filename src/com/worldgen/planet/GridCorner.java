package com.worldgen.planet;

import com.jogamp.opengl.math.VectorUtil;

public class GridCorner {
	int id;
	float[] v;

	GridTile[] tiles;
	GridCorner[] corners;
	GridEdge[] edges;

	/*
	 * CONSTRUCTORS
	 */
	public GridCorner(int id) {
		this.id = id;

		v = new float[] { 0, 0, 0 };
		tiles = new GridTile[3];
		corners = new GridCorner[3];
		edges = new GridEdge[3];
	}

	/*
	 * 
	 */
	public void addCorner(GridTile[] t) {
		VectorUtil.addVec3(v, t[0].v, VectorUtil.addVec3(v, t[1].v, t[2].v));
		v = VectorUtil.normalizeVec3(v);

		for (int i = 0; i < 3; ++i) {
			t[i].corners[Grid.position(t[i], t[(i + 2) % 3])] = this;
			tiles[i] = t[i];
		}
	}

}
