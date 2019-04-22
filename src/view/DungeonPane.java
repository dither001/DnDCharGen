package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.dnd5e.dungeons.*;
import com.miscellaneous.util.*;

import model.*;

@SuppressWarnings("serial")
public class DungeonPane extends JPanel {

	/*
	 * INSTANCE FIELDS
	 */
	private Dungeon dungeon;
	private FloorPanel floorPanel;

	private DungeonFloorModel floorModel;
	private JTable floorTable;

	private JScrollPane scrollPane;

	/*
	 * CONSTRUCTORS
	 */
	private DungeonPane() {
		// XXX
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

	public DungeonFloorModel getFloorModel() {
		return floorModel;
	}

	public void setFloorModel(DungeonFloorModel floorModel) {
		this.floorModel = floorModel;
	}

	public JTable getFloorTable() {
		return floorTable;
	}

	public void setFloorTable(JTable floorTable) {
		this.floorTable = floorTable;
	}

	public void selectFloor() {
		int row = floorTable.getSelectedRow();
		if (row >= 0) {
			floorPanel.setFloor(dungeon.getFloor(row));

			revalidate();
			repaint();
		}
	}

	/*
	 * PRIVATE METHODS
	 */
	private void explore() {
		dungeon.explore();

		//
		floorModel.clearInstances();
		floorModel.addAll(Misc.arrayToList(dungeon.getFloors()));
		floorPanel.setFloor(dungeon.getFloor(0));
		
		//
		revalidate();
		repaint();
	}

	private void rebuild() {
		Dungeon dungeon = Dungeon.build(Dice.roll(2, 4) + 1);
		setDungeon(dungeon);

		//
		floorModel.clearInstances();
		floorModel.addAll(Misc.arrayToList(dungeon.getFloors()));
		floorPanel.setFloor(dungeon.getFloor(0));

		//
		revalidate();
		repaint();
	}

	/*
	 * STATIC METHODS
	 */
	public static DungeonPane build(Dungeon dungeon) {
		DungeonPane pane = new DungeonPane();
		pane.setLayout(new BorderLayout(5, 5));

		// add dungeon
		pane.setDungeon(dungeon);
		pane.setFloorPanel(FloorPanel.build(dungeon.getFloor(0)));
		pane.add(pane.floorPanel, BorderLayout.CENTER);

		// add floor list
		pane.floorModel = new DungeonFloorModel();
		pane.floorModel.addAll(Misc.arrayToList(dungeon.getFloors()));
		pane.floorTable = new JTable(pane.floorModel);
		pane.floorTable.getSelectionModel().addListSelectionListener(e -> pane.selectFloor());

		// setup floor table scroll pane
		pane.scrollPane = new JScrollPane(pane.floorTable);
		pane.scrollPane.setPreferredSize(new Dimension(80, 200));
		pane.add(pane.scrollPane, BorderLayout.LINE_START);

		// south panel
		JPanel southPanel = new JPanel();

		// generate button
		JButton regenerate = new JButton("Regenerate");
		regenerate.addActionListener(e -> pane.rebuild());
		southPanel.add(regenerate);

		// explore button
		JButton explore = new JButton("Explore");
		explore.addActionListener(e -> pane.explore());
		southPanel.add(explore);

		//
		pane.add(southPanel, BorderLayout.SOUTH);

		return pane;
	}

}
