package mobs;

import items.*;
import java.util.List;
import abilities.*;

public class Dragon extends Monster {
	
	public Dragon(String name, int level) {
		this.name = name;
		this.level = level;
		healthMax = 10 * level;
		healthCurrent = healthMax;
	}
	
	public Dragon(String name, int level, List<Ability> attacks, List<Item> inventory) {
		this.name = name;
		this.level = level;
		healthMax = 10 * level;
		healthCurrent = healthMax;
		this.attacks = attacks;
		this.inventory = inventory;
	}
	
}
