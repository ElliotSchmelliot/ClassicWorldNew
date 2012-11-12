package items;

import abilities.*;

public abstract class OffHand extends Item {
	
	// strength of the thing the offhand does
	int abilityPower;
	int durability;
	public Ability power;
	
	public abstract void use();
	
	public abstract void abilityPower();
	
	public int cost() {
		return level * quality * 1000 / durability;
	}
	
}
