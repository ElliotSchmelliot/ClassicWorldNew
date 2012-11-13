package items;

import abilities.Ability;

public abstract class Weapon extends Item {

	public int attack;
	public int durability;
	public Ability primary;
	public Ability secondary;
		
	public abstract int use();
	
	public int cost() {
		return attack;
	}
	
}
