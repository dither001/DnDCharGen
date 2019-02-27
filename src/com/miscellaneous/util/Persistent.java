package com.miscellaneous.util;

public interface Persistent {

	public boolean isPersistent();

	public void makePersistent(boolean isPersistent);

	public boolean hasChanged();

	public void markChanged(boolean hasChanged);

	public int getID();

	public void setID(int id);

}
