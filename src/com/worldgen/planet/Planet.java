package com.worldgen.planet;

public class Planet {
	Grid grid;
	Terrain terrain;
	Climate climate;

	/*
	 * 
	 */
	public void clear() {
		// TODO

	}

	/*
	 * 
	 */
	public static Planet build() {
		Planet planet = new Planet();

		// TODO - I'm sure I need to fix some stuff later
		planet.grid = Grid.build();
		planet.terrain = new Terrain();
		planet.climate = new Climate();

		return planet;
	}
}
