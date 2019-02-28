package com.dnd5e.gear.equipment;

import java.util.ArrayList;
import java.util.Iterator;

import com.dnd5e.definitions.*;

public class Inventory {

	/*
	 * INSTANCE FIELDS
	 */
	protected Creature owner;

	protected ArrayList<Armor> armorList;
	protected ArrayList<Shield> shieldList;
	protected ArrayList<Weapon> weaponList;

	public Inventory(Creature owner) {
		this.owner = owner;

		this.armorList = new ArrayList<Armor>();
		this.shieldList = new ArrayList<Shield>();
		this.weaponList = new ArrayList<Weapon>();
	}

	/*
	 * INSTANCE METHODS
	 */
	public String toString() {
		String s = "[";

		ArrayList<Item> list = new ArrayList<Item>();
		list.addAll(armorList);
		list.addAll(shieldList);
		list.addAll(weaponList);

		Item item = null;
		int total = 0;
		for (Iterator<Item> it = list.iterator(); it.hasNext();) {
			item = it.next();
			s += item.toString();
			total += item.getWeightOz();

			if (it.hasNext())
				s += ", ";
		}

		total /= 16;
		return s + "] (" + total + " lbs.)";
	}

	/*
	 * 
	 */
	protected int containsWeapon(Skill skill) {
		int index = -1;

		for (int i = 0; i < weaponList.size(); ++i) {
			Skill[] array = weaponList.get(i).getSkills();
			for (Skill el : array) {
				if (el.equals(skill))
					index = i;
			}

			if (index != -1)
				break;
		}

		return index;
	}

	protected ArrayList<Armor> getArmorList() {
		return armorList;
	}

	protected ArrayList<Shield> getShieldList() {
		return shieldList;
	}

	protected ArrayList<Weapon> getWeaponList() {
		return weaponList;
	}

	/*
	 * HELPER METHODS
	 */
	protected boolean addArmor(Skill skill) {
		return armorList.add(Armor.getArmorClone(skill));
	}

	protected boolean addShield() {
		return shieldList.add(Shield.get(Skill.SHIELD));
	}

	protected boolean addWeapon(Skill skill) {
		// OVERLOADS addWeapon()
		return addWeapon(1, skill);
	}

	protected boolean addWeapon(int quantity, Skill skill) {
		boolean added = false;
		Weapon weapon = Weapon.get(skill);

		if (weapon.getIsStackable()) {
			int index = containsWeapon(skill);

			if (index > -1) {
				// stack the stackable
				Weapon w = weaponList.get(index);
				int q = w.getQuantity();
				w.setQuantity(quantity + q);
				added = true;
			} else {
				added = weaponList.add(weapon);
				weapon.setQuantity(quantity);
				added = true;
			}

		} else {
			added = weaponList.add(weapon);
			weapon.setQuantity(quantity);
		}

		return added;
	}

	protected void randomSimpleHelper() {
		Skill weapon = Skill.randomSimpleWeapon();
		if (weapon.equals(Skill.DART) != true)
			addWeapon(weapon);

		if (weapon.usesAmmunition())
			addAmmunition(weapon);
	}

	protected void randomMilitaryHelper() {
		Skill weapon = Skill.randomMilitaryWeapon();
		addWeapon(weapon);

		if (weapon.usesAmmunition())
			addAmmunition(weapon);
	}

	@SuppressWarnings("incomplete-switch")
	protected void addAmmunition(Skill weapon) {
		switch (weapon) {
		case BLOWGUN:
			addWeapon(50, Skill.NEEDLE);
			break;
		case DART:
			addWeapon(10, Skill.DART);
			break;
		case HAND_CROSSBOW:
		case HEAVY_CROSSBOW:
		case LIGHT_CROSSBOW:
			addWeapon(20, Skill.BOLT);
			break;
		case LONGBOW:
		case SHORTBOW:
			addWeapon(20, Skill.ARROW);
			break;
		case SLING:
			addWeapon(20, Skill.BULLET);
			break;
		}
	}
}
