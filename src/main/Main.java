package main;
import mobs.Character;
import abilities.*;
import mobs.*;
import items.*;

public class Main {
	public static void main(String[] args) {
		printIntro();
		Character champ = new Character();
		fightTest(champ);
	}
	
	public static void printIntro() {
		System.out.println("Welcome to Classic World New.");
		System.out.println("Redevoloped by James Murphree and Elliot Keder 11/1/12.");
		System.out.println("Good luck!");
	}
	
	public static void fightTest(Character champ) {
		Ability primary = new Ability("Slash", 10);
		Ability secondary = new Ability("Bash", 5);
		Sword masterSword = new Sword("Master Sword", 10, 3, 1, primary, secondary);
		champ.equipment.mainHand = masterSword;
		
	}
}