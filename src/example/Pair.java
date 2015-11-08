package example;

/**
 * 
 * The {@code Pair} class acquires both {@code Race} and {@code Ability}
 * objects.
 *
 */
public class Pair {
	
	Race race;
	Ability ability;
	Effect effect; 
	
	Pair[] pair = new Pair[2];

	int units;
	boolean active; // if active the abilities apply and the player can control
					// the race



	public Pair(Race race, Ability ability) {
		this.race = race;
		this.ability = ability;
		units = race.unitAmount + ability.unitAmount;
	}

	public void set(Race race, Ability ability) {
		pair[0] = new Pair(race, ability);
	}

	public boolean setActive(boolean a) {
		if (a == true)
			return active = true;
		else
			return active = false;
	}


}