package com.worldgen.climate;

public class Wind {
	float direction, speed;

	public Wind() {
		direction = 0;
		speed = 0;
	}

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
}
