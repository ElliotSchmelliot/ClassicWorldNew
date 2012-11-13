package mobs;
import items.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import abilities.*;


public class Character extends Mob {
	public int strength;
	public int intelligence;
	// int agility;
	public List<Ability> melee;
	public List<Ability> spell;
	public List<Ability> masterMelee;
	public List<Ability> masterSpell;
	// List<Ability> masterStealth;
	// Ability[] equippedAbilities;
	public Scanner input;
	public EquipmentSet equipment;
	public AbilitySet equippedAbilities;
	public List<Item> inventory;

	public Character() {
		input = new Scanner(System.in);
		System.out.println("What's your characters name?");
		name = input.next();
		strength = 1;
		intelligence = 1;
		// agility = 1;
		level = 1;
		healthMax = 100;
		healthCurrent = healthMax;
		spell = new ArrayList<Ability>();
		melee = new ArrayList<Ability>();
		equipment = new EquipmentSet();
		equippedAbilities = new AbilitySet(equipment);
		inventory = new ArrayList<Item>();
	}
	
	public void getInventory() {
		int j = 1;
		for (Item i : inventory) {
			System.out.println(j + ") " + i);
		}
	}
	
	public void addToInventory(Item add) {
		inventory.add(add);
		if (inventory.size() > 10) {
			System.out.println("Too many items in inventory.");
			System.out.println("Pick one to drop.");
			getInventory();
			System.out.println("Select a number: ");
			inventory.remove(input.nextInt() - 1);
		}
	}
	
	public void swapAbility() {
		equippedAbilities.abilitySwap(melee, spell, input);
	}
	
	public void equipItem() {
		System.out.println("Which item would you like to equip?");
		getInventory();
		System.out.println("Select a number: ");
		equipment.equip(inventory.get(input.nextInt() - 1));
	}

}
