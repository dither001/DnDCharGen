package com.dnd5e.magic;

import java.util.EnumSet;

public interface MagicUser {

	public EnumSet<Spell> getCantripsKnown();

	public void setCantripsKnown(EnumSet<Spell> cantripsKnown);

	public EnumSet<Spell> getSpellsKnown();

	public void setSpellsKnown(EnumSet<Spell> spellsKnown);
}
