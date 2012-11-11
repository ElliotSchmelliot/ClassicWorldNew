package items;
import abilities.Ability;


public class Sword extends Weapon {

	public Sword(String name, int attack, int quality, int level, int rarity, Ability primary, Ability secondary) {
		this.name = name;
		this.attack = attack;
		durability = 1000;
		this.quality = quality;
		this.level = level;
		this.primary = primary;
		this.secondary = secondary;
	}
	
	public int damage() {
		return attack * quality * 1000 / durability;
	}

	public int use() {
		durability -= 5;
		return damage();
	}

}
