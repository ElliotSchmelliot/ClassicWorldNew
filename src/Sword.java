
public class Sword extends Weapon {

	public Sword(String name, int attack, int quality, int level, int rarity) {
		this.name = name;
		this.attack = attack;
		durability = 1000;
		this.quality = quality;
		this.level = level;
	}
	
	public int damage() {
		return attack * quality * 1000 / durability;
	}

	public int use() {
		durability -= 5;
		return damage();
	}

}
