package com.dnd5e.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

import com.dnd5e.characters.*;
import com.dnd5e.definitions.rules.*;
import com.dnd5e.equipment.*;
import com.dnd5e.magic.*;
import com.miscellaneous.util.*;

public abstract class Wizard extends JobClass {
	private static final DnDClass CLAZZ;
	private static final RacialFeature[] SAVING_THROWS;
	private static final Skill[] CLASS_SKILLS;
	private static final int NUMBER_OF_SKILLS;

	static {
		CLAZZ = DnDClass.WIZARD;
		SAVING_THROWS = DnDClass.getSavingThrows(CLAZZ);
		CLASS_SKILLS = Skill.getClassSkills(CLAZZ);
		NUMBER_OF_SKILLS = DnDClass.getNumberOfSkills(CLAZZ);
	}

	public static void setup(Hero actor) {
		// CLASS FEATURES
		apply(1, actor);

		// SAVING THROWS
		actor.getFeatures().addAll(Misc.arrayToList(SAVING_THROWS));

		// SKILLS & WEAPON/ARMOR PROFICIENCY
		Misc.tryToAddN(NUMBER_OF_SKILLS, CLASS_SKILLS, actor.getCommonSkills());

		actor.getWeaponSkills().addAll(Skill.wizardWeapons());

		Spell.addCantrip(3, CLAZZ, actor.getCantripsKnown());
		actor.getClassFeatures().add(ClassFeature.RITUAL_CASTING_WIZARD);
		actor.getSpecialSkills().add(Skill.ARCANE_FOCUS);
	}

	public static void setupStartingGear(Hero actor) {
		/*
		 * INVENTORY
		 */
		Inventory inv = actor.getInventory();

		// FIRST CHOICE
		int dice = Dice.roll(2);
		if (dice == 1) {
			inv.addWeaponHelper(Skill.QUARTERSTAFF);

		} else {
			inv.addWeaponHelper(Skill.DAGGER);

		}

		// TODO - component pouch or arcane focus
		// TODO - add scholar's or explorer's pack

		// spellbook
		Spellbook spellbook = Spellbook.build();
		spellbook.setName(actor.getName() + "'s " + "spellbook");

		inv.addSpellbook(spellbook);

		// FINAL STEP
		actor.setInventory(inv);
	}

	public static void apply(int level, Hero actor) {
		EnumSet<ClassFeature> features = actor.getClassFeatures();
		int numberOfSpells = 2;
		int spellLevel = level < 18 ? (level + 1) / 2 : 9;

		Subclass subclass = actor.getSubclass();
		switch (level) {
		case 1:
			features.add(ClassFeature.ARCANE_RECOVERY);

			break;
		case 2:
			// UPDATE SPELLBOOK
			updateSpellbook(numberOfSpells, spellLevel, actor);

			/*
			 * ARCANE TRADITION
			 */
			if (subclass.equals(Subclass.ABJURER)) {
				features.add(ClassFeature.ABJURATION_SAVANT);
				features.add(ClassFeature.ARCANE_WARD);

			} else if (subclass.equals(Subclass.CONJUROR)) {
				features.add(ClassFeature.CONJURATION_SAVANT);
				features.add(ClassFeature.MINOR_CONJURATION);

			} else if (subclass.equals(Subclass.DIVINER)) {
				features.add(ClassFeature.DIVINATION_SAVANT);
				features.add(ClassFeature.PORTENT);

			} else if (subclass.equals(Subclass.ENCHANTER)) {
				features.add(ClassFeature.ENCHANTMENT_SAVANT);
				features.add(ClassFeature.HYPNOTIC_GAZE);

			} else if (subclass.equals(Subclass.EVOKER)) {
				features.add(ClassFeature.EVOCATION_SAVANT);
				features.add(ClassFeature.SCULPT_SPELLS);

			} else if (subclass.equals(Subclass.ILLUSIONIST)) {
				features.add(ClassFeature.ILLUSION_SAVANT);
				features.add(ClassFeature.IMPROVED_MINOR_ILLUSION);

			} else if (subclass.equals(Subclass.NECROMANCER)) {
				features.add(ClassFeature.NECROMANCY_SAVANT);
				features.add(ClassFeature.GRIM_HARVEST);

			} else if (subclass.equals(Subclass.TRANSMUTER)) {
				features.add(ClassFeature.TRANSMUTATION_SAVANT);
				features.add(ClassFeature.MINOR_ALCHEMY);

			}

			break;
		case 3:
			// UPDATE SPELLBOOK
			updateSpellbook(numberOfSpells, spellLevel, actor);

			break;
		case 4:
			// UPDATE SPELLBOOK
			updateSpellbook(numberOfSpells, spellLevel, actor);

			// NEW CANTRIP
			Spell.addCantrip(CLAZZ, actor.getCantripsKnown());

			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_4);
			improveAbility(actor);

			break;
		case 5:
			// UPDATE SPELLBOOK
			updateSpellbook(numberOfSpells, spellLevel, actor);

			break;
		case 6:
			// UPDATE SPELLBOOK
			updateSpellbook(numberOfSpells, spellLevel, actor);

			/*
			 * ARCANE TRADITION
			 */
			if (subclass.equals(Subclass.ABJURER)) {
				features.add(ClassFeature.PROJECTED_WARD);

			} else if (subclass.equals(Subclass.CONJUROR)) {
				features.add(ClassFeature.BENIGN_TRANSPOSITION);

			} else if (subclass.equals(Subclass.DIVINER)) {
				features.add(ClassFeature.EXPERT_DIVINATION);

			} else if (subclass.equals(Subclass.ENCHANTER)) {
				features.add(ClassFeature.INSTINCTIVE_CHARM);

			} else if (subclass.equals(Subclass.EVOKER)) {
				features.add(ClassFeature.POTENT_CANTRIP);

			} else if (subclass.equals(Subclass.ILLUSIONIST)) {
				features.add(ClassFeature.MALLEABLE_ILLUSIONS);

			} else if (subclass.equals(Subclass.NECROMANCER)) {
				features.add(ClassFeature.UNDEAD_THRALLS);

			} else if (subclass.equals(Subclass.TRANSMUTER)) {
				features.add(ClassFeature.TRANSMUTERS_STONE);

			}

			break;
		case 7:
			// UPDATE SPELLBOOK
			updateSpellbook(numberOfSpells, spellLevel, actor);

			break;
		case 8:
			// UPDATE SPELLBOOK
			updateSpellbook(numberOfSpells, spellLevel, actor);

			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_8);
			improveAbility(actor);

			break;
		case 9:
			// UPDATE SPELLBOOK
			updateSpellbook(numberOfSpells, spellLevel, actor);

			break;
		case 10:
			// UPDATE SPELLBOOK
			updateSpellbook(numberOfSpells, spellLevel, actor);

			// NEW CANTRIP
			Spell.addCantrip(CLAZZ, actor.getCantripsKnown());

			/*
			 * ARCANE TRADITION
			 */
			if (subclass.equals(Subclass.ABJURER)) {
				features.add(ClassFeature.IMPROVED_ABJURATION);

			} else if (subclass.equals(Subclass.CONJUROR)) {
				features.add(ClassFeature.FOCUSED_CONJURATION);

			} else if (subclass.equals(Subclass.DIVINER)) {
				features.add(ClassFeature.THE_THIRD_EYE);

			} else if (subclass.equals(Subclass.ENCHANTER)) {
				features.add(ClassFeature.SPLIT_ENCHANTMENT);

			} else if (subclass.equals(Subclass.EVOKER)) {
				features.add(ClassFeature.EMPOWERED_EVOCATION);

			} else if (subclass.equals(Subclass.ILLUSIONIST)) {
				features.add(ClassFeature.ILLUSORY_SELF);

			} else if (subclass.equals(Subclass.NECROMANCER)) {
				features.add(ClassFeature.INURED_TO_DEATH);

			} else if (subclass.equals(Subclass.TRANSMUTER)) {
				features.add(ClassFeature.SHAPECHANGER);

			}

			break;
		case 11:
			// UPDATE SPELLBOOK
			updateSpellbook(numberOfSpells, spellLevel, actor);

			break;
		case 12:
			// UPDATE SPELLBOOK
			updateSpellbook(numberOfSpells, spellLevel, actor);

			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_12);
			improveAbility(actor);

			break;
		case 13:
			// UPDATE SPELLBOOK
			updateSpellbook(numberOfSpells, spellLevel, actor);

			break;
		case 14:
			// UPDATE SPELLBOOK
			updateSpellbook(numberOfSpells, spellLevel, actor);

			/*
			 * ARCANE TRADITION
			 */
			if (subclass.equals(Subclass.ABJURER)) {
				features.add(ClassFeature.ABJURER_RESISTANCE);

			} else if (subclass.equals(Subclass.CONJUROR)) {
				features.add(ClassFeature.DURABLE_SUMMONS);

			} else if (subclass.equals(Subclass.DIVINER)) {
				features.add(ClassFeature.GREATER_PORTENT);

			} else if (subclass.equals(Subclass.ENCHANTER)) {
				features.add(ClassFeature.ALTER_MEMORIES);

			} else if (subclass.equals(Subclass.EVOKER)) {
				features.add(ClassFeature.OVERCHANNEL);

			} else if (subclass.equals(Subclass.ILLUSIONIST)) {
				features.add(ClassFeature.ILLUSORY_REALITY);

			} else if (subclass.equals(Subclass.NECROMANCER)) {
				features.add(ClassFeature.COMMAND_UNDEAD);

			} else if (subclass.equals(Subclass.TRANSMUTER)) {
				features.add(ClassFeature.MASTER_TRANSMUTER);

			}

			break;
		case 15:
			// UPDATE SPELLBOOK
			updateSpellbook(numberOfSpells, spellLevel, actor);

			break;
		case 16:
			// UPDATE SPELLBOOK
			updateSpellbook(numberOfSpells, spellLevel, actor);

			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_16);
			improveAbility(actor);

			break;
		case 17:
			// UPDATE SPELLBOOK
			updateSpellbook(numberOfSpells, spellLevel, actor);

			break;
		case 18:
			// UPDATE SPELLBOOK
			updateSpellbook(numberOfSpells, spellLevel, actor);

			features.add(ClassFeature.SPELL_MASTERY);
			spellMastery(actor);

			break;
		case 19:
			// UPDATE SPELLBOOK
			updateSpellbook(numberOfSpells, spellLevel, actor);

			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_19);
			improveAbility(actor);

			break;
		case 20:
			// UPDATE SPELLBOOK
			updateSpellbook(numberOfSpells, spellLevel, actor);

			features.add(ClassFeature.SIGNATURE_SPELL);
			signatureSpell(actor);

			break;
		}

		actor.setClassFeatures(features);
	}

	/*
	 * PRIVATE METHODS
	 */
	private static void updateSpellbook(int n, int level, Hero actor) {
		List<Spell> list = Spell.spellsList(level, CLAZZ);

		// remove known spells
		try {
			list.removeAll(actor.getInventory().getSpellbookSpells());

			if (list.size() >= n) {
				int[] levels = Misc.initializeArray(n, level);
				Spell[] spells = new Spell[n];

				Collections.shuffle(list);
				for (int i = 0; i < n; ++i)
					spells[i] = list.get(i);

				actor.getInventory().updateSpellbook(levels, spells);
			}

		} catch (ItemNotPresentException e) {
			e.printStackTrace();
		}
	}

	private static void spellMastery(Hero actor) {
		List<Spell>[] array = null;
		List<Spell> innateSpells = null;

		try {
			array = actor.getInventory().getSpellbookSpellsByLevel();
			innateSpells = new ArrayList<Spell>(actor.getInnateSpells().getSpellsList());

			List<Spell> firstLevelSpells = array[1];
			firstLevelSpells.removeAll(innateSpells);
			actor.getInnateSpells().add(1, Misc.randomFromList(firstLevelSpells));

			List<Spell> secondLevelSpells = array[2];
			secondLevelSpells.removeAll(innateSpells);
			actor.getInnateSpells().add(2, Misc.randomFromList(secondLevelSpells));

		} catch (ItemNotPresentException e) {
			e.printStackTrace();
		}
	}

	private static void signatureSpell(Hero actor) {
		int spellLevel = 3;
		List<Spell> innateSpells = null, spells = null;

		try {
			innateSpells = new ArrayList<Spell>(actor.getInnateSpells().getSpellsList());
			spells = actor.getInventory().getSpellbookSpellsByLevel(spellLevel);

			// remove existing
			spells.removeAll(innateSpells);
			Collections.shuffle(spells);

			actor.getInnateSpells().add(1, spells.get(0));
			actor.getInnateSpells().add(1, spells.get(1));

		} catch (ItemNotPresentException e) {
			e.printStackTrace();
		}

	}
}
