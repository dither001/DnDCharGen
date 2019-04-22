package model;

import com.dnd5e.dungeons.*;

@SuppressWarnings("serial")
public class RoomViewerModel extends EntityTableModel<Chamber> {

	/*
	 * ATTRIBUTES
	 */
	private final Attribute<String> NAME = new Attribute<>("Name", String.class, Chamber::toString);

	/*
	 * CONSTRUCTORS
	 */
	@SuppressWarnings("unchecked")
	public RoomViewerModel() {
		setColumns(NAME);
	}
}
