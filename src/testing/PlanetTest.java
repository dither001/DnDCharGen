package testing;

import org.junit.Test;

import com.worldgen.math.Sphere;
import com.worldgen.model.Corner;
import com.worldgen.model.Planet;
import com.worldgen.model.Tile;
import com.worldgen.view.PlanetColor;

public class PlanetTest {

	@Test
	public void testSphere() {
		Sphere sphere = new Sphere();
	}

	@Test
	public void testElevation() {
		Planet p;
		
		int tileCount = 0;
		int counter = 0;
		int longestRiver = 0;

		double windSpeed = 0.0;

		float humidity = 0.0f;
		float precipitation = 0.0f;

		try {
			/*
			 * PLANET GENERATION
			 */
			p = Planet.build(6);
			tileCount = p.getGrid().tiles.length;

			for (Tile el : p.getGrid().tiles) {
				if (el.elevation > p.getSeaLevel()) {
					// System.out.printf("%s%n", el.getElevation());
					++counter;
				}

				windSpeed += el.wind.speed;

				humidity = el.humidity > 0 ? el.humidity : humidity;
				precipitation = el.precipitation > 0 ? el.precipitation : precipitation;
			}

			for (Corner el : p.getGrid().corners) {
				if (el.distanceToSea > longestRiver)
					longestRiver = el.distanceToSea;
			}

			System.out.printf("Sea Level: %.2f %n", p.getSeaLevel());
			System.out.println("Tiles: " + tileCount);
			System.out.println("Longest River: " + longestRiver);

			System.out.printf("Average wind speed: %.2f %n", 1.0 * windSpeed / tileCount);
			System.out.printf("Average humidity: %e %n", 1.0 * humidity / tileCount);
			System.out.printf("Average rainfall: %e %n", 1.0 * precipitation / tileCount);
			System.out.println("Tiles above sea Level: " + counter);

			/*
			 * COLOR
			 */
			PlanetColor.colorTopography(p);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
