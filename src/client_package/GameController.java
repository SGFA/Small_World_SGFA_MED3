package client_package;

import java.util.ArrayList;

import map_package.MapHandler;

public class GameController {

	static Stack stack = new Stack();
	public static ArrayList<Player> players = new ArrayList<Player>();
	public static SerializationHandler serializationHandler = new SerializationHandler();
	static Race race;
	static Ability ability;
	public static int CURRENT_PLAYER_ID; 


	public static void createStack() {
		stack.initDb();
		stack.initialize();
		stack.shuffle();
	}

	/**
	 * Adds an amount of players to the game.
	 * @param amount the amount of players you want to add
	 */
	public static void addPlayers(int amount) {
		
		for (int i = 1; i <= amount; i++) {
			players.add(new Player(i));	
		}		
	}
	
	/**
	 * Removes a player from the game. Makes sure to reassign the player IDs in the new array order.
	 * @param id the assigned number of the player you want to remove
	 */
	public static void removePlayer(int id) {

		players.remove(0);
		
//		for (Player player: players) {
//			if (player.getId()==id) players.remove(player);
//		}
//		
//		for (int i = 0; i < players.size(); i++) {
//			if (players.get(i).getId()!=i+1) {
//				players.get(i).setId(i+1);
//			}
//		}
	}
	
	public static void initialize() {
		System.out.println("Initializing game");
		MapHandler.initialize(players.size());
	}

	public static void setPair(int currentPlayer, int pos) {
		players.get(currentPlayer).pair[0] = new Pair(stack.raceStack.get(pos), stack.abilityStack.get(pos));
		stack.raceStack.remove(pos);
		stack.abilityStack.remove(pos);
	}

	public static void decline(int currentPlayer) {
		if (players.get(currentPlayer).pair[1] == null) {
			players.get(currentPlayer).pair[1] = players.get(currentPlayer).pair[0];
			players.get(currentPlayer).pair[0] = null;
		} else {
			stack.addPair(players.get(currentPlayer).pair[1].race, players.get(currentPlayer).pair[1].ability);
			players.get(currentPlayer).pair[1] = players.get(currentPlayer).pair[0];
			players.get(currentPlayer).pair[0] = null;
		}
	}
}
