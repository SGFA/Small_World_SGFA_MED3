package Client;

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

public class Race extends Template {

	Race(String name, int unitAmount, String type, String effect, int amount, String effectReq, String condition) {
		this.name = name;
		this.unitAmount = unitAmount;
		this.type = type;
		this.effect = effect;
		this.amount = amount;
		this.effectReq = effectReq;
		this.condition = condition; 
	}
	
//	Race(String name, int unitAmount, String type, String effect, String effectReq) {
//		this.name = name;
//		this.unitAmount = unitAmount;
//		this.type = type;
//		this.effect = effect;
//		this.effectReq = effectReq;
//	}
//	
//	Race(String name, int unitAmount, Bonus bonus, String string, int i, String string2) {
//		this.name = name;
//		this.unitAmount = unitAmount;
//	}
	
	

	/**
	 * Returns the properties of the race card as a String .
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
