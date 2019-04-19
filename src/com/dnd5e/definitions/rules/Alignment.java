package com.dnd5e.definitions.rules;

import java.util.List;

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
		case CHAOTIC_EVIL: // 0
			s = "CE";
			break;
		case CHAOTIC_GOOD: // 1
			s = "CG";
			break;
		case CHAOTIC_NEUTRAL: // 2
			s = "CN";
			break;
		case LAWFUL_EVIL: // 3
			s = "LE";
			break;
		case LAWFUL_GOOD: // 4
			s = "LG";
			break;
		case LAWFUL_NEUTRAL: // 5
			s = "LN";
			break;
		case NEUTRAL_EVIL: // 6
			s = "NE";
			break;
		case NEUTRAL_GOOD: // 7
			s = "NG";
			break;
		case TRUE_NEUTRAL: // 8
			s = "TN";
			break;
		case UNALIGNED: // 9
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

	public static List<Alignment> list() {
		return Misc.arrayToList(ALIGNMENTS);
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
		Alignment[] array = null;

		int dice = Dice.roll(100);
		if (dice < 36) {
			array = new Alignment[] { Alignment.CHAOTIC_EVIL, Alignment.NEUTRAL_EVIL, Alignment.LAWFUL_EVIL };
			a = Misc.randomFromArray(array);

		} else if (dice < 56) {
			array = new Alignment[] { Alignment.LAWFUL_EVIL, Alignment.LAWFUL_NEUTRAL, Alignment.LAWFUL_GOOD };
			a = Misc.randomFromArray(array);

		} else if (dice < 76) {
			array = new Alignment[] { Alignment.CHAOTIC_GOOD, Alignment.NEUTRAL_GOOD, Alignment.LAWFUL_GOOD };
			a = Misc.randomFromArray(array);

		} else if (dice < 96) {
			array = new Alignment[] { Alignment.CHAOTIC_EVIL, Alignment.CHAOTIC_NEUTRAL, Alignment.CHAOTIC_GOOD };
			a = Misc.randomFromArray(array);

		} else {
			a = Alignment.TRUE_NEUTRAL;

		}

		return a;
	}
}
