package abilities;

public class Ability {
	String name;
	int damage;
	
	public Ability(String name, int damage) {
		this.name = name;
		this.damage = damage;
	}
	
	public String toString() {
		return name;
	}
	
}
