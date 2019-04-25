package com.dnd5e.factions;

import java.util.Collection;

import com.dnd5e.characters.*;

public interface Ensemble {

	/*
	 * 
	 */
	public String getName();
	
	public void setName(String name);
	
	/*
	 * 
	 */
	public boolean add(Actor creature);

	public boolean addAll(Collection<Actor> c);

	public Actor remove(Actor creature);

	public Collection<Actor> removeAll(Collection<Actor> c);

	/*
	 * 
	 */
	public Collection<Actor> getMembers();

	public void setMembers(Collection<Actor> members);

	public Foundation getFoundation();

	public void setFoundation(Foundation foundation);
}
