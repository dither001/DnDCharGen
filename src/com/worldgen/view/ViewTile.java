package com.worldgen.view;

import com.jogamp.opengl.math.Quaternion;
import com.worldgen.math.Matrix3;
import com.worldgen.model.Planet;
import com.worldgen.model.PlanetUtil;
import com.worldgen.model.Tile;

public class ViewTile {

	int id;
	float[] center;
	float[][] corners;

	public ViewTile(Tile t, Matrix3 m) {
		this.id = t.id;

		float[] tmp = m.multVec3(t.v);
		double longitude = Planet.longitude(tmp);
		Quaternion offset = PlanetUtil.fromAngle((float) -longitude, new float[] { 0, 0, 1 });

		this.center = HammerProjection.toHammer(tmp);
		for (int i = 0; i < t.edges.length; ++i) {
			float[] v = m.multVec3(t.corners[i].v);
			double lat = Planet.latitude(v);
			double lon = longitude + Planet.longitude(PlanetUtil.rotateVec3(v, offset));

			corners[i] = HammerProjection.toHammer(lat, lon);
		}

		if (t.edges.length == 5)
			corners[5] = corners[0];
	}

}
