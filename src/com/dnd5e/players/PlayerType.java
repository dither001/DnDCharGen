package com.dnd5e.players;

import com.dnd5e.util.Misc;

/*
 * Per 4e "player" archetypes, pgs. 8-10.
 */
public enum PlayerType {
	/*
	 * (DMG p.8) The actor likes to pretend to be her character. She emphasizes
	 * character development that has nothing to do with numbers and powers, trying
	 * to make her character seem to be a real person in the fantasy world. She
	 * enjoys interacting with the rest of the group, with characters and monsters
	 * in the game world, and with the fantasy world in general by speaking “in
	 * character” and describing her character’s actions in the first person.
	 */
	ACTOR,
	/*
	 * (DMG p.8) An explorer loves to see new places in the fantasy world and to
	 * meet the residents of such places, fair and foul. All the explorer needs is
	 * the promise of an interesting locale or different culture, and off he goes to
	 * see that place.
	 */
	EXPLORER,
	/*
	 * (DMG p.8) An instigator enjoys making things happen. She has no patience for
	 * careful planning or deliberation. She’ll open an obviously trapped chest
	 * “just to see what happens.” She provokes authority figures and opens dungeon
	 * doors to bring more monsters into an already difficult fight. The instigator
	 * loves the vicarious thrill of taking enormous risks and sometimes just making
	 * bad choices.
	 */
	INSTIGATOR,
	/*
	 * (DMG p.9) A power gamer thrives on gaining levels and loves the cool
	 * abilities that come with those levels. He defeats monsters to take their
	 * stuff and use that stuff against future enemies. The story and roleplaying
	 * are secondary to action and awesome abilities and magic items.
	 */
	POWER_GAMER,
	/*
	 * (DMG p.9) The slayer is like the power gamer, but she is even easier to
	 * please. She emphasizes kicking the tar out of monsters. Maybe she does so to
	 * let off a little steam in a safe way, or she likes the joy of feeling
	 * superior. Perhaps it’s the pleasure of having the power to mete out
	 * punishment to villains.
	 */
	SLAYER,
	/*
	 * (DMG p.9) The storyteller is a player who prefers the narrative of the game
	 * to individual character motivations and personality. This player sees the
	 * game as an ongoing chronicle of events in the fantasy world, and he wants to
	 * see where the tale goes.
	 */
	STORYTELLER,
	/*
	 * (DMG p.9) A thinker likes to make careful choices, reflecting on challenges
	 * and the best way to overcome them. She also enjoys herself most when her
	 * planning results in success with minimal risk and use of resources.
	 */
	THINKER,
	/*
	 * (DMG p.10) A watcher is a casual player who comes to the game because he
	 * wants to be part of the social event. A watcher might be shy or just really
	 * laid back. He wants to participate, but he doesn’t really care if he’s deeply
	 * immersed, and he doesn’t want to be assertive or too involved in the details
	 * of the game, rules, or story. He enjoys the game by being part of a social
	 * circle.
	 */
	WATCHER;

	private static final PlayerType[] PLAYER_TYPES = { ACTOR, EXPLORER, INSTIGATOR, POWER_GAMER, SLAYER, STORYTELLER,
			THINKER, WATCHER };

	public static PlayerType random() {
		return Misc.randomFromArray(PLAYER_TYPES);
	}

}
