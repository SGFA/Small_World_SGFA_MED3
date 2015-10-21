package example;

/**
 * The {@code Race} class specifies each race in the database.
 * 
 * @param name
 *            the name of the race
 * @param unitAmount
 *            the amount of units of given to the player
 * @param effect
 *            the effect of the race
 * @param effectReq
 *            the requirement for the effect to take place
 */

public class Race implements Template {

	String name;
	int unitAmount;

	String effect; // Temporarily a 'String'
	String effectReq; // Temporarily a 'String'

	Race(String name, int unitAmount, String effect, String effectReq) {
		this.name = name;
		this.unitAmount = unitAmount;
		this.effect = effect;
		this.effectReq = effectReq;
	}

	/**
	 * Returns the properties of the race card.
	 * 
	 * @return name, unitAmount, effect, effectReq
	 * @see Race
	 */

	public String debugStats() {
		return "name: " + name + "\n" 
				+ "unitAmount: " + unitAmount + "\n" 
				+ "effect: " + effect + "\n" 
				+ "effectReq: " + effectReq;
	}

}
