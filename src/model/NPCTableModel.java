package model;

import com.dnd5e.character.definitions.*;
import com.dnd5e.definitions.*;

@SuppressWarnings("serial")
public class NPCTableModel extends EntityTableModel<DnDCharacter> {

	/*
	 * ATTRIBUTES
	 */
	public final Attribute<String> NAME = new Attribute<>("Name", String.class, DnDCharacter::getName);
	public final Attribute<Integer> LVL = new Attribute<>("Level", Integer.class, DnDCharacter::getLevel);

	public final Attribute<Alignment> ALI = new Attribute<>("Alignment", Alignment.class, DnDCharacter::getAlignment);
	public final Attribute<Background> BGD = new Attribute<>("Background", Background.class,
			DnDCharacter::getBackground);
	public final Attribute<Race> RACE = new Attribute<>("Race", Race.class, DnDCharacter::getRace);
	public final Attribute<DnDClass> JOB = new Attribute<>("Class", DnDClass.class, DnDCharacter::getJob);
	public final Attribute<Subclass> SUB = new Attribute<>("Subclass", Subclass.class, DnDCharacter::getSubclass);

	public final Attribute<Integer> STR = new Attribute<>("Strength", Integer.class, DnDCharacter::getStrength);
	public final Attribute<Integer> DEX = new Attribute<>("Dexterity", Integer.class, DnDCharacter::getDexterity);
	public final Attribute<Integer> CON = new Attribute<>("Constitution", Integer.class, DnDCharacter::getConstitution);
	public final Attribute<Integer> INT = new Attribute<>("Intelligence", Integer.class, DnDCharacter::getIntelligence);
	public final Attribute<Integer> WIS = new Attribute<>("Wisdom", Integer.class, DnDCharacter::getWisdom);
	public final Attribute<Integer> CHA = new Attribute<>("Charisma", Integer.class, DnDCharacter::getCharisma);

	/*
	 * CONSTRUCTORS
	 */
	@SuppressWarnings("unchecked")
	public NPCTableModel() {
		setColumns(NAME, LVL, ALI, RACE, SUB, JOB, BGD, STR, DEX, CON, INT, WIS, CHA);
	}
}
