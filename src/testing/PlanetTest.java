package testing;

import org.junit.Test;

import com.worldgen.planet.Tile;
import com.worldgen.planet.Corner;
import com.worldgen.planet.Planet;

public class PlanetTest {

	@Test
	public void buildPlanet() {

	}

	@Test
	public void testElevation() {
		Planet p;
		int counter = 0;
		int longestRiver = 0;

		try {
			p = Planet.build(6);

			for (Tile el : p.grid.tiles) {
				if (el.elevation > p.terrain.getSeaLevel()) {
					// System.out.printf("%s%n", el.getElevation());
					++counter;
				}
			}

			for (Corner el : p.grid.corners) {
				if (el.distanceToSea > longestRiver)
					longestRiver = el.distanceToSea;
			}

			System.out.println("Sea Level: " + p.terrain.getSeaLevel());
			System.out.println("Tiles: " + p.grid.tiles.length);
			System.out.println("Longest River: " + longestRiver);

		} catch (Exception e) {
			// e.printStackTrace();

		}

		System.out.println("Tiles above sea Level: " + counter);
	}

}
