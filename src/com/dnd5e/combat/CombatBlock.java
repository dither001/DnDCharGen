package com.dnd5e.combat;

import java.util.ArrayList;
import java.util.List;

import com.dnd5e.characters.*;
import com.dnd5e.definitions.combat.*;
import com.dnd5e.equipment.*;

public class CombatBlock {

	// basic
	private Actor owner;
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

	public String toStringVerbose() {
		String s = "";

		int exp = ChallengeRating.getEXPReward(challengeRating);
		s = String.format("AC %2s (%s) ||  %s hp || CR %s (%s exp)%n", armorClass, "", maximumHitPoints,
				challengeRating, exp);

		for (Attack el : inv.weaponAttackList())
			s += el + "\n";

		return s;
	}

	/*
	 * INSTANCE METHODS
	 */
	public Actor getOwner() {
		return owner;
	}

	public void setOwner(Actor owner) {
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
	public static CombatBlock build(Actor actor) {
		CombatBlock block = new CombatBlock();

		//
		block.setOwner(actor);
		block.setInventory(actor.getInventory());

		//
		block.setMaximumHitPoints(actor.getMaximumHitPoints());
		block.setCurrentHitPoints(actor.getCurrentHitPoints());

		//
		block.setArmorClass(actor.getInventory().getArmorClass());
		block.setAttacks(block.inv.weaponAttackList());

		// finalize
		block.evaluateChallengeRating();

		return block;
	}

}
