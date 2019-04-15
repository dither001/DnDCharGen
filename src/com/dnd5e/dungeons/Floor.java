package com.dnd5e.dungeons;

import java.awt.Graphics;
import java.util.List;

import com.dnd5e.definitions.dungeons.*;

public class Floor {
	private List<Segment> chambers;
	private List<Segment> passages;

	/*
	 * INSTANCE METHODS
	 */
	public List<Segment> getChambers() {
		return chambers;
	}

	public void setChambers(List<Segment> chambers) {
		this.chambers = chambers;
	}

	public List<Segment> getPassages() {
		return passages;
	}

	public void setPassages(List<Segment> passages) {
		this.passages = passages;
	}

	public void paint(Graphics g) {
		for (Segment el : chambers)
			el.paint(g);

		for (Segment el : passages)
			el.paint(g);
	}
}
