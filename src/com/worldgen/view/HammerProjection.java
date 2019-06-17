package com.worldgen.view;

import com.jogamp.opengl.math.Quaternion;
import com.jogamp.opengl.math.VectorUtil;
import com.worldgen.math.Matrix3;
import com.worldgen.model.Planet;
import com.worldgen.model.Tile;

public abstract class HammerProjection {

	static ViewTile[] vtiles;

	public static void buildGeometry(Planet p, Quaternion q) {
		Tile[] gtiles = p.getGrid().tiles;
		vtiles = new ViewTile[gtiles.length];

		Matrix3 m = new Matrix3(q);
		for (int i = 0; i < gtiles.length; ++i) {
			vtiles[i] = new ViewTile(gtiles[i], m);
		}
	}

	public static double hammerHeight() {
		return Math.sqrt(2.0);
	}

	public static double hammerWidth() {
		return Math.sqrt(8.0);
	}

	//
	public static float[] toHammer(float[] v) {
		return toHammer(Planet.latitude(v), Planet.longitude(v));
	}

	public static float[] toHammer(double longitude, double latitude) {
		float[] v = new float[] { (float) (2.0 * Math.cos(latitude) * Math.sin(longitude / 2.0)),
				(float) Math.sin(latitude) };
		float u = (float) (Math.sqrt(2.0) / Math.sqrt(1.0 + Math.cos(latitude) * Math.cos(longitude / 2.0)));

		return VectorUtil.scaleVec2(v, v, u);
	}

	//
	public static float[] fromHammer(float[] v2) {
		double z = Math.sqrt(1.0 - Math.pow(v2[0] / 4.0, 2.0) - Math.pow(v2[1] / 2.0, 2.0));
		double latitude = Math.asin(z * v2[1]);
		double longitude = 2.0 * Math.atan(z * v2[0] / (2.0 * (2.0 * z * z - 1.0)));

		return fromLatitudeLongitude(latitude, longitude);
	}

	public static float[] fromLatitudeLongitude(double latitude, double longitude) {
		return new float[] { (float) (Math.cos(latitude) * Math.cos(longitude)),
				(float) (Math.cos(latitude) * Math.sin(longitude)), (float) Math.sin(latitude) };
	}

}
