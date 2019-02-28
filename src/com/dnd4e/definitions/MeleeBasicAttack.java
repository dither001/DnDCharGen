package com.dnd4e.definitions;

import com.dnd5e.combat.definitions.*;
import com.dnd5e.definitions.*;
import com.dnd5e.gear.equipment.*;

public class MeleeBasicAttack implements Attack {
	protected Creature attacker;
	protected Creature target;

	protected Weapon weapon;

	protected EffectMode effectMode;
	protected int range;
	protected EffectArea effectArea;

	/*
	 * INSTANCE METHODS
	 */
	@Override
	public Creature getAttacker() {
		return attacker;
	}

	@Override
	public void setAttacker(Creature attacker) {
		this.attacker = attacker;
	}

	@Override
	public Creature getTarget() {
		return target;
	}

	@Override
	public void setTarget(Creature target) {
		this.target = target;
	}

	/*
	 * STATIC METHODS
	 */
	public static MeleeBasicAttack build(Weapon weapon, Creature actor) {
		MeleeBasicAttack b = new MeleeBasicAttack();

		/*
		 * attack bonus calculation
		 */
		boolean proficientUser = false;
		for (Skill el : weapon.getSkills()) {
			if (actor.getSkills().contains(el))
				proficientUser = true;
		}

		int attackBonus = (proficientUser) ? actor.getProficiencyBonus() : 0;

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
