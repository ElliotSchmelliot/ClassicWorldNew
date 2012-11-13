package mobs;

import items.*;
import java.util.List;
import abilities.*;

public class Dragon extends Monster {
	
	public Dragon(String name, int health, int charLevel, List<Ability> attacks, List<Item> inventory) {
		level = charLevel + 2;
		healthMax = 10 * level;
		this.attacks = attacks;
		healthMax = health;
		healthCurrent = healthMax;
		this.inventory = inventory;
		this.name = name;
	}
	
}
