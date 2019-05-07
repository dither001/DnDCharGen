package com.dnd5e.definitions.combat;

import com.dnd5e.characters.Actor;
import com.dnd5e.characters.Creature;
import com.dnd5e.definitions.rules.*;

public interface Attack {
	public Actor getAttacker();

	public void setAttacker(Actor attacker);

	public Creature getTarget();

	public void setTarget(Actor target);

	public int getAttackBonus();

	public void setAttackBonus(int attackBonus);

	public int getAverageDamage();

	public void setAverageDamage(int averageDamage);

	public EnergyType getDamageType();

	public void setDamageType(EnergyType damageType);
}
