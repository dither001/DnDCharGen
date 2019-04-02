package com.dnd5e.character.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

import com.dnd5e.definitions.*;
import com.dnd5e.gear.equipment.*;
import com.dnd5e.magic.*;
import com.miscellaneous.util.*;

public abstract class Wizard extends JobClass {
	private static final DnDClass CLAZZ;
	private static final RacialFeature[] SAVING_THROWS;
	private static final Skill[] CLASS_SKILLS;
	private static final int NUMBER_OF_SKILLS;

	//
	private static final Spell[][] SPELL_LIST;

	static {
		CLAZZ = DnDClass.WIZARD;
		SAVING_THROWS = DnDClass.getSavingThrows(CLAZZ);
		CLASS_SKILLS = Skill.getClassSkills(CLAZZ);
		NUMBER_OF_SKILLS = DnDClass.getNumberOfSkills(CLAZZ);

		//
		SPELL_LIST = new Spell[][] {
				{ Spell.ACID_SPLASH, Spell.BLADE_WARD, Spell.CHILL_TOUCH, Spell.DANCING_LIGHTS, Spell.FIREBOLT,
						Spell.FRIENDS, Spell.LIGHT, Spell.MAGE_HAND, Spell.MENDING, Spell.MESSAGE, Spell.MINOR_ILLUSION,
						Spell.POISON_SPRAY, Spell.PRESTIDIGITATION, Spell.RAY_OF_FROST, Spell.SHOCKING_GRASP,
						Spell.TRUE_STRIKE },
				{ Spell.ALARM, Spell.BURNING_HANDS, Spell.CHARM_PERSON, Spell.CHROMATIC_ORB, Spell.COLOR_SPRAY,
						Spell.COMPREHEND_LANGUAGES, Spell.DETECT_MAGIC, Spell.DISGUISE_SELF, Spell.EXPEDITIOUS_RETREAT,
						Spell.FALSE_LIFE, Spell.FEATHER_FALL, Spell.FIND_FAMILIAR, Spell.FOG_CLOUD, Spell.GREASE,
						Spell.IDENTIFY, Spell.ILLUSORY_SCRIPT, Spell.JUMP, Spell.LONGSTRIDER, Spell.MAGE_ARMOR,
						Spell.MAGIC_MISSILE, Spell.PROTECTION_FROM_EVIL, Spell.RAY_OF_SICKNESS, Spell.SHIELD,
						Spell.SILENT_IMAGE, Spell.SLEEP, Spell.HIDEOUS_LAUGHTER, Spell.FLOATING_DISK, Spell.THUNDERWAVE,
						Spell.UNSEEN_SERVANT, Spell.WITCH_BOLT },
				{ Spell.ALTER_SELF, Spell.ARCANE_LOCK, Spell.BLINDNESS_DEAFNESS, Spell.BLUR, Spell.CLOUD_OF_DAGGERS,
						Spell.CONTINUAL_FLAME, Spell.CROWN_OF_MADNESS, Spell.DARKVISION, Spell.DETECT_THOUGHTS,
						Spell.ENLARGE_REDUCE, Spell.FLAMING_SPHERE, Spell.GENTLE_REPOSE, Spell.GUST_OF_WIND,
						Spell.HOLD_PERSON, Spell.INVISIBILITY, Spell.KNOCK, Spell.LEVITATE, Spell.LOCATE_OBJECT,
						Spell.MAGIC_MOUTH, Spell.MAGIC_WEAPON, Spell.ACID_ARROW, Spell.MIRROR_IMAGE, Spell.MISTY_STEP,
						Spell.MAGIC_AURA, Spell.PHANTASMAL_FORCE, Spell.RAY_OF_ENFEEBLEMENT, Spell.ROPE_TRICK,
						Spell.SCORCHING_RAY, Spell.SEE_INVISIBILITY, Spell.SHATTER, Spell.SPIDER_CLIMB,
						Spell.SUGGESTION, Spell.WEB },
				{ Spell.ANIMATE_DEAD, Spell.BESTOW_CURSE, Spell.BLINK, Spell.CLAIRVOYANCE, Spell.COUNTERSPELL,
						Spell.DISPEL_MAGIC, Spell.FEAR, Spell.FEIGN_DEATH, Spell.FIREBALL, Spell.FLY,
						Spell.GASEOUS_FORM, Spell.GLYPH_OF_WARDING, Spell.HASTE, Spell.HYPNOTIC_PATTERN, Spell.TINY_HUT,
						Spell.LIGHTNING_BOLT, Spell.MAGIC_CIRCLE, Spell.MAJOR_IMAGE, Spell.NONDETECTION,
						Spell.PHANTOM_STEED, Spell.PROTECTION_FROM_ENERGY, Spell.REMOVE_CURSE, Spell.SENDING,
						Spell.SLEET_STORM, Spell.SLOW, Spell.STINKING_CLOUD, Spell.TONGUES, Spell.VAMPIRIC_TOUCH,
						Spell.WATER_BREATHING },
				{ Spell.ARCANE_EYE, Spell.BANISHMENT, Spell.BLIGHT, Spell.CONFUSION, Spell.CONJURE_MINOR_ELEMENTALS,
						Spell.CONTROL_WATER, Spell.DIMENSION_DOOR, Spell.BLACK_TENTACLES, Spell.FABRICATE,
						Spell.FIRE_SHIELD, Spell.GREATER_INVISIBILITY, Spell.HALLUCINATORY_TERRAIN, Spell.ICE_STORM,
						Spell.SECRET_CHEST, Spell.LOCATE_CREATURE, Spell.FAITHFUL_HOUND, Spell.PRIVATE_SANCTUM,
						Spell.RESILIENT_SPHERE, Spell.PHANTASMAL_KILLER, Spell.POLYMORPH, Spell.STONE_SHAPE,
						Spell.STONESKIN, Spell.WALL_OF_FIRE },
				{ Spell.ANIMATE_OBJECTS, Spell.ARCANE_HAND, Spell.CLOUDKILL, Spell.CONE_OF_COLD,
						Spell.CONJURE_ELEMENTAL, Spell.CONTACT_OTHER_PLANE, Spell.CREATION, Spell.DOMINATE_PERSON,
						Spell.DREAM, Spell.GEAS, Spell.HOLD_MONSTER, Spell.LEGEND_LORE, Spell.MISLEAD,
						Spell.MODIFY_MEMORY, Spell.PASSWALL, Spell.PLANAR_BINDING, Spell.TELEPATHIC_BOND, Spell.SCRYING,
						Spell.TELEKINESIS, Spell.TELEPORTATION_CIRCLE, Spell.WALL_OF_FORCE, Spell.WALL_OF_STONE },
				{ Spell.ARCANE_GATE, Spell.CHAIN_LIGHTNING, Spell.CIRCLE_OF_DEATH, Spell.CONTINGENCY,
						Spell.CREATE_UNDEAD, Spell.DISINTEGRATE, Spell.INSTANT_SUMMONS, Spell.EYEBITE,
						Spell.FLESH_TO_STONE, Spell.GLOBE_OF_INVULNERABILITY, Spell.GUARDS_AND_WARDS, Spell.MAGIC_JAR,
						Spell.MASS_SUGGESTION, Spell.MOVE_EARTH, Spell.FREEZING_SPHERE, Spell.IRRESISTIBLE_DANCE,
						Spell.PROGRAMMED_ILLUSION, Spell.SUNBEAM, Spell.TRUE_SEEING, Spell.WALL_OF_ICE },
				{ Spell.DELAYED_BLAST_FIREBALL, Spell.ETHEREALNESS, Spell.FINGER_OF_DEATH, Spell.FORCECAGE,
						Spell.MIRAGE_ARCANA, Spell.MAGNIFICENT_MANSION, Spell.ARCANE_SWORD, Spell.PLANE_SHIFT,
						Spell.PRISMATIC_SPRAY, Spell.PROJECT_IMAGE, Spell.REVERSE_GRAVITY, Spell.SEQUESTER,
						Spell.SIMULACRUM, Spell.SYMBOL, Spell.TELEPORT },
				{ Spell.ANTIMAGIC_FIELD, Spell.ANTIPATHY_SYMPATHY, Spell.CLONE, Spell.CONTROL_WEATHER, Spell.DEMIPLANE,
						Spell.DOMINATE_MONSTER, Spell.FEEBLEMIND, Spell.INCENDIARY_CLOUD, Spell.MAZE, Spell.MIND_BLANK,
						Spell.POWER_WORD_STUN, Spell.SUNBURST, Spell.TELEPATHY },
				{ Spell.ASTRAL_PROJECTION, Spell.FORESIGHT, Spell.GATE, Spell.IMPRISONMENT, Spell.METEOR_SWARM,
						Spell.POWER_WORD_KILL, Spell.PRISMATIC_WALL, Spell.SHAPECHANGE, Spell.TIME_STOP,
						Spell.TRUE_POLYMORPH, Spell.WEIRD, Spell.WISH } };
	}

	public static void setup(Hero actor) {
		// CLASS FEATURES
		apply(1, actor);

		// SAVING THROWS
		actor.getFeatures().addAll(Misc.arrayToList(SAVING_THROWS));

		// SKILLS & WEAPON/ARMOR PROFICIENCY
		Misc.tryToAdd(NUMBER_OF_SKILLS, CLASS_SKILLS, actor.getCommonSkills());

		actor.getWeaponSkills().addAll(Skill.wizardWeapons());

		Spell.addCantrip(3, CLAZZ, actor.getCantripsKnown());
		actor.getInventory().addSpellbook(Spellbook.build());
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
