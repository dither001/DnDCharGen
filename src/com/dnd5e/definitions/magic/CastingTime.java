package com.dnd5e.definitions.magic;

public class CastingTime {
	protected int ticks;
	protected SpellTimeInterval interval;

	/*
	 * CONSTRUCTORS
	 */
	private CastingTime() {
		this.setTicks(1);
		this.setInterval(SpellTimeInterval.STANDARD_ACTION);
	}

	/*
	 * INSTANCE METHODS
	 */
	public int getTicks() {
		return ticks;
	}

	public void setTicks(int ticks) {
		this.ticks = ticks;
	}

	public SpellTimeInterval getInterval() {
		return interval;
	}

	public void setInterval(SpellTimeInterval interval) {
		this.interval = interval;
	}

	/*
	 * STATIC METHODS
	 */
	public static CastingTime build() {
		return new CastingTime();
	}
}
