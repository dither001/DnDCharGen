package view;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import model.EntityTableModel;

@SuppressWarnings("serial")
public class TablePane<T> extends JPanel {

	/*
	 * INSTANCE FIELDS
	 */
	protected EntityTableModel<T> model;
	protected JTable table;
	protected JScrollPane scrollpane;
	private TableRowSorter<TableModel> rowSorter;

	protected List<T> contents;

	/*
	 * CONSTRUCTORS
	 */
	public EntityTableModel<T> getModel() {
		return model;
	}

	public void setModel(EntityTableModel<T> model) {
		this.model = model;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public TableRowSorter<TableModel> getRowSorter() {
		return rowSorter;
	}

	public void setRowSorter(TableRowSorter<TableModel> rowSorter) {
		this.rowSorter = rowSorter;
	}

	public List<T> getContents() {
		return contents;
	}

	public void setContents(List<T> contents) {
		this.contents = contents;
	}

	public JScrollPane getScrollpane() {
		return scrollpane;
	}

	public void setScrollpane(JScrollPane scrollpane) {
		this.scrollpane = scrollpane;
	}

	/*
	 * STATIC METHODS
	 */
	public static <T> TablePane<T> build(EntityTableModel<T> model, List<T> contents) {
		TablePane<T> pane = new TablePane<T>();

		// set model, table, & contents
		pane.setModel(model);
		pane.setTable(new JTable(model));
		pane.setContents(contents);
		pane.getTable().setRowSorter(new TableRowSorter<>(pane.getTable().getModel()));

		// add contents to model & pane
		pane.getModel().addAll(contents);
		pane.setScrollpane(new JScrollPane(pane.getTable()));
		pane.add(pane.getScrollpane());

		return pane;
	}
}
