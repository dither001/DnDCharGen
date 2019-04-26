package model;

import com.dnd5e.factions.*;

@SuppressWarnings("serial")
public class FactionTableModel extends EntityTableModel<Warband> {

	/*
	 * ATTRIBUTES
	 */
	private final Attribute<String> NAME = new Attribute<>("Name", String.class, Warband::getName);
	private final Attribute<String> TYPE = new Attribute<>("Type", String.class, Warband::getPurpose);
	private final Attribute<FactionType> CLAZZ = new Attribute<>("Class", FactionType.class, Warband::getType);

	private final Attribute<String> FACE = new Attribute<>("Leader", String.class, Warband::getLeaderName);
	private final Attribute<Integer> SIZE = new Attribute<>("Size", Integer.class, Warband::size);
	private final Attribute<Foundation> IDEAL = new Attribute<>("Ideal", Foundation.class, Warband::getFoundation);
	private final Attribute<Integer> MORALE = new Attribute<>("Morale", Integer.class, Warband::getMorale);

	/*
	 * CONSTRUCTORS
	 */
	@SuppressWarnings("unchecked")
	public FactionTableModel() {
		setColumns(NAME, TYPE, CLAZZ, FACE, SIZE, IDEAL, MORALE);
	}
}
