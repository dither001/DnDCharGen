package com.dnd5e.factions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.dnd5e.characters.*;

public class Warband implements Ensemble {
	protected String name;
	protected FactionType type;
	protected String purpose;

	protected List<Member> members;
	protected Member founder;
	protected Foundation foundation;
	protected int morale;

	/*
	 * CONSTRUCTOR
	 */
	public Warband() {
		this.name = "Unnamed Warband";
		this.type = FactionType.GANG;

		//
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

	public FactionType getType() {
		return type;
	}

	public void setType(FactionType type) {
		this.type = type;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getLeaderName() {
		return founder.creature.getName();
	}

	@Override
	public Actor getFace() {
		return founder.creature;
	}

	@Override
	public void setFace(Actor face) {
		// TODO Auto-generated method stub

	}

	public int size() {
		return members.size();
	}

	public boolean add(Actor actor) {
		if (contains(actor)) {
			return false;
		} else {
			Member add = new Member(actor);
			if (members.size() == 0) {
				this.founder = add;
				members.add(add);

			} else if (members.size() > 1) {
				members.add(new Member(actor));

			} else {
				members.add(new Member(actor));

			}

			return true;
		}
	}

	public boolean addAll(Collection<Actor> c) {
		boolean added = true;

		for (Iterator<Actor> it = c.iterator(); it.hasNext();) {
			if (add(it.next()) != true)
				added = false;
		}

		foundation = biggestDifference();

		return added;
	}

	public boolean contains(Actor creature) {
		for (Member el : members) {
			if (el.equals(creature))
				return true;
		}

		return false;
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
	private Member getMember(Actor creature) {
		for (Member el : members) {
			if (el.creature.equals(creature))
				return el;
		}

		return null;
	}

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
