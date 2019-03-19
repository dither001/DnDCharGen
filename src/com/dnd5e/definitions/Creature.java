package com.dnd5e.definitions;

import java.util.EnumSet;

import com.dnd5e.gear.equipment.*;
import com.dnd5e.magic.*;
import com.dnd5e.worlds.*;

public interface Creature {

	/*
	 * BASIC DESCRIPTION
	 */
	public String getName();

	public void setName(String name);

	public boolean isFemale();

	public void setFemale(boolean isFemale);

	public Alignment getAlignment();

	public void setAlignment(Alignment alignment);

	public God getGod();

	public void setGod(God god);

	public Size getCreatureSize();

	public void setCreatureSize(Size size);

	public CreatureType getCreatureType();

	public void setCreatureType(CreatureType creatureType);

	public EnumSet<MovementType> getSpeed();

	public void setSpeed(EnumSet<MovementType> movement);

	public EnumSet<Sense> getSenses();

	public void setSenses(EnumSet<Sense> senses);

	public EnumSet<Language> getLanguages();

	public void setLanguages(EnumSet<Language> Languages);

	public EnumSet<RacialFeature> getFeatures();

	public void setFeatures(EnumSet<RacialFeature> features);
	
	public EnumSet<Spell> getCantripsKnown();

	public void setCantripsKnown(EnumSet<Spell> cantripsKnown);

	public EnumSet<Spell> getSpellsKnown();

	public void setSpellsKnown(EnumSet<Spell> spellsKnown);

	/*
	 * COMBAT STATS
	 */
	public int getCurrentHitPoints();

	public void setCurrentHitPoints(int currentHitPoints);

	public int getMaximumHitPoints();

	public void setMaximumHitPoints(int maximumHitPoints);

	public int[] getHitDice();

	public void setHitDice(int[] hitDice);

	public int[] getAbilityScores();

	public void setAbilityScores(int[] abilityScores);

	public int[] getAbilityCeiling();

	public void setAbilityCeiling(int[] abilityCeiling);

	public int[] getSavingThrows();

	public EnumSet<Skill> getSkills();

	public void setSkills(EnumSet<Skill> skills);

	/*
	 * STATUS EFFECTS
	 */
	public EnumSet<EnergyType> getResistance();

	public void setResistance(EnumSet<EnergyType> resistance);

	public EnumSet<EnergyType> getEnergyImmunity();

	public void setEnergyImmunity(EnumSet<EnergyType> energyImmunity);

	public EnumSet<Condition> getConditionImmunity();

	public void setConditionImmunity(EnumSet<Condition> conditionImmunity);

	public EnumSet<Condition> getConditions();

	public void setConditions(EnumSet<Condition> conditions);

	/*
	 * ITEMS / INVENTORY
	 */
	public Inventory getInventory();
 
	public void setInventory(Inventory inventory);

	/*
	 * DEFAULT METHODS
	 */
	public default boolean isSmall() {
		return getCreatureSize().equals(Size.SMALL);
	}

	public default boolean isMedium() {
		return getCreatureSize().equals(Size.MEDIUM);
	}

	public default String abilityArrayToString() {
		int[] array = getAbilityScores();

		String s = "";
		s += array[0] + ", ";
		s += array[1] + ", ";
		s += array[2] + ", ";
		s += array[3] + ", ";
		s += array[4] + ", ";
		s += array[5];

		return String.format("[ %-22s ]", s);
	}

	public default int getStrength() {
		return getAbilityScores()[0];
	}

	public default int getDexterity() {
		return getAbilityScores()[1];
	}

	public default int getConstitution() {
		return getAbilityScores()[2];
	}

	public default int getIntelligence() {
		return getAbilityScores()[3];
	}

	public default int getWisdom() {
		return getAbilityScores()[4];
	}

	public default int getCharisma() {
		return getAbilityScores()[5];
	}

	public default boolean setAbilityScore(int index, int bonus) {
		boolean set = false;
		int ability = getAbilityScores()[index], ceiling = getAbilityCeiling()[index];

		// FIXME - testing
		int[] newScores = getAbilityScores();
		if (ability <= ceiling) {
			set = true;
			newScores[index] = bonus;
			setAbilityScores(newScores);
		}

		return set;
	}

	public default boolean setStrength(int bonus) {
		return setAbilityScore(0, bonus);
	}

	public default boolean setDexterity(int bonus) {
		return setAbilityScore(1, bonus);
	}

	public default boolean setConstitution(int bonus) {
		return setAbilityScore(2, bonus);
	}

	public default boolean setIntelligence(int bonus) {
		return setAbilityScore(3, bonus);
	}

	public default boolean setWisdom(int bonus) {
		return setAbilityScore(4, bonus);
	}

	public default boolean setCharisma(int bonus) {
		return setAbilityScore(5, bonus);
	}

	public default boolean prefersFinesse() {
		return getDexterityModifier() > getStrengthModifier();
	}
	
	/*
	 * ABILITY MODIFIER GETTERS
	 */
	public default int getAbilityModifier(int index) {
		int ability = getAbilityScores()[index];
		return (ability > 9) ? (ability - 10) / 2 : (ability - 11) / 2;
	}

	public default int getStrengthModifier() {
		return getAbilityModifier(0);
	}

	public default int getDexterityModifier() {
		return getAbilityModifier(1);
	}

	public default int getConstitutionModifier() {
		return getAbilityModifier(2);
	}

	public default int getIntelligenceModifier() {
		return getAbilityModifier(3);
	}

	public default int getWisdomModifier() {
		return getAbilityModifier(4);
	}

	public default int getCharismaModifier() {
		return getAbilityModifier(5);
	}

	/*
	 * SKILL METHODS
	 */
	public default void updateHitPoints() {
		int hp = 0, conMod = getConstitutionModifier();

		for (int el : getHitDice())
			hp += el + conMod;

		setMaximumHitPoints(hp);
	}

	public default int getProficiencyBonus() {
		int bonus = 2;
		int hitDice = getHitDice().length;

		if (hitDice > 16)
			bonus = 6;
		else if (hitDice > 12)
			bonus = 5;
		else if (hitDice > 8)
			bonus = 4;
		else if (hitDice > 4)
			bonus = 3;

		return bonus;
	}
}
