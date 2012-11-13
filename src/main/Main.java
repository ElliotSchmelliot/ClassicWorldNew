package main;

import java.util.ArrayList;
import java.util.List;

import mobs.Character;
import abilities.*;
import mobs.*;
import items.*;

public class Main {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		printIntro();
		Character champ = new Character();
		List<Ability> a = new ArrayList<Ability>();
		a.add(new Ability("Fire Breath", 10));
		List<Item> i = new ArrayList<Item>();
		i.add(new Sword("DragonSlayer", 5, 5, new Ability("Slash", 5), new Ability("Fire Slash", 5)));
		fight(champ, new Dragon("The Black Dragon", 100, champ.level, a, i));
	}

	public static void printIntro() {
		System.out.println("Welcome to Classic World New.");
		System.out.println("Redevoloped by James Murphree and Elliot Keder 11/1/12.");
		System.out.println("Good luck!");
	}

	public static void fight(Character champ, Monster enemy) throws IllegalArgumentException, IllegalAccessException {
		boolean fight = true;
		while (fight) {
			System.out.println("Your health: " + champ.healthCurrent);
			System.out.println("Enemy health: " + enemy.healthCurrent);
			System.out.print("\nWhat would you like to do (R)un, (F)ight, or (H)eal? " );
			String choice = "";
			while (!choice.equals("F") && !choice.equals("R") && !choice.equals("H")) {
				choice = champ.input.next().toUpperCase();
			} 
			System.out.println();
			if (choice.equals("F")) {
				int attackNum = 0;
				while (attackNum < 1 || attackNum > 6) {
					System.out.println("Choose an attack:");
					System.out.print(champ.equippedAbilities);
					System.out.print("Pick an number: ");
					attackNum = champ.input.nextInt();
				}
				System.out.println();
				Ability attack = champ.equippedAbilities.getAbility(attackNum);
				int damage = attack.damage;
				enemy.healthCurrent -= damage;
				System.out.println("You used " + attack.name + " on " + enemy.name + " for " + damage + " damage");
				if (enemy.healthCurrent <= 0) {
					System.out.println("You defeated " + enemy.name);
					fight = false;
				}
			} else if (choice.equals("R")) {
				fight = false;
				System.out.println("You ran away...");
			} else {
				champ.heal();
				System.out.println("You regained health to " + champ.healthCurrent);
			} if (enemy.healthCurrent > 0 && fight) {
				Ability attack = enemy.getAbility();
				int damage = attack.damage;
				champ.healthCurrent -= damage;
				System.out.println(enemy.name + " used " + attack + " on you for " + damage + " damage");
				if (champ.healthCurrent <= 0) {
					System.out.println("You were defeated by " + enemy.name);
					fight = false;
				}
			}
			System.out.println();
		}
	}
}