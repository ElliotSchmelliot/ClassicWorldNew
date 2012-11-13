package main;

import java.util.ArrayList;
import java.util.List;

import mobs.Character;
import abilities.*;
import mobs.*;
import items.*;

public class Main {
	public static void main(String[] args) {
		printIntro();
		Character champ = new Character();
		List<Ability> a = new ArrayList<Ability>();
		a.add(new Ability("Fire Breath", 10));
		List<Item> i = new ArrayList<Item>();
		i.add(new Sword("DragonSlayer", 5, 5, new Ability("Slash", 5), new Ability("Fire Slash", 5)));
		fightTest(champ, new Dragon("The Black Dragon", 100, champ.level, a, i));
	}
	
	public static void printIntro() {
		System.out.println("Welcome to Classic World New.");
		System.out.println("Redevoloped by James Murphree and Elliot Keder 11/1/12.");
		System.out.println("Good luck!");
	}
	
	public static void fightTest(Character champ, Monster enemy) {
		while (enemy.healthCurrent > 0 && champ.healthCurrent > 0) {
			System.out.println("Your health: " + champ.healthCurrent);
			System.out.println("Enemy health: " + enemy.healthCurrent);
			System.out.print("/nWhat would you like to do (R)un, (F)ight, or (H)eal? " );
			String choice = champ.input.next().toUpperCase();
			if (choice.equals("F"))
		}
	}
}