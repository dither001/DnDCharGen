package com.dnd4e.definitions;

import com.dnd5e.definitions.*;
import com.dnd5e.gear.equipment.*;

public class BasicMeleeAttack {
	
	EffectRange effectRange;
	int range;
	EffectMode effectMode;
	
	BasicMeleeAttack(Weapon weapon) {
		if (weapon.uses(Skill.UNARMED))
		this.effectMode = EffectMode.WEAPON;
	}
}
