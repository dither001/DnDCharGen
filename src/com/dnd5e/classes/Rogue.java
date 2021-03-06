package com.dnd5e.classes;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import com.dnd5e.characters.*;
import com.dnd5e.definitions.magic.School;
import com.dnd5e.definitions.magic.Spell;
import com.dnd5e.definitions.skills.Skill;
import com.dnd5e.equipment.*;
import com.dnd5e.magic.*;
import com.miscellaneous.util.*;

public abstract class Rogue extends JobClass {
	private static final DnDClass CLAZZ;
	private static final RacialFeature[] SAVING_THROWS;
	private static final Skill[] CLASS_SKILLS;
	private static final int NUMBER_OF_SKILLS;

	//
	private static final DnDClass CASTING_CLASS;
	private static final School[] ARCANE_TRICKSTER_SCHOOLS;
	private static final Skill[] ASSASSIN_SKILLS;

	static {
		CLAZZ = DnDClass.ROGUE;
		SAVING_THROWS = DnDClass.getSavingThrows(CLAZZ);
		CLASS_SKILLS = Skill.getClassSkills(CLAZZ);
		NUMBER_OF_SKILLS = DnDClass.getNumberOfSkills(CLAZZ);

		//
		CASTING_CLASS = DnDClass.WIZARD;
		ARCANE_TRICKSTER_SCHOOLS = new School[] { School.ENCHANTMENT, School.ILLUSION };
		ASSASSIN_SKILLS = new Skill[] { Skill.DISGUISE_KIT, Skill.POISONER_KIT };

	}

	public static void setup(Hero actor) {
		// CLASS FEATURES
		apply(1, actor);

		// SAVING THROWS
		actor.getFeatures().addAll(Misc.arrayToList(SAVING_THROWS));

		// SKILLS & WEAPON/ARMOR PROFICIENCY
		Misc.tryToAddN(NUMBER_OF_SKILLS, CLASS_SKILLS, actor.getCommonSkills());
		actor.getSpecialSkills().add(Skill.THIEVES_TOOLS);

		actor.getArmorSkills().addAll(Skill.lightArmorList());
		actor.getWeaponSkills().addAll(Skill.simpleWeaponList());
		actor.getWeaponSkills().addAll(Skill.rogueWeapons());
	}

	public static void setupStartingGear(Hero actor) {
		/*
		 * INVENTORY
		 */
		Inventory inv = actor.getInventory();

		// FIRST CHOICE
		int dice = Dice.roll(2);
		if (dice == 1) {
			inv.addWeaponHelper(Skill.RAPIER);

		} else {
			inv.addWeaponHelper(Skill.SHORTSWORD);

		}

		// SECOND CHOICE
		dice = Dice.roll(2);
		if (dice == 1) {
			inv.addWeaponHelper(Skill.SHORTBOW);
			inv.addAmmunition(Skill.SHORTBOW);

		} else {
			inv.addWeaponHelper(Skill.SHORTSWORD);

		}

		// TODO - add burglar's or dungeoneer's or explorer's pack
		// TODO - receive thieves' tool
		inv.addGearHelper(1, "thieves tools");
		inv.addArmorHelper(Skill.LEATHER_ARMOR);
		inv.addWeaponHelper(Skill.DAGGER);
		inv.addWeaponHelper(Skill.DAGGER);

		// FINAL STEP
		actor.setInventory(inv);
	}

	public static void apply(int level, Hero actor) {
		EnumSet<ClassFeature> features = actor.getClassFeatures();

		Subclass subclass = actor.getSubclass();
		switch (level) {
		case 1:
			features.add(ClassFeature.SNEAK_ATTACK_1);
			ClassFeature.addRandomExpertise(2, actor);

			break;
		case 2:
			features.add(ClassFeature.CUNNING_ACTION);

			break;
		case 3:
			features.add(ClassFeature.SNEAK_ATTACK_2);

			/*
			 * THIEF ARCHETYPE
			 */
			if (subclass.equals(Subclass.THIEF)) {
				features.add(ClassFeature.FAST_HANDS);
				features.add(ClassFeature.SECOND_STORY_WORK);

			} else if (subclass.equals(Subclass.ASSASSIN)) {
				Misc.tryToAddAll(ASSASSIN_SKILLS, actor.getSpecialSkills());
				features.add(ClassFeature.ASSASSINATE);

			} else if (subclass.equals(Subclass.ARCANE_TRICKSTER)) {
				Misc.tryToAdd(Spell.MAGE_HAND, actor.getCantripsKnown());
				features.add(ClassFeature.MAGE_HAND_LEGERDEMAIN);
				Spell.addCantrip(2, CASTING_CLASS, actor.getCantripsKnown());
				addArcaneTricksterSpell(3, 1, actor.getSpellsKnown());

			}

			break;
		case 4:
			// ARCANE TRICKSTER SPELL
			if (subclass.equals(Subclass.ARCANE_TRICKSTER)) {
				addArcaneTricksterSpell(1, 1, actor.getSpellsKnown());
			}

			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_4);
			improveAbility(actor);

			break;
		case 5:
			features.add(ClassFeature.SNEAK_ATTACK_3);
			features.add(ClassFeature.UNCANNY_DODGE);

			break;
		case 6:
			break;
		case 7:
			// ARCANE TRICKSTER SPELL
			if (subclass.equals(Subclass.ARCANE_TRICKSTER)) {
				addArcaneTricksterSpell(1, 2, actor.getSpellsKnown());
			}

			features.add(ClassFeature.SNEAK_ATTACK_4);
			features.add(ClassFeature.EVASION);

			break;
		case 8:
			// ARCANE TRICKSTER FREEBIE
			if (subclass.equals(Subclass.ARCANE_TRICKSTER)) {
				Spell.addSpell(2, CASTING_CLASS, actor.getSpellsKnown());
			}

			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_8);
			improveAbility(actor);

			break;
		case 9:
			features.add(ClassFeature.SNEAK_ATTACK_5);

			/*
			 * THIEF ARCHETYPE
			 */
			if (subclass.equals(Subclass.THIEF)) {
				features.add(ClassFeature.SUPREME_SNEAK);

			} else if (subclass.equals(Subclass.ASSASSIN)) {
				features.add(ClassFeature.INFILTRATION_EXPERTISE);

			} else if (subclass.equals(Subclass.ARCANE_TRICKSTER)) {
				features.add(ClassFeature.MAGICAL_AMBUSH);

			}

			break;
		case 10:
			// ARCANE TRICKSTER CANTRIP & SPELL
			if (subclass.equals(Subclass.ARCANE_TRICKSTER)) {
				Spell.addCantrip(CASTING_CLASS, actor.getCantripsKnown());
				addArcaneTricksterSpell(1, 2, actor.getSpellsKnown());
			}

			break;
		case 11:
			// ARCANE TRICKSTER SPELL
			if (subclass.equals(Subclass.ARCANE_TRICKSTER)) {
				addArcaneTricksterSpell(1, 2, actor.getSpellsKnown());
			}

			features.add(ClassFeature.SNEAK_ATTACK_6);
			features.add(ClassFeature.RELIABLE_TALENT);

			break;
		case 12:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_12);
			improveAbility(actor);

			break;
		case 13:
			features.add(ClassFeature.SNEAK_ATTACK_7);

			/*
			 * THIEF ARCHETYPE
			 */
			if (subclass.equals(Subclass.THIEF)) {
				features.add(ClassFeature.USE_MAGIC_DEVICE);

			} else if (subclass.equals(Subclass.ASSASSIN)) {
				features.add(ClassFeature.IMPOSTOR);

			} else if (subclass.equals(Subclass.ARCANE_TRICKSTER)) {
				features.add(ClassFeature.VERSATILE_TRICKSTER);
				addArcaneTricksterSpell(1, 3, actor.getSpellsKnown());

			}

			break;
		case 14:
			// ARCANE TRICKSTER FREEBIE
			if (subclass.equals(Subclass.ARCANE_TRICKSTER)) {
				Spell.addSpell(3, CASTING_CLASS, actor.getSpellsKnown());
			}

			features.add(ClassFeature.BLINDSENSE);

			break;
		case 15:
			features.add(ClassFeature.SNEAK_ATTACK_8);
			features.add(ClassFeature.SLIPPERY_MIND);

			break;
		case 16:
			// ARCANE TRICKSTER SPELL
			if (subclass.equals(Subclass.ARCANE_TRICKSTER)) {
				addArcaneTricksterSpell(1, 3, actor.getSpellsKnown());
			}

			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_16);
			improveAbility(actor);

			break;
		case 17:
			features.add(ClassFeature.SNEAK_ATTACK_9);

			/*
			 * THIEF ARCHETYPE
			 */
			if (subclass.equals(Subclass.THIEF)) {
				features.add(ClassFeature.THIEFS_REFLEXES);

			} else if (subclass.equals(Subclass.ASSASSIN)) {
				features.add(ClassFeature.DEATH_STRIKE);

			} else if (subclass.equals(Subclass.ARCANE_TRICKSTER)) {
				features.add(ClassFeature.SPELL_THIEF);

			}

			break;
		case 18:
			features.add(ClassFeature.ELUSIVE);

			break;
		case 19:
			// ARCANE TRICKSTER SPELL
			if (subclass.equals(Subclass.ARCANE_TRICKSTER)) {
				addArcaneTricksterSpell(1, 4, actor.getSpellsKnown());
			}

			features.add(ClassFeature.SNEAK_ATTACK_10);

			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_19);
			improveAbility(actor);

			break;
		case 20:
			// ARCANE TRICKSTER FREEBIE
			if (subclass.equals(Subclass.ARCANE_TRICKSTER)) {
				Spell.addSpell(4, CASTING_CLASS, actor.getSpellsKnown());
			}

			features.add(ClassFeature.STROKE_OF_LUCK);

			break;
		}

		actor.setClassFeatures(features);
	}

	/*
	 * PRIVATE METHODS
	 */
	public static void addArcaneTricksterSpell(int n, int level, Set<Spell> spellsKnown) {
		// get initial list
		List<Spell> list = Spell.spellsList(DnDClass.WIZARD);
		// remove duplicates
		list.removeAll(spellsKnown);
		// keep
		list.retainAll(Sorcery.getSpellsOfSchool(level, ARCANE_TRICKSTER_SCHOOLS));

		if (list.size() > 0) {
			Collections.shuffle(list);
			for (int i = 0; i < n; ++i)
				spellsKnown.add(list.get(i));
		}
	}
}
