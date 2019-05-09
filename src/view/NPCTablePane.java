package view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.dnd5e.characters.*;

import controller.*;
import model.*;

@SuppressWarnings("serial")
public class NPCTablePane extends JPanel {

	/*
	 * INSTANCE FIELDS
	 */
	private NPCTableModel tableModel;
	private JTable npcTable;
	private TableRowSorter<TableModel> rowSorter;
	private JScrollPane scrollPane;

	/*
	 * CONSTRUCTORS
	 */
	private NPCTablePane() {

	}

	/*
	 * INSTANCE METHODS
	 */
	public NPCTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(NPCTableModel tableModel) {
		this.tableModel = tableModel;
	}

	public JTable getNpcTable() {
		return npcTable;
	}

	public void setNpcTable(JTable npcTable) {
		this.npcTable = npcTable;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public TableRowSorter<TableModel> getRowSorter() {
		return rowSorter;
	}

	public void setRowSorter(TableRowSorter<TableModel> rowSorter) {
		this.rowSorter = rowSorter;
	}

	/*
	 * PRIVATE METHODS
	 */
	private void clearCharacterDetail() {
		Controller.detail.setVisible(false);
		Controller.detail = new NPCDetailFrame();
		tableModel.clearInstances();

		if (Controller.getPlayers().size() > 0)
			tableModel.addAll(Controller.getPlayers());
	}

	private void addToParty() {
		int[] rows = npcTable.getSelectedRows();

		if (rows.length > 0) {
			int[] indices = new int[rows.length];
			for (int i = 0; i < rows.length; ++i)
				indices[i] = npcTable.convertRowIndexToModel(rows[i]);

			List<DnDCharacter> list = new ArrayList<DnDCharacter>(rows.length);
			for (int el : indices) {
				list.add(tableModel.getInstance(el));

			}

			Controller.addPlayers(list);
			Controller.update();
		}
	}

	private void launchCharacterDetail() {
		/*
		 * Gets character instance from selected row; validation step to ensure that
		 * sorting the table hasn't altered the index (of the character instance)
		 */
		int index = npcTable.getSelectedRow();
		StringBuilder sb = new StringBuilder();

		if (index >= 0) {
			DnDCharacter c = tableModel.getInstance(npcTable.convertRowIndexToModel(index));

			sb.append(c.toStringVerbose() + "\n---\n");
			sb.append(c.getCombatBlock().toStringVerbose());
		}

		if (npcTable.getRowCount() > 0) {

			JTextPane panel = new JTextPane();
			panel.setText(sb.toString());
			Controller.detail.setContentPane(new JScrollPane(panel));
			Controller.detail.revalidate();

			if (Controller.detail.isVisible() != true)
				Controller.detail.setVisible(true);

		}
	}

	/*
	 * STATIC METHODS
	 */
	public static NPCTablePane build(List<DnDCharacter> list) {
		NPCTablePane pane = new NPCTablePane();

		//
		pane.setLayout(new BorderLayout(5, 5));

		// setup model
		pane.setTableModel(new NPCTableModel());
		pane.tableModel.addAll(list);

		// setup table
		pane.setNpcTable(new JTable(pane.tableModel));
		pane.getNpcTable().setRowSorter(new TableRowSorter<>(pane.npcTable.getModel()));
		pane.getNpcTable().getSelectionModel().addListSelectionListener(e -> pane.launchCharacterDetail());

		pane.setScrollPane(new JScrollPane(pane.npcTable));
		pane.add(pane.scrollPane);

		// panel for additional components (when desired)
		JPanel southPanel = new JPanel();
		JButton partyButton = new JButton("Add to Party");
		JButton rerollButton = new JButton("Roll New Characters");
		JButton clearButton = new JButton("Clear Characters");

		southPanel.add(partyButton);
		partyButton.addActionListener(e -> pane.addToParty());
		southPanel.add(rerollButton);
		rerollButton.addActionListener(e -> pane.tableModel.addAll(Controller.rollCharacters()));
		southPanel.add(clearButton);
		clearButton.addActionListener(e -> pane.clearCharacterDetail());

		// adds the southern panel
		pane.add(southPanel, BorderLayout.SOUTH);

		return pane;
	}

}
