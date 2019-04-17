package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.dnd5e.definitions.dungeons.*;
import com.dnd5e.dungeons.*;

@SuppressWarnings("serial")
public class FloorPanel extends JPanel {

	private Floor floor;

	/*
	 * CONSTRUCTORS
	 */
	private FloorPanel() {
		this.floor = null;
	}

	/*
	 * INSTANCE METHODS
	 */
	public Dimension getPreferredSize() {
		return new Dimension(Default.DIMENSIONS);
	}

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	public void paint(Graphics g) {
		floor.paint(g);
	}

	/*
	 * STATIC METHODS
	 */
	public static FloorPanel build(Floor floor) {
		FloorPanel panel = new FloorPanel();

		panel.setSize(Default.DIMENSIONS);
		panel.setFloor(floor);

		return panel;
	}

}
