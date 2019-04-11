package com.dnd5e.factions;

import java.util.Collection;

import com.dnd5e.characters.Creature;
import com.dnd5e.definitions.rules.*;

public interface Band extends Ensemble {

	/*
	 * First primary method of a Band: to band a group of creatures or characters
	 * together. Secondary method of a Band: to disband a group of creatures or
	 * characters and retrieve the latest Collection.
	 */
	public void band(Ideal ideal, Collection<Creature> c);

	public Collection<Creature> disband();

	/*
	 * 
	 */
	public Ideal getIdeal();

	public void setIdeal(Ideal ideal);

}
