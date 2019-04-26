package model;

import com.dnd5e.factions.*;

@SuppressWarnings("serial")
public class FactionTableModel extends EntityTableModel<Warband> {

	/*
	 * ATTRIBUTES
	 */
	private final Attribute<String> NAME = new Attribute<>("Name", String.class, Warband::getName);
	private final Attribute<String> FACE = new Attribute<>("Leader", String.class, Warband::getLeaderName);
	private final Attribute<Integer> SIZE = new Attribute<>("Size", Integer.class, Warband::size);

	/*
	 * CONSTRUCTORS
	 */
	@SuppressWarnings("unchecked")
	public FactionTableModel() {
		setColumns(NAME, FACE, SIZE);
	}
}
