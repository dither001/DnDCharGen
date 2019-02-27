package com.dnd4e.definitions;

import com.dnd5e.definitions.*;
import com.dnd5e.gear.equipment.*;

public class MeleeBasicAttack {

	protected EffectMode effectMode;
	protected int range;
	protected EffectArea effectArea;

	/*
	 * STATIC METHODS
	 */
	public static MeleeBasicAttack build(Weapon weapon) {
		MeleeBasicAttack b = new MeleeBasicAttack();

		if (weapon.uses(Skill.UNARMED)) {
			b.effectArea = EffectArea.TOUCH;
		} else {
			b.effectArea = EffectArea.WEAPON;
		}

		return b;
	}
}
