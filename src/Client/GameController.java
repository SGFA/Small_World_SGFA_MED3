package Client;

import java.util.ArrayList;

import Map.MapHandler;

public class GameController {

	static Stack stack = new Stack();
	static ArrayList<Player> players = new ArrayList<Player>();
	static Race race;
	static Ability ability;

	public static void createStack() {
		stack.initDb();
		stack.initialize();
		stack.shuffle();
	}

	public static void addPlayer(int amount) {
		
		for (int i = 1; i <= amount; i++) {
			players.add(new Player(i));	
		}		
	}
	
	public static void initlialize() {
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

	public static void debugPlayerAmount() {
		System.out.println("Amount of players: " + players.size());
	}
}
