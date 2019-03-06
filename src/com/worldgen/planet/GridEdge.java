package com.worldgen.planet;

public class GridEdge {
	int id;

	GridTile[] tiles;
	GridCorner[] corners;

	/*
	 * 
	 */
	public GridEdge(int id) {
		this.id = id;

		tiles = new GridTile[2];
		corners = new GridCorner[2];
	}

	/*
	 * 
	 */
	public String toString() {
		return "(" + tiles[0].id + "," + tiles[1].id + ")";
	}
	
	void addEdge(GridTile[] t) {
		// TODO - untested
		GridCorner[] c = { //
				t[0].corners[Grid.position(t[0], t[1])], //
				t[0].corners[(Grid.position(t[0], t[1]) + 1) % t[0].edgeCount] //
		};

		for (int i = 0; i < 2; i++) {
			t[i].edges[Grid.position(t[i], t[(i + 1) % 2])] = this;
			tiles[i] = t[i];
			c[i].edges[Grid.position(c[i], c[(i + 1) % 2])] = this;
			corners[i] = c[i];
		}
	}
}
