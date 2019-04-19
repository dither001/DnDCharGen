package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.dnd5e.dungeons.*;
import com.miscellaneous.util.*;

import model.*;

@SuppressWarnings("serial")
public class DungeonFrame extends JFrame {

	/*
	 * INSTANCE FIELDS
	 */
	private Dungeon dungeon;
	private FloorPanel floorPanel;

	private DungeonFloorModel floorModel;
	private JTable floorTable;

	/*
	 * CONSTRUCTORS
	 */
	private DungeonFrame(Dungeon dungeon) {
		super("Dungeon Generator");
		this.dungeon = dungeon;
	}

	/*
	 * INSTANCE METHODS
	 */
	public Dungeon getDungeon() {
		return dungeon;
	}

	public void setDungeon(Dungeon dungeon) {
		this.dungeon = dungeon;
	}

	public FloorPanel getFloorPanel() {
		return floorPanel;
	}

	public void setFloorPanel(FloorPanel floorPanel) {
		this.floorPanel = floorPanel;
	}

	public void selectFloor() {
		int row = floorTable.getSelectedRow();
		// System.out.println(row + " " + dungeon.getFloor(row).getTotalMappedArea() + "
		// / " + Default.BOUNDARY_AREA + " " + dungeon.getFloor(row).isUnderMapped());
		if (row >= 0) {
			floorPanel.setFloor(dungeon.getFloor(row));
			revalidate();
			repaint();
		}
	}

	private void rebuild() {
		Dungeon dungeon = Dungeon.build(Dice.roll(2, 4) + 1);
		dungeon.explore();

		setDungeon(dungeon);
		floorModel.clearInstances();
		floorModel.addAll(Misc.arrayToList(dungeon.getFloors()));
		floorPanel.setFloor(dungeon.getFloor(0));

		revalidate();
		repaint();
	}

	/*
	 * STATIC METHODS
	 */
	public static DungeonFrame build(Dungeon dungeon) {
		DungeonFrame frame = new DungeonFrame(dungeon);

		// initialize
		frame.setLayout(new BorderLayout(5, 5));

		// add dungeon
		frame.setFloorPanel(FloorPanel.build(dungeon.getFloor(0)));
		frame.add(frame.floorPanel, BorderLayout.CENTER);

		// add floor list
		frame.floorModel = new DungeonFloorModel();
		frame.floorModel.addAll(Misc.arrayToList(dungeon.getFloors()));
		frame.floorTable = new JTable(frame.floorModel);
		frame.floorTable.getSelectionModel().addListSelectionListener(e -> frame.selectFloor());

		// setup floor table scroll pane (USES PREFERRED SIZE)
		JScrollPane scrollPane = new JScrollPane(frame.floorTable);
		scrollPane.setPreferredSize(new Dimension(80, 200));
		frame.add(scrollPane, BorderLayout.LINE_START);

		// south panel
		JPanel southPanel = new JPanel();
		JButton regenerate = new JButton("Generate Dungeon");
		regenerate.addActionListener(e -> frame.rebuild());
		southPanel.add(regenerate);
		frame.add(southPanel, BorderLayout.SOUTH);

		// finalize
		frame.setResizable(false);
		// frame.setSize(640, 480);
		frame.pack();
		// frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

		return frame;
	}

}
