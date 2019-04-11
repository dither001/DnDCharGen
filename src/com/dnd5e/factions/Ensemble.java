package com.dnd5e.factions;

import java.util.Collection;

import com.dnd5e.characters.Creature;
import com.dnd5e.definitions.rules.*;

public interface Ensemble {

	/*
	 * 
	 */
	public boolean add(Creature creature);

	public boolean addAll(Collection<Creature> c);

	public Creature remove(Creature creature);

	public Collection<Creature> removeAll(Collection<Creature> c);

	/*
	 * 
	 */
	public Collection<Creature> getMembers();

	public void setMembers(Collection<Creature> members);

	public Foundation getFoundation();

	public void setFoundation(Foundation foundation);
}
