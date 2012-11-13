package items;

import abilities.*;

public abstract class OffHand extends Item {
	
	// strength of the thing the offhand does
	int abilityPower;
	int durability;
	public Ability power;
	
	public abstract int use();
		
	public int cost() {
		return abilityPower;
	}
	
}
