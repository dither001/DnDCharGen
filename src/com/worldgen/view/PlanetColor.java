package com.worldgen.view;

import com.worldgen.model.Planet;
import com.worldgen.model.Tile;

public abstract class PlanetColor {

	public static float[][] colorTiles;

	/*
	 * COLOR FIELDS
	 */
	private static float[] deepWater = new float[] { 0.0f, 0.0f, 0.25f };
	private static float[] water = new float[] { 0.0f, 0.12f, 0.5f };
	private static float[] shallow = new float[] { 0.0f, 0.4f, 0.6f };

	private static float[][] land = new float[][] { { 0.0f, 0.4f, 0.0f }, { 0.0f, 0.7f, 0.0f }, { 1.0f, 1.0f, 0.0f },
			{ 1.0f, 0.5f, 0.0f }, { 0.7f, 0.0f, 0.0f }, { 0.1f, 0.1f, 0.1f } };
	private static float[] limit = { -500, 0, 500, 1000, 1500, 2000, 2500 };

	/*
	 * COLOR METHODS
	 */
	private static float[] color() {
		return new float[] { 0, 0, 0 };
	}

	private static float[] color(float r, float g, float b) {
		return new float[] { r, g, b };
	}

	private static float[] interpolateColor(float[] a, float[] b, double ratio) {
		return new float[] { //
				(float) (a[0] * (1.0 - ratio) + b[0] * ratio), //
				(float) (a[1] * (1.0 - ratio) + b[1] * ratio), //
				(float) (a[2] * (1.0 - ratio) + b[2] * ratio) //
		};
	}

	/*
	 * 
	 */
	public static void colorTopography(Planet p) {
		Tile[] gTiles = p.getGrid().tiles;
		int length = gTiles.length;
		colorTiles = new float[length][];

		double seaLevel = p.getSeaLevel();

		int dw = 0, ow = 0, sw = 0, ld = 0;

		for (int i = 0; i < length; ++i) {
			double elevation = gTiles[i].elevation - seaLevel;
			double ratio = 0.0;

			if (gTiles[i].isWater()) {
				// WATER
				if (elevation < -1000) {
					colorTiles[i] = deepWater;
					++dw;
				} else if (elevation < -500) {
					ratio = (elevation + 500) / -500;
					colorTiles[i] = interpolateColor(water, deepWater, ratio);
					++ow;
				} else {
					ratio = elevation / -500;
					colorTiles[i] = interpolateColor(shallow, water, ratio);
					++sw;
				}
			} else {
				// LAND
				colorTiles[i] = land[5];
				for (int j = 0; j < 5; ++j) {
					if (elevation <= limit[j + 1]) {
						ratio = Math.max(0.0, Math.min(1.0, elevation - limit[j] / (limit[j + 1] - limit[j])));
						colorTiles[i] = interpolateColor(land[j], land[j + 1], ratio);
						break;
					}
				}

				++ld;
			}
		}

		int water = dw + ow + sw;
		System.out.printf("Land: %d || Water: %d || Total: %d%n", ld, water, ld + water);
		System.out.printf("Deep: %d || Open: %d || Shallow: %d%n", dw, ow, sw);

	}

}
