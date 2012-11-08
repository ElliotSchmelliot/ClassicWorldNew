
public abstract class Mob {
	int level;
	int healthCurrent;
	int healthMax;
	//Item[] inventory;
	String name;
	
	public int getLevel() {
		return level;
	}
	
	public int getHealthMax() {
		return healthMax;
	}
	
	public int getHealthCurrent() {
		return healthCurrent;
	}
	
	public String getName() {
		return name;
	}
	
}
