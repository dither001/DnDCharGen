package com.dnd5e.character.definitions;

import com.dnd5e.character.classes.ClassFeature;
import com.dnd5e.character.classes.DnDClass;
import com.dnd5e.character.classes.Hero;
import com.dnd5e.character.classes.Subclass;
import com.dnd5e.combat.definitions.*;
import com.dnd5e.definitions.*;
import com.dnd5e.gear.equipment.InventoryBuilder;
import com.dnd5e.worlds.*;
import com.miscellaneous.util.*;

public class DnDCharacter extends Hero {

	public DnDCharacter() {
		super();
	}

	/*
	 * INSTANCE METHODS
	 */
	public String toString() {
		return String.format("%s %s %s %s (%s) %s", alignment.abbreviation(), isFemale ? "female" : "male",
				race.abbreviation(), job.toString(), subclass.toString(), background.toString());
	}

	public String toStringVerbose() {
		String s = "";

		s += String.format("%s %s %s %s (%s) %s \n", alignment.abbreviation(), isFemale ? "female" : "male",
				race.abbreviation(), job.toString(), subclass.toString(), background.toString());
		s += "worships " + god.toString() + "\n";
		s += abilityArrayToString() + "\n";
		s += skills.toString() + "\n";

		s += features.toString() + "\n";
		s += cantripsKnown.size() > 0 ? cantripsKnown.toString() + "\n" : "";
		s += spellsKnown.size() > 0 ? spellsKnown.toString() + "\n" : "";
		s += classFeatures.toString() + "\n";

		s += inventory.toString() + "\n";

		// attack options
		for (Attack el : inventory.weaponAttackList())
			s += el + "\n";

		return s;
	}

	/*
	 * STATIC METHODS
	 */
	public static DnDCharacter random() {
		DnDCharacter toon = new DnDCharacter();

		toon.makePersistent(false);
		toon.markChanged(true);
		// toon.setID(id);

		toon.setAbilityScores(Dice.roll3d6InOrder());
		toon.setAbilityCeiling(new int[] { 20, 20, 20, 20, 20, 20 });
		toon.setFemale(toon.getStrength() > toon.getConstitution());

		toon.setAlignment(Alignment.randomSkewEvil());
		toon.setJob(DnDClass.selectClass(toon));
		toon.setSubclass(Subclass.selectSubclass(toon));
		toon.setRace(Race.randomSkewHuman());
		toon.setBackground(Background.random());
		toon.setGod(God.selectGod(toon));
		
		RacialFeature.apply(toon);
		ClassFeature.apply(1, toon);

		toon.setName(CharacterName.randomName(toon.isFemale, toon.race));
		InventoryBuilder.setupStartingGear(toon);

		return toon;
	}

	@Override
	public void updateHitPoints() {
		int hp = 0, conMod = getConstitutionModifier();

		for (int i = 0; i < level; ++i)
			hp += hitDice[i] + conMod;

		this.maximumHitPoints = hp;
	}

}
