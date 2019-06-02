package com.worldgen.planet;

import com.worldgen.terrain.LandType;
import com.worldgen.terrain.TerrainWater;

public class Tile implements UsesTerrain {
	public int id;
	int edgeCount;

	public Tile[] tiles;
	Corner[] corners;
	Edge[] edges;

	public float[] v;

	// terrain fields
	public float elevation;
	public LandType type;

	public TerrainWater water;

	/*
	 * CONSTRUCTORS
	 */
	public Tile(int id, int edgeCount) {
		this.id = id;
		this.edgeCount = edgeCount;

		v = new float[] { 0, 0, 0 };
		tiles = new Tile[edgeCount];
		corners = new Corner[edgeCount];
		edges = new Edge[edgeCount];

		// terrain fields
		elevation = 0;
		type = LandType.LAND;
		water = new TerrainWater();
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

	/*
	 * TERRAIN METHODS
	 */
	public boolean isLand() {
		return type.equals(LandType.LAND);
	}

	public boolean isWater() {
		return type.equals(LandType.WATER);
	}

	public boolean hasCoast() {
		return type.equals(LandType.COAST);
	}

	public float getElevation() {
		return elevation;
	}

	public float getWaterDepth() {
		return water.depth;
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
