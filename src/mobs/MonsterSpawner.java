package mobs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import abilities.*;
import items.*;

public class MonsterSpawner {
	public List<Monster> dungeon = new ArrayList<Monster>();
	
	public MonsterSpawner(String fileName) throws FileNotFoundException {
		Monster temp = null;
		List<Ability> attacksTemp = new ArrayList<Ability>();
		List<Item> inventoryTemp = new ArrayList<Item>();
		Scanner fileScan = new Scanner(new File(fileName));
		while (fileScan.hasNextLine()) {
			String line = fileScan.nextLine();
			Scanner lineScan = new Scanner(line);
			String[] creatureInfo = line.split(":");
			if (creatureInfo[0].trim().equals("Dragon")) {
				temp = new Dragon(creatureInfo[1].trim(), Integer.parseInt(creatureInfo[2].trim()));
			} else if (creatureInfo[0].trim().equals("Critter")) {
				temp = new Critter(creatureInfo[1].trim(), Integer.parseInt(creatureInfo[2].trim()));	
			}
			
			String[] attackInfo = creatureInfo[3].split(",");
			for (int i = 0; i < attackInfo.length; i+=2) {
				attacksTemp.add(new Ability(attackInfo[i].trim(), Integer.parseInt(attackInfo[i + 1].trim())));
			}
			
			String[] lootInfo = creatureInfo[4].split(",");
			for (int i = 0; i < attackInfo.length; i++) {
				if (lootInfo[i].trim().equals("Consumable")) {
					inventoryTemp.add(new Consumable(lootInfo[i + 1].trim(), Integer.parseInt(lootInfo[i + 2].trim()), Integer.parseInt(lootInfo[i + 3].trim())));
					i+=3;
				}
			}

			for (Ability aaa : attacksTemp) {
				temp.attacks.add(aaa);
			}
			attacksTemp.clear();
			for (Item iii : inventoryTemp) {
				temp.inventory.add(iii);
			}
			inventoryTemp.clear();
			dungeon.add(temp);
			temp = null;
		}
	}
}
