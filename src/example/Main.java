package example;


public class Main {
	
	public void initGame() {

		
		GameController.createStack();
		GameController.addPlayer();
		GameController.setPair(0, 2);
		GameController.decline(0);
		GameController.setPair(0, 2);
		GameController.decline(0);
		GameController.decline(0);


		System.out.println(GameController.stack.toString());

		
//		System.out.println(gameController.player.get(0).score);
//		System.out.println(gameController.player.get(0).pair[0].race.type);
		
//		gameController.player.get(0).effect(); // Activate effect on 'player 1'
//		System.out.println(gameController.player.get(0).score);
		
	
	}

	public static void main(String[] args) {

		Main m = new Main();
		m.initGame();
		
	}
}
