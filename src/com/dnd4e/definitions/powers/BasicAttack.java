package com.dnd4e.definitions.powers;

import com.dnd5e.characters.*;
import com.dnd5e.definitions.combat.*;
import com.dnd5e.definitions.rules.*;
import com.dnd5e.definitions.skills.*;
import com.dnd5e.equipment.*;

public class BasicAttack implements Attack {
	protected Actor attacker;
	protected Actor target;

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

		String atk = weapon.isRangedOnly() ? "ranged " : "melee ";
		atk += attackBonus > -1 ? "+" + attackBonus : "" + attackBonus;

		String dmg = weapon.diceToString();
		String avg = averageDamage > -1 ? "" + averageDamage : "1";
		return String.format("%s %s %s (%s)", weapon.getName(), atk, dmg, avg);
	}

	/*
	 * ATTACK METHODS
	 */
	@Override
	public Actor getAttacker() {
		return attacker;
	}

	@Override
	public void setAttacker(Actor attacker) {
		this.attacker = attacker;
	}

	@Override
	public Actor getTarget() {
		return target;
	}

	@Override
	public void setTarget(Actor target) {
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
	public static BasicAttack build(Weapon weapon, Actor actor) {
		BasicAttack b = new BasicAttack();

		/*
		 * attack bonus calculation
		 */
		boolean useDexterity = weapon.isRangedOnly() || (weapon.usesDexterity() && actor.prefersFinesse());
		boolean proficientUser = false;
		for (Skill el : weapon.getSkills()) {
			if (actor.getWeaponSkills().contains(el))
				proficientUser = true;
		}

		int attackBonus = 0;

		// proficiency
		attackBonus += proficientUser ? actor.getProficiencyBonus() : 0;

		// ability modifier
		if (useDexterity) {
			attackBonus += actor.getDexterityModifier();

		} else {
			attackBonus += actor.getStrengthModifier();

		}

		b.weapon = weapon;
		b.setAttackBonus(attackBonus);

		int averageDamage = weapon.getAverageDamage();
		// ability modifier
		if (useDexterity) {
			averageDamage += actor.getDexterityModifier();

		} else {
			averageDamage += actor.getStrengthModifier();

		}

		b.setAverageDamage(averageDamage);
		b.setDamageType(weapon.getDamageType());

		if (weapon.uses(Skill.UNARMED)) {
			b.effectArea = EffectArea.TOUCH;
		} else {
			b.effectArea = EffectArea.WEAPON;
		}

		return b;
	}

}
