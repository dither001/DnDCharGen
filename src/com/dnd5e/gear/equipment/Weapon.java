package com.dnd5e.gear.equipment;

import java.util.HashMap;

import com.dnd5e.definitions.*;
import com.dnd5e.gear.definitions.*;
import com.dnd5e.util.FileLoader;

public class Weapon extends Tool implements Armable {
	private static HashMap<Skill, Weapon> weaponMap;
	
	static {
		weaponMap = FileLoader.parseWeapons("weapons.csv");
		
	}
	
	/*
	 * INSTANCE FIELDS
	 */
	private int[] damageDice;
	private Energy damageType;
	private WeaponTrait[] traits;

	public Weapon() {
		super();
		this.damageDice = new int[] { 1, 1 };
		this.damageType = Energy.BLUDGEONING;
		this.traits = new WeaponTrait[0];
	}

	/*
	 * INSTANCE METHODS
	 */
	@Override
	public int[] getDamageDice() {
		return damageDice;
	}

	@Override
	public void setDamageDice(int[] damageDice) {
		this.damageDice = damageDice;
	}

	@Override
	public Energy getDamageType() {
		return damageType;
	}

	@Override
	public void setDamageType(Energy damageType) {
		this.damageType = damageType;
	}

	@Override
	public WeaponTrait[] getTraits() {
		return traits;
	}

	@Override
	public void setTraits(WeaponTrait[] traits) {
		this.traits = traits;
	}
	
	/*
	 * 
	 */
	public static void mapSize() {
		System.out.println(weaponMap.size());
	}
}
