package com.dnd5e.players;

public enum Action {
	// "Pass turn" - if everyone passes, the game state must change somehow
	PASS,
	// Standard
	MOVE, PLAY, REST, WAIT, WORK,
	// "Free"
	EAT, FIGHT, SLEEP, TALK;

}
