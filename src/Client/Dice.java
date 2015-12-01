package Client;

import java.util.Random;
/**
 * Class representing a dice. Can roll it with the public static int roll() method.
 */
public class Dice {

	private static Random random = new Random();
	
	/**
	 * Method which rolls a 6-sized dice consisting of 0,0,0,1,2,3 and returns the result
	 */
	public static int roll() {
		
		int value = random.nextInt(6);
		
		if (value <3) return 0;
		else return value-2;
		
	}
}
