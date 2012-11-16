package items;

public class Consumable extends Item {
	int power;
	
	public Consumable(String name, int quality, int power) {
		this.name = name;
		this.quality = quality;
		this.power = power;
	}
}
