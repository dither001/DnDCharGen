package com.dnd5e.gear.equipment;

import java.util.EnumSet;

import com.dnd5e.character.classes.*;
import com.dnd5e.character.definitions.*;
import com.dnd5e.definitions.*;
import com.miscellaneous.util.*;

public abstract class InventoryBuilder {

	/*
	 * 
	 */
	public static void setupStartingGear(Creature owner) {
		if (owner.getClass().equals(DnDCharacter.class)) {
			DnDCharacter actor = (DnDCharacter) owner;
			EnumSet<Skill> skills = actor.getCommonSkills();
			Inventory inv = actor.getInventory();

			int dice, strength, dexterity;
			DnDClass job = actor.getJob();
			switch (job) {
			case BARBARIAN:

				// FIRST CHOICE
//				dice = Dice.roll(2);
//				if (actor.isMedium() && dice == 1) {
//					inv.addWeapon(Skill.GREATAXE);
//				} else {
//					inv.addWeapon(Skill.randomMilitaryMelee());
//				}
//
//				// SECOND CHOICE
//				dice = Dice.roll(2);
//				if (dice == 1) {
//					inv.addWeapon(Skill.HANDAXE);
//					inv.addWeapon(Skill.HANDAXE);
//				} else {
//					inv.addWeapon(Skill.randomSimpleWeapon());
//				}
//
//				// TODO - add explorer's pack
//
//				// 4 javelins
//				inv.addWeapon(4, Skill.JAVELIN);

				break;
			case BARD:

				// FIRST CHOICE
				dice = Dice.roll(3);
				if (dice == 1) {
					inv.addWeapon(Skill.RAPIER);
				} else if (dice == 2) {
					inv.addWeapon(Skill.LONGSWORD);
				} else {
					// random simple weapon
					inv.addWeapon(Skill.randomSimpleWeapon());
				}

				// TODO - add diplomat's or entertainer's pack
				// TODO - add lute or any instrument

				// leather armor + dagger
				inv.addArmor(Skill.LEATHER_ARMOR);
				inv.addWeapon(Skill.DAGGER);

				break;
			case CLERIC:
				strength = actor.getStrength();
				dexterity = actor.getDexterity();

				// FIRST CHOICE
				if (skills.contains(Skill.WARHAMMER)) {
					inv.addWeapon(Skill.WARHAMMER);
				} else {
					inv.addWeapon(Skill.MACE);
				}

				// SECOND CHOICE
				if (dexterity > 15) {
					inv.addArmor(Skill.LEATHER_ARMOR);
				} else if (skills.contains(Skill.CHAIN_MAIL) && strength > 12) {
					inv.addArmor(Skill.CHAIN_MAIL);
				} else {
					inv.addArmor(Skill.SCALE_MAIL);
				}

				// THIRD CHOICE
				dice = Dice.roll(2);
				if (dice == 1) {
					inv.addWeapon(Skill.LIGHT_CROSSBOW);
					inv.addAmmunition(Skill.LIGHT_CROSSBOW);
				} else {
					inv.randomSimpleHelper();
				}

				// TODO - add priest's or explorer's pack
				// TODO - receive shield + holy symbol
				inv.addShield();

				break;
			case DRUID:

				// FIRST CHOICE
				dice = Dice.roll(2);
				if (dice == 1) {
					inv.randomSimpleHelper();
				} else {
					inv.addShield();
				}

				// SECOND CHOICE
				dice = Dice.roll(2);
				if (dice == 1) {
					inv.addWeapon(Skill.SCIMITAR);
				} else {
					inv.addWeapon(Skill.randomSimpleMelee());
				}

				// TODO - receive explorer's pack + druid focus
				inv.addArmor(Skill.LEATHER_ARMOR);

				break;
			case FIGHTER:
				strength = actor.getStrength();
				dexterity = actor.getDexterity();

				// FIRST CHOICE
				if (strength < 13 || dexterity > 15) {
					inv.addArmor(Skill.LEATHER_ARMOR);
					inv.addWeapon(Skill.LONGBOW);
					inv.addAmmunition(Skill.LONGBOW);
				} else {
					inv.addArmor(Skill.CHAIN_MAIL);
				}

				// SECOND CHOICE
				dice = Dice.roll(2);
				if (dice == 1) {
					inv.randomMilitaryHelper();
					inv.addShield();
				} else {
					inv.randomSimpleHelper();
				}

				// THIRD CHOICE
				dice = Dice.roll(2);
				if (dice == 1) {
					inv.addWeapon(Skill.LIGHT_CROSSBOW);
					inv.addAmmunition(Skill.LIGHT_CROSSBOW);
				} else {
					inv.addWeapon(Skill.HANDAXE);
					inv.addWeapon(Skill.HANDAXE);
				}

				// TODO - add dungeoneer's or explorer's pack

				break;
			case MONK:

				// FIRST CHOICE
				dice = Dice.roll(2);
				if (dice == 1) {
					inv.addWeapon(Skill.SHORTSWORD);
				} else {
					inv.randomSimpleHelper();
				}

				// TODO - add dungeoneer's or explorer's pack
				// TODO - receive 10 darts
				inv.addAmmunition(Skill.DART);

				break;
			case PALADIN:

				// FIRST CHOICE
				dice = Dice.roll(2);
				if (dice == 1) {
					inv.randomMilitaryHelper();
					inv.addShield();
				} else {
					inv.randomMilitaryHelper();
					inv.randomMilitaryHelper();
				}

				// SECOND CHOICE
				dice = Dice.roll(2);
				if (dice == 1) {
					inv.addWeapon(5, Skill.JAVELIN);
				} else {
					inv.randomSimpleHelper();
				}

				// TODO - add priest's or explorer's pack
				// TODO - receive holy symbol
				inv.addArmor(Skill.CHAIN_MAIL);

				break;
			case RANGER:
				dexterity = actor.getDexterity();

				// FIRST CHOICE
				if (dexterity > 15) {
					inv.addArmor(Skill.LEATHER_ARMOR);
				} else {
					inv.addArmor(Skill.SCALE_MAIL);
				}

				dice = Dice.roll(2);
				if (dice == 1) {
					inv.addWeapon(Skill.SHORTSWORD);
					inv.addWeapon(Skill.SHORTSWORD);
				} else {
					inv.randomSimpleHelper();
					inv.randomSimpleHelper();
				}

				// THIRD CHOICE
				// TODO - add dungeoneer's or explorer's pack

				// TODO - receive longbow + 20 arrows
				inv.addWeapon(Skill.LONGBOW);
				inv.addAmmunition(Skill.LONGBOW);

				break;
			case ROGUE:

				// FIRST CHOICE
				dice = Dice.roll(2);
				if (dice == 1) {
					inv.addWeapon(Skill.RAPIER);
				} else {
					inv.addWeapon(Skill.SHORTSWORD);
				}

				// SECOND CHOICE
				dice = Dice.roll(2);
				if (dice == 1) {
					inv.addWeapon(Skill.SHORTBOW);
					inv.addAmmunition(Skill.SHORTBOW);
				} else {
					inv.addWeapon(Skill.SHORTSWORD);
				}

				// TODO - add burglar's or dungeoneer's or explorer's pack
				// TODO - receive thieves' tool
				inv.addArmor(Skill.LEATHER_ARMOR);
				inv.addWeapon(Skill.DAGGER);
				inv.addWeapon(Skill.DAGGER);

				break;
			case SORCERER:

				// FIRST CHOICE
				dice = Dice.roll(2);
				if (dice == 1) {
					inv.addWeapon(Skill.LIGHT_CROSSBOW);
					inv.addAmmunition(Skill.LIGHT_CROSSBOW);
				} else {
					inv.randomSimpleHelper();
				}

				// TODO - component pouch or arcane focus
				// TODO - add dungeoneer's or explorer's pack
				inv.addWeapon(Skill.DAGGER);
				inv.addWeapon(Skill.DAGGER);

				break;
			case WARLOCK:

				// FIRST CHOICE
				dice = Dice.roll(2);
				if (dice == 1) {
					inv.addWeapon(Skill.LIGHT_CROSSBOW);
					inv.addAmmunition(Skill.LIGHT_CROSSBOW);
				} else {
					inv.randomSimpleHelper();
				}

				// TODO - component pouch or arcane focus
				// TODO - add dungeoneer's or scholar's pack
				inv.addArmor(Skill.LEATHER_ARMOR);
				inv.randomSimpleHelper();
				inv.addWeapon(Skill.DAGGER);
				inv.addWeapon(Skill.DAGGER);

				break;
			case WIZARD:

				// FIRST CHOICE
				dice = Dice.roll(2);
				if (dice == 1) {
					inv.addWeapon(Skill.QUARTERSTAFF);
				} else {
					inv.addWeapon(Skill.DAGGER);
				}

				// TODO - component pouch or arcane focus
				// TODO - add scholar's or explorer's pack
				// TODO - receive spellbook

				break;
			}

			actor.setInventory(inv);
		}

	}

}
