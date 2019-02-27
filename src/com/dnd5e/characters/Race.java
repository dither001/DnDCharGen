package com.dnd5e.characters;

import com.miscellaneous.util.*;

public enum Race implements Opposite, Similar {
	// GNOLL, GOBLIN, GRIMLOCK, KOBOLD, LIZARDFOLK, MERFOLK, ORC, SAHUAGIN
	HALF_ELF, HALF_ORC, HUMAN, TIEFLING,
	//
	REDSCALE, BLACKSCALE, BLUESCALE, GREENSCALE, WHITESCALE,
	//
	GOLDLEAF, SILVERLEAF, BRONZELEAF, BRASSLEAF, COPPERLEAF,
	//
	HILL_DWARF, MOUNTAIN_DWARF,
	//
	DARK_ELF, HIGH_ELF, WOOD_ELF,
	//
	FOREST_GNOME, ROCK_GNOME,
	//
	LIGHTFOOT_HALFLING, STRONGHEART_HALFLING;

	/*
	 * 
	 */
	private static final Race[] RACES = {
			//
			HALF_ELF, HALF_ORC, HUMAN, TIEFLING,
			//
			REDSCALE, BLACKSCALE, BLUESCALE, GREENSCALE, WHITESCALE,
			//
			GOLDLEAF, SILVERLEAF, BRONZELEAF, BRASSLEAF, COPPERLEAF,
			//
			HILL_DWARF, MOUNTAIN_DWARF,
			//
			DARK_ELF, HIGH_ELF, WOOD_ELF,
			//
			FOREST_GNOME, ROCK_GNOME,
			//
			LIGHTFOOT_HALFLING, STRONGHEART_HALFLING };

	/*
	 * INSTANCE METHODS
	 */
	public String abbreviation() {
		String s = null;

		switch (this) {
		case BLACKSCALE:
		case BLUESCALE:
		case BRASSLEAF:
		case BRONZELEAF:
		case COPPERLEAF:
		case GOLDLEAF:
		case GREENSCALE:
		case REDSCALE:
		case SILVERLEAF:
		case WHITESCALE:
			s = "dragonborn";
			break;
		case DARK_ELF:
			s = "dark elf";
			break;
		case FOREST_GNOME:
		case ROCK_GNOME:
			s = "gnome";
			break;
		case HALF_ELF:
			s = "half-elf";
			break;
		case HALF_ORC:
			s = "half-orc";
			break;
		case HIGH_ELF:
			s = "high elf";
			break;
		case HILL_DWARF:
		case MOUNTAIN_DWARF:
			s = "dwarf";
			break;
		case HUMAN:
			s = "human";
			break;
		case LIGHTFOOT_HALFLING:
		case STRONGHEART_HALFLING:
			s = "halfling";
			break;
		case TIEFLING:
			s = "tiefling";
			break;
		case WOOD_ELF:
			s = "wood elf";
			break;
		}

		return s;
	}

	public int indexOf() {
		int index = -1;

		// TODO
		for (int i = 0; i < RACES.length; ++i) {
			if (RACES[i].equals(this)) {
				index = i;
				break;
			}
		}

		return index;
	}

	public boolean isDragonborn() {
		return this.isChromaticDragonborn() || this.isMetallicDragonborn();
	}

	public boolean isChromaticDragonborn() {
		return this.equals(REDSCALE) || this.equals(BLACKSCALE) || this.equals(BLUESCALE) || this.equals(GREENSCALE)
				|| this.equals(WHITESCALE);
	}

	public boolean isMetallicDragonborn() {
		return this.equals(GOLDLEAF) || this.equals(SILVERLEAF) || this.equals(BRONZELEAF) || this.equals(BRASSLEAF)
				|| this.equals(COPPERLEAF);
	}

	public boolean isDwarf() {
		return this.equals(HILL_DWARF) || this.equals(MOUNTAIN_DWARF);
	}

	public boolean isElf() {
		return this.equals(DARK_ELF) || this.equals(HALF_ELF) || this.equals(HIGH_ELF) || this.equals(WOOD_ELF);
	}

	public boolean isGnome() {
		return this.equals(FOREST_GNOME) || this.equals(ROCK_GNOME);
	}

	public boolean isHalfling() {
		return this.equals(LIGHTFOOT_HALFLING) || this.equals(STRONGHEART_HALFLING);
	}

	public boolean isHuman() {
		return this.equals(HALF_ELF) || this.equals(HALF_ORC) || this.equals(HUMAN) || this.equals(TIEFLING);
	}

	/*
	 * 
	 */
	private boolean ambitious() {
		return this.equals(HUMAN) || this.equals(TIEFLING);
	}

	private boolean industrius() {
		return this.isDwarf() || this.isDragonborn();
	}

	private boolean nomadic() {
		return this.equals(HALF_ELF) || this.equals(HALF_ORC) || this.isHalfling();
	}

	private boolean sylvan() {
		return this.isGnome() || this.isElf();
	}

	@Override
	public int similarTo(Object o) {
		int similar = -1;

		if (o.getClass().equals(Race.class)) {
			Race r = (Race) o;

			if (r.ambitious() && this.ambitious())
				similar = 1;
			else if (r.industrius() && this.industrius())
				similar = 1;
			else if (r.nomadic() && this.nomadic())
				similar = 1;
			else if (r.sylvan() && this.sylvan())
				similar = 1;

			if (r.equals(this))
				similar = 0;
		}

		return similar;
	}

	@Override
	public boolean opposedTo(Object o) {
		boolean opposed = false;

		if (o.getClass().equals(Race.class)) {
			Race r = (Race) o;

			if (r.ambitious() && this.sylvan())
				opposed = true;
			else if (r.nomadic() && this.industrius())
				opposed = true;
			else if (r.sylvan() && this.ambitious())
				opposed = true;
			else if (r.industrius() && this.nomadic())
				opposed = true;

			if (r.equals(this))
				opposed = false;
		}

		return opposed;
	}

	/*
	 * STATIC METHODS
	 */
	public static Race get(int index) {
		return RACES[index];
	}

	public static Race parse(String s) throws ParserException {
		for (Race el : RACES) {
			if (el.toString().compareToIgnoreCase(s) == 0)
				return el;
		}

		throw new ParserException();
	}

	public static Race random() {
		return Misc.randomFromArray(RACES);
	}

	public static Race randomChromatic() {
		Race race = null;
		int dice = Dice.roll(20);

		if (dice < 1 + 6)
			race = REDSCALE;
		else if (dice < 7 + 5)
			race = BLACKSCALE;
		else if (dice < 12 + 4)
			race = BLUESCALE;
		else if (dice < 16 + 3)
			race = GREENSCALE;
		else
			race = WHITESCALE;

		return race;
	}

	public static Race randomMetallic() {
		Race race = null;
		int dice = Dice.roll(20);

		if (dice < 1 + 6)
			race = GOLDLEAF;
		else if (dice < 7 + 5)
			race = SILVERLEAF;
		else if (dice < 12 + 4)
			race = BRONZELEAF;
		else if (dice < 16 + 3)
			race = BRASSLEAF;
		else
			race = COPPERLEAF;

		return race;
	}

	public static Race randomSkewHuman() {
		Race race = null;

		int dice = Dice.roll(100);
		if (dice < 41) {
			race = HUMAN;
		} else if (dice < 41 + 15) {
			// DWARF
			dice = Dice.roll(3);
			if (dice < 3)
				race = HILL_DWARF;
			else
				race = MOUNTAIN_DWARF;
		} else if (dice < 41 + 30) {
			// ELF
			dice = Dice.roll(6);
			if (dice < 4)
				race = WOOD_ELF;
			else if (dice < 6)
				race = HIGH_ELF;
			else
				race = DARK_ELF;
		} else if (dice < 41 + 45) {
			// HALFLING
			dice = Dice.roll(3);
			if (dice < 3)
				race = LIGHTFOOT_HALFLING;
			else
				race = STRONGHEART_HALFLING;
		} else {
			// other races
			dice = Dice.roll(10);
			if (dice == 1 || dice == 2 || dice == 3)
				race = HALF_ELF;
			else if (dice == 4)
				race = randomChromatic();
			else if (dice == 5)
				race = randomMetallic();
			else if (dice == 6 || dice == 7)
				race = TIEFLING;
			else if (dice == 8)
				race = FOREST_GNOME;
			else if (dice == 9)
				race = ROCK_GNOME;
			else
				race = HALF_ORC;
		}

		return race;
	}

}
