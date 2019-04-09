package com.dnd5e.character.definitions;

import com.dnd5e.backgrounds.Acolyte;
import com.miscellaneous.util.*;

public enum Background implements Opposite, Similar {
	ACOLYTE, CHARLATAN, CRIMINAL, ENTERTAINER, FOLK_HERO, GUILD_ARTISAN, HERMIT, NOBLE, OUTLANDER, SAGE, SAILOR, SOLDIER, URCHIN;

	private static final Background[] BACKGROUNDS = { ACOLYTE, CHARLATAN, CRIMINAL, ENTERTAINER, FOLK_HERO,
			GUILD_ARTISAN, HERMIT, NOBLE, OUTLANDER, SAGE, SAILOR, SOLDIER, URCHIN };

	/*
	 * INSTANCE METHODS
	 */
	public int indexOf() {
		return Misc.indexOfEnum(this.toString(), BACKGROUNDS);
	}

	private boolean isClergy() {
		return this.equals(ACOLYTE);
	}

	private boolean isNoble() {
		return this.equals(NOBLE);
	}

	private boolean isOutlaw() {
		return this.equals(CHARLATAN) || this.equals(CRIMINAL) || this.equals(HERMIT) || this.equals(OUTLANDER)
				|| this.equals(URCHIN);
	}

	private boolean isTradesman() {
		return this.equals(ENTERTAINER) || this.equals(FOLK_HERO) || this.equals(GUILD_ARTISAN) || this.equals(SAGE)
				|| this.equals(SAILOR) || this.equals(SOLDIER);
	}

	@Override
	public int similarTo(Object o) {
		int similar = -1;

		if (o.getClass().equals(Background.class)) {
			Background b = (Background) o;

			if (b.isClergy() && (this.isOutlaw() || this.isNoble()))
				similar = 1;
			else if (b.isOutlaw() && (this.isTradesman() || this.isClergy()))
				similar = 1;
			else if (b.isTradesman() && (this.isNoble() || this.isOutlaw()))
				similar = 1;
			else if (b.isNoble() && (this.isClergy() || this.isTradesman()))
				similar = 1;

			if (b.equals(this))
				similar = 0;
		}

		return similar;
	}

	@Override
	public boolean opposedTo(Object o) {
		boolean opposed = false;

		if (o.getClass().equals(Background.class)) {
			Background b = (Background) o;

			if (b.isClergy() && this.isTradesman())
				opposed = true;
			else if (b.isOutlaw() && this.isNoble())
				opposed = true;
			else if (b.isTradesman() && this.isClergy())
				opposed = true;
			else if (b.isNoble() && this.isOutlaw())
				opposed = true;

			if (b.equals(this))
				opposed = false;
		}

		return opposed;
	}

	/*
	 * STATIC METHODS
	 */
	public static void apply(Hero actor) {
		Background bg = actor.getBackground();

		switch (bg) {
		case ACOLYTE:
			Acolyte.setup(actor);
			break;
		case CHARLATAN:
			break;
		case CRIMINAL:
			break;
		case ENTERTAINER:
			break;
		case FOLK_HERO:
			break;
		case GUILD_ARTISAN:
			break;
		case HERMIT:
			break;
		case NOBLE:
			break;
		case OUTLANDER:
			break;
		case SAGE:
			break;
		case SAILOR:
			break;
		case SOLDIER:
			break;
		case URCHIN:
			break;
		default:
			break;
		}

	}

	public static Background parse(String s) throws ParserException {
		for (Background el : BACKGROUNDS) {
			if (el.toString().compareToIgnoreCase(s) == 0)
				return el;
		}

		throw new ParserException();
	}

	public static Background random() {
		return Misc.randomFromArray(BACKGROUNDS);
	}
}
