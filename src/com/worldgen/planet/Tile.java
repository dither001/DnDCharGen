package com.worldgen.planet;

public class Tile implements UsesTerrain {
	public int id;
	int edgeCount;

	public Tile[] tiles;
	Corner[] corners;
	Edge[] edges;

	public float[] v;

	// terrain fields
	public float elevation;
	public LandType type;
	public Water water;

	// climate fields
	public Wind wind;
	private float latitude;
	public double temperature;
	private float humidity;
	private float precipitation;

	/*
	 * CONSTRUCTORS
	 */
	public Tile(int id, int edgeCount) {
		this.id = id;
		this.edgeCount = edgeCount;

		v = new float[] { 0, 0, 0 };
		tiles = new Tile[edgeCount];
		corners = new Corner[edgeCount];
		edges = new Edge[edgeCount];

		// terrain fields
		elevation = 0;
		type = LandType.LAND;
		water = new Water();

		// climate fields
		wind = new Wind();
		latitude = 0;
		temperature = 0;
		humidity = 0;
		precipitation = 0;
	}

	/*
	 * TERRAIN METHODS
	 */
	public boolean isLand() {
		return type.equals(LandType.LAND);
	}

	public boolean isWater() {
		return type.equals(LandType.WATER);
	}

	public boolean hasCoast() {
		return type.equals(LandType.COAST);
	}

	public float getElevation() {
		return elevation;
	}

	public float getWaterDepth() {
		return water.depth;
	}

	@Override
	public LandType getLandType() {
		return type;
	}

	@Override
	public void setLandType(LandType type) {
		this.type = type;
	}

}
