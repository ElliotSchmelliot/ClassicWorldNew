import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Character extends Mob {
	int strength;
	int intelligence;
	// int agility;
	List<Ability> melee;
	List<Ability> spells;
	// Ability[] stealth;
	Ability[] equippedAbilities;
	Weapon mainHand;
	OffHand offHand;
	Armor[] equipment;
	Scanner input;


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
		melee = new ArrayList();
		spells = new ArrayList();
		equippedAbilities = new Ability[6];
		// Head, Chest, Pants, Shoes, Shield
		equipment = new Armor[5];
		inventory = new Item[10];
		mainHand = null;
		offHand = null;
	}

	public void getEquipment() {
		System.out.println("1) Equipped Equipment");
		System.out.println("2) Main hand: " + mainHand);
		System.out.println("3) Off hand: " + offHand);
		System.out.println("4) Head: " + equipment[0]);
		System.out.println("5) Chest: " + equipment[1]);
		System.out.println("6) Pants: " + equipment[2]);
		System.out.println("7) Shoes: " + equipment[3]);
		System.out.println("8) Shield: " + equipment[4]);
		System.out.println();
	}

	public void getActiveAbilities() {
		System.out.println("Equipped Abilities");
		System.out.println("Weapon/Off Hand Abilities");
		System.out.println("Ability 1: Main hand ability 1: " + equippedAbilities[0]);
		System.out.println("Ability 2: Main hand ability 2: " + equippedAbilities[1]);
		System.out.println("Ability 3: Off hand ability: " + equippedAbilities[2]);
		System.out.println("Melee Ability");
		System.out.println("Ability 4: Melee Ability: " + equippedAbilities[3]);
		System.out.println("Spell Abilities");
		System.out.println("Ability 5: Spell 1: " + equippedAbilities[4]);
		System.out.println("Ability 6: Spell 2: " + equippedAbilities[5]);
		System.out.println();
	}

	public int getAbilities() {
		System.out.println("Abilities");
		int i = 1;
		System.out.println("Melee Abilities");
		for (Ability a : melee) {
			System.out.println(i + ") " + a);
			i++;
		}
		int spell1 = i;
		System.out.println("Spell Abilities");
		for (Ability a : spells) {
			System.out.println(i + ") " + a);
			i++;
		}
		System.out.println();
		return spell1;
	}

	public void getInventory() {
		System.out.println("Inventory");
		int i = 1;
		for (Item a : inventory) {
			System.out.println(i + ") " + a);
			i++;
		}
		System.out.println();
	}

	public void changeOutAbilities() {
		boolean done = false;
		boolean choice = false;
		int spell1 = 0;
		int old = 0;
		int replace = 0;

		while (!done) {
			while (!choice) {
				System.out.println("Which character ability would you like to switch? (choose #) ");
				getActiveAbilities();
				old = input.nextInt();
				if (old == 4 || old == 5 || old == 6) {
					choice = !choice;
				}
			}
			choice = false;
			while (!choice) {
				System.out.println("Which character ability would you like to replace " + equippedAbilities[old - 1] + " with? (choose #) ");
				spell1 = getAbilities();
				replace = input.nextInt();
				if (replace <= 0 || replace > melee.size() + spells.size()) {
					System.out.println("Invalid input.");
				} else if (old == 4 && replace < spell1) {
					choice = !alreadyEquipped(melee.get(replace - 1));
				} else if (old == 5 || old == 6 && replace > spell1) {
					choice = !alreadyEquipped(spells.get(replace - spell1));
				} if (!choice) {
					System.out.println("Ability already equipped.");
				}
			}
			if (old == 4) {
				equippedAbilities[old - 1] = melee.get(replace - 1);
			} else {
				equippedAbilities[old - 1] = spells.get(replace - spell1);
			}
			System.out.println("Do you want to switch another ability? (1 = yes/2 = no) ");
			if (input.nextInt() == 1) {
				choice = !choice;
			}
		}
	}

	public boolean alreadyEquipped(Ability replace) {
		for (Ability a : equippedAbilities) {
			if (a.equals(replace)) {
				return true;
			}
		}
		return false;
	}

}
