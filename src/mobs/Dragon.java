package mobs;

import items.*;

import java.util.ArrayList;
import java.util.List;
import abilities.*;

public class Dragon extends Monster {
	
	public Dragon(String name, int level) {
		this.name = name;
		this.level = level;
		expValue = 25 * level;
		healthMax = 30 * level;
		healthCurrent = healthMax;
		attacks = new ArrayList<Ability>();
		inventory = new ArrayList<Item>();
		attacks.add(new Ability("Fire Breath", -5 * level));
		attacks.add(new Ability("Wing Buffet", -3 * level));
		attacks.add(new Ability("Claw Slash", -4 * level));
		attacks.add(new Ability("Consume Nearby Peasants", 5 * level));
	}
	
	//Don't use this constructor unless testing
	public Dragon(String name, int level, List<Ability> attacks, List<Item> inventory) {
		this.name = name;
		this.level = level;
		expValue = 15 * level;
		healthMax = 30 * level;
		healthCurrent = healthMax;
		this.attacks = attacks;
		this.inventory = inventory;
	}
	
}
