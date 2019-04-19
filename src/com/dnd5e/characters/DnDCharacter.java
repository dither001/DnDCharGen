package com.dnd5e.characters;

import java.util.ArrayList;
import java.util.List;

import com.dnd5e.classes.*;
import com.dnd5e.definitions.combat.*;
import com.dnd5e.definitions.rules.*;
import com.dnd5e.magic.*;
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

		s += String.format("%s- %s %s %s %s %d (%s) %s \n", name, alignment.abbreviation(),
				isFemale ? "female" : "male", race.abbreviation(), job.toString(), level, subclass.toString(),
				background.toString());
		s += "worships " + god.toString() + "\n";
		s += abilityArrayToString() + "\n";

		int spellbookSize = 0;
		List<Spell> spellbookSpells = null;
		try {
			spellbookSize = inventory.getSpellbookSpells().size();
			spellbookSpells = inventory.getSpellbookSpells();
		} catch (ItemNotPresentException e) {
			// e.printStackTrace();
		}

		s += languages.toString() + "\n";
		s += String.format("%s%n", commonSkills.toString());
		s += specialSkills.size() > 0 ? String.format("%s %n", specialSkills.toString()) : "";
		s += armorSkills.size() > 0 ? String.format("%s %n", armorSkills.toString()) : "";
		s += weaponSkills.size() > 0 ? String.format("%s %n", weaponSkills.toString()) : "";
		s += String.format("%s %n", features.toString());
		s += innateSpells.size() > 0 ? String.format("%10s %s %n", "Innate:", innateSpells.toString()) : "";
		s += cantripsKnown.size() > 0 ? String.format("%10s %s %n", "Cantrips:", cantripsKnown.toString()) : "";
		s += spellsKnown.size() > 0 ? String.format("(x%2d) %s %n", spellsKnown.size(), spellsKnown.toString()) : "";
		s += spellbookSize > 0 ? String.format("%10s %s %n", "Spellbook:", spellbookSpells.toString()) : "";
		s += String.format("(x%2d) %s %n", classFeatures.size(), classFeatures.toString());

		s += inventory.toString() + "\n";

		// attack options
		for (Attack el : inventory.weaponAttackList())
			s += el + "\n";

		return s;
	}

	@Override
	public void updateHitPoints() {
		int hp = 0, conMod = getConstitutionModifier();

		for (int i = 0; i < level; ++i)
			hp += hitDice[i] + conMod;

		this.maximumHitPoints = hp;
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
		toon.setBackground(Background.randomSkewMedieval());
		toon.setGod(God.selectGod(toon));

		RacialFeature.setup(toon);
		Background.apply(toon);
		ClassFeature.setup(toon);

		toon.setName(CharacterName.randomName(toon.isFemale, toon.race));
		JobClass.setupStartingGear(toon);

		return toon;
	}

	public static List<DnDCharacter> rollCharacters(int n) {
		List<DnDCharacter> list = new ArrayList<DnDCharacter>(n);
		for (int i = 0; i < n; ++i)
			list.add(random());

		return list;
	}

}
