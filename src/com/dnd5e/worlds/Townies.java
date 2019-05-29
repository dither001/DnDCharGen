package com.dnd5e.worlds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dnd3e.definitions.towns.*;
import com.dnd5e.characters.*;
import com.dnd5e.classes.*;
import com.miscellaneous.util.*;

/*
 * This class is a mediator (in a sense) between the settlement-generation
 * methods of D&D 3e and the classes of 5e. In 3e, "rare" classes were
 * typically represented by a character of level 1d4 plus the community
 * modifier. This went to 1d6+modifier and 1d8+modifier for more common
 * character classes. 5e character classes are a little different.
 */

public class Townies {

	private Map<DnDClass, List<Integer>> pawns;
	private List<DnDCharacter> townies;

	/*
	 * CONSTRUCTORS
	 */
	private Townies() {
		pawns = new HashMap<DnDClass, List<Integer>>();
		townies = new ArrayList<DnDCharacter>();

	}

	public Map<DnDClass, List<Integer>> getMap() {
		return pawns;
	}

	public int size() {
		int n = 0;
		for (List<Integer> el : pawns.values())
			n += el.size();

		return n;
	}

	/*
	 * STATIC METHODS
	 */
	public static Townies build(SettlementType type) {
		Townies t = new Townies();
		DnDClass[] array = null;

		// barbarian, druid, monk, paladin, ranger, sorcerer, wizard
		array = new DnDClass[] { DnDClass.BARBARIAN, DnDClass.DRUID, DnDClass.MONK, DnDClass.PALADIN, DnDClass.RANGER,
				DnDClass.SORCERER, DnDClass.WIZARD };
		helper(4, type, array, t);

		// bard, cleric, warlock
		array = new DnDClass[] { DnDClass.BARD, DnDClass.CLERIC, DnDClass.WARLOCK };
		helper(6, type, array, t);

		// fighter, rogue
		array = new DnDClass[] { DnDClass.FIGHTER, DnDClass.ROGUE };
		helper(8, type, array, t);

		return t;
	}

	private static void helper(int dice, SettlementType type, DnDClass[] array, Townies t) {
		int modifier = SettlementType.communityModifier(type);

		// determines number of high-level NPCs
		int n = 1;
		if (type.equals(SettlementType.TOWN))
			n = 2;
		else if (type.equals(SettlementType.CITY))
			n = 3;
		else if (type.equals(SettlementType.METROPOLIS))
			n = 4;

		for (int i, j = 0; j < array.length; ++j) {
			// determines highest-level NPC of class & initializes list
			int level = Dice.roll(dice) + modifier;
			if (t.pawns.containsKey(array[j]) != true)
				t.pawns.put(array[j], new ArrayList<Integer>());

			for (i = n; level / 2 > 0; i *= 2, level /= 2) {
				// fills list
				for (int k = i; k > 0; --k) {
					int l = level > 5 ? level + 4 - Dice.roll(4) : level;
					t.pawns.get(array[j]).add(new Integer(l));
				}
			}

			// finally, adds 1st-level NPCs
			for (int k = i; k > 0; --k)
				t.pawns.get(array[j]).add(new Integer(1));
		}
	}

}
