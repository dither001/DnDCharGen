package com.dnd5e.gear.definitions;

import com.dnd5e.definitions.*;

public interface Armable extends Usable {
	public int[] getDamageDice();

	public void setDamageDice(int[] damageDice);

	public Energy getDamageType();

	public void setDamageType(Energy damageType);

	public WeaponTrait[] getTraits();

	public void setTraits(WeaponTrait[] traits);

	/*
	 * DEFAULT METHODS
	 */
	public default int getAverageDamage() {
		int[] dice = getDamageDice();
		return ((dice[1] + 1) * dice[0] / 2);
	}

	public default boolean hasRangedMode() {
		for (WeaponTrait el : getTraits()) {
			if (el.equals(WeaponTrait.AMMUNITION) || el.equals(WeaponTrait.THROWN))
				return true;
		}

		return false;
	}

	public default boolean isRangedOnly() {
		for (WeaponTrait el : getTraits()) {
			if (el.equals(WeaponTrait.AMMUNITION))
				return true;
		}

		return false;
	}

	public default boolean usesDexterity() {
		for (WeaponTrait el : getTraits()) {
			if (el.equals(WeaponTrait.AMMUNITION) || el.equals(WeaponTrait.FINESSE))
				return true;
		}

		return false;
	}
}
