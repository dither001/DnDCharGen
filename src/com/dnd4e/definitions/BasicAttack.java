package com.dnd4e.definitions;

import com.dnd5e.combat.definitions.*;
import com.dnd5e.definitions.*;
import com.dnd5e.gear.equipment.*;

public class BasicAttack implements Attack {
	protected Creature attacker;
	protected Creature target;

	protected Weapon weapon;

	protected EffectMode effectMode;
	protected int range;
	protected EffectArea effectArea;

	protected EnergyType damageType;
	protected int attackBonus;
	protected int averageDamage;

	/*
	 * CONSTRUCTORS
	 */
	public BasicAttack() {
		this.weapon = null;
		this.attacker = null;
		this.target = null;

		this.attackBonus = 2;
		this.averageDamage = 1;
		this.damageType = EnergyType.BLUDGEONING;
	}

	/*
	 * INSTANCE METHODS
	 */
	public String toString() {
		String atk = attackBonus > -1 ? "+" + attackBonus : "" + attackBonus;
		String dmg = weapon.diceToString();
		String avg = averageDamage > -1 ? "" + averageDamage : "1";
		return String.format("%s %s %s (%s)", weapon.getName(), atk, dmg, avg);
	}

	/*
	 * ATTACK METHODS
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

	@Override
	public int getAttackBonus() {
		return attackBonus;
	}

	@Override
	public void setAttackBonus(int attackBonus) {
		this.attackBonus = attackBonus;
	}

	@Override
	public int getAverageDamage() {
		return averageDamage;
	}

	@Override
	public void setAverageDamage(int averageDamage) {
		this.averageDamage = averageDamage;
	}

	@Override
	public EnergyType getDamageType() {
		return damageType;
	}

	@Override
	public void setDamageType(EnergyType damageType) {
		this.damageType = damageType;
	}

	/*
	 * STATIC METHODS
	 */
	public static BasicAttack build(Weapon weapon, Creature actor) {
		BasicAttack b = new BasicAttack();

		/*
		 * attack bonus calculation
		 */
		boolean proficientUser = false;
		for (Skill el : weapon.getSkills()) {
			if (actor.getSkills().contains(el))
				proficientUser = true;
		}

		int attackBonus = 0;

		// proficiency
		attackBonus += proficientUser ? actor.getProficiencyBonus() : 0;
		// ability modifier
		attackBonus += weapon.usesDexterity() && actor.prefersFinesse() ? actor.getDexterityModifier()
				: actor.getStrengthModifier();

		b.weapon = weapon;
		b.setAttackBonus(attackBonus);
		b.setAverageDamage(weapon.getAverageDamage());
		b.setDamageType(weapon.getDamageType());

		if (weapon.uses(Skill.UNARMED)) {
			b.effectArea = EffectArea.TOUCH;
		} else {
			b.effectArea = EffectArea.WEAPON;
		}

		return b;
	}

}
