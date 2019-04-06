package view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SingleSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.dnd5e.character.definitions.*;

import model.*;

@SuppressWarnings("serial")
public class NPCFrame extends JFrame {
	private static NPCDetailFrame detail;
	private static JPanel panel;
	private static JLabel label;
	private static JTextPane pane;

	private static NPCTableModel tableModel;
	private static JTable npcTable;
	private static TableRowSorter<TableModel> rowSorter;

	private static boolean isDetailOpen;

	/*
	 * STATIC FIELDS
	 */
	private static final int NPCS_TO_ROLL;

	static {
		NPCS_TO_ROLL = 25;
		detail = new NPCDetailFrame();
	}

	/*
	 * CONSTRUCTORS
	 */
	public NPCFrame() {
		super("Character Generator");
		setLayout(new BorderLayout(5, 5));
		tableModel = new NPCTableModel();

		// adds characters to model
		tableModel.addAll(rollCharacters(NPCS_TO_ROLL));

		// hands model off to table
		npcTable = new JTable(tableModel);
		rowSorter = new TableRowSorter<>(npcTable.getModel());
		npcTable.setRowSorter(rowSorter);
		npcTable.getSelectionModel().addListSelectionListener(e -> launchCharacterDetail(e));

		add(new JScrollPane(npcTable), BorderLayout.CENTER);

		// panel for additional components (when desired)
		JPanel sortPanel = new JPanel();
		JButton rerollButton = new JButton("Roll New Characters");
		JButton clearButton = new JButton("Clear Characters");
		// JButton inspectButton = new JButton("Inspect Character");

		sortPanel.add(rerollButton);
		rerollButton.addActionListener(e -> tableModel.addAll(rollCharacters(NPCS_TO_ROLL)));
		sortPanel.add(clearButton);
		clearButton.addActionListener(e -> clearCharacterDetail());
		// sortPanel.add(inspectButton);
		// inspectButton.addActionListener(e -> launchCharacterDetail(e));

		// adds the southern panel
		add(sortPanel, BorderLayout.SOUTH);

		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void detailCloseEvent() {
		isDetailOpen = false;
	}

	/*
	 * PRIVATE METHODS
	 */
	private static void launchCharacterDetail(ListSelectionEvent e) {
		if (npcTable.getRowCount() > 0) {
			if (detail.isVisible()) {
				StringBuilder sb = new StringBuilder();
				sb.append(tableModel.getInstance(npcTable.getSelectedRow()).toStringVerbose());

				pane.setText(sb.toString());
				detail.setContentPane(pane);

			} else {
				detail = new NPCDetailFrame();

				StringBuilder sb = new StringBuilder();
				sb.append(tableModel.getInstance(npcTable.getSelectedRow()).toStringVerbose());

				pane = new JTextPane();
				pane.setText(sb.toString());

				detail.setContentPane(pane);
				detail.setVisible(true);

			}

		}
	}

	private static void clearCharacterDetail() {
		detail.setVisible(false);
		detail = new NPCDetailFrame();
		tableModel.clearInstances();
	}

	private static List<DnDCharacter> rollCharacters(int n) {
		List<DnDCharacter> list = new ArrayList<DnDCharacter>(n);
		for (int i = 0; i < n; ++i)
			list.add(DnDCharacter.random());

		return list;
	}
}
