package com.dnd5e.magic;

import java.util.HashMap;

import com.miscellaneous.util.FileLoader;

public class Sorcery {
	private static HashMap<String, Sorcery> spellMap;

	static {
		spellMap = FileLoader.parseSpells("spells.csv");
	}

	protected School school;
	protected int level;

	public Sorcery() {
		this.school = School.ABJURATION;
		this.level = 1;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
