package client_package;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import map_package.MapHandler;
import menu_package.Toast;
import server_package.Client;
import server_package.Server;

public class GameController {

	/**
	 * The stack of race/ability pairs available for purchase.
	 */
	static Stack stack = new Stack();

	/**
	 * An ArrayList of all the players in the game.
	 */
	public static ArrayList<Player> players = new ArrayList<Player>();

	/**
	 * A serialization handler for general client-server communication via
	 * serialization of variables from this class.
	 */
	public static SerializationHandler serializationHandler = new SerializationHandler();

	/**
	 * Represents a race associated with the client.
	 */
	static Race race;

	/**
	 * Represents an ability associated with the client.
	 */
	static Ability ability;

	/**
	 * Represents the player whose turn it is.
	 */
	public static AtomicInteger CURRENT_ACTIVE_PLAYER = new AtomicInteger(1);

	/**
	 * Represents the player whose turn it is.
	 */
	public static int PLAYER_ID;

	/**
	 * Defines whether the game has begun or not, as determined by the host.
	 */
	public static AtomicBoolean launched = new AtomicBoolean(false);

	/**
	 * Static reference to the client and server classes
	 */

	public static Client client = new Client();
	public static Server server = new Server();

	/**
	 * Creates a stack by running the database methods associated with the Stack
	 * class.
	 * 
	 * @see Stack
	 */
	public static void createStack() {
		stack.initDb();
		stack.initialize();
		stack.shuffle();
	}

	/**
	 * Adds an amount of players to the game.
	 * 
	 * @param amount
	 *            the amount of players you want to add
	 */
	public static void addPlayers(int amount) {

		for (int i = 1; i <= amount; i++) {
			players.add(new Player(i));
		}
	}

	/**
	 * Removes a player from the game. Makes sure to reassign the player IDs in
	 * the new array order.
	 * 
	 * @param id
	 *            the assigned number of the player you want to remove
	 */
	public static void removePlayer(int id) {

		players.remove(PLAYER_ID - 1);

		// for (int i = 0; i < players.size(); i++) {
		// if (players.get(i).getId()!=i+1) {
		// players.get(i).setId(i+1);
		// }
		// }
	}

	public static void endTurn() {

		Toast.set(10, 550, "Your turn has ended.", 3000);

		if (CURRENT_ACTIVE_PLAYER.get() + 1 <= players.size())
			CURRENT_ACTIVE_PLAYER.incrementAndGet();
		else
			CURRENT_ACTIVE_PLAYER.set(1);
	}

	/**
	 * Sets the active pair of a specified player to a pair from the stack and
	 * removes it from the stack.
	 * 
	 * @param playerPos
	 *            the Position of the player in the player array (0 = player 1,
	 *            1 = player 2, etc.)
	 * @param stackPos
	 *            the position of the pair in the stack.
	 */
	public static void setPair(int playerPos, int stackPos) {

		// System.out.println(GameController.players.get(CURRENT_ACTIVE_PLAYER -
		// 1).pair[0].race);
		// System.out.println("Pair is put in playerPos: " + playerPos);

		if (PLAYER_ID == CURRENT_ACTIVE_PLAYER.get() && players.get(CURRENT_ACTIVE_PLAYER.get() - 1).pair[0] == null)
			System.out.println("set pair");
		Toast.set(10, 550, "Pair assigned from stack.", 3000);

		players.get(playerPos).pair[0] = new Pair(stack.raceStack.get(stackPos), stack.abilityStack.get(stackPos));
		stack.raceStack.remove(stackPos);
		stack.abilityStack.remove(stackPos);
	}

	/**
	 * Puts a specified player into decline. This involves setting his active
	 * race to inactive, and adding any currently inactive race back to the
	 * stack.
	 * 
	 * @param playerPos
	 *            the position of the player in the GameController.players
	 *            ArrayList.
	 */
	public static void decline(int playerPos) {
		if (players.get(playerPos).pair[1] == null) {
			players.get(playerPos).pair[1] = players.get(playerPos).pair[0];
			players.get(playerPos).pair[0] = null;
		} else {
			stack.addPair(players.get(playerPos).pair[1].race, players.get(playerPos).pair[1].ability);
			players.get(playerPos).pair[1] = players.get(playerPos).pair[0];
			players.get(playerPos).pair[0] = null;
		}
	}

	

	public static void initialize() {
		MapHandler.initialize(GameController.players.size());	
		GameController.createStack();
	}

}
