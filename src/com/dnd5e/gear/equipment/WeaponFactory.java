package com.dnd5e.gear.equipment;

import com.dnd5e.definitions.*;

public abstract class WeaponFactory {
	public static Weapon build(Skill skill) {
		Weapon weapon = new Weapon();

		return weapon;
	}
}
