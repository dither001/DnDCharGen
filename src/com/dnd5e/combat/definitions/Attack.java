package com.dnd5e.combat.definitions;

import com.dnd5e.definitions.*;

public interface Attack {
	public Creature getAttacker();

	public void setAttacker(Creature attacker);

	public Creature getTarget();

	public void setTarget(Creature target);

	public int getAttackBonus();

	public void setAttackBonus(int attackBonus);

	public int getAverageDamage();

	public void setAverageDamage(int averageDamage);
}
