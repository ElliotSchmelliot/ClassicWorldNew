import java.util.ArrayList;


public abstract class Weapon extends Item {

	int attack;
	int durability;
	ArrayList<Ability> abilities;
	
	public abstract int damage();
	
	public abstract int use();
	
	public int cost() {
		return quality * level * 1000 / durability;
	}
	
}
