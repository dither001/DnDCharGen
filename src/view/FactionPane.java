package view;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;

import com.dnd5e.factions.*;

import controller.*;
import model.*;

@SuppressWarnings("serial")
public class FactionPane extends TablePane<Warband> {

	/*
	 * CONSTRUCTORS
	 */
	private FactionPane() {
		// TODO

	}

	private void launchCharacterDetail() {
		StringBuilder sb = null;

		int index = table.getSelectedRow();
		if (index >= 0)
			sb = model.getInstance(table.convertRowIndexToModel(index)).memberList();

		if (table.getRowCount() > 0) {
			JTextPane panel = new JTextPane();
			panel.setText(sb.toString());

			Controller.detail.setContentPane(panel);
			Controller.detail.revalidate();

			if (Controller.detail.isVisible() != true)
				Controller.detail.setVisible(true);

		}
	}

	public void updateContents() {
		removeAll();

		setModel(new FactionTableModel());
		getModel().addAll(Controller.getFactions());

		setTable(new JTable(getModel()));
		table.getSelectionModel().addListSelectionListener(e -> launchCharacterDetail());

		setScrollpane(new JScrollPane(table));
		add(new JScrollPane(getTable()));
	}

	/*
	 * STATIC METHODS
	 */
	public static FactionPane build() {
		FactionPane pane = new FactionPane();
		pane.setLayout(new BorderLayout(5, 5));

		//
		pane.setModel(new FactionTableModel());
		pane.setTable(new JTable(pane.getModel()));
		pane.setContents(Controller.getFactions());

		//
		pane.table.getSelectionModel().addListSelectionListener(e -> pane.launchCharacterDetail());

		//
		pane.getModel().addAll(pane.getContents());
		pane.setScrollpane(new JScrollPane(pane.getTable()));
		pane.add(pane.getScrollpane());

		return pane;
	}
}