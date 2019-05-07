package com.dnd5e.definitions.gear;

import com.dnd5e.characters.*;
import com.dnd5e.definitions.skills.Skill;

public interface Wearable extends Usable {
	public int getArmorClass();

	public void setArmorClass(int armorClass);

	public int getDexterityBonus();

	public void setDexterityBonus(int dexterityBonus);

	/*
	 * DEFAULT METHODS
	 */
	public default boolean isLightArmor() {
		boolean isLightArmor = false;
		Skill[] skills = getSkills();

		for (Skill el : skills) {
			if (el.equals(Skill.PADDED_ARMOR) || el.equals(Skill.LEATHER_ARMOR) || el.equals(Skill.STUDDED_LEATHER)) {
				isLightArmor = true;
			}
		}

		return isLightArmor;
	}

	public default boolean isMediumArmor() {
		boolean isMediumArmor = false;
		Skill[] skills = getSkills();

		for (Skill el : skills) {
			if (el.equals(Skill.HIDE_ARMOR) || el.equals(Skill.CHAIN_SHIRT) || el.equals(Skill.SCALE_MAIL)
					|| el.equals(Skill.BREASTPLATE) || el.equals(Skill.HALF_PLATE)) {
				isMediumArmor = true;
			}
		}

		return isMediumArmor;
	}

	public default boolean isHeavyArmor() {
		boolean isHeavyArmor = false;
		Skill[] skills = getSkills();

		for (Skill el : skills) {
			if (el.equals(Skill.RING_MAIL) || el.equals(Skill.CHAIN_MAIL) || el.equals(Skill.SPLINT_MAIL)
					|| el.equals(Skill.PLATE_MAIL)) {
				isHeavyArmor = true;
			}
		}

		return isHeavyArmor;
	}

}
