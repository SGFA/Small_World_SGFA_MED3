package client_package;

/**
 * 
 * The {@code Pair} class acquires both {@code Race} and {@code Ability}
 * objects and represents a combination of the two. Contains both the
 * active and inactive race.
 *
 */
public class Pair {
	
	Race race;
	Ability ability;
	
	// Array containing both the active (index[0]) and inactive (index[1])
	// race of a player
	Pair[] pair = new Pair[2];

	private int units;
	boolean active; // if active the abilities apply and the player can control
					// the race


/**
 * 
 * @param race
 * 			the race of the pair
 * @param ability
 * 			the ability of the pair
 */
	public Pair(Race race, Ability ability) {
		this.race = race;
		this.ability = ability;
		setUnits(race.unitAmount + ability.unitAmount);
	}

	/**
	 * Sets the race and ability of a player's active race.
	 * @param race
	 * 			the race of the active race
	 * @param ability
	 * 			the ability of the active race
	 */
	public void set(Race race, Ability ability) {
		pair[0] = new Pair(race, ability);
	}

	/**
	 * Returns the amount of units in a pair.
	 * @return amount of units in pair
	 */
	int getUnits() {
		return units;
	}

	/**
	 * Sets the amount of units in a pair.
	 * @param units amount of units in pair
	 */
	void setUnits(int units) {
		this.units = units;
	}


}