package view;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.dnd5e.factions.*;

import controller.*;
import model.*;

@SuppressWarnings("serial")
public class FactionPane extends TablePane<Warband> {

	/*
	 * CONSTRUCTORS
	 */
	private FactionPane() {

	}

	public void updateContents() {
		removeAll();

		setModel(new FactionTableModel());
		getModel().addAll(Controller.getFactions());

		setTable(new JTable(getModel()));
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
		pane.getModel().addAll(pane.getContents());
		pane.setScrollpane(new JScrollPane(pane.getTable()));
		pane.add(pane.getScrollpane());

		return pane;
	}
}