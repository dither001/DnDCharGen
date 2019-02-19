package com.dnd5e.gear.equipment;

import java.util.ArrayList;
import java.util.EnumSet;

import com.dnd5e.characters.*;
import com.dnd5e.definitions.*;
import com.dnd5e.util.Dice;

public class Inventory {

	/*
	 * INSTANCE FIELDS
	 */
	protected Creature owner;

	protected ArrayList<Armor> armorList;
	protected ArrayList<Weapon> weaponList;

	public Inventory(Creature owner) {
		this.owner = owner;

		this.armorList = new ArrayList<Armor>();
		this.weaponList = new ArrayList<Weapon>();
	}

	/*
	 * INSTANCE METHODS
	 */
	public ArrayList<Armor> getArmorList() {
		return armorList;
	}

	public ArrayList<Weapon> getWeaponList() {
		return weaponList;
	}

	private boolean addArmor(Skill skill) {
		return armorList.add(Armor.getArmorClone(skill));
	}

	private boolean addWeapon(Skill skill) {
		return weaponList.add(Weapon.getWeaponClone(skill));
	}

	private boolean addWeapon(int quantity, Skill skill) {
		Weapon weapon = Weapon.getWeaponClone(skill);
		weapon.setQuantity(quantity);
		return weaponList.add(weapon);
	}

	/*
	 * STATIC METHODS
	 */
	public static void setupStartingGear(Creature owner) {

		// begin
		if (owner.getClass().equals(DnDCharacter.class)) {
			DnDCharacter actor = (DnDCharacter) owner;
			// EnumSet<Skill> skills = actor.getSkills();
			Inventory inv = actor.getInventory();

			int dice;
			DnDClass job = actor.getJob();
			Armor armor = null;
			Weapon weapon = null;
			switch (job) {
			case BARBARIAN:
				// FIRST CHOICE
				dice = Dice.roll(2);
				if (actor.isMedium() && dice == 1) {
					inv.addWeapon(Skill.GREATAXE);
				} else {
					// random military melee
					inv.addWeapon(Skill.randomMilitaryMelee());
				}

				// SECOND CHOICE
				dice = Dice.roll(2);
				if (dice == 1) {
					inv.addWeapon(Skill.HANDAXE);
					inv.addWeapon(Skill.HANDAXE);
				} else {
					// random simple weapon
					inv.addWeapon(Skill.randomSimpleWeapon());
				}

				break;
			case BARD:
				break;
			case CLERIC:
				break;
			case DRUID:
				break;
			case FIGHTER:
				break;
			case MONK:
				break;
			case PALADIN:
				break;
			case RANGER:
				break;
			case ROGUE:
				break;
			case SORCERER:
				break;
			case WARLOCK:
				break;
			case WIZARD:
				break;
			}

		}

	}
}
