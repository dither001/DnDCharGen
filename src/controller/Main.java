package controller;
//import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;

import com.dnd5e.magic.Sorcery;
import com.dnd5e.monsters.Monster;
import com.miscellaneous.util.Dice;
import com.miscellaneous.util.FileLoader;
import com.dnd5e.characters.*;
import com.dnd5e.dungeons.Chamber;
import com.dnd5e.dungeons.Dungeon;
import com.dnd5e.dungeons.Floor;
import com.dnd5e.equipment.Armor;
import com.dnd5e.equipment.Tool;
import com.dnd5e.equipment.Weapon;

import view.DungeonFrame;
import view.FloorPanel;
import view.NPCFrame;

public class Main {
	public static final boolean RELEASE;
	public static final boolean TESTING_MESSAGES;
	public static final int NPCS_TO_ROLL;

	private static NPCFrame frame;
	public static List<DnDCharacter> npcList;

	private static DungeonFrame dungeonFrame;
	public static Dungeon dungeon;

	static {
		RELEASE = false;
		TESTING_MESSAGES = false;

		NPCS_TO_ROLL = 25;

		Armor.setupArmor(FileLoader.parseArmor("resources/armor.csv"));
		Monster.setupMonsters(FileLoader.parseMonsters("resources/monsters.csv"));
		Sorcery.setupSpells(FileLoader.parseSpells("resources/spells.csv"));
		Tool.setupTools(FileLoader.parseGear("resources/gear.csv"));
		Weapon.setupWeapons(FileLoader.parseWeapons("resources/weapons.csv"));
	}

	/*
	 * MAIN METHOD
	 */
	public static void main(String[] args) {

		// for (Skill el : Skill.getInstrumentSkillsList())
		// System.out.println(el.toString().replace("_", " ").toLowerCase());
		//
		// for (Skill el : Skill.getInstrumentSkillsList())
		// System.out.println(el.toString());

		// frame.addMouseListener(null);

		/*
		 * START
		 */
		// npcList = rollCharacters(NPCS_TO_ROLL);
		// frame = new NPCFrame();
		// frame.setVisible(true);

		dungeon = Dungeon.build(Dice.roll(4) + 1);
		dungeon.explore();

		dungeonFrame = DungeonFrame.build(dungeon);
		dungeonFrame.setVisible(true);

		dungeonFrame.revalidate();
	}

	public static List<DnDCharacter> rollCharacters(int n) {
		List<DnDCharacter> list = new ArrayList<DnDCharacter>(n);
		for (int i = 0; i < n; ++i)
			list.add(DnDCharacter.random());

		return list;
	}
}
