package mobs;

import java.util.List;
import main.General;
import items.*;


public abstract class Mob extends General {
	public int level;
	public int healthCurrent;
	public int healthMax;
	public List<Item> inventory;
	public String name;

	public void heal(String user, String ability, int  x) {
		healthCurrent += x;
		if (healthCurrent > healthMax) {
			healthCurrent = healthMax;
		}
		System.out.println(user + " used " + ability + " and healed for " + x + " health");
	}

	public void getInventory() {
		int count = 1;
		for (Item item : inventory) {
			System.out.println(count + ") " + item.name);
			count++;
		}
	}

	public void damage(String user, String ability, String target, int x) {
		healthCurrent -= x;
		System.out.println(user + " used " + ability + " on " + target + " for " + x + " damage");
		if (healthCurrent <= 0) {
			System.out.println(target + " was defeated by " + user + "!");
		}
	}

}