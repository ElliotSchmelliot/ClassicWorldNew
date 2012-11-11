package items;

import java.lang.reflect.Field;

public class EquipmentSet {
	Weapon mainHand;
	OffHand offHand;
	Helmet helmet;
	Chest chest;
	Legs legs;
	Feet feet;
	Shield shield;

	public EquipmentSet() {
		mainHand = null;
		offHand = null;
		helmet = null;
		chest = null;
		legs = null;
		feet = null;
		shield = null;
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

	public void equip(Item equipping) {
		try {
			for (Field f : EquipmentSet.class.getFields()) {
				if (f.getClass().equals(equipping.getClass())) {
					// put f in inventory f.get(this)
					f.set(this, equipping);
				}
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Item cannot be equipped");
		} catch (IllegalAccessException e) {
			// won't happen
		} if (equipping.getClass().getName().equals("Shield")) { 
			// put offHand in inventory
			offHand = null;
			System.out.println("Offhand item removed and shield equipped.");
		} if (equipping.getClass().getName().equals("OffHand")) {
			// put shield in inventory
			shield = null;
			System.out.println("Shield removed and offhand item equipped.");
		}
	}

	public void getEquippment() throws IllegalArgumentException, IllegalAccessException {
		int i = 1;
		for (Field f : EquipmentSet.class.getFields()) {
			System.out.println(i + ") " + f.getName() + f.get(this));
		}
	}

}
