package com.dnd5e.equipment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.dnd4e.definitions.*;
import com.dnd5e.characters.*;
import com.dnd5e.definitions.combat.*;
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
		list.addAll(spellbookList);
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
	 * COMBAT RELATED INVENTORY
	 */
	public List<Attack> weaponAttackList() {
		List<Attack> list = new ArrayList<Attack>();

		for (Weapon el : weaponList)
			list.add(BasicAttack.build(el, owner));

		return list;
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
	public boolean addArmorHelper(Skill skill) {
		return armorList.add(Armor.getArmorClone(skill));
	}

	public boolean addShieldHelper() {
		return shieldList.add(Shield.get(Skill.SHIELD));
	}

	public boolean addWeaponHelper(Skill skill) {
		// OVERLOADS addWeapon()
		return addWeaponHelper(1, skill);
	}

	public boolean addWeaponHelper(int quantity, Skill skill) {
		boolean added = false;
		Weapon weapon = Weapon.get(skill);

		if (weapon.getIsStackable()) {
			// stack the stackable
			int index = containsWeapon(skill);

			if (index >= 0) {
				added = true;
				Weapon w = weaponList.get(index);
				int q = w.getQuantity();
				w.setQuantity(quantity + q);
			} else {
				added = true;
				added = weaponList.add(weapon);
				weapon.setQuantity(quantity);
			}

		} else {
			// else, simply add
			added = true;
			for (int i = 0; i < quantity; ++i)
				added = weaponList.add(weapon);
		}

		return added;
	}

	public boolean addGear(Tool tool) {
		boolean added = false;

		if (tool.getIsStackable()) {
			int index = containsGear(tool.name);

			if (index >= 0) {
				added = true;
				Tool w = gearList.get(index);
				int q = w.getQuantity();
				w.setQuantity(tool.getQuantity() + q);
			} else {
				added = gearList.add(tool);
			}
		}
	}

	public boolean addGearHelper(int quantity, String s) {
		boolean added = false;
		Tool tool = Tool.get(s);

		// FIXME
		if (tool.getIsStackable()) {
			// stack the stackable
			int index = containsGear(tool.name);

			if (index >= 0) {
				added = true;
				Tool w = gearList.get(index);
				int q = w.getQuantity();
				w.setQuantity(quantity + q);
			} else {
				added = gearList.add(tool);
				tool.setQuantity(quantity);
			}

		} else {
			// else, simply add
			added = true;
			for (int i = 0; i < quantity; ++i)
				added = gearList.add(tool);
		}

		if (!(added))
			System.out.println("Failed to add");
		return added;
	}

	@SuppressWarnings("incomplete-switch")
	public void addAmmunition(Skill weapon) {
		switch (weapon) {
		case BLOWGUN:
			addGearHelper(50, "blowgun needle");
			break;
		case HAND_CROSSBOW:
		case HEAVY_CROSSBOW:
		case LIGHT_CROSSBOW:
			addGearHelper(20, "crossbow bolt");
			break;
		case LONGBOW:
		case SHORTBOW:
			addGearHelper(20, "arrow");
			break;
		case SLING:
			addGearHelper(20, "sling bullet");
			break;
		}
	}

	/*
	 * RANDOM METHODS
	 */

	public void randomSimpleWeapon() {
		Skill weapon = Skill.randomSimpleWeapon();
		if (weapon.equals(Skill.DART) != true)
			addWeaponHelper(weapon);

		if (weapon.usesAmmunition())
			addAmmunition(weapon);
	}

	public void randomMilitaryWeapon() {
		Skill weapon = Skill.randomMilitaryWeapon();
		addWeaponHelper(weapon);

		if (weapon.usesAmmunition())
			addAmmunition(weapon);
	}

	public void randomArtisanTool() {
		List<Skill> list = Misc.filterSetFor(Skill.getProfessionalSkillsList(), owner.getSpecialSkills());
		if (list.size() > 0)
			addGearHelper(1, Misc.randomFromList(list).name().replace("_", " ").toLowerCase());
	}

	public void randomInstrument() {
		List<Skill> list = Misc.filterSetFor(Skill.getInstrumentSkillsList(), owner.getSpecialSkills());
		if (list.size() > 0)
			addGearHelper(1, Misc.randomFromList(list).name().replace("_", " ").toLowerCase());
	}
}
