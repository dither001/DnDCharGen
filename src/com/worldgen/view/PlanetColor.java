package com.worldgen.view;

import com.worldgen.model.Climate;
import com.worldgen.model.Planet;
import com.worldgen.model.Season;
import com.worldgen.model.Tile;

public abstract class PlanetColor {

	public static float[][] topoColors;
	public static float[][] vegeColors;
	public static float[][] tempColors;
	public static float[][] aridColors;
	public static float[][] humidColors;
	public static float[][] rainColors;

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
	 * TOPOGRAPHY
	 */
	public static void colorTopography(Planet p) {
		float[] deepWater = new float[] { 0.0f, 0.0f, 0.25f };
		float[] water = new float[] { 0.0f, 0.12f, 0.5f };
		float[] shallow = new float[] { 0.0f, 0.4f, 0.6f };

		float[][] land = new float[][] { { 0.0f, 0.4f, 0.0f }, { 0.0f, 0.7f, 0.0f }, { 1.0f, 1.0f, 0.0f },
				{ 1.0f, 0.5f, 0.0f }, { 0.7f, 0.0f, 0.0f }, { 0.1f, 0.1f, 0.1f } };
		float[] limit = { -500, 0, 500, 1000, 1500, 2000, 2500 };

		//
		Tile[] gTiles = p.getGrid().tiles;
		int length = gTiles.length;
		double seaLevel = p.getSeaLevel();

		topoColors = new float[length][];
		for (int i = 0; i < length; ++i) {
			double elevation = gTiles[i].elevation - seaLevel;
			double ratio = 0.0;

			if (gTiles[i].isWater()) {
				// WATER
				if (elevation < -1000) {
					topoColors[i] = deepWater;
				} else if (elevation < -500) {
					ratio = (elevation + 500) / -500;
					topoColors[i] = interpolateColor(water, deepWater, ratio);
				} else {
					ratio = elevation / -500;
					topoColors[i] = interpolateColor(shallow, water, ratio);
				}
			} else {
				// LAND
				topoColors[i] = land[5];
				for (int j = 0; j < 5; ++j) {
					if (elevation <= limit[j + 1]) {
						ratio = Math.max(0.0, Math.min(1.0, elevation - limit[j] / (limit[j + 1] - limit[j])));
						topoColors[i] = interpolateColor(land[j], land[j + 1], ratio);
						break;
					}
				}
			}
		}
	}

	/*
	 * VEGETATION
	 */
	public static void colorVegetation(Season s, Planet p) {
		float[] deepWater = new float[] { 0.0f, 0.0f, 0.25f };
		float[] shallow = new float[] { 0.0f, 0.4f, 0.6f };
		float[] snow = new float[] { 1.0f, 1.0f, 1.0f };
		float[] lowland = new float[] { 0.95f, 0.81f, 0.53f };
		float[] highland = new float[] { 0.1f, 0.1f, 0.1f };
		float[] vegetation = new float[] { 0.176f, 0.32f, 0.05f };

		Tile[] gTiles = p.getGrid().tiles;
		int length = gTiles.length;

		vegeColors = new float[length][];
		for (int i = 0; i < length; ++i) {
			double ratio = 0.0;

			if (gTiles[i].isWater()) {
				// WATER
				ratio = Math.min(1, gTiles[i].getWaterDepth() / 400);
				vegeColors[i] = interpolateColor(shallow, deepWater, ratio);

			} else {
				if (s.getTemperature(i) <= Climate.freezingPoint()) {
					vegeColors[i] = snow;

				} else {
					ratio = Math.min(1, (gTiles[i].elevation - p.getSeaLevel()) / 2500);
					float[] ground = interpolateColor(lowland, highland, ratio);
					ratio = Math.min(1.0f, s.aridity(i) / 1.5f);
					vegeColors[i] = interpolateColor(vegetation, ground, ratio);
				}
			}
		}
	}

	/*
	 * TEMPERATURE
	 */
	public static void colorTemperature(Season s, Planet p) {
		float[][] colors = new float[][] { //
				{ 1.0f, 1.0f, 1.0f }, //
				{ 0.7f, 0f, 0.5f }, //
				{ 0f, 0f, 0.5f }, //
				{ 0f, 0f, 1.0f }, //
				{ 0f, 1.0f, 1 }, //
				{ 1.0f, 1.0f, 0 }, //
				{ 1.0f, 0.1f, 0 }, //
				{ 0.45f, 0f, 0 } //
		};

		float[] limit = new float[] { -50, -35, -20, -10, 0, 10, 20, 30 };

		//
		Tile[] gTiles = p.getGrid().tiles;
		int length = gTiles.length;

		tempColors = new float[length][];
		for (int i = 0; i < length; ++i) {
			float temp = s.getTemperature(i) - Climate.freezingPoint();
			if (temp <= limit[0]) {
				tempColors[i] = colors[0];
			} else if (temp >= limit[7]) {
				tempColors[i] = colors[7];
			} else {
				for (int j = 0; j < 7; ++j) {
					if (temp >= limit[j] && temp < limit[j + 1]) {
						double ratio = (temp - limit[j]) / (limit[j + 1] - limit[j]);
						tempColors[i] = interpolateColor(colors[j], colors[j + 1], ratio);
						break;
					}
				}
			}
		}

	}

	/*
	 * ARIDITY
	 */
	public static void colorAridity(Season s, Planet p) {
		float[] water = new float[] { 1, 1, 1 };
		float[][] colors = new float[][] { { 1, 0, 0 }, { 1, 1, 0 }, { 0, 1, 0 }, { 0, 0.5f, 0 } };
		float[] limit = new float[] { 2, 1, 0.5f, 0 };

		//
		Tile[] gTiles = p.getGrid().tiles;
		int length = gTiles.length;

		aridColors = new float[length][];
		for (int i = 0; i < length; ++i) {

			if (gTiles[i].isWater()) {
				aridColors[i] = water;
			} else {
				float aridity = s.aridity(i);
				aridColors[i] = colors[3];
				for (int j = 1; j < 4; ++j) {
					if (aridity > limit[j]) {
						float ratio = Math.min(1, (aridity - limit[j]) / (limit[j - 1] - limit[j]));
						aridColors[i] = interpolateColor(colors[j], colors[j - 1], ratio);
						break;
					}
				}
			}
		}
	}

	/*
	 * HUMIDITY
	 */
	public static void colorHumidity(Season s, Planet p) {
		float[] water = new float[] { 1, 1, 1 };
		float[] dryland = new float[] { 1, 1, 0.5f };
		float[] midland = new float[] { 1, 1, 0 };
		float[] humid = new float[] { 0, 0.7f, 0 };

		//
		Tile[] gTiles = p.getGrid().tiles;
		int length = gTiles.length;

		humidColors = new float[length][];
		for (int i = 0; i < length; ++i) {
			if (gTiles[i].isWater()) {
				humidColors[i] = water;
			} else {
				double humidity = s.getHumidity(i) / Climate.saturationHumidity(s.getTemperature(i));
				double ratio = 0.0;
				if (humidity < 0.5) {
					ratio = humidity / 0.5;
					humidColors[i] = interpolateColor(dryland, midland, ratio);
				} else {
					ratio = (humidity - 0.5) / 0.5;
					humidColors[i] = interpolateColor(midland, humid, ratio);
				}
			}
		}
	}

	/*
	 * PRECIPITATION
	 */
	public static void colorPrecipitation(Season s, Planet p) {
		float[] water = new float[] { 1, 1, 1 };
		float[] dry = new float[] { 1, 1, 0.5f };
		float[] medium = new float[] { 0, 1, 0 };
		float[] wet = new float[] { 0, 0, 1 };

		//
		Tile[] gTiles = p.getGrid().tiles;
		int length = gTiles.length;

		rainColors = new float[length][];
		for (int i = 0; i < length; ++i) {
			double high = 7e-8;
			double low = high / 10;

			if (gTiles[i].isWater()) {
				rainColors[i] = water;
			} else {
				double ratio = 0.0;
				float rain = s.getPrecipitation(i);
				if (rain < low) {
					ratio = rain / low;
					rainColors[i] = interpolateColor(dry, medium, ratio);
				} else {
					ratio = Math.min(1, (rain - low) / (high - low));
					rainColors[i] = interpolateColor(medium, wet, ratio);
				}
			}
		}
	}

}
