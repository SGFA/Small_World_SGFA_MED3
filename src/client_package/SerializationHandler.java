package client_package;


import java.io.*;
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
	         
	         objectOutputStream.writeObject(this);
	         
	         objectOutputStream.close();
	         fileOutputStream.close();
	         
	         System.out.println("Successfully serialized input to 'data.ser'.");
	         
	      } catch (IOException i)
	      {
	          i.printStackTrace();
	      }
		
	}
	
	/**
	 * Method which deserializes the input and closes the input streams
	 */
	public void deserialize(){  
		try
    {
        FileInputStream fileInputStream = new FileInputStream("data.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        SerializationHandler inputHandler;
        inputHandler = (SerializationHandler) objectInputStream.readObject();
        input = inputHandler.input;
        
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
        System.out.println("class associated with variable 'input' cannot be found");
        c.printStackTrace();
        return;
     }

		stack=(Stack)input.get(0);
		players=(ArrayList<Player>) input.get(1);
		race=(Race) input.get(2);
		ability=(Ability) input.get(3);
		
		System.out.println("Successfully deserialized input to variables.");
		
   }
		
	}