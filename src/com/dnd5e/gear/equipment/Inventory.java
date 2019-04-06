package com.dnd5e.gear.equipment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.dnd4e.definitions.*;
import com.dnd5e.combat.definitions.*;
import com.dnd5e.definitions.*;
import com.dnd5e.magic.*;
import com.miscellaneous.util.*;

public class Inventory {

	/*
	 * INSTANCE FIELDS
	 */
	protected Creature owner;

	protected ArrayList<Armor> armorList;
	protected ArrayList<Shield> shieldList;
	protected ArrayList<Weapon> weaponList;
	protected ArrayList<Spellbook> spellbookList;
	protected ArrayList<Tool> gearList;

	public Inventory(Creature owner) {
		this.owner = owner;

		this.armorList = new ArrayList<Armor>();
		this.shieldList = new ArrayList<Shield>();
		this.weaponList = new ArrayList<Weapon>();

		this.spellbookList = new ArrayList<Spellbook>();
		this.gearList = new ArrayList<Tool>();
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
		list.addAll(gearList);

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
	protected int containsGear(String s) {
		int index = -1;

		for (int i = 0; i < gearList.size(); ++i) {
			for (Tool el : gearList) {
				if (el.getName().equalsIgnoreCase(s))
					index = i;
			}

			if (index != -1)
				break;
		}

		return index;
	}

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

	protected List<Armor> getArmorList() {
		return armorList;
	}

	protected List<Shield> getShieldList() {
		return shieldList;
	}

	protected List<Spellbook> getSpellbookList() {
		return spellbookList;
	}

	protected List<Weapon> getWeaponList() {
		return weaponList;
	}

	/*
	 * SPELLBOOK METHODS
	 */
	public void addSpellbook(Spellbook spellbook) {
		spellbookList.add(spellbook);
	}

	public List<Spell> getSpellbookSpells() throws ItemNotPresentException {
		if (spellbookList.size() > 0) {
			int book = 0;
			return spellbookList.get(book).getSpellsList();
		}

		throw new ItemNotPresentException("spellbook");
	}

	public List<Spell> getSpellbookSpellsByLevel(int level) throws ItemNotPresentException {
		if (spellbookList.size() > 0) {
			int book = 0;
			return spellbookList.get(book).getSpellsOfLevel(level);
		}

		throw new ItemNotPresentException("spellbook");
	}

	public List<Spell>[] getSpellbookSpellsByLevel() throws ItemNotPresentException {
		if (spellbookList.size() > 0) {
			int book = 0;
			return spellbookList.get(book).getSpellsByLevel();
		}

		throw new ItemNotPresentException("spellbook");
	}

	public void updateSpellbook(int[] levels, Spell[] spells) throws ItemNotPresentException {
		if (spellbookList.size() > 0) {
			int book = 0;
			for (int i = 0; i < spells.length; ++i)
				spellbookList.get(book).add(levels[i], spells[i]);
		} else {
			// you can't update a spellbook you don't have
			throw new ItemNotPresentException("spellbook");

		}
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

	protected boolean addGear(int quantity, String s) {
		boolean added = false;
		Tool tool = Tool.get(s);

		// FIXME
		if (tool.getIsStackable()) {
			int index = containsGear(tool.name);

			if (index > -1) {
				// stack the stackable
				Tool w = gearList.get(index);
				int q = w.getQuantity();
				w.setQuantity(quantity + q);
				added = true;
			} else {
				added = gearList.add(tool);
				tool.setQuantity(quantity);
				added = true;
			}

		} else {
			added = gearList.add(tool);
			tool.setQuantity(quantity);
		}

		if (!(added))
			System.out.println("Failed to add");
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
			addGear(50, "blowgun needle");
			break;
		case DART:
			addWeapon(10, Skill.DART);
			break;
		case HAND_CROSSBOW:
		case HEAVY_CROSSBOW:
		case LIGHT_CROSSBOW:
			addGear(20, "crossbow bolt");
			break;
		case LONGBOW:
		case SHORTBOW:
			addGear(20, "arrow");
			break;
		case SLING:
			addGear(20, "sling bullet");
			break;
		}
	}

	/*
	 * 
	 */
	public List<Attack> weaponAttackList() {
		List<Attack> list = new ArrayList<Attack>();

		for (Weapon el : weaponList)
			list.add(BasicAttack.build(el, owner));

		return list;
	}

}
