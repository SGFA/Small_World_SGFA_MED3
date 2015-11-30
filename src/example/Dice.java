package example;

import java.util.Random;

public class Dice {

	private static Random random = new Random();
	
	public static int roll() {
		
		
		int value = random.nextInt(6);
		
		if (value <3) return 0;
		else return value-2;
		
	}
}
