package mobs;

import java.util.List;
import java.util.Random;

import abilities.Ability;


public abstract class Monster extends Mob {
	public List<Ability> attacks;
	public int expValue;
	
	public Ability getAbility() {
		Random pick = new Random();
		return attacks.get(pick.nextInt(attacks.size()));
	}
	
}
