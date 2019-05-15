package com.dnd5e.spells.cantrips;

/*
 * This is an experiment to see what sort of information I need to store in a 
 * spell to make it viable. Do I need an object for every spell? Do I need to 
 * create spreadsheets to read in when the program launches? How much of the 
 * process can I automate? I'm sure I'll figure out a lot between now and the 
 * next time I work on spells. In the short term, what I need are ways to 
 * represent the DAMAGING SPELLS because those contribute to challenge rating 
 * calculation.
 * 
 * Probably somewhere between here and there, I will update items to include 
 * magic items, maybe include quirks and origins and stuff (beyond materials),
 * and it would be nice if I could figure that out before I need to do any
 * serious stuff with spells. It would be nice if I could create "families" of
 * spells kind of like how "all weapons are an implementation of the Armable
 * interface called Weapon," and it pretty much works like that.
 * 
 * Of course the ultimate problem is that UNLIKE equipment, every single spell
 * is basically a unique rules item. I'm going to need to figure out how best
 * to represent literally HUNDREDS of rules items without going insane. I think
 * my previous work on consolidating the spell lists and "trimming the fat," so
 * to speak, will help me a lot in this regard.
 * 
 * There are really only so many unique spell effects worth tracking.
 */

import com.dnd5e.definitions.magic.*;
import com.dnd5e.magic.*;

public class FireBolt extends Sorcery {
	/*
	 * ACID_SPLASH, CHILL_TOUCH, DANCING_LIGHTS, DRUIDCRAFT, ELDRITCH_BLAST,
	 * FIRE_BOLT, GUIDANCE, LIGHT, MAGE_HAND, MENDING, MESSAGE, MINOR_ILLUSION,
	 * POISON_SPRAY, PRESTIDIGITATION, PRODUCE_FLAME, RAY_OF_FROST, RESISTANCE,
	 * SACRED_FLAME, SHILLELAGH, SHOCKING_GRASP, SPARE_THE_DYING, THAUMATURGY,
	 * TRUE_STRIKE, VICIOUS_MOCKERY
	 */

	/*
	 * CONSTRUCTORS
	 */
	public FireBolt() {
		super();

		//
		this.name = "Fire Bolt";
		this.spell = Spell.FIRE_BOLT;
		this.school = School.EVOCATION;
		this.level = 0;

		//
		this.isRitual = false;
		this.usesConcentration = false;
	}

}
