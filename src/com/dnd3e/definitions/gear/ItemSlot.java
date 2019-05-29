package com.dnd3e.definitions.gear;

/*
 * This class uses Magic of Incarnum as the basis for its limited body slots. 
 * The 3e Dungeon Master's Guide was permissive with locations for potential 
 * magic items, requiring DM Fiat for numerous corner cases.
 */

/*
 * 4e attempted to curb the need for magic items by limiting the most useful 
 * effects to three primary locations/types: weapon, "neck," and armor. 5e 
 * curbed this further by abstracting magic items to "attunement slots," and 
 * allowing 3 of any such type.
 */

public enum ItemSlot {
	ARMS, BROW, CHARM, CHEST, CROWN, FEET, HANDS, LEGS, MANTLE, WAIST;

	// upper: hands, arms, mantle
	// lower: feet, legs, waist
	// body: chest, brow, crown
	// misc: charm ("soul", amulet, rings)

}
