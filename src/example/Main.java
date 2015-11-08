package example;


public class Main {

	GameController gameController = new GameController(); 
	
	public void initGame() {

		gameController.createStack();
		gameController.addPlayer();
		gameController.setPair(0, 2);
		gameController.decline(0);
		gameController.setPair(0, 2);
		
		System.out.println(gameController.player.get(0).score);
		System.out.println(gameController.player.get(0).pair[0].race.type);
		
		gameController.player.get(0).effect(); // Activate effect on 'player 1'
		System.out.println(gameController.player.get(0).score);
		
	
	}

	public static void main(String[] args) {

		Main m = new Main();
		m.initGame();
		
	}
}
