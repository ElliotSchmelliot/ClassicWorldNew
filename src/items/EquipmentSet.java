package items;

import java.lang.reflect.Field;
import abilities.*;

public class EquipmentSet {
	public Weapon mainHand;
	public OffHand offHand;
	public Helmet helmet;
	public Chest chest;
	public Legs legs;
	public Feet feet;
	public Shield shield;

	public EquipmentSet() {
		mainHand = new Sword("Newbie Sword", 5, 0, new Ability("Slash", 5), new Ability("Stab", 5));
		offHand = null;
		helmet = new Helmet("Newbie Helment", 5, 0);
		chest = new Chest("Newbie Chest", 5, 0);
		legs = new Legs("Newbie Legs", 5, 0);
		feet = new Feet("Newbie Feet", 5, 0);
		shield = new Shield("Newbie Shield", 5, 0, 5, new Ability("Shield Smash", 5));
	}

	public EquipmentSet(Weapon mainHand, OffHand offHand, Helmet helmet, Chest chest, Legs legs, Feet feet, Shield shield) {
		this.mainHand = mainHand;
		this.offHand = offHand;
		this.helmet = helmet;
		this.chest = chest;
		this.legs = legs;
		this.feet = feet;
		this.shield = shield;
	}

	public Item equip(Item equipping, AbilitySet abilities) {
		Item replace = null;
		try {
			for (Field f : EquipmentSet.class.getFields()) {
				if (f.getClass().equals(equipping.getClass())) {
					replace = (Item) f.get(this);
					f.set(this, equipping);
				}
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Item cannot be equipped");
			return equipping;
		} catch (IllegalAccessException e) {
			// won't happen
		} if (equipping.getClass().getName().equals("Shield")) { 
			replace = offHand;
			offHand = null;
			abilities.offHand = shield.power;
			System.out.println("Offhand item removed and shield equipped.");
		} else if (equipping.getClass().getName().equals("OffHand")) {
			replace = shield;
			shield = null;
			abilities.offHand = offHand.power;
			System.out.println("Shield removed and offhand item equipped.");
		} else if (equipping.getClass().getName().equals("Weapon")) {
			abilities.main1 = mainHand.primary;
			abilities.main2 = mainHand.secondary;
		}
		return replace;
	}

public void getEquippment() throws IllegalArgumentException, IllegalAccessException {
	int i = 1;
	for (Field f : EquipmentSet.class.getFields()) {
		System.out.println(i + ") " + f.getName() + f.get(this));
	}
}

}
