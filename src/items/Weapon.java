package items;

import java.util.ArrayList;

import abilities.Ability;



public abstract class Weapon extends Item {

	int attack;
	int durability;
	public Ability primary;
	public Ability secondary;
	
	public abstract int damage();
	
	public abstract int use();
	
	public int cost() {
		return quality * level * 1000 / durability;
	}
	
}
