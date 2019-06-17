package com.worldgen.view;

import com.worldgen.model.Planet;
import com.worldgen.model.Tile;

public class PlanetColor {

	float[][] colorTiles;

	/*
	 * COLOR FIELDS
	 */
	private float[] deepWater = new float[] { 0.0f, 0.0f, 0.25f };
	private float[] water = new float[] { 0.0f, 0.12f, 0.5f };
	private float[] shallow = new float[] { 0.0f, 0.4f, 0.6f };

	private float[][] land = new float[][] { { 0.0f, 0.4f, 0.0f }, { 0.0f, 0.7f, 0.0f }, { 1.0f, 1.0f, 0.0f },
			{ 1.0f, 0.5f, 0.0f }, { 0.7f, 0.0f, 0.0f }, { 0.1f, 0.1f, 0.1f } };
	private float[] limit = { -500, 0, 500, 1000, 1500, 2000, 2500 };

	/*
	 * COLOR METHODS
	 */
	private float[] color() {
		return new float[] { 0, 0, 0 };
	}

	private float[] color(float r, float g, float b) {
		return new float[] { r, g, b };
	}

	private float[] interpolateColor(float[] a, float[] b, double ratio) {
		return new float[] { //
				(float) (a[0] * (1.0 - ratio) + b[0] * ratio), //
				(float) (a[1] * (1.0 - ratio) + b[1] * ratio), //
				(float) (a[2] * (1.0 - ratio) + b[2] * ratio) //
		};
	}

	/*
	 * 
	 */
	public void colorTopography(Planet p) {
		Tile[] gTiles = p.getGrid().tiles;
		int length = gTiles.length;
		colorTiles = new float[length][];

		double seaLevel = p.getSeaLevel();

		for (int i = 0; i < length; ++i) {
			double elevation = gTiles[i].elevation - seaLevel;
			double ratio = 0.0;

			if (gTiles[i].isWater()) {
				// WATER
				if (elevation < -1000) {
					colorTiles[i] = deepWater;
				} else if (elevation < -500) {
					ratio = (elevation + 500) / -500;
					colorTiles[i] = interpolateColor(water, deepWater, ratio);
				} else {
					ratio = elevation / -500;
					colorTiles[i] = interpolateColor(shallow, water, ratio);
				}
			} else {
				// LAND
				colorTiles[i] = land[5];
				for (int j = 0; j < 5; ++j) {
					if (elevation <= limit[j + 1]) {
						ratio = Math.max(0.0, Math.min(1.0, elevation - limit[j] / (limit[j + 1] - limit[j])));
						colorTiles[i] = interpolateColor(land[j], land[j + 1], ratio);
					}
				}
			}
		}
		
		System.out.println("Coloring ran.");
	}

}
