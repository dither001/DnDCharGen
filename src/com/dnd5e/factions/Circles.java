package com.dnd5e.factions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.dnd5e.characters.*;
import com.dnd5e.definitions.rules.*;
import com.dnd5e.worlds.God;

public class Circles {
	private HashMap<Alignment, List<DnDCharacter>> alignmentMap;
	private HashMap<Background, List<DnDCharacter>> backgroundMap;
	private HashMap<DnDClass, List<DnDCharacter>> classMap;
	private HashMap<God, List<DnDCharacter>> godMap;
	private HashMap<Race, List<DnDCharacter>> raceMap;
	private HashMap<Subclass, List<DnDCharacter>> subclassMap;

	/*
	 * CONSTRUCTORS
	 */
	private Circles() {
		// ALIGNMENTS
		this.setAlignmentMap(new HashMap<Alignment, List<DnDCharacter>>());
		for (Alignment el : Alignment.list()) {
			alignmentMap.put(el, new ArrayList<DnDCharacter>());
		}

		// BACKGROUNDS
		this.setBackgroundMap(new HashMap<Background, List<DnDCharacter>>());
		for (Background el : Background.list()) {
			backgroundMap.put(el, new ArrayList<DnDCharacter>());
		}

		// CLASSES
		this.setClassMap(new HashMap<DnDClass, List<DnDCharacter>>());
		for (DnDClass el : DnDClass.list()) {
			classMap.put(el, new ArrayList<DnDCharacter>());
		}

		// GODS
		this.setGodMap(new HashMap<God, List<DnDCharacter>>());
		for (God el : God.list()) {
			godMap.put(el, new ArrayList<DnDCharacter>());
		}

		// RACES
		this.setRaceMap(new HashMap<Race, List<DnDCharacter>>());
		for (Race el : Race.list()) {
			raceMap.put(el, new ArrayList<DnDCharacter>());
		}

		// SUBCLASSES
		this.setSubclassMap(new HashMap<Subclass, List<DnDCharacter>>());
		for (Subclass el : Subclass.list()) {
			subclassMap.put(el, new ArrayList<DnDCharacter>());
		}

	}

	/*
	 * INSTANCE METHODS
	 */
	public String toString() {
		String s = "";

		s += "\n";
		s += "Alignment:\n";
		for (Alignment el : alignmentMap.keySet()) {
			int amount = alignmentMap.get(el).size();
			s += String.format("%20s (%6s) %n", el.toString(), amount);
		}

		s += "\n";
		s += "Backgrounds:\n";
		for (Background el : backgroundMap.keySet()) {
			int amount = backgroundMap.get(el).size();
			s += String.format("%20s (%6s) %n", el.toString(), amount);
		}

		s += "\n";
		s += "Classes:\n";
		for (DnDClass el : classMap.keySet()) {
			int amount = classMap.get(el).size();
			s += String.format("%20s (%6s) %n", el.toString(), amount);
		}

		s += "\n";
		s += "Gods:\n";
		for (God el : godMap.keySet()) {
			int amount = godMap.get(el).size();
			s += String.format("%20s (%6s) %n", el.toString(), amount);
		}

		s += "\n";
		s += "Races:\n";
		for (Race el : raceMap.keySet()) {
			int amount = raceMap.get(el).size();
			s += String.format("%20s (%6s) %n", el.toString(), amount);
		}

		s += "\n";
		s += "Subclasses:\n";
		for (Subclass el : subclassMap.keySet()) {
			int amount = subclassMap.get(el).size();
			s += String.format("%20s (%6s) %n", el.toString(), amount);
		}

		return s;
	}

	public HashMap<Alignment, List<DnDCharacter>> getAlignmentMap() {
		return alignmentMap;
	}

	public void setAlignmentMap(HashMap<Alignment, List<DnDCharacter>> alignmentMap) {
		this.alignmentMap = alignmentMap;
	}

	public HashMap<Background, List<DnDCharacter>> getBackgroundMap() {
		return backgroundMap;
	}

	public void setBackgroundMap(HashMap<Background, List<DnDCharacter>> backgroundMap) {
		this.backgroundMap = backgroundMap;
	}

	public HashMap<DnDClass, List<DnDCharacter>> getClassMap() {
		return classMap;
	}

	public void setClassMap(HashMap<DnDClass, List<DnDCharacter>> classMap) {
		this.classMap = classMap;
	}

	public HashMap<God, List<DnDCharacter>> getGodMap() {
		return godMap;
	}

	public void setGodMap(HashMap<God, List<DnDCharacter>> godMap) {
		this.godMap = godMap;
	}

	public HashMap<Race, List<DnDCharacter>> getRaceMap() {
		return raceMap;
	}

	public void setRaceMap(HashMap<Race, List<DnDCharacter>> raceMap) {
		this.raceMap = raceMap;
	}

	public HashMap<Subclass, List<DnDCharacter>> getSubclassMap() {
		return subclassMap;
	}

	public void setSubclassMap(HashMap<Subclass, List<DnDCharacter>> subclassMap) {
		this.subclassMap = subclassMap;
	}

	/*
	 * STATIC METHODS
	 */
	public static Circles build(List<DnDCharacter> list) {
		Circles circle = new Circles();

		for (DnDCharacter el : list) {
			circle.alignmentMap.get(el.getAlignment()).add(el);
			circle.backgroundMap.get(el.getBackground()).add(el);
			circle.classMap.get(el.getJob()).add(el);
			circle.godMap.get(el.getGod()).add(el);
			circle.raceMap.get(el.getRace()).add(el);
			circle.subclassMap.get(el.getSubclass()).add(el);
		}

		return circle;
	}

}
