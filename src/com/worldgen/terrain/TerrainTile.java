package com.worldgen.terrain;

import com.worldgen.planet.*;

public class TerrainTile {

	Tile gridTile;
	float elevation;
	LandType type;

	Water water;

	/*
	 * CONSTRUCTORS
	 */
	public TerrainTile(Tile gridTile) {
		this.gridTile = gridTile;
		elevation = 0;
		type = LandType.LAND;
	}

	/*
	 * 
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

}
