package com.worldgen.climate;

public class Climate {

	Season[] seasons;

	/*
	 * CONSTRUCTORS
	 */
	public Climate() {
		seasons = new Season[0];
	}

	/*
	 * 
	 */
	void clear() {
		// TODO

	}

	float freezing_point() {
		return 273.15f;
	}

	float temperature_lapse_rate() {
		return 9.8e-3f;
	}

	// LAPSE OF ELEVATION
	float temperature_lapse(float height) {
		return height * temperature_lapse_rate();
	}

	// SATURATION AT TEMPERATURE
	float saturation_humidity(float temperature) {
		double c = 4.6e-9;
		double k = 0.05174;

		return (float) (c * Math.pow(k, temperature));
	}

	// ARIDITY AT TEMPERATURE
	float aridity(float potential_evapotranspiration) {
		float index_base_temperature = 10 + freezing_point();

		return potential_evapotranspiration / saturation_humidity(index_base_temperature);
	}
}
