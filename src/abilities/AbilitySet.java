package abilities;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Scanner;
import items.*;

public class AbilitySet {
	public Ability main1;
	public Ability main2;
	public Ability offHand;
	public Ability melee;
	public Ability spell1;
	public Ability spell2;

	public AbilitySet(EquipmentSet equipped) {
		main1 = equipped.mainHand.primary;
		main2 = equipped.mainHand.secondary;
		if (!equipped.offHand.equals(null)) {
			offHand = equipped.offHand.power;
		} else if (!equipped.shield.equals(null)) {
			offHand = equipped.shield.power;
		} else {
			offHand = null;
		}
		melee = null;
		spell1 = null;
		spell2 = null;
	}

	public String toString() {
		String write = "Equipped Abilities\n";
		for (Field f : AbilitySet.class.getFields()) {
			try {
				write += f.getName() + ": " + f.get(this) + "\n";
			} catch (IllegalArgumentException e) {
			} catch (IllegalAccessException e) {
			}
		}
		return write;
	}

	public void abilitySwap(List<Ability> meleeList, List<Ability> spellList, Scanner input) {
		String choice = "";
		while (!choice.toLowerCase().equals("melee") && !choice.toLowerCase().equals("spell")) {
			System.out.print("Which type of ability would you like to switch, melee or spell? ");
			choice = input.next();
		}
		if (choice.equals("melee")) {
			System.out.println("Pick an ability to swap with.");
			int i = 1;
			for (Ability a : meleeList) {
				System.out.println(i + ") " + a);
				i++;
			}
			System.out.print("Enter a number: ");
			int pick = input.nextInt();
			melee = meleeList.get(pick - 1);
		} else {
			int num = 0;
			while (num != 1 && num != 2) {
				System.out.println("Pick an ability to swap (1 for spell1, 2 for spell2");
				num = input.nextInt();
			}
			System.out.println("Pick an ability to swap with.");
			int i = 1;
			for (Ability a : spellList) {
				System.out.println(i + ") " + a);
				i++;
			}
			System.out.print("Enter a number: ");
			int pick = input.nextInt();
			if (num == 1) {
				spell1 = spellList.get(pick - 1);
			} else {
				spell2 = spellList.get(pick - 1);
			}
		}
	}

}
