package com.worldgen.planet;

import com.jogamp.opengl.math.VectorUtil;

public class Wind {
	double direction, speed;

	/*
	 * CONSTRUCTORS
	 */
	private Wind() {
		direction = 0;
		speed = 0;
	}

	private Wind(double direction, double speed) {
		this.direction = direction;
		this.speed = speed;
	}

	/*
	 * INSTANCE METHODS
	 */
	@Override
	public boolean equals(Object o) {
		boolean equals = false;

		if (o.equals(this))
			return true;

		if (o.getClass().equals(Wind.class)) {
			Wind w = (Wind) o;

			int d1 = (int) (this.direction), d2 = (int) (w.direction);
			int s1 = (int) (this.speed), s2 = (int) (w.speed);

			if (d1 == d2 && s1 == s2)
				equals = true;
		}

		return equals;
	}

	/*
	 * STATIC METHODS
	 */
	public static Wind prevailingWind(float[] pressureGradientForce, double coriolisCoefficient,
			double frictionCoefficient) {
		double angleOffset = Math.atan2(coriolisCoefficient, frictionCoefficient);
		float[] divisor = new float[] { (float) coriolisCoefficient, (float) frictionCoefficient };
		double speed = VectorUtil.normVec2(pressureGradientForce) / VectorUtil.normVec2(divisor);

		// Vector2 v = rotation_matrix(angle(pressure_gradient_force) - angle_offset) *
		// Vector2(1.0, 0.0);
		float[] v = new float[] {};

		double direction = Math.atan2(v[1], v[0]);
		return new Wind(direction, speed);
	}
}
