package com.dnd5e.factions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.dnd5e.characters.*;

public class Warband implements Ensemble {
	protected String name;

	protected List<Member> members;
	protected Member founder;
	protected Foundation foundation;
	protected int morale;

	/*
	 * CONSTRUCTOR
	 */
	public Warband() {
		this.name = "Unnamed Warband";
		this.members = new ArrayList<Member>();
		this.foundation = Foundation.ALIGNMENT;
		this.morale = 11;
	}

	/*
	 * ENSEMBLE METHODS
	 */
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	public boolean add(Actor creature) {
		boolean added = false;

		if (members.size() == 0) {
			Member founder = new Member(creature);
			this.founder = founder;

			members.add(new Member(creature));
			added = true;

		} else if (members.size() > 1) {
			members.add(new Member(creature));
			added = true;
			foundation = biggestDifference();

		} else {
			members.add(new Member(creature));
			added = true;

		}

		return added;
	}

	public boolean addAll(Collection<Actor> c) {
		boolean added = false;

		if (true) {
			added = true;
			for (Iterator<Actor> it = c.iterator(); it.hasNext();)
				members.add(new Member(it.next()));

			foundation = biggestDifference();

		}

		return added;
	}

	public Actor remove(Actor creature) {
		// TODO
		return null;
	}

	public Collection<Actor> removeAll(Collection<Actor> c) {
		// TODO
		return null;
	}

	public List<Actor> getMembers() {
		ArrayList<Actor> list = new ArrayList<Actor>();
		for (Iterator<Member> it = members.iterator(); it.hasNext();)
			list.add(it.next().creature);

		return list;
	}

	public void setMembers(Collection<Actor> members) {
		// TODO
	}

	public Foundation getFoundation() {
		return foundation;
	}

	public void setFoundation(Foundation foundation) {
		this.foundation = foundation;
	}

	public String foundationToString() {
		String s = null;
		if (foundation.equals(Foundation.ALIGNMENT))
			s = foundation.toString() + " (1): " + founder.creature.getAlignment().toString();
		else if (foundation.equals(Foundation.GOD))
			s = foundation.toString() + " (2): " + founder.creature.getGod().toString();
		else if (foundation.equals(Foundation.RACE))
			s = foundation.toString() + " (3): " + ((Hero) founder.creature).getRace().toString();
		else if (foundation.equals(Foundation.BACKGROUND))
			s = foundation.toString() + " (4): " + ((Hero) founder.creature).getBackground().toString();
		else if (foundation.equals(Foundation.JOB))
			s = foundation.toString() + " (5): " + ((Hero) founder.creature).getJob().toString();
		else
			s = foundation.toString() + " (6)";

		return s;
	}

	/*
	 * PRIVATE METHODS
	 */
	private Foundation biggestDifference() {
		Foundation foundation = Foundation.ALIGNMENT;
		// 15, 13, 11, 9, 7

		int i = 0, length = members.size();
		Member current, next;
		boolean found, tryNext;

		while (foundation.higherIdeal()) {
			found = true;
			tryNext = false;

			if (foundation.equals(Foundation.NONE))
				break;

			for (i = 0; i + 1 < length; ++i) {
				current = members.get(i);

				for (int j = i + 1; j < length; ++j) {
					next = members.get(j);

					if (current.opposedIdeal(foundation, next)) {
						tryNext = true;
						break;
					}
				}

				if (tryNext) {
					i = 0;
					foundation = foundation.next();
					found = false;
					break;
				}
			}

			if (found)
				break;
		}

		return foundation;
	}

	/*
	 * PRIVATE CLASS - MEMBER
	 */
	private class Member {
		// basic
		Actor creature;
		boolean hasClass;
		boolean active;

		/*
		 * CONSTRUCTOR
		 */
		Member(Actor creature) {
			this.creature = creature;

			// classed characters
			if (creature.getClass().equals(DnDCharacter.class))
				this.hasClass = true;
			else
				this.hasClass = false;

			this.active = true;
		}

		private boolean opposedIdeal(Foundation ideal, Member other) {
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
