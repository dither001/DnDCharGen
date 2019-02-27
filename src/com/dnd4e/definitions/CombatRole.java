package com.dnd4e.definitions;

import com.dnd5e.exceptions.*;
import com.miscellaneous.util.*;

public enum CombatRole implements Opposite, Similar {
	CONTROLLER, DEFENDER, LEADER, STRIKER;

	private static final CombatRole[] COMBAT_ROLES = { CONTROLLER, DEFENDER, LEADER, STRIKER };

	/*
	 * 
	 */
	public int indexOf() {
		return Misc.indexOfEnum(this.toString(), COMBAT_ROLES);
	}

	@Override
	public int similarTo(Object o) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public boolean opposedTo(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * STATIC METHODS
	 */
	public static CombatRole get(int index) {
		return COMBAT_ROLES[index];
	}

	public static CombatRole parse(String s) throws ParserException {
		for (CombatRole el : COMBAT_ROLES) {
			if (el.toString().compareToIgnoreCase(s) == 0)
				return el;
		}

		throw new ParserException(CombatRole.class.getName(), s);
	}

}
