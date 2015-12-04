package client_package;

/**
 * Serializable class which extends Template and contains variables pertaining to an ability.
 * @see Template
 */
public class Ability extends Template implements java.io.Serializable {

	/**
	 * 
	 * @param name
	 * 			the name of the ability
	 * @param unitAmount
	 * 			the amount of units the ability adds
	 * @param effect
	 * 			the effect of the ability
	 * @param effectReq
	 * 			the requirement for the effect to take place
	 * @param condition
	 * 			the condition which the effectReq must fulfill
	 */
	Ability(String name, int unitAmount, String effect, String effectReq, String condition) {
		this.name = name;
		this.unitAmount = unitAmount;
		this.effect = effect;
		this.effectReq = effectReq;
		this.condition = condition; 
		
	
	}

	/**
	 * Returns the properties of the ability card.
	 * 
	 * @return name, unitAmount, effect, effectReq
	 */

	public String debugStats() {
		return "name: " + name + "\n" 
				+ "unitAmount: " + unitAmount + "\n" 
				+ "effect: " + effect + "\n" 
				+ "effectReq: " + effectReq
				+ "effect condition"+ condition;
	}

}
