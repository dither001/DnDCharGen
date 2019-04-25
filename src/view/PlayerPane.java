package view;

import java.awt.BorderLayout;
import java.util.EnumSet;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableRowSorter;

import com.dnd5e.characters.*;
import com.dnd5e.worlds.*;

import controller.Controller;
import model.*;

@SuppressWarnings("serial")
public class PlayerPane extends TablePane<DnDCharacter> {

	public void updateContents() {
		removeAll();

		setContents(Controller.getPlayers());
		setModel(new PlayerTableModel());
		getModel().addAll(Controller.getPlayers());
		setTable(new JTable(model));
		getTable().setRowSorter(new TableRowSorter<>(getTable().getModel()));
		setScrollpane(new JScrollPane(table));
		add(scrollpane);

		/*
		 * FIXME - KLUDGE -> need more efficient way to rebuild/re-validate
		 */

		// panel for additional components (when desired)
		JPanel southPanel = new JPanel();
		JButton factionButton = new JButton("Generate Factions");
		factionButton.addActionListener(e -> Controller.generateFactions());

		// finalize southern panel
		southPanel.add(factionButton);
		add(southPanel, BorderLayout.SOUTH);

		revalidate();
		repaint();
	}

	/*
	 * STATIC METHODS
	 */
	public static PlayerPane build(List<DnDCharacter> contents) {
		PlayerPane pane = new PlayerPane();
		pane.setLayout(new BorderLayout(5, 5));

		// set model, table, & contents
		pane.setModel(new PlayerTableModel());
		pane.setTable(new JTable(pane.getModel()));
		pane.setContents(contents);

		// add contents to model & pane
		pane.getModel().addAll(contents);
		pane.setScrollpane(new JScrollPane(pane.getTable()));
		pane.getTable().setRowSorter(new TableRowSorter<>(pane.getTable().getModel()));
		pane.add(pane.getScrollpane());

		// panel for additional components (when desired)
		JPanel southPanel = new JPanel();
		JButton factionButton = new JButton("Generate Factions");
		factionButton.addActionListener(e -> Controller.generateFactions());

		// finalize southern panel
		southPanel.add(factionButton);
		pane.add(southPanel, BorderLayout.SOUTH);

		return pane;
	}
}
