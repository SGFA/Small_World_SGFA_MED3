package client_package;

public class Ability extends Template implements java.io.Serializable{

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
