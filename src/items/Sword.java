package items;
import abilities.Ability;


public class Sword extends Weapon {

	public Sword(String name, int attack, int quality, Ability primary, Ability secondary) {
		this.name = name;
		this.attack = attack + quality;
		this.quality = quality;
		this.primary = primary;
		this.secondary = secondary;
		durability = 1000;
	}
	
	public int damage() {
		return attack;
	}

	public int use() {
		durability -= 5;
		return damage();
	}

}
