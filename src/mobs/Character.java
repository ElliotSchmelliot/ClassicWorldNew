package mobs;

import items.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import abilities.*;


public class Character extends Mob {
	public int expCurrent;
	public int expMax;
	public int strength;
	public int intelligence;
	public int coin;
	public List<Ability> melee;
	public List<Ability> spell;
	public List<Ability> masterMelee;
	public List<Ability> masterSpell;
	public Scanner input;
	public Scanner lineInput;
	public EquipmentSet equipment;
	public AbilitySet equippedAbilities;
	public int inventorySize = 10;

	public Character() {
		input = new Scanner(System.in);
		lineInput = new Scanner(System.in);
		System.out.print("Enter a character name: ");
		name = lineInput.nextLine().trim();
		System.out.println();
		level = 1;
		expCurrent = 0;
		expMax = 100;
		strength = 1;
		intelligence = 1;
		level = 1;
		healthMax = 100;
		coin = 50;
		healthCurrent = healthMax;
		spell = new ArrayList<Ability>();
		melee = new ArrayList<Ability>();
		equipment = new EquipmentSet();
		equippedAbilities = new AbilitySet(equipment);
		inventory = new ArrayList<Item>();
		inventory.add(new Consumable("Butterscotch Oatmeal Cookie", 1, 50)); //Heals
		inventory.add(new Consumable("Spam", 1, 10)); //Heals
		inventory.add(new Consumable("Firebomb", 1, 35)); //Deals damage
		inventory.add(new Consumable("Chrome Garbage Can", 1, 100)); //Monetary value only
	}
	
	public void addToInventory(Item add) {
		inventory.add(add);
		if (inventory.size() > inventorySize) {
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
	
	public void expGain(int exp) {
		expCurrent += exp;
		while (expCurrent > expMax) { //In case multiple levels are gained from one fight
			level();
			expCurrent = expCurrent - expMax;
			expMax *= 2;
		}
		System.out.println("Current exp: " + expCurrent + "/" + expMax);
	}
	public void level() {
		level++;
		System.out.println("You are now level " + level + "!");
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
	
	public int defend() {
		int total = 0;
		total += equipment.helmet.use();
		total += equipment.chest.use();
		total += equipment.legs.use();
		total += equipment.feet.use();
		if (equipment.shieldEq) {
			total += equipment.shield.use();
		}
		return total;
	}

}
