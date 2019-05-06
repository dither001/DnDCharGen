package com.worldgen.planet;

public class Grid {
	private static final float X_POS = -0.525731112119133606f;
	private static final float Z_POS = -0.850650808352039932f;

	private static final float[][] ICOSAHEDRON_VECTORS = { //
			{ -X_POS, 0, Z_POS }, { X_POS, 0, Z_POS }, { -X_POS, 0, -Z_POS }, //
			{ X_POS, 0, -Z_POS }, { 0, Z_POS, X_POS }, { 0, Z_POS, -X_POS }, //
			{ 0, -Z_POS, X_POS }, { 0, -Z_POS, -X_POS }, { Z_POS, X_POS, 0 }, //
			{ -Z_POS, X_POS, 0 }, { Z_POS, -X_POS, 0 }, { -Z_POS, -X_POS, 0 } //
	};

	private static final int[][] ICOSAHEDRON_IDS = { //
			{ 9, 4, 1, 6, 11 }, { 4, 8, 10, 6, 0 }, { 11, 7, 3, 5, 9 }, //
			{ 2, 7, 10, 8, 5 }, { 9, 5, 8, 1, 0 }, { 2, 3, 8, 4, 9 }, //
			{ 0, 1, 10, 7, 11 }, { 11, 6, 10, 3, 2 }, { 5, 3, 10, 1, 4 }, //
			{ 2, 5, 4, 0, 11 }, { 3, 7, 6, 1, 8 }, { 7, 2, 9, 0, 6 } //
	};

	/*
	 * 
	 */
	public int size;

	public GridTile[] tiles;
	public GridCorner[] corners;
	public GridEdge[] edges;

	private Grid(int size) {
		this.size = size;

		int tileSize = tileCount(size);
		int cornerSize = cornerCount(size);
		int edgeSize = edgeCount(size);

		tiles = new GridTile[tileSize];
		for (int i = 0; i < tileSize; ++i)
			tiles[i] = new GridTile(i, i < 12 ? 5 : 6);

		corners = new GridCorner[cornerSize];
		for (int i = 0; i < cornerSize; ++i)
			corners[i] = new GridCorner(i);

		edges = new GridEdge[edgeSize];
		for (int i = 0; i < edgeSize; ++i)
			edges[i] = new GridEdge(i);

	}

	/*
	 * INSTANCE METHODS
	 */
	public void addCorner(int index, int t1, int t2, int t3) {
		corners[index].addCorner(new GridTile[] { tiles[t1], tiles[t2], tiles[t3] });
	}

	public void addEdge(int index, int t1, int t2) {
		edges[index].addEdge(new GridTile[] { tiles[t1], tiles[t2] });
	}

	public GridTile getTile(int index) {
		return tiles[index];
	}

	public GridCorner getCorner(int index) {
		return corners[index];
	}

	public GridEdge getEdge(int index) {
		return edges[index];
	}

	public int tileSize() {
		return tiles.length;
	}

	public int cornerSize() {
		return corners.length;
	}

	public int edgeSize() {
		return edges.length;
	}

	public String toString() {
		String s = "";

		s += tiles.length + "\n";
		s += corners.length + "\n";
		s += edges.length;

		return s;
	}

	/*
	 * STATIC METHODS
	 */
	public static Grid build(int size) {
		if (size == 0)
			return sizeZeroGrid();
		else
			return subdivide(build(size - 1));
	}

	private static Grid subdivide(Grid prev) {
		Grid grid = new Grid(prev.size + 1);

		int prev_tile_count = prev.tiles.length;
		int prev_corner_count = prev.corners.length;

		// OLD TILES
		for (int i = 0; i < prev_tile_count; i++) {
			grid.tiles[i].v = prev.tiles[i].v;
			for (int k = 0; k < grid.tiles[i].edgeCount; k++) {
				grid.tiles[i].tiles[k] = grid.tiles[prev.tiles[i].corners[k].id + prev_tile_count];
			}
		}

		// OLD CORNERS BECOMES TILES
		for (int i = 0; i < prev_corner_count; i++) {
			grid.tiles[i + prev_tile_count].v = prev.corners[i].v;
			for (int k = 0; k < 3; k++) {
				grid.tiles[i + prev_tile_count].tiles[2 * k] = grid.tiles[prev.corners[i].corners[k].id
						+ prev_tile_count];
				grid.tiles[i + prev_tile_count].tiles[2 * k + 1] = grid.tiles[prev.corners[i].tiles[k].id];
			}
		}

		// NEW CORNERS
		int next_corner_id = 0;
		for (GridTile n : prev.tiles) {
			GridTile t = grid.tiles[n.id];
			for (int k = 0; k < t.edgeCount; k++) {
				grid.addCorner(next_corner_id, t.id, t.tiles[(k + t.edgeCount - 1) % t.edgeCount].id, t.tiles[k].id);
				++next_corner_id;
			}
		}

		// CONNECT CORNERS
		for (GridCorner c : grid.corners) {
			for (int k = 0; k < 3; k++) {
				c.corners[k] = c.tiles[k].corners[(position(c.tiles[k], c) + 1) % (c.tiles[k].edgeCount)];
			}
		}

		// NEW EDGES
		int next_edge_id = 0;
		for (GridTile t : grid.tiles) {
			for (int k = 0; k < t.edgeCount; k++) {
				if (t.edges[k] == null) {
					grid.addEdge(next_edge_id, t.id, t.tiles[k].id);
					next_edge_id++;
				}
			}
		}

		return grid;
	}

	private static Grid sizeZeroGrid() {
		Grid grid = new Grid(0);

		for (GridTile el : grid.tiles) {
			el.v = ICOSAHEDRON_VECTORS[el.id];

			for (int i = 0; i < 5; ++i)
				el.tiles[i] = grid.tiles[ICOSAHEDRON_IDS[el.id][i]];
		}

		for (int i = 0; i < 5; i++)
			grid.addCorner(i, 0, ICOSAHEDRON_IDS[0][(i + 4) % 5], ICOSAHEDRON_IDS[0][i]);

		for (int i = 0; i < 5; i++)
			grid.addCorner(i + 5, 3, ICOSAHEDRON_IDS[3][(i + 4) % 5], ICOSAHEDRON_IDS[3][i]);

		grid.addCorner(10, 10, 1, 8);
		grid.addCorner(11, 1, 10, 6);
		grid.addCorner(12, 6, 10, 7);
		grid.addCorner(13, 6, 7, 11);
		grid.addCorner(14, 11, 7, 2);
		grid.addCorner(15, 11, 2, 9);
		grid.addCorner(16, 9, 2, 5);
		grid.addCorner(17, 9, 5, 4);
		grid.addCorner(18, 4, 5, 8);
		grid.addCorner(19, 4, 8, 1);

		// ADD CORNERS TO CORNERS
		for (GridCorner el : grid.corners) {
			for (int i = 0; i < 3; i++)
				el.corners[i] = el.tiles[i].corners[(position(el.tiles[i], el) + 1) % 5];
		}

		// NEW EDGES
		int nextId = 0;
		for (GridTile el : grid.tiles) {
			for (int i = 0; i < 5; i++) {
				if (el.edges[i] == null) {
					grid.addEdge(nextId, el.id, ICOSAHEDRON_IDS[el.id][i]);
					nextId++;
				}
			}
		}

		//
		return grid;
	}

	public static int tileCount(int size) {
		return (int) (10 * Math.pow(3, size) + 2);
	}

	public static int cornerCount(int size) {
		return (int) (20 * Math.pow(3, size));
	}

	public static int edgeCount(int size) {
		return (int) (30 * Math.pow(3, size));
	}

	/*
	 * RELATIVE POSITION FINDERS
	 */
	static int position(GridTile t, GridTile n) {
		for (int i = 0; i < t.edgeCount; i++) {
			if (t.tiles[i].equals(n))
				return i;
		}

		return -1;
	}

	static int position(GridTile t, GridCorner c) {
		for (int i = 0; i < t.edgeCount; i++) {
			if (t.corners[i].equals(c))
				return i;
		}

		return -1;
	}

	static int position(GridTile t, GridEdge e) {
		for (int i = 0; i < t.edgeCount; i++) {
			if (t.edges[i].equals(e))
				return i;
		}

		return -1;
	}

	static int position(GridCorner c, GridTile t) {
		for (int i = 0; i < 3; i++) {
			if (c.tiles[i].equals(t))
				return i;
		}

		return -1;
	}

	static int position(GridCorner c, GridCorner n) {
		for (int i = 0; i < 3; i++) {
			if (c.corners[i].equals(n))
				return i;
		}

		return -1;
	}

	static int position(GridCorner c, GridEdge e) {
		for (int i = 0; i < 3; i++) {
			if (c.edges[i].equals(e))
				return i;
		}

		return -1;
	}

	static int position(GridEdge e, GridTile t) {
		if (e.tiles[0].equals(t))
			return 0;
		else if (e.tiles[1].equals(t))
			return 1;

		return -1;
	}

	static int position(GridEdge e, GridCorner c) {
		if (e.corners[0].equals(c))
			return 0;
		else if (e.corners[1].equals(c))
			return 1;

		return -1;
	}
}
