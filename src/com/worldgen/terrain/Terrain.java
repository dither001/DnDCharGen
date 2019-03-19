package com.worldgen.terrain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.jogamp.opengl.math.VectorUtil;
import com.miscellaneous.util.Dice;
import com.worldgen.planet.*;

public class Terrain {

	float[] axis;
	double axial_tilt;
	double radius;
	double sea_level;

	TerrainTile[] tiles;
	TerrainCorner[] corners;
	TerrainEdge[] edges;

	public Terrain(int size) {
		int tileSize = Grid.tileCount(size);
		int cornerSize = Grid.cornerCount(size);
		int edgeSize = Grid.edgeCount(size);

		tiles = new TerrainTile[tileSize];
		corners = new TerrainCorner[cornerSize];
		edges = new TerrainEdge[edgeSize];

		//

	}

	/*
	 * 
	 */
	public static Terrain build(int size) {
		Terrain terrain = new Terrain(size);

		// clear(planet)
		// set_grid_size(planet, parameters.grid_size)
		// init_terrain(p);

		// _set_variables(p, par);
		terrain.axis = Parameters.axis;
		terrain.radius = 40000000;

		// _set_elevation(p, par);
		List<float[][]> d = Dice.rollVector3(Parameters.iterations);
		for (Iterator<float[][]> it = d.iterator(); it.hasNext();) {
			float[][] f = it.next();
			for (float[] el : f)
				System.out.println(Dice.printVector3(el));
		}

		// _create_sea(p, par);
		// _classify_terrain(p);
		// _set_river_directions(p);

		return terrain;
	}

	private static float elevationAtPoint(float[] point, List<float[][]> list) {
		float elevation = 0;

		for (float[][] el : list) {
			if (VectorUtil.distSquareVec3(point, el[0]) < 2.0 && VectorUtil.distSquareVec3(point, el[1]) < 2.0
					&& VectorUtil.distSquareVec3(point, el[2]) < 2.0)
				++elevation;
		}

		return elevation;
	}

}
