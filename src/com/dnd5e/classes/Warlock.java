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

public abstract class Warlock extends JobClass {
	private static final DnDClass CLAZZ;
	private static final RacialFeature[] SAVING_THROWS;
	private static final Skill[] CLASS_SKILLS;
	private static final int NUMBER_OF_SKILLS;

	//
	private static final ClassFeature[] PACTS;
	private static final ClassFeature[][] RANDOM_INVOCATIONS; // no requirements

	private static final Spell[][] SPELL_LIST;

	static {
		CLAZZ = DnDClass.WARLOCK;
		SAVING_THROWS = DnDClass.getSavingThrows(CLAZZ);
		CLASS_SKILLS = Skill.getClassSkills(CLAZZ);
		NUMBER_OF_SKILLS = DnDClass.getNumberOfSkills(CLAZZ);

		//
		SPELL_LIST = new Spell[][] {
				{ Spell.BLADE_WARD, Spell.CHILL_TOUCH, Spell.ELDRITCH_BLAST, Spell.FRIENDS, Spell.MAGE_HAND,
						Spell.MINOR_ILLUSION, Spell.POISON_SPRAY, Spell.PRESTIDIGITATION, Spell.TRUE_STRIKE },
				{ Spell.ARMOR_OF_AGATHYS, Spell.ARMS_OF_HADAR, Spell.CHARM_PERSON, Spell.COMPREHEND_LANGUAGES,
						Spell.EXPEDITIOUS_RETREAT, Spell.HELLISH_REBUKE, Spell.HEX, Spell.ILLUSORY_SCRIPT,
						Spell.PROTECTION_FROM_EVIL, Spell.UNSEEN_SERVANT, Spell.WITCH_BOLT },
				{ Spell.CLOUD_OF_DAGGERS, Spell.CROWN_OF_MADNESS, Spell.DARKNESS, Spell.ENTHRALL, Spell.HOLD_PERSON,
						Spell.INVISIBILITY, Spell.MIRROR_IMAGE, Spell.MISTY_STEP, Spell.RAY_OF_ENFEEBLEMENT,
						Spell.SHATTER, Spell.SPIDER_CLIMB, Spell.SUGGESTION },
				{ Spell.COUNTERSPELL, Spell.DISPEL_MAGIC, Spell.FEAR, Spell.FLY, Spell.GASEOUS_FORM,
						Spell.HUNGER_OF_HADAR, Spell.HYPNOTIC_PATTERN, Spell.MAGIC_CIRCLE, Spell.MAJOR_IMAGE,
						Spell.REMOVE_CURSE, Spell.TONGUES, Spell.VAMPIRIC_TOUCH },
				{ Spell.BANISHMENT, Spell.BLIGHT, Spell.DIMENSION_DOOR, Spell.HALLUCINATORY_TERRAIN },
				{ Spell.CONTACT_OTHER_PLANE, Spell.DREAM, Spell.HOLD_MONSTER, Spell.SCRYING },
				{ Spell.ARCANE_GATE, Spell.CIRCLE_OF_DEATH, Spell.CONJURE_FEY, Spell.CREATE_UNDEAD, Spell.EYEBITE,
						Spell.FLESH_TO_STONE, Spell.MASS_SUGGESTION, Spell.TRUE_SEEING },
				{ Spell.ETHEREALNESS, Spell.FINGER_OF_DEATH, Spell.FORCECAGE, Spell.PLANE_SHIFT },
				{ Spell.DEMIPLANE, Spell.DOMINATE_MONSTER, Spell.FEEBLEMIND, Spell.GLIBNESS, Spell.POWER_WORD_STUN },
				{ Spell.ASTRAL_PROJECTION, Spell.FORESIGHT, Spell.IMPRISONMENT, Spell.POWER_WORD_KILL,
						Spell.TRUE_POLYMORPH } };

		//
		PACTS = new ClassFeature[] { ClassFeature.PACT_OF_THE_BLADE, ClassFeature.PACT_OF_THE_CHAIN,
				ClassFeature.PACT_OF_THE_TOME };
		RANDOM_INVOCATIONS = new ClassFeature[][] {
				{ ClassFeature.ARMOR_OF_SHADOWS, ClassFeature.BEAST_SPEECH, ClassFeature.BEGUILING_INFLUENCE,
						ClassFeature.DEVILS_SIGHT, ClassFeature.ELDRITCH_SIGHT, ClassFeature.EYES_OF_THE_KEEPER,
						ClassFeature.FIENDISH_VIGOR, ClassFeature.GAZE_OF_TWO_MINDS, ClassFeature.MASK_OF_MANY_FACES,
						ClassFeature.MISTY_VISIONS, ClassFeature.THIEF_OF_FIVE_FATES },
				{ ClassFeature.MIRE_OF_THE_MIND_5, ClassFeature.ONE_WITH_SHADOWS_5, ClassFeature.SIGN_OF_ILL_OMEN_5 },
				{ ClassFeature.BEWITCHING_WHISPERS_7, ClassFeature.DREADFUL_WORD_7, ClassFeature.SCULPTOR_OF_FLESH_7 },
				{ ClassFeature.ASCENDANT_STEP_9, ClassFeature.MINIONS_OF_CHAOS_9, ClassFeature.OTHERWORLDLY_LEAP_9,
						ClassFeature.WHISPERS_OF_THE_GRAVE_9 },
				{ ClassFeature.MASTER_OF_MYRIAD_FORMS_15, ClassFeature.VISIONS_OF_DISTANT_REALMS_15,
						ClassFeature.WITCH_SIGHT_15 } };

	}

	public static void setup(Hero actor) {
		// CLASS FEATURES
		apply(1, actor);

		// SAVING THROWS
		actor.getFeatures().addAll(Misc.arrayToList(SAVING_THROWS));

		// SKILLS & WEAPON/ARMOR PROFICIENCY
		Misc.tryToAddN(NUMBER_OF_SKILLS, CLASS_SKILLS, actor.getCommonSkills());

		actor.getArmorSkills().addAll(Skill.lightArmorList());

		actor.getWeaponSkills().addAll(Skill.simpleWeaponList());

		Spell.addCantrip(2, CLAZZ, actor.getCantripsKnown());
		Spell.addSpell(2, 1, CLAZZ, actor.getSpellsKnown());
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
			inv.addWeapon(Skill.LIGHT_CROSSBOW);
			inv.addAmmunition(Skill.LIGHT_CROSSBOW);

		} else {
			inv.randomSimpleWeapon();

		}

		// TODO - component pouch or arcane focus
		// TODO - add dungeoneer's or scholar's pack
		inv.addArmor(Skill.LEATHER_ARMOR);
		inv.randomSimpleWeapon();
		inv.addWeapon(Skill.DAGGER);
		inv.addWeapon(Skill.DAGGER);

		// FINAL STEP
		actor.setInventory(inv);
	}

	public static void apply(int level, Hero actor) {
		EnumSet<ClassFeature> features = actor.getClassFeatures();

		Subclass subclass = actor.getSubclass();
		switch (level) {
		case 1:
			features.add(Misc.randomFromArray(PACTS));
			features.add(ClassFeature.WARLOCK_SLOT_1);

			/*
			 * WARLOCK PACT
			 */
			if (subclass.equals(Subclass.FEY_PACT)) {
				features.add(ClassFeature.FEY_PRESENCE);

			} else if (subclass.equals(Subclass.FIEND_PACT)) {
				features.add(ClassFeature.DARK_ONES_BLESSING);

			} else if (subclass.equals(Subclass.STAR_PACT)) {
				features.add(ClassFeature.AWAKENED_MIND);

			}

			break;
		case 2:
			features.add(ClassFeature.WARLOCK_SLOT_2);

			// SPELLS KNOWN
			Spell.addSpell(1, CLAZZ, actor.getSpellsKnown());

			// ADD INVOCATION
			addWarlockInvocations(2, actor);

			break;
		case 3:
			// SPELLS KNOWN
			Spell.addSpell(2, CLAZZ, actor.getSpellsKnown());

			break;
		case 4:
			// CANTRIP & SPELLS KNOWN
			Spell.addCantrip(CLAZZ, actor.getCantripsKnown());
			Spell.addSpell(2, CLAZZ, actor.getSpellsKnown());

			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_4);
			improveAbility(actor);

			break;
		case 5:
			// SPELLS KNOWN
			Spell.addSpell(3, CLAZZ, actor.getSpellsKnown());

			// ADD INVOCATION
			addWarlockInvocations(1, actor);

			break;
		case 6:
			// SPELLS KNOWN
			Spell.addSpell(3, CLAZZ, actor.getSpellsKnown());

			/*
			 * WARLOCK PACT
			 */
			if (subclass.equals(Subclass.FEY_PACT)) {
				features.add(ClassFeature.MISTY_ESCAPE);

			} else if (subclass.equals(Subclass.FIEND_PACT)) {
				features.add(ClassFeature.DARK_ONES_OWN_LUCK);

			} else if (subclass.equals(Subclass.STAR_PACT)) {
				features.add(ClassFeature.ENTROPIC_WARD);

			}

			break;
		case 7:
			// SPELLS KNOWN
			Spell.addSpell(4, CLAZZ, actor.getSpellsKnown());

			// ADD INVOCATION
			addWarlockInvocations(1, actor);

			break;
		case 8:
			// SPELLS KNOWN
			Spell.addSpell(4, CLAZZ, actor.getSpellsKnown());

			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_8);
			improveAbility(actor);

			break;
		case 9:
			// SPELLS KNOWN
			Spell.addSpell(5, CLAZZ, actor.getSpellsKnown());

			// ADD INVOCATION
			addWarlockInvocations(1, actor);

			break;
		case 10:
			// CANTRIPS KNOWN
			Spell.addCantrip(CLAZZ, actor.getCantripsKnown());

			/*
			 * WARLOCK PACT
			 */
			if (subclass.equals(Subclass.FEY_PACT)) {
				features.add(ClassFeature.BEGUILING_DEFENSES);

			} else if (subclass.equals(Subclass.FIEND_PACT)) {
				features.add(ClassFeature.FIENDISH_RESILIENCE);

			} else if (subclass.equals(Subclass.STAR_PACT)) {
				features.add(ClassFeature.THOUGHT_SHIELD);

			}

			break;
		case 11:
			// SPELLS KNOWN
			Misc.tryToAddOne(getListOfAvailableSpellsToLearn(actor), actor.getSpellsKnown());

			features.add(ClassFeature.MYSTIC_ARCANUM_11);
			actor.getInnateSpells().add(1, addMysticArcanum(6, actor));
			features.add(ClassFeature.WARLOCK_SLOT_3);

			break;
		case 12:
			// ADD INVOCATION
			addWarlockInvocations(1, actor);

			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_12);
			improveAbility(actor);

			break;
		case 13:
			// SPELLS KNOWN
			Misc.tryToAddOne(getListOfAvailableSpellsToLearn(actor), actor.getSpellsKnown());

			features.add(ClassFeature.MYSTIC_ARCANUM_13);
			actor.getInnateSpells().add(1, addMysticArcanum(7, actor));

			break;
		case 14:
			/*
			 * WARLOCK PACT
			 */
			if (subclass.equals(Subclass.FEY_PACT)) {
				features.add(ClassFeature.DARK_DELIRIUM);

			} else if (subclass.equals(Subclass.FIEND_PACT)) {
				features.add(ClassFeature.HURL_THROUGH_HELL);

			} else if (subclass.equals(Subclass.STAR_PACT)) {
				features.add(ClassFeature.CREATE_THRALL);

			}

			break;
		case 15:
			// SPELLS KNOWN
			Misc.tryToAddOne(getListOfAvailableSpellsToLearn(actor), actor.getSpellsKnown());

			features.add(ClassFeature.MYSTIC_ARCANUM_15);
			actor.getInnateSpells().add(1, addMysticArcanum(8, actor));

			// ADD INVOCATION
			addWarlockInvocations(1, actor);

			break;
		case 16:
			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_16);
			improveAbility(actor);

			break;
		case 17:
			// SPELLS KNOWN
			Misc.tryToAddOne(getListOfAvailableSpellsToLearn(actor), actor.getSpellsKnown());

			features.add(ClassFeature.MYSTIC_ARCANUM_17);
			actor.getInnateSpells().add(1, addMysticArcanum(9, actor));
			features.add(ClassFeature.WARLOCK_SLOT_4);

			break;
		case 18:
			// ADD INVOCATION
			addWarlockInvocations(1, actor);

			break;
		case 19:
			// SPELLS KNOWN
			Misc.tryToAddOne(getListOfAvailableSpellsToLearn(actor), actor.getSpellsKnown());

			// ABILTIY SCORE IMPROVEMENT
			features.add(ClassFeature.ABILITY_BONUS_19);
			improveAbility(actor);

			break;
		case 20:
			features.add(ClassFeature.ELDRITCH_MASTER);

			break;
		}

		actor.setClassFeatures(features);
	}

	public static List<Spell> getSpellsList() {
		int n = 0;
		for (Spell[] el : SPELL_LIST)
			n += el.length;

		List<Spell> list = new ArrayList<Spell>(n);
		for (Spell[] el : SPELL_LIST) {
			for (Spell em : el)
				list.add(em);
		}

		return list;
	}

	public static List<Spell> getSpellsInRange(int start, int end) {
		List<Spell> list = new ArrayList<Spell>();
		for (int i = start; i < end; ++i) {
			for (Spell em : SPELL_LIST[i])
				list.add(em);
		}

		return list;
	}

	/*
	 * PRIVATE METHODS
	 */
	private static List<Spell> getListOfAvailableSpellsToLearn(Hero actor) {
		EnumSet<Spell> spells = actor.getSpellsKnown();

		List<Spell> list = getSpellsInRange(1, 5);
		// remove all spells known
		list.removeAll(spells);

		return list;
	}

	private static Spell addMysticArcanum(int level, Hero actor) {
		List<Spell> list = new ArrayList<Spell>();
		for (Spell el : SPELL_LIST[level])
			list.add(el);

		list.removeAll(actor.getInnateSpells().getSpellsList());

		Collections.shuffle(list);
		return list.get(0);
	}

	private static void addWarlockInvocations(int n, Hero actor) {
		int level = actor.getLevel(), added = 0;

		// has eldritch blast
		boolean eldritchBlast = actor.getCantripsKnown().contains(Spell.ELDRITCH_BLAST);

		// has pact
		EnumSet<ClassFeature> features = actor.getClassFeatures();
		boolean blade = features.contains(ClassFeature.PACT_OF_THE_BLADE);
		boolean chain = features.contains(ClassFeature.PACT_OF_THE_CHAIN);
		boolean tome = features.contains(ClassFeature.PACT_OF_THE_TOME);

		ClassFeature[] array = null;

		if (eldritchBlast) {
			int dice = Dice.roll(6);

			// 50% chance to add agonizing blast w/eldritch blast
			if (added < n && dice < 3)
				added += Misc.tryToAdd(ClassFeature.AGONIZING_BLAST, features);

			// 12% chance to add eldritch spear w/eldritch blast
			if (added < n && dice == 3)
				added += Misc.tryToAdd(ClassFeature.ELDRITCH_SPEAR, features);

			// 12% chance to add repelling blast w/eldritch blast
			if (added < n && dice == 4)
				added += Misc.tryToAdd(ClassFeature.REPELLING_BLAST, features);
		}

		if (blade) {
			int dice = Dice.roll(5);

			// 20% chance of lifedrinker w/pact of blade
			if (level >= 12 && dice == 1)
				added += Misc.tryToAdd(ClassFeature.LIFEDRINKER_12, features);

			// 20% chance of thirsting blade w/pact of blade
			if (level >= 5 && dice == 2)
				added += Misc.tryToAdd(ClassFeature.THIRSTING_BLADE_5, features);
		}

		if (chain) {
			int dice = Dice.roll(5);

			// 20% chance of chains of carceri w/pact of chain
			if (level >= 15 && dice == 1)
				added += Misc.tryToAdd(ClassFeature.CHAINS_OF_CARCERI_15, features);

			// 20% chance of voice of chain master w/ chain pact
			if (level >= 15 && dice == 2)
				added += Misc.tryToAdd(ClassFeature.VOICE_OF_THE_CHAIN_MASTER, features);
		}

		if (tome) {
			int dice = Dice.roll(5);

			// 20% chance of book of ancient secrets w/ tome pact
			if (level >= 15 && dice == 1)
				added += Misc.tryToAdd(ClassFeature.BOOK_OF_ANCIENT_SECRETS, features);
		}

		// choose array for random invocation
		if (level >= 15)
			array = RANDOM_INVOCATIONS[4];
		else if (level >= 9)
			array = RANDOM_INVOCATIONS[3];
		else if (level >= 7)
			array = RANDOM_INVOCATIONS[2];
		else if (level >= 5)
			array = RANDOM_INVOCATIONS[1];
		else
			array = RANDOM_INVOCATIONS[0];

		if (n - added > 0) {
			// after random chances to add req-locked invocations
			Misc.tryToAddN(n - added, array, features);
		}

		actor.setClassFeatures(features);
	}
}
