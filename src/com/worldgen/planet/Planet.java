package com.worldgen.planet;

import com.jogamp.opengl.math.VectorUtil;

public class Planet {
	protected Grid grid;
	protected Terrain terrain;
	protected Climate climate;

	/*
	 * 
	 */
	public void clear() {
		// TODO

	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public Terrain getTerrain() {
		return terrain;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	public Climate getClimate() {
		return climate;
	}

	public void setClimate(Climate climate) {
		this.climate = climate;
	}

	/*
	 * 
	 */
	public double getSeaLevel() {
		return terrain.seaLevel;
	}

	/*
	 * 
	 */
	public static Planet build(int size) throws Exception {
		if (size < 9) {
			Planet planet = new Planet();

			planet.grid = Grid.build(size);
			planet.terrain = Terrain.build(planet.grid);
			planet.setClimate(Climate.build(planet));

			return planet;
		}

		throw new Exception("Please enter smaller size.");
	}

	/*
	 * XXX - default is set to "24 hours"
	 */
	public double angularVelocity(Planet p) {
		return 2.0 * Math.PI / (24 * 60 * 60);
	}

	public double coriolisCoeeficient(Planet p, double latitude) {
		return 2.0 * angularVelocity(p) * Math.sin(latitude);
	}

	public static double latitude(Planet p, float[] vector3) {
		/*
		 * FIXME - subtracts (angle between planet's axis and vector3)
		 */
		return Math.PI / 2 - VectorUtil.angleVec3(null, vector3);
	}

	/*
	 * Checks if x and y are 0; returns inverse-tangent of y, x
	 */
	public static double longitude(float[] vector3) {
		int x = (int) vector3[0];
		int y = (int) vector3[1];
		if (x == 0 && y == 0)
			return 0;

		return Math.atan2(vector3[1], vector3[0]);
	}

	/*
	 * Returns inverse-sine of z-coordinate
	 */
	public static double latitude(float[] vector3) {
		return Math.asin(vector3[2]);
	}

	public static float[] pressureGradiaentForce(double tropicalEquator, double latitude) {
		double pressure_derivate;
		double pressure_deviation = 20.0 / 15000;

		double c;
		if (latitude > tropicalEquator)
			c = 3.0 * Math.PI / (Math.PI / 2.0 - tropicalEquator);
		else
			c = 3.0 * Math.PI / (Math.PI / 2.0 + tropicalEquator);

		pressure_derivate = pressure_deviation * Math.sin(c * (latitude - tropicalEquator));

		double a = tropicalEquator + (Math.PI / 2.0 - tropicalEquator) / 3.0;
		double b = tropicalEquator - (Math.PI / 2.0 + tropicalEquator) / 3.0;
		if (latitude < a && latitude > b)
			pressure_derivate = pressure_deviation / 3.0;

		return new float[] { (float) -pressure_derivate, 0.0f };
	}

}
