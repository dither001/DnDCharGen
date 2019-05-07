package com.dnd5e.combat;

import java.util.ArrayList;
import java.util.List;

import com.dnd5e.characters.*;
import com.dnd5e.definitions.combat.*;
import com.dnd5e.equipment.*;

public class CombatBlock {

	// basic
	private Creature owner;
	private Inventory inv;
	private int challengeRating;

	// defense
	private int armorClass;
	private int maximumHitPoints;
	private int currentHitPoints;

	// offense
	private List<Attack> attacks;

	/*
	 * CONSTRUCTORS
	 */
	private CombatBlock() {
		this.setChallengeRating(0);

		this.setArmorClass(10);
		this.setMaximumHitPoints(1);
		this.setCurrentHitPoints(1);

		this.setAttacks(new ArrayList<Attack>());
	}

	/*
	 * INSTANCE METHODS
	 */
	public Creature getOwner() {
		return owner;
	}

	public void setOwner(Creature owner) {
		this.owner = owner;
	}

	public Inventory getInventory() {
		return inv;
	}

	public void setInventory(Inventory inv) {
		this.inv = inv;
	}

	public int getChallengeRating() {
		return challengeRating;
	}

	public void setChallengeRating(int challengeRating) {
		this.challengeRating = challengeRating;
	}

	/*
	 * 
	 */
	public int getArmorClass() {
		return armorClass;
	}

	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
	}

	public int getMaximumHitPoints() {
		return maximumHitPoints;
	}

	public void setMaximumHitPoints(int hitPoints) {
		this.maximumHitPoints = hitPoints;
	}

	public int getCurrentHitPoints() {
		return currentHitPoints;
	}

	public void setCurrentHitPoints(int currentHitPoints) {
		this.currentHitPoints = currentHitPoints;
	}

	public List<Attack> getAttacks() {
		return attacks;
	}

	public void setAttacks(List<Attack> attacks) {
		this.attacks = attacks;
	}

	/*
	 * PRIVATE METHODS
	 */
	private void evaluateChallengeRating() {
		/*
		 * FIXME - unsophisticated
		 */
		setChallengeRating(ChallengeRating.evaluateCR(attacks.get(0), maximumHitPoints, armorClass));
	}

	/*
	 * STATIC METHODS
	 */
	public static CombatBlock build(Creature actor) {
		CombatBlock block = new CombatBlock();

		//
		block.setOwner(actor);
		block.setInventory(actor.getInventory());

		//
		block.setMaximumHitPoints(actor.getMaximumHitPoints());
		block.setCurrentHitPoints(actor.getCurrentHitPoints());

		//
		block.setAttacks(block.inv.weaponAttackList());

		//
		block.evaluateChallengeRating();

		return block;
	}

}
