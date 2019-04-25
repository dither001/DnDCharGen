package com.miscellaneous.util;

public interface Observable {
	public boolean addObserver(Observer o);

	public boolean removeObserver(Observer o);

	public void notifyObservers();

}
