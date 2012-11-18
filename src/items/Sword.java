package items;
import abilities.Ability;


public class Sword extends Weapon {

	public Sword(String name, int quality, int value, Ability primary, Ability secondary) {
		this.name = name;
		this.attack = 3 * quality;
		this.quality = quality;
		this.value = value;
		this.primary = primary;
		this.secondary = secondary;
		durability = 1000;
	}

	public int use() {
		durability -= 5;
		return attack;
	}

}
