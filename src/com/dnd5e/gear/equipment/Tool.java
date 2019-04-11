package com.dnd5e.gear.equipment;

import java.util.HashMap;

import com.dnd5e.definitions.*;
import com.dnd5e.gear.definitions.*;

public class Tool extends Item implements Cloneable, Usable {
	private static HashMap<String, Tool> gearMap;

	static {
		gearMap = new HashMap<String, Tool>();

	}

	/*
	 * INSTANCE FIELDS
	 */
	protected Handed handed;
	protected Skill[] skills;

	public Tool() {
		super();
		this.handed = Handed.HEAVY;
		this.skills = new Skill[] { Skill.IMPROVISED };
	}

	/*
	 * CLONE
	 */
	@Override
	public Object clone() {
		Tool tool = new Tool();

		tool.setName(name);
		tool.setMaterial(material);
		tool.setCostCP(cost);
		tool.setWeightOz(weight);

		tool.setIsStackable(isStackable);
		tool.setQuantity(quantity);
		tool.setSizeOfStack(sizeOfStack);

		tool.setHanded(handed);
		tool.setSkills(skills);

		return tool;
	}

	/*
	 * INSTANCE METHODS
	 */
	@Override
	public Handed getHanded() {
		return handed;
	}

	@Override
	public void setHanded(Handed handed) {
		this.handed = handed;
	}

	@Override
	public Skill[] getSkills() {
		return skills;
	}

	@Override
	public void setSkills(Skill[] skills) {
		this.skills = skills;
	}

	/*
	 * STATIC METHODS
	 */
	public static Tool get(String s) {
		Tool tool = (Tool) gearMap.get(s);

		if (tool == null)
			System.out.println("Failed to fetch " + s);

		return tool;
	}

	public static void setupTools(HashMap<String, Tool> gearMap) {
		Tool.gearMap = gearMap;
	}

}
