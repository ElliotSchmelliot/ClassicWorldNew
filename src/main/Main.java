package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mobs.Character;
import abilities.*;
import mobs.*;
import items.*;

public class Main extends General {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
		printIntro();
		Character champ = new Character();
		List<Ability> a = new ArrayList<Ability>();
		a.add(new Ability("Fire Breath", -10));
		a.add(new Ability("Claw Slash", -8));
		a.add(new Ability("Consume Nearby Peasants", 12));
		List<Item> i = new ArrayList<Item>();
		i.add(new Sword("DragonSlayer", 5, 5, new Ability("Slash", -5), new Ability("Fire Slash", -5)));
		fight(champ, new Dragon("The Black Dragon", 100, champ.level, a, i));
	}

	public static void printIntro() {
		System.out.println("Welcome to Classic World New.");
		System.out.println("Redevoloped by James Murphree and Elliot Keder 11/1/12.");
		System.out.println("Good luck!");
		System.out.println();
	}

	public static void fight(Character champ, Monster enemy) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
		Random r = new Random();
		boolean fight = true;
		boolean roundStun = false;
		while (fight) {
			System.out.println(champ.name + "'s health: " + champ.healthCurrent);
			System.out.println(enemy.name + "'s health: " + enemy.healthCurrent);
			System.out.print("\nWould you like to (R)un, (F)ight, or (V)iew Info? " );
			String choice = "";
			while (!choice.equals("F") && !choice.equals("R") && !choice.equals("V")) {
				choice = champ.input.next().toUpperCase().trim();
			} 
			System.out.println();
			if (choice.equals("F")) {
				int attackNum = 0;
				while (attackNum < 1 || attackNum > 6) {
					System.out.print(champ.equippedAbilities);
					System.out.print("Choose an attack number: ");
					attackNum = champ.input.nextInt();
				}
				System.out.println();
				Ability attack = champ.equippedAbilities.getAbility(attackNum);
				int power = attack.power;
				roundStun = attack.stun;
				if(power < 0) {
					fight = enemy.damage(champ.name, attack.name, enemy.name, -power);
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
						champ.equipment.getEquipment();
						System.out.println();
					} else if (choice2.equals("A")) {
						//View abilities
					} else {// ("X")
						loopView = false;
					}
				}
			} 
			
			//Enemy retaliation
			if (enemy.healthCurrent > 0 && fight && (choice.equals("F") || choice.equals("R"))) {
				if (roundStun) {
					System.out.println(enemy.name + " is stunned!");
					roundStun = false;
				} else {
					Ability attack = enemy.getAbility();
					int power = attack.power;
					if(power < 0) {
						fight = champ.damage(enemy.name, attack.name, champ.name, roundUp((double)-power / (100 / champ.defend())));
					} else {
						enemy.heal(enemy.name, attack.name, power);
					}
				}
				System.out.println();
			}

		}
		//Loot the bodies!!
	}
}