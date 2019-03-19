package com.dnd5e.character.classes;

public abstract class JobClass {

	/*
	 * 
	 */
	public static void advance(int level, Adventurer actor) {
		switch (actor.getJob()) {
		case BARBARIAN:
			Barbarian.apply(level, actor);
			break;
		case BARD:
			// FIXME
			break;
		case CLERIC:
			// FIXME
			break;
		case DRUID:
			// FIXME
			break;
		case FIGHTER:
			// FIXME
			break;
		case MONK:
			// FIXME
			break;
		case PALADIN:
			// FIXME
			break;
		case RANGER:
			// FIXME
			break;
		case ROGUE:
			// FIXME
			break;
		case SORCERER:
			// FIXME
			break;
		case WARLOCK:
			// FIXME
			break;
		case WIZARD:
			// FIXME
			break;
		}

	}

	public static void apply(int level, Adventurer actor) {
		switch (level) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		case 10:
			break;
		case 11:
			break;
		case 12:
			break;
		case 13:
			break;
		case 14:
			break;
		case 15:
			break;
		case 16:
			break;
		case 17:
			break;
		case 18:
			break;
		case 19:
			break;
		case 20:
			break;
		}
	}

	public static void enhanceAbility(Adventurer actor) {
		// TODO

	}

}
