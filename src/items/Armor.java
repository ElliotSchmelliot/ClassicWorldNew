package items;

public abstract class Armor extends Item {
	public int durability;
	public int defense;
	
	public int use() {
		durability -= 5;
		return defense;
	}
	
}
