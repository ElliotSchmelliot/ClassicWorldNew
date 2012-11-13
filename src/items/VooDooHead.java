package items;

import abilities.*;

public class VooDooHead extends OffHand {

	public VooDooHead(String name, int abilityPower, int quality, Ability power) {
		this.abilityPower = abilityPower;
		this.power = power;
		durability = 1000;
		this.name = name;
		this.quality = quality;
	}
	
	public int use() {
		durability -= 5;
		return abilityPower;
	}

	public void abilityPower() {

	}

}
