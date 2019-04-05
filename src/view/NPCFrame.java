package view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.dnd5e.character.definitions.*;

import model.*;

@SuppressWarnings("serial")
public class NPCFrame extends JFrame {
	/*
	 * STATIC FIELDS
	 */
	private static final int NPCS_TO_ROLL;

	static {
		NPCS_TO_ROLL = 25;
	}

	/*
	 * INSTANCE FIELDS
	 */
	private NPCTableModel tableModel;
	private JTable npcTable;
	private TableRowSorter<TableModel> rowSorter;

	/*
	 * CONSTRUCTORS
	 */
	public NPCFrame() {
		super("Character Generator");
		setLayout(new BorderLayout(5, 5));
		tableModel = new NPCTableModel();

		// adds characters to model
		List<DnDCharacter> list = rollNewCharacters(NPCS_TO_ROLL);
		tableModel.addAll(list);

		// hands model off to table
		npcTable = new JTable(tableModel);
		rowSorter = new TableRowSorter<>(npcTable.getModel());
		npcTable.setRowSorter(rowSorter);

		add(new JScrollPane(npcTable), BorderLayout.CENTER);

		// panel for additional components (when desired)
		// JPanel sortPanel = new JPanel();

		// adds the southern panel
		// add(sortPanel, BorderLayout.SOUTH);

		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private static List<DnDCharacter> rollNewCharacters(int n) {
		List<DnDCharacter> list = new ArrayList<DnDCharacter>(n);
		for (int i = 0; i < n; ++i)
			list.add(DnDCharacter.random());

		return list;
	}

}
