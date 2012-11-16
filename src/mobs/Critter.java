package mobs;

import items.*;
import abilities.*;

import java.util.ArrayList;
import java.util.List;

public class Critter extends Monster {

	public Critter(String name, int level) {
		this.name = name;
		this.level = level;
		healthMax = 2 * level;
		healthCurrent = healthMax;
		attacks = new ArrayList<Ability>();
		inventory = new ArrayList<Item>();
	}
	
	public Critter(String name, int level, List<Ability> attacks, List<Item> inventory) {
		this.name = name;
		this.level = level;
		healthMax = 2 * level;
		healthCurrent = healthMax;
		this.attacks = attacks;
		this.inventory = inventory;
	}
}
