package com.dnd5e.equipment;

import java.util.HashMap;

import com.dnd5e.characters.*;
import com.dnd5e.definitions.gear.*;
import com.dnd5e.definitions.skills.Skill;

public class Armor extends Tool implements Wearable, Cloneable {
	private static HashMap<Skill, Armor> armorMap;

	static {
		armorMap = new HashMap<Skill, Armor>();
	}

	/*
	 * INSTANCE FIELDS
	 */
	protected int armorClass;
	protected int dexterityBonus;

	public Armor() {
		super();
		this.armorClass = 10;
		this.dexterityBonus = 10;
	}

	/*
	 * INSTANCE METHODS
	 */
	@Override
	public Object clone() {
		Armor armor = new Armor();

		armor.setName(name);
		armor.setMaterial(material);
		armor.setCostCP(cost);
		armor.setWeightOz(weight);

		armor.setIsStackable(isStackable);
		armor.setQuantity(quantity);
		armor.setSizeOfStack(sizeOfStack);

		armor.setHanded(handed);
		armor.setSkills(skills);

		armor.setArmorClass(armorClass);
		armor.setDexterityBonus(dexterityBonus);

		return armor;
	}

	@Override
	public int getArmorClass() {
		return armorClass;
	}

	@Override
	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
	}

	@Override
	public int getDexterityBonus() {
		return dexterityBonus;
	}

	@Override
	public void setDexterityBonus(int dexterityBonus) {
		this.dexterityBonus = dexterityBonus;
	}

	/*
	 * STATIC METHODS
	 */
	public static Armor getArmorClone(Skill skill) {
		return (Armor) armorMap.get(skill).clone();
	}

	public static void setupArmor(HashMap<Skill, Armor> armorMap) {
		Armor.armorMap = armorMap;
	}
}
