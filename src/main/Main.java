package main;

import java.io.File;
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
		gameLoop(champ);
	}

	public static void printIntro() {
		System.out.println("Welcome to Classic World New.");
		System.out.println("Redevoloped by James Murphree and Elliot Keder 11/1/12.");
		System.out.println("Good luck!");
		System.out.println();
	}

	public static void gameLoop(Character champ) throws IllegalAccessException, FileNotFoundException {
		boolean gameContinuing = true;
		while (gameContinuing) {
			System.out.print("Where would you like to go: (S)hop, (I)nn, or (Q)uest?");
			String choice = "";
			while (!choice.equals("S") && !choice.equals("I") && !choice.equals("Q")) {
				choice = champ.input.next().toUpperCase().trim();
			}
			System.out.println();
			if (choice.equals("S")) {
				
			} else if (choice.equals("I")) {
				String sleep = "";
				System.out.print("Would you like to sleep for 25 coins? (Y) or (N):");
				while (!sleep.equals("Y") && !sleep.equals("N")) {
					sleep = champ.input.next().toUpperCase().trim();
				}
				if (sleep.equals("Y")) {
					if (champ.coin >= 25) {
						System.out.println("You sleep and recover all of your health.");
						champ.coin -= 25;
						champ.healthCurrent = champ.healthMax;
					} else {
						System.out.println("You do not have enough money to spend the night.");
					}
				}
				System.out.println();
			} else { // ("Q")
				System.out.println("Currently available quest(s):");
				String path = "C:\\Users\\Elliot\\Eclipse\\ClassicWorldNew";
				File folder = new File(path);
				File[] allFiles = folder.listFiles();
				List<File> dungeons = new ArrayList<File>();
				for (int i = 0; i < allFiles.length; i++) {
					if (allFiles[i].isFile()) {
						if (allFiles[i].getName().startsWith("dungeon") && allFiles[i].getName().endsWith(".txt")) {
							dungeons.add(allFiles[i]);
						}
					}
				}
				for (int i = 0; i < dungeons.size(); i++) {
					System.out.println(i + 1 + ") " + dungeons.get(i).getName().substring(7, dungeons.get(i).getName().length() - 4));
				}
				System.out.print("Select a quest: ");
				int questChoice = 0;
				while (questChoice < 1 || questChoice > dungeons.size()) {
					questChoice = champ.input.nextInt();
				}
				System.out.println("You have selected " + dungeons.get(questChoice - 1).getName().substring(7, dungeons.get(questChoice - 1).getName().length() - 4));
				System.out.println();
				MonsterSpawner dungeonTest = new MonsterSpawner(dungeons.get(questChoice - 1).getName());
				fight(champ, dungeonTest);
				if (champ.healthCurrent <= 0) {
					gameContinuing = false;
					System.out.println("Game over!");
					System.out.println("Better luck next time!");
				}
			}
		}
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
			
			//Loot and EXP
			if (fight && spawner.dungeon.size() == 0) {
				System.out.println("You gain " + spawner.totalExp + " experience!");
				champ.expGain(spawner.totalExp);
				fight = false;
				if (spawner.loot.size() > 0) {
					int lootNum = r.nextInt(spawner.loot.size()) + 1;
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
				} else {
					System.out.println();
					System.out.println("No loot was found...");
				}
			}
			
			//Enemy retaliation
			if (fight && (choice.equals("F") || choice.equals("R"))) {
				for (Monster attacker : spawner.dungeon) {
					if (champ.healthCurrent > 0) {
						Ability attack = attacker.getAbility();
						int power = attack.power;
						if(power < 0) {
							double armor = (double)champ.defend() / 100;
							champ.damage(attacker.name, attack.name, champ.name, -power - (int)((double)-power * armor));
							if (champ.healthCurrent <= 0 ) {
								fight = false;
							}
						} else {
							attacker.heal(attacker.name, attack.name, power);
						}
					}
				}
			}
			System.out.println();
		}
	}
}