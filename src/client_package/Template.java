package client_package;

/**
 * Abstract class which serves as a template for classes containing information
 * pertaining to the effects involved in a player's race / ability pair.
 * @see Race
 * @see Ability
 */
public abstract class Template {

	String name;
	int unitAmount;
	int amount;
	
	String type;  // type of the effect
	String effect; // Temporarily a 'String'
	String effectReq; // Temporarily a 'String'
	String condition;

}
