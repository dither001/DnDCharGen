package com.dnd5e.gear.equipment;

import java.util.HashMap;

import com.dnd5e.definitions.*;
import com.dnd5e.gear.definitions.*;
import com.dnd5e.util.*;

public class Armor extends Tool implements Wearable, Cloneable {
	private static HashMap<Skill, Armor> armorMap;
	
	static {
		armorMap = FileLoader.parseArmor("armor.csv");
		System.out.println(armorMap.size());
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
}
