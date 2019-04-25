package model;

@SuppressWarnings("serial")
public class StringTableModel extends EntityTableModel<String> {

	/*
	 * ATTRIBUTES
	 */
	private final Attribute<String> columnName;

	/*
	 * CONSTRUCTORS
	 */
	@SuppressWarnings("unchecked")
	public StringTableModel(String name) {
		columnName = new Attribute<String>(name, String.class, String::toString);

		//
		setColumns(columnName);
	}

}
