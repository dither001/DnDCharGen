package model;

import com.dnd5e.dungeons.*;

@SuppressWarnings("serial")
public class DungeonFloorModel extends EntityTableModel<Floor> {

	/*
	 * ATTRIBUTES
	 */
	public final Attribute<String> NAME = new Attribute<>("Name", String.class, Floor::toString);

	/*
	 * CONSTRUCTORS
	 */
	@SuppressWarnings("unchecked")
	public DungeonFloorModel() {
		setColumns(NAME);
	}
}
