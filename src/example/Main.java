package example;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import javagame.CheckPlayer;


public class Main extends StateBasedGame{
	public static final String gamename = "Small World";
	public static final int menu = 0; 
	public static final int server = 1; 
	public static final int game = 2;
		
	public Main(String gamename) {
		
		super(gamename);
		this.addState(new Menu(menu));
		this.addState(new Game(game));
		this.addState(new CheckPlayer(server));
	}

	public void initGame() {	
		GameController.createStack();
		GameController.addPlayer(0);
		GameController.setPair(0, 2);
		GameController.setPair(0, 2);
		//GameController.decline(0);
		//GameController.decline(0);
		System.out.println(GameController.stack.toString());
		System.out.println(GameController.players.get(0).score);
		System.out.println(GameController.players.get(0).pair[0].race.type);
		
		GameController.players.get(0).effect(); // Activate effect on 'player 1'
		System.out.println(GameController.players.get(0).score);
		
	
	}
	
	public void initStatesList (GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(game).init(gc, this);
		this.enterState(menu);
	
	}

	
	public static void main(String[] args) {
		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer (new Main (gamename));
			appgc.setDisplayMode(800, 505, false);
			appgc.start();
			
			
		} catch (SlickException e) {
			e.printStackTrace();
		} 
	}
}
