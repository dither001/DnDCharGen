package com.dnd5e.gear.equipment;

import java.util.HashMap;

import com.dnd5e.definitions.*;
import com.dnd5e.gear.definitions.*;
import com.miscellaneous.util.FileLoader;

public class Weapon extends Tool implements Armable, Cloneable {
	private static HashMap<Skill, Weapon> weaponMap;

	static {
		weaponMap = FileLoader.parseWeapons("weapons.csv");
	}

	/*
	 * INSTANCE FIELDS
	 */
	protected int meleeRange;
	protected int thrownRange;
	protected int missileRange;

	protected int[] damageDice;
	protected Energy damageType;
	protected WeaponTrait[] traits;

	public Weapon() {
		super();
		this.meleeRange = 1;
		this.thrownRange = 4;
		this.missileRange = -1;
	
		this.damageDice = new int[] { 1, 4 };
		this.damageType = Energy.BLUDGEONING;
		this.traits = new WeaponTrait[] { WeaponTrait.IMPROVISED };
	}

	/*
	 * CLONE
	 */
	@Override
	public Object clone() {
		Weapon weapon = new Weapon();

		weapon.setName(name);
		weapon.setMaterial(material);
		weapon.setCostCP(cost);
		weapon.setWeightOz(weight);

		weapon.setIsStackable(isStackable);
		weapon.setQuantity(quantity);
		weapon.setSizeOfStack(sizeOfStack);

		weapon.setHanded(handed);
		weapon.setSkills(skills);

		weapon.setMeleeRange(meleeRange);
		weapon.setThrownRange(thrownRange);
		weapon.setMissileRange(missileRange);

		weapon.setDamageDice(damageDice);
		weapon.setDamageType(damageType);
		weapon.setTraits(traits);

		return weapon;
	}

	/*
	 * INSTANCE METHODS
	 */
	@Override
	public int getMeleeRange() {
		return meleeRange;
	}

	@Override
	public void setMeleeRange(int meleeRange) {
		this.meleeRange = meleeRange;
	}

	@Override
	public int getThrownRange() {
		return thrownRange;
	}

	@Override
	public void setThrownRange(int thrownRange) {
		this.thrownRange = thrownRange;
	}

	@Override
	public int getMissileRange() {
		return missileRange;
	}

	@Override
	public void setMissileRange(int missileRange) {
		this.missileRange = missileRange;
	}

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
	 * STATIC METHODS
	 */
	public static Weapon get(Skill skill) {
		return (Weapon) weaponMap.get(skill).clone();
	}

}
