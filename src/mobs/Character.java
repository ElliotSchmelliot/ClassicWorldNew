package mobs;

import items.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import abilities.*;


public class Character extends Mob {
	public int level;
	public int exp;
	public int strength;
	public int intelligence;
	public int healthMax;
	public int healthCurrent;
	public int coin;
	// int agility;
	public List<Ability> melee;
	public List<Ability> spell;
	public List<Ability> masterMelee;
	public List<Ability> masterSpell;
	// List<Ability> masterStealth;
	public Scanner input;
	public EquipmentSet equipment;
	public AbilitySet equippedAbilities;
	public List<Item> inventory;

	public Character() {
		input = new Scanner(System.in);
		System.out.println("What's your characters name?");
		name = input.next();
		level = 1;
		exp = 0;
		strength = 1;
		intelligence = 1;
		// agility = 1;
		level = 1;
		healthMax = 100;
		coin = 50;
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
		addToInventory(equipment.equip(inventory.get(input.nextInt() - 1), equippedAbilities));
	}
	
	public void level() {
		exp = 0;
		level++;
		
		String choice = "";
		while (!choice.equals("intelligence") && !choice.equals("strength")) {
			System.out.println("Increase intelligence or strength: ");
			choice = input.next().toLowerCase();
		} 
		System.out.println("Pick a new ability.");
		if (choice.equals("intelligence")) {
			printList(masterSpell);
			spell.add(masterSpell.get(input.nextInt() - 1));
			intelligence++;
			healthMax += 10;
			healthCurrent = healthMax;
		} else {
			printList(masterMelee);
			melee.add(masterMelee.get(input.nextInt() - 1));
			strength++;
			healthMax += 20;
			healthCurrent = healthMax;
		}
		
	}
	
	public void printList(List<Ability> list) {
		int i = 1;
		for (Ability a : list) {
			System.out.println(i + ") " + a);
		}
	}

}
