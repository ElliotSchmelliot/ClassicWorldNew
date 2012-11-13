package items;

import abilities.*;

public class Shield extends Armor {
	public Ability power;

	public Shield(String name, int defense, int quality, Ability power) {
		this.name = name;
		durability = 1000;
		this.quality = quality;
		this.defense = defense;
		this.power = power;
	}

}
