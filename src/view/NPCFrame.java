package view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.dnd5e.character.definitions.*;

import controller.Main;
import model.*;

@SuppressWarnings("serial")
public class NPCFrame extends JFrame {
	/*
	 * STATIC FIELDS
	 */

	private static NPCDetailFrame detail;
	private static JTextPane pane;

	private static NPCTableModel tableModel;
	private static JTable npcTable;
	private static TableRowSorter<TableModel> rowSorter;

	/*
	 * INITIALIZER
	 */
	static {
		detail = new NPCDetailFrame();
	}

	/*
	 * CONSTRUCTORS
	 */
	public NPCFrame() {
		super("Character Generator");
		setLayout(new BorderLayout(5, 5));

		// adds characters to model
		tableModel = new NPCTableModel();
		tableModel.addAll(Main.npcList);

		// hands model off to table
		npcTable = new JTable(tableModel);
		rowSorter = new TableRowSorter<>(npcTable.getModel());
		npcTable.setRowSorter(rowSorter);

		//
		npcTable.getSelectionModel().addListSelectionListener(e -> launchCharacterDetail());
		add(new JScrollPane(npcTable), BorderLayout.CENTER);

		// panel for additional components (when desired)
		JPanel southPanel = new JPanel();
		JButton partyButton = new JButton("Create Adventuring Party");
		JButton rerollButton = new JButton("Roll New Characters");
		JButton clearButton = new JButton("Clear Characters");

		southPanel.add(partyButton);
		partyButton.addActionListener(e -> createAdventuringParty());
		southPanel.add(rerollButton);
		rerollButton.addActionListener(e -> tableModel.addAll(Main.rollCharacters(Main.NPCS_TO_ROLL)));
		southPanel.add(clearButton);
		clearButton.addActionListener(e -> clearCharacterDetail());

		// adds the southern panel
		add(southPanel, BorderLayout.SOUTH);

		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/*
	 * PRIVATE METHODS
	 */
	private static void clearCharacterDetail() {
		detail.setVisible(false);
		detail = new NPCDetailFrame();
		tableModel.clearInstances();
	}

	private static void createAdventuringParty() {
		int[] rows = npcTable.getSelectedRows();

		if (rows.length > 0) {
			int[] indices = new int[rows.length];
			for (int i = 0; i < rows.length; ++i)
				indices[i] = npcTable.convertRowIndexToModel(rows[i]);

			for (int el : indices)
				System.out.println(tableModel.getInstance(el).toString());
		}
	}

	private static void launchCharacterDetail() {
		if (npcTable.getRowCount() > 0) {
			if (detail.isVisible()) {
				StringBuilder sb = new StringBuilder();

				int index = npcTable.convertRowIndexToModel(npcTable.getSelectedRow());
				sb.append(tableModel.getInstance(index).toStringVerbose());

				pane.setText(sb.toString());
				detail.setContentPane(pane);

			} else {
				detail = new NPCDetailFrame();

				StringBuilder sb = new StringBuilder();
				// sb.append(tableModel.getInstance(npcTable.getSelectedRow()).toStringVerbose());
				int index = npcTable.convertRowIndexToModel(npcTable.getSelectedRow());
				sb.append(tableModel.getInstance(index).toStringVerbose());

				pane = new JTextPane();
				pane.setText(sb.toString());

				detail.setContentPane(pane);
				detail.setVisible(true);

			}

		}
	}

}
