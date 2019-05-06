package com.worldgen.terrain;

import java.util.List;

import com.jogamp.opengl.math.VectorUtil;
import com.miscellaneous.util.*;
import com.worldgen.planet.*;

public class Terrain {

	private static final int SCALE = 3000;

	/*
	 * 
	 */
	float[] axis;
	double axial_tilt;
	double radius;
	double sea_level;

	TerrainTile[] tiles;
	TerrainCorner[] corners;
	TerrainEdge[] edges;

	/*
	 * CONSTRUCTORS
	 */
	private Terrain(int size) {
		int tileSize = Grid.tileCount(size);
		int cornerSize = Grid.cornerCount(size);
		int edgeSize = Grid.edgeCount(size);

		tiles = new TerrainTile[tileSize];
		corners = new TerrainCorner[cornerSize];
		edges = new TerrainEdge[edgeSize];

		//

	}

	/*
	 * PRIVATE METHODS
	 */
	private void initializeTerrain(Grid grid) {
		int tileSize = grid.tileSize();
		int cornerSize = grid.cornerSize();
		int edgeSize = grid.edgeSize();

		for (int i = 0; i < tileSize; ++i)
			tiles[i] = new TerrainTile(grid.tiles[i]);

		for (int i = 0; i < cornerSize; ++i)
			corners[i] = new TerrainCorner(grid.corners[i]);

		for (int i = 0; i < edgeSize; ++i)
			edges[i] = new TerrainEdge(grid.edges[i]);

	}

	private void setElevation() {
		/*
		 * First step appears to create 1,000 Vec3[3] arrays with points uniformly
		 * distributed over a unit sphere
		 */

		// _elevation_vectors
		List<float[][]> d = Dice.elevationVectors(Parameters.iterations);

		for (TerrainTile el : tiles)
			el.elevation = elevationHelper(el.gridTile.v, d);

		for (TerrainCorner el : corners)
			el.elevation = elevationHelper(el.gridCorner.v, d);

		/*
		 * SCALE ELEVATION
		 */
		float lowest = tiles[0].elevation, highest = lowest;

		for (TerrainTile el : tiles) {
			lowest = el.elevation < lowest ? el.elevation : lowest;
			highest = el.elevation > highest ? el.elevation : highest;
		}

		for (TerrainCorner el : corners) {
			lowest = el.elevation < lowest ? el.elevation : lowest;
			highest = el.elevation > highest ? el.elevation : highest;
		}

		highest = Math.max(1, highest - lowest);
		float scalar = SCALE / highest;

		for (TerrainTile el : tiles) {
			el.elevation -= lowest;
			el.elevation *= scalar;
		}

		for (TerrainCorner el : corners) {
			el.elevation -= lowest;
			el.elevation *= scalar;
		}
	}

	private float elevationHelper(float[] point, List<float[][]> list) {
		float elevation = 0;

		for (float[][] el : list) {
			if (VectorUtil.distSquareVec3(point, el[0]) < 2.0 //
					&& VectorUtil.distSquareVec3(point, el[1]) < 2.0 //
					&& VectorUtil.distSquareVec3(point, el[2]) < 2.0) {

				++elevation;
			}
		}

		return elevation;
	}

	private void createSea() {
		/*
		 * FIXME
		 */
		TerrainTile start = lowestTile();

	}

	private TerrainTile lowestTile() {
		TerrainTile lowest = tiles[0];
		for (int i = 0; i < tiles.length; ++i) {
			if (tiles[i].elevation < lowest.elevation)
				lowest = tiles[i];
		}

		return lowest;
	}

	/*
	 * STATIC METHODS
	 */
	public static Terrain build(Grid grid) {
		/*
		 * FIXME - currently working through the "generate_terrain" method of the
		 * terrain_generation.cpp file in vraid's old earthgen project.
		 */
		Terrain terrain = new Terrain(grid.size);

		// clear(planet)
		// set_grid_size(planet, parameters.grid_size)
		// init_terrain(p);
		terrain.initializeTerrain(grid);

		// REPLACES: _set_variables(p, par);
		terrain.axis = Parameters.axis;
		terrain.radius = 40000000;

		// REPLACES: _set_elevation(p, par);
		terrain.setElevation();

		// _create_sea(p, par);
		// _classify_terrain(p);
		// _set_river_directions(p);

		return terrain;
	}

	/*
	 * Returns inverse-sine of z-coordinate
	 */
	public static double latitude(float[] vector3) {
		return Math.asin(vector3[2]);
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

	public static double latitude(Planet p, float[] vector3) {
		/*
		 * FIXME - subtracts (angle between planet's axis and vector3)
		 */
		return Math.PI / 2 - VectorUtil.angleVec3(null, vector3);
	}

}
