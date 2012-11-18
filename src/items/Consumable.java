package items;

public class Consumable extends Item {
	public int power;
	//public int heal;
	//public int damage;
	
	public Consumable(String name, int quality, int power) {
		this.name = name;
		this.quality = quality;
		this.power = power;
	}
	
	/*public Consumable(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	public Consumable(String name, int value, int heal, int damage) {
		this.name = name;
		this.value = value;
		this.heal = heal;
		this.damage = damage;
	}*/
}
