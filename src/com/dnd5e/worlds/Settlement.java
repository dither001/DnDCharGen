package com.dnd5e.worlds;

import com.dnd3e.definitions.towns.SettlementType;

public class Settlement {

	/*
	 * INSTANCE FIELDS
	 */
	private SettlementType type;
	private int population;

	/*
	 * CONSTRUCTORS
	 */
	private Settlement() {

	}

	public String toString() {
		return type.toString();
	}

	public String toStringVerbose() {
		String s = "";

		s += type.toString() + "\n";
		s += "Pop: " + population + "\n";
		s += "Mod: " + SettlementType.communityModifier(type) + "\n";
		s += "GP: " + SettlementType.currencyLimit(type) + "\n";

		return s;
	}

	/*
	 * INSTANCE METHODS
	 */
	public SettlementType getType() {
		return type;
	}

	public void setType(SettlementType type) {
		this.type = type;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	/*
	 * STATIC METHODS
	 */
	public static Settlement buildRandom() {
		return build(SettlementType.randomType());
	}

	public static Settlement build(SettlementType type) {
		Settlement s = new Settlement();

		s.setType(type);
		s.setPopulation(SettlementType.randomPopulation(s.type));

		return s;
	}

}
