package com.dnd5e.definitions.skills;

import java.util.EnumSet;

public interface SkillUser {
	public EnumSet<Skill> getCommonSkills();

	public void setCommonSkills(EnumSet<Skill> commonSkills);

	public EnumSet<Skill> getSpecialSkills();

	public void setSpecialSkills(EnumSet<Skill> specialSkills);

	public EnumSet<Skill> getArmorSkills();

	public void setArmorSkills(EnumSet<Skill> armorSkills);

	public EnumSet<Skill> getWeaponSkills();

	public void setWeaponSkills(EnumSet<Skill> weaponSkills);

	/*
	 * DEFAULT METHODS
	 */
	public default boolean proficientWithCommon(Skill skill) {
		return getCommonSkills().contains(skill);
	}

	public default boolean proficientWithSpecial(Skill skill) {
		return getSpecialSkills().contains(skill);
	}

	public default boolean proficientWithArmor(Skill skill) {
		return getArmorSkills().contains(skill);
	}

	public default boolean proficientWithWeapon(Skill skill) {
		return getWeaponSkills().contains(skill);
	}

	public default boolean canUseShields() {
		return getWeaponSkills().contains(Skill.SHIELD);
	}

	public default boolean canUseArmor() {
		return getArmorSkills().size() > 0;
	}

}
