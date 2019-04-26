package com.dnd5e.characters;

import java.util.List;

import com.dnd5e.backgrounds.*;
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
			Charlatan.setup(actor);
			break;
		case CRIMINAL:
			Criminal.setup(actor);
			break;
		case ENTERTAINER:
			Entertainer.setup(actor);
			break;
		case FOLK_HERO:
			FolkHero.setup(actor);
			break;
		case GUILD_ARTISAN:
			GuildArtisan.setup(actor);
			break;
		case HERMIT:
			Hermit.setup(actor);
			break;
		case NOBLE:
			Noble.setup(actor);
			break;
		case OUTLANDER:
			Outlander.setup(actor);
			break;
		case SAGE:
			Sage.setup(actor);
			break;
		case SAILOR:
			Sailor.setup(actor);
			break;
		case SOLDIER:
			Soldier.setup(actor);
			break;
		case URCHIN:
			Urchin.setup(actor);
			break;
		default:
			break;
		}
	}

	public static Background get(int index) {
		return BACKGROUNDS[index];
	}

	public static List<Background> list() {
		return Misc.arrayToList(BACKGROUNDS);
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

	public static Background randomSkewMedieval() {
		Background background = null;
		Background[] array = null;
		int dice = Dice.roll(100);

		if (dice < 21) {
			// 20%
			background = Background.GUILD_ARTISAN;

		} else if (dice < 41) {
			// 20%
			array = new Background[] { Background.CHARLATAN, Background.CRIMINAL, Background.HERMIT,
					Background.OUTLANDER, Background.URCHIN };
			background = Misc.randomFromArray(array);

		} else if (dice < 56) {
			// 15%
			background = Background.SAILOR;

		} else if (dice < 71) {
			// 15%
			background = Background.SOLDIER;

		} else if (dice < 86) {
			// 15%
			array = new Background[] { Background.ENTERTAINER, Background.FOLK_HERO, Background.SAGE };
			background = Misc.randomFromArray(array);

		} else if (dice < 96) {
			//
			background = Background.ACOLYTE;

		} else {
			//
			background = Background.NOBLE;

		}

		return background;
	}

}
