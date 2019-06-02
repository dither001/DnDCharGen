package com.worldgen.planet;

public class Climate {

	Planet planet;
	Season[] seasons;
	
	/*
	 * CONSTRUCTORS
	 */
	private Climate() {
		seasons = new Season[0];
	}

	/*
	 * 
	 */
	void clear() {
		// TODO

	}

	void generateSeasons() {
		for (int i = 0; i < seasons.length; ++i) {
			float t = i / seasons.length;
			seasons[i] = Season.build(i, t, planet);
		}

		// Climate_generation_season season;
		// season.tiles.resize(tile_count(planet));
		// season.corners.resize(corner_count(planet));
		// season.edges.resize(edge_count(planet));

		// season.var.time_of_year = time_of_year;
		// season.var.solar_equator = axial_tilt(planet) * sin(2.0*pi*time_of_year);
		// season.tropical_equator = 0.67*season.var.solar_equator;

		// _set_temperature(planet, par, season);
		// _set_wind(planet, par, season);
		// _set_humidity(planet, par, season);

		// Season s;
		// s.tiles.resize(tile_count(planet));
		// s.corners.resize(corner_count(planet));
		// s.edges.resize(edge_count(planet));
		// copy_season(season, s);
		// m_climate(planet).seasons.push_back(s);
	}

	/*
	 * STATIC METHODS
	 */
	public static Climate build(Planet planet) {
		Climate climate = new Climate();
		
		//
		climate.planet = planet;

		// clear_climate(planet);
		// m_terrain(planet).var.axial_tilt = par.axial_tilt;

		// m_climate(planet).var.season_count = par.seasons;
		climate.seasons = new Season[Parameters.seasons];

		// generate_season(planet, par, (float)i/par.seasons);
		climate.generateSeasons();

		return climate;
	}

	public static double freezingPoint() {
		return 273.15;
	}

	public static double temperatureLapseRate() {
		return 9.8e-3;
	}

	// LAPSE OF ELEVATION
	public static double temperatureLapse(double d) {
		return d * temperatureLapseRate();
	}

	// SATURATION AT TEMPERATURE
	public static float saturation_humidity(double index_base_temperature) {
		double c = 4.6e-9;
		double k = 0.05174;

		return (float) (c * Math.pow(k, index_base_temperature));
	}

	// ARIDITY AT TEMPERATURE
	public static double aridity(double potential_evapotranspiration) {
		double index_base_temperature = 10 + freezingPoint();

		return potential_evapotranspiration / saturation_humidity(index_base_temperature);
	}

}
