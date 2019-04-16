package view;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JFrame;

import com.dnd5e.definitions.dungeons.Default;
import com.dnd5e.dungeons.*;

@SuppressWarnings("serial")
public class DungeonFrame extends JFrame {

	private Floor floor;

	/*
	 * CONSTRUCTORS
	 */
	private DungeonFrame() {
		super("Chargen");
	}

	/*
	 * INSTANCE METHODS
	 */
	public void paint(Graphics g) {
		/*
		 * FIXME - as it turns out, in order to get a JFrame to "paint" the contents of
		 * some objects you've coded to "paint," you must override JFrame's paint()
		 * method. This might be obvious if you know enough about Swing.
		 */
		if (floor != null)
			floor.paint(g);
	}

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	/*
	 * STATIC METHODS
	 */
	public static DungeonFrame build(Floor floor) {
		DungeonFrame frame = new DungeonFrame();

		// initialize
		// frame.setLayout(new BorderLayout(5, 5));

		frame.setFloor(floor);

		// finalize
		frame.setResizable(false);
		frame.setSize(Default.DIMENSIONS);
		frame.setLocationRelativeTo(null);
		// frame.pack();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

		return frame;
	}

}
