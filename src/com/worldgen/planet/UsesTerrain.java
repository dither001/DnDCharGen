package com.worldgen.planet;

import com.worldgen.terrain.LandType;

public interface UsesTerrain {

	public LandType getLandType();

	public void setLandType(LandType type);

	/*
	 * DEFAULT METHODS
	 */
	public default boolean isCoast() {
		return getLandType().isCoast();
	}

	public default boolean isLand() {
		return getLandType().isLand();
	}

	public default boolean isWater() {
		return getLandType().isWater();
	}

}
