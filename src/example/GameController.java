package example;

import java.util.ArrayList;

public class GameController {

	Stack stack = new Stack();
	ArrayList<Player> player = new ArrayList<Player>();

	Race race;
	Ability ability;

	public void createStack() {
		stack.initDb();
		stack.initialize();
		stack.shuffle();
	}

	public void addPlayer() {
		player.add(new Player());
	}

	public void setPair(int currentPlayer, int pos) {
		player.get(currentPlayer).pair[0] = new Pair(stack.raceStack.get(pos), stack.abilityStack.get(pos));
		stack.raceStack.remove(pos);
		stack.abilityStack.remove(pos);
	}

	public void decline(int currentPlayer) {
		if (player.get(currentPlayer).pair[1] == null) {
			player.get(currentPlayer).pair[1] = player.get(currentPlayer).pair[0];
			player.get(currentPlayer).pair[0] = null;
		} else {
			stack.addPair(player.get(currentPlayer).pair[1].race, player.get(currentPlayer).pair[1].ability);
			player.get(currentPlayer).pair[1] = player.get(currentPlayer).pair[0];
			player.get(currentPlayer).pair[0] = null;
		}
	}

	public void debugPlayerAmount() {
		System.out.println("Amount of players: " + player.size());
	}
}
