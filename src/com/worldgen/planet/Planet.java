package com.worldgen.planet;

import com.worldgen.climate.Climate;
import com.worldgen.terrain.Terrain;

public class Planet {
	public Grid grid;
	public Terrain terrain;
	public Climate climate;

	/*
	 * 
	 */
	public void clear() {
		// TODO

	}

	/*
	 * 
	 */
	public static Planet build(int size) throws Exception {
		if (size < 9) {
			Planet planet = new Planet();

			planet.grid = Grid.build(size);
			planet.terrain = Terrain.build(planet.grid);
			planet.climate = new Climate();

			return planet;
			
		} 
		
		throw new Exception("Please enter smaller size.");
	}
	
	
}
