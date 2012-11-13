package abilities;

public class Ability {
	public String name;
	public int damage;
	
	public Ability(String name, int damage) {
		this.name = name;
		this.damage = damage;
	}
	
	public String toString() {
		return name;
	}
	
}
