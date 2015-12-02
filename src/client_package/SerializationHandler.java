package client_package;


import java.io.*;
import java.util.ArrayList;

import server_package.Server;

/**
 * Serializable class which handles serialization of relevant variables from the GameController class
 * For the purpose of data transfer via the server.
 */
public class SerializationHandler implements java.io.Serializable {
	Stack stack = GameController.stack;
	ArrayList<Player> players = GameController.players;
	Race race = GameController.race;
	Ability ability = GameController.ability;

	ArrayList<Object> input = new ArrayList<Object>();

	/**
	 * Method which serializes the input ArrayList containing relevant variables from GameController.
	 */
	public void serialize() {

		// Add variables to input array
		input.add(stack);
		input.add(players);
		input.add(race);
		input.add(ability);


		try
		{
			// Create file and object output streams
			FileOutputStream fileOutputStream = new FileOutputStream("data.ser");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

			// Write this SerializationHandler to the file output stream via the object output stream
			objectOutputStream.writeObject(this);

			// Close output streams
			objectOutputStream.close();
			fileOutputStream.close();

			System.out.println("Successfully serialized input to 'data.ser'.");

		} catch (IOException i)
		{
			i.printStackTrace();
		}

	}

	/**
	 * Method which deserializes object and stores its input in relevant 
	 * class-level variables. 
	 */
	public void deserialize(){  
		try
		{
			// Create file and object input streams
			FileInputStream fileInputStream = new FileInputStream("data.ser");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

			// Since we the object we serialize is the current SerializationHandler, we need
			// this handler to read the input
			SerializationHandler inputHandler;

			// Reads input by typecasting from Object to SerializationHandler
			inputHandler = (SerializationHandler) objectInputStream.readObject();

			// Takes the input ArrayList from the deserialized object and stores it in 
			// this input ArrayList
			input = inputHandler.input;

			// Close streams
			objectInputStream.close();
			fileInputStream.close();
		}
		catch(IOException i)
		{
			i.printStackTrace();
			return;
		}
		catch(ClassNotFoundException c)
		{
			System.out.println("Class associated with variable 'input' cannot be found.");
			c.printStackTrace();
			return;
		}

		// Typecasts the variables in input to class-level variables
		stack=(Stack)input.get(0);
		players=(ArrayList<Player>) input.get(1);
		race=(Race) input.get(2);
		ability=(Ability) input.get(3);

		System.out.println("Successfully deserialized input to variables.");

	}

}