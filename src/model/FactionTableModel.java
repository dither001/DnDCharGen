package model;

import com.dnd5e.factions.Warband;

@SuppressWarnings("serial")
public class FactionTableModel extends EntityTableModel<Warband> {

	/*
	 * ATTRIBUTES
	 */
	private final Attribute<String> NAME = new Attribute<>("Name", String.class, Warband::getName);

	/*
	 * CONSTRUCTORS
	 */
	@SuppressWarnings("unchecked")
	public FactionTableModel() {
		setColumns(NAME);
	}
}
