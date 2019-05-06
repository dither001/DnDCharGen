package com.worldgen.terrain;

import com.jogamp.opengl.math.VectorUtil;

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

	void setDefault() {
		grid_size = 6;
		axis = new float[] { 0, 0, 1 };
		iterations = 1000;
		water_ratio = 0.65;
	}

	void correctValues() {
		// Ensure grid_size is between 0-10
		grid_size = Math.max(0, grid_size);
		grid_size = Math.min(grid_size, 10);

		if (VectorUtil.isVec3Zero(axis, 0)) {
			axis = new float[] { 0, 0, 1 };

		} else {
			axis = VectorUtil.normalizeVec3(axis);

		}

		iterations = Math.max(0, grid_size);

		water_ratio = Math.max(0.0, water_ratio);
		water_ratio = Math.min(1.0, water_ratio);
	}
}
