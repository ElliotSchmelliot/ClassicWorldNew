package mobs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import abilities.*;
import items.*;

public class MonsterSpawner {
	public List<Monster> dungeon;
	
	public MonsterSpawner(String fileName) throws FileNotFoundException {
		Monster temp = null;
		List<Ability> attacks = null;
		List<Item> inventory = null;
		Scanner fileScan = new Scanner(new File(fileName));
		while (fileScan.hasNextLine()) {
			String line = fileScan.nextLine();
			Scanner lineScan = new Scanner(line);
			String[] creatureInfo = line.split(":");
			if (creatureInfo[0] == "Dragon") {
				temp = new Dragon(creatureInfo[1], Integer.parseInt(creatureInfo[2]));
			} else if (creatureInfo[0] == "Critter") {
				temp = new Critter(creatureInfo[1], Integer.parseInt(creatureInfo[2]));	
			}
			
			String[] attackInfo = creatureInfo[3].split(",");
			for (int i = 0; i < attackInfo.length; i+=2) {
				attacks.add(new Ability(attackInfo[i], Integer.parseInt(attackInfo[i + 1])));
			}
			
			String[] lootInfo = creatureInfo[4].split(",");
			for (int i = 0; i < attackInfo.length; i+=2) {
				inventory.add(new Item)
			}

			temp.attacks = attacks;
			temp.inventory = inventory;
			dungeon.add(temp);
		}
	}
}
