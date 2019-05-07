package com.dnd5e.equipment;

import java.util.HashMap;

import com.dnd5e.definitions.gear.*;
import com.dnd5e.definitions.rules.*;
import com.dnd5e.definitions.skills.Skill;

public class Weapon extends Tool implements Armable, Cloneable {
	private static HashMap<Skill, Weapon> weaponMap;

	static {
		weaponMap = new HashMap<Skill, Weapon>();
	}
	
	/*
	 * INSTANCE FIELDS
	 */
	protected int meleeRange;
	protected int thrownRange;
	protected int missileRange;

	protected int[] damageDice;
	protected EnergyType damageType;
	protected WeaponTrait[] traits;

	public Weapon() {
		super();
		this.meleeRange = 1;
		this.thrownRange = 4;
		this.missileRange = -1;

		this.damageDice = new int[] { 1, 4 };
		this.damageType = EnergyType.BLUDGEONING;
		this.traits = new WeaponTrait[] { WeaponTrait.IMPROVISED };
	}

	/*
	 * 
	 */
	public String toStringVerbose() {
		String dice = damageDice[0] + "d" + damageDice[1];

		String t = traits.length > 0 ? "[" : "";
		for (int i = 0; i < traits.length; ++i) {
			t += traits[i];
			if (i+1 < traits.length)
				t += ", ";
		}
		t += traits.length > 0 ? "]" : "";

		return String.format("%s %s %s %s", name, dice, damageType.toString(), t);
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

		// weapon traits
		WeaponTrait[] t = new WeaponTrait[traits.length];
		for (int i = 0; i < traits.length; ++i)
			t[i] = traits[i];

		weapon.setTraits(t);

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
		this.damageDice[0] = damageDice[0];
		this.damageDice[1] = damageDice[1];
	}

	@Override
	public EnergyType getDamageType() {
		return damageType;
	}

	@Override
	public void setDamageType(EnergyType damageType) {
		this.damageType = damageType;
	}

	@Override
	public WeaponTrait[] getTraits() {
		return traits;
	}

	@Override
	public void setTraits(WeaponTrait[] traits) {
		WeaponTrait[] t = new WeaponTrait[traits.length];
		for (int i = 0; i < traits.length; ++i)
			t[i] = traits[i];

		this.traits = t;
	}

	/*
	 * STATIC METHODS
	 */
	public static Weapon get(Skill skill) {
		return (Weapon) weaponMap.get(skill).clone();
	}

	public static void setupWeapons(HashMap<Skill, Weapon> weaponMap) {
		Weapon.weaponMap = weaponMap;
	}
	
	public static int mapSize() {
		return weaponMap.size();
	}
}
