package com.worldgen.terrain;

public class TerrainTile {

	float elevation;
	LandType type;

	TerrainWater water;
	
	/*
	 * CONSTRUCTORS
	 */
	public TerrainTile() {
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
