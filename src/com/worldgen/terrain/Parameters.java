package com.worldgen.terrain;

public abstract class Parameters {
	public static int grid_size;
	public static float[] axis;
	public String seed;
	public static int iterations;
	public static double water_ratio;

	static {
		grid_size = 6;
		axis = new float[] { 0, 0, 1 };
		iterations = 1000;
		water_ratio = 0.65;
	}
}
