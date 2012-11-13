package mobs;

import java.util.List;
import items.*;


public abstract class Mob {
	public int level;
	public int healthCurrent;
	int healthMax;
	List<Item> inventory;
	String name;
	
}
