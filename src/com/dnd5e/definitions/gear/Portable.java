package com.dnd5e.definitions.gear;

public interface Portable {
	public String getName();

	public void setName(String name);

	public Material getMaterial();

	public void setMaterial(Material material);

	public int getCostCP();

	public void setCostCP(int cost);

	public int getWeightOz();

	public void setWeightOz(int weight);

	public boolean getIsStackable();

	public void setIsStackable(boolean isStackable);

	public int getQuantity();

	public void setQuantity(int quantity);
	
	public int getSizeOfStack();
	
	public void setSizeOfStack(int sizeOfStack);

	/*
	 * DEFAULT METHODS
	 */
	public default Rarity getRarity() {
		return Rarity.getRarity(getCostCP());
	}

	/*
	 * STATIC METHODS
	 */
	public static int copperToGold(int copper) {
		return copper / 100;
	}

	public static int copperToSilver(int copper) {
		return copper / 10;
	}

	public static int goldToCopper(int gold) {
		return gold * 100;
	}

	public static int silverToCopper(int silver) {
		return silver * 10;
	}

}
