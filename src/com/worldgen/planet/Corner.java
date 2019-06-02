package com.worldgen.planet;

import com.jogamp.opengl.math.VectorUtil;
import com.worldgen.terrain.LandType;

public class Corner implements UsesTerrain {
	int id;
	public float[] v;

	public Tile[] tiles;
	public Corner[] corners;
	Edge[] edges;

	// terrain fields
	public float elevation;
	public LandType type;

	public int riverDirection;
	public int distanceToSea;

	/*
	 * CONSTRUCTORS
	 */
	public Corner(int id) {
		this.id = id;

		v = new float[] { 0, 0, 0 };
		tiles = new Tile[3];
		corners = new Corner[3];
		edges = new Edge[3];

		// terrain fields
		type = LandType.LAND;

		elevation = 0;
		riverDirection = -1;
		distanceToSea = -1;
	}

	/*
	 * 
	 */
	public void addCorner(Tile[] t) {
		VectorUtil.addVec3(v, t[0].v, VectorUtil.addVec3(v, t[1].v, t[2].v));
		v = VectorUtil.normalizeVec3(v);

		for (int i = 0; i < 3; ++i) {
			t[i].corners[Grid.position(t[i], t[(i + 2) % 3])] = this;
			tiles[i] = t[i];
		}
	}

	/*
	 * TERRAIN METHODS
	 */
	public float getElevation() {
		return elevation;
	}

	public void setElevation(float elevation) {
		this.elevation = elevation;
	}

	@Override
	public LandType getLandType() {
		return type;
	}

	@Override
	public void setLandType(LandType type) {
		this.type = type;
	}

}
