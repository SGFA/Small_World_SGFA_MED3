package example;

public class Race implements Template {
	
	String name;
	int unitAmount;
	
	String effect; //Temporarily a 'String'
	String effectReq; //Temporarily a 'String'

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
	 */
	
	public String debugStats() {
		return "name: " + name + "\n" 
				+ "unitAmount: " + unitAmount + "\n" 
				+ "effect: " + effect + "\n" 
				+ "effectReq: " + effectReq;
	}

}
