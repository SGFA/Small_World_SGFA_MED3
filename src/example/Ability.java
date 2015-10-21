package example;

/**
 * The {@code Ability} class specifies each ability in the database.
 * 
 * @param name
 *            the name of the ability
 * @param unitAmount
 *            the amount of units of given to the player
 * @param effect
 *            the effect of the ability
 * @param effectReq
 *            the requirement for the effect to take place
 */

public class Ability implements Template {

	String name;
	int unitAmount;

	String effect; // Temporarily a 'String'
	String effectReq; // Temporarily a 'String'

	Ability(String name, int unitAmount, String effect, String effectReq) {
		this.name = name;
		this.unitAmount = unitAmount;
		this.effect = effect;
		this.effectReq = effectReq;
	}

	/**
	 * Returns the properties of the ability card.
	 * 
	 * @return name, unitAmount, effect, effectReq
	 * @see Ability
	 */

	public String debugStats() {
		return "name: " + name + "\n" 
				+ "unitAmount: " + unitAmount + "\n" 
				+ "effect: " + effect + "\n" 
				+ "effectReq: " + effectReq;
	}

}
