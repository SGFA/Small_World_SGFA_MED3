package example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Player {

	int score;
	Pair[] pair = new Pair[2];

	// public void decline(){
	// pair[0].setActive(false);
	// pair[1].reurnToStack;
	// pair[1] = pair[0];
	// pair[0] = null;
	// }

	// if (pair.active == true) {
	// attack
	// } else
	// do nothing

	// attack()

	/*
	 * This method looks for the type of effect in the database and instantiates the corresponding class as an object. 
	 * The effect of that particular object is then invoked with specified parameters also found in the database.  
	 */
	public void effect() {

		Class<?> clazz;
		// Integer parameter

		// No parameters
		Class<?> noparams[] = {};

		// Parameters to be used by the method
		Class[] param = new Class[2];
		param[0] = Player.class;
		param[1] = int.class;

		try {

			// Get class by name (String) in package 
			clazz = Class.forName("example." + pair[0].race.type);		

			Object object = clazz.newInstance();

			// Look for method in the database corresponding to the race. 'param' denotes the different overloads as seen above 
			Method method = clazz.getDeclaredMethod(pair[0].race.effect, param);

			// Invoke method from the database with parameters
			method.invoke(object, this, pair[0].race.amount);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void redeploy() {

		// Run though all tiles on the board
		for (Field field : GameController.currentBoard.allFields) {

			// If this player owns the field
			if (field.getFieldOwner()==1) {

				// Set player's units to current amount of units plus (field's units-1)
				pair[0].setUnits(pair[0].getUnits()+(field.getAmountOfUnits()-1));

				// Set amount of units on this field to 1
				field.setAmountOfUnits(1);

			}
		}
	}
}