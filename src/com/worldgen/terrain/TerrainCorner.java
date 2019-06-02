package com.worldgen.terrain;

import com.worldgen.planet.*;

public class TerrainCorner {
	
	Corner gridCorner;
	float elevation;
	
	public TerrainCorner(Corner gridCorner) {
		this.gridCorner = gridCorner;
	}

	public float getElevation() {
		return elevation;
	}

	public void setElevation(float elevation) {
		this.elevation = elevation;
	}

}
