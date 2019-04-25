package model;

import com.dnd5e.characters.*;
import com.dnd5e.definitions.rules.*;
import com.dnd5e.worlds.*;

@SuppressWarnings("serial")
public class PlayerTableModel extends EntityTableModel<DnDCharacter> {

	/*
	 * ATTRIBUTES
	 */
	private final Attribute<String> NAME = new Attribute<>("Name", String.class, DnDCharacter::getName);
	private final Attribute<Integer> EXP = new Attribute<>("EXP", Integer.class, DnDCharacter::getExperience);
	private final Attribute<Integer> LVL = new Attribute<>("Level", Integer.class, DnDCharacter::getLevel);

	//
	private final Attribute<Alignment> ALI = new Attribute<>("Alignment", Alignment.class, DnDCharacter::getAlignment);
	private final Attribute<Race> RACE = new Attribute<>("Race", Race.class, DnDCharacter::getRace);
	private final Attribute<DnDClass> CLAZZ = new Attribute<>("Class", DnDClass.class, DnDCharacter::getJob);
	private final Attribute<Subclass> SUB = new Attribute<>("Subclass", Subclass.class, DnDCharacter::getSubclass);
	private final Attribute<Background> BGD = new Attribute<>("Background", Background.class,
			DnDCharacter::getBackground);
	private final Attribute<God> GOD = new Attribute<>("God", God.class, DnDCharacter::getGod);

	//
	private final Attribute<Integer> STR = new Attribute<>("Strength", Integer.class, DnDCharacter::getStrength);
	private final Attribute<Integer> DEX = new Attribute<>("Dexterity", Integer.class, DnDCharacter::getDexterity);
	private final Attribute<Integer> CON = new Attribute<>("Constitution", Integer.class, DnDCharacter::getConstitution);
	private final Attribute<Integer> INT = new Attribute<>("Intelligence", Integer.class, DnDCharacter::getIntelligence);
	private final Attribute<Integer> WIS = new Attribute<>("Wisdom", Integer.class, DnDCharacter::getWisdom);
	private final Attribute<Integer> CHA = new Attribute<>("Charisma", Integer.class, DnDCharacter::getCharisma);

	/*
	 * CONSTRUCTORS
	 */
	@SuppressWarnings("unchecked")
	public PlayerTableModel() {
		setColumns(NAME, EXP, LVL, ALI, RACE, SUB, CLAZZ, BGD, GOD, STR, DEX, CON, INT, WIS, CHA);
	}

}
