package com.dnd5e.gear.equipment;

import com.dnd5e.gear.definitions.*;

public class Item implements Portable {
	/*
	 * INSTANCE FIELDS
	 */
	private String name;
	private Material material;
	private int cost;
	private int weight;

	private boolean isStackable;
	private int quantity;
	private int sizeOfStack;

	public Item() {
		this.name = "Unnamed Item";
		this.material = null;
		this.cost = 0;
		this.isStackable = false;
		this.quantity = 1;
		this.sizeOfStack = 1;
	}

	/*
	 * INSTANCE METHODS
	 */
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Material getMaterial() {
		return material;
	}

	@Override
	public void setMaterial(Material material) {
		this.material = material;
	}

	@Override
	public int getCostCP() {
		return cost;
	}

	@Override
	public void setCostCP(int cost) {
		this.cost = cost;
	}

	@Override
	public int getWeightOzs() {
		return weight;
	}

	@Override
	public void setWeightOzs(int weight) {
		this.weight = weight;
	}

	@Override
	public boolean getIsStackable() {
		return isStackable;
	}

	@Override
	public void setIsStackable(boolean isStackable) {
		this.isStackable = isStackable;
	}

	@Override
	public int getQuantity() {
		return quantity;
	}

	@Override
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int getSizeOfStack() {
		return sizeOfStack;
	}

	@Override
	public void setSizeOfStack(int sizeOfStack) {
		this.sizeOfStack = sizeOfStack;
	}

}
