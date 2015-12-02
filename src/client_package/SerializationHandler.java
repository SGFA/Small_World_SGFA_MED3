package client_package;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import server_package.Server;

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
		
		input.add(stack);
		input.add(players);
		input.add(race);
		input.add(ability);
		
		
		try
		 {
		     	
			FileOutputStream fileOutputStream = new FileOutputStream("data.ser");
	         ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
	         
	         objectOutputStream.writeObject(input);
	         
	         objectOutputStream.close();
	         fileOutputStream.close();
	         
	         System.out.println("Successfully serialized input to 'data.ser'.");
	         
	      } catch (IOException i)
	      {
	          i.printStackTrace();
	      }
		
	}
	
}
