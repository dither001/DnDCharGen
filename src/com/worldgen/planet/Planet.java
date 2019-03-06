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
		try {
			planet.grid = Grid.build(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		planet.terrain = new Terrain();
		planet.climate = new Climate();

		return planet;
	}
}
