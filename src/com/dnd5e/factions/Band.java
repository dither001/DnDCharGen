package com.dnd5e.factions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.dnd5e.characters.*;
import com.dnd5e.definitions.*;

public class Band {
	protected List<Partner> partners;
	protected Partner founder;
	protected FactionIdeal ideal;
	protected int morale;

	/*
	 * CONSTRUCTOR
	 */
	public Band() {
		this.partners = new ArrayList<Partner>();
		this.ideal = FactionIdeal.ALIGNMENT;
		this.morale = 11;
	}

	/*
	 * INSTANCE METHODS
	 */
	public boolean addPartner(Creature creature) {
		boolean added = false;

		/*
		 * TODO
		 */
		if (partners.size() == 0) {
			Partner founder = new Partner(creature);
			this.founder = founder;

			partners.add(new Partner(creature));
			added = true;

		} else if (partners.size() > 1) {
			partners.add(new Partner(creature));
			added = true;
			ideal = biggestDifference();

		} else {
			partners.add(new Partner(creature));
			added = true;

		}

		return added;
	}

	public boolean addAllPartners(Collection<Creature> list) {
		boolean added = false;

		if (true) {
			added = true;
			for (Iterator<Creature> it = list.iterator(); it.hasNext();)
				partners.add(new Partner(it.next()));

			ideal = biggestDifference();

		}

		return added;
	}

	public String getIdeal() {
		String s = null;

		if (ideal.equals(FactionIdeal.ALIGNMENT))
			s = ideal.toString() + " (1): " + founder.creature.getAlignment().toString();
		else if (ideal.equals(FactionIdeal.GOD))
			s = ideal.toString() + " (2): " + founder.creature.getGod().toString();
		else if (ideal.equals(FactionIdeal.RACE))
			s = ideal.toString() + " (3): " + ((Hero) founder.creature).getRace().toString();
		else if (ideal.equals(FactionIdeal.BACKGROUND))
			s = ideal.toString() + " (4): " + ((Hero) founder.creature).getBackground().toString();
		else if (ideal.equals(FactionIdeal.JOB))
			s = ideal.toString() + " (5): " + ((Hero) founder.creature).getJob().toString();
		else
			s = ideal.toString() + " (6)";

		return s;
	}

	public List<Creature> getPartnerList() {
		ArrayList<Creature> list = new ArrayList<Creature>();
		for (Iterator<Partner> it = partners.iterator(); it.hasNext();)
			list.add(it.next().creature);

		return list;
	}

	private FactionIdeal biggestDifference() {
		FactionIdeal ideal = FactionIdeal.ALIGNMENT;
		// 15, 13, 11, 9, 7

		int i = 0, length = partners.size();
		Partner current, next;
		boolean foundIdeal, nextIdeal;

		while (ideal.higherIdeal()) {
			foundIdeal = true;
			nextIdeal = false;

			if (ideal.equals(FactionIdeal.NONE))
				break;

			for (i = 0; i + 1 < length; ++i) {
				current = partners.get(i);

				for (int j = i + 1; j < length; ++j) {
					next = partners.get(j);

					if (current.opposedIdeal(ideal, next)) {
						nextIdeal = true;
						break;
					}
				}

				if (nextIdeal) {
					i = 0;
					ideal = ideal.next();
					foundIdeal = false;
					break;
				}
			}

			if (foundIdeal)
				break;
		}

		return ideal;
	}

	/*
	 * PRIVATE CLASS - PARTNER
	 * 
	 */
	private class Partner {
		// basic
		Creature creature;
		boolean hasClass;
		boolean active;

		/*
		 * CONSTRUCTOR
		 */
		Partner(Creature creature) {
			this.creature = creature;

			// classed characters
			if (creature.getClass().equals(DnDCharacter.class))
				this.hasClass = true;
			else
				this.hasClass = false;

			this.active = true;
		}

		private boolean opposedIdeal(FactionIdeal ideal, Partner other) {
			boolean opposed = false;

			switch (ideal) {
			case ALIGNMENT:
				opposed = creature.getAlignment().opposedTo(other.creature.getAlignment());
				break;
			case GOD:
				opposed = creature.getGod().opposedTo(other.creature.getGod());
				break;
			case RACE:
				if (hasClass && other.hasClass) {
					DnDCharacter a = (DnDCharacter) creature;
					DnDCharacter b = (DnDCharacter) other.creature;

					opposed = a.getRace().opposedTo(b.getRace());
				}

				break;
			case BACKGROUND:
				if (hasClass && other.hasClass) {
					DnDCharacter a = (DnDCharacter) creature;
					DnDCharacter b = (DnDCharacter) other.creature;

					opposed = a.getBackground().opposedTo(b.getBackground());
				}

				break;
			case JOB:
				if (hasClass && other.hasClass) {
					DnDCharacter a = (DnDCharacter) creature;
					DnDCharacter b = (DnDCharacter) other.creature;

					opposed = a.getJob().opposedTo(b.getJob());
				}

				break;
			case NONE:
				break;
			}

			return opposed;
		}

	}
}
