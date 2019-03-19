package com.dnd5e.gear.equipment;

import java.util.HashMap;

import com.dnd5e.definitions.*;
import com.dnd5e.gear.definitions.*;

public class Shield extends Tool implements Armable, Cloneable, Wearable {
	private static HashMap<Skill, Shield> shieldMap;

	static {
		shieldMap = new HashMap<Skill, Shield>();
		shieldMap.put(Skill.SHIELD, basicShield());
	}

	/*
	 * INSTANCE FIELDS
	 */
	protected int armorClass;
	protected int dexterityBonus;

	protected int meleeRange;
	protected int thrownRange;
	protected int missileRange;

	protected int[] damageDice;
	protected EnergyType damageType;
	protected WeaponTrait[] traits;

	public Shield() {
		super();
		this.armorClass = 10;
		this.dexterityBonus = 10;

		this.meleeRange = 1;
		this.thrownRange = 4;
		this.missileRange = -1;

		this.damageDice = new int[] { 1, 4 };
		this.damageType = EnergyType.BLUDGEONING;
		this.traits = new WeaponTrait[0];
	}

	/*
	 * CLONE
	 */
	@Override
	public Object clone() {
		Shield shield = new Shield();

		shield.setName(name);
		shield.setMaterial(material);
		shield.setCostCP(cost);
		shield.setWeightOz(weight);

		shield.setIsStackable(isStackable);
		shield.setQuantity(quantity);
		shield.setSizeOfStack(sizeOfStack);

		shield.setHanded(handed);
		shield.setSkills(skills);

		shield.setArmorClass(armorClass);
		shield.setDexterityBonus(dexterityBonus);

		shield.setMeleeRange(meleeRange);
		shield.setThrownRange(thrownRange);
		shield.setMissileRange(missileRange);

		shield.setDamageDice(damageDice);
		shield.setDamageType(damageType);
		shield.setTraits(traits);

		return shield;
	}

	/*
	 * ARMOR METHODS
	 */
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
	 * WEAPON METHODS
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
		this.traits = traits;
	}

	/*
	 * STATIC METHODS
	 */
	public static Shield get(Skill skill) {
		return (Shield) shieldMap.get(skill).clone();
	}

	private static Shield basicShield() {
		Shield shield = new Shield();

		shield.setName("shield");
		shield.setMaterial(Material.WOOD);
		shield.setCostCP(1000);
		shield.setWeightOz(96);

		shield.setIsStackable(false);
		shield.setQuantity(1);
		shield.setSizeOfStack(1);

		shield.setHanded(Handed.ONE);
		shield.setSkills(new Skill[] { Skill.SHIELD });

		shield.setArmorClass(2);

		return shield;
	}
}
