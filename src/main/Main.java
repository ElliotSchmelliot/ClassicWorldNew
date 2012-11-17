package main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mobs.Character;
import abilities.*;
import mobs.*;
import items.*;

public class Main extends General {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, FileNotFoundException {
		printIntro();
		Character champ = new Character();
//test commit / push
		//git commit -m "commit message"
		MonsterSpawner dungeonTest = new MonsterSpawner("dungeonQuick.txt");
		fight(champ, dungeonTest);
	}

	public static void printIntro() {
		System.out.println("Welcome to Classic World New.");
		System.out.println("Redevoloped by James Murphree and Elliot Keder 11/1/12.");
		System.out.println("Good luck!");
		System.out.println();
	}

	public static void fight(Character champ, MonsterSpawner spawner) throws IllegalArgumentException, IllegalAccessException {
		Random r = new Random();
		boolean fight = true;
		while (fight) {
			System.out.println(champ.name + "'s health: " + champ.healthCurrent);
			spawner.printMonsters();
			System.out.print("\nWould you like to (R)un, (F)ight, or (V)iew Info? " );
			String choice = "";
			while (!choice.equals("F") && !choice.equals("R") && !choice.equals("V")) {
				choice = champ.input.next().toUpperCase().trim();
			} 
			System.out.println();
			if (choice.equals("F")) {
				Monster target = null;
				int choiceNum = 0;
				spawner.printMonsterIndexes();
				System.out.print("Select a monster to attack: ");
				while (choiceNum < 1 || choiceNum > spawner.dungeon.size()) {
					choiceNum = champ.input.nextInt();
				}
				target = spawner.getMonster(choiceNum - 1);
				System.out.println();
				int attackNum = 0;
				while (attackNum < 1 || attackNum > 6) {
					System.out.print(champ.equippedAbilities);
					System.out.print("Choose an attack number: ");
					attackNum = champ.input.nextInt();
				}
				System.out.println();
				Ability attack = champ.equippedAbilities.getAbility(attackNum);
				int power = attack.power;
				if(power < 0) {
					target.damage(champ.name, attack.name, target.name, -power);
					if (target.healthCurrent <= 0) {
						spawner.dungeon.remove(spawner.dungeon.indexOf(target));
					}
				} else { //power > 0
					champ.heal(champ.name, attack.name, power);
				}
			} else if (choice.equals("R")) {
				int temp = r.nextInt(2);
				if(temp == 0) {
					fight = false;
					System.out.println("You ran away...Like little bitch!");
				} else {
					System.out.println("You fail to run away...");
				}
			} else { // ("I")
				boolean loopView = true;
				while (loopView) {
					String choice2 = "";
					System.out.print("Would you like to view (I)nventory, (E)quipment, or (A)bilities? (X) to exit.");
					while (!choice2.equals("I") && !choice2.equals("E") && !choice2.equals("A") && !choice2.equals("X")) {
						choice2 = champ.input.next().toUpperCase().trim();
					}
					System.out.println();
					if (choice2.equals("I")) {
						champ.getInventory();
						System.out.println();
					} else if (choice2.equals("E")) { 
						System.out.println(champ.equipment);
						System.out.println();
					} else if (choice2.equals("A")) {
						//View abilities
					} else {// ("X")
						loopView = false;
					}
				}
			} 
			
			//Loot
			if (fight && spawner.dungeon.size() == 0) {
				fight = false;
				int lootNum = r.nextInt(spawner.loot.size() + 1) + 1;
				while (lootNum > 0) {
					System.out.println();
					spawner.printLoot();
					System.out.print("Select an item to loot (" + lootNum + " loots left):");
					int lootChoice = 0;
					while (lootChoice < 1 || lootChoice > spawner.loot.size()) {
						lootChoice = champ.input.nextInt();
					}
					System.out.println("You loot " + spawner.loot.get(lootChoice - 1));
					champ.inventory.add(spawner.loot.get(lootChoice - 1));
					spawner.loot.remove(lootChoice - 1);
					lootNum--;
					System.out.println(champ.inventory);
				}
			}
			
			//Enemy retaliation
			if (fight && (choice.equals("F") || choice.equals("R"))) {
				for (Monster attacker : spawner.dungeon) {
					Ability attack = attacker.getAbility();
					int power = attack.power;
					if(power < 0) {
						double armor = (double)champ.defend() / 100;
						champ.damage(attacker.name, attack.name, champ.name, -power - (int)((double)-power * armor)); //roundUp((double)-power / (100 / champ.defend())));
						if (champ.healthCurrent <= 0 ) {
							fight = false;
						}
					} else {
						attacker.heal(attacker.name, attack.name, power);
					}
				}
			}
			System.out.println();
		}
	}
}