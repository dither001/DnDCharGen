package com.dnd5e.factions;

import java.util.Collection;

import com.dnd5e.characters.*;

public interface Band extends Ensemble {

	/*
	 * First primary method of a Band: to band a group of creatures or characters
	 * together. Secondary method of a Band: to disband a group of creatures or
	 * characters and retrieve the latest Collection.
	 */
	public void band(Ideal ideal, Collection<Actor> c);

	public Collection<Actor> disband();

	/*
	 * 
	 */
	public Ideal getIdeal();

	public void setIdeal(Ideal ideal);

}
