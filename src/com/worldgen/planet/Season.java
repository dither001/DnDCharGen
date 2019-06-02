package com.worldgen.planet;


public class Season {

	//
	Planet planet;
	int id;

	double solar_equator;
	float time_of_year;

	//
	double tropical_equator;

	/*
	 * CONSTRUCTORS
	 */
	private Season() {
		// TODO
	}

	/*
	 * PRIVATE METHODS
	 */
	void setupTemperature() {
		for (Tile el : planet.grid.tiles) {
			double temperature = temperatureAtLatitude(tropical_equator - Planet.latitude(el.v));

			if (el.isLand() && el.elevation > planet.getSeaLevel()) {
				temperature -= Climate.temperatureLapse(el.elevation - planet.getSeaLevel());
			} else {
				temperature = 0.3 * temperature + 0.7 * temperatureAtLatitude(Planet.latitude(el.v));
			}
			
			el.temperature = temperature;
		}
	}
	
	void setupWind() {
		for (Tile el : planet.grid.tiles) {
			el.wind = windHelper();
		}
		
		
	}
	
	private Wind windHelper() {
		Wind wind = new Wind();
		
		float[] pressureForce = new float[2];
		
		
		
		
		
		return wind;
	}

	private double temperatureAtLatitude(double latitude) {
		return Climate.freezingPoint() - 25 + 50 * Math.cos(latitude);
	}

	/*
	 * STATIC METHODS
	 */
	public static Season build(int id, float timeOfYear, Planet planet) {
		Season season = new Season();

		//
		season.id = id;
		season.time_of_year = timeOfYear;
		season.planet = planet;

		season.solar_equator = Parameters.axial_tilt * Math.sin(2 * Math.PI * timeOfYear);
		season.tropical_equator = 0.67 * season.solar_equator;

		//
		season.setupTemperature();

		return season;
	}
}
