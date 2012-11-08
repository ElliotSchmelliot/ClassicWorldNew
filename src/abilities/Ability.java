package abilities;

public class Ability {
	public String name;
	public int power;
	public boolean stun;
	public double dmgMod;
	
	public Ability(String name, int power) {
		this.name = name;
		this.power = power;
		stun = false;
		dmgMod = 1.0;
	}
	
	//Full contructor
	public Ability(String name, int power, boolean stun, double dmgMod) {
		this.name = name;
		this.power = power;
		this.stun = stun;
		this.dmgMod = dmgMod;
	}
	
	public String toString() {
		return name;
	}
	
}
