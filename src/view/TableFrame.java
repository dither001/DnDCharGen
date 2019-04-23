package view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.*;

@SuppressWarnings("serial")
public class TableFrame<T> extends JFrame {
	/*
	 * INSTANCE FIELDS
	 */
	private EntityTableModel<T> model;
	private JTable table;

	private List<T> contents;

	/*
	 * CONSTRUCTORS
	 */
	private TableFrame() {
		super("Default Title");
	}

	public EntityTableModel<T> getTableModel() {
		return model;
	}

	public void setTableModel(EntityTableModel<T> model) {
		this.model = model;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public List<T> getTableContents() {
		return contents;
	}

	public void setTableContents(List<T> contents) {
		this.contents = contents;
	}

	/*
	 * STATIC METHODS
	 */
	public static <T> TableFrame<T> build(EntityTableModel<T> model, List<T> contents) {
		TableFrame<T> frame = new TableFrame<T>();

		// initialize
		frame.setLayout(new BorderLayout(5, 5));

		// set model, table, & contents
		JTable table = new JTable(model);
		frame.setTableModel(model);
		frame.setTable(table);
		frame.setTableContents(contents);

		// pass contents to model & add to frame
		frame.getTableModel().addAll(contents);
		frame.add(new JScrollPane(table), BorderLayout.CENTER);

		// finalize
		frame.pack();
		frame.setDefaultCloseOperation(HIDE_ON_CLOSE);

		return frame;
	}
}
