package example;

import java.util.ArrayList;

class GameController {

	static Stack stack = new Stack();
	static ArrayList<Player> player = new ArrayList<Player>();
	static MapTwoPlayer currentBoard;

	static Race race;
	static Ability ability;

	public static void createStack() {
		stack.initDb();
		stack.initialize();
		stack.shuffle();
	}

	public static void addPlayer() {
		player.add(new Player());
	}

	public static void setPair(int currentPlayer, int pos) {
		player.get(currentPlayer).pair[0] = new Pair(stack.raceStack.get(pos), stack.abilityStack.get(pos));
		stack.raceStack.remove(pos);
		stack.abilityStack.remove(pos);
	}

	public static void decline(int currentPlayer) {
		if (player.get(currentPlayer).pair[1] == null) {
			player.get(currentPlayer).pair[1] = player.get(currentPlayer).pair[0];
			player.get(currentPlayer).pair[0] = null;
		} else {
			stack.addPair(player.get(currentPlayer).pair[1].race, player.get(currentPlayer).pair[1].ability);
			player.get(currentPlayer).pair[1] = player.get(currentPlayer).pair[0];
			player.get(currentPlayer).pair[0] = null;
		}
	}

	public static void debugPlayerAmount() {
		System.out.println("Amount of players: " + player.size());
	}
}
