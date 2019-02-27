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
	public static MeleeBasicAttack build(Weapon weapon, Creature actor) {
		MeleeBasicAttack b = new MeleeBasicAttack();

		/*
		 * attack bonus calculation
		 */
		int attackBonus = 0;

		boolean proficientUser = false;
		for (Skill el : weapon.getSkills()) {
			if (actor.getSkills().contains(el))
				proficientUser = true;
		}

		attackBonus = (proficientUser) ? actor.getProficiencyBonus() : 0;

		/*
		 * 
		 */
		if (weapon.uses(Skill.UNARMED)) {
			b.effectArea = EffectArea.TOUCH;
		} else {
			b.effectArea = EffectArea.WEAPON;
		}

		return b;
	}
}
