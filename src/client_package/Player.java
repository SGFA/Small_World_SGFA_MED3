package client_package;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import client_package.Dice;
import map_package.Field;
import map_package.Map;
import menu_package.Toast;

/**
 * Serializable class representing a player in the game.
 * 
 */
public class Player implements java.io.Serializable {

	private int score;
	Pair[] pair = new Pair[2];
	boolean hasFields = false;
	int attackingUnits = 0;
	private int id;

	/**
	 * 
	 * @param id
	 *            the ID of the player; 1-5.
	 */
	public Player(int id) {
		this.id = id;
	}

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

	/**
	 * This method looks for the type of effect in the database and instantiates
	 * the corresponding class as an object. The effect of that particular
	 * object is then invoked with specified parameters also found in the
	 * database.
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

			// Look for method in the database corresponding to the race.
			// 'param' denotes the different overloads as seen above
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

	/**
	 * Checks if this object has enough units to conquer clickedField. If true,
	 * clickedField gets assigned the attackingUnits of units, and this object
	 * is assigned as clickedField's owner. It also subtracts the attackingUnits
	 * units from this object.
	 * 
	 * @param clickedField
	 *            - the target Field object.
	 */
	public void takeField(Field clickedField) {

		if (pair[0] != null) {

			System.out.println("Field taken");

			// If you have necessary amount of units you may take the field
			if (pair[0].getUnits() >= clickedField.getDefenceValue() + 1) {
				attackingUnits = clickedField.getDefenceValue() + 1;
				clickedField.setFieldOwner(1);
				clickedField.setAmountOfUnits(attackingUnits);
				pair[0].setUnits(pair[0].getUnits() - attackingUnits);
			}

			/*
			 * If you don't have the necessary amount of units you may use the
			 * die to add to your amount of units
			 */
			else {
				int reinforcements = Dice.roll();
				if (pair[0].getUnits() + reinforcements >= clickedField.getDefenceValue() + 1) {
					attackingUnits = clickedField.getDefenceValue() + 1;
					clickedField.setFieldOwner(1);
					clickedField.setAmountOfUnits(attackingUnits);
					pair[0].setUnits(pair[0].getUnits() - attackingUnits);
				} else {
					System.out.println("You dont have enough units to take this field");
				}

			}
		} else {
			Toast.set(10, 550,"Unable to conquer. Choose a race and ability from the stack.", 3000);
		}
	}

	/**
	 * Checks if this object owns any Field object matching its ID, if not the
	 * method can target any Field objects which has the boolean
	 * isBorderPosition set to true. If this object does own at least one Field
	 * object, the method checks which Field objects are adjacent to the Field
	 * objects owned by this object and allows targeting of those Field objects.
	 * 
	 * @param clickedField
	 *            the targeted Field object.
	 */
	public void conquer(Field clickedField) {

		// Check is the current player has owns any fields
		boolean hasFields = false;
		for (Field otherField : Map.fields) {
			if (otherField.getFieldOwner() == id) {
				hasFields = true;
			}
		}

		// Checks what fields are adjacent to the fields the current player
		// owns
		boolean ownAnyAdjacencies = false;
		for (Field otherField : clickedField.adjacencies) {
			if (otherField.getFieldOwner() == id) {
				ownAnyAdjacencies = true;
			}
		}

		/*
		 * If the current player doesn't own any fields he must choose a
		 * conquerable border position
		 */
		if (hasFields == false && clickedField.isBorderPosition() == true && clickedField.isConquerable() == true) {
			takeField(clickedField);
		}

		// if the current player does own fields he can choose any field
		// adjacent to his or her field(s)
		else if (clickedField.isConquerable() == true && ownAnyAdjacencies == true && hasFields == true) {
			takeField(clickedField);
		}
	}

	/**
	 * Returns all units on the map except one per field to the player, setting
	 * up the redeployment phase.
	 */
	public void redeploy() {

		// Run though all tiles on the board
		for (Field field : Map.fields) {

			// If this player owns the field
			if (field.getFieldOwner() == id) {

				// Set player's units to current amount of units plus (field's
				// units-1)
				pair[0].setUnits(pair[0].getUnits() + (field.getAmountOfUnits() - 1));

				// Set amount of units on this field to 1
				field.setAmountOfUnits(1);

			}
		}
		

	}

	//Sets the score by counting the amount of fields the current player owns
	public void scorePoint(){
		
		for(Field ownedFields: Map.fields){
			if(ownedFields.getFieldOwner()==id)
			{
				setScore(getScore() + 1);
			}
		}
		System.out.println("Score: "+getScore());
		
	}
	
	/**
	 * Gets the ID of the player.
	 * 
	 * @return the player's ID.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set the ID of the player.
	 * 
	 * @param id
	 *            an integer representing the player's ID.
	 */
	public void setId(int id) {
		this.id = id;
	}

	private int getScore() {
		return score;
	}

	private void setScore(int score) {
		this.score = score;
	}
}