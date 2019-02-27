package com.dnd5e.definitions;

import com.dnd5e.exceptions.*;
import com.miscellaneous.util.*;

public enum Alignment implements Opposite, Similar {
	CHAOTIC_EVIL, CHAOTIC_GOOD, CHAOTIC_NEUTRAL, LAWFUL_EVIL, LAWFUL_GOOD, LAWFUL_NEUTRAL, NEUTRAL_EVIL, NEUTRAL_GOOD, TRUE_NEUTRAL, UNALIGNED;

	/*
	 * STATIC FIELDS
	 */
	private static final Alignment[] ALIGNMENTS = { CHAOTIC_EVIL, CHAOTIC_GOOD, CHAOTIC_NEUTRAL, LAWFUL_EVIL,
			LAWFUL_GOOD, LAWFUL_NEUTRAL, NEUTRAL_EVIL, NEUTRAL_GOOD, TRUE_NEUTRAL, UNALIGNED };

	/*
	 * INSTANCE METHODS
	 */
	public String abbreviation() {
		String s = null;

		switch (this) {
		case CHAOTIC_EVIL:
			s = "CE";
			break;
		case CHAOTIC_GOOD:
			s = "CG";
			break;
		case CHAOTIC_NEUTRAL:
			s = "CN";
			break;
		case LAWFUL_EVIL:
			s = "LE";
			break;
		case LAWFUL_GOOD:
			s = "LG";
			break;
		case LAWFUL_NEUTRAL:
			s = "LN";
			break;
		case NEUTRAL_EVIL:
			s = "NE";
			break;
		case NEUTRAL_GOOD:
			s = "NG";
			break;
		case TRUE_NEUTRAL:
			s = "TN";
			break;
		case UNALIGNED:
			s = "UA";
			break;
		}

		return s;
	}

	public int indexOf() {
		return Misc.indexOfEnum(this.toString(), ALIGNMENTS);
	}

	public boolean isAligned() {
		return this.equals(UNALIGNED) != true;
	}

	public boolean isChaotic() {
		return this.equals(CHAOTIC_GOOD) || this.equals(CHAOTIC_NEUTRAL) || this.equals(CHAOTIC_EVIL);
	}

	public boolean isEvil() {
		return this.equals(LAWFUL_EVIL) || this.equals(NEUTRAL_EVIL) || this.equals(CHAOTIC_EVIL);
	}

	public boolean isGood() {
		return this.equals(LAWFUL_GOOD) || this.equals(NEUTRAL_GOOD) || this.equals(CHAOTIC_GOOD);
	}

	public boolean isLawful() {
		return this.equals(LAWFUL_GOOD) || this.equals(LAWFUL_NEUTRAL) || this.equals(LAWFUL_EVIL);
	}

	public boolean isNeutral() {
		return this.equals(LAWFUL_NEUTRAL) || this.equals(NEUTRAL_GOOD) || this.equals(TRUE_NEUTRAL)
				|| this.equals(NEUTRAL_EVIL) || this.equals(CHAOTIC_NEUTRAL);
	}

	public boolean isTrueNeutral() {
		return this.equals(TRUE_NEUTRAL);
	}

	public boolean isUnaligned() {
		return this.equals(UNALIGNED);
	}

	public boolean nonChaotic() {
		return isChaotic() != true;
	}

	public boolean nonEvil() {
		return isEvil() != true;
	}

	public boolean nonGood() {
		return isGood() != true;
	}

	public boolean nonLawful() {
		return isLawful() != true;
	}

	public boolean nonNeutral() {
		return this.equals(CHAOTIC_EVIL) || this.equals(CHAOTIC_GOOD) || this.equals(LAWFUL_EVIL)
				|| this.equals(LAWFUL_GOOD) || this.equals(UNALIGNED);
	}

	@Override
	public int similarTo(Object o) {
		int similar = -1;

		// Must be an Alignment object
		if (o.getClass().equals(Alignment.class)) {
			Alignment a = (Alignment) o;

			if (a.isChaotic() && this.isChaotic())
				similar = 1;
			else if (a.isEvil() && this.isEvil())
				similar = 1;
			else if (a.isGood() && this.isGood())
				similar = 1;
			else if (a.isLawful() && this.isLawful())
				similar = 1;
			else if (a.isUnaligned() && this.isUnaligned())
				similar = 1;

			if (a.equals(this))
				similar = 0;
		}

		return similar;
	}

	@Override
	public boolean opposedTo(Object o) {
		boolean opposed = false;

		// Must be an Alignment object
		if (o.getClass().equals(Alignment.class)) {
			Alignment a = (Alignment) o;

			if (a.isChaotic() && this.isLawful())
				opposed = true;
			else if (a.isLawful() && this.isChaotic())
				opposed = true;
			else if (a.isEvil() && this.isGood())
				opposed = true;
			else if (a.isGood() && this.isEvil())
				opposed = true;

			if (a.isTrueNeutral() && !(this.isTrueNeutral()))
				opposed = true;
			else if (!(a.isTrueNeutral()) && this.isTrueNeutral())
				opposed = true;

		}

		return opposed;
	}

	/*
	 * STATIC METHODS
	 */
	public static Alignment get(int index) {
		return ALIGNMENTS[index];
	}

	public static Alignment parse(String s) throws ParserException {
		for (Alignment el : ALIGNMENTS) {
			if (el.toString().compareToIgnoreCase(s) == 0)
				return el;
		}

		throw new ParserException();
	}

	public static Alignment random() {
		return Misc.randomFromArray(ALIGNMENTS);
	}

	public static Alignment randomSkewEvil() {
		Alignment a = null;

		int dice = Dice.roll(100);
		if (dice < 11)
			a = LAWFUL_GOOD;
		else if (dice < 21)
			a = LAWFUL_NEUTRAL;
		else if (dice < 31)
			a = NEUTRAL_GOOD;
		else if (dice < 41)
			a = TRUE_NEUTRAL;
		else if (dice < 51)
			a = NEUTRAL_EVIL;
		else if (dice < 61)
			a = CHAOTIC_GOOD;
		else if (dice < 71)
			a = CHAOTIC_NEUTRAL;
		else if (dice < 86)
			a = LAWFUL_EVIL;
		else
			a = CHAOTIC_EVIL;

		return a;
	}
}
