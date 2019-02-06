package com.dnd5e.characters;

import java.util.EnumSet;

import com.dnd5e.definitions.*;
import com.dnd5e.util.*;
import com.dnd5e.worlds.*;

public abstract class Actor implements Creature, Persistent {

	/*
	 * PERSISTENT FIELDS
	 */
	protected boolean isPersistent;
	protected boolean hasChanged;
	protected int id;

	/*
	 * CREATURE FIELDS
	 */
	protected String name;
	protected boolean isFemale;
	protected Alignment alignment;
	protected God god;

	protected Size size;
	protected CreatureType creatureType;
	protected EnumSet<MovementType> movement;
	protected EnumSet<Sense> senses;

	/*
	 * COMBAT STATS
	 */
	protected int[] hitDice;
	protected int[] abilityScores;
	protected int[] abilityCeiling;
	protected int[] savingThrows;

	/*
	 * STATUS EFFECTS
	 */
	protected EnumSet<Energy> energyResistance;
	protected EnumSet<Energy> energyImmunity;
	protected EnumSet<Condition> conditionImmunity;
	protected EnumSet<Condition> conditions;

	/*
	 * PERSISTENT METHODS
	 */
	@Override
	public boolean isPersistent() {
		return isPersistent;
	}

	@Override
	public void makePersistent(boolean isPersistent) {
		this.isPersistent = isPersistent;
	}

	@Override
	public boolean hasChanged() {
		return hasChanged;
	}

	@Override
	public void markChanged(boolean hasChanged) {
		this.hasChanged = hasChanged;
	}

	@Override
	public int getID() {
		return id;
	}

	@Override
	public void setID(int id) {
		this.id = id;
	}

	/*
	 * CREATURE METHODS
	 */
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean isFemale() {
		return isFemale;
	}

	@Override
	public void setFemale(boolean isFemale) {
		this.isFemale = isFemale;
	}

	@Override
	public Alignment getAlignment() {
		return alignment;
	}

	@Override
	public void setAlignment(Alignment alignment) {
		this.alignment = alignment;
	}

	@Override
	public God getGod() {
		return god;
	}

	@Override
	public void setGod(God god) {
		this.god = god;
	}

	@Override
	public Size getCreatureSize() {
		return size;
	}

	@Override
	public CreatureType getCreatureType() {
		return creatureType;
	}

	@Override
	public EnumSet<MovementType> getSpeed() {
		return movement;
	}

	@Override
	public void setSpeed(EnumSet<MovementType> movement) {
		this.movement = movement;
	}

	@Override
	public EnumSet<Sense> getSenses() {
		return senses;
	}

	@Override
	public void setSenses(EnumSet<Sense> senses) {
		this.senses = senses;
	}

	@Override
	public int[] getHitDice() {
		return hitDice;
	}

	@Override
	public void setHitDice(int[] hitDice) {
		this.hitDice = hitDice;
	}

	@Override
	public int[] getAbilityScores() {
		return abilityScores;
	}

	@Override
	public void setAbilityScores(int[] abilityScores) {
		this.abilityScores = abilityScores;
	}

	@Override
	public int[] getAbilityCeiling() {
		return abilityCeiling;
	}

	@Override
	public void setAbilityCeiling(int[] abilityCeiling) {
		this.abilityCeiling = abilityCeiling;
	}

	@Override
	public int[] getSavingThrows() {
		return savingThrows;
	}

	@Override
	public EnumSet<Energy> getResistance() {
		return energyResistance;
	}

	@Override
	public void setResistance(EnumSet<Energy> resistance) {
		this.energyResistance = resistance;
	}

	@Override
	public EnumSet<Energy> getEnergyImmunity() {
		return energyImmunity;
	}

	@Override
	public void setEnergyImmunity(EnumSet<Energy> energyImmunity) {
		this.energyImmunity = energyImmunity;
	}

	@Override
	public EnumSet<Condition> getConditionImmunity() {
		return conditionImmunity;
	}

	@Override
	public void setConditionImmunity(EnumSet<Condition> conditionImmunity) {
		this.conditionImmunity = conditionImmunity;
	}

	@Override
	public EnumSet<Condition> getConditions() {
		return conditions;
	}

	@Override
	public void setConditions(EnumSet<Condition> conditions) {
		this.conditions = conditions;
	}

}
