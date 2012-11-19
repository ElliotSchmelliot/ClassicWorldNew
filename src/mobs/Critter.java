package mobs;

import items.*;
import abilities.*;

import java.util.ArrayList;
import java.util.List;

public class Critter extends Monster {

	public Critter(String name, int level) {
		this.name = name;
		this.level = level;
		expValue = 5* level;
		healthMax = 4 * level;
		healthCurrent = healthMax;
		attacks = new ArrayList<Ability>();
		inventory = new ArrayList<Item>();
		attacks.add(new Ability("Bite", -2 * level));
		attacks.add(new Ability("Scratch", -1 * level));
	}
	
	//Don't use this constructor unless testing
	public Critter(String name, int level, List<Ability> attacks, List<Item> inventory) {
		this.name = name;
		this.level = level;
		expValue = 5 * level;
		healthMax = 4 * level;
		healthCurrent = healthMax;
		this.attacks = attacks;
		this.inventory = inventory;
	}
}
