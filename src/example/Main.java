package example;

public class Main {

	GameController gameController = new GameController();

	public void initGame() {

		gameController.initDb();
		gameController.createStack();
		gameController.debugStack();

		// Debug database
		System.out.println(gameController.abilityDb.get(0).debugStats());

	}

	public static void main(String[] args) {

		Main m = new Main();
		m.initGame();

	}
}
