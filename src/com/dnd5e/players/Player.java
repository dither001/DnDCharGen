package com.dnd5e.players;

public interface Player {

	/*
	 * "This method is called when it's your turn and you need to choose what kind
	 * of Action to take in the game." TODO - NEEDS PARAMETERS
	 */
	public Action play(GameState gamestate);
	// public int play(Card[] hand, Card upCard, Color calledColor, GameState state)
	// throws NoPlayPossibleException;

	// public Color callColor(Card[] hand);

	/*
	 * Sometimes a consensus of the group is required to proceed, in which case a
	 * vote is called. TODO - NEEDS PARAMETERS
	 */
	public boolean vote(Agenda agenda);

}
